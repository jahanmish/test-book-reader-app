
package com.israt.jahan.testbookreaderapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class DbDatum {

    @SerializedName("category_data")
    private List<CategoryDatum> categoryData;
    @SerializedName("category_id")
    private Long categoryId;
    @SerializedName("category_name")
    private String categoryName;

    public List<CategoryDatum> getCategoryData() {
        return categoryData;
    }

    public void setCategoryData(List<CategoryDatum> categoryData) {
        this.categoryData = categoryData;
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
