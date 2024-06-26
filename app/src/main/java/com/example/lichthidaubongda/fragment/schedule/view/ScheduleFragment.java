package com.example.lichthidaubongda.fragment.schedule.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.lichthidaubongda.databinding.FragmentScheduleBinding;
import com.example.lichthidaubongda.fragment.schedule.adapter.ScheduleAdapter;
import com.example.lichthidaubongda.fragment.schedule.viewmodel.ScheduleViewModel;

import java.util.ArrayList;
import java.util.List;

public class ScheduleFragment extends Fragment {
    private ScheduleViewModel viewModel;
    private ScheduleAdapter scheduleAdapter;
    private FragmentScheduleBinding binding;
    private ProgressDialog progressDialog;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentScheduleBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initAction();
    }

    private void initAction() {
        // Removed the spinner item selection listener as filtering is not required.
    }
    private void initView() {
        progressDialog = new ProgressDialog(requireContext());
        initAdapter();
        initViewModel();
        // Removed the call to initSpinner() as it's no longer needed.
    }


    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext());
        binding.rcvSchedule.setLayoutManager(linearLayoutManager);
        scheduleAdapter = new ScheduleAdapter();
        binding.rcvSchedule.setAdapter(scheduleAdapter);
    }

    private void initViewModel() {
        viewModel = new ViewModelProvider(this).get(ScheduleViewModel.class);
        getSchedulesAllMatchesML(); // Call this method directly to always show all matches.
    }

    private void getSchedulesAllMatchesML(){
        viewModel.getSchedulesAllMatchesML().observe(requireActivity(), schedules -> {
            if (schedules.size() == 0){
                progressDialog.show();
            } else {
                scheduleAdapter.submitList(schedules);
                progressDialog.dismiss();
            }
        });
    }

    private void getSchedulesNSMatchesML(){
        viewModel.getSchedulesNSMatchesML().observe(requireActivity(), schedules -> {
            if (schedules.size() == 0){
                progressDialog.show();
            } else {
                scheduleAdapter.submitList(schedules);
                progressDialog.dismiss();
            }
        });
    }

}