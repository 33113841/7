package com.example.a7;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class BasketDialogFragment extends DialogFragment {

    private Basket basket;
    private RecyclerView recyclerViewBasketItems;
    private TextView textViewTotalPrice;
    private Button buttonCheckout;

    public BasketDialogFragment(Basket basket) {
        this.basket = basket;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.basket_dialog, container, false);

        // Initialize views
        recyclerViewBasketItems = view.findViewById(R.id.recyclerViewBasketItems);
        textViewTotalPrice = view.findViewById(R.id.textViewTotalPrice);
        buttonCheckout = view.findViewById(R.id.buttonCheckout);

        // Set up RecyclerView with BasketAdapter
        BasketAdapter basketAdapter = new BasketAdapter(basket.getItems());
        recyclerViewBasketItems.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewBasketItems.setAdapter(basketAdapter);

        // Display total price
        textViewTotalPrice.setText("Total: £" + basket.getTotalPrice());

        // Set up button to checkout
        buttonCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show toast message
                Toast.makeText(getContext(), "Proceeding to checkout", Toast.LENGTH_SHORT).show();
                // Start OrdersActivity
                Intent intent = new Intent(getContext(), OrdersActivity.class);
                intent.putExtra("basket", basket);
                startActivity(intent);
                dismiss();
            }
        });

        return view;
    }
}