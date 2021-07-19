package com.miracle.flowlayoutdemo.bean;

import java.util.List;

public class Car {
    private String brandName;
    private List<Model> model;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public List<Model> getModel() {
        return model;
    }

    public void setModel(List<Model> model) {
        this.model = model;
    }
}
