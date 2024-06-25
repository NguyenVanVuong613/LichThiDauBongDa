package com.example.lichthidaubongda.fragment.topassist.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.lichthidaubongda.R;
import com.example.lichthidaubongda.databinding.ItemRcvTopassistBinding;
import com.example.lichthidaubongda.fragment.topassist.model.Topassist;

public class TopassistAdapter extends ListAdapter<Topassist, TopassistAdapter.ScheduleAdapterVH> {

    public TopassistAdapter() {
        super(Topassist.SCHEDULE_DIFF_UTIL);
    }

    @NonNull
    @Override
    public ScheduleAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRcvTopassistBinding itemRcvTopassistBinding = ItemRcvTopassistBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ScheduleAdapterVH(itemRcvTopassistBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleAdapterVH holder, int position) {
        if (getItem(position) == null) {
            return;
        }
        holder.bindData(getItem(position));
    }

    public static class ScheduleAdapterVH extends RecyclerView.ViewHolder {

        private final ItemRcvTopassistBinding itemBinding;

        public ScheduleAdapterVH(ItemRcvTopassistBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }

        @SuppressLint("SetTextI18n")
        public void bindData(Topassist item) {
            itemBinding.tvTeam.setText(item.getTeamName());
            itemBinding.tvPlayer.setText(item.getPlayerName());
            itemBinding.tvAssist.setText("assist: "+ item.getGoals().getAssists());
            Glide.with(itemView.getContext()).load(item.getLogoTeam()).into(itemBinding.imgTeam);
            Animation animation = AnimationUtils.loadAnimation(itemView.getContext(), R.anim.scale_alpha);
            itemView.startAnimation(animation);
        }
    }

}
