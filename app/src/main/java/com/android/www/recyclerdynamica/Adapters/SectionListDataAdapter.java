package com.android.www.recyclerdynamica.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.www.recyclerdynamica.Model.SingleItemModel;
import com.android.www.recyclerdynamica.R;

import java.util.ArrayList;

public class SectionListDataAdapter extends RecyclerView.Adapter<SectionListDataAdapter.SingleItemRowHolder>  {
    private ArrayList<SingleItemModel> itemList;
    private Context context;

    public SectionListDataAdapter(ArrayList<SingleItemModel> itemlist, Context context) {
        this.itemList = itemlist;
        this.context = context;
    }

    @NonNull
    @Override
    public SingleItemRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_card,parent,false);
        SingleItemRowHolder holder = new SingleItemRowHolder(v);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull SingleItemRowHolder holder, int position) {
        holder.title.setText(itemList.get(position).getName());
        if (position%2 == 0){
            holder.imageView.setImageResource(R.drawable.fanman);
        }else {
            holder.imageView.setImageResource(R.drawable.spiderman);
        }
    }

    @Override
    public int getItemCount() {
        return (null != itemList ? itemList.size() : 0);
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView title;
        public SingleItemRowHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView)itemView.findViewById(R.id.list_item_card_img);
            this.title = (TextView)itemView.findViewById(R.id.list_item_card_text_view);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(),title.getText(),Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
