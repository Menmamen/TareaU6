package proyectoFinal;

import javax.swing.*;
import javax.swing.text.*;
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
    private JTextPane box;
    private JPanel marco1;
    private JPanel marco2;
    private JPanel marco3;
    private JButton subindice;
    private JButton superindice;
    private JButton modOscuro;

    private String[] fuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    private Integer[] sizes = new Integer[40];





    public Editor() {
        setTitle("Editor de Texto");
        setSize(790,610);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        fondo = new JPanel();
        fondo.setBackground(new java.awt.Color(204, 187, 187));
        fondo.setLayout(new FlowLayout ( FlowLayout.LEFT ));
        add(fondo);
        fondo.add(marco1);//lo añado antes de los botones para que se alinee el marco con el marco de la ventana

        negr = new JButton("Negrita");
        negr.addActionListener(new NegrListener());
        negr.setBackground(new java.awt.Color(255, 255, 255));
        fondo.add(negr);

        curs = new JButton("Cursiva");
        curs.addActionListener(new CursListener());
        curs.setBackground(new java.awt.Color(255, 255, 255));
        fondo.add(curs);

        subr = new JButton("Subrayado");
        subr.addActionListener(new SubrListener());
        subr.setBackground(new java.awt.Color(255, 255, 255));
        fondo.add(subr);

        subindice = new JButton("Subindice");
        subindice.setBackground(new java.awt.Color(255, 255, 255));
        subindice.addActionListener(new SubindiceListener());
        fondo.add(subindice);

        superindice = new JButton("Superindice");
        superindice.setBackground(new java.awt.Color(255, 255, 255));
        superindice.addActionListener(new SuperindiceListener());
        fondo.add(superindice);

        formato = new JComboBox(fuentes);
        formato.addActionListener(new FormatoListener());
        formato.setBackground(new java.awt.Color(255, 255, 255));
        fondo.add(formato);

        //Añadimos los tamaños de fuente
        int s = 2;
        for (int i = 0; i < sizes.length; i++){
            sizes[i] = s;
            s+=2;
        }

        tamanyo = new JComboBox(sizes);
        tamanyo.addActionListener(new TamanyoListener());
        tamanyo.setBackground(new java.awt.Color(255, 255, 255));
        fondo.add(tamanyo);


        color = new JButton("Color");
        color.setBackground(new java.awt.Color(255, 255, 255));
        color.addActionListener(new ColorListener());
        fondo.add(color);

        modOscuro = new JButton("Modo Oscuro");
        modOscuro.setBackground(new java.awt.Color(255, 255, 255));
        modOscuro.addActionListener(new ModOscuro());
        fondo.add(modOscuro);

        box = new JTextPane();
        box.setBackground(new java.awt.Color(255, 255, 255));
        JScrollPane scrollTexto = new JScrollPane(box);

        marco1 = new JPanel();
        marco1.setBackground(new java.awt.Color(204, 187, 187));


        marco2 = new JPanel();
        marco2.setBackground(new java.awt.Color(204, 187, 187));

        marco3 = new JPanel();
        marco3.setBackground(new java.awt.Color(204, 187, 187));


        //Añadimos todos los elementos con BorderLAyout
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(scrollTexto, BorderLayout.CENTER);
        getContentPane().add(fondo, BorderLayout.NORTH);
        getContentPane().add(marco1, BorderLayout.SOUTH);
        getContentPane().add(marco2, BorderLayout.EAST);
        getContentPane().add(marco3, BorderLayout.WEST);


    }
    public void actionPerformed(ActionEvent e){

    }
    private class ModOscuro implements ActionListener{
        public void actionPerformed(ActionEvent e){
            // Obtener el documento de estilo del JTextPane
            StyledDocument doc = box.getStyledDocument();

            /*Cogemos los atributos por defecto en lugar de los actuales como hacemos en el resto de listeners
            en este caso queremos modificarlo y que siga trabajando en ese modo */
            MutableAttributeSet attrs = box.getInputAttributes();

            // Obtener el color actual del fondo
            Color colorfondo = box.getBackground();
            boolean esOscuro = colorfondo.equals(Color.black);

            if(esOscuro == true){
                // Cambiamos el fondo a blanco y el texto a negro
                StyleConstants.setForeground(attrs, Color.black);
                box.setBackground(Color.white);
                // Aplicar el estilo al texto
                doc.setCharacterAttributes(0, doc.getLength(), attrs, false);
            }else {
                // Cambiamos el fondo a negro y el texto a blanco
                StyleConstants.setForeground(attrs, Color.white);
                box.setBackground(Color.black);
                // Aplicar el estilo al texto
                doc.setCharacterAttributes(0, doc.getLength(), attrs, false);
            }


        }
    }

    private class NegrListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Obtener la selección actual
            int start = box.getSelectionStart();
            int end = box.getSelectionEnd();

            // Obtener el documento de estilo del JTextPane
            StyledDocument doc = box.getStyledDocument();

            // Crear un nuevo estilo
            Style style = doc.addStyle("Negrita", null);

            // Verificar si el texto seleccionado está en negrita
            AttributeSet atributos = doc.getCharacterElement(start).getAttributes();
            boolean esNegrita = StyleConstants.isBold(atributos);

            // Alternar el estilo de negrita
            if (esNegrita) {
                // Si el texto seleccionado está en negrita, quitar el estilo de negrita
                StyleConstants.setBold(style, false);
            } else {
                // Si el texto seleccionado no está en negrita, aplicar el estilo de negrita
                StyleConstants.setBold(style, true);
            }

            // Aplicar el estilo al texto seleccionado
            doc.setCharacterAttributes(start, end - start, style, false);
        }

    }private class CursListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Obtener la selección actual
            int start = box.getSelectionStart();
            int end = box.getSelectionEnd();

            // Obtener el documento de estilo del JTextPane
            StyledDocument doc = box.getStyledDocument();

            // Crear un nuevo estilo
            Style style = doc.addStyle("Cursiva", null);

            if (end-start == 0) {
                MutableAttributeSet attrs = box.getInputAttributes();
                boolean esCursiva = StyleConstants.isItalic(attrs);


                // Aplicar el estilo al texto futuro
                StyleConstants.setItalic(attrs, esCursiva);
                doc.setCharacterAttributes(0, doc.getLength(), attrs, false);

            }else{
                // Verificar si el texto seleccionado está en cursiva
                AttributeSet atributos = doc.getCharacterElement(start).getAttributes();
                boolean esCursiva = StyleConstants.isItalic(atributos);

                // Alternar el estilo de negrita
                if (esCursiva) {
                    // Si el texto seleccionado está en cursiva, quitar el estilo de cursiva
                    StyleConstants.setItalic(style, false);
                } else {
                    // Si el texto seleccionado no está en cursiva, aplicar el estilo de cursiva
                    StyleConstants.setItalic(style, true);
                }

                // Aplicar el estilo al texto seleccionado
                doc.setCharacterAttributes(start, end - start, style, false);
            }



        }

    }
    private class SubrListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Obtener la selección actual
            int start = box.getSelectionStart();
            int end = box.getSelectionEnd();

            // Obtener el documento de estilo del JTextPane
            StyledDocument doc = box.getStyledDocument();

            // Crear un nuevo estilo
            Style style = doc.addStyle("Subrayado", null);

            // Verificar si el texto seleccionado está en Subrayado
            AttributeSet atributos = doc.getCharacterElement(start).getAttributes();
            boolean esSubrayado = StyleConstants.isUnderline(atributos);

            // Alternar el estilo de Subrayado
            if (esSubrayado) {
                // Si el texto seleccionado está en Subrayado, quitar el estilo de Subrayado
                StyleConstants.setUnderline(style, false);
            } else {
                // Si el texto seleccionado no está en Subrayado, aplicar el estilo de Subrayado
                StyleConstants.setUnderline(style, true);
            }

            // Aplicar el estilo al texto seleccionado
            doc.setCharacterAttributes(start, end - start, style, false);
        }

    }
    private class SubindiceListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Obtener la selección actual
            int start = box.getSelectionStart();
            int end = box.getSelectionEnd();

            // Obtener el documento de estilo del JTextPane
            StyledDocument doc = box.getStyledDocument();

            // Crear un nuevo estilo
            Style style = doc.addStyle("Subindice", null);

            // Verificar si el texto seleccionado está en Subindice
            AttributeSet atributos = doc.getCharacterElement(start).getAttributes();
            boolean esSubindice = StyleConstants.isSubscript(atributos);

            // Alternar el estilo de Subindice
            if (esSubindice) {
                // Si el texto seleccionado está en Subindice, quitar el estilo de Subindice
                StyleConstants.setSubscript(style, false);
            } else {
                // Si el texto seleccionado no está en Subindice, aplicar el estilo de Subindice
                StyleConstants.setSubscript(style, true);
            }

            // Aplicar el estilo al texto seleccionado
            doc.setCharacterAttributes(start, end - start, style, false);
        }

    }
    private class SuperindiceListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Obtener la selección actual
            int start = box.getSelectionStart();
            int end = box.getSelectionEnd();

            // Obtener el documento de estilo del JTextPane
            StyledDocument doc = box.getStyledDocument();

            // Crear un nuevo estilo
            Style style = doc.addStyle("Superindice", null);

            // Verificar si el texto seleccionado está en Superindice
            AttributeSet atributos = doc.getCharacterElement(start).getAttributes();
            boolean esSuperindice = StyleConstants.isSuperscript(atributos);

            // Alternar el estilo de Superindice
            if (esSuperindice) {
                // Si el texto seleccionado está en Superindice, quitar el estilo de Superindice
                StyleConstants.setSuperscript(style, false);
            } else {
                // Si el texto seleccionado no está en Superindice, aplicar el estilo de Superindice
                StyleConstants.setSuperscript(style, true);
            }

            // Aplicar el estilo al texto seleccionado
            doc.setCharacterAttributes(start, end - start, style, false);
        }

    }

    private class FormatoListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Obtener la selección actual
            int start = box.getSelectionStart();
            int end = box.getSelectionEnd();

            // Obtener el documento de estilo del JTextPane
            StyledDocument doc = box.getStyledDocument();
            // Obtener el estilo actual del texto seleccionado
            AttributeSet attr = doc.getCharacterElement(start).getAttributes();
            // Obtener la fuente actual del texto seleccionado
            String fuenteActual = StyleConstants.getFontFamily(attr);
            int tamanoActual = StyleConstants.getFontSize(attr);

            // Crear un nuevo estilo
            Style style = doc.addStyle("cambioFuente", null);

            // Aplicar el estilo al texto seleccionado
            String selectedFont = (String) formato.getSelectedItem();
            //Font nuevaFuente = new Font(selectedFont, Font.PLAIN, tamanoActual);
            StyleConstants.setFontFamily(style, selectedFont);
            StyleConstants.setFontSize(style, tamanoActual);
            doc.setCharacterAttributes(start, end - start, style, false);
        }

    }
    private class TamanyoListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Obtener la selección actual
            int start = box.getSelectionStart();
            int end = box.getSelectionEnd();

            // Obtener el documento de estilo del JTextPane
            StyledDocument doc = box.getStyledDocument();
            // Obtener el estilo actual del texto seleccionado
            AttributeSet attr = doc.getCharacterElement(start).getAttributes();
            // Obtener la fuente actual del texto seleccionado
            String fontName = StyleConstants.getFontFamily(attr);
            int fontSize = StyleConstants.getFontSize(attr);

            // Crear un nuevo estilo
            Style style = doc.addStyle("cambioFuente", null);

            // Aplicar el estilo al texto seleccionado
            int selectedSize = (int) tamanyo.getSelectedItem();
            StyleConstants.setFontSize(style, selectedSize);
            doc.setCharacterAttributes(start, end - start, style, false);
        }
    }


    private class ColorListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Color selectedColor = JColorChooser.showDialog(null, "Seleccione un color", Color.BLACK);

            if (selectedColor != null) {
                // Obtener la selección actual
                int start = box.getSelectionStart();
                int end = box.getSelectionEnd();

                // Obtener el documento de estilo del JTextPane
                StyledDocument doc = box.getStyledDocument();

                // Crear un nuevo estilo
                Style style = doc.addStyle("Color", null);

                // Aplicar el color seleccionado al estilo
                StyleConstants.setForeground(style, selectedColor);

                // Aplicar el estilo al texto seleccionado
                doc.setCharacterAttributes(start, end - start, style, false);
            }
        }
    }


    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.setResizable(true);
        editor.setVisible(true);
    }



}


