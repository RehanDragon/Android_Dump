package com.example.shared_preferences_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    TextView showdata;

    EditText enter_user, enter_pass ;

    Button  remember_me , show_details;



// guide taken from stack over flow

// this code is for exiting the application
    //if you tap two times on back button in android it will exit the application
    private static long back_pressed;
    @Override
    public void onBackPressed(){
        if (back_pressed + 2000 > System.currentTimeMillis()){
            super.onBackPressed();
        }
        else{
            Toast.makeText(getBaseContext(), "Press once again to exit",
                    Toast.LENGTH_SHORT).show();
            back_pressed = System.currentTimeMillis();
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showdata = (TextView) findViewById(R.id.data_display);

       enter_user =   (EditText) findViewById(R.id.user_enter);

        enter_pass = (EditText) findViewById(R.id.enter_pass);

        remember_me= (Button) findViewById(R.id.remember_me);

         show_details = (Button) findViewById(R.id.show_details);




      // this is for saving tha data
         remember_me.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                // this is the code  that will save  users input values

                 SharedPreferences data_storage_1 = getSharedPreferences( " NAME_OF_SHARED_PREFERENCES_CREATED" , MODE_PRIVATE );
                 SharedPreferences.Editor editor = data_storage_1.edit();
                 editor.putString("username",enter_user.getText().toString());
                 editor.putString("password",enter_pass.getText().toString());

                 editor.apply();

                 Toast.makeText(getApplicationContext(),"Saved",Toast.LENGTH_SHORT).show();
             }
         });


  // this is for showing the data
         show_details.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 // here data will be saved

                 SharedPreferences data_storage_1 = getSharedPreferences( " NAME_OF_SHARED_PREFERENCES_CREATED" , MODE_PRIVATE );

                 String name =  data_storage_1.getString("username",null);
                 String pass =  data_storage_1.getString("password",null);

                 //enter_user , enter_pass

                 enter_user.setText(name);

                 enter_pass.setText(pass);

                 showdata.setText("Username : "+name + ", Pass :"+pass+ " is set");
             }
         });



    }
}
