package com.enig.iot.iotenig;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Commande extends AppCompatActivity {
EditText equip;
    Button on,off;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commande);
        on=(Button)findViewById(R.id.on);
        off=(Button)findViewById(R.id.off);
        equip=(EditText)findViewById(R.id.equip);
        on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            final String e=equip.getText().toString();
                StringRequest sr=new StringRequest(Request.Method.POST,
                        "http://192.168.1.13/domo/commande.php",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
try
{
    JSONObject js=new JSONObject(response);
    String f=js.getString("flag");
    if(f.equals("ok"))
    {
        Toast.makeText(Commande.this, e+" en marche", Toast.LENGTH_LONG).show();

    }
    else
    {
        Toast.makeText(Commande.this, "erreur", Toast.LENGTH_LONG).show();

    }
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
                        HashMap<String,String> para=new HashMap<String, String>();
                        para.put("nom",e);
                        para.put("etat","1");
                        return  para;
                    }
                };
                RequestQueue q= Volley.newRequestQueue(Commande.this);
                q.add(sr);
            }
        });
        off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String e=equip.getText().toString();
                StringRequest sr=new StringRequest(Request.Method.POST,
                        "http://192.168.1.13/domo/commande.php",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try
                                {
                                    JSONObject js=new JSONObject(response);
                                    String f=js.getString("flag");
                                    if(f.equals("ok"))
                                    {
                                        Toast.makeText(Commande.this, e+" en arrêt", Toast.LENGTH_LONG).show();

                                    }
                                    else
                                    {
                                        Toast.makeText(Commande.this, "erreur", Toast.LENGTH_LONG).show();

                                    }
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
                        HashMap<String,String> para=new HashMap<String, String>();
                        para.put("nom",e);
                        para.put("etat","0");
                        return  para;
                    }
                };
                RequestQueue q= Volley.newRequestQueue(Commande.this);
                q.add(sr);
            }
        });
    }
}
