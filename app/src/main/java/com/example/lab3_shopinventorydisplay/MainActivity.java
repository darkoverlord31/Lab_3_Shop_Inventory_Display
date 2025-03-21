package com.example.lab3_shopinventorydisplay;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ItemAdapter adapter;
    private List<Item> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize the item list
        itemList = new ArrayList<>();

        // Add sample items
        itemList.add(new Item("Laptop", 5799.95, "electronics"));
        itemList.add(new Item("T-Shirt", 120.00, "clothing"));
        itemList.add(new Item("Headphones", 249.95, "electronics"));
        itemList.add(new Item("Jeans", 300.00, "clothing"));
        itemList.add(new Item("Air Fryer", 600.00, "electronics"));
        itemList.add(new Item("Sneakers", 740.00, "clothing"));
        itemList.add(new Item("Corn Flakes", 48.95, "food"));

        // Set up the adapter
        adapter = new ItemAdapter(itemList, this);
        recyclerView.setAdapter(adapter);
    }
}