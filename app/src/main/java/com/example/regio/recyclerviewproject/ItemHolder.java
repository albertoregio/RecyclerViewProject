package com.example.regio.recyclerviewproject;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ItemHolder extends RecyclerView.ViewHolder {

    public TextView item;
    public Button excluir;

    public ItemHolder(View itemView) {
        super(itemView);

        item = (TextView) itemView.findViewById(R.id.main_item_title);
        excluir = (Button) itemView.findViewById(R.id.main_delete_button);
    }
}
