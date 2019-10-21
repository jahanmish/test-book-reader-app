
package com.israt.jahan.testbookreaderapp.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@Entity(tableName = "bookChapter")
public class BookChapter {

    @PrimaryKey(autoGenerate = true)
    private int id = 0;

    @ColumnInfo(name = "book_id")
    @SerializedName("book_id")
    private Long bookId;

    @ColumnInfo(name = "chapterName")
    @Expose
    private String chapterName;

    @Expose
    @ColumnInfo(name = "chapterPage")
    private String chapterPage;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
