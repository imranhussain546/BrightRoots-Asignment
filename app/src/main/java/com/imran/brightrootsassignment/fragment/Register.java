package com.imran.brightrootsassignment.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.room.Room;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.imran.brightrootsassignment.Constants;
import com.imran.brightrootsassignment.MainActivity;
import com.imran.brightrootsassignment.R;
import com.imran.brightrootsassignment.database.Database;
import com.imran.brightrootsassignment.database.MyDao;
import com.imran.brightrootsassignment.database.Student;
import com.imran.brightrootsassignment.databinding.FragmentRegisterBinding;

public class Register extends Fragment {

   FragmentRegisterBinding binding;
    private MyDao db;
    private MainActivity mainActivity;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding=FragmentRegisterBinding.inflate(inflater, container, false);
        mainActivity = (MainActivity) getActivity();
        db= Room.databaseBuilder(getActivity(), Database.class,"BrightRoot")
                .allowMainThreadQueries()
                .build().getStudentDao();
        spinner();
        submit();
        showrdata();
        return binding.getRoot();
    }



    private void spinner() {

        String [] gender={"Choose Stream","Science","commerce","Arts"};
        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_dropdown_item,gender);
        binding.stream.setAdapter(adapter);

    }
    private void submit() {
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateData())
                {
                    savedate();
                    Toast.makeText(getActivity(), " Save Record", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void showrdata() {

        binding.showdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StudentDataFragment studentDataFragment= new StudentDataFragment();
                mainActivity.replaceFragment(R.id.container_FL,studentDataFragment);
            }
        });
    }



    private boolean validateData(){
        if (binding.studentname.getText().length()== Constants.ZERO)
        {
            settingError(binding.studentname,getString(R.string.name_empty_error));
        }
        else if (binding.studentroll.getText().length()== Constants.ZERO)
        {
            settingError(binding.studentroll,getString(R.string.roll_empty_error));
        }
        else if (binding.stream.getSelectedItem()=="Choose Stream")
        {
            Snackbar snackbar = Snackbar
                    .make(getView(), "Please Choose Stream", Snackbar.LENGTH_LONG);
            snackbar.show();
        }
        else return true;

        return false;
    }
    private void settingError(EditText editText, String validationText) {
        editText.requestFocus();
        editText.setError(validationText);
    }
    private void savedate() {
        String name,roll,stream;
        name=binding.studentname.getText().toString();
        roll=binding.studentroll.getText().toString();
        stream=binding.stream.getSelectedItem().toString();

        Student student= new Student(name,roll,stream);
        db.inser(student);
        if (db.getstudent()!=null)
        {
            Snackbar snackbar = Snackbar
                    .make(getView(), "Register Succesfully 👍", Snackbar.LENGTH_LONG);
            snackbar.show();

        }
        else{
            Toast.makeText(getActivity(), "Something Wrong", Toast.LENGTH_SHORT).show();
        }

    }
}