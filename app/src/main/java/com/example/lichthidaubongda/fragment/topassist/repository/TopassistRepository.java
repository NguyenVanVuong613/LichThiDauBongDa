package com.example.lichthidaubongda.fragment.topassist.repository;

import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.lichthidaubongda.fragment.topassist.api.ApiSchedule;
import com.example.lichthidaubongda.fragment.topassist.model.DataTopassist;
import com.example.lichthidaubongda.fragment.topassist.model.Topassist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopassistRepository {
    private MutableLiveData<List<Topassist>> schedulesAllMatchesML;

    private List<Topassist> topassists = new ArrayList<>();

    public TopassistRepository() {
        this.schedulesAllMatchesML = new MutableLiveData<>();
    }

    public MutableLiveData<List<Topassist>> getSchedulesAllMatchesML() {
        setSchedulesAllMatchesML();
        return schedulesAllMatchesML;
    }

    public MutableLiveData<List<Topassist>> getSchedulesNSMatchesML() {
        return schedulesAllMatchesML;
    }

    private void setSchedulesAllMatchesML(){
        ApiSchedule.apiSchedule.getListTopassist().enqueue(new Callback<DataTopassist>() {
            @Override
            public void onResponse(@NonNull Call<DataTopassist> call, @NonNull Response<DataTopassist> response) {
                Log.e("Dunno", "Schedule: Success");
                DataTopassist dataTopassist = response.body();

                if (dataTopassist != null){
                    List<Topassist> topassists = dataTopassist.getDataIdTopscorer().getIdTopassistss().getTopassists();
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        Collections.sort(topassists, new Comparator<Topassist>() {
                            @Override
                            public int compare(Topassist t1, Topassist t2) {
                                if (t1.getGoals().getAssists() == null && t2.getGoals().getAssists() == null) {
                                    return 0;
                                } else if (t1.getGoals().getAssists() == null) {
                                    return 1; // Null values are considered larger
                                } else if (t2.getGoals().getAssists() == null) {
                                    return -1; // Null values are considered larger
                                } else {
                                    // For non-null values, sort in descending order
                                    return t2.getGoals().getAssists().compareTo(t1.getGoals().getAssists());
                                }
                            }
                        });
                    }
                    schedulesAllMatchesML.postValue(topassists);
                }
            }

            @Override
            public void onFailure(@NonNull Call<DataTopassist> call, @NonNull Throwable t) {
                Log.e("Dunno", "Schedule: " + t);
            }
        });
        schedulesAllMatchesML.setValue(topassists);
    }


}
