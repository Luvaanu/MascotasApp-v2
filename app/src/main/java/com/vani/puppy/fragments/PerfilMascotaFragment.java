package com.vani.puppy.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vani.puppy.FotoMascota;
import com.vani.puppy.FotoMascotaAdapter;
import com.vani.puppy.R;

import java.util.ArrayList;

public class PerfilMascotaFragment extends Fragment {

    private RecyclerView rvPerfil;
    private ArrayList<FotoMascota> fotos;

    public PerfilMascotaFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_perfil_mascota, container, false);

        rvPerfil = v.findViewById(R.id.rvPerfil);
        rvPerfil.setLayoutManager(new GridLayoutManager(getActivity(), 3));

        inicializarFotos();

        FotoMascotaAdapter adapter = new FotoMascotaAdapter(fotos);
        rvPerfil.setAdapter(adapter);

        return v;
    }

    private void inicializarFotos() {
        fotos = new ArrayList<>();

        fotos.add(new FotoMascota(R.drawable.mascota1, 5));
        fotos.add(new FotoMascota(R.drawable.mascota2, 3));
        fotos.add(new FotoMascota(R.drawable.mascota3, 7));
        fotos.add(new FotoMascota(R.drawable.mascota4, 2));
        fotos.add(new FotoMascota(R.drawable.mascota5, 6));
        fotos.add(new FotoMascota(R.drawable.mascota6, 4));
    }
}