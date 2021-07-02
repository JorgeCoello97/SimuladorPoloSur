/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista_secundaria;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import static java.awt.image.ImageObserver.HEIGHT;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import modelo.Modelo;

/**
 *
 * @author JORCH
 */
        

public class EstadoActualPanel extends JPanel{
        private Modelo modelo;
        private Fila diaFila;
        private Fila temperaturaFila;
        private Fila numKrillFila;
        public EstadoActualPanel(Modelo modelo) {
            setLayout(new GridLayout(1, 3, 25,0));
            this.modelo = modelo;
            
            //COLOR DEL PANEL
            setBackground(new Color(60, 66, 69));
            
            //BORDES DEL PANEL
            Border borderExterior = BorderFactory.createEmptyBorder(15, 15, 15, 15);
            TitledBorder borderInterior = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 1), 
                    "Estado del Ecosistema", TitledBorder.CENTER , TitledBorder.TOP, new Font(Font.DIALOG, Font.BOLD, 15));
            borderInterior.setTitleColor(Color.WHITE);
            setBorder(BorderFactory.createCompoundBorder( borderInterior, borderExterior));

            
            
            diaFila = new Fila("DIA ACTUAL", "./src/images/dia_64.png", 
                    String.valueOf(modelo.getDiaActual()), "Dia actual en el ecosistema.");
            temperaturaFila = new Fila("TEMPERATURA", "./src/images/temperatura_64.png", 
                    String.valueOf(modelo.getTemperaturaActual()), "Temperatura actual en el ecosistema.");
            numKrillFila = new Fila("KRILL", "./src/images/krill_64.png", 
                    String.valueOf(modelo.getPolo().getNumKrillPlancton()), "Nº de Krill actual en el ecosistema.");

            add(diaFila);
            add(temperaturaFila);
            add(numKrillFila);
        }
        //CLASE AUXILIAR
        class Fila extends JPanel{
            private JLabel label;
            private Icon icon;
            private JTextField textField;
            public Fila(String textoLabel, String url_icono,String texto, String tooltip) {
                setLayout(new GridLayout(2, 1));
                
                //COLOR DEL PANEL
                setBackground(new Color(247, 220, 111));
                
                //BORDES DEL PANEL
                Border borderExterior = BorderFactory.createEmptyBorder(15, 15, 15, 15);
                Border borderInterior = BorderFactory.createLineBorder(Color.BLACK, 1);
                setBorder(BorderFactory.createCompoundBorder( borderInterior, borderExterior));
                icon = new ImageIcon(url_icono);
                label = new JLabel(textoLabel, icon, HEIGHT);
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setHorizontalTextPosition(SwingConstants.RIGHT);
                label.setVerticalTextPosition(SwingConstants.CENTER);

                textField = new JTextField();
                textField.setEditable(false);
                textField.setHorizontalAlignment(JTextField.CENTER);
                textField.setText(texto);
                textField.setToolTipText(tooltip);
                textField.setBackground(new Color( 254, 249, 231 ));
                add(label);
                add(textField);
            }
            //SETTERS CONECTORES A LOS PANELES 
            public void actualizarValorCampo(String cantidad){
                textField.setText(cantidad);
            }
        }
        //SETTERS CONECTORES A LOS PANELES 
        public void actualizarDiaActual(){
            diaFila.actualizarValorCampo(String.valueOf(modelo.getDiaActual()));
        }
        public void actualizarTemperatura(){
            DecimalFormat formatoDecimal = new DecimalFormat("#.00");
            temperaturaFila.actualizarValorCampo(formatoDecimal.format(modelo.getTemperaturaActual())+" ºC");
        }
        public void actualizarNumKrill(){
            numKrillFila.actualizarValorCampo(String.valueOf(modelo.getPolo().getNumKrillPlancton()));
        }

    
}