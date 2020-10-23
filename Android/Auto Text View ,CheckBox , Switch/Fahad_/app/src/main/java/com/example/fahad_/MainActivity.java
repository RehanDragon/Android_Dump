package com.example.fahad_;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.QuickContactBadge;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AutoCompleteTextView atxt;
    private CheckBox c1,c2,c3;
    private Button btn ;
    private TextView txt ;
    private Switch s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       atxt=  (AutoCompleteTextView) findViewById(R.id.search);
        c1=(CheckBox) findViewById(R.id.c1);
        c2=(CheckBox) findViewById(R.id.c2);
        c3=(CheckBox) findViewById(R.id.c3);
        btn= (Button) findViewById(R.id.btn);
        txt= (TextView) findViewById(R.id.change);
        s= (Switch) findViewById(R.id.swtich1);
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(s.isChecked()==true){
                    txt.setText("Switch On");

                }
                else{
                    txt.setText("Switch Off");

                }
            }
        });
       String [] item = {"Haider" ,
               "Wizarat" , "Rehan" ,"Raheel",
               "Rameez", "Raheem", "Emaan" ,
               "Adeel" , "Nameer"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this ,
                android.R.layout.simple_list_item_1 , item);
        atxt.setAdapter(adapter);


btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(c1.isChecked() == true){
            Toast.makeText(getApplicationContext(),
                    "You Like Apple" ,
                    Toast.LENGTH_SHORT).show();

        }
        if(c2.isChecked() == true){
            Toast.makeText(getApplicationContext(),
                    "You Like Banana" ,
                    Toast.LENGTH_SHORT).show();

        }


    }
});


    }
}
