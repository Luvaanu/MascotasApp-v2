package com.vani.puppy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FotoMascotaAdapter extends RecyclerView.Adapter<FotoMascotaAdapter.ViewHolder> {

    private ArrayList<FotoMascota> fotos;

    public FotoMascotaAdapter(ArrayList<FotoMascota> fotos) {
        this.fotos = fotos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_foto_mascota, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FotoMascota foto = fotos.get(position);

        holder.imgFoto.setImageResource(foto.getFoto());
        holder.tvLikes.setText(String.valueOf(foto.getLikes()));
    }

    @Override
    public int getItemCount() {
        return fotos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgFoto;
        TextView tvLikes;

        public ViewHolder(View itemView) {
            super(itemView);

            imgFoto = itemView.findViewById(R.id.imgFotoGrid);
            tvLikes = itemView.findViewById(R.id.tvLikesGrid);
        }
    }
}