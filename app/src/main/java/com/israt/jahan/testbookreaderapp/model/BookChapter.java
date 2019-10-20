
package com.israt.jahan.testbookreaderapp.model;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


@SuppressWarnings("unused")
public class BookChapter implements Serializable {

    @SerializedName("chapterName")
    private String mChapterName;
    @SerializedName("chapterPage")
    private String mChapterPage;

    public String getChapterName() {
        return mChapterName;
    }

    public void setChapterName(String chapterName) {
        mChapterName = chapterName;
    }

    public String getChapterPage() {
        return mChapterPage;
    }

    public void setChapterPage(String chapterPage) {
        mChapterPage = chapterPage;
    }

}
