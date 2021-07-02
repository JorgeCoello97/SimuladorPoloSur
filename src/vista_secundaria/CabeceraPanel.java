package vista_secundaria;

import java.awt.BorderLayout;
import java.awt.Color;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import modelo.Modelo;

/**
 *
 * @author JORCH
 */
public class CabeceraPanel extends JPanel{
    private Modelo modelo;
    private PrincipalPanel principalPanel;
    private ContadoresAnimalesPanel contadadoresAnimalesPanel;
    public CabeceraPanel(Modelo modelo) {
        setLayout(new BorderLayout());
        this.modelo = modelo;
        
        //COLOR DEL PANEL
        setBackground(new Color(60, 66, 69));
        
        //BORDES DEL PANEL
        Border borderExterior = BorderFactory.createEmptyBorder(25, 25, 25, 25);
        Border borderInterior = BorderFactory.createLineBorder(Color.BLACK, 1);
        setBorder(BorderFactory.createCompoundBorder( borderInterior, borderExterior));
        
        principalPanel = new PrincipalPanel();
        contadadoresAnimalesPanel = new ContadoresAnimalesPanel(modelo);
        
        add(principalPanel, BorderLayout.CENTER);
        add(contadadoresAnimalesPanel, BorderLayout.EAST);
    }
    class PrincipalPanel extends JPanel {
        private EstadoActualPanel estadoActualPanel;
        private SucesosEcosistemaPanel sucesosEcosistemaPanel;

        public PrincipalPanel() {
            setLayout(new BorderLayout());
            
            estadoActualPanel = new EstadoActualPanel(modelo);
            sucesosEcosistemaPanel = new SucesosEcosistemaPanel(modelo);
           
            add(estadoActualPanel, BorderLayout.CENTER);
            add(sucesosEcosistemaPanel, BorderLayout.EAST);
        }
        
        //SETTERS CONECTORES A LOS PANELES 
        public void actualizarSucesos(){
            sucesosEcosistemaPanel.actualizarSucesos();
        }
        public void actualizarDiaActual(){
            estadoActualPanel.actualizarDiaActual();
        }
        public void actualizarTemperatura(){
            estadoActualPanel.actualizarTemperatura();
        }
        public void actualizarNumKrill(){
            estadoActualPanel.actualizarNumKrill();
        }
    }
    
    //SETTERS CONECTORES A LOS PANELES 
    public void actualizarContadoresAnimales(){
        contadadoresAnimalesPanel.actualizarContadoresAnimales();
    }
    public void actualizarSucesos(){
        principalPanel.actualizarSucesos();
    }
    public void actualizarDiaActual(){
        principalPanel.actualizarDiaActual();
    }
    public void actualizarTemperatura(){
        principalPanel.actualizarTemperatura();
    }
    public void actualizarNumKrill(){
        principalPanel.actualizarNumKrill();
    }
}
