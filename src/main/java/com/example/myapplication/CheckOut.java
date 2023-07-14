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

public class CheckOut extends AppCompatActivity
{
    EditText et,et2,et3,et4;
    TextView tv,tv2;
    Button booked;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);
        et=findViewById(R.id.editTextBookName);
        et2=findViewById(R.id.editTextBookPlace);
        et3=findViewById(R.id.editTextBookContact);
        et4=findViewById(R.id.editTextBookType);
        booked=findViewById(R.id.buttonBook);
        Intent intent=getIntent();
        String date=intent.getStringExtra("date");
        String time=intent.getStringExtra("time");
        String types=intent.getStringExtra("type");
        booked.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                SharedPreferences sharedPreferences=getSharedPreferences("shared.prefs", Context.MODE_PRIVATE);
                String username=sharedPreferences.getString("username","").toString();
                Database db= new Database(getApplicationContext(),"healthcare",null,1);
                db.addOrder(username,et.getText().toString(),et2.getText().toString(),et3.getText().toString(),et4.getText().toString());
                db.DeleteCart(username,types);
                Toast.makeText(CheckOut.this, "Your booking is done succesfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(CheckOut.this,Home.class));
            }
        });

    }
}