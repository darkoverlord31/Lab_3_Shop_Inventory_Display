package com.example.lab3_shopinventorydisplay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private List<Item> itemList;
    private Context context;

    public ItemAdapter(List<Item> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.itemName.setText(item.getName());
        holder.itemPrice.setText(String.format("P%.2f", item.getPrice()));

        // Set the appropriate drawable based on category
        switch(item.getCategory()) {
            case "electronics":
                holder.categoryIcon.setImageResource(R.drawable.category_electronics);
                break;
            case "clothing":
                holder.categoryIcon.setImageResource(R.drawable.category_clothing);
                break;
            case "food":
                holder.categoryIcon.setImageResource(R.drawable.category_food);
                break;
            default:
                holder.categoryIcon.setImageResource(R.drawable.category_default);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemName;
        TextView itemPrice;
        ImageView categoryIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.item_name);
            itemPrice = itemView.findViewById(R.id.item_price);
            categoryIcon = itemView.findViewById(R.id.category_icon);
        }
    }
}

