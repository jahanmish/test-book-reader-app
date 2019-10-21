
package com.israt.jahan.testbookreaderapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "book")
public class Book implements Serializable {


    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "book_id")
    @SerializedName("book_id")
    int bookId;


    @ColumnInfo(name = "book_author")
    @SerializedName("book_author")
    String bookAuthor;

    @ColumnInfo(name = "book_category")
    @SerializedName("book_category")
    String bookCategory;


    @Ignore
    List<BookChapter> bookChapter ;


    @ColumnInfo(name = "book_language")
    @SerializedName("book_language")
    String bookLanguage;

    @ColumnInfo(name = "book_name")
    @SerializedName("book_name")
    String bookName;

    @ColumnInfo(name = "book_path")
    @SerializedName("book_path")
    String bookPath;

    @ColumnInfo(name = "book_ratings")
    @SerializedName("book_ratings")
    Long bookRatings;

    @ColumnInfo(name = "book_summery")
    @SerializedName("book_summery")
    String bookSummery;

    @ColumnInfo(name = "book_type")
    @SerializedName("book_type")
    String bookType;

    @ColumnInfo(name = "category_id")
    @SerializedName("category_id")
    Long categoryId;

    @ColumnInfo(name = "cover_path")
    @SerializedName("cover_path")
    String coverPath;

    @ColumnInfo(name = "publisher_name")
    @SerializedName("publisher_name")
    String publisherName;

    @ColumnInfo(name = "total_pages")
    @SerializedName("total_pages")
    Long totalPages;


    public Book(int id) {
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    public String getBookLanguage() {
        return bookLanguage;
    }

    public void setBookLanguage(String bookLanguage) {
        this.bookLanguage = bookLanguage;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookPath() {
        return bookPath;
    }

    public void setBookPath(String bookPath) {
        this.bookPath = bookPath;
    }

    public Long getBookRatings() {
        return bookRatings;
    }

    public void setBookRatings(Long bookRatings) {
        this.bookRatings = bookRatings;
    }

    public String getBookSummery() {
        return bookSummery;
    }

    public void setBookSummery(String bookSummery) {
        this.bookSummery = bookSummery;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCoverPath() {
        return coverPath;
    }

    public void setCoverPath(String coverPath) {
        this.coverPath = coverPath;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public Long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
    }

    public Book() {
    }



}
