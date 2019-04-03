package com.example.lenovo.myapplication1.Network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MyCalls {


    @GET("login.php")
    Call<ServerFormat> login(
            @Query("username") String username,
            @Query("password") String password
    );

    @GET("get_inventory.php")
    Call<ServerFormat> get_Inventory(
    );
    @GET("get_writeoff.php")
    Call<ServerFormat> get_Writeoff(
    );

    @GET("add_inventory.php")
    Call<ServerFormat> add_inventory(
            @Query("item_id") String item_id,
            @Query("purchase_year") String purchase_year,
            @Query("name_of_item") String name_of_item,
            @Query("name_of_suplier") String name_of_suplier,
            @Query("total_quantity") String total_quantity,
            @Query("rate_per_unit") String rate_per_unit,
            @Query("total_amount") String total_amount,
            @Query("grant_type") String grant_type,
            @Query("remarks") String remarks

    );

    @GET("add_writeoff.php")
    Call<ServerFormat> add_writeoff(
            @Query("item_id") String item_id,
            //   @Query("purchase_year") String purchase_year,
            @Query("name_of_item") String name_of_item,
            //   @Query("name_of_suplier") String name_of_suplier,
            // @Query("total_quantity") String total_quantity,
            @Query("rate_per_unit") String rate_per_unit,
            @Query("total_amount") String total_amount,
            // @Query("grant_type") String grant_type,
            //  @Query("remarks") String remarks,
            // @Query("price_of_each_item") String price_of_each_item,
            @Query("date_of_purchase") String date_of_purchase,
            @Query("date_of_unuseability") String date_of_unuseability,
            @Query("period_of_use") String period_of_use,
            @Query("period_of_item_become_unserviceable") String period_of_item_become_unserviceable,
            @Query("wheather_defect_can_be_repaired") String rewheather_defect_can_be_repairedmarks,
            @Query("description") String description,
            @Query("reason") String reason

    );

}
