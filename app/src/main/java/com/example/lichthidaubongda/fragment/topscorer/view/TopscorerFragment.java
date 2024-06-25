package com.example.lichthidaubongda.fragment.topscorer.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.lichthidaubongda.databinding.FragmentTopscorerBinding;
import com.example.lichthidaubongda.fragment.topscorer.adapter.TopscorerAdapter;
import com.example.lichthidaubongda.fragment.topscorer.viewmodel.TopscorerViewModel;

public class TopscorerFragment extends Fragment {
    private TopscorerViewModel viewModel;
    private TopscorerAdapter topscorerAdapter;
    private FragmentTopscorerBinding binding;
    private ProgressDialog progressDialog;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTopscorerBinding.inflate(inflater, container, false);
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
        topscorerAdapter = new TopscorerAdapter();
        binding.rcvSchedule.setAdapter(topscorerAdapter);
    }

    private void initViewModel() {
        viewModel = new ViewModelProvider(this).get(TopscorerViewModel.class);
        getSchedulesAllMatchesML(); // Call this method directly to always show all matches.
    }

    private void getSchedulesAllMatchesML(){
        viewModel.getSchedulesAllMatchesML().observe(requireActivity(), topscorers -> {
            if (topscorers.size() == 0){
                progressDialog.show();
            } else {
                topscorerAdapter.submitList(topscorers);
                progressDialog.dismiss();
            }
        });
    }

}