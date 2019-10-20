package com.israt.jahan.testbookreaderapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.israt.jahan.testbookreaderapp.model.CategoryDatum;
import com.israt.jahan.testbookreaderapp.ui.adapter.RecyclerViewClickListener;

import java.util.ArrayList;
import java.util.List;

public class SameCategoryAdapter extends RecyclerView.Adapter<SameCategoryAdapter.ViewHolder> {

    Context context;
    List<CategoryDatum> bookList;
    private RecyclerViewClickListener recyclerViewClickListener;

    public SameCategoryAdapter(Context context, List<CategoryDatum> bookList, RecyclerViewClickListener recyclerViewClickListener) {
        this.context = context;
        this.bookList = bookList;
        this.recyclerViewClickListener = recyclerViewClickListener;
    }

    @NonNull
    @Override
    public SameCategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.same_category_list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {



        ArrayList singleSectionItems = (ArrayList) bookList.get(position).getBookData();


        SectionListDataAdapter itemListDataAdapter = new SectionListDataAdapter(context, singleSectionItems, recyclerViewClickListener);

        ((TextView)holder.itemView.findViewById(R.id.sameCateTitle)).setText(bookList.get(position).getCategoryName());

        ((RecyclerView)holder.itemView.findViewById(R.id.same_category_listRV)).setHasFixedSize(true);
        ((RecyclerView)holder.itemView.findViewById(R.id.same_category_listRV)).setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        ((RecyclerView)holder.itemView.findViewById(R.id.same_category_listRV)).setAdapter(itemListDataAdapter);

    }



    @Override
    public int getItemCount() {

        return bookList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
