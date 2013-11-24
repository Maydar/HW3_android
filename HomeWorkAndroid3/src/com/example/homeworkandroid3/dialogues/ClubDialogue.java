package com.example.homeworkandroid3.dialogues;

import com.example.homeworkandroid3.R;
import com.example.homeworkandroid3.R.layout;
import com.example.homeworkandroid3.R.menu;
import com.example.homeworkandroid3.database.Club;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class ClubDialogue extends DialogFragment {
	public interface ClubDialogListener {
		public void onClubDialogPositiveClick(DialogFragment dialog);
		public void onClubDialogNegativeClick(DialogFragment dialog);
	}
	ClubDialogListener clubDialogListener;
	private Club club;
	
	
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		try {
            clubDialogListener = (ClubDialogListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement ClubDialogListener");
        }
	}
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = getActivity().getLayoutInflater();
		
		View view = inflater.inflate(R.layout.club_dialogue, null);
		
		Bundle arguments = getArguments();
		club = new Club(arguments.getInt("ID"), arguments.getString("NAME"), arguments.getString("CITY"), arguments.getString("LEAGUE"), 
				arguments.getInt("FOUNDED"));
		
		EditText name = (EditText) view.findViewById(R.id.club_name_dlg);
		name.setText(club.getName());
		
		EditText city = (EditText) view.findViewById(R.id.city_dlg);
		city.setText(club.getCity());
		
		EditText league = (EditText) view.findViewById(R.id.league_dlg);
		league.setText(club.getLeague());
		
		EditText founded = (EditText) view.findViewById(R.id.year_found_dlg);
		founded.setText(String.valueOf(club.getYearOfFoundation()));
		
		
		builder.setView(view)
						.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								clubDialogListener.onClubDialogPositiveClick(ClubDialogue.this);
								
							}
						})
						.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								clubDialogListener.onClubDialogNegativeClick(ClubDialogue.this);
								
							}
						});
		return builder.create();
	}
	
	public Club getClub() {
		return club;
	}
}
