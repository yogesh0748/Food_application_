package com.foodapplication.fragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.foodapplication.R;
import com.foodapplication.adapter.PopularAdapter;
import com.foodapplication.model.FoodItem;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<FoodItem> foodItemList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Initialize ImageSlider
        ImageSlider imageSlider = view.findViewById(R.id.image_slider);
        List<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.banner1, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner2, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner3, ScaleTypes.FIT));
        imageSlider.setImageList(imageList, ScaleTypes.FIT);

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        foodItemList = new ArrayList<>();

        foodItemList.add(new FoodItem(R.drawable.menu1, "Veg Burger", "$5"));
        foodItemList.add(new FoodItem(R.drawable.menu2, "Margherita Pizza", "$7"));
        foodItemList.add(new FoodItem(R.drawable.menu3, "White Sauce Pasta", "$6"));
        foodItemList.add(new FoodItem(R.drawable.menu4, "Caesar Salad", "$4"));
        foodItemList.add(new FoodItem(R.drawable.menu5, "Vegetable Soup", "$3"));

        PopularAdapter adapter = new PopularAdapter(foodItemList);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
