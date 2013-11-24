package com.example.homeworkandroid3.utils;

import com.example.homeworkandroid3.database.MyContentProvider;
import com.example.homeworkandroid3.database.Contract.ClubEntry;

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
public class ClubUpdateService extends IntentService {

	public ClubUpdateService() {
		super("ClubUpdateServices");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		if (intent == null) {
			return;
		}
		
		int _id = intent.getIntExtra(ClubEntry.COLUMN_NAME_ENTRY_ID, -1);
		String clubName = intent.getStringExtra(ClubEntry.COLUMN_NAME_CLUBNAME);
		String league = intent.getStringExtra(ClubEntry.COLUMN_NAME_LEAGUE);
		String city = intent.getStringExtra(ClubEntry.COLUMN_NAME_CTTY);
		int founded = intent.getIntExtra(ClubEntry.COLUMN_NAME_YEAR_OF_FOUNDATION, 1900);
		
		ContentValues cv = new ContentValues();
		cv.put(ClubEntry.COLUMN_NAME_CLUBNAME, clubName);
		cv.put(ClubEntry.COLUMN_NAME_CTTY, city);
		cv.put(ClubEntry.COLUMN_NAME_LEAGUE, league);
		cv.put(ClubEntry.COLUMN_NAME_YEAR_OF_FOUNDATION, founded);
		
		StringBuilder where = new StringBuilder();
        where.append(ClubEntry.COLUMN_NAME_ENTRY_ID).append("=").append(_id);
        
        getContentResolver().update(MyContentProvider.CONTENT_URI_CLUB, cv, where.toString(), null);
	}
	
}
