package com.israt.jahan.testbookreaderapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.israt.jahan.testbookreaderapp.model.Book;
import com.israt.jahan.testbookreaderapp.ui.adapter.RecyclerViewClickListener;

import java.util.ArrayList;

public class SectionListDataAdapter extends RecyclerView.Adapter<SectionListDataAdapter.SingleItemRowHolder> {

    private ArrayList<Book> itemsList;
    private Context mContext;
    private RecyclerViewClickListener recyclerViewClickListener;

    public SectionListDataAdapter(Context context, ArrayList<Book> itemsList, RecyclerViewClickListener recyclerViewClickListener) {
        this.mContext = context;
        this.itemsList = itemsList;
        this.recyclerViewClickListener = recyclerViewClickListener;
    }

    @Override
    public SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_single_card, null);
        SingleItemRowHolder mh = new SingleItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(SingleItemRowHolder holder, final int i) {


//        holder.tvTitle.setText(itemsList.get(i).getBookName());

        CardView itemLinear=holder.itemView.findViewById(R.id.itemLinear);

        TextView bookName=holder.itemView.findViewById(R.id.tvTitle);
        TextView authorName=holder.itemView.findViewById(R.id.authorTV);
        ImageView bookImageIV=holder.itemView.findViewById(R.id.itemImage);
        bookName.setText(itemsList.get(i).getBookName());
        authorName.setText(itemsList.get(i).getBookAuthor());
        bookImageIV.setImageBitmap(ProjectHelper.getImage(mContext, itemsList.get(i).getCoverPath()));

        itemLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(v.getContext(),itemsList.get(i).getBookName(), Toast.LENGTH_SHORT).show();
                if(recyclerViewClickListener != null){
                    recyclerViewClickListener.onClick(itemsList.get(i));
                }

            }
        });


       /* Glide.with(mContext)
                .load(feedItem.getImageURL())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .error(R.drawable.bg)
                .into(feedListRowHolder.thumbView);*/
    }

    @Override
    public int getItemCount() {

        return (null != itemsList ? itemsList.size() : 0);
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {

        protected TextView tvTitle;

        protected ImageView itemImage;


        public SingleItemRowHolder(View view) {
            super(view);

            this.tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            this.itemImage = (ImageView) view.findViewById(R.id.itemImage);

        }

    }



}
