package com.example.lenovo.myapplication;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ItemFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private List<ItemModel> mDataSet;

    public ItemFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataSet = new ArrayList<>();

        initDataset();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_item, container, false);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);

        mLayoutManager = new GridLayoutManager(getActivity(),2);

        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new ItemAdapter(mDataSet, getContext());

        mRecyclerView.setAdapter(mAdapter);


        return rootView;

    }

    private void initDataset() {

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Constants.URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("results");

                            for (int i = 0; i < jsonArray.length(); i++) {

                                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                                String overView = jsonObject1.getString("poster_path");

                                ItemModel model = new ItemModel(overView);
                                mDataSet.add(model);

                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        ;


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        requestQueue.add(stringRequest);


    }
}
