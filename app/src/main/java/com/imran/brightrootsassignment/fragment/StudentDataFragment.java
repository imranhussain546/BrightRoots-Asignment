package com.imran.brightrootsassignment.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.room.Room;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SearchView;
import android.widget.Toast;

import com.imran.brightrootsassignment.R;
import com.imran.brightrootsassignment.adapter.DataAdapter;
import com.imran.brightrootsassignment.database.Database;
import com.imran.brightrootsassignment.database.MyDao;
import com.imran.brightrootsassignment.database.Student;
import com.imran.brightrootsassignment.databinding.FragmentStudentDataBinding;
import com.imran.brightrootsassignment.model.StudentList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentDataFragment extends Fragment {
    FragmentStudentDataBinding binding;
    private MyDao db;
    List<Student> student;
    DataAdapter dataAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentStudentDataBinding.inflate(inflater, container, false);

        db = Room.databaseBuilder(getActivity(), Database.class, "BrightRoot")
                .allowMainThreadQueries()
                .build().getStudentDao();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(layoutManager.VERTICAL);
        binding.recycler.setLayoutManager(layoutManager);
        showdata();
        searchview();

        return binding.getRoot();
    }


    private void showdata() {

        student = db.getstudent();
        Collections.sort(student, new Comparator<Student>() {
            @Override
            public int compare(Student student, Student t1) {
                return student.getName().compareTo(t1.getName());
            }
        });
        Log.d("showdataaa", "showdata: " + student.get(0).getName());

        // Log.d("showdataa", "showdata: "+llist.get(1).getName());
        dataAdapter = new DataAdapter(student, getContext());
        binding.recycler.setAdapter(dataAdapter);
    }

    private void searchview() {

        binding.searchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (s.length() > 0)
                {
                    getdata(s);
                }
                return false;
            }
        });

    }

    private void getdata(String s) {

        List<Student> students=db.getsinglestudent(s);
        DataAdapter dataAdapter= new DataAdapter(students,getContext());
        binding.recycler.setAdapter(dataAdapter);

    }



}