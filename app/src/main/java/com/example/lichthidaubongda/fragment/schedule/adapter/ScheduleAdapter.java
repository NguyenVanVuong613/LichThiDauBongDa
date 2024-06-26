package com.example.lichthidaubongda.fragment.schedule.adapter;

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
import com.example.lichthidaubongda.databinding.ItemRcvScheduleBinding;
import com.example.lichthidaubongda.fragment.schedule.model.Schedule;
import com.example.lichthidaubongda.object.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScheduleAdapter extends ListAdapter<Schedule, ScheduleAdapter.ScheduleAdapterVH> {

    public ScheduleAdapter() {
        super(Schedule.SCHEDULE_DIFF_UTIL);
    }

    @NonNull
    @Override
    public ScheduleAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRcvScheduleBinding itemRcvScheduleBinding = ItemRcvScheduleBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ScheduleAdapterVH(itemRcvScheduleBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleAdapterVH holder, int position) {
        if (getItem(position) == null) {
            return;
        }
        holder.bindData(getItem(position));
    }

    public static class ScheduleAdapterVH extends RecyclerView.ViewHolder {

        private final ItemRcvScheduleBinding itemBinding;

        public ScheduleAdapterVH(ItemRcvScheduleBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }

        @SuppressLint("SetTextI18n")
        public void bindData(Schedule item) {
            Glide.with(itemView.getContext()).load(item.getHomeTeam().getLogo()).into(itemBinding.imgTeam1);
            Glide.with(itemView.getContext()).load(item.getAwayTeam().getLogo()).into(itemBinding.imgTeam2);
            itemBinding.tvTeam1.setText(item.getHomeTeam().getTeamName());
            itemBinding.tvTeam2.setText(item.getAwayTeam().getTeamName());
            if (item.getStatus().equals("FT")){
                String strDate = item.getDateTime();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                Date convertedDate = new Date();
                try {
                    convertedDate = dateFormat.parse(strDate);
                    SimpleDateFormat sdfnewformat = new SimpleDateFormat("HH:mm/dd-MM-yyyy  ");
                    String finalDateString = sdfnewformat.format(convertedDate);
                    itemBinding.tvEvent.setText(finalDateString);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                itemBinding.tvDate.setText(item.getStatus());
                itemBinding.tvTime.setText(item.getScore().getFullTime());

            } else {
                String dateTime = item.getDateTime();
                String[] fields = dateTime.split("T");
                String date = fields[0];
                String[] times = fields[1].split("\\+");
                String time = times[0].substring(0, 5);
                DateTime dt = new DateTime(date, time);
                String[] dts = dt.toString().split(" ");
                String d = dts[0];
                String t = dts[1];

                itemBinding.tvTime.setText(t);
                itemBinding.tvDate.setText(d);
            }
            itemBinding.tvRound.setText("Round: " + item.getRound());

            Animation animation = AnimationUtils.loadAnimation(itemView.getContext(), R.anim.scale_alpha);
            itemView.startAnimation(animation);
        }
    }

}
