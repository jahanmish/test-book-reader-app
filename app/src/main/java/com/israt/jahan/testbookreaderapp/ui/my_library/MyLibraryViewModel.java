package com.israt.jahan.testbookreaderapp.ui.my_library;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyLibraryViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MyLibraryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}