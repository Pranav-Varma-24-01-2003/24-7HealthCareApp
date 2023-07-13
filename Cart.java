package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class Cart extends AppCompatActivity
{
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;
    Button dateButton,timeButton,checkout,back;
    ArrayList list;
    HashMap<String,String> item;
    ListView listView;
    SimpleAdapter sa;
    String type;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        dateButton=findViewById(R.id.buttontate);
        timeButton=findViewById(R.id.buttonss);
        checkout=findViewById(R.id.buttonBook);
        back=findViewById(R.id.buttonBack);
        Intent it=getIntent();
        type=it.getStringExtra("type");
        SharedPreferences sharedPreferences=getSharedPreferences("shared.prefs", Context.MODE_PRIVATE);
        String username=sharedPreferences.getString("username","").toString();
        Database db=new Database(getApplicationContext(),"healthcare",null,1);
        ArrayList dbdata=db.getCartData(username,type);
        String[][] packages=new String[dbdata.size()][];
        for(int i=0;i<dbdata.size();i++)
        {
            packages[i]=new String[3];
        }
        for(int i=0;i<dbdata.size();i++)
        {
            packages[i][0]=dbdata.get(i).toString();
        }
        listView=findViewById(R.id.productformation);
        list=new ArrayList();
        for(int i=0;i<packages.length;i++)
        {
            item=new HashMap<String,String>();
            item.put("line0",packages[i][0]);
            item.put("line1","Added Succesfully");
            item.put("line2","1 item");
            list.add(item);
        }
        sa=new SimpleAdapter(this,list,R.layout.multi_line,new String[]{"line0","line1","line2"},new int[]{R.id.linea,R.id.lineb,R.id.linec});
        listView.setAdapter(sa);
        initDatePicker();
        dateButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                datePickerDialog.show();
            }
        });
        initTimePicker();
        timeButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                timePickerDialog.show();
            }
        });

        checkout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent it=new Intent(Cart.this,CheckOut.class);
                it.putExtra("date",dateButton.getText());
                it.putExtra("time",timeButton.getText());
                it.putExtra("type",type);
                startActivity(it);

            }
        });
        back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(Cart.this, Home.class));
            }
        });
    }
    private void initDatePicker()
    {
        DatePickerDialog.OnDateSetListener dateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2)
            {
                i1=i1+1;
                dateButton.setText(i2+"/"+i1+"/"+i);

            }
        };
        Calendar cal=Calendar.getInstance();
        int year=cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH);
        int day=cal.get(Calendar.DAY_OF_MONTH);

        int style= AlertDialog.THEME_HOLO_DARK;
        datePickerDialog=new DatePickerDialog(this,style,dateSetListener,year,month,day);
    }

    private void initTimePicker()
    {
        TimePickerDialog.OnTimeSetListener timeSetListener=new TimePickerDialog.OnTimeSetListener()
        {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i2)
            {
                timeButton.setText(i2+":"+i);
            }
        };
        Calendar call=Calendar.getInstance();
        int hours=call.get(Calendar.HOUR);
        int min=call.get(Calendar.MINUTE);
        int second=call.get(Calendar.SECOND);
        int style=AlertDialog.THEME_HOLO_DARK;
        timePickerDialog=new TimePickerDialog(this,style,timeSetListener,hours,min,true);
    }
}