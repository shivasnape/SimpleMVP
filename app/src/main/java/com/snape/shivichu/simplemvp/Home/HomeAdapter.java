package com.snape.shivichu.simplemvp.Home;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.snape.shivichu.simplemvp.R;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private List<String> items;
    private com.snape.shivichu.simplemvp.Home.HomeAdapter.Listener listener;


    public HomeAdapter(List<String> items, com.snape.shivichu.simplemvp.Home.HomeAdapter.Listener listener) {
        this.items = items;
        this.listener = listener;
    }

    public interface Listener {
        void onItemClicked(String item);
    }


    @NonNull
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_view, parent, false);
        return new HomeAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final HomeAdapter.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        final String item = items.get(position);

        holder.textView.setText(item);
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClicked(item);
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        ViewHolder(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.text_view);

        }
    }
}
