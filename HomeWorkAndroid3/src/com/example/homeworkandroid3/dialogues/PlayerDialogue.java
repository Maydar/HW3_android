package com.example.homeworkandroid3.dialogues;

import com.example.homeworkandroid3.R;
import com.example.homeworkandroid3.R.layout;
import com.example.homeworkandroid3.R.menu;
import com.example.homeworkandroid3.database.Club;
import com.example.homeworkandroid3.database.Player;

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

public class PlayerDialogue extends DialogFragment {
	public interface PlayerDialogListener {
		public void onPlayerDialogPositiveClick(DialogFragment dialog);
		public void onPlayerDialogNegativeClick(DialogFragment dialog);
	}
	PlayerDialogListener playerDialogListener;
	private Player player;
	
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		try {
            playerDialogListener = (PlayerDialogListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement playerDialogListener");
        }
	}
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = getActivity().getLayoutInflater();
		
		View view = inflater.inflate(R.layout.player_dialogue, null);
		
		Bundle arguments = getArguments();
		player = new Player(arguments.getInt("ID"), arguments.getString("NAME"), arguments.getString("SURNAME"), arguments.getInt("AGE"), 
				arguments.getInt("CLUB"));
		
		EditText name = (EditText) view.findViewById(R.id.player_name_dlg);
		name.setText(player.getName());
		
		EditText surname = (EditText) view.findViewById(R.id.surname_dlg);
		surname.setText(player.getSurname());
		
		EditText age = (EditText) view.findViewById(R.id.age_dlg);
		age.setText(String.valueOf(player.getAge()));
		
		EditText club = (EditText) view.findViewById(R.id.player_club_dlg);
		club.setText(String.valueOf(player.getClub()));
		
		builder.setView(view)
						.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								playerDialogListener.onPlayerDialogPositiveClick(PlayerDialogue.this);
								
							}
						})
						.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								playerDialogListener.onPlayerDialogNegativeClick(PlayerDialogue.this);
								
							}
						});
		return builder.create();
	}
	public Player getPlayer() {
		return player;
	}


}
