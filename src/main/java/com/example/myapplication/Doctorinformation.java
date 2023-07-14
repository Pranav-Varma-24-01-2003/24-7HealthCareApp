package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class Doctorinformation extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctorinformation);

        TextView tv=findViewById(R.id.LabtestTitle);
        Intent it=getIntent();
        String title=it.getStringExtra("title");
        tv.setText(title);
        Button btn=findViewById(R.id.cartback);
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(Doctorinformation.this,FindDoctor.class));
            }
        });
         String[][] doctorinformations1=
                 {
                         {"Name:Brock Son","Phone:747.329.4910","Email:paucek.eve@purdy.org"},
                         {"Name:Zaria Block","Phone:17746401696","Email:ashanahan@conroy.com"},
                         {"Name: Emily Smith","Phone: +1 (555) 123-4567","Email: emilysmith@example.com"},
                         {"Name: Michael Johnson","Phone: +1 (555) 987-6543","Email: michaeljohnson@example.com"},
                         {"Name: Olivia Davis","Phone: +1 (555) 234-5678","Email: oliviadavis@example.com"}
                 };
         String[][]doctorinformations2=
                 {
                         {"Name:Monte Greenholt","Phone:(731) 716-4758","Email:eleanore.koepp@dubuque.biz"},
                         {"Name:Zaria Block","Phone:17746401696","Email:ashanahan@conroy.com"},
                         {"Name: William Anderson","Phone: +1 (555) 876-5432","Email: williamanderson@example.com"},
                         {"Name: Ava Wilson","Phone: +1 (555) 345-6789","Email: avawilson@example.com"},
                         {"Name: Noah Martinez","Phone: +1 (555) 765-4321","Email: noahmartinez@example.com"},
                 };
        String[][]doctorinformations3=
                {
                        {"Name: Sophia Thompson","Phone: +1 (555) 456-7890","Email: sophiathompson@example.com"},
                        {"Name: Liam Harris","Phone: +1 (555) 234-5678","Email: liamharris@example.com"},
                        {"Name: Ethan Lewis","Phone: +1 (555) 345-6789","Email: ethanlewis@example.com"},
                        {"Name: Benjamin Walke","Phone: +1 (555) 456-7890","Email: benjaminwalker@example.com"},
                        {"Name: Charlotte Green","Phone: +1 (555) 234-5678","Email: charlottegreen@example.com"},
                };
        String[][]doctorinformations4=
                {
                        {"Name: Lucas Hill","Phone: +1 (555) 987-6543","Email: lucashill@example.com"},
                        {"Name: Henry Turner","Phone: +1 (555) 765-4321","Email: henryturner@example.com"},
                        {"Name: Daniel Morgan","Phone: +1 (555) 345-6789","Email: danielmorgan@example.com"},
                        {"Name: Evelyn Young","Phone: +1 (555) 876-5432","Email: evelynyoung@example.com"},
                        {"Name: Matthew King","Phone: +1 (555) 456-7890","Email: matthewking@example.com"},
                };
        String[][]doctorinformations5=
                {
                        {"Name: Harper Walker","Phone: +1 (555) 456-7890","Email: harperwalker@example.com"},
                        {"Name: Samuel Adams","Phone: +1 (555) 234-5678","Email: samueladams@example.com"},
                        {"Name: Benjamin Wright","Phone: +1 (555) 345-6789","mail: benjaminwright@example.com"},
                        {"Name: Henry Turner","Phone: +1 (555) 765-4321","Email: henryturner@example.com"},
                        {"Name: Samuel Adams","Phone: +1 (555) 456-7890","Email: samueladams@example.com"}
                };
        String[][] doctorinformation;
        if(title.compareTo("Family Doctor")==0)
        {
            doctorinformation=doctorinformations1;
        }
        else if(title.compareTo("Family Dietician")==0)
        {
            doctorinformation=doctorinformations2;
        }
        else if(title.compareTo("Family Dentist")==0)
        {
            doctorinformation=doctorinformations3;
        }
        else if(title.compareTo("Family Surgeon")==0)
        {
            doctorinformation=doctorinformations4;
        }
        else
        {
            doctorinformation=doctorinformations5;
        }
        ArrayList list;
        SimpleAdapter sa;
        list=new ArrayList();
        HashMap<String,String>item;
        for(int i=0;i<doctorinformation.length;i++)
        {
            item=new HashMap<String,String>();
            item.put("line0",doctorinformation[i][0]);
            item.put("line1",doctorinformation[i][1]);
            item.put("line2",doctorinformation[i][2]);
            list.add(item);
        }
        sa=new SimpleAdapter(this,list,R.layout.multi_line,new String[]{"line0","line1","line2"},new int[]{R.id.linea,R.id.lineb,R.id.linec});
        ListView lst=findViewById(R.id.Packagedetails);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                Intent it=new Intent(Doctorinformation.this, BookPointment.class);
                it.putExtra("titles",title);
                it.putExtra("line0",doctorinformation[i][0]);
                it.putExtra("line1",doctorinformation[i][1]);
                it.putExtra("line2",doctorinformation[i][2]);
                startActivity(it);
            }
        });
    }
}