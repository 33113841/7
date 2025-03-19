package com.example.a7;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewPets;
    private Button buttonViewBasket;
    private List<Pet> petList;
    private Basket basket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        recyclerViewPets = findViewById(R.id.recyclerViewPets);
        buttonViewBasket = findViewById(R.id.buttonViewBasket);

        // Initialize pet list and basket
        petList = new ArrayList<>();
        basket = new Basket();

        // Add sample pets to the list
        petList.add(new Pet("Chinchilla", 150, R.drawable.chinchilla));
        petList.add(new Pet("Ferret", 200, R.drawable.ferret));
        petList.add(new Pet("Rabbit", 180, R.drawable.rabbit));

        // Set up RecyclerView with PetAdapter
        PetAdapter petAdapter = new PetAdapter(petList, basket);
        recyclerViewPets.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewPets.setAdapter(petAdapter);

        // Set up button to view basket
        buttonViewBasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show basket dialog fragment
                BasketDialogFragment basketDialogFragment = new BasketDialogFragment(basket);
                basketDialogFragment.show(getSupportFragmentManager(), "BasketDialogFragment");
            }
        });
    }
}