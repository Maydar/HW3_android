package com.example.homeworkandroid3.fragments;


import java.util.zip.Inflater;


import com.example.homeworkandroid3.R;
import com.example.homeworkandroid3.R.drawable;
import com.example.homeworkandroid3.R.id;
import com.example.homeworkandroid3.R.layout;
import com.example.homeworkandroid3.main.MainActivity;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
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

public class ClubsFragment extends Fragment {

	private PlayersFragment playersFragment;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		return inflater.inflate(R.layout.main_fragment, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		ListView listView = (ListView)getActivity().findViewById(R.id.first_list);
		listView.setAdapter(new MyAdapter());
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
	private class ViewHolder {
		public ImageView imageView;
		public TextView  textView1;
		public TextView textView2;
	}
	
	private class MyAdapter extends BaseAdapter {
		
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			
			return 100;
			
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder;
			if (convertView == null) {
				convertView = getActivity().getLayoutInflater().inflate(R.layout.item_layout, parent, false);
				holder = new ViewHolder();
				holder.textView1 = (TextView) convertView.findViewById(R.id.text1);
				holder.textView2 = (TextView) convertView.findViewById(R.id.text2);
				holder.imageView = (ImageView) convertView.findViewById(R.id.image);
				convertView.setTag(holder);
			}
			else {
				holder = (ViewHolder) convertView.getTag();
			}
			
			holder.textView1.setText("example txt");
			holder.textView2.setText("example2");

			holder.imageView.setImageResource(R.drawable.ic_launcher);
			
			return convertView;
		}
		
		
	}
}
