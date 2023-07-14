package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class HealthArticles extends AppCompatActivity
{
    private String[][]packages=
            {
                    {"Walking Daily","","Click for more detials"},
                    {"Home Care of COVID-19","","Click for more details"},
                    {"Stop Smoking","","Click for more details"},
                    {"Heathly Gut","","Click for more details"}
            };
    private String[]PackageDetails=
            {"Walking Daily","Home Care of COVID-19","Stop Smoking","Healthy Gut"};
    private int[] images={R.drawable.health1,R.drawable.health2,R.drawable.health3,R.drawable.health5};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView listView;
    Button Cartback;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_articles);
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
                Intent it=new Intent(HealthArticles.this,HealthArticlesInformation.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",PackageDetails[i]);
                it.putExtra("text3",images[i]);
                startActivity(it);
            }
        });
        Cartback=findViewById(R.id.cartback);
        Cartback.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(HealthArticles.this, Home.class));
            }
        });
    }
}


