package com.israt.jahan.testbookreaderapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.israt.jahan.testbookreaderapp.model.BookData;
import com.israt.jahan.testbookreaderapp.ui.adapter.RecyclerViewClickListener;

public class RecyclerViewDataAdapter extends RecyclerView.Adapter<RecyclerViewDataAdapter.ItemRowHolder> {

    private BookData dataList;
    private Context mContext;
    private RecyclerViewClickListener recyclerViewClickListener;

    public RecyclerViewDataAdapter(Context context, BookData dataList, RecyclerViewClickListener recyclerViewClickListener) {
        this.dataList = dataList;
        this.mContext = context;
        this.recyclerViewClickListener = recyclerViewClickListener;
    }

    @Override
    public ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, null);
        ItemRowHolder mh = new ItemRowHolder(view);
        return mh;
    }

    @Override
    public void onBindViewHolder(ItemRowHolder itemRowHolder, int i) {

        SameCategoryAdapter sameCategoryAdapter=new SameCategoryAdapter(mContext, (dataList.getDbData().get(i).getCategoryData()),recyclerViewClickListener);
        itemRowHolder.itemTitle.setText(dataList.getDbData().get(i).getCategoryName());
        itemRowHolder.recycler_view_list.setHasFixedSize(true);
        itemRowHolder.recycler_view_list.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        itemRowHolder.recycler_view_list.setAdapter(sameCategoryAdapter);



       /* Glide.with(mContext)
                .load(feedItem.getImageURL())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .error(R.drawable.bg)
                .into(feedListRowHolder.thumbView);*/
    }

    @Override
    public int getItemCount() {
        return (null != dataList ? dataList.getDbData().size() : 0);
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {

        protected TextView itemTitle;
        protected RecyclerView recycler_view_list;
        protected Button btnMore;

        public ItemRowHolder(View view) {
            super(view);

            this.itemTitle = (TextView) view.findViewById(R.id.itemTitle);
            this.recycler_view_list = (RecyclerView) view.findViewById(R.id.recycler_view_list);
            this.btnMore = (Button) view.findViewById(R.id.btnMore);

        }

    }

    }
