package com.miracle.flowlayoutdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;

import com.miracle.flowlayout.FlowLayout;
import com.miracle.flowlayout.TagAdapter;
import com.miracle.flowlayout.TagFlowLayout;
import com.miracle.flowlayoutdemo.bean.Car;
import com.miracle.flowlayoutdemo.bean.Model;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TagFlowLayout brand_flowlayout;
    private TagFlowLayout model_flowlayout;
    private List<Car> cars;
    private TagAdapter brandAdapter;
    private TagAdapter modelAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        brand_flowlayout = findViewById(R.id.brand_flowlayout);
        model_flowlayout = findViewById(R.id.model_flowlayout);
        initData();
    }

    @Override
    protected void onStart() {
        super.onStart();
        showBrand();
    }

    private void showBrand() {
        brandAdapter = new TagAdapter<Car>(cars) {
            @Override
            public View getView(FlowLayout parent, int position, Car car) {
                CheckBox checkBox = (CheckBox) LayoutInflater.from(MainActivity.this).inflate(R.layout.item_project_checkbox, brand_flowlayout, false);
                checkBox.setText(car.getBrandName());
                return checkBox;
            }

            @Override
            public void onSelected(int position, View view) {
                super.onSelected(position, view);
                showModel(cars.get(position).getModel());
            }
        };
        brand_flowlayout.setAdapter(brandAdapter,0);
    }

    private void showModel(List<Model> models) {
        if(modelAdapter == null) {
            modelAdapter = new TagAdapter<Model>(models) {
                @Override
                public View getView(FlowLayout parent, int position, Model model) {
                    CheckBox checkBox = (CheckBox) LayoutInflater.from(MainActivity.this).inflate(R.layout.item_project_checkbox, model_flowlayout, false);
                    checkBox.setText(model.getModelName());
                    return checkBox;
                }

                @Override
                public void onSelected(int position, View view, Model model) {
                    super.onSelected(position, view, model);
                    Log.i("jiaojing","models name =="+ model.getModelName());
                }
            };
            model_flowlayout.setAdapter(modelAdapter,0);
        }else {
            modelAdapter.refreshData(models);
        }
    }

    private void initData() {
        cars = new ArrayList<>();

        Car car2 = new Car();
        car2.setBrandName("奥迪");
        List<Model> tempMode2 = new ArrayList<>();
        tempMode2.add(new Model("A1L"));
        tempMode2.add(new Model("A2L"));
        tempMode2.add(new Model("A3L"));
        tempMode2.add(new Model("A4L"));
        car2.setModel(tempMode2);
        cars.add(car2);

        Car car1 = new Car();
        car1.setBrandName("宝马");
        List<Model> tempMode = new ArrayList<>();
        tempMode.add(new Model("X1"));
        tempMode.add(new Model("X2"));
        tempMode.add(new Model("X3"));
        tempMode.add(new Model("X4"));
        tempMode.add(new Model("X5"));
        tempMode.add(new Model("z1"));
        tempMode.add(new Model("z2"));
        tempMode.add(new Model("z3"));
        tempMode.add(new Model("z4"));
        tempMode.add(new Model("z5"));
        car1.setModel(tempMode);
        cars.add(car1);
    }
}