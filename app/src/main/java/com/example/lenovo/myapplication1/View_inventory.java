package com.example.lenovo.myapplication1;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.Toast;

import com.example.lenovo.myapplication1.Network.MyBase;
import com.example.lenovo.myapplication1.Network.MyCalls;
import com.example.lenovo.myapplication1.Network.ServerFormat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;

public class View_inventory extends AppCompatActivity {
    RecyclerView r;
    myAdapter adapter;
    ArrayList<InventoryModel> data=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_inventory);
        r = findViewById(R.id.view_inventory);
        r.setLayoutManager(new LinearLayoutManager(View_inventory.this));
        get_Inventory();
      }

    public void get_Inventory() {

        final ProgressDialog dialog = new ProgressDialog(View_inventory.this);
        dialog.setMessage("please wait");
        dialog.setCancelable(false);
        dialog.show();

        MyCalls calls = MyBase.getRetrofit().create(MyCalls.class);
        Call<ServerFormat> call = calls.get_Inventory();
        call.enqueue(new Callback<ServerFormat>() {
            @Override
            public void onResponse(Call<ServerFormat> call, retrofit2.Response<ServerFormat> response) {
                dialog.dismiss();
                List<Map> temp=response.body().server_response;

                for(int i=0;i<temp.size();i++){
                    data.add(new InventoryModel(
                            temp.get(i).get("id")+"",
                            temp.get(i).get("item_id")+"",
                            temp.get(i).get("purchase_year")+"",
                            temp.get(i).get("name_of_item")+"",
                            temp.get(i).get("name_of_suplier")+"",
                            temp.get(i).get("total_quantity")+"",
                            temp.get(i).get("rate_per_unit")+"",
                            temp.get(i).get("total_amount")+"",
                            temp.get(i).get("grant_type")+"",
                            temp.get(i).get("remarks")+""

                    ));
                }
                adapter = new myAdapter(View_inventory.this,data);
                r.setAdapter(adapter);



            }

            @Override
            public void onFailure(Call<ServerFormat> call, Throwable t) {
                Toast.makeText(View_inventory.this, "internet error", Toast.LENGTH_SHORT).show();
                dialog.dismiss();

            }
        });


    }

}
