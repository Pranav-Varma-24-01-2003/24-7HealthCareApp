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
                    {"Package 1:Full Body Checkup","Precautions","Age:30-80"},
                    {"Package 2:Glucose","Precautions","Age:20-100"},
                    {"Package 3:Cholesterol Profile","Precuations","Age:10-100"},
                    {"Package 4:Thyroid Check","Precuations","Age:20-50"},
                    {"Package 5:Immunity Check","Precuations","Age:20-100"}
            };
    private String[]PackageDetails=
            {"Blood Pressure Measurement\n" +
                    "Blood Tests\n" +
                    "Urine Analysis\n" +
                    "Body Mass Index (BMI) Calculation\n" +
                    "Electrocardiogram (ECG)\n" +
                    "Chest X-ray\n" +
                    "Eye Examination\n" +
                    "Dental Examination\n" +
                    "Physical Examination","Fasting Blood Glucose Test\n" +
                    "Oral Glucose Tolerance Test (OGTT)\n" +
                    "HbA1c Test (Glycated Hemoglobin)\n" +
                    "Random Blood Glucose Test\n" +
                    "Postprandial Blood Glucose Test\n" +
                    "Continuous Glucose Monitoring (CGM)\n" +
                    "Self-Monitoring of Blood Glucose (SMBG)\n" +
                    "Glucose Challenge Test (GCT)\n" +
                    "Glucose Control Solutions Testing","Total Cholesterol\n" +
                    "LDL Cholesterol (Bad Cholesterol)\n" +
                    "HDL Cholesterol (Good Cholesterol)\n" +
                    "Triglycerides\n" +
                    "Cholesterol Ratios","Thyroid Function Tests:\n" +
                    "\n" +
                    "Thyroid Stimulating Hormone (TSH) Test\n" +
                    "Free T3 (Triiodothyronine) Test\n" +
                    "Free T4 (Thyroxine) Test\n" +
                    "Thyroid Antibody Tests:\n" +
                    "\n" +
                    "Thyroid Peroxidase Antibodies (TPOAb) Test\n" +
                    "Thyroglobulin Antibodies (TgAb) Test\n" +
                    "Thyroid Ultrasound:\n" +
                    "\n" +
                    "Imaging of the thyroid gland to evaluate its structure and detect any abnormalities or nodules.","Complete Blood Count (CBC)\n" +
                    "Immunoglobulin Levels\n" +
                    "Lymphocyte Subset Analysis\n" +
                    "Cytokine Profile Analysis\n" +
                    "Natural Killer (NK) Cell Activity Test\n" +
                    "T-Cell Function Assessment\n" +
                    "Immunophenotyping\n" +
                    "Autoantibody Screening\n" +
                    "Allergy Testing"};
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