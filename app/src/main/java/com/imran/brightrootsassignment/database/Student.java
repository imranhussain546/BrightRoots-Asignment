package com.imran.brightrootsassignment.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "student")
public class Student {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private String name;
    private String roll;
    private String stream;

    public Student(String name, String roll, String stream) {
        this.name = name;
        this.roll = roll;
        this.stream = stream;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }
}
