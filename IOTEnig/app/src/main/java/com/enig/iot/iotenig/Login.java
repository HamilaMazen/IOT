package com.enig.iot.iotenig;

import android.content.Intent;
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

public class Login extends AppCompatActivity {
EditText log,pass;
    Button ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //liaison entre java et xml
        setContentView(R.layout.activity_login);
log=(EditText)findViewById(R.id.log);
pass=(EditText)findViewById(R.id.pass);
   ok=(Button)findViewById(R.id.ok);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View x) {
               final String l,p;
                l=log.getText().toString();
                p=pass.getText().toString();
                if(l.equals(""))
                {
                    log.setError("Login obligatoire");
                }
                else
                {
                    if(p.equals(""))
                    {
                        pass.setError("Mot de passe obligatoire");
                    }
                    else
                    {
StringRequest sr=new StringRequest(Request.Method.POST,
        "http://192.168.1.13/domo/login.php", new Response.Listener<String>() {
    @Override
    public void onResponse(String response) {
try
{
    JSONObject js=new JSONObject(response);
String n=js.getString("x");
    if(n.equals("introuvable"))
    {
        Toast.makeText(Login.this,"Données incorrectes",Toast.LENGTH_LONG).show();
    }
    else
    {
        Toast.makeText(Login.this,"Bienvenue "+n,Toast.LENGTH_LONG).show();
        Intent i=new Intent(Login.this,Accueil.class);
        startActivity(i);
    }
}
catch(Exception e)
{
    Toast.makeText(Login.this,"Erreur",Toast.LENGTH_LONG).show();

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
        para.put("login",l);
        para.put("password",p);
        return para;
    }
};
    RequestQueue rq=Volley.newRequestQueue(Login.this);
     rq.add(sr);
                    }
                }

            }
        });



    }
}
