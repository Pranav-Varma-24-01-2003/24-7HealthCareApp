package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Booked extends AppCompatActivity
{
    ListView lst;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booked);

        lst=findViewById(R.id.Packagedetails);
        back=findViewById(R.id.cartback);
        SharedPreferences sharedPreferences=getSharedPreferences("shared.prefs", Context.MODE_PRIVATE);
        String username=sharedPreferences.getString("username","").toString();
        Database db= new Database(getApplicationContext(),"healthcare",null,1);
        ArrayList dbdata=db.getorderplace(username);
        String [][]orderplace=new String[(dbdata.size())/3][3];
        for(int i=0;i< (orderplace.length)/3;i++)
        {
            orderplace[i][0]=dbdata.get(3*i).toString();
            orderplace[i][1]=dbdata.get(3*i+1).toString();
            orderplace[i][2]=dbdata.get(3*i+2).toString();
        }


        ArrayList list;
        list=new ArrayList();
        SimpleAdapter sa;
        HashMap<String,String>item;
        for(int i=0;i<orderplace.length;i++)
        {
            item=new HashMap<String,String>();
            item.put("line0",orderplace[i][0]);
            item.put("line1",orderplace[i][1]);
            item.put("line2",orderplace[i][2]);
            list.add(item);
        }
        sa=new SimpleAdapter(this,list,R.layout.multi_line,new String[]{"line0","line1","line2"},new int[]{R.id.linea,R.id.lineb,R.id.linec});
        lst.setAdapter(sa);

    }
}