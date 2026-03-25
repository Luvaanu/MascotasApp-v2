package com.vani.puppy.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vani.puppy.Mascota;
import com.vani.puppy.MascotaAdapter;
import com.vani.puppy.R;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {

    private RecyclerView rvMascotas;
    private ArrayList<Mascota> mascotas;
    private MascotaAdapter adapter;

    public RecyclerViewFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        rvMascotas = v.findViewById(R.id.rvMascotas);
        rvMascotas.setLayoutManager(new LinearLayoutManager(getActivity()));

        inicializarListaMascotas();
        inicializarAdapter();

        return v;
    }

    private void inicializarListaMascotas() {
        mascotas = new ArrayList<>();

        mascotas.add(new Mascota(R.drawable.mascota1, "Koda", 5));
        mascotas.add(new Mascota(R.drawable.mascota2, "Milo", 4));
        mascotas.add(new Mascota(R.drawable.mascota3, "Luna", 3));
        mascotas.add(new Mascota(R.drawable.mascota4, "Simba", 2));
        mascotas.add(new Mascota(R.drawable.mascota5, "Nala", 1));
        mascotas.add(new Mascota(R.drawable.mascota6, "Ronny", 3));
    }

    private void inicializarAdapter() {
        adapter = new MascotaAdapter(mascotas);
        rvMascotas.setAdapter(adapter);
    }
}