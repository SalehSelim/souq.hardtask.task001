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

public class SubCategoryFragment extends Fragment implements ApiResponse {

    private RecyclerView recycler_view;
    private ArrayList<Category> subCategories = new ArrayList<>();
    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.fragment_category, container, false);
        context = container.getContext();
        Bundle bundle = getArguments();
        String categoryId = bundle.getString("categoryId");
        recycler_view = (RecyclerView) fragment.findViewById(R.id.recycler_view);
        ApiManager.getSubCategories(this, categoryId);
        return fragment;
    }


    @Override
    public void onSuccess(Object response) {
        if (response != null) {
            subCategories = (ArrayList<Category>) response;
            if (subCategories.size() == 0) {
                Toast.makeText(context, "There is no sub category for this category", Toast.LENGTH_LONG).show();

            } else {
                CategoryAdapter adapter = new CategoryAdapter(context, subCategories);
                recycler_view.setLayoutManager(new GridLayoutManager(context, 2));
                recycler_view.setAdapter(adapter);
            }
        }
    }

    @Override
    public void onFailure(Throwable error) {
        Toast.makeText(context, "No Internet Connection", Toast.LENGTH_LONG).show();
    }

}
