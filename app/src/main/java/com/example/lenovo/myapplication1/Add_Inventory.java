package com.example.lenovo.myapplication1;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.lenovo.myapplication1.Network.MyBase;
import com.example.lenovo.myapplication1.Network.MyCalls;
import com.example.lenovo.myapplication1.Network.ServerFormat;

import retrofit2.Call;
import retrofit2.Callback;

public class Add_Inventory extends AppCompatActivity {
    EditText item_id, purchase_year, name_item, name_sup, qty, rate, amount, remark;
    Spinner grant_type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        item_id = findViewById(R.id.add_id);
        grant_type = findViewById(R.id.spinner1);
        purchase_year = findViewById(R.id.purchase_year);
        name_item = findViewById(R.id.name_item);
        name_sup = findViewById(R.id.name_sup);
        qty = findViewById(R.id.qty);
        rate = findViewById(R.id.rate);
        amount = findViewById(R.id.amount);
        remark = findViewById(R.id.remark);


        rate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (qty.getText().toString().trim().length() == 0) {
                    qty.setError("invalid qty");
                    qty.requestFocus();
                } else {


                    amount.setText((Integer.parseInt(rate.getText().toString().trim())
                            * Integer.parseInt(qty.getText().toString().trim())) + "");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        findViewById(R.id.add_inventory).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (item_id.getText().toString().trim().length() == 0) {
                    item_id.setError("Please Enter item id");
                    item_id.requestFocus();
                } else if (purchase_year.getText().toString().trim().length() == 0) {
                    purchase_year.setError("Please Enter Purchase year");
                    purchase_year.requestFocus();
                } else if (name_item.getText().toString().trim().length() == 0) {
                    name_item.setError("Please Enter Name of item");
                    name_item.requestFocus();
                } else if (name_sup.getText().toString().trim().length() == 0) {
                    name_sup.setError("Please Enter Name of Suplier");
                    name_sup.requestFocus();
                } else if (qty.getText().toString().trim().length() == 0) {
                    qty.setError("Please Enter Total Quantity");
                    qty.requestFocus();
                } else if (rate.getText().toString().trim().length() == 0) {
                    rate.setError("Please Enter Rate Per Unit");
                    rate.requestFocus();
                } else if (amount.getText().toString().trim().length() == 0) {
                    amount.setError("Please Enter Total Amount");
                    amount.requestFocus();
                } else if (remark.getText().toString().trim().length() == 0) {
                    remark.setError("Please Enter Remarks");
                    remark.requestFocus();
                } else {
                    add_Inventory();
                }


            }
        });

    }

    public void add_Inventory() {

        final ProgressDialog dialog = new ProgressDialog(Add_Inventory.this);
        dialog.setMessage("please wait");
        dialog.setCancelable(false);
        dialog.show();

        MyCalls calls = MyBase.getRetrofit().create(MyCalls.class);
        Call<ServerFormat> call = calls.add_inventory(
                item_id.getText().toString().trim() + "",
                purchase_year.getText().toString().trim() + "",
                name_item.getText().toString().trim() + "",
                name_sup.getText().toString().trim() + "",
                qty.getText().toString().trim() + "",
                rate.getText().toString().trim() + "",
                amount.getText().toString().trim() + "",
                grant_type.getSelectedItem() + "",
                remark.getText().toString().trim() + ""
        );
        call.enqueue(new Callback<ServerFormat>() {
            @Override
            public void onResponse(Call<ServerFormat> call, retrofit2.Response<ServerFormat> response) {
                dialog.dismiss();
                if (response.body().status.equals("1")) {
                    Toast.makeText(Add_Inventory.this, "Added Successfully ", Toast.LENGTH_SHORT).show();
                    finish();

                } else {
                    Toast.makeText(Add_Inventory.this, "try again later", Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<ServerFormat> call, Throwable t) {
                Toast.makeText(Add_Inventory.this, "internet error", Toast.LENGTH_SHORT).show();
                dialog.dismiss();

            }
        });


    }


}
