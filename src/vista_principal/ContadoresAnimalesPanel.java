package vista_principal;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import modelo.Modelo;

/**
 *
 * @author JORCH
 */
public class ContadoresAnimalesPanel extends JPanel{
    public static final int NUM_ANIMALES = 5;
    public static final int ESQUIMAL = 0;
    public static final int OSO_POLAR = 1;
    public static final int MORSA = 2;
    public static final int FOCA = 3;
    public static final int PEZ = 4;
    private Modelo modelo;
    private JLabel[] animalesLabels = new JLabel[NUM_ANIMALES]; 
    
    public ContadoresAnimalesPanel(Modelo modelo) {
        setLayout(new GridLayout(5, 1));
        this.modelo = modelo;
        
        //COLOR DEL PANEL
        setBackground(new Color( 115, 198, 182 ));        

        
        //BORDES DEL PANEL
        Border borderExterior = BorderFactory.createEmptyBorder(25, 25, 25, 25);
        Border borderInterior = BorderFactory.createLineBorder(Color.BLACK, 1);
        setBorder(BorderFactory.createCompoundBorder( borderInterior, borderExterior));
        
        Icon esquimalIcon = new ImageIcon("./src/images/esquimal.png");
        animalesLabels[ESQUIMAL] = new JLabel("x0",
                esquimalIcon, SwingConstants.CENTER);
        animalesLabels[ESQUIMAL].setToolTipText("Nº actual de esquimales en el ecosistema.");
        
        Icon osoPolarIcon = new ImageIcon("./src/images/oso_polar.png");
        animalesLabels[OSO_POLAR] = new JLabel("x0",
                osoPolarIcon, SwingConstants.CENTER);
        animalesLabels[OSO_POLAR].setToolTipText("Nº actual de osos polares en el ecosistema.");
        
        Icon morsaIcon = new ImageIcon("./src/images/morsa.png");
        animalesLabels[MORSA] = new JLabel("x0",
                morsaIcon, SwingConstants.CENTER);
        animalesLabels[MORSA].setToolTipText("Nº actual de morsas en el ecosistema.");
        
        Icon focaIcon = new ImageIcon("./src/images/foca.png");
        animalesLabels[FOCA] = new JLabel("x0",
                focaIcon, SwingConstants.CENTER);
        animalesLabels[FOCA].setToolTipText("Nº actual de focas en el ecosistema.");
        
        Icon pezIcon = new ImageIcon("./src/images/pez.png");
        animalesLabels[PEZ] = new JLabel("x0",
                pezIcon, SwingConstants.CENTER);
        animalesLabels[PEZ].setToolTipText("Nº actual de peces en el ecosistema."); 
        
        for (int i = 0; i < NUM_ANIMALES; i++) {
            animalesLabels[i].setHorizontalTextPosition(JLabel.RIGHT);
            animalesLabels[i].setVerticalTextPosition(JLabel.CENTER);
            add(animalesLabels[i]);
        }
    }
    public void actualizarContadoresAnimales(){
        animalesLabels[ESQUIMAL].setText("x"+String.valueOf(modelo.getPolo().getNumEsquimales()));
        animalesLabels[OSO_POLAR].setText("x"+String.valueOf(modelo.getPolo().getNumOsosPolares()));
        animalesLabels[MORSA].setText("x"+String.valueOf(modelo.getPolo().getNumMorsas()));
        animalesLabels[FOCA].setText("x"+String.valueOf(modelo.getPolo().getNumFocas()));
        animalesLabels[PEZ].setText("x"+String.valueOf(modelo.getPolo().getNumPeces()));
    }
}
