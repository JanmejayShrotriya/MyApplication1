package com.example.lenovo.myapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class WriteoffDetailsActivity extends AppCompatActivity {
    TextView wtotal_amountTV;
    String total_amount;
    TextView wrate_per_unitTV;
    String rate_per_unit;
    TextView wdate_of_unuseabilityTV;
    String date_of_unuseability;
    TextView wperiod_of_item_become_unserviceableTV;
    String period_of_item_become_unserviceable;
    TextView wperiod_of_useTV;
    String period_of_use;
    TextView wheather_defect_can_be_repairedTV;
    String wheather_defect_can_be_repaired;
    TextView descriptionTV;
    String description;
    TextView reasonTV;
    String reason;
    TextView statusTV;
    String status;

    private String url = "https://collegeinventory.000webhostapp.com/android/getInventoryDetail.php";
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writeoff_details);

        wtotal_amountTV = findViewById(R.id.wtotal_amountTV);
        wrate_per_unitTV = findViewById(R.id.wrate_per_unitTV);
        wdate_of_unuseabilityTV = findViewById(R.id.wdate_of_unuseabilityTV);
        wperiod_of_item_become_unserviceableTV = findViewById(R.id.wperiod_of_item_become_unserviceableTV);
        wperiod_of_useTV = findViewById(R.id.wperiod_of_useTV);
        wheather_defect_can_be_repairedTV = findViewById(R.id.wheather_defect_can_be_repairedTV);
        descriptionTV = findViewById(R.id.descriptionTV);
        reasonTV = findViewById(R.id.reasonTV);
        statusTV=findViewById(R.id.statusTV);


        Intent intent = getIntent();
        total_amount = intent.getStringExtra("total_amount");
        rate_per_unit = intent.getStringExtra("rate_per_unit");
        date_of_unuseability = intent.getStringExtra("date_of_unuseability");
        period_of_item_become_unserviceable = intent.getStringExtra("period_of_item_become_unserviceable");
        period_of_use = intent.getStringExtra("period_of_use");
        wheather_defect_can_be_repaired = intent.getStringExtra("wheather_defect_can_be_repaired");
        description = intent.getStringExtra("description");
        reason = intent.getStringExtra( "reason");
        status = intent.getStringExtra( "status");

        Log.e("zxczxc", reason);

        wtotal_amountTV.setText(total_amount);
        wrate_per_unitTV.setText(rate_per_unit);
        wdate_of_unuseabilityTV.setText(date_of_unuseability);
        wperiod_of_item_become_unserviceableTV.setText(period_of_item_become_unserviceable);
        wperiod_of_useTV.setText(period_of_use);
        wheather_defect_can_be_repairedTV.setText(wheather_defect_can_be_repaired);
        descriptionTV.setText(description);
        reasonTV.setText(reason);
        statusTV.setText(status);
//        total_amount.setText("20000");
//        rate_per_unit.setText("Janmejay Shrotriya");
//        date_of_unuseability.setText("7/01/200");
//        period_of_item_become_unserviceable.setText("1 month");
//        period_of_use.setText("15 days");
//        wheather_defect_can_be_repaired.setText("no");
//        description.setText("not working");
//        reason.setText("defected");
    }

}
