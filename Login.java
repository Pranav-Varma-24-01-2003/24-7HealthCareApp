package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity
{
    EditText euser,eword;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        euser=findViewById(R.id.editTextLoginUsername);
        eword=findViewById(R.id.editTextLoginPassword);
        btn=findViewById(R.id.buttonBook);
        tv=findViewById(R.id.textViewLoginNewUser);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usr=euser.getText().toString();
                String words=eword.getText().toString();
                Database db= new Database(getApplicationContext(),"healthcare",null,1);
                if(usr.length()==0 || words.length()==0)
                {
                    Toast.makeText(getApplicationContext(),"Enter correctly",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(db.login(usr,words)==1)
                    {
                        Toast.makeText(getApplicationContext(),"Login Succesful",Toast.LENGTH_SHORT).show();
                        SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor= sharedPreferences.edit();
                        editor.putString("username",usr);
                        editor.apply();
                        startActivity(new Intent(Login.this,Home.class));
                    }
                    else
                    {
                       Toast.makeText(getApplicationContext(),"Enter the correct username and password",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, Register.class));
            }
        });
    }
}