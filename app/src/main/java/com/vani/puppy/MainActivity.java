package com.vani.puppy;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView rvMascotas;
    private ArrayList<Mascota> mascotas;
    private MascotaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rvMascotas = findViewById(R.id.rvMascotas);
        rvMascotas.setLayoutManager(new LinearLayoutManager(this));

        inicializarListaMascotas();
        inicializarAdapter();
    }

    private void inicializarListaMascotas() {
        mascotas = new ArrayList<>();

        mascotas.add(new Mascota(R.drawable.mascota1, "Koda", 5));
        mascotas.add(new Mascota(R.drawable.mascota2, "Milo", 3));
        mascotas.add(new Mascota(R.drawable.mascota3, "Luna", 4));
        mascotas.add(new Mascota(R.drawable.mascota4, "Simba", 2));
        mascotas.add(new Mascota(R.drawable.mascota5, "Nala", 1));
    }

    private void inicializarAdapter() {
        adapter = new MascotaAdapter(mascotas);
        rvMascotas.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_favoritos) {
            Intent intent = new Intent(MainActivity.this, FavoritosActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}