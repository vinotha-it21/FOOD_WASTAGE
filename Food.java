package com.example.tryapp;

import android.widget.EditText;

public class Food {
   private int Quantity;
   private String Food_Name;
   Food(EditText quantity, EditText food_name) {
   }
   Food(int Quantity, String Food_Name) {
       this.Quantity = Quantity;
       this.Food_Name = Food_Name;
   }

   public Food() {

   }

   void setID(int id) {
       this.Quantity = Quantity;
   }
   int getID() {
       return this.Quantity;
   }
   void setfood_Name(String food_Name) {
       this.Food_Name = Food_Name;
   }
   String getStudentName() {
       return this.Food_Name;
   }
}

