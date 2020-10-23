package com.example.fahad_;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private AutoCompleteTextView atxt;
    private CheckBox checkBox1, checkBox2;
    private Button btn;
    private TextView txt;
    private Switch sw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
       atxt= (AutoCompleteTextView) findViewById(R.id.search12);
        checkBox1=(CheckBox) findViewById(R.id.check1);
        checkBox2=(CheckBox) findViewById(R.id.check2);
       btn =  (Button) findViewById(R.id.btn);

       sw= (Switch) findViewById(R.id.sw);
        txt=(TextView) findViewById(R.id.st);
       String [] names = {"Pakistan" , "Parsi" , "Germany" , "Italy"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1 , names);
        atxt.setAdapter(adapter);


        sw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sw.isChecked()==true){

                    txt.setText("Switch is On");

                }else{

                    txt.setText("Switch is Off");
                }
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox1.isChecked() == true){
                    Toast.makeText(getApplicationContext(),
                            "You like Apple" ,
                            Toast.LENGTH_SHORT).show();


                }
            }
        });
    }
}
