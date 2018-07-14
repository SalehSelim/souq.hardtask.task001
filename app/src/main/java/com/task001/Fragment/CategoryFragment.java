package com.task001.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.task001.Adapter.CategoryAdapter;
import com.task001.Api.ApiManager;
import com.task001.Api.ApiResponse;
import com.task001.Model.Category;
import com.task001.R;

import java.util.ArrayList;

public class CategoryFragment extends Fragment implements ApiResponse {
    private RecyclerView recycler_view;
    private ArrayList<Category> categories = new ArrayList<>();
    private Context context;
    private ApiResponse apiResponse;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.fragment_category, container, false);
        context = container.getContext();
        apiResponse = this;
        recycler_view = (RecyclerView) fragment.findViewById(R.id.recycler_view);
        ApiManager.getCategories(apiResponse);
        return fragment;
    }

    @Override
    public void onSuccess(Object response) {
        if (response != null) {
            categories = (ArrayList<Category>) response;
            CategoryAdapter adapter = new CategoryAdapter(context, categories);
            recycler_view.setLayoutManager(new GridLayoutManager(context, 2));
            recycler_view.setAdapter(adapter);
        }
    }

    @Override
    public void onFailure(Throwable error) {
        Toast.makeText(context, "No Internet Connection", Toast.LENGTH_LONG).show();

    }
}
