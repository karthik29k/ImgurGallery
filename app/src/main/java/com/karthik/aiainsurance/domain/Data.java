
package com.karthik.aiainsurance.domain;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Data {
    @SerializedName("items")
    private List<Item> items = null;

    public Data(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }
}
