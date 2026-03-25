package com.vani.puppy;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FavoritosActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView rvFavoritos;
    private ArrayList<Mascota> favoritas;
    private MascotaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        toolbar = findViewById(R.id.toolbarFavoritos);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        rvFavoritos = findViewById(R.id.rvFavoritos);
        rvFavoritos.setLayoutManager(new LinearLayoutManager(this));

        inicializarListaFavoritas();
        inicializarAdapter();
    }

    private void inicializarListaFavoritas() {
        favoritas = new ArrayList<>();

        favoritas.add(new Mascota(R.drawable.mascota1, "Koda", 5));
        favoritas.add(new Mascota(R.drawable.mascota2, "Milo", 4));
        favoritas.add(new Mascota(R.drawable.mascota3, "Luna", 3));
        favoritas.add(new Mascota(R.drawable.mascota4, "Simba", 2));
        favoritas.add(new Mascota(R.drawable.mascota5, "Nala", 1));
    }

    private void inicializarAdapter() {
        adapter = new MascotaAdapter(favoritas);
        rvFavoritos.setAdapter(adapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}