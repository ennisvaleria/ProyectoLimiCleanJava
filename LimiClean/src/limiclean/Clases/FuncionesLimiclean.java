/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package limiclean.Clases;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.*;

/**
 *
 * @author user
 */
public class FuncionesLimiclean {
    
public static void borrar_mensaje_defecto(JTextField txt, String placeholder) {

    txt.setText(placeholder);
    txt.setForeground(Color.GRAY);

    txt.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (txt.getText().equals(placeholder)) {
                txt.setText("");
                txt.setForeground(Color.BLACK);
            }
        }
    });

    txt.addFocusListener(new FocusAdapter() {
        @Override
        public void focusLost(FocusEvent e) {
            if (txt.getText().trim().isEmpty()) {
                txt.setText(placeholder);
                txt.setForeground(Color.GRAY);
            }
        }
    });
}
public static void text_color(JTextField text,String dato){
    text.setText(dato.toString());
    text.setForeground(Color.black);
}

}
