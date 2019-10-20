
package com.israt.jahan.testbookreaderapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


@SuppressWarnings("unused")
public class BookData {

    @SerializedName("database_version")
    private Long mDatabaseVersion;
    @SerializedName("db_data")
    private List<Category> mDbData;

    public Long getDatabaseVersion() {
        return mDatabaseVersion;
    }

    public void setDatabaseVersion(Long databaseVersion) {
        mDatabaseVersion = databaseVersion;
    }

    public List<Category> getDbData() {
        return mDbData;
    }

    public void setDbData(List<Category> dbData) {
        mDbData = dbData;
    }

}
