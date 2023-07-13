package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class BookPointment extends AppCompatActivity
{
    EditText et1,et2,et3;
    TextView tv;
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;
    private Button dateButton,timeButton;
    private Button book,back;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_pointment);
        tv=findViewById(R.id.Bookpoint);
        et1=findViewById(R.id.editTextBookName);
        et2=findViewById(R.id.editTextBookPlace);
        et3=findViewById(R.id.editTextBookContact);
        Intent it=getIntent();
        String title=it.getStringExtra("titles");
        String name=it.getStringExtra("line0");
        String phone=it.getStringExtra("line1");
        String email=it.getStringExtra("line2");
        tv.setText(title);
        et1.setText(name);
        et2.setText(phone);
        et3.setText(email);
        dateButton=findViewById(R.id.buttontate);
        timeButton=findViewById(R.id.buttonss);
        book=findViewById(R.id.buttonBook);
        back=findViewById(R.id.buttonBack);
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