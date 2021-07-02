package vista_secundaria;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import static java.awt.image.ImageObserver.HEIGHT;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import modelo.Modelo;

/**
 *
 * @author JORCH
 */
//PANEL LATERAL DERECHO (Contadores de animales)
public class ContadoresAnimalesPanel extends JPanel{
    private Modelo modelo;
    private Fila esquimalFila;
    private Fila osoPolarFila;
    private Fila morsaFila;
    private Fila focaFila;
    private Fila pezFila;
    public ContadoresAnimalesPanel(Modelo modelo) {
        setLayout(new GridLayout(5, 1));
        this.modelo = modelo;
        
        
        //COLOR DEL PANEL
        setBackground(new Color(60, 66, 69));
        
        //BORDES DEL PANEL
        Border borderExterior = BorderFactory.createEmptyBorder(15, 15, 15, 15);
        TitledBorder borderInterior = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 1), 
                "Número de Animales", TitledBorder.CENTER , TitledBorder.TOP, new Font(Font.DIALOG, Font.BOLD, 15));
        borderInterior.setTitleColor(Color.WHITE);
        setBorder(BorderFactory.createCompoundBorder( borderInterior, borderExterior));
        
        
        esquimalFila = new Fila("Nº Esquimales", "./src/images/esquimal_32.png", 
                String.valueOf( modelo.getPolo().getNumEsquimales()), "Nº de esquimales actualmente en el ecosistema.");

        osoPolarFila = new Fila("Nº Osos Polares", "./src/images/oso_polar_32.png", 
                String.valueOf( modelo.getPolo().getNumOsosPolares()), "Nº de osos polares actualmente en el ecosistema.");
        

        morsaFila = new Fila("Nº Morsas", "./src/images/morsa_32.png", 
                String.valueOf( modelo.getPolo().getNumMorsas()), "Nº de morsas actualmente en el ecosistema.");


        focaFila = new Fila("Nº Focas", "./src/images/foca_32.png", 
                String.valueOf( modelo.getPolo().getNumFocas()), "Nº de focas actualmente en el ecosistema.");


        pezFila = new Fila("Nº Peces", "./src/images/pez_32.png", 
                String.valueOf( modelo.getPolo().getNumPeces()), "Nº de peces actualmente en el ecosistema.");

        add(esquimalFila);
        add(osoPolarFila);
        add(morsaFila);
        add(focaFila);
        add(pezFila);
    }

    //CLASE AUXILIAR
    class Fila extends JPanel{
        private JLabel label;
        private Icon icon;
        private JTextField textField;
        public Fila(String textoLabel, String url_icono,String texto, String tooltip) {
            setLayout(new FlowLayout(FlowLayout.RIGHT));
            
            //COLOR DEL PANEL
            setBackground(new Color( 115, 198, 182 ));
            
            //BORDES DEL PANEL
            setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED,Color.GRAY, Color.DARK_GRAY));
            
            icon = new ImageIcon(url_icono);
            label = new JLabel(textoLabel, icon, HEIGHT);
            label.setHorizontalTextPosition(SwingConstants.RIGHT);
            label.setVerticalTextPosition(SwingConstants.CENTER);
            label.setHorizontalAlignment(SwingConstants.LEFT);

            textField = new JTextField(6);
            textField.setEditable(false);
            textField.setHorizontalAlignment(JTextField.RIGHT);
            textField.setText(texto);
            textField.setBackground(new Color( 254, 249, 231 ));
            textField.setToolTipText(tooltip);
            add(label);
            add(textField);
        }
        //SETTERS CONECTORES A LOS PANELES 
        public void actualizarValorCampo(String cantidad){
            textField.setText(cantidad);
        }
    }
    
    

    //SETTERS CONECTORES A LOS PANELES 
    public void actualizarContadoresAnimales(){
        esquimalFila.actualizarValorCampo(String.valueOf(modelo.getPolo().getNumEsquimales()));
        osoPolarFila.actualizarValorCampo(String.valueOf(modelo.getPolo().getNumOsosPolares()));
        morsaFila.actualizarValorCampo(String.valueOf(modelo.getPolo().getNumMorsas()));
        focaFila.actualizarValorCampo(String.valueOf(modelo.getPolo().getNumFocas()));
        pezFila.actualizarValorCampo(String.valueOf(modelo.getPolo().getNumPeces()));
    }
}
