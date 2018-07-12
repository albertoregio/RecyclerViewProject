package com.example.regio.recyclerviewproject;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemHolder> {

    private final List<ItemModel> itens;


    public ItemAdapter(ArrayList itens) {
        this.itens = itens;
    }


    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ItemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item_view, parent, false));

    }


    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, final int position) {
        holder.item.setText(itens.get(position).getNome());

        holder.excluir.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View view) {
                                                  final int p = position;
                                                  removeItem(p);
                                              }
                                          }
        );
    }

    @Override
    public int getItemCount() {
        return (itens != null) ? itens.size() : 0;
    }

    public void updateList(ItemModel item) {
        insertItem(item);
    }

    private void insertItem(ItemModel item) {
        itens.add(item);
        notifyItemInserted(getItemCount());
    }

    private void removeItem(int position) {
        itens.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,itens.size());
    }

}
