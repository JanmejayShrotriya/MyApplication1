package com.example.lenovo.myapplication1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class writeoffmyAdapter extends RecyclerView.Adapter<writeoffmyAdapter.MyHolder> {

    Context context;
    ArrayList<WriteoffModel> data;

    public writeoffmyAdapter(Context context, ArrayList<WriteoffModel> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layout = LayoutInflater.from(context).inflate(R.layout.activity_writeoff_view, parent, false);

        return new MyHolder(layout);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {

        if (position == 0) {
            holder.cols.setVisibility(View.VISIBLE);
        } else {
            holder.cols.setVisibility(View.GONE);
        }

        holder.item_id.setText(data.get(position).getItem_id());
        holder.name_of_item.setText(data.get(position).getName_of_item());
        holder.total_amount.setText(data.get(position).getTotal_amount());
        holder.rate_per_unit.setText(data.get(position).getRate_per_unit());
        holder.date_of_purchase.setText(data.get(position).getDate_of_purchase());
        holder.date_of_unuseability.setText(data.get(position).getDate_of_unuseability());
        holder.period_of_item_become_unserviceable.setText(data.get(position).getPeriod_of_item_become_unserviceable());
        holder.period_of_use.setText(data.get(position).getPeriod_of_use());
        holder.wheather_defect_can_be_repaired.setText(data.get(position).getWheather_defect_can_be_repaired());
        holder.description.setText(data.get(position).getDescription());
        holder.reason.setText(data.get(position).getReason());


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        Button request;
        TableRow cols;
        TextView item_id,name_of_item
                ,rate_per_unit,total_amount,date_of_purchase
                , date_of_unuseability,period_of_use
                ,period_of_item_become_unserviceable
                ,wheather_defect_can_be_repaired
                ,description,reason;

        public MyHolder(View itemView) {
            super(itemView);
            request = itemView.findViewById(R.id.btn_request);
            cols = itemView.findViewById(R.id.cols);
            item_id = itemView.findViewById(R.id.item_id);
            name_of_item = itemView.findViewById(R.id.name_of_item);
            rate_per_unit= itemView.findViewById(R.id.wrate_per_unit);
            total_amount = itemView.findViewById(R.id.wtotal_amount);
            date_of_purchase = itemView.findViewById(R.id.wdate_of_purchase);
            date_of_unuseability = itemView.findViewById(R.id.wdate_of_unuseability);
            period_of_use = itemView.findViewById(R.id.wperiod_of_use);
            period_of_item_become_unserviceable= itemView.findViewById(R.id.wperiod_of_item_become_unserviceable);
            wheather_defect_can_be_repaired= itemView.findViewById(R.id.wwheather_defect_can_be_repaired);
            description= itemView.findViewById(R.id.wdescription);
            reason= itemView.findViewById(R.id.reason);

        }
    }
}
