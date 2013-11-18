package com.example.homeworkandroid3.utils;


import com.example.homeworkandroid3.R;
import com.example.homeworkandroid3.database.Contract.ClubEntry;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ClubAdapter extends CursorAdapter {

	public ClubAdapter(Context context, Cursor c) {
		super(context, c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void bindView(View view, Context context, Cursor cursor) {
		TextView textViewClubName = (TextView) view.findViewById(R.id.text1);
		textViewClubName.setText(cursor.getString(cursor.getColumnIndex(ClubEntry.COLUMN_NAME_CLUBNAME)));
		
		TextView textViewCity  = (TextView) view.findViewById(R.id.text2);
		textViewCity.setText(cursor.getString(cursor.getColumnIndex(ClubEntry.COLUMN_NAME_CTTY)));
	}

	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {
		LayoutInflater inflater = LayoutInflater.from(parent.getContext());
		View view = inflater.inflate(R.layout.item_layout, parent, false);
		return view;
	}


}
