package com.example.lichthidaubongda.fragment.topscorer.adapter;

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
import com.example.lichthidaubongda.databinding.ItemRcvTopscorerBinding;
import com.example.lichthidaubongda.fragment.topscorer.model.Topscorer;

public class TopscorerAdapter extends ListAdapter<Topscorer, TopscorerAdapter.ScheduleAdapterVH> {

    public TopscorerAdapter() {
        super(Topscorer.SCHEDULE_DIFF_UTIL);
    }

    @NonNull
    @Override
    public ScheduleAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRcvTopscorerBinding itemRcvTopscorerBinding = ItemRcvTopscorerBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ScheduleAdapterVH(itemRcvTopscorerBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleAdapterVH holder, int position) {
        if (getItem(position) == null) {
            return;
        }
        holder.bindData(getItem(position));
    }

    public static class ScheduleAdapterVH extends RecyclerView.ViewHolder {

        private final ItemRcvTopscorerBinding itemBinding;

        public ScheduleAdapterVH(ItemRcvTopscorerBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }

        @SuppressLint("SetTextI18n")
        public void bindData(Topscorer item) {
            itemBinding.tvTeam1.setText(item.getTeamName());
            itemBinding.tvTime.setText( item.getPlayerName());
            itemBinding.tvDate.setText("scorer: "+ item.getGoals().getTotal());
            Glide.with(itemView.getContext()).load(item.getLogoTeam()).into(itemBinding.imgTeam1);
            Animation animation = AnimationUtils.loadAnimation(itemView.getContext(), R.anim.scale_alpha);
            itemView.startAnimation(animation);
        }
    }

}
