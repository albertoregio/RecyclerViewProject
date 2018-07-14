package com.example.regio.recyclerviewproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_recycleview) //recView = findViewById(R.id.main_recycleview);
    RecyclerView recView;

    @BindView(R.id.edtNome)
    TextView edtNome;

    private ItemAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setupRecycler();
    }

    private void setupRecycler() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recView.setLayoutManager(layoutManager);

        itemAdapter = new ItemAdapter(new ArrayList<>(0));
        recView.setAdapter(itemAdapter);

        recView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    @OnClick(R.id.btnIncluir)
    public void incluir() {

        ItemModel itemModel = new ItemModel();
        itemModel.setNome(edtNome.getText().toString());

        edtNome.setText("");
        itemAdapter.insertItem(itemModel);

        //edtNome.requestFocus();
    }
}
