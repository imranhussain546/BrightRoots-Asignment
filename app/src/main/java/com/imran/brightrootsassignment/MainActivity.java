package com.imran.brightrootsassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.imran.brightrootsassignment.databinding.ActivityMainBinding;
import com.imran.brightrootsassignment.fragment.Register;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Register registerFragment= new Register();
        addFragment(R.id.container_FL,registerFragment);
    }


    public void addFragment(int replaceId, Fragment fragment) {
        try {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(replaceId, fragment);
            ft.commit();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void replaceFragment(int replaceId, Fragment replaceFragment)
    {
        try {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(replaceId,replaceFragment);
            ft.addToBackStack(null);
            ft.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}