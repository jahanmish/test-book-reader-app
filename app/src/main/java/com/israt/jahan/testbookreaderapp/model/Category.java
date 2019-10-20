
package com.israt.jahan.testbookreaderapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


@SuppressWarnings("unused")
public class Category {

    @SerializedName("category_data")
    private List<CategoryDatum> mCategoryData;
    @SerializedName("category_id")
    private String mCategoryId;
    @SerializedName("category_name")
    private String mCategoryName;

    public List<CategoryDatum> getCategoryData() {
        return mCategoryData;
    }

    public void setCategoryData(List<CategoryDatum> categoryData) {
        mCategoryData = categoryData;
    }

    public String getCategoryId() {
        return mCategoryId;
    }

    public void setCategoryId(String categoryId) {
        mCategoryId = categoryId;
    }

    public String getCategoryName() {
        return mCategoryName;
    }

    public void setCategoryName(String categoryName) {
        mCategoryName = categoryName;
    }

}
