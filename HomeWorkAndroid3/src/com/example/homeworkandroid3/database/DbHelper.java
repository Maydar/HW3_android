package com.example.homeworkandroid3.database;

import java.util.Random;

import com.example.homeworkandroid3.database.Contract.ClubEntry;
import com.example.homeworkandroid3.database.Contract.PlayerEntry;

import android.content.ContentValues;
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
		String [] playersName = {"Frank", "Fillip", "Vasiliy", "Ivan", "Petr", "John", "Ilkay", "Ivan", "Andrey"};
        String [] playersSurname = {"Ribery", "Lahm", "Berezickiy", "Ivanov", "Cech", "Terry", "Gundogan", "Cordoba", "Arshavin"};
        String [] clubNames = {"Inter", "Bayer Munich", "Zenit"};
        String [] cities = {"Milan", "Munich", "Saint's Petersburg"};
        String [] leagues = {"Serial A", "Bundesliga", "Russian Premiere leaague"};
        Random random = new Random();
        
        for (int i = 0; i < leagues.length; i++) {
			ContentValues cv = new ContentValues();
			cv.put(ClubEntry.COLUMN_NAME_CLUBNAME, clubNames[random.nextInt(clubNames.length)]);
			cv.put(ClubEntry.COLUMN_NAME_CTTY, cities[random.nextInt(cities.length)]);
			cv.put(ClubEntry.COLUMN_NAME_LEAGUE, leagues[random.nextInt(leagues.length)]);
			cv.put(ClubEntry.COLUMN_NAME_YEAR_OF_FOUNDATION, random.nextInt(3) + 1898);
			db.insert(ClubEntry.TABLE_NAME, null, cv);
		}
        

        for (int i = 0; i < playersSurname.length; i++) {
        	ContentValues cv = new ContentValues();
        	cv.put(PlayerEntry.COLUMN_NAME_PLAYERNAME, playersName[random.nextInt(playersName.length)]);
        	cv.put(PlayerEntry.COLUMN_NAME_SURNAME, playersSurname[random.nextInt(playersSurname.length)]);
        	cv.put(PlayerEntry.COLUMN_NAME_AGE, random.nextInt(20) + 21);
        	cv.put(PlayerEntry.COLUMN_NAME_CLUB, random.nextInt(7));
        	db.insert(PlayerEntry.TABLE_NAME, null, cv);
		}
        
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
