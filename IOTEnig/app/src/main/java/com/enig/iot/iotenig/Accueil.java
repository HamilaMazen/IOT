package com.enig.iot.iotenig;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Accueil extends AppCompatActivity {
Button co,su;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        co=(Button)findViewById(R.id.co);
        su=(Button)findViewById(R.id.su);
        co.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Accueil.this,Commande.class);
                startActivity(i);
            }
        });

        su.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Accueil.this,Supervision.class);
                startActivity(i);
            }
        });
    }
}
