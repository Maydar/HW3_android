package com.example.homeworkandroid3.fragments;


import java.util.zip.Inflater;


import com.example.homeworkandroid3.R;
import com.example.homeworkandroid3.R.drawable;
import com.example.homeworkandroid3.R.id;
import com.example.homeworkandroid3.R.layout;
import com.example.homeworkandroid3.database.DbHelper;
import com.example.homeworkandroid3.database.MyContentProvider;
import com.example.homeworkandroid3.database.Contract.ClubEntry;
import com.example.homeworkandroid3.main.MainActivity;
import com.example.homeworkandroid3.utils.ClubAdapter;

import android.R.anim;
import android.net.Uri;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class ClubsFragment extends Fragment implements android.support.v4.app.LoaderManager.LoaderCallbacks<Cursor>{

	private PlayersFragment playersFragment;
	static final String[] PROJECTION  = new String[] {
		ClubEntry.COLUMN_NAME_ENTRY_ID,
		ClubEntry.COLUMN_NAME_CLUBNAME,
		ClubEntry.COLUMN_NAME_CTTY,
	};
	
	private static final int LOADER_ID = 1;
	private ClubAdapter adapter;
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
		
		android.support.v4.app.LoaderManager lm = getLoaderManager();
        lm.initLoader(LOADER_ID, null,this);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View v, int position,
					long id) {
				playersFragment = new PlayersFragment();
				android.support.v4.app.FragmentTransaction fTransaction = getActivity().getSupportFragmentManager().beginTransaction();
				fTransaction.replace(R.id.fragment_container, playersFragment);
				fTransaction.addToBackStack(null);
				fTransaction.commit();
			}
		});
		listView.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View v,
					int position, long id) {
				((MainActivity)getActivity()).showClubDialog();
				return true;
			}
		});
		
		super.onActivityCreated(savedInstanceState);
	}
	
	
	
		
		
	

	@Override
	public android.support.v4.content.Loader<Cursor> onCreateLoader(int arg0,
			Bundle arg1) {
		Uri basUri = MyContentProvider.CONTENT_URI_CLUB;
		//String selection = ClubEntry.COLUMN_NAME_CLUBNAME + "AND" + ClubEntry.COLUMN_NAME_CTTY;
		return new android.support.v4.content.CursorLoader(getActivity().getApplicationContext(), basUri, PROJECTION, null, null, ClubEntry.COLUMN_NAME_CLUBNAME + " ASC");
	}

	


	@Override
	public void onLoadFinished(android.support.v4.content.Loader<Cursor> loader,
			Cursor cursor) {
		switch (loader.getId()) {
		case LOADER_ID:
			
			listView.setAdapter(new ClubAdapter(getActivity().getApplicationContext(), cursor));
			break;

		default:
			break;
		}
		
	}

	@Override
	public void onLoaderReset(android.support.v4.content.Loader<Cursor> arg0) {
		// TODO Auto-generated method stub
		
	}
}
