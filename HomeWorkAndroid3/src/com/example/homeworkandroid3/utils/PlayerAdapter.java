package com.example.homeworkandroid3.utils;

import com.example.homeworkandroid3.R;
import com.example.homeworkandroid3.database.Contract.ClubEntry;
import com.example.homeworkandroid3.database.Contract.PlayerEntry;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PlayerAdapter extends CursorAdapter {

	public PlayerAdapter(Context context, Cursor c) {
		super(context, c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void bindView(View view, Context context, Cursor cursor) {
		TextView textViewPlayerName = (TextView) view.findViewById(R.id.player_name);
		textViewPlayerName.setText(cursor.getString(cursor.getColumnIndex(PlayerEntry.COLUMN_NAME_PLAYERNAME)));
		
		TextView textViewAge  = (TextView) view.findViewById(R.id.player_age);
		textViewAge.setText(cursor.getString(cursor.getColumnIndex(PlayerEntry.COLUMN_NAME_AGE)));
		
		TextView textViewSurname  = (TextView) view.findViewById(R.id.player_surname);
		textViewSurname.setText(cursor.getString(cursor.getColumnIndex(PlayerEntry.COLUMN_NAME_SURNAME)));
		
	}

	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {
		LayoutInflater inflater = LayoutInflater.from(parent.getContext());
		View view = inflater.inflate(R.layout.item_player_layout, parent, false);
		return view;
	}

	

}
