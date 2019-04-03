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

public class myAdapter extends RecyclerView.Adapter<myAdapter.MyHolder> {

    Context context;
    ArrayList<InventoryModel> data;

    public myAdapter(Context context, ArrayList<InventoryModel> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layout = LayoutInflater.from(context).inflate(R.layout.activity_view, parent, false);

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
        holder.purchase_year.setText(data.get(position).getPurchase_year());
        holder.name_of_item.setText(data.get(position).getName_of_item());
        holder.name_of_suppplier.setText(data.get(position).getName_of_suplier());
        holder.total_amount.setText(data.get(position).getTotal_amount());
        holder.total_quantity.setText(data.get(position).getTotal_quantity());
        holder.grant_type.setText(data.get(position).getGrant_type());
        holder.remarks.setText(data.get(position).getRemarks());
        holder.rate_per_unit.setText(data.get(position).getRate_per_unit());

        holder.request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context,Writeoff_inventory.class)
                .putExtra("id",data.get(position).getItem_id())
                .putExtra("name",data.get(position).getName_of_item())
                .putExtra("price_each",data.get(position).getRate_per_unit())
                .putExtra("writeoff_qty",data.get(position).getTotal_quantity())
                .putExtra("total_amount",data.get(position).getTotal_amount())
                .putExtra("date_purchase",data.get(position).getPurchase_year())
                );
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        Button request;
        TableRow cols;
        TextView item_id,purchase_year,name_of_item,name_of_suppplier,total_quantity
                ,rate_per_unit,total_amount,grant_type,remarks;

        public MyHolder(View itemView) {
            super(itemView);
            request = itemView.findViewById(R.id.btn_request);
            cols = itemView.findViewById(R.id.cols);
            item_id = itemView.findViewById(R.id.item_id);
            purchase_year = itemView.findViewById(R.id.purchase_year);
            name_of_item = itemView.findViewById(R.id.name_of_item);
            name_of_suppplier= itemView.findViewById(R.id.name_of_suppplier);
            total_quantity = itemView.findViewById(R.id.total_quantity);
            rate_per_unit = itemView.findViewById(R.id.rate_per_unit);
            total_amount = itemView.findViewById(R.id.total_amount);
            grant_type = itemView.findViewById(R.id.grant_type);
            remarks= itemView.findViewById(R.id.remarks);
        }
    }
}
