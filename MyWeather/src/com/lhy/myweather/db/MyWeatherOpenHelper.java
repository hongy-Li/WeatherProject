package com.lhy.myweather.db;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyWeatherOpenHelper extends SQLiteOpenHelper {

	public static final String PROVINCE="create table Province("
								+"id integer primary key autoincrement,"
								+ "province_name text,"
								+ "province_code text)";
	public static final String CITY="create table City("
								+"id integer primary key autoincrement,"
								+ "city_name text,"
								+ "city_code,"
								+ "province_id)";
	public static final String COUNTY="create table Country("
								+ "id integer primary autoincrement,"
								+ "county_name text,"
								+ "county_code text,"
								+ "city_id integer)";
	

	public MyWeatherOpenHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
		JSONObject jsonObject=new JSONObject();
		try {
			jsonObject.get("");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(PROVINCE);
		db.execSQL(CITY);
		db.execSQL(COUNTY);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
