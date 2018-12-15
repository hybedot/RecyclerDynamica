package com.android.www.recyclerdynamica.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.www.recyclerdynamica.Model.SectionDataModel;
import com.android.www.recyclerdynamica.R;

import java.util.ArrayList;

public class RecyclerViewDataAdapter extends RecyclerView.Adapter<RecyclerViewDataAdapter.ItemRowHolder>{
    private ArrayList<SectionDataModel> itemList;
    private Context context;

    public RecyclerViewDataAdapter(ArrayList<SectionDataModel> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_recycler,parent,false);
        ItemRowHolder holder = new ItemRowHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemRowHolder holder, int position) {
        String sectionName = itemList.get(position).getHeaderTitle();
        ArrayList singleSectionItem = itemList.get(position).getAllSectionItem();

        holder.header.setText(sectionName);

        SectionListDataAdapter adapter = new SectionListDataAdapter(singleSectionItem, context);
        holder.recyclerView.setHasFixedSize(true);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false));
        holder.recyclerView.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return (null != itemList ? itemList.size() : 0);
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder{
        private TextView header;
        private RecyclerView recyclerView;

        public ItemRowHolder(View itemView) {
            super(itemView);

            header = (TextView)itemView.findViewById(R.id.item_text_view_title);
            recyclerView = (RecyclerView)itemView.findViewById(R.id.item_recycler_view);
        }
    }
}
