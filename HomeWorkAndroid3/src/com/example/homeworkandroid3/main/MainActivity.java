package com.example.homeworkandroid3.main;


import com.example.homeworkandroid3.R;
import com.example.homeworkandroid3.dialogues.ClubDialogue;
import com.example.homeworkandroid3.dialogues.ClubDialogue.ClubDialogListener;
import com.example.homeworkandroid3.dialogues.PlayerDialogue;
import com.example.homeworkandroid3.dialogues.PlayerDialogue.PlayerDialogListener;
import com.example.homeworkandroid3.fragments.ClubsFragment;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;


public class MainActivity extends FragmentActivity implements ClubDialogListener, PlayerDialogListener{
	private ClubsFragment clubsFragment;
	
	
	public void showClubDialog() {
		DialogFragment clubDialogFragment = new ClubDialogue();
		clubDialogFragment.show(getSupportFragmentManager(), "clubDialogue");
	}
	
	public void showPlayerDialog() {
		DialogFragment playerDialogFragment = new PlayerDialogue();
		playerDialogFragment.show(getSupportFragmentManager(), "playerDialogue");
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		clubsFragment = new ClubsFragment();
		android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
		fragmentTransaction.add(R.id.fragment_container, clubsFragment);
		fragmentTransaction.addToBackStack(null);
		fragmentTransaction.commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onPlayerDialogPositiveClick(DialogFragment dialog) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPlayerDialogNegativeClick(DialogFragment dialog) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClubDialogPositiveClick(DialogFragment dialog) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClubDialogNegativeClick(DialogFragment dialog) {
		// TODO Auto-generated method stub
		
	}
	
	

}
