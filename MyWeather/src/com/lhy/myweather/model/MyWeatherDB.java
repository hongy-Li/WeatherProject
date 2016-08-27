package com.lhy.myweather.model;

import java.util.ArrayList;
import java.util.List;

import com.lhy.myweather.db.MyWeatherOpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MyWeatherDB {
	/**
	 * 数据库名
	 */
	public static final String DB_NAME = "my_weather";
	/**
	 * 数据库版本
	 */
	public static final int VERSION = 1;
	private static MyWeatherDB myweatherDB;
	private static SQLiteDatabase db;

	/**
	 * 将构造函数私有化
	 * 
	 * @param context
	 */
	private MyWeatherDB(Context context) {
		MyWeatherOpenHelper dbhelper = new MyWeatherOpenHelper(context,
				DB_NAME, null, VERSION);
		db = dbhelper.getWritableDatabase();
	}

	/**
	 * 获取MyWeatherDB的实例
	 * 懒汉式
	 */
	public synchronized static MyWeatherDB getInstance(Context context) {
		if (myweatherDB != null) {
			myweatherDB = new MyWeatherDB(context);
		}
		return myweatherDB;
	}

	/**
	 * 将province实例存储到数据库
	 */
	public void saveProvince(Province province) {
		if (province != null) {
			ContentValues values = new ContentValues();
			values.put("province_name", province.getProvinceName());
			values.put("province_code", province.getProvinceCode());
			db.insert("Province", null, values);
		}
	}

	/**
	 * 从数据库读取所有信息
	 */
	public List<Province> loadProvinces() {
		List<Province> list = new ArrayList<Province>();
		Cursor cursor = db
				.query("Province", null, null, null, null, null, null);
		if (cursor.moveToFirst()) {
			do {
				Province province = new Province();
				province.setId(cursor.getInt(cursor.getColumnIndex("id")));
				province.setProvinceName(cursor.getString(cursor
						.getColumnIndex("province_name")));
				province.setProvinceCode(cursor.getString(cursor
						.getColumnIndex("province_code")));
				list.add(province);
			} while (cursor.moveToNext());
		}
		if (cursor != null) {
			cursor.close();
		}
		return list;

	}

	/**
	 * 将City实例添加到数据库
	 */
	public void saveCity(City city) {
		if (city != null) {
			ContentValues values = new ContentValues();
			values.put("id", city.getId());
			values.put("city_name", city.getCityName());
			values.put("city_code", city.getCityCode());
			values.put("province_id", city.getProvinceId());
			db.insert("City", null, values);
		}
	}

	/**
	 * 从数据库读取City的信息；
	 */
	public List<City> loadCity() {
		List<City> list = new ArrayList<City>();
		Cursor cursor = db.query("City", null, null, null, null, null, null);
		while (cursor.moveToNext()) {
			City city = new City();
			city.setId(cursor.getInt(cursor.getColumnIndex("id")));
			city.setCityName(cursor.getString(cursor
					.getColumnIndex("city_name")));
			city.setCityCode(cursor.getString(cursor
					.getColumnIndex("city_code")));
			city.setProvinceId(cursor.getInt(cursor
					.getColumnIndex("province_id")));
			list.add(city);
		}
		if (cursor != null) {
			cursor.close();
		}
		return list;
	}
/**
 * 保存county数据到数据库
 */
	public void saveCounty(County county){
		if(county!=null){
		ContentValues values=new ContentValues();
		values.put("id", county.getId());
		values.put("county_name", county.getCountyName());
		values.put("county_code", county.getCountyCode());
		values.put("city_id", county.getCityId());
		db.insert("County", null, values);
	}
	}
	/**
	*从数据库取出来县的信息 
	 */ 
	public List<County> loadCounty(){
		List<County> list=new ArrayList<County>();
		Cursor cursor=db.query("County", null, null, null, null, null, null);
		while(cursor.moveToNext()){
			County county=new County();
			county.setId(cursor.getInt(cursor.getColumnIndex("id")));
			county.setCountyName(cursor.getString(cursor.getColumnIndex("county_name")));
			county.setCountyCode(cursor.getString(cursor.getColumnIndex("county_code")));
			county.setCityId(cursor.getInt(cursor.getColumnIndex("city_id")));
			list.add(county);
		}
		if(cursor!=null){
			cursor.close();
		}
		
		return list  ;
		
	}
	
}
