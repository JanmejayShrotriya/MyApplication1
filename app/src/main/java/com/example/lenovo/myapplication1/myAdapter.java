package com.example.lenovo.myapplication1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

        View layout = LayoutInflater.from(context).inflate(R.layout.inventory_row, parent, false);

        return new MyHolder(layout);
    }

    //harsh.hadvani@tops-int.com

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {


        final String requestId = data.get(position).getItem_id();
        holder.item_id.setText("Item Id :" + data.get(position).getItem_id());
//        holder.purchase_year.setText(data.get(position).getPurchase_year());
        holder.name_of_item.setText("Name Of Item :"+data.get(position).getName_of_item());
//        holder.name_of_suppplier.setText(data.get(position).getName_of_suplier());
//        holder.total_amount.setText(data.get(position).getTotal_amount());
        holder.total_quantity.setText("Total Quantity :"+data.get(position).getTotal_quantity());
//        holder.grant_type.setText(data.get(position).getGrant_type());
//        holder.remarks.setText(data.get(position).getRemarks());
//        holder.rate_per_unit.setText(data.get(position).getRate_per_unit());

        holder.request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, Writeoff_inventory.class)
                        .putExtra("id", data.get(position).getItem_id())
                        .putExtra("name", data.get(position).getName_of_item())
                        .putExtra("price_each", data.get(position).getRate_per_unit())
                        .putExtra("writeoff_qty", data.get(position).getTotal_quantity())
                        .putExtra("total_amount", data.get(position).getTotal_amount())
                        .putExtra("date_purchase", data.get(position).getPurchase_year())
                );
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, DetailsActivity.class)
                .putExtra("purchase_year",data.get(position).getPurchase_year())
                .putExtra("name_of_suplier",data.get(position).getName_of_suplier())
                .putExtra("total_amount",data.get(position).getTotal_amount())
                .putExtra("grant_type",data.get(position).getGrant_type())
                .putExtra("remarks",data.get(position).getRemarks())
                .putExtra("rate_per_unit",data.get(position).getRate_per_unit())
                .putExtra("grant_type",data.get(position).getGrant_type())
                );
            }
        });
//        holder.viewDetail.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent(v.getContext(),DetailsActivity.class);
//                intent.putExtra("id",requestId);
//                context.startActivity(intent);
//
////                Toast.makeText(v.getContext(),"detail",Toast.LENGTH_SHORT
//////                ).show();
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        Button request;
        TextView item_id, name_of_item, total_quantity;

        public MyHolder(View itemView) {
            super(itemView);
            request = itemView.findViewById(R.id.btn_request);
//            viewDetail = itemView.findViewById(R.id.btn_detail);
            item_id = itemView.findViewById(R.id.item_id);

            name_of_item = itemView.findViewById(R.id.name_of_item);

            total_quantity = itemView.findViewById(R.id.qty);
//            rate_per_unit = itemView.findViewById(R.id.rate_per_unit);
//            total_amount = itemView.findViewById(R.id.total_amount);
//            grant_type = itemView.findViewById(R.id.grant_type);
//            remarks= itemView.findViewById(R.id.remarks);
//        }
        }
    }
}