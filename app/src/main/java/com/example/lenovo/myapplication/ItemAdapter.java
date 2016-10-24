package com.example.lenovo.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lenovo on 10/24/2016.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.VH> {
    List<ItemModel> mDataset;

    public ItemAdapter(List<ItemModel> mDataset) {
        this.mDataset = mDataset;
    }

    @Override

    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        ItemModel model = mDataset.get(position);
        holder.textView.setText(model.getOverView());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public static class VH extends RecyclerView.ViewHolder {
        TextView textView;

        public VH(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.textView);
        }
    }
}
