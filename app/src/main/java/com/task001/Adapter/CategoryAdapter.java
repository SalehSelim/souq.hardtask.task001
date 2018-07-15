package com.task001.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.task001.Fragment.CategoryFragment;
import com.task001.Fragment.SubCategoryFragment;
import com.task001.Model.Category;
import com.task001.R;
import com.task001.Utilities.Constants;
import com.task001.Utilities.Utilities;

import java.util.ArrayList;

/**
 * Created by ssasa on 07-Jul-18.
 */

public class CategoryAdapter extends RecyclerView.Adapter <CategoryAdapter.CategoryViewHolder>{
    private ArrayList <Category> categories;
    private CardView recycler_item ;
    private Context context;

    public CategoryAdapter(Context context , ArrayList<Category> categories)
    {
        this.context = context;
        this.categories =categories;
    }
    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_item,parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CategoryViewHolder holder, final int position) {
        if (Utilities.getPreference(context ,Constants.SELECTED_LANGUAGE).equals(Constants.ARABIC)) {

            holder.cat_name.setText(categories.get(position).getTitleAR() + " (" + categories.get(position).getProductCount() + ")");
        }
        else
        {
            holder.cat_name.setText(categories.get(position).getTitleEN() + " (" + categories.get(position).getProductCount() + ")");

        }
        if(categories.get(position).getPhoto()!=null)
        {
        Picasso.with(context)
                .load(categories.get(position).getPhoto())
                .into( holder.cat_image);
            if (holder.cat_image.getDrawable() == null)
            {
                holder.cat_image.setImageResource(R.drawable.cat_no_img);
            }
        }
       recycler_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    initiateToolbar(activity,position);
                    SubCategoryFragment subCategoryFragment = new SubCategoryFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("categoryId",categories.get(position).getId());
                    subCategoryFragment.setArguments(bundle);
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.fl_fragment, subCategoryFragment).addToBackStack("").commit();
                }
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }


    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        private TextView cat_name;
        private ImageView cat_image ;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            recycler_item = (CardView) itemView.findViewById(R.id.cat_item);
            cat_name = (TextView) itemView.findViewById(R.id.cat_name);
            Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Montserrat-Regular.ttf");
            cat_name.setTypeface(typeface);
            cat_image = (ImageView) itemView.findViewById(R.id.cat_image);
        }
    }

    private void initiateToolbar(AppCompatActivity activity ,int position)
    {
        final Toolbar toolbar = (Toolbar) activity.findViewById(R.id.toolbar);
        TextView title = (TextView)toolbar.findViewById(R.id.bar_title);
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Montserrat-Regular.ttf");
        title.setTypeface(typeface);
        if (Utilities.getPreference(context ,Constants.SELECTED_LANGUAGE).equals(Constants.ARABIC)) {
            title.setText(categories.get(position).getTitleAR());
        }
        else {
            title.setText(categories.get(position).getTitleEN());
        }
        toolbar.findViewById(R.id.logo).setVisibility(View.GONE);
        toolbar.findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                toolbar.findViewById(R.id.logo).setVisibility(View.VISIBLE);
                CategoryFragment categoryFragment = new CategoryFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fl_fragment, categoryFragment).addToBackStack("").commit();
            }
        });
        activity.setSupportActionBar(toolbar);
    }
}
