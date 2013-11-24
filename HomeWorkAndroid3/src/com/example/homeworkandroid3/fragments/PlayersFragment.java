package com.example.homeworkandroid3.fragments;

import com.example.homeworkandroid3.R;
import com.example.homeworkandroid3.R.layout;
import com.example.homeworkandroid3.R.menu;
import com.example.homeworkandroid3.database.MyContentProvider;
import com.example.homeworkandroid3.database.Contract.ClubEntry;
import com.example.homeworkandroid3.database.Contract.PlayerEntry;
import com.example.homeworkandroid3.main.MainActivity;
import com.example.homeworkandroid3.utils.ClubAdapter;
import com.example.homeworkandroid3.utils.PlayerAdapter;


import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class PlayersFragment extends Fragment implements android.support.v4.app.LoaderManager.LoaderCallbacks<Cursor> {
	
	private static final int LOADER_ID = 2;
	static final String[] PROJECTION  = new String[] {
		PlayerEntry.COLUMN_NAME_ENTRY_ID,
		PlayerEntry.COLUMN_NAME_PLAYERNAME,
		PlayerEntry.COLUMN_NAME_SURNAME,
		PlayerEntry.COLUMN_NAME_AGE,
		PlayerEntry.COLUMN_NAME_CLUB,
	};
	private PlayerAdapter adapter;
	private ListView listView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		return inflater.inflate(R.layout.main_fragment, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		listView = (ListView)getActivity().findViewById(R.id.first_list);
		Bundle arguments = getArguments();
		android.support.v4.app.LoaderManager lm = getLoaderManager();
        lm.initLoader(LOADER_ID, arguments,this);
        
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View v, int position,
					long id) {
				((MainActivity)getActivity()).showPlayerDialog();
			}
		});
		
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public Loader<Cursor> onCreateLoader(int id, Bundle arguments) {
		Uri basUri = MyContentProvider.CONTENT_URI_PLAYER;
		Integer clubId = arguments.getInt("ID");
		String [] selectionArgs = {clubId.toString()};
		return new android.support.v4.content.CursorLoader(getActivity().getApplicationContext(), basUri, PROJECTION, "club=?", selectionArgs, PlayerEntry.COLUMN_NAME_PLAYERNAME + " ASC");
	}

	@Override
	public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
		switch (loader.getId()) {
		case LOADER_ID:
			
			listView.setAdapter(new PlayerAdapter(getActivity().getApplicationContext(), cursor));
			break;

		default:
			break;
		}
		
	}

	@Override
	public void onLoaderReset(Loader<Cursor> arg0) {
		// TODO Auto-generated method stub
		
	}

}
