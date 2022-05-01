package com.enig.iot.iotenig;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

public class Supervision extends AppCompatActivity {
ListView list;
    ArrayList<String> listit;
    ArrayAdapter<String> adapt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supervision);
        list=(ListView)findViewById(R.id.listView);
        listit=new ArrayList<String>();
        adapt=new ArrayAdapter<String>(Supervision.this,android.R.layout.simple_list_item_1,listit);
        list.setAdapter(adapt);

    }
    protected void onStart()
    {
        super.onStart();
        StringRequest sr=new StringRequest(Request.Method.POST,
                "http://192.168.1.13/domo/liste.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
try
{
    JSONArray js=new JSONArray(response);
    for(int i=0;i<js.length();i++)
    {
        JSONObject k=js.getJSONObject(i);
        String res="Température= "+k.getString("temp")+"\n"+"Humidité= "
              + k.getString("hum") +"\n"+"Luminosité="+k.getString("lum")
                +"\n"+"Date= "+k.getString("date")+"\n"+"Heure= "+k.getString("heure");
        listit.add(res);
    }
    adapt.notifyDataSetChanged();
}
catch(Exception e)
{

}
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }
        };
        RequestQueue rq= Volley.newRequestQueue(Supervision.this);
        rq.add(sr);
    }
}
