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
public class BasketAdapter extends RecyclerView.Adapter<BasketAdapter.BasketViewHolder> {
    private List<BasketItem> basketItemList;

    public static class BasketViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewPetName, textViewPetPrice, textViewQuantity;

        public BasketViewHolder(View itemView) {
            super(itemView);
            textViewPetName = itemView.findViewById(R.id.textViewPetName);
            textViewPetPrice = itemView.findViewById(R.id.textViewPetPrice);
            textViewQuantity = itemView.findViewById(R.id.textViewQuantity);
        }
    }

    public BasketAdapter(List<BasketItem> basketItemList) {
        this.basketItemList = basketItemList;
    }

    @Override
    public BasketViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_basket, parent, false);
        return new BasketViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BasketViewHolder holder, int position) {
        BasketItem basketItem = basketItemList.get(position);
        holder.textViewPetName.setText(basketItem.getPetName());
        holder.textViewPetPrice.setText("£" + basketItem.getPetPrice());
        holder.textViewQuantity.setText(String.valueOf(basketItem.getQuantity()));
    }

    @Override
    public int getItemCount() {
        return basketItemList.size();
    }
}