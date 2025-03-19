package com.example.a7;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class OrdersActivity extends AppCompatActivity {

    private RecyclerView recyclerViewOrders;
    private TextView textViewTotalAmount;
    private Button buttonGoBackToProducts;
    private Button buttonCheckout;
    private Basket basket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

        // Initialize views
        recyclerViewOrders = findViewById(R.id.recyclerViewOrders);
        textViewTotalAmount = findViewById(R.id.textViewTotalAmount);
        buttonGoBackToProducts = findViewById(R.id.buttonGoBackToProducts);
        buttonCheckout = findViewById(R.id.buttonCheckout);

        // Get basket from intent
        basket = (Basket) getIntent().getSerializableExtra("basket");

        // Set up RecyclerView with OrdersAdapter
        OrdersAdapter ordersAdapter = new OrdersAdapter(basket.getItems());
        recyclerViewOrders.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewOrders.setAdapter(ordersAdapter);

        // Display total amount
        textViewTotalAmount.setText("Total you need to pay: £" + basket.getTotalPrice());

        // Set up button to go back to products
        buttonGoBackToProducts.setOnClickListener(v -> {
            // Show toast message
            Toast.makeText(OrdersActivity.this, "Going back to products", Toast.LENGTH_SHORT).show();
            finish();
        });

        // Set up button to checkout
        buttonCheckout.setOnClickListener(v -> {
            // Show toast message
            Toast.makeText(OrdersActivity.this, "Checking out", Toast.LENGTH_SHORT).show();
            // Handle checkout logic
        });
    }
}