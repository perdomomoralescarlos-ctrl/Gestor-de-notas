package ui;

import model.Usuario;
import persistence.GestorArchivos;
import security.HashUtil;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LoginFrame extends JFrame {

    private JTextField txtUsuario;
    private JPasswordField txtPassword;

    private ArrayList<Usuario> usuarios;

    public LoginFrame() {

        usuarios = GestorArchivos.cargarUsuarios();

        setTitle("Login");
        setSize(300,200);
        setLayout(new GridLayout(4,2));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        txtUsuario = new JTextField();
        txtPassword = new JPasswordField();

        JButton btnLogin = new JButton("Login");
        JButton btnRegistro = new JButton("Registrarse");

        add(new JLabel("Usuario"));
        add(txtUsuario);

        add(new JLabel("Password"));
        add(txtPassword);

        add(btnLogin);
        add(btnRegistro);

        btnLogin.addActionListener(e -> login());
        btnRegistro.addActionListener(e -> new RegistroFrame(usuarios));

        setVisible(true);
    }

    private void login() {

        String user = txtUsuario.getText();
        String pass = HashUtil.hash(new String(txtPassword.getPassword()));

        for(Usuario u : usuarios){

            if(u.getNombre().equals(user) &&
                    u.getPasswordHash().equals(pass)){

                new NotasFrame(u,usuarios);
                dispose();
                return;
            }

        }

        JOptionPane.showMessageDialog(this,"Credenciales incorrectas");

    }
}