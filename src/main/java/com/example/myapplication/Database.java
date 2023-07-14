package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.ContentView;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "create table users(username text,email text,password text)";
        sqLiteDatabase.execSQL(query);
        String query2 = "create table cart(username text,product text,otype text)";
        sqLiteDatabase.execSQL(query2);
        String query3 = "create table porderr(username text,fullname text,contact text,address text,pincode text)";
        sqLiteDatabase.execSQL(query3);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void register(String username, String email, String password) {
        ContentValues cv = new ContentValues();
        cv.put("username", username);
        cv.put("email", email);
        cv.put("password", password);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("users", null, cv);
        db.close();
    }

    public int login(String username, String password) {
        int result = 0;
        String strs[] = new String[2];
        strs[0] = username;
        strs[1] = password;
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from users where username=? and password=?", strs);
        if (c.moveToFirst()) {
            result = 1;
        }
        return result;
    }

    public void AddCart(String username, String product, String otype) {
        ContentValues cv = new ContentValues();
        cv.put("username", username);
        cv.put("product", product);
        cv.put("otype", otype);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("cart", null, cv);
        db.close();
    }

    public int CheckCart(String username, String product)
    {
        int  result=0;
        String[]str=new String[2];
        str[0]=username;
        str[1]=product;
        SQLiteDatabase db=getReadableDatabase();
        Cursor c=db.rawQuery("select *  from cart where username=? and product=?",str);
        if(c.moveToFirst())
        {
            result=1;
        }
        return result;
    }
    public void DeleteCart(String username,String otype)
    {
        String[]str=new String[2];
        str[0]=username;
        str[1]=otype;
        SQLiteDatabase db=getWritableDatabase();
        db.delete("cart","username=? and otype=?",str);
        db.close();
    }
    public ArrayList getCartData(String username,String otype)
    {
        ArrayList<String> arr=new ArrayList<>();
        SQLiteDatabase db=getReadableDatabase();
        String[]str=new String[2];
        str[0]=username;
        str[1]=otype;
        Cursor c=db.rawQuery("select *  from cart where username=? and otype=?",str);
        boolean flag=c.moveToFirst();
        if(c.moveToFirst())
        {
            while(flag)
            {
                String product=c.getString(1);
                arr.add(product);
                flag=c.moveToNext();
            }
        }
        db.close();
        return arr;
    }

    public void addOrder(String username,String fullname,String contactnumber,String address,String pincode)
    {
        ContentValues cv = new ContentValues();
        cv.put("username", username);
        cv.put("fullname", fullname);
        cv.put("contact", contactnumber);
        cv.put("address", address);
        cv.put("pincode", pincode);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("porderr", null, cv);
        db.close();
    }
    public ArrayList getorderplace(String username)
    {
        ArrayList<String>arr=new ArrayList<>();
        SQLiteDatabase db=getReadableDatabase();
        String []str=new String[1];
        str[0]=username;
        Cursor c=db.rawQuery("select *  from porderr where username=?",str);
        boolean flag=c.moveToFirst();
        if(c.moveToFirst())
        {
            while(flag)
            {
                arr.add(c.getString(1));
                arr.add(c.getString(2));
                arr.add(c.getString(3));
                flag=c.moveToNext();
            }
        }
        db.close();
        return arr;
    }
}
