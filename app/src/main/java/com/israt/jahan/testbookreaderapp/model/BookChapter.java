
package com.israt.jahan.testbookreaderapp.model;

import java.io.Serializable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;


@Entity(tableName = "bookChapter", foreignKeys = @ForeignKey(entity = Book.class,
        parentColumns = "id",
        childColumns = "bookId",
        onDelete = CASCADE))
public class BookChapter implements Serializable {

    @PrimaryKey(autoGenerate = true)
    public  int id;
    public  String name;
    public  String url;

    @ColumnInfo(index = true)
    public int bookId;

    @ColumnInfo(name = "chapterName")
    private String chapterName;


    @ColumnInfo(name = "chapterPage")
    private String chapterPage;

    public int getId() {
        return id;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getChapterPage() {
        return chapterPage;
    }

    public void setChapterPage(String chapterPage) {
        this.chapterPage = chapterPage;
    }



}
