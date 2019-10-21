
package com.israt.jahan.testbookreaderapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


@SuppressWarnings("unused")
public class BookData {

    @SerializedName("database_version")
    private Long databaseVersion;
    @SerializedName("db_data")
    private List<DbDatum> dbData;

    public Long getDatabaseVersion() {
        return databaseVersion;
    }

    public void setDatabaseVersion(Long databaseVersion) {
        this.databaseVersion = databaseVersion;
    }

    public List<DbDatum> getDbData() {
        return dbData;
    }

    public void setDbData(List<DbDatum> dbData) {
        this.dbData = dbData;
    }

}
