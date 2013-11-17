package com.example.homeworkandroid3.database;

import com.example.homeworkandroid3.database.Contract.ClubEntry;
import com.example.homeworkandroid3.database.Contract.PlayerEntry;

import android.R.integer;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class MyContentProvider extends ContentProvider {
	public static final UriMatcher sUriMatcher;
	private static final int PLAYERS = 10;
	private static final int CLUBS = 20;
	public static final String AUTHORITY = "com.example.homeworkandroid3.database.provider";
	static {
		sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
		sUriMatcher.addURI(AUTHORITY, PlayerEntry.TABLE_NAME, PLAYERS);
		sUriMatcher.addURI(AUTHORITY, ClubEntry.TABLE_NAME, CLUBS);
	}
	private DbHelper dbHelper;
	private SQLiteDatabase db;
	
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		long id;
		Uri uriString;
		switch (sUriMatcher.match(uri)) {
		case PLAYERS:
		        id = db.insert(PlayerEntry.TABLE_NAME, null, values);
		        uriString = Uri.parse(PlayerEntry.TABLE_NAME + "/" + id);
		        break;
		case CLUBS:
		        id = db.insert(ClubEntry.TABLE_NAME, null, values);
		        uriString = Uri.parse(ClubEntry.TABLE_NAME + "/" + id);
		        break;
		default:
		        throw new IllegalArgumentException("Unknown URI " + uri);
		}
		getContext().getContentResolver().notifyChange(uri, null);
		return uriString;
	}

	@Override
	public boolean onCreate() {
		dbHelper = new DbHelper(getContext());
		return true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		String tableName;
		switch (sUriMatcher.match(uri)) {
		case PLAYERS:
			tableName = PlayerEntry.TABLE_NAME;
			break;
		case CLUBS:
			tableName = ClubEntry.TABLE_NAME;
			break;
		default:
			throw new IllegalArgumentException("Unknown URI " + uri);
		}
		db = dbHelper.getReadableDatabase();
		
		Cursor cursor = db.query(tableName, projection, selection, selectionArgs, null, null, sortOrder);
		cursor.setNotificationUri(getContext().getContentResolver(), uri);
		return cursor;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		db = dbHelper.getWritableDatabase();
		int count= 0;
		switch (sUriMatcher.match(uri)) {
		case PLAYERS:
		        count = db.update(PlayerEntry.TABLE_NAME, values, selection, selectionArgs);
		        break;
		case CLUBS:
		        count = db.update(ClubEntry.TABLE_NAME, values, selection, selectionArgs);
		        break;
		default:
		        throw new IllegalArgumentException("Unknown URI " + uri);
		}
		getContext().getContentResolver().notifyChange(uri, null);
		return count;
		
	}

}
