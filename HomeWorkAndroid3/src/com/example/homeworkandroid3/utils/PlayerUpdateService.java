package com.example.homeworkandroid3.utils;

import com.example.homeworkandroid3.database.MyContentProvider;
import com.example.homeworkandroid3.database.Contract.PlayerEntry;

import android.app.IntentService;
import android.content.ContentValues;
import android.content.Intent;
import android.content.Context;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class PlayerUpdateService extends IntentService {

	public PlayerUpdateService() {
		super("PlayerUpdateService");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		if (intent == null) {
			return;
		}
		
		int _id = intent.getIntExtra(PlayerEntry.COLUMN_NAME_ENTRY_ID, -1);
		String name = intent.getStringExtra(PlayerEntry.COLUMN_NAME_PLAYERNAME);
		String surname = intent.getStringExtra(PlayerEntry.COLUMN_NAME_SURNAME);
		int age = intent.getIntExtra(PlayerEntry.COLUMN_NAME_AGE, 20);
		int club = intent.getIntExtra(PlayerEntry.COLUMN_NAME_CLUB, 1900);
		
		ContentValues cv = new ContentValues();
		cv.put(PlayerEntry.COLUMN_NAME_PLAYERNAME, name);
		cv.put(PlayerEntry.COLUMN_NAME_SURNAME, surname);
		cv.put(PlayerEntry.COLUMN_NAME_AGE, age);
		cv.put(PlayerEntry.COLUMN_NAME_CLUB, club);
		
		StringBuilder where = new StringBuilder();
        where.append(PlayerEntry.COLUMN_NAME_ENTRY_ID).append("=").append(_id);
        
        getContentResolver().update(MyContentProvider.CONTENT_URI_PLAYER, cv, where.toString(), null);
		
	}
	
}
