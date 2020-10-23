activity_main.xml
Drag the Spinner from the pallete, now the activity_main.xml file will like this:

File: activity_main.xml
<?xml version="1.0" encoding="utf-8"?>  
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"  
    xmlns:app="http://schemas.android.com/apk/res-auto"  
    xmlns:tools="http://schemas.android.com/tools"  
    android:layout_width="match_parent"  
    android:layout_height="match_parent"  
    tools:context="example.javatpoint.com.spinner.MainActivity">  
  
    <Spinner  
        android:id="@+id/spinner"  
        android:layout_width="149dp"  
        android:layout_height="40dp"  
        android:layout_marginBottom="8dp"  
        android:layout_marginEnd="8dp"  
        android:layout_marginStart="8dp"  
        android:layout_marginTop="8dp"  
        app:layout_constraintBottom_toBottomOf="parent"  
        app:layout_constraintEnd_toEndOf="parent"  
        app:layout_constraintHorizontal_bias="0.502"  
        app:layout_constraintStart_toStartOf="parent"  
        app:layout_constraintTop_toTopOf="parent"  
        app:layout_constraintVertical_bias="0.498" />  
  
</android.support.constraint.ConstraintLayout>  
Activity class
Let's write the code to display item on the spinner and perform event handling.

File: MainActivity.java
package example.javatpoint.com.spinner;  
  
import android.support.v7.app.AppCompatActivity;  
import android.os.Bundle;  
import android.view.View;  
import android.widget.AdapterView;  
import android.widget.ArrayAdapter;  
import android.widget.Spinner;  
import android.widget.Toast;  
  
public class MainActivity extends AppCompatActivity implements  
        AdapterView.OnItemSelectedListener {  
    String[] country = { "India", "USA", "China", "Japan", "Other"};  
  
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_main);  
       //Getting the instance of Spinner and applying OnItemSelectedListener on it  
        Spinner spin = (Spinner) findViewById(R.id.spinner);  
        spin.setOnItemSelectedListener(this);  
  
        //Creating the ArrayAdapter instance having the country list  
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);  
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);  
        //Setting the ArrayAdapter data on the Spinner  
        spin.setAdapter(aa);  
  
    }  
  
    //Performing action onItemSelected and onNothing selected  
    @Override  
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {  
        Toast.makeText(getApplicationContext(),country[position] , Toast.LENGTH_LONG).show();  
    }  
    @Override  
    public void onNothingSelected(AdapterView<?> arg0) {  
        // TODO Auto-generated method stub  
    }  
}  