
package com.israt.jahan.testbookreaderapp.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


@Entity (tableName = "book")
public class Book implements Serializable {


    @PrimaryKey(autoGenerate = true)
    private int id = 0;

    @ColumnInfo (name = "book_author")
    @SerializedName("book_author")
    private String mBookAuthor;

    @ColumnInfo (name = "book_category")
    @SerializedName("book_category")
    private String mBookCategory;

    @ColumnInfo(name = "book_chapter")
    @SerializedName("bookChapter")
    private List<BookChapter> mBookChapter;

    @ColumnInfo (name = "book_id")
    @SerializedName("book_id")
    private Long mBookId;

    @ColumnInfo (name = "book_language")
    @SerializedName("book_language")
    private String mBookLanguage;

    @ColumnInfo (name = "book_name")
    @SerializedName("book_name")
    private String mBookName;

    @ColumnInfo (name = "book_path")
    @SerializedName("book_path")
    private String mBookPath=new String();

    @ColumnInfo (name = "book_ratings")
    @SerializedName("book_ratings")
    private Long mBookRatings;

    @ColumnInfo (name = "book_type")
    @SerializedName("book_type")
    private String mBookType;

    @ColumnInfo (name = "book_summary")
    @SerializedName("book_summary")
    private String mBookSummary;

    @ColumnInfo (name = "cover_path")
    @SerializedName("cover_path")
    private String mCoverPath;

    @ColumnInfo (name = "publisher_name")
    @SerializedName("publisher_name")
    private String mPublisherName;

    @ColumnInfo (name = "total_pages")
    @SerializedName("total_pages")
    private Long mTotalPages;

    public String getBookAuthor() {
        return mBookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        mBookAuthor = bookAuthor;
    }

    public String getBookCategory() {
        return mBookCategory;
    }

    public void setBookCategory(String bookCategory) {
        mBookCategory = bookCategory;
    }

    public List<BookChapter> getBookChapter() {
        return mBookChapter;
    }

    public void setBookChapter(List<BookChapter> bookChapter) {
        mBookChapter = bookChapter;
    }

    public Long getBookId() {
        return mBookId;
    }

    public void setBookId(Long bookId) {
        mBookId = bookId;
    }

    public String getBookLanguage() {
        return mBookLanguage;
    }

    public void setBookLanguage(String bookLanguage) {
        mBookLanguage = bookLanguage;
    }

    public String getBookName() {
        return mBookName;
    }

    public void setBookName(String bookName) {
        mBookName = bookName;
    }

    public String getBookPath() {
        return mBookPath;
    }

    public void setBookPath(String bookPath) {
        mBookPath = bookPath;
    }

    public Long getBookRatings() {
        return mBookRatings;
    }

    public void setBookRatings(Long bookRatings) {
        mBookRatings = bookRatings;
    }

    public String getBookType() {
        return mBookType;
    }

    public void setBookType(String bookType) {
        mBookType = bookType;
    }


    public String getBookSummary() {
        return mBookSummary;
    }

    public void setBookSummary(String bookSummary) {
        mBookSummary = bookSummary;
    }



    public String getCoverPath() {
        return mCoverPath;
    }

    public void setCoverPath(String coverPath) {
        mCoverPath = coverPath;
    }

    public String getPublisherName() {
        return mPublisherName;
    }

    public void setPublisherName(String publisherName) {
        mPublisherName = publisherName;
    }

    public Long getTotalPages() {
        return mTotalPages;
    }

    public void setTotalPages(Long totalPages) {
        mTotalPages = totalPages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
