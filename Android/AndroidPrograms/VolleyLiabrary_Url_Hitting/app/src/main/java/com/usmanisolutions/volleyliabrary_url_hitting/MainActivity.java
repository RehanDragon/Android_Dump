package com.usmanisolutions.volleyliabrary_url_hitting;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<mainData/*model class*/> arrayList;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      listView=  (ListView) findViewById(R.id.listView);


try {
    //Assign Url
     url="https://picsum.photos/v2/list"   /*"https://picsum.photos/id/237/200/300"*/;

}catch (Exception e)
{
    e.printStackTrace();
}
        Log.d("yea_reha_error", url);
        //Initialize progress dialog
        final ProgressDialog dialog = new ProgressDialog(this);
        //Set message
        dialog.setMessage("Please Wait ...");
        //Set no cancelable
        dialog.setCancelable(true);

        //Show progress dialog
        dialog.show();

        //Initialize string request
        StringRequest stringRequest = new StringRequest(url,
                new Response.Listener<String>()

                {
                    @Override
                    public void onResponse(String response) {

                        //check condition when response is not null
                        if (response !=null)
                        {
                            //Dismiss progress dialog
                            dialog.dismiss();
                            try {
                                //initialite jason response Array

                                JSONArray jsonArray = new JSONArray(response);
                                parseArray(jsonArray);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                }
                ,

                new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }

        );

        //Initialize request queue
        RequestQueue queue = Volley.newRequestQueue(this);
        //Add request
        queue.add(stringRequest);
    }

    private void parseArray(JSONArray jsonArray) {
    // use for loop to get array of Json responses
        for (int i=0; i<jsonArray.length();i++)
        {
            try {
                JSONObject object = jsonArray.getJSONObject(i);
                //initialize main data  (model / helper ) class
                mainData data = new mainData();

                //Set name
                data.setName(object.getString("author"));
                //Set image
                data.setImage(object.getString("download_url"));
                // add data in array list
                arrayList.add(data);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            //Set adapter
            /*
            Adapter --> Do views ke functionality ko  work krwane ka lia Jorta ha
            Inflator --> farz krain k ap k  pas 3 xml layout files hain aur ap
            na xml2 aur xml 3 k layouts ko xml1 pa la k chipkana ha
            to ap inflator aismal krain ga ,, layout1 ka xml pa inflator k
            zaria layuot 2 aur layout 3 lga dain ga
            * */
            listView.setAdapter(new BaseAdapter() {
                @Override
                public int getCount() {
                    return arrayList.size();
                }

                @Override
                public Object getItem(int i) {
                    return null;
                }

                @Override
                public long getItemId(int i) {
                    return 0;
                }

                @Override
                public View getView(int position, View convertView, ViewGroup viewGroup) {
                    View view = getLayoutInflater().inflate(
                            R.layout.item_main,null
                    );
                    //Initalize main data(model class/helper class)
                    mainData data = arrayList.get(position);

                    //Initialize and assign variable
                    ImageView imageView = view.findViewById(R.id.image_view);
                    TextView textView = view.findViewById(R.id.text_view);

                    //Set image on imageView with the help of Glide , Glide it
                    Glide.with(getApplicationContext())
                            .load(data.getImage())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imageView)
                    ;

                    //Set name on TextView
                    textView.setText(data.getName());
                    return view;
                }
            });
        }
    }
}