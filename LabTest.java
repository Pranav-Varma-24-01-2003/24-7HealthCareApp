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

public class LabTest extends AppCompatActivity {
    private String[][]packages=
            {
                    {"Package 1:Full Body Checkup","Precautions","Age:20-80"},
                    {"Package 2:Glucose","Precautions","Age:20-80"},
                    {"Package 3:Covid 19","Precuations","Age:20-80"},
                    {"Package 4:Thyroid Check","Precuations","Age:20-80"},
                    {"Package 5:Immunity Check","Precuations","Age:20-80"}
            };
    private String[]PackageDetails=
            {"Package 1:Details","Package 2:Details","Package 3:Details","Package 4:Details","Package 5:Details"};
    HashMap<String,String>item;
    ArrayList list;
    SimpleAdapter sa;
    ListView listView;
    Button Gotocart,Cartback;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);
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
                Intent it=new Intent(LabTest.this,LabTestInformation.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",PackageDetails[i]);
                it.putExtra("text3",PackageDetails[i]);
                startActivity(it);
            }
        });

        Gotocart.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent it=new Intent(LabTest.this,Cart.class);
                it.putExtra("hey","hi");
                it.putExtra("type","lab");
                startActivity(it);
            }
        });
        Cartback=findViewById(R.id.cartback);
        Cartback.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(LabTest.this, Home.class));
            }
        });
    }
}