package com.example.menuprieto;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class MyDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Dialog Title")
                .setMessage("This is the message of the dialog.")
                .setPositiveButton("Positive", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Handle positive button action
                    }
                })
                .setNegativeButton("Negative", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Handle negative button action
                    }
                });
        return builder.create();
    }
}
