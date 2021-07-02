package vista_secundaria;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import static java.awt.image.ImageObserver.HEIGHT;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import modelo.Modelo;

/**
 *
 * @author JORCH
 */
//PANEL CENTRAL DERECHO (Sucesos que ocurren en el ecosistema)       
public class SucesosEcosistemaPanel extends JPanel{
    private Modelo modelo;
    private Fila calentamientoFila;
    private Fila cazaFurtivaFila;
    private Fila volcanFila;
    private Fila tornadoFila;
    private Fila tsunamiFila;
    public SucesosEcosistemaPanel(Modelo modelo) {
        setLayout(new GridLayout(5, 1));
        this.modelo = modelo;
        
        //COLOR DEL PANEL
        setBackground(new Color(60, 66, 69));
        
         //BORDES DEL PANEL
        Border borderExterior = BorderFactory.createEmptyBorder(15, 15, 15, 15);
        TitledBorder borderInterior = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 1), 
                "Sucesos", TitledBorder.CENTER , TitledBorder.TOP, new Font(Font.DIALOG, Font.BOLD, 15));
        borderInterior.setTitleColor(Color.WHITE);
        setBorder(BorderFactory.createCompoundBorder( borderInterior, borderExterior));
        
        calentamientoFila = new Fila("Calentamiento Global", "./src/images/calentamiento_32.png", false, "Suceso: Calentamiento global");
        cazaFurtivaFila = new Fila("Caza Furtiva", "./src/images/caza_32.png",false,"Suceso: Caza Masiva de animales");
        volcanFila = new Fila("Volcan", "./src/images/volcan_32.png", false, "Sucesos: Volcan en el ecosistema.");
        tornadoFila = new Fila("Tornado", "./src/images/tornado_32.png", false, "Suceso: Tornado en el ecosistema");
        tsunamiFila = new Fila("Tsunami", "./src/images/tsunami_32.png", false, "Suceso: Tsunami en el ecosistema");



        add(calentamientoFila);
        add(cazaFurtivaFila);
        add(volcanFila);
        add(tornadoFila);
        add(tsunamiFila);
    }
    //CLASE AUXILIAR
    class Fila extends JPanel{
        private JLabel label;
        private Icon icon;
        private JCheckBox checkbox;
        public Fila(String textoLabel, String url_icono,boolean estado, String tooltip) {
            setLayout(new FlowLayout(FlowLayout.RIGHT));
            
            //COLOR DEL PANEL
            setBackground(new Color(240, 178, 122));
            
            //BORDES DEL PANEL
            setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED,Color.GRAY, Color.DARK_GRAY));
            
            icon = new ImageIcon(url_icono);
            label = new JLabel(textoLabel, icon, HEIGHT);
            label.setHorizontalTextPosition(SwingConstants.RIGHT);
            label.setVerticalTextPosition(SwingConstants.CENTER);
            label.setHorizontalAlignment(SwingConstants.RIGHT);


            checkbox = new JCheckBox();

            checkbox.setSelected(estado);
            checkbox.setBackground(new Color( 254, 249, 231 ));
            checkbox.setHorizontalAlignment(JCheckBox.RIGHT);
            checkbox.setEnabled(false);
            checkbox.setToolTipText(tooltip);
            add(label);
            add(checkbox);
        }
        //SETTERS CONECTORES A LOS PANELES 
        public void actualizarEstado(boolean estado){
            checkbox.setSelected(estado);
        }
    }
    
    //SETTERS CONECTORES A LOS PANELES 
    public void actualizarSucesos(){
        
        cazaFurtivaFila.actualizarEstado(modelo.getPolo().isCazaFurtiva());
        calentamientoFila.actualizarEstado(modelo.getPolo().isCalentamiento());
        volcanFila.actualizarEstado(modelo.getPolo().isVolcan());
        tornadoFila.actualizarEstado(modelo.getPolo().isTornado());
        tsunamiFila.actualizarEstado(modelo.getPolo().isTsunami());
        
    }
}
