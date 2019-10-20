package com.israt.jahan.testbookreaderapp.ui.new_book;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NewBookViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public NewBookViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is new book fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}