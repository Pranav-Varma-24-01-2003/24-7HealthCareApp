package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class HealthKit extends AppCompatActivity
{
    private String[][]packages=
            {
                    {"Medicine 1:Paracetamol:","Precautions","Age:20-80"},
                    {"Medicine 2:Ibuprofen","Precautions","Age:10-80"},
                    {"Medicine 3:Aspirin","Precuations","Age:10-100"},
                    {"Medicine 4:Amoxicillin","Precuations","Age:20-50"},
                    {"Medicine 5:Cetirizine","Precuations","Age:10-100"}
            };
    private String[]PackageDetails=
            {"Paracetamol is a widely used over-the-counter medication known for its analgesic (pain-relieving) and antipyretic (fever-reducing) properties.\n" +
                    "It is commonly used to alleviate mild to moderate pain, such as headaches, muscle aches, toothaches, and to reduce fever associated with various conditions.\n",
                    "Metformin is an oral medication commonly prescribed to manage type 2 diabetes.\n" +
                            "It helps lower blood sugar levels by reducing glucose production in the liver and increasing insulin sensitivity in the body.\n" +
                            "Metformin is often used alongside lifestyle changes, such as diet and exercise, to achieve optimal blood sugar control.\n",
                    "Aspirin is an NSAID with analgesic, anti-inflammatory, and antipyretic properties.\n" +
                            "It is commonly used for pain relief, reducing inflammation, and preventing blood clot formation.\n" +
                            "Aspirin is often used to relieve mild to moderate pain, such as headaches, toothaches, muscle aches, and to manage conditions like arthritis.\n",
                    "Amoxicillin is an antibiotic commonly prescribed to treat a wide range of bacterial infections.\n" +
                            "It belongs to the penicillin group of antibiotics and is effective against various types of infections, such as respiratory tract infections, ear infections, urinary tract infections, and skin infections.\n",
                    "Cetirizine is an antihistamine used to relieve allergy symptoms such as sneezing, itching, watery eyes, and runny nose.\n" +
                            "It works by blocking the effects of histamine, a substance produced by the body during an allergic reaction.\n" +
                            "Cetirizine is commonly used to alleviate symptoms associated with allergic rhinitis (hay fever) and other allergic conditions.\n"};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView listView;
    Button Gotocart,Cartback;
    String types="medicine";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_kit);
        Gotocart=findViewById(R.id.gotocart);
        Cartback=findViewById(R.id.cartback);
        listView=findViewById(R.id.Packagedetails);
        list=new ArrayList();
        for(int i=0;i<packages.length;i++)
        {
            item=new HashMap<String,String>();
            item.put("line0",packages[i][0]);
            item.put("line1",packages[i][1]);
            item.put("line2",packages[i][2]);
            list.add(item);
        }
        sa=new SimpleAdapter(this,list,R.layout.multi_line,new String[]{"line0","line1","line2"},new int[]{R.id.linea,R.id.lineb,R.id.linec});
        listView.setAdapter(sa);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                Intent it=new Intent(HealthKit.this,HealthKitFormation.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",PackageDetails[i]);
                it.putExtra("text3",PackageDetails[i]);
                startActivity(it);
            }
        });
        Cartback=findViewById(R.id.cartback);
        Gotocart.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent it=new Intent(HealthKit.this,Cart.class);
                it.putExtra("hi","hey");
                it.putExtra("type",types);
                startActivity(it);
            }
        });

        Cartback.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(HealthKit.this, Home.class));
            }
        });
    }
}
