
package com.israt.jahan.testbookreaderapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


@SuppressWarnings("unused")
public class BookDatum implements Serializable {

    @SerializedName("book_author")
    private String mBookAuthor;
    @SerializedName("book_category")
    private String mBookCategory;
    @SerializedName("bookChapter")
    private List<BookChapter> mBookChapter;
    @SerializedName("book_id")
    private Long mBookId;
    @SerializedName("book_language")
    private String mBookLanguage;
    @SerializedName("book_name")
    private String mBookName;
    @SerializedName("book_path")
    private String mBookPath=new String();
    @SerializedName("book_ratings")
    private Long mBookRatings;
    @SerializedName("book_type")
    private String mBookType;
    @SerializedName("book_summary")
    private String mBookSummary;
    @SerializedName("cover_path")
    private String mCoverPath;
    @SerializedName("publisher_name")
    private String mPublisherName;
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

}
