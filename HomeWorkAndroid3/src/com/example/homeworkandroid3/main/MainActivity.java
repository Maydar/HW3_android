package com.example.homeworkandroid3.main;


import com.example.homeworkandroid3.R;
import com.example.homeworkandroid3.database.Club;
import com.example.homeworkandroid3.database.Contract.ClubEntry;
import com.example.homeworkandroid3.database.Contract.PlayerEntry;
import com.example.homeworkandroid3.database.Player;
import com.example.homeworkandroid3.dialogues.ClubDialogue;
import com.example.homeworkandroid3.dialogues.ClubDialogue.ClubDialogListener;
import com.example.homeworkandroid3.dialogues.PlayerDialogue;
import com.example.homeworkandroid3.dialogues.PlayerDialogue.PlayerDialogListener;
import com.example.homeworkandroid3.fragments.ClubsFragment;
import com.example.homeworkandroid3.utils.ClubUpdateService;
import com.example.homeworkandroid3.utils.PlayerUpdateService;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.widget.EditText;


public class MainActivity extends FragmentActivity implements ClubDialogListener, PlayerDialogListener{
	private ClubsFragment clubsFragment;
	private DialogFragment clubDialogFragment;
	private DialogFragment playerDialogFragment;
	
	public void showClubDialog(Bundle arguments) {
		clubDialogFragment = new ClubDialogue();
		clubDialogFragment.setArguments(arguments);
		clubDialogFragment.show(getSupportFragmentManager(), "clubDialog");
	}
	
	public void showPlayerDialog(Bundle arguments) {
		playerDialogFragment = new PlayerDialogue();
		playerDialogFragment.setArguments(arguments);
		playerDialogFragment.show(getSupportFragmentManager(), "playerDialog");
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
		updatePlayer();
		
	}

	@Override
	public void onPlayerDialogNegativeClick(DialogFragment dialog) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClubDialogPositiveClick(DialogFragment dialog) {
		updateClub();
		
	}

	@Override
	public void onClubDialogNegativeClick(DialogFragment dialog) {
		// TODO Auto-generated method stub
		
	}
	
	public void updateClub() {
		if (clubDialogFragment != null) {
			Dialog view = clubDialogFragment.getDialog();
			
			Club club = ((ClubDialogue)clubDialogFragment).getClub();
			
			 int _id = club.getId();
             String name = ((EditText)view.findViewById(R.id.club_name_dlg)).getText().toString();
             String city = ((EditText)view.findViewById(R.id.city_dlg)).getText().toString();
             String league = ((EditText)view.findViewById(R.id.league_dlg)).getText().toString();
             int founded = Integer.parseInt(((EditText)view.findViewById(R.id.year_found_dlg)).getText().toString());

             if (!club.getName().equals(name) || !club.getCity().equals(city) || 
                             !(club.getLeague()== league) || !(club.getYearOfFoundation() == founded)) {
            	 
                     Intent intent = new Intent(MainActivity.this, ClubUpdateService.class);
                     intent.putExtra(ClubEntry._ID, _id);
                     intent.putExtra(ClubEntry.COLUMN_NAME_CLUBNAME, name);
                     intent.putExtra(ClubEntry.COLUMN_NAME_CTTY, city); 
                     intent.putExtra(ClubEntry.COLUMN_NAME_LEAGUE, league);
                     intent.putExtra(ClubEntry.COLUMN_NAME_YEAR_OF_FOUNDATION, founded);

                     startService(intent);
             }
		}
	}
	
	public void updatePlayer() {
		
		
		if (playerDialogFragment != null) {
			Dialog view = playerDialogFragment.getDialog();
			
			Player player = ((PlayerDialogue)playerDialogFragment).getPlayer();
			
			 int _id = player.getId();
             String name = ((EditText)view.findViewById(R.id.player_name_dlg)).getText().toString();
             String surname = ((EditText)view.findViewById(R.id.surname_dlg)).getText().toString();
             int age = Integer.parseInt(((EditText)view.findViewById(R.id.age_dlg)).getText().toString());
             int club = Integer.parseInt(((EditText)view.findViewById(R.id.player_club_dlg)).getText().toString());

             if (!player.getName().equals(name) || !player.getSurname().equals(surname) || 
                             !(player.getAge()== age) || !(player.getClub() == club)) {
            	 
                     Intent intent = new Intent(MainActivity.this, PlayerUpdateService.class);
                     intent.putExtra(PlayerEntry._ID, _id);
                     intent.putExtra(PlayerEntry.COLUMN_NAME_PLAYERNAME, name);
                     intent.putExtra(PlayerEntry.COLUMN_NAME_SURNAME, surname); 
                     intent.putExtra(PlayerEntry.COLUMN_NAME_AGE, age);
                     intent.putExtra(PlayerEntry.COLUMN_NAME_CLUB, club);

                     startService(intent);
             }
		}
	}
	

}
