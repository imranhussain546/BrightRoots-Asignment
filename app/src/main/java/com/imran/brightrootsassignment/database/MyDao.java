package com.imran.brightrootsassignment.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface MyDao {

    @Insert
    public void inser(Student student);

    @Query("select * from Student")
    List<Student> getstudent();

    @Query("select * from student where name= :name")
            List<Student> getsinglestudent(String name);


}
