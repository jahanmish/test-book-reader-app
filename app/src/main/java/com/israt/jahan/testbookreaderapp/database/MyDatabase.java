package com.israt.jahan.testbookreaderapp.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.israt.jahan.testbookreaderapp.model.Book;
import com.israt.jahan.testbookreaderapp.model.BookChapter;

@Database(entities = {Book.class, BookChapter.class},version = 1)
public abstract class MyDatabase extends RoomDatabase {

    public abstract MyBookDao getBookDao();

}
