package com.example.lenovo.myapplication1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class DetailsActivity extends AppCompatActivity {
    String purchase_year;
    TextView purchase_yearTV;
    String Name_of_Suplier;
    TextView Name_of_SuplierTV;
    String Rate_Per_Unit;
    TextView Rate_Per_UnitTV;
    String Total_Amount;
    TextView Total_AmountTV;
    String Grant_Type;
    TextView Grant_TypeTV;
    String Remarks;
    TextView RemarksTV;
    private String url = "https://collegeinventory.000webhostapp.com/android/getInventoryDetail.php";
    private String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent intent = getIntent();
        purchase_year = intent.getStringExtra("purchase_year");
        Name_of_Suplier = intent.getStringExtra("name_of_suplier");
        Total_Amount = intent.getStringExtra("total_amount");
        Remarks = intent.getStringExtra("remarks");
        Rate_Per_Unit = intent.getStringExtra("rate_per_unit");
        Grant_Type = intent.getStringExtra("grant_type");
//        Toast.makeText(getApplicationContext(),id,Toast.LENGTH_SHORT).show();
        purchase_yearTV=findViewById(R.id.purchase_yearTV);
        Name_of_SuplierTV=findViewById(R.id.Name_of_SuplierTV);
        Rate_Per_UnitTV=findViewById(R.id.Rate_Per_UnitTV);
        Total_AmountTV=findViewById(R.id.Total_AmountTV);
        Grant_TypeTV=findViewById(R.id.Grant_TypeTV);
        RemarksTV=findViewById(R.id.RemarksTV);

        purchase_yearTV.setText(purchase_year);
        Name_of_SuplierTV.setText(Name_of_Suplier);
        Total_AmountTV.setText(Total_Amount);
        RemarksTV.setText(Remarks);
        Rate_Per_UnitTV.setText(Rate_Per_Unit);
        Grant_TypeTV.setText(Grant_Type);

//
//        RequestQueue queue = Volley.newRequestQueue(this);
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                Toast.makeText(getApplicationContext(),response,Toast.LENGTH_SHORT).show();
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        }){
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                Map<String,String> params = new HashMap<>();
//                params.put("id",id);
//                return params;
//            }
//        };
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//        queue.add(stringRequest);
//
//
//        purchase_year.setText("2014");
//        Name_of_Suplier.setText("Janmejay Shrotriya");
//        Rate_Per_Unit.setText("100");
//        Total_Amount.setText("10000");
//        Grant_Type.setText("STATE");
//        Remarks.setText("all good");
//
//

    }
}
