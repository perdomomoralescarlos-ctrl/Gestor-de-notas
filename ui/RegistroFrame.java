package ui;

import model.Usuario;
import persistence.GestorArchivos;
import security.HashUtil;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RegistroFrame extends JFrame {

    public RegistroFrame(ArrayList<Usuario> usuarios){

        setTitle("Registro");
        setSize(300,200);
        setLayout(new GridLayout(3,2));

        JTextField txtUser = new JTextField();
        JPasswordField txtPass = new JPasswordField();

        JButton btnCrear = new JButton("Crear");

        add(new JLabel("Usuario"));
        add(txtUser);

        add(new JLabel("Password"));
        add(txtPass);

        add(btnCrear);

        btnCrear.addActionListener(e->{

            String user = txtUser.getText();
            String pass = HashUtil.hash(new String(txtPass.getPassword()));

            usuarios.add(new Usuario(user,pass));

            GestorArchivos.guardarUsuarios(usuarios);

            JOptionPane.showMessageDialog(this,"Usuario creado");

            dispose();

        });

        setVisible(true);
    }
}