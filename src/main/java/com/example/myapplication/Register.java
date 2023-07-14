package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class Register extends AppCompatActivity
{
    EditText registerUsername,registerPassword,registerConfirm,registerEmail;
    TextView tv;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        registerUsername=findViewById(R.id.editTextBookName);
        registerEmail=findViewById(R.id.editTextBookPlace);
        registerPassword=findViewById(R.id.editTextBookContact);
        registerConfirm=findViewById(R.id.editTextBookType);
        btn=findViewById(R.id.buttonBook);
        tv=findViewById(R.id.textViewRegisterAccount);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Register.this, Login.class));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String username=registerUsername.getText().toString();
                String email=registerEmail.getText().toString();
                String password=registerPassword.getText().toString();
                String confirm=registerConfirm.getText().toString();
                Database db=new Database(getApplicationContext(),"healthcare",null,1);
                if(username.length()==0||email.length()==0||password.length()==0||confirm.length()==0)
                {
                    Toast.makeText(getApplicationContext(),"Enter correctly without blanks",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(password.compareTo(confirm)==0)
                    {
                        if(isValid(password))
                        {
                            db.register(username,email,password);
                            Toast.makeText(getApplicationContext(),"Your account is registered",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Register.this,Login.class));
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"Password must be of length more than 8,should have letter and digit",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Password and Confirm Password are not same",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
    public static boolean isValid(String password)
    {
        if(password.length()<8)
        {
            return false;
        }
        int f1=0;
        int f2=0;
        for(int i=0;i<password.length();i++)
        {
            if(Character.isLetter(password.charAt(i)))
            {
                f1=1;
            }
        }
        for(int i=0;i<password.length();i++)
        {
            if(Character.isDigit(password.charAt(i)))
            {
                f2=1;
            }
        }
        if(f1==1)
        {
            if(f2==1)
            {
                return true;
            }
        }
        return false;
    }
}