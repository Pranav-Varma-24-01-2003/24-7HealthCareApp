package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HealthKitFormation extends AppCompatActivity
{
    TextView tv;
    EditText et;
    Button addtocart,back;
    String types="medicine";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_kit_formation);
        tv=findViewById(R.id.LabtestTitle);
        et=findViewById(R.id.Packagedetails);
        addtocart=findViewById(R.id.gotocart);
        back=findViewById(R.id.cartback);
        Intent it=getIntent();
        String titles=it.getStringExtra("text1");
        String formation=it.getStringExtra("text2");
        tv.setText(titles);
        et.setText(formation);

        addtocart.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                SharedPreferences sharedPreferences=getSharedPreferences("shared.prefs", Context.MODE_PRIVATE);
                String username=sharedPreferences.getString("username","").toString();
                String product=tv.getText().toString();
                Database db=new Database(getApplicationContext(),"healthcare",null,1);
                if(db.CheckCart(username,product)==1)
                {
                    Toast.makeText(HealthKitFormation.this, "Medicine Already Added", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    db.AddCart(username,product,types);
                    Toast.makeText(HealthKitFormation.this, "The Medicine is now added", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(HealthKitFormation.this,HealthKit.class));

                }
            }
        });
        back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(HealthKitFormation.this, HealthKit.class));
            }
        });
    }
}