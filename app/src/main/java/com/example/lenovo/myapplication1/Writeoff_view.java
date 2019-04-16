package com.example.lenovo.myapplication1;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.lenovo.myapplication1.Network.MyBase;
import com.example.lenovo.myapplication1.Network.MyCalls;
import com.example.lenovo.myapplication1.Network.ServerFormat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;

public class Writeoff_view extends AppCompatActivity {
    RecyclerView r;
    writeoffmyAdapter adapter;
    ArrayList<WriteoffModel> data=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_inventory);
        r = findViewById(R.id.view_inventory);
        r.setLayoutManager(new LinearLayoutManager(Writeoff_view.this));
        get_writeoff();

        }

        public void get_writeoff(){

                final ProgressDialog dialog = new ProgressDialog(Writeoff_view.this);
                dialog.setMessage("please wait");
                dialog.setCancelable(false);
                dialog.show();

                MyCalls calls = MyBase.getRetrofit().create(MyCalls.class);
                Call<ServerFormat> call = calls.get_Writeoff();
                call.enqueue(new Callback<ServerFormat>() {
                    @Override
                    public void onResponse(Call<ServerFormat> call, retrofit2.Response<ServerFormat> response) {
                        dialog.dismiss();
                        List<Map> temp=response.body().server_response;

                        for(int i=0;i<temp.size();i++){
                            data.add(new WriteoffModel(
                                    temp.get(i).get("id")+"",
                                    temp.get(i).get("item_id")+"",
                                    temp.get(i).get("name_of_item")+"",
                                    temp.get(i).get("rate_per_unit")+"",
                                    temp.get(i).get("total_amount")+"",
                                    temp.get(i).get("date_of_purchase")+"",
                                    temp.get(i).get("date_of_unuseability")+"",
                                    temp.get(i).get("period_of_use")+"",
                                    temp.get(i).get("period_of_item_become_unserviceable")+"",
                                    temp.get(i).get("wheather_defect_can_be_repaired")+"",
                                    temp.get(i).get("description")+"",
                                    temp.get(i).get("reason")+"",
                                    temp.get(i).get("status")+""
                                    ));
                        }
                        adapter = new writeoffmyAdapter(Writeoff_view.this,data);
                        r.setAdapter(adapter);



                    }

                    @Override
                    public void onFailure(Call<ServerFormat> call, Throwable t) {
                        Toast.makeText(Writeoff_view.this, "internet error", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();

                    }
                });
        }

}
