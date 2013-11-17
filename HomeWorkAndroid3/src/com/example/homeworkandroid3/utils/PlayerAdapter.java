package com.example.homeworkandroid3.utils;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;

public class PlayerAdapter extends SimpleCursorAdapter {

	public PlayerAdapter(Context context, int layout, Cursor c, String[] from,
			int[] to) {
		super(context, layout, c, from, to);
		// TODO Auto-generated constructor stub
	}

}
