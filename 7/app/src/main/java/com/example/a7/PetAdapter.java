package com.example.a7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.PetViewHolder> {

    private List<Pet> petList;
    private Basket basket;

    public PetAdapter(List<Pet> petList, Basket basket) {
        this.petList = petList;
        this.basket = basket;
    }

    @NonNull
    @Override
    public PetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pet, parent, false);
        return new PetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PetViewHolder holder, int position) {
        Pet pet = petList.get(position);
        holder.imageViewPet.setImageResource(pet.getImageResId());
        holder.textViewPetName.setText(pet.getName());
        holder.textViewPetPrice.setText("£" + pet.getPrice());
        holder.numberPickerQuantity.setValue(1);

        // Set up button to add pet to basket
        holder.buttonAddToBasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantity = holder.numberPickerQuantity.getValue();
                basket.addItem(new BasketItem(pet, quantity));
                // Show toast message
                Toast.makeText(v.getContext(), pet.getName() + " added to basket", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return petList.size();
    }

    public static class PetViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewPet;
        TextView textViewPetName;
        TextView textViewPetPrice;
        NumberPicker numberPickerQuantity;
        Button buttonAddToBasket;

        public PetViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewPet = itemView.findViewById(R.id.imageViewPet);
            textViewPetName = itemView.findViewById(R.id.textViewPetName);
            textViewPetPrice = itemView.findViewById(R.id.textViewPetPrice);
            numberPickerQuantity = itemView.findViewById(R.id.numberPickerQuantity);
            buttonAddToBasket = itemView.findViewById(R.id.buttonAddToBasket);
        }
    }
}