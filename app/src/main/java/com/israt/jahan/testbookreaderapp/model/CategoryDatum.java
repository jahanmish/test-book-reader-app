
package com.israt.jahan.testbookreaderapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;



public class CategoryDatum {

    @SerializedName("book_data")
    private List<Book> bookData;
    @SerializedName("category_id")
    private Long categoryId;
    @SerializedName("category_name")
    private String categoryName;

    public List<Book> getBookData() {
        return bookData;
    }

    public void setBookData(List<Book> bookData) {
        this.bookData = bookData;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}
