package com.example.homeworkandroid3.database;

import com.example.homeworkandroid3.database.Contract.ClubEntry;
import com.example.homeworkandroid3.database.Contract.PlayerEntry;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
	 public static final String DATABASE_NAME = "homework3.db";
     private static final int DATABASE_VERSION = 1;
     
     private static final String CREATE_ENTRIES_CLUB = 
		 "CREATE TABLE " + ClubEntry.TABLE_NAME + " (" +
		 ClubEntry.COLUMN_NAME_ENTRY_ID + "INTEGER PRIMARY KEY, " +
		 ClubEntry.COLUMN_NAME_CLUBNAME + " TEXT, " +
		 ClubEntry.COLUMN_NAME_CTTY + " TEXT, " +
		 ClubEntry.COLUMN_NAME_LEAGUE + " TEXT, " +
		 ClubEntry.COLUMN_NAME_YEAR_OF_FOUNDATION + " INTEGER" + ");";
     
     private static final String CREATE_ENTRIES_PLAYER =
		 "CREATE TABLE " + PlayerEntry.TABLE_NAME + " (" +
         PlayerEntry.COLUMN_NAME_ENTRY_ID + "INTEGER PRIMARY KEY, " +
         PlayerEntry.COLUMN_NAME_PLAYERNAME + " TEXT, " +
         PlayerEntry.COLUMN_NAME_SURNAME + " TEXT, " +
         PlayerEntry.COLUMN_NAME_AGE + " INTEGER, " +
         PlayerEntry.COLUMN_NAME_CLUB + " INTEGER, " +
         "FOREIGN KEY ("+PlayerEntry.COLUMN_NAME_CLUB+")" + "REFERENCES " +
         ClubEntry.TABLE_NAME + " ("+ClubEntry.COLUMN_NAME_ENTRY_ID+"));";
     
    private static final String DELETE_ENTRIES_CLUB =
         "DROP TABLE IF EXISTS " + ClubEntry.TABLE_NAME;
    private static final String DELETE_ENTRIES_PLAYER =
         "DROP TABLE IF EXISTS " + PlayerEntry.TABLE_NAME;
	
	public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATE_ENTRIES_CLUB);
		db.execSQL(CREATE_ENTRIES_PLAYER);
		fillData(db);
	}
	
	private void fillData(SQLiteDatabase db) {
        //разбираем файл data.xml лежащий например в assets 
            //и вставляем данные в базу	
            //либо читаем лежащие там же sql-скрипты и выполняем с помощью все того же db.execSQL() или аналогично	
    }
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL(DELETE_ENTRIES_PLAYER);
		db.execSQL(CREATE_ENTRIES_CLUB);
		onCreate(db);
	}
		
	@Override
	public synchronized void close() {
		// TODO Auto-generated method stub
		getReadableDatabase().close();
        getWritableDatabase().close();
        super.close();
	}

}
