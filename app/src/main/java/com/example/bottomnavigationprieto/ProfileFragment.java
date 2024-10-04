package com.example.bottomnavigationprieto;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    private EditText editTextName;
    private RadioGroup radioGroupGender;
    private RadioButton radioMale, radioFemale, radioOther;
    private CheckBox checkBoxMusic, checkBoxSports, checkBoxTravel;
    private Button buttonSave;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Initialize views
        editTextName = view.findViewById(R.id.editTextName);
        radioGroupGender = view.findViewById(R.id.radioGroupGender);
        radioMale = view.findViewById(R.id.radioMale);
        radioFemale = view.findViewById(R.id.radioFemale);
        radioOther = view.findViewById(R.id.radioOther);
        checkBoxMusic = view.findViewById(R.id.checkBoxMusic);
        checkBoxSports = view.findViewById(R.id.checkBoxSports);
        checkBoxTravel = view.findViewById(R.id.checkBoxTravel);
        buttonSave = view.findViewById(R.id.buttonSave);

        // Set save button click listener
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveProfile();
            }
        });

        return view;
    }

    // Method to save profile details
    private void saveProfile() {
        String name = editTextName.getText().toString();
        String gender = getSelectedGender();
        StringBuilder interests = new StringBuilder();

        if (checkBoxMusic.isChecked()) {
            interests.append("Music ");
        }
        if (checkBoxSports.isChecked()) {
            interests.append("Sports ");
        }
        if (checkBoxTravel.isChecked()) {
            interests.append("Travel ");
        }

        // Handle empty name
        if (name.isEmpty()) {
            Toast.makeText(getActivity(), "Please enter your name", Toast.LENGTH_SHORT).show();
            return;
        }

        // Show a confirmation message
        String message = "Name: " + name + "\n" +
                "Gender: " + gender + "\n" +
                "Interests: " + interests.toString().trim();
        Toast.makeText(getActivity(), "Profile Saved:\n" + message, Toast.LENGTH_LONG).show();
    }

    // Method to get the selected gender from RadioGroup
    private String getSelectedGender() {
        int selectedId = radioGroupGender.getCheckedRadioButtonId();
        if (selectedId == radioMale.getId()) {
            return "Male";
        } else if (selectedId == radioFemale.getId()) {
            return "Female";
        } else if (selectedId == radioOther.getId()) {
            return "Other";
        }
        return "Unspecified";
    }
}