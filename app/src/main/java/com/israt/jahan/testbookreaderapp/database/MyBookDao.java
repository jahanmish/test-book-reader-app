package com.israt.jahan.testbookreaderapp.database;

import com.israt.jahan.testbookreaderapp.model.Book;
import com.israt.jahan.testbookreaderapp.model.BookChapter;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface MyBookDao {

    @Insert
    void insert(BookChapter character);

    @Insert
    void insert(Book book);



}
