package com.example.regio.recyclerviewproject;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

// Classe responsavel por controlar os itens que serao exibidas na tela
public class ItemAdapter extends RecyclerView.Adapter<ItemHolder> {

    // Declaracao de variaveis
    private final List<ItemModel> itens;


    // Construtor da classe
    public ItemAdapter(ArrayList itens) {
        this.itens = itens;
    }


    // Metodo responsavel pela criacao da classe que representa a tela
    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item_view, parent, false));
    }


    // Metodo responsavel pela a alimentacao dos dados da tela
    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, final int position) {
        holder.item.setText(itens.get(position).getNome());

        holder.excluir.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View view) {
                                                  final int p = position;
                                                  deleteItem(p);
                                              }
                                          }
        );
    }


    // Recupera quantos itens de dados existem
    @Override
    public int getItemCount() {
        return (itens != null) ? itens.size() : 0;
    }


    // Insere na tela um novo item
    public void insertItem(ItemModel item) {
        itens.add(item);
        notifyItemInserted(getItemCount());
    }


    // Remove da tela um item na posicao determinada
    public void deleteItem(int position) {
        itens.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, itens.size());
    }

}
