package com.example.lenovo.myapplication1;

public class InventoryModel {
  /*{"server_response":[{"id":"8","item_id":"5435","purchase_year":"4t4hhh","name_of_item":"dummy","\tname_of_suplier":"3458347","total_quantity":"fnbdjs","rate_per_unit":"resgrgr","total_amount":"64565tr","grant_type":"dfhffhf","\tremarks":"kjdgfjfbgjkfg"},{"id":"9","item_id":"5435","purchase_year":"4t4hhh","name_of_item":"dummy","\tname_of_suplier":"3458347","total_quantity":"fnbdjs","rate_per_unit":"resgrgr","total_amount":"64565tr","grant_type":"dfhffhf","\tremarks":"kjdgfjfbgjkfg"},{"id":"10","item_id":"5435","purchase_year":"4t4hhh","name_of_item":"dummy","\tname_of_suplier":"3458347","total_quantity":"fnbdjs","rate_per_unit":"resgrgr","total_amount":"64565tr","grant_type":"dfhffhf","\tremarks":"kjdgfjfbgjkfg"},{"id":"11","item_id":"12345678","purchase_year":"2018","name_of_item":"pc","\tname_of_suplier":"jj","total_quantity":"50","rate_per_unit":"20000","total_amount":"200000"
  ,"grant_type":"STATE","\tremarks":"hello i m jj"}],"status":"1"}*/

    String id,item_id,purchase_year,name_of_item,name_of_suplier,total_quantity,rate_per_unit,total_amount,grant_type,remarks;

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

    public String getPurchase_year() {
        return purchase_year;
    }

    public void setPurchase_year(String purchase_year) {
        this.purchase_year = purchase_year;
    }

    public String getName_of_item() {
        return name_of_item;
    }

    public void setName_of_item(String name_of_item) {
        this.name_of_item = name_of_item;
    }

    public String getName_of_suplier() {
        return name_of_suplier;
    }

    public void setName_of_suplier(String name_of_suplier) {
        this.name_of_suplier = name_of_suplier;
    }

    public String getTotal_quantity() {
        return total_quantity;
    }

    public void setTotal_quantity(String total_quantity) {
        this.total_quantity = total_quantity;
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

    public String getGrant_type() {
        return grant_type;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public InventoryModel(String id, String item_id, String purchase_year, String name_of_item, String name_of_suplier, String total_quantity, String rate_per_unit, String total_amount, String grant_type, String remarks) {
        this.id = id;
        this.item_id = item_id;
        this.purchase_year = purchase_year;
        this.name_of_item = name_of_item;
        this.name_of_suplier = name_of_suplier;
        this.total_quantity = total_quantity;
        this.rate_per_unit = rate_per_unit;
        this.total_amount = total_amount;
        this.grant_type = grant_type;
        this.remarks = remarks;
    }
}
