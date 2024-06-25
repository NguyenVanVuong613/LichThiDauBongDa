package com.example.lichthidaubongda.fragment.topassist.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.lichthidaubongda.fragment.topassist.model.Topassist;
import com.example.lichthidaubongda.fragment.topassist.repository.TopassistRepository;

import java.util.List;

public class TopassistViewModel extends ViewModel {
    private final TopassistRepository repository;

    public TopassistViewModel() {
        repository = new TopassistRepository();
    }

    public MutableLiveData<List<Topassist>> getSchedulesAllMatchesML() {
        return repository.getSchedulesAllMatchesML();
    }
}

