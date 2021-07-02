package vista_principal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import modelo.Modelo;

/**
 *
 * @author JORCH
 */
public class CabeceraPanel extends JPanel{
    
    private Modelo modelo;
    private EstadosPanel estadosPanel;
    private TituloPanel tituloPanel;
    
    public CabeceraPanel(Modelo modelo) {
        setLayout(new BorderLayout());
        this.modelo = modelo;
        
        //COLOR DEL PANEL
        
        setBackground(new Color(60, 66, 69));
        
        //BORDES DEL PANEL
        Border borderExterior = BorderFactory.createEmptyBorder(25, 25, 25, 25);
        Border borderInterior = BorderFactory.createLineBorder(Color.BLACK, 1);
        setBorder(BorderFactory.createCompoundBorder( borderInterior, borderExterior));
        
        this.estadosPanel = new EstadosPanel(modelo);
        this.tituloPanel = new TituloPanel();
        
        add(estadosPanel, BorderLayout.NORTH);
        add(tituloPanel, BorderLayout.CENTER);
    }
    class TituloPanel extends JPanel{
        private JLabel tituloLabel;

        public TituloPanel() {
            setLayout(new BorderLayout());
            
            //COLOR DEL PANEL
            setBackground(new Color( 115, 198, 182 ));  
            
            
            //BORDE DEL PANEL
            Border borderExterior = BorderFactory.createEmptyBorder(25, 25, 25, 25);
            Border borderInterior = BorderFactory.createLineBorder(Color.BLACK, 1);
            setBorder(BorderFactory.createCompoundBorder( borderInterior, borderExterior));

            tituloLabel = new JLabel("SIMULADOR DEL POLO SUR");
            tituloLabel.setFont(new Font(Font.DIALOG,  Font.BOLD, 25));
            tituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
            add(tituloLabel);
        }   
    }
    
    //SETTERS CONECTORES A LOS PANELES
    public void actualizarDiaActual(){
        this.estadosPanel.actualizarDiaActual();
    }
    public void actualizarTemperatura(){
        this.estadosPanel.actualizarTemperatura();
    }
    public void actualizarSucesoCalentamientoGlobal(){
        this.estadosPanel.actualizarSucesoCalentamientoGlobal();
    }
    public void actualizarSucesoCazaFurtiva(){
        this.estadosPanel.actualizarSucesoCazaFurtiva();
    }
    public void actualizarSucesoVolcan(){
        this.estadosPanel.actualizarSucesoVolcan();
    }
    public void actualizarSucesoTornado(){
        this.estadosPanel.actualizarSucesoTornado();
    }
    public void actualizarSucesoTsunami(){
        this.estadosPanel.actualizarSucesoTsunami();
    }
    public void actualizarDiaYTemperatura(){
        this.estadosPanel.actualizarDiaYTemperatura();
    }
    
}
