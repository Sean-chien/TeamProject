package com.example.pickrecipes;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewListAdapter extends RecyclerView.Adapter<RecyclerViewListAdapter.ViewHolder> {

    private final List<CardList> mDataList;
    private Context mContext;

    public RecyclerViewListAdapter(List<CardList> mDataList, Context mContext) {
        this.mDataList = mDataList;
        this.mContext = mContext;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) { // 뷰홀더 만드는 부분
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_cards, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        CardList list = mDataList.get(i);
        viewHolder.category.setText(list.getCategory());
        viewHolder.title.setText(list.getTitle());
        viewHolder.listThumbnail.setImageResource(list.getListThumbnail());

        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, Contents.class);
                intent.putExtra("Category", mDataList.get(i).getCategory());
                intent.putExtra("Title", mDataList.get(i).getTitle());
                intent.putExtra("ListThumbnail", mDataList.get(i).getListThumbnail());
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    } // 어댑터의 리스트 갯수

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView category;
        TextView title;
        ImageView listThumbnail;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            category = itemView.findViewById(R.id.category_text);
            title = itemView.findViewById(R.id.title_text);
            listThumbnail = itemView.findViewById(R.id.listThumb);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
