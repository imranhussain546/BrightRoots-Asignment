package com.imran.brightrootsassignment.database;

import androidx.room.RoomDatabase;
@androidx.room.Database(entities = {Student.class},version = 1)
public abstract class Database  extends RoomDatabase {

    public abstract MyDao getStudentDao();
}
