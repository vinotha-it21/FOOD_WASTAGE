package com.example.tryapp;

       import android.content.ContentValues;
       import android.content.Context;
       import android.database.Cursor;
       import android.database.sqlite.SQLiteDatabase;
       import android.database.sqlite.SQLiteOpenHelper;
public class MyDBHandler extends SQLiteOpenHelper {
   private static final int DATABASE_VERSION = 1;
   private static final String DATABASE_NAME = "FoodDB.db";
   private static final String TABLE_FOOD = "Food";
   private static final String COLUMN_ID = "Quantity";
   private static final String COLUMN_NAME = "Food Name";
   MyDBHandler(Context context)
   {
       super(context, DATABASE_NAME, null, DATABASE_VERSION);
   }
   @Override
   public void onCreate(SQLiteDatabase db) {
       String CREATE_STUDENT_TABLE = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY,%s TEXT )", TABLE_FOOD, COLUMN_ID, COLUMN_NAME);
       db.execSQL(CREATE_STUDENT_TABLE);
   }
   @Override
   public void onUpgrade(SQLiteDatabase db, int oldVersion,
                         int newVersion) {
       db.execSQL("DROP TABLE IF EXISTS " + TABLE_FOOD);
       onCreate(db);
   }
   String loadHandler() {
       String result = "";
       String query = "Select*FROM " + TABLE_FOOD;
       SQLiteDatabase db = this.getWritableDatabase();
       Cursor cursor = db.rawQuery(query, null);
       while (cursor.moveToNext()) {
           int result_0 = cursor.getInt(0);
           String result_1 = cursor.getString(1);
           result += String.valueOf(result_0) + " " + result_1 +
                   System.getProperty("line.separator");
       }
       cursor.close();
       db.close();
       if(result.equals(""))
           result="No Record Found";
       return result;
   }
   long addHandler(Food student) {
       long id;
       ContentValues values = new ContentValues();
       values.put(COLUMN_ID, student.getID());
       values.put(COLUMN_NAME, student.getStudentName());
       SQLiteDatabase db = this.getWritableDatabase();
       id = db.insert(TABLE_FOOD, null, values);
       db.close();
       return id;
   }
   boolean updateHandler(int ID, String name) {
       SQLiteDatabase db = this.getWritableDatabase();
       ContentValues args = new ContentValues();
       args.put(COLUMN_ID, ID);
       args.put(COLUMN_NAME, name);
       return db.update(TABLE_FOOD, args, COLUMN_ID + "=" + ID, null) > 0;
   }
   boolean deleteHandler(int ID) {
       boolean result = false;
       String query = "Select*FROM " + TABLE_FOOD + " WHERE " + COLUMN_ID + " = '" + String.valueOf(ID) + "'";
       SQLiteDatabase db = this.getWritableDatabase();
       Cursor cursor = db.rawQuery(query, null);
       Food student = new Food();
       if (cursor.moveToFirst()) {
           student.setID(Integer.parseInt(cursor.getString(0)));
           db.delete(TABLE_FOOD, COLUMN_ID + "=?",
                   new String[] {
                           String.valueOf(student.getID())
                   });
           cursor.close();
           result = true;
       }
       db.close();
       return result;
   }
}
