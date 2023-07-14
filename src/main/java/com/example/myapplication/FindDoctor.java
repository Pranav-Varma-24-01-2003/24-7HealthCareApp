package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FindDoctor extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);

        CardView familydoctor=findViewById(R.id.familydoctor);
        familydoctor.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent it=new Intent(FindDoctor.this, Doctorinformation.class);
                it.putExtra("title","Family Doctor");
                startActivity(it);
            }
        });
        CardView dietician=findViewById(R.id.familydietician);
        dietician.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent it2=new Intent(FindDoctor.this,Doctorinformation.class);
                it2.putExtra("title","Family Dietician");
                startActivity(it2);
            }
        });

        CardView dentist=findViewById(R.id.familydentist);
        dentist.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent it3=new Intent(FindDoctor.this,Doctorinformation.class);
                it3.putExtra("title","Family Dentist");
                startActivity(it3);
            }
        });
        CardView surgeon=findViewById(R.id.familysurgeon);
        surgeon.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent it4=new Intent(FindDoctor.this,Doctorinformation.class);
                it4.putExtra("title","Family Surgeon");
                startActivity(it4);
            }
        });
        CardView cardiologist=findViewById(R.id.familycardiologist);
        cardiologist.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent it5=new Intent(FindDoctor.this,Doctorinformation.class);
                it5.putExtra("title","Family Cardiologist");
                startActivity(it5);
            }
        });
        CardView exit=findViewById(R.id.familylogout);
        exit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(FindDoctor.this, Home.class));
            }
        });
    }
}