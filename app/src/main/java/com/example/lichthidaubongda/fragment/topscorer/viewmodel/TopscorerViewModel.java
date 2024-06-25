package com.example.lichthidaubongda.fragment.topscorer.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.lichthidaubongda.fragment.topscorer.model.Topscorer;
import com.example.lichthidaubongda.fragment.topscorer.repository.TopscorerRepository;

import java.util.List;

public class TopscorerViewModel extends ViewModel {
    private final TopscorerRepository repository;

    public TopscorerViewModel() {
        repository = new TopscorerRepository();
    }

    public MutableLiveData<List<Topscorer>> getSchedulesAllMatchesML() {
        return repository.getSchedulesAllMatchesML();
    }
}

