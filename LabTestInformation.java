package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LabTestInformation extends AppCompatActivity
{
    TextView tv;
    EditText et;
    Button addtocart,back;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_information);
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
                    Toast.makeText(LabTestInformation.this, "Product Already Added", Toast.LENGTH_SHORT).show();
                }
                else
                {
                        db.AddCart(username,product,"lab");
                    Toast.makeText(LabTestInformation.this, "The Product is now added", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LabTestInformation.this,LabTest.class));

                }
            }
        });
        back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(LabTestInformation.this, LabTest.class));
            }
        });
    }
}