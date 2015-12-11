package me.rahul.plugins.sqlDB;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

	private Context myContext;

	public DatabaseHelper(Context context) {
		super(context, sqlDB.dbname, null, 1);
		this.myContext = context;
		// TODO Auto-generated constructor stub
	}

	public void createdatabase(File dbPath) throws IOException {

		// Log.d("CordovaLog","Inside CreateDatabase = "+dbPath);
		this.getReadableDatabase();
		try {
			copyDatabase(dbPath);
		} catch (IOException e) {
			throw new Error(
					"Create Database Exception ============================ "
							+ e);
		}

	}

	private void copyDatabase(File database) throws IOException {
		InputStream myInput = myContext.getAssets().open("www/"+sqlDB.dbname);
		OutputStream myOutput = new FileOutputStream(database);
		byte[] buffer = new byte[1024];
		while ((myInput.read(buffer)) > -1) {
			myOutput.write(buffer);
		}

		myOutput.flush();
		myOutput.close();
		myInput.close();

	}


	public void createdatabaseFrom(File dbPath, String path) throws IOException {

		// Log.d("CordovaLog","Inside CreateDatabase = "+dbPath);
		this.getReadableDatabase();
		try {
			copyDatabaseFrom(dbPath, path);
		} catch (IOException e) {
			throw new Error(
					"Create Database Exception ============================ "
							+ e);
		}

	}

	private void copyDatabaseFrom(File database, String path) throws IOException {
		InputStream myInput = new FileInputStream(path+"/"+sqlDB.dbname);
		OutputStream myOutput = new FileOutputStream(database);
		byte[] buffer = new byte[1024];
		while ((myInput.read(buffer)) > -1) {
			myOutput.write(buffer);
		}

		myOutput.flush();
		myOutput.close();
		myInput.close();

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
