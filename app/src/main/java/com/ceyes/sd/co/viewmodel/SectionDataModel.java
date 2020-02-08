package com.ceyes.sd.co.viewmodel;

import java.util.ArrayList;

public class SectionDataModel {



    private String name;
    private String id;
    private ArrayList<SingleItemModel> values;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<SingleItemModel> getValues() {
        return values;
    }

    public void setValues(ArrayList<SingleItemModel> values) {
        this.values = values;
    }
}
