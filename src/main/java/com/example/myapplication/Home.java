package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Home extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username= sharedPreferences.getString("username"," ").toString();
        Toast.makeText(getApplicationContext(),"Welcome "+username,Toast.LENGTH_SHORT).show();

        CardView findoctor=findViewById(R.id.cardhomedoctor);
        findoctor.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(Home.this,FindDoctor.class));
            }
        });
        CardView labtest=findViewById(R.id.cardhome0);
        labtest.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(Home.this,LabTest.class));
            }
        });
        CardView exit=findViewById(R.id.cardhomeexit);
        exit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.clear();
                editor.apply();
                startActivity(new Intent(Home.this, Login.class));
            }
        });
        CardView booked=findViewById(R.id.cardhomeorder);
        booked.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(Home.this,Booked.class));
            }
        });
        CardView healthkit=findViewById(R.id.cardhomesell);
        healthkit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(Home.this,HealthKit.class));
            }
        });
        CardView healtharticles=findViewById(R.id.cardhomehealthdoctor);
        healtharticles.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(Home.this,HealthArticles.class));
            }
        });

    }
}