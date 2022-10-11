package com.example.tryapp;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class Mainpage extends AppCompatActivity {
   TextView resultText;
   EditText Quantity;
   EditText Food_name;
   MyDBHandler dbHandler;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
       resultText = (TextView) findViewById(R.id.result);
       Quantity = (EditText) findViewById(R.id.Quantity);
       Food_name = (EditText) findViewById(R.id.Food_name);
       resultText.setMovementMethod(new ScrollingMovementMethod());
       dbHandler= new MyDBHandler(this);
   }
   public void load(View view) {
       resultText.setText(dbHandler.loadHandler());
       Quantity.setText("");
       Food_name.setText("");
   }
   public void add (View view) {
       if(!Quantity.getText().toString().isEmpty() && !Food_name.getText().toString().isEmpty()) {
           int id = Integer.parseInt(Quantity.getText().toString());
           String name = Food_name.getText().toString();
           Food student = new Food(id, name);
           long insertId=dbHandler.addHandler(student);
           if(insertId==-1){
               resultText.setText("Record already exists");
           }
           else{
               Quantity.setText("");
               Food_name.setText("");
               resultText.setText("Record added");
           }
       }
       else{
           resultText.setText("Please fill correct id and name");
       }
   }
   public void update(View view) {
       if( !Quantity.getText().toString().isEmpty() && !Food_name.getText().toString().isEmpty()) {
           boolean result = dbHandler.updateHandler(Integer.parseInt(
                   Quantity.getText().toString()), Food_name.getText().toString());
           if (result) {
               Quantity.setText("");
               Food_name.setText("");
               resultText.setText("Record Updated");
           } else {
               resultText.setText("No Record Found");
           }
       }
       else{
           resultText.setText("Please fill correct id and name");
       }
   }
   public void delete(View view) {
       if(!Quantity.getText().toString().isEmpty()) {
           boolean result = dbHandler.deleteHandler(Integer.parseInt(
                   Quantity.getText().toString()));
           if (result) {
               Quantity.setText("");
               Food_name.setText("");
               resultText.setText("Record Deleted");
           } else {
               resultText.setText("No Record Found");
           }
       } else{
           resultText.setText("Please fill correct id");
       }
   }
   @Override
   protected void onDestroy() {
       super.onDestroy();
       dbHandler.close();
   }
}
