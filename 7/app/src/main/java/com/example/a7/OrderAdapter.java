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
public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {
    private List<Order> orderList;

    public static class OrderViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewPetName, textViewPetPrice, textViewQuantity, textViewTotal;

        public OrderViewHolder(View itemView) {
            super(itemView);
            textViewPetName = itemView.findViewById(R.id.textViewPetName);
            textViewPetPrice = itemView.findViewById(R.id.textViewPetPrice);
            textViewQuantity = itemView.findViewById(R.id.textViewQuantity);
            textViewTotal = itemView.findViewById(R.id.textViewTotal);
        }
    }

    public OrderAdapter(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public OrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_order, parent, false);
        return new OrderViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(OrderViewHolder holder, int position) {
        Order order = orderList.get(position);
        holder.textViewPetName.setText(order.getPetName());
        holder.textViewPetPrice.setText("£" + order.getPetPrice());
        holder.textViewQuantity.setText(String.valueOf(order.getQuantity()));
        holder.textViewTotal.setText("£" + order.getTotal());
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }
}