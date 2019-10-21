
package com.israt.jahan.testbookreaderapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


@SuppressWarnings("unused")
public class CategoryDatum {

    @SerializedName("book_data")
    private List<BookDatum> bookData;
    @SerializedName("category_id")
    private Long categoryId;
    @SerializedName("category_name")
    private String categoryName;

    public List<BookDatum> getBookData() {
        return bookData;
    }

    public void setBookData(List<BookDatum> bookData) {
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
