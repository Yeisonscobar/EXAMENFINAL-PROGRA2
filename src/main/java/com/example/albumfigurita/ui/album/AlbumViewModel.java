package com.example.albumfigurita.ui.album;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AlbumViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AlbumViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Contenido del album");
    }

    public LiveData<String> getText() {
        return mText;
    }
}