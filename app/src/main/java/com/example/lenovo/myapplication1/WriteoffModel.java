package com.example.lenovo.myapplication1;

public class WriteoffModel {

    String id,item_id,name_of_item,rate_per_unit,total_amount,date_of_purchase,date_of_unuseability,period_of_use,period_of_item_become_unserviceable,wheather_defect_can_be_repaired,description,reason;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getName_of_item() {
        return name_of_item;
    }

    public void setName_of_item(String name_of_item) {
        this.name_of_item = name_of_item;
    }

    public String getRate_per_unit() {
        return rate_per_unit;
    }

    public void setRate_per_unit(String rate_per_unit) {
        this.rate_per_unit = rate_per_unit;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    public String getDate_of_purchase() {
        return date_of_purchase;
    }

    public void setDate_of_purchase(String date_of_purchase) {
        this.date_of_purchase = date_of_purchase;
    }

    public String getDate_of_unuseability() {
        return date_of_unuseability;
    }

    public void setDate_of_unuseability(String date_of_unuseability) {
        this.date_of_unuseability = date_of_unuseability;
    }

    public String getPeriod_of_use() {
        return period_of_use;
    }

    public void setPeriod_of_use(String period_of_use) {
        this.period_of_use = period_of_use;
    }

    public String getPeriod_of_item_become_unserviceable() {
        return period_of_item_become_unserviceable;
    }

    public void setPeriod_of_item_become_unserviceable(String period_of_item_become_unserviceable) {
        this.period_of_item_become_unserviceable = period_of_item_become_unserviceable;
    }

    public String getWheather_defect_can_be_repaired() {
        return wheather_defect_can_be_repaired;
    }

    public void setWheather_defect_can_be_repaired(String wheather_defect_can_be_repaired) {
        this.wheather_defect_can_be_repaired = wheather_defect_can_be_repaired;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public WriteoffModel(String id, String item_id, String name_of_item, String rate_per_unit, String total_amount, String date_of_purchase, String date_of_unuseability, String period_of_use, String period_of_item_become_unserviceable, String wheather_defect_can_be_repaired, String description, String reason) {
        this.id = id;
        this.item_id = item_id;
        this.name_of_item = name_of_item;
        this.rate_per_unit = rate_per_unit;
        this.total_amount = total_amount;
        this.date_of_purchase = date_of_purchase;
        this.date_of_unuseability = date_of_unuseability;
        this.period_of_use = period_of_use;
        this.period_of_item_become_unserviceable = period_of_item_become_unserviceable;
        this.wheather_defect_can_be_repaired = wheather_defect_can_be_repaired;
        this.description = description;
        this.reason = reason;
    }
}


