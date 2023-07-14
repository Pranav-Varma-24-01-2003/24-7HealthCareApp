package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HealthArticlesInformation extends AppCompatActivity
{
    TextView tv;
    Button back;
    ImageView images;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_articles_information);
        Intent it=getIntent();
        String healtharticles=it.getStringExtra("text2");

        tv=findViewById(R.id.LabtestTitle);
        back=findViewById(R.id.cartback);
        images=findViewById(R.id.imageView);
        tv.setText(healtharticles);

        Bundle bundle=it.getExtras();
        if(bundle!=null)
        {
            int img=bundle.getInt("text3");
            images.setImageResource(img);
        }
        back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(HealthArticlesInformation.this,HealthArticles.class));
            }
        });
    }
}