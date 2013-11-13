package com.example.homeworkandroid3.database;

import android.provider.BaseColumns;

public class Contract {
	public Contract() {}
	
	public static abstract class ClubEntry implements BaseColumns {
		public static final String TABLE_NAME_STRING = "club";
		public static final String COLUMN_NAME_ENTRY_ID = "clubid";
		public static final String COLUMN_NAME_CLUBNAME = "name";
		public static final String COLUMN_NAME_YEAR_OF_FOUNDATION = "year";
		public static final String COLUMN_NAME_CTTY = "city";
		public static final String COLUMN_NAME_LEAGUE = "league";
	}
	
	public static abstract class PlayerEntry implements BaseColumns {
		public static final String TABLE_NAME_STRING = "player";
		public static final String COLUMN_NAME_ENTRY_ID = "playerid";
		public static final String COLUMN_NAME_PLAYERNAME = "name";
		public static final String COLUMN_NAME_SURNAME = "surname";
		public static final String COLUMN_NAME_AGE = "age";
		public static final String COLUMN_NAME_CLUB = "club";
	}
}