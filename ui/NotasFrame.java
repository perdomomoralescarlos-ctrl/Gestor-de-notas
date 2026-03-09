package ui;

import model.Nota;
import model.Usuario;
import persistence.GestorArchivos;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class NotasFrame extends JFrame {

    private Usuario usuario;
    private ArrayList<Usuario> usuarios;

    private DefaultListModel<Nota> modeloLista;
    private JList<Nota> listaNotas;

    private JTextField txtTitulo;
    private JTextArea txtContenido;

    public NotasFrame(Usuario usuario, ArrayList<Usuario> usuarios){

        this.usuario = usuario;
        this.usuarios = usuarios;

        setTitle("Gestor de Notas - " + usuario.getNombre());
        setSize(600,400);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        modeloLista = new DefaultListModel<>();

        for(Nota n : usuario.getNotas()){
            modeloLista.addElement(n);
        }

        listaNotas = new JList<>(modeloLista);

        add(new JScrollPane(listaNotas),BorderLayout.WEST);

        JPanel panelCentro = new JPanel(new BorderLayout());

        txtTitulo = new JTextField();
        txtContenido = new JTextArea();

        panelCentro.add(txtTitulo,BorderLayout.NORTH);
        panelCentro.add(new JScrollPane(txtContenido),BorderLayout.CENTER);

        add(panelCentro,BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();

        JButton crear = new JButton("Crear");
        JButton editar = new JButton("Editar");
        JButton borrar = new JButton("Borrar");
        JButton limpiar = new JButton("Limpiar");

        panelBotones.add(crear);
        panelBotones.add(editar);
        panelBotones.add(borrar);
        panelBotones.add(limpiar);

        add(panelBotones,BorderLayout.SOUTH);

        listaNotas.addListSelectionListener(e -> cargarNota());

        crear.addActionListener(e -> crearNota());
        editar.addActionListener(e -> editarNota());
        borrar.addActionListener(e -> borrarNota());
        limpiar.addActionListener(e -> limpiar());

        setVisible(true);
    }

    private void crearNota(){

        Nota n = new Nota(txtTitulo.getText(),txtContenido.getText());

        usuario.getNotas().add(n);
        modeloLista.addElement(n);

        guardar();
    }

    private void editarNota(){

        Nota n = listaNotas.getSelectedValue();

        if(n==null){
            JOptionPane.showMessageDialog(this,"Selecciona una nota");
            return;
        }

        n.setTitulo(txtTitulo.getText());
        n.setContenido(txtContenido.getText());

        listaNotas.repaint();

        guardar();
    }

    private void borrarNota(){

        Nota n = listaNotas.getSelectedValue();

        if(n==null) return;

        usuario.getNotas().remove(n);
        modeloLista.removeElement(n);

        guardar();
    }

    private void cargarNota(){

        Nota n = listaNotas.getSelectedValue();

        if(n!=null){

            txtTitulo.setText(n.getTitulo());
            txtContenido.setText(n.getContenido());

        }

    }

    private void limpiar(){

        txtTitulo.setText("");
        txtContenido.setText("");

    }

    private void guardar(){

        GestorArchivos.guardarUsuarios(usuarios);

    }
}