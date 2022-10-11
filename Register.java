package com.example.tryapp;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import  android.content.Intent;
import android .view.View;
import android.widget.TextView;

public class Register extends AppCompatActivity {
   public TextView button;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_register);
       button= (TextView) findViewById(R.id.register);
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(Register.this,Login.class);
               startActivity(intent);
           }
       });
   }

}
