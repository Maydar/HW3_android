package com.example.homeworkandroid3.fragments;

import com.example.homeworkandroid3.R;
import com.example.homeworkandroid3.R.layout;
import com.example.homeworkandroid3.R.menu;


import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
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

public class PlayersFragment extends Fragment {

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
		listView.setAdapter(new MyItemAdapter());
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View v, int position,
					long id) {
				Toast.makeText(getActivity().getApplicationContext(), "in item fragment", Toast.LENGTH_SHORT).show();
			}
		});
		
		super.onActivityCreated(savedInstanceState);
	}
	private class ViewHolder {
		public ImageView imageView;
		public TextView  textView1;
		public TextView textView2;
	}
	
	private class MyItemAdapter extends BaseAdapter {
		
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