package com.pramod.firebase;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
//import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.pramod.firebase.services.ClipboardMonitorService;
import com.pramod.firebase.storage.Device;
import com.pramod.firebase.storage.DeviceStore;
import com.pramod.firebase.util.KeyStore;
import com.shobhitpuri.custombuttons.GoogleSignInButton;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/**
 * @author Pramod Nanduri
 * <p>
 * Resources:
 * Firebase Login setup:
 * https://firebase.google.com/docs/android/setup
 * <p>
 * Facebook login:
 * https://firebase.google.com/docs/auth/android/facebook-login
 * <p>
 * Realtime DB Vs Cloudstore.
 * https://firebase.google.com/docs/database/rtdb-vs-firestore?authuser=0
 */
public class LoginActivity extends AppCompatActivity implements Animation.AnimationListener {

    EditText email;
    EditText password;
    Button loginBtn;
    Button signUpBtn;
    Animation uptodown, downtoup;
    TextView app_name;
    ImageView logo;
    Animation animMoveToTop, animMoveToBottom;
    LinearLayout loginPage;
    Animation animLoginPage;
    //Firebase Auth handler
    FirebaseAuth firebaseAuth;

    //For FB
    CallbackManager callbackManager = CallbackManager.Factory.create();
    private static final String TAG = "PmdLogTag";

    private GoogleApiClient mGoogleApiClient;

    private static final int RC_SIGN_IN = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        logo = (ImageView) findViewById(R.id.logo);
        logo.setVisibility(View.VISIBLE);
        animMoveToTop = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
        animMoveToTop.setAnimationListener(this);
        logo.startAnimation(animMoveToTop);

        app_name = (TextView) findViewById(R.id.app_name);
        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setStartOffset(1000);
        fadeIn.setDuration(1000);
        app_name.startAnimation(fadeIn);

        loginPage = (LinearLayout) findViewById(R.id.loginPage);
        Animation fadeIn_login = new AlphaAnimation(0, 1);
        fadeIn_login.setStartOffset(1000);
        fadeIn_login.setDuration(1000);
        loginPage.startAnimation(fadeIn);

        setupFireBase();
        if (firebaseAuth.getCurrentUser() != null) {
            navigateHomePage();
            this.finish();
            return;
        }

        //Ui Components
        setupElements();

        //Ignore this method call if FB login not needed!
        facebookLogin();

        googleLogin();


    }

    void setupFireBase() {
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseAuth.getInstance();
    }

    /**
     * Setting up all UI elements for this activity.
     */

    void setupElements() {
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        loginBtn = findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginEmailPassword(email.getText().toString(), password.getText().toString());
            }
        });
        signUpBtn = findViewById(R.id.signUpBtn);
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), SignUp.class);
                view.getContext().startActivity(intent);
            }
        });

    }


    /**
     * The handler for Facebook Login.
     * Before this all the steps in the below link needs to be followed .
     */

    void facebookLogin() {

        LoginButton loginButton = findViewById(R.id.facebookLoginButton);
        loginButton.setReadPermissions("email", "public_profile");
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d(TAG, "facebook:onSuccess:" + loginResult);
                handleFacebookAccessToken(loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {
                Log.d(TAG, "facebook:onCancel");
                // ...
            }

            @Override
            public void onError(FacebookException error) {
                Log.d(TAG, "facebook:onError", error);
                // ...
                error.printStackTrace();
            }
        });
    }


    /**
     * Once we get valid Auth token from Facebook login,
     * we authenticate firebase login with the fb credentials of the current user.
     */
    private void handleFacebookAccessToken(AccessToken token) {
        Log.d(TAG, "handleFacebookAccessToken:" + token);
        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        handleLoginResult(task);
                    }
                });
    }

    /**
     * Needed for FB Login.
     */
    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Pass the activity result back to the Facebook SDK
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }*/


    //Common method to handle signin result.
    void handleLoginResult(@NonNull Task<AuthResult> task) {
        if (task.isSuccessful()) {
            // Sign in success, update UI with the signed-in user's information
            Log.d(TAG, "signInWithEmail:success");
            FirebaseUser user = firebaseAuth.getCurrentUser();
            navigateHomePage();
            DeviceStore.getInstance().storeCurrentDevice(getContentResolver());
        } else {
            // If sign in fails, display a message to the user.
            Log.w(TAG, "signInWithEmail:failure", task.getException());
            Toast.makeText(getApplicationContext(), "Invalid Credentials!", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Basic email password authentication
     */

    void loginEmailPassword(String email, String password) {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                handleLoginResult(task);
            }
        });
    }

    /**
     * Method to navigate to Home Page after successful login.
     */
    void navigateHomePage() {
        Intent intent = new Intent(getApplicationContext(), MainHomeActivity.class);
        startActivity(intent);
    }


    /**
     * The handler for google Login.
     * Before this all the steps in the below link needs to be followed .
     */
    void googleLogin() {

        GoogleSignInButton googleLoginButton = (GoogleSignInButton) findViewById(R.id.googleLoginButton);
        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(getApplicationContext())
                .enableAutoManage(this, new GoogleApiClient.OnConnectionFailedListener() {
                    @Override
                    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                        Toast.makeText(getApplicationContext(), "Unable to sign up using google", Toast.LENGTH_SHORT).show();
                    }
                })
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        googleLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "onActivityResult:" + requestCode + ":" + resultCode + ":" + data);
        if (requestCode == RC_SIGN_IN) {
            //handle google sign in
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()) {
                GoogleSignInAccount account = result.getSignInAccount();
                firebaseAuthWithGoogle(account);
            }
        }
        else {
            //facebook login
            callbackManager.onActivityResult(requestCode, resultCode, data);
        }
    }


    private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }


    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(Constants.TAG, "signInWithCredential:success");
                            handleLoginResult(task);
                            Toast.makeText(getApplicationContext(), "Sign in using google successful", Toast.LENGTH_SHORT).show();
                        }
                        if (!task.isSuccessful()) {
                            Log.d(Constants.TAG, "signInWithCredential:success", task.getException());
                            Toast.makeText(getApplicationContext(), "Unable to sign up using google", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
