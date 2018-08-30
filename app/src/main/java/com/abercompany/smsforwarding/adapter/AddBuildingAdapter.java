package com.abercompany.smsforwarding.adapter;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abercompany.smsforwarding.R;
import com.abercompany.smsforwarding.databinding.ViewRoomInfoItemBinding;
import com.abercompany.smsforwarding.model.OnClickEvent;
import com.abercompany.smsforwarding.model.Room;
import com.abercompany.smsforwarding.provider.BusProvider;

import org.greenrobot.eventbus.Subscribe;

import java.util.List;

public class AddBuildingAdapter extends RecyclerView.Adapter<AddBuildingAdapter.BindingHolder>  {

    private Context context;
    private Activity activity;
    private String buildingName = "";
    private List<Room> rooms;


    private int itemCount = 1;


    public class BindingHolder extends RecyclerView.ViewHolder {

        private ViewRoomInfoItemBinding binding;

        public BindingHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }

    public AddBuildingAdapter(Context context, Activity activity, String buildingName, List<Room> rooms) {
        this.context = context;
        this.activity = activity;
        this.buildingName = buildingName;
        this.rooms = rooms;

        itemCount = rooms.size();

        BusProvider.getInstance().register(this);
    }

    @NonNull
    @Override
    public BindingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_room_info_item, parent, false);
        return new BindingHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BindingHolder holder, int position) {
        holder.binding.etFloor.setText(rooms.get(position).getFloor());
        holder.binding.etRoomNum.setText(rooms.get(position).getRoomNum());
        holder.binding.etRoomPrice.setText(rooms.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return itemCount;
    }

    @Subscribe
    public void Finished(OnClickEvent event) {
        itemCount++;
        notifyDataSetChanged();
    }


    @Override
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        BusProvider.getInstance().unregister(this);
    }
}