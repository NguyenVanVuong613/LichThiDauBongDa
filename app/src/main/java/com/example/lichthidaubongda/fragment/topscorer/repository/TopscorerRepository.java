package com.example.lichthidaubongda.fragment.topscorer.repository;

import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.lichthidaubongda.fragment.chart.model.Chart;
import com.example.lichthidaubongda.fragment.topscorer.api.ApiSchedule;
import com.example.lichthidaubongda.fragment.topscorer.model.DataTopscorer;
import com.example.lichthidaubongda.fragment.topscorer.model.Topscorer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopscorerRepository {
    private MutableLiveData<List<Topscorer>> schedulesAllMatchesML;

    private List<Topscorer> topscorers = new ArrayList<>();

    public TopscorerRepository() {
        this.schedulesAllMatchesML = new MutableLiveData<>();
    }

    public MutableLiveData<List<Topscorer>> getSchedulesAllMatchesML() {
        setSchedulesAllMatchesML();
        return schedulesAllMatchesML;
    }

    public MutableLiveData<List<Topscorer>> getSchedulesNSMatchesML() {
        return schedulesAllMatchesML;
    }

    private void setSchedulesAllMatchesML(){
        ApiSchedule.apiSchedule.getListTopscorer().enqueue(new Callback<DataTopscorer>() {
            @Override
            public void onResponse(@NonNull Call<DataTopscorer> call, @NonNull Response<DataTopscorer> response) {
                Log.e("Dunno", "Schedule: Success");
                DataTopscorer dataTopscorer = response.body();

                if (dataTopscorer != null){
                    List<Topscorer> topscorers = dataTopscorer.getDataIdTopscorer().getIdToscorers().getTopscorers();
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        Collections.sort(topscorers, new Comparator<Topscorer>() {
                            @Override
                            public int compare(Topscorer t1, Topscorer t2) {
                                if (t1.getGoals().getTotal() == null && t2.getGoals().getTotal() == null) {
                                    return 0;
                                } else if (t1.getGoals().getTotal() == null) {
                                    return 1; // Null values are considered larger
                                } else if (t2.getGoals().getTotal() == null) {
                                    return -1; // Null values are considered larger
                                } else {
                                    // For non-null values, sort in descending order
                                    return t2.getGoals().getTotal().compareTo(t1.getGoals().getTotal());
                                }
                            }
                        });
                    }
                    schedulesAllMatchesML.postValue(topscorers);
                }
            }

            @Override
            public void onFailure(@NonNull Call<DataTopscorer> call, @NonNull Throwable t) {
                Log.e("Dunno", "Schedule: " + t);
            }
        });
        schedulesAllMatchesML.setValue(topscorers);
    }


}
