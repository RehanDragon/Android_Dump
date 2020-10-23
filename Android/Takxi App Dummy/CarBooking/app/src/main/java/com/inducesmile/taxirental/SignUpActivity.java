package com.inducesmile.taxirental;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.inducesmile.taxirental.models.UserObject;
import com.inducesmile.taxirental.network.GsonRequest;
import com.inducesmile.taxirental.utils.Constants;
import com.inducesmile.taxirental.utils.CustomApplication;
import com.inducesmile.taxirental.utils.Helper;

import org.apache.commons.validator.routines.EmailValidator;

import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity {

    private static final String TAG = SignUpActivity.class.getSimpleName();

    private EditText names, email, password, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ActionBar actionBar = getSupportActionBar();
        if(null != actionBar){
            actionBar.hide();
        }

        names = (EditText)findViewById(R.id.name);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        phone = (EditText)findViewById(R.id.phone);

        TextView linkToLogin = (TextView)findViewById(R.id.link_to_login);
        linkToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(SignUpActivity.this, SignInActivity.class);
                startActivity(homeIntent);
            }
        });

        Button signUpButton = (Button)findViewById(R.id.btnRegister);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EmailValidator validator = EmailValidator.getInstance();

                String mNames = names.getText().toString();
                String mEmail = email.getText().toString();
                String mPassword = password.getText().toString();
                String mPhone = phone.getText().toString();

                if(TextUtils.isEmpty(mNames) || TextUtils.isEmpty(mEmail) || TextUtils.isEmpty(mPassword) || TextUtils.isEmpty(mPhone)){
                    Helper.displayErrorMessage(SignUpActivity.this, "All input fields must be filled");
                }
                else if(!validator.isValid(mEmail)){
                    Helper.displayErrorMessage(SignUpActivity.this, "You have entered an invalid email");
                }else{
                    if(Helper.isNetworkAvailable(SignUpActivity.this)){
                        registerUseToServer(mNames, mEmail, mPassword, mPhone);
                    }else{
                        Helper.displayErrorMessage(SignUpActivity.this, "No network available");
                    }
                }

                Intent homeIntent = new Intent(SignUpActivity.this, HomeActivity.class);
                startActivity(homeIntent);
            }
        });
    }

    private void registerUseToServer(String names, String email, String password, String phone){
        Map params = getParams(names, email, password, phone);
        GsonRequest<UserObject> serverRequest = new GsonRequest<UserObject>(
                Request.Method.POST,
                Constants.PATH_TO_SERVER_SIGN_IN,
                UserObject.class,
                params,
                createRequestSuccessListener(),
                createRequestErrorListener());

        ((CustomApplication)getApplication()).getNetworkCall().callToRemoteServer(serverRequest);
    }

    private Map getParams(String names, String email, String password, String phone){
        Map<String, String> params = new HashMap<String,String>();
        params.put(Constants.NAMES, names);
        params.put(Constants.EMAIL, email);
        params.put(Constants.PASSWORD, password);
        params.put(Constants.PHONE, phone);
        return params;
    }

    private Response.Listener<UserObject> createRequestSuccessListener() {
        return new Response.Listener<UserObject>() {
            @Override
            public void onResponse(UserObject response) {
                try {
                    if(response != null){
                        String userData = ((CustomApplication)getApplication()).getGsonObject().toJson(response);
                        ((CustomApplication)getApplication()).getShared().setUserData(userData);

                        Intent homeIntent = new Intent(SignUpActivity.this, HomeActivity.class);
                        startActivity(homeIntent);

                    }else{
                        Helper.displayErrorMessage(SignUpActivity.this, "Registeration failed. Try again");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private Response.ErrorListener createRequestErrorListener() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        };
    }
}
