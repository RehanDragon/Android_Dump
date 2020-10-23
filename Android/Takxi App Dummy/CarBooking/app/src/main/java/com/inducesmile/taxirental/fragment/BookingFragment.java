package com.inducesmile.taxirental.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.inducesmile.taxirental.R;
import com.inducesmile.taxirental.adapter.ListingAdapter;
import com.inducesmile.taxirental.models.CarCategoryObject;

import java.util.ArrayList;
import java.util.List;


public class BookingFragment extends Fragment {

    private static final String TAG = BookingFragment.class.getSimpleName();

    private RecyclerView bookingRecyclerView;


    public BookingFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_booking, container, false);

        bookingRecyclerView = (RecyclerView)view.findViewById(R.id.car_list);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        bookingRecyclerView.setLayoutManager(gridLayoutManager);
        bookingRecyclerView.setHasFixedSize(true);

        ListingAdapter mAdapter = new ListingAdapter(getActivity(), getTextData());
        bookingRecyclerView.setAdapter(mAdapter);

        return view;
    }

    private List<CarCategoryObject> getTextData() {

        List<CarCategoryObject> carData = new ArrayList<>();
        carData.add(new CarCategoryObject("", "BMW"));
        carData.add(new CarCategoryObject("", "TOYOTA"));
        carData.add(new CarCategoryObject("", "FORD"));
        carData.add(new CarCategoryObject("", "NISSAN"));
        carData.add(new CarCategoryObject("", "SAAB"));
        carData.add(new CarCategoryObject("", "VOLVO"));

        return carData;
    }

}
