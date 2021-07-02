package vista_principal;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import static java.awt.image.ImageObserver.HEIGHT;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import modelo.Modelo;

/**
 *
 * @author JORCH
 */
public class EstadosPanel extends JPanel{
    private Modelo modelo;
    private InformacionEcosistema informacionEcosistema;
    private SucesosEcosistema sucesosEcosistema;
    public EstadosPanel(Modelo modelo) {
        setLayout(new GridLayout(1, 2));
        this.modelo = modelo;
        
        //COLOR DEL PANEL
        setBackground(new Color(95, 103, 105));
        
        //BORDES DEL PANEL
        Border borderExterior = BorderFactory.createEmptyBorder(15, 15, 15, 15);
        Border borderInterior = BorderFactory.createLineBorder(Color.BLACK, 1);
        setBorder(BorderFactory.createCompoundBorder( borderInterior, borderExterior));
        
        this.informacionEcosistema = new InformacionEcosistema();
        this.sucesosEcosistema = new SucesosEcosistema();
        
        
        add(informacionEcosistema);
        add(sucesosEcosistema);
    }
    
    class InformacionEcosistema extends JPanel{
        private JLabel diaLabel;
        private JLabel temperaturaLabel;
        private JTextField diaField;
        private JTextField temperaturaField;

        public InformacionEcosistema() {
            setLayout(new GridLayout(1, 2,15,0));
            
            //COLOR DEL PANEL
            setBackground(new Color(247, 220, 111));
            
            //BORDES DEL PANEL
            Border borderExterior = BorderFactory.createEmptyBorder(15, 15, 15, 15);
            Border borderInterior = BorderFactory.createLineBorder(Color.BLACK, 1);
            setBorder(BorderFactory.createCompoundBorder( borderInterior, borderExterior));
            
            Icon diaIcon = new ImageIcon("./src/images/dia_32.png");
            diaLabel = new JLabel("DIA ACTUAL:",diaIcon, SwingConstants.CENTER);
            diaLabel.setHorizontalTextPosition(JLabel.CENTER);
            diaLabel.setVerticalTextPosition(JLabel.TOP);
            diaField = new JTextField("0");
            diaField.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
            
            diaField.setToolTipText("Dia actual en el ecosistema del Polo Sur.");
            diaField.setBackground(new Color( 254, 249, 231 ));
            Fila filaDia = new Fila(diaLabel, diaField);
            
            Icon temperaturaIcon = new ImageIcon("./src/images/temperatura_32.png");
            temperaturaLabel = new JLabel("TEMPERATURA:", temperaturaIcon, SwingConstants.CENTER);
            temperaturaLabel.setHorizontalTextPosition(JLabel.CENTER);
            temperaturaLabel.setVerticalTextPosition(JLabel.TOP);
            temperaturaField = new JTextField("0ºC");
            temperaturaField.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
            temperaturaField.setToolTipText("Temperatura actual en el ecosistema del Polo Sur.");
            temperaturaField.setBackground(new Color( 254, 249, 231 ));
            Fila filaTemperatura = new Fila(temperaturaLabel, temperaturaField);
            
            add(filaDia);
            add(filaTemperatura);
        }
        //SETTERS
        public void actualizarDiaActual(){
            diaField.setText(String.valueOf(modelo.getDiaActual()));
        }
        public void actualizarDiaYTemperatura(){
            diaField.setText(String.valueOf(modelo.getDiaActual()));
            DecimalFormat formatoDecimal = new DecimalFormat("#.00");
            temperaturaField.setText(formatoDecimal.format(modelo.getTemperaturaActual())+"ºC");
        }
        public void actualizarTemperatura(){
            DecimalFormat formatoDecimal = new DecimalFormat("#.00");
            temperaturaField.setText(formatoDecimal.format(modelo.getTemperaturaActual())+"ºC");
        }
    }
    class SucesosEcosistema extends JPanel{
        private Fila calentamientoFila;
        private Fila cazaFurtivaFila;
        private Fila volcanFila;
        private Fila tornadoFila;
        private Fila tsunamiFila;
        
        public SucesosEcosistema() {
            setLayout(new GridLayout(2, 1,0,15));
            
            //COLOR DEL PANEL
            setBackground(new Color(240, 178, 122));
            
            //BORDES DEL PANEL
            Border borderExterior = BorderFactory.createEmptyBorder(15, 15, 15, 15);
            Border borderInterior = BorderFactory.createLineBorder(Color.BLACK, 1);
            setBorder(BorderFactory.createCompoundBorder( borderInterior, borderExterior));
            
            calentamientoFila = new Fila("Calentamiento Global", "./src/images/calentamiento_32.png", false, "Suceso: Calentamiento global");
            cazaFurtivaFila = new Fila("Caza Furtiva", "./src/images/caza_32.png",false,"Suceso: Caza Masiva de animales");
            volcanFila = new Fila("Volcan", "./src/images/volcan_32.png", false, "Suceso: Volcan en el ecosistema.");
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
        //SETTERS
        public void actualizarSucesoCalentamientoGlobal(){
            calentamientoFila.actualizarEstado(modelo.getPolo().isCalentamiento());
        }
        public void actualizarSucesoCazaFurtiva(){
            cazaFurtivaFila.actualizarEstado(modelo.getPolo().isCazaFurtiva());
        }
        public void actualizarSucesoVolcan(){
            volcanFila.actualizarEstado(modelo.getPolo().isVolcan());
        }
        public void actualizarSucesoTornado(){
            tornadoFila.actualizarEstado(modelo.getPolo().isTornado());
        }
        public void actualizarSucesoTsunami(){
            tsunamiFila.actualizarEstado(modelo.getPolo().isTsunami());
        }
        
    }
    //AUXILIAR
    class Fila extends JPanel{

        public Fila(JLabel label, JTextField textField) {
            setLayout(new GridLayout(1, 2,10,0));
            setOpaque(false);
            textField.setEnabled(false);
            textField.setFocusable(false);
            textField.setHorizontalAlignment(JTextField.CENTER);
            add(label);
            add(textField);
        }

    }
    //SETTERS CONECTORES A LOS PANELES
    public void actualizarDiaActual(){
        this.informacionEcosistema.actualizarDiaActual();
    }
    public void actualizarTemperatura(){
        this.informacionEcosistema.actualizarTemperatura();
    }
    public void actualizarSucesoCalentamientoGlobal(){
        sucesosEcosistema.actualizarSucesoCalentamientoGlobal();
    }
    public void actualizarSucesoCazaFurtiva(){
        sucesosEcosistema.actualizarSucesoCazaFurtiva();
    }
    public void actualizarSucesoVolcan(){
        sucesosEcosistema.actualizarSucesoVolcan();
    }
    public void actualizarSucesoTornado(){
        sucesosEcosistema.actualizarSucesoTornado();
    }
    public void actualizarSucesoTsunami(){
        sucesosEcosistema.actualizarSucesoTsunami();
    }
    public void actualizarDiaYTemperatura(){
        this.informacionEcosistema.actualizarDiaYTemperatura();
    }
    
}
