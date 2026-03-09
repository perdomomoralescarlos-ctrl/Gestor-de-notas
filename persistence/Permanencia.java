package persistence;

import model.Usuario;

import java.io.*;
import java.util.ArrayList;

public class Permanencia {

    private static final String ARCHIVO = "usuarios.dat";

    public static void guardarUsuarios(ArrayList<Usuario> usuarios) {

        try {

            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(ARCHIVO));

            oos.writeObject(usuarios);
            oos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Usuario> cargarUsuarios() {

        try {

            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(ARCHIVO));

            ArrayList<Usuario> usuarios = (ArrayList<Usuario>) ois.readObject();

            ois.close();

            return usuarios;

        } catch (Exception e) {

            return new ArrayList<>();

        }
    }
}