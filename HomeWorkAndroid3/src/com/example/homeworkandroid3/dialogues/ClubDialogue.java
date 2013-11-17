package com.example.homeworkandroid3.dialogues;

import com.example.homeworkandroid3.R;
import com.example.homeworkandroid3.R.layout;
import com.example.homeworkandroid3.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.Menu;

public class ClubDialogue extends DialogFragment {
	public interface ClubDialogListener {
		public void onClubDialogPositiveClick(DialogFragment dialog);
		public void onClubDialogNegativeClick(DialogFragment dialog);
	}
	ClubDialogListener clubDialogListener;
	
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
		builder.setView(inflater.inflate(R.layout.club_dialogue, null))
						.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								// TODO Auto-generated method stub
								
							}
						})
						.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								// TODO Auto-generated method stub
								
							}
						});
		return builder.create();
	}
}
