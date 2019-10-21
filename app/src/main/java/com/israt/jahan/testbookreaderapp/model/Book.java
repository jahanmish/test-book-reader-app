
package com.israt.jahan.testbookreaderapp.model;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


@Entity(tableName = "book")
public class Book  implements Serializable {


    @PrimaryKey(autoGenerate = true)
    private int id = 0;


    @ColumnInfo(name = "book_author")
    @SerializedName("book_author")
    private String bookAuthor;

    @ColumnInfo (name = "book_category")
    @SerializedName("book_category")
    private String bookCategory;

//    @ColumnInfo (name = "book_chapter")
    @Expose
    @Embedded
    private List<BookChapter> bookChapter;

    @ColumnInfo (name = "book_id")
    @SerializedName("book_id")
    private Long bookId;

    @ColumnInfo (name = "book_language")
    @SerializedName("book_language")
    private String bookLanguage;

    @ColumnInfo (name = "book_name")
    @SerializedName("book_name")
    private String bookName;

    @ColumnInfo (name = "book_path")
    @SerializedName("book_path")
    private String bookPath;

    @ColumnInfo (name = "book_ratings")
    @SerializedName("book_ratings")
    private Long bookRatings;

    @ColumnInfo (name = "book_summery")
    @SerializedName("book_summery")
    private String bookSummery;

    @ColumnInfo (name = "book_type")
    @SerializedName("book_type")
    private String bookType;

    @ColumnInfo (name = "category_id")
    @SerializedName("category_id")
    private Long categoryId;

    @ColumnInfo (name = "cover_path")
    @SerializedName("cover_path")
    private String coverPath;

    @ColumnInfo (name = "publisher_name")
    @SerializedName("publisher_name")
    private String publisherName;

    @ColumnInfo (name = "total_pages")
    @SerializedName("total_pages")
    private Long totalPages;




    public Book(int id, String bookAuthor, String bookCategory, List<BookChapter> bookChapter, Long bookId, String bookLanguage, String bookName, String bookPath, Long bookRatings, String bookSummery, String bookType, Long categoryId, String coverPath, String publisherName, Long totalPages) {
        this.id = id;
        this.bookAuthor = bookAuthor;
        this.bookCategory = bookCategory;
        this.bookChapter = bookChapter;
        this.bookId = bookId;
        this.bookLanguage = bookLanguage;
        this.bookName = bookName;
        this.bookPath = bookPath;
        this.bookRatings = bookRatings;
        this.bookSummery = bookSummery;
        this.bookType = bookType;
        this.categoryId = categoryId;
        this.coverPath = coverPath;
        this.publisherName = publisherName;
        this.totalPages = totalPages;
    }

    public Book() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<BookChapter> getBookChapter() {
        return bookChapter;
    }

    public void setBookChapter(List<BookChapter> bookChapter) {
        this.bookChapter = bookChapter;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
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
}
