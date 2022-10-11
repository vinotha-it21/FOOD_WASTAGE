package com.example.tryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import  android.content.Intent;
import android .view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   public TextView button;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
       button= (TextView) findViewById(R.id.STARTED);
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(MainActivity.this,Login.class);
               startActivity(intent);
           }
       });
   }

}
