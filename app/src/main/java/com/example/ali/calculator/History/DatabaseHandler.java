package com.example.ali.calculator.History;

import java.util.ArrayList;
import java.util.List;

import android.R.integer;
import android.R.string;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHandler extends SQLiteOpenHelper{

	

	private static final int DATABASE_VERSION=1;
	
	private static final String DATABASE_NAME="historyDB";
	
	private static final String TABLE_NAME="history";
	
	private static final String KEY_ID="id";
	private static final String KEY_INPUT="input";
	private static final String KEY_OUTPUT="output";
	
	public DatabaseHandler(Context context) {
		super(context,DATABASE_NAME,null,DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		//Log.v("db created", "yes");
		String CREATE_CONTACT_TABLE="CREATE TABLE "+ TABLE_NAME +"("
									+ KEY_ID +" INTEGER PRIMARY KEY,"
									+ KEY_INPUT +" TEXT,"
									+ KEY_OUTPUT +" TEXT" +")";
		db.execSQL(CREATE_CONTACT_TABLE);
		//Log.v("db created", "yes");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
		onCreate(db);
	}
	
	public void addHistory(History history)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues value=new ContentValues();
		
		value.put(KEY_INPUT, history.getInput());
		value.put(KEY_OUTPUT,history.getOutput());
		
		db.insert(TABLE_NAME, null,value);
		db.close();
		
	}
	/*
	public History getSingleHistory(int id)
	{
		SQLiteDatabase db=this.getReadableDatabase();
		
		Cursor cursor = db.query(TABLE_NAME, new String[] {KEY_ID,KEY_NAME,KEY_CONTACTNO}, KEY_ID+"=?",new String[]{String.valueOf(id)} ,null, null,null, null);
		if(cursor!=null)
		{
			cursor.moveToFirst();
		}
				
		Contact mycontact=new Contact(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2));
		return mycontact;
	}
	*/
	public List<History> getAllHistory()
	{
		List<History> historyList=new ArrayList<History>();
		
		String selectquery="SELECT * FROM "+ TABLE_NAME;
		
		SQLiteDatabase db=this.getReadableDatabase();
		
		Cursor cursor=db.rawQuery(selectquery, null);
		
		if(cursor.moveToFirst())
		{
			do
			{
				History history= new History(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2));
				historyList.add(history);
			}while(cursor.moveToNext());
		}
		db.close();
		return historyList;
	}
	/*
	public void updateContact(Contact contact)
	{
		SQLiteDatabase db=this.getWritableDatabase();
		ContentValues value=new ContentValues();
		value.put(KEY_NAME, contact.getName());
		value.put(KEY_CONTACTNO,contact.getContactNumber());
		
		db.update(TABLE_NAME, value, KEY_ID+"=?", new String[]{String.valueOf(contact.getId())});
		db.close();
	}
	*/
	public void deleteContact(int id)
	{
		SQLiteDatabase db=this.getWritableDatabase();
		db.delete(TABLE_NAME, KEY_ID+"=?", new String[]{String.valueOf(id)});
	}

    public void delete(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME,null,null);
        db.close();
    }

}
