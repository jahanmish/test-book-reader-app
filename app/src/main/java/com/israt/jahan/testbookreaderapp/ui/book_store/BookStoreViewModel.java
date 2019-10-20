package com.israt.jahan.testbookreaderapp.ui.book_store;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BookStoreViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public BookStoreViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is book store fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}