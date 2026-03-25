package com.vani.puppy;

public class FotoMascota {

    private int foto;
    private int likes;

    public FotoMascota(int foto, int likes) {
        this.foto = foto;
        this.likes = likes;
    }

    public int getFoto() {
        return foto;
    }

    public int getLikes() {
        return likes;
    }
}