package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Usuario implements Serializable {

    private String nombre;
    private String passwordHash;
    private ArrayList<Nota> notas;

    public Usuario(String nombre, String passwordHash) {
        this.nombre = nombre;
        this.passwordHash = passwordHash;
        this.notas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public ArrayList<Nota> getNotas() {
        return notas;
    }
}