package proyectoFinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Editor extends JFrame implements ActionListener {
    private JButton negr;
    private JButton curs;
    private JButton subr;
    private JComboBox formato;
    private JComboBox tamanyo;
    private JButton color;
    private JPanel fondo;
    private JTextArea box;

    public Editor() {
        setTitle("Editor de Texto");
        setSize(790,610);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        fondo = new JPanel();
        fondo.setLayout(null);
        fondo.setBounds(0,0,30000,30000);
        fondo.setBackground(new java.awt.Color(204, 187, 187));
        add(fondo);

        negr = new JButton("Negrita");
        negr.setBounds(10,20,100,30);
        negr.addActionListener(this);
        negr.setBackground(new java.awt.Color(255, 255, 255));
        fondo.add(negr);

        JScrollPane scroll = new JScrollPane();

        curs = new JButton("Cursiva");
        curs.setBounds(150,20,100,30);
        curs.addActionListener(this);
        curs.setBackground(new java.awt.Color(255, 255, 255));
        fondo.add(curs);

        subr = new JButton("Subrayado");
        subr.setBounds(290,20,100,30);
        subr.addActionListener(this);
        subr.setBackground(new java.awt.Color(255, 255, 255));
        fondo.add(subr);

        formato = new JComboBox(new String[]{"Arial", "Verdana", "Times New Roman", "Calibri", "Stardew"});
        formato.setBounds(430,20,80,30);
        formato.addActionListener(this);
        formato.setBackground(new java.awt.Color(255, 255, 255));
        fondo.add(formato);

        tamanyo = new JComboBox(new Integer[]{8,10,12,14,16,18,20});
        tamanyo.setBounds(550,20,80,30);
        tamanyo.addActionListener(this);
        tamanyo.setBackground(new java.awt.Color(255, 255, 255));
        fondo.add(tamanyo);

        box = new JTextArea();
        box.setBackground(new java.awt.Color(255, 255, 255));
        box.setBounds(10,60,750,500);
        fondo.add(box);

        color = new JButton("Color");
        color.setBounds(670,20,80,30);
        color.setBackground(new java.awt.Color(255, 255, 255));
        color.addActionListener(this);
        fondo.add(color);


    }
    public void actionPerformed(ActionEvent e){

    }

    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.setResizable(false);
        editor.setVisible(true);
    }



}
//private class NegrListener()
