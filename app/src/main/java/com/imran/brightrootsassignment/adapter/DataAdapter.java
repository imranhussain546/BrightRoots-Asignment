package com.imran.brightrootsassignment.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.imran.brightrootsassignment.database.Student;
import com.imran.brightrootsassignment.databinding.StudentcardBinding;
import com.imran.brightrootsassignment.model.StudentList;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.Viewholder> {
    StudentcardBinding binding;

    public List<Student> studentlist;
    Context context;

    public DataAdapter(List<Student> studentlist, Context context) {
        this.studentlist = studentlist;
        this.context = context;
    }



    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Viewholder(StudentcardBinding.inflate(LayoutInflater.from(context)));
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        final  Student student=studentlist.get(position);

        Log.d("adapterdata", "onBindViewHolder: "+student.getName());

        holder.binding.name.setText("Name:- "+student.getName());
        holder.binding.roll.setText("Roll:- "+student.getRoll());
        holder.binding.stream.setText("Stream:- "+"Roll"+student.getRoll());

    }

    @Override
    public int getItemCount() {
        return studentlist.size();
    }

    class Viewholder extends RecyclerView.ViewHolder{
        StudentcardBinding binding;
        public Viewholder(@NonNull StudentcardBinding itemView) {
            super(itemView.getRoot());
            binding=itemView;
        }
    }

}
