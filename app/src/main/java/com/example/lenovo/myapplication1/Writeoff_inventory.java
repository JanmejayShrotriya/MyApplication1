package com.example.lenovo.myapplication1;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lenovo.myapplication1.Network.MyBase;
import com.example.lenovo.myapplication1.Network.MyCalls;
import com.example.lenovo.myapplication1.Network.ServerFormat;

import retrofit2.Call;
import retrofit2.Callback;

public class Writeoff_inventory extends AppCompatActivity {
    EditText writeoff_id, item_name, writeoff_qty, price_each, date_purchase, date_unuse, period_use, period_unuse, defect_repair, total_amount, defect_description, reason;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        writeoff_id = findViewById(R.id.writeoff_id);
        item_name = findViewById(R.id.item_name);
        writeoff_qty = findViewById(R.id.writeoff_qty);
        price_each = findViewById(R.id.price_each);
        date_purchase = findViewById(R.id.date_purchase);
        date_unuse = findViewById(R.id.date_unuse);
        period_use = findViewById(R.id.period_use);
        period_unuse = findViewById(R.id.period_unuse);
        defect_repair = findViewById(R.id.defect_repair);
        total_amount = findViewById(R.id.total_amount);
        defect_description = findViewById(R.id.defect_description);
        reason = findViewById(R.id.reason);

        writeoff_id.setText(getIntent().getStringExtra("id"));
        item_name.setText(getIntent().getStringExtra("name"));
        price_each.setText(getIntent().getStringExtra("price_each"));
        writeoff_qty.setText(getIntent().getStringExtra("writeoff_qty"));
        total_amount.setText(getIntent().getStringExtra("total_amount"));
        date_purchase.setText(getIntent().getStringExtra("date_purchase"));
        findViewById(R.id.writeoff_inventory).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (writeoff_id.getText().toString().trim().length() == 0) {
                    writeoff_id.setError("Please Enter Item id");
                    writeoff_id.requestFocus();
                } else if (item_name.getText().toString().trim().length() == 0) {
                    item_name.setError("Please Enter Item Name");
                    item_name.requestFocus();
                } else if (writeoff_qty.getText().toString().trim().length() == 0) {
                    writeoff_qty.setError("Please Enter Quntity");
                    writeoff_qty.requestFocus();
                } else if (price_each.getText().toString().trim().length() == 0) {
                    price_each.setError("Please Enter Price Of Each Item");
                    price_each.requestFocus();
                } else if (date_purchase.getText().toString().trim().length() == 0) {
                    date_purchase.setError("Please Enter Date of Purchase");
                    date_purchase.requestFocus();
                } else if (date_unuse.getText().toString().trim().length() == 0) {
                    date_unuse.setError("Please Enter Date of Unusablity");
                    date_unuse.requestFocus();
                } else if (period_use.getText().toString().trim().length() == 0) {
                    period_use.setError("Please Enter Period Of Use");
                    period_use.requestFocus();
                } else if (period_unuse.getText().toString().trim().length() == 0) {
                    period_unuse.setError("Please Enter Period Of Item Become Unserviceable");
                    period_unuse.requestFocus();
                } else if (defect_repair.getText().toString().trim().length() == 0) {
                    defect_repair.setError("Please Enter Whether Defect Can Be Repaired");
                    defect_repair.requestFocus();
                } else if (total_amount.getText().toString().trim().length() == 0) {
                    total_amount.setError("Please Enter Total Amount Of Items");
                    total_amount.requestFocus();
                } else if (defect_description.getText().toString().trim().length() == 0) {
                    defect_description.setError("Description Defects Devlop In Condition Of Item");
                    defect_description.requestFocus();
                } else if (reason.getText().toString().trim().length() == 0) {
                    reason.setError("Please Enter Reason");
                    reason.requestFocus();
                } else {
                    add_writeoff();
                }

            }
        });


    }

    public void add_writeoff() {

        final ProgressDialog dialog = new ProgressDialog(Writeoff_inventory.this);
        dialog.setMessage("please wait");
        dialog.setCancelable(false);
        dialog.show();

        MyCalls calls = MyBase.getRetrofit().create(MyCalls.class);
        Call<ServerFormat> call = calls.add_writeoff(
                writeoff_id.getText().toString().trim() + "",
                item_name.getText().toString().trim() + "",
                price_each.getText().toString().trim() + "",
                writeoff_qty.getText().toString().trim() + "",
                date_purchase.getText().toString().trim() + "",
                date_unuse.getText().toString().trim() + "",
                period_use.getText().toString().trim() + "",
                period_unuse.getText().toString().trim() + "",
                defect_repair.getText().toString().trim() + "",
                defect_description.getText().toString().trim() + "",
                reason.getText().toString().trim() + ""
        );
        call.enqueue(new Callback<ServerFormat>() {
            @Override
            public void onResponse(Call<ServerFormat> call, retrofit2.Response<ServerFormat> response) {
                dialog.dismiss();
                if (response.body().status.equals("1")) {
                    Toast.makeText(Writeoff_inventory.this, "Sent Writeoff Request Successfully ", Toast.LENGTH_SHORT).show();
                    finish();

                } else {
                    Toast.makeText(Writeoff_inventory.this, "try again later", Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<ServerFormat> call, Throwable t) {
                Toast.makeText(Writeoff_inventory.this, "internet error", Toast.LENGTH_SHORT).show();
                dialog.dismiss();

            }
        });


    }

}
