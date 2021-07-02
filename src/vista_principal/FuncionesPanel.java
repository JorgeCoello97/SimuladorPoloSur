package vista_principal;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import modelo.Modelo;

/**
 *
 * @author JORCH
 */
public class FuncionesPanel extends JPanel{
    public static final int NUM_FUNCIONES = 5;
    public static final int NUM_SUCESOS_FUNCIONES = 5;
    private Modelo modelo;
    private PrincipalFuncionesPanel principalFuncionesPanel;
    private SucesosFuncionesPanel sucesosFuncionesPanel;
    private JButton[] sucesosButtons = new JButton[NUM_SUCESOS_FUNCIONES];
    private JButton[] pricipalButtons = new JButton[NUM_FUNCIONES];
    
    public FuncionesPanel(Modelo modelo) {
        setLayout(new GridLayout(1, 2, 0, 0));
        this.modelo = modelo;
        
        //COLOR DEL PANEL
        setBackground(new Color(95, 103, 105));
        
        //BORDES DEL PANEL
        Border borderExterior = BorderFactory.createEmptyBorder(25, 25, 25, 25);
        Border borderInterior = BorderFactory.createLineBorder(Color.BLACK, 1);
        setBorder(BorderFactory.createCompoundBorder( borderInterior, borderExterior));
        
        principalFuncionesPanel = new PrincipalFuncionesPanel();
        sucesosFuncionesPanel = new SucesosFuncionesPanel();
        
        add(principalFuncionesPanel);
        add(sucesosFuncionesPanel);
        desactivarFunciones();
    }
    class PrincipalFuncionesPanel extends JPanel{

        public PrincipalFuncionesPanel() {
            setLayout(new GridLayout(NUM_FUNCIONES, 1));
            
            //COLOR DEL PANEL
            setBackground(new Color(95, 103, 105));

            //BORDES DEL PANEL
            Border borderExterior = BorderFactory.createEmptyBorder(15, 15, 15, 15);
            TitledBorder borderInterior = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 1), 
                    "MENU PRINCIPAL", TitledBorder.CENTER , TitledBorder.TOP, new Font(Font.DIALOG, Font.BOLD, 15));
            borderInterior.setTitleColor(new Color(247, 220, 111));
            setBorder(BorderFactory.createCompoundBorder( borderInterior, borderExterior));
            
            //BOTONES
            pricipalButtons[0] = new JButton("CREAR NUEVO POLO");
            pricipalButtons[0].setToolTipText("Crea un nuevo ecosistema del Polo Sur.");
            pricipalButtons[0].setActionCommand("CREAR_POLO");

            pricipalButtons[1] = new JButton("TRANSCURRIR UN DIA");
            pricipalButtons[1].setToolTipText("Avanza un dia el ecosistema del Polo Sur.");
            pricipalButtons[1].setActionCommand("UN_DIA");

            pricipalButtons[2] = new JButton("MOSTRAR MÁS DETALLES");
            pricipalButtons[2].setToolTipText("Muestra los detalles del estado actual"
                    + " del ecosistema.");
            pricipalButtons[2].setActionCommand("DETALLES");

            pricipalButtons[3] = new JButton("AVANZAR 10 DIAS");
            pricipalButtons[3].setToolTipText("Avanza diez dias el ecosistema del Polo Sur.");
            pricipalButtons[3].setActionCommand("DIEZ_DIAS");


            pricipalButtons[4] = new JButton("SALIR DEL PROGRAMA");
            pricipalButtons[4].setToolTipText("Terminar la simulación del ecosistema del Polo Sur.");
            pricipalButtons[4].setActionCommand("SALIR");

            for (int i = 0; i < NUM_FUNCIONES; i++) {
                //COLORES
                pricipalButtons[i].setBackground(new Color(230, 230, 255));
                add(pricipalButtons[i]);
            }

        }
        
    } 
    class SucesosFuncionesPanel extends JPanel{
        
    
        public SucesosFuncionesPanel() {
            setLayout(new GridLayout(NUM_SUCESOS_FUNCIONES, 1));
            //COLOR DEL PANEL
            setBackground(new Color(95, 103, 105));

            //BORDES DEL PANEL
            Border borderExterior = BorderFactory.createEmptyBorder(15, 15, 15, 15);
            TitledBorder borderInterior = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 1), 
                    "PROVOCAR SUCESOS", TitledBorder.CENTER , TitledBorder.TOP, new Font(Font.DIALOG, Font.BOLD, 15));
            borderInterior.setTitleColor(new Color(240, 178, 122));
            setBorder(BorderFactory.createCompoundBorder( borderInterior, borderExterior));
            
            //BOTONES
            sucesosButtons[0] = new JButton("CALENTAMIENTO GLOBAL");
            sucesosButtons[0].setToolTipText("Provoca calentamiento global en el ecosistema.");
            sucesosButtons[0].setActionCommand("CALENTAMIENTO");

            sucesosButtons[1] = new JButton("CAZA FURTIVA");
            sucesosButtons[1].setToolTipText("Provoca la caza furtiva de animales en el ecosistema.");
            sucesosButtons[1].setActionCommand("CAZA");

            sucesosButtons[2] = new JButton("VOLCAN");
            sucesosButtons[2].setToolTipText("Provoca la aparición de un volcan en erupción en el ecosistema.");
            sucesosButtons[2].setActionCommand("VOLCAN");

            sucesosButtons[3] = new JButton("TORNADO");
            sucesosButtons[3].setToolTipText("Provoca la aparición de un tornado en el ecosistema.");
            sucesosButtons[3].setActionCommand("TORNADO");

            sucesosButtons[4] = new JButton("TSUNAMI");
            sucesosButtons[4].setToolTipText("Provoca la aparición de un tsunami en el ecosistema.");
            sucesosButtons[4].setActionCommand("TSUNAMI");


            for (int i = 0; i < NUM_SUCESOS_FUNCIONES; i++) {
                //COLORES
                sucesosButtons[i].setBackground(new Color(230, 230, 255));
                add(sucesosButtons[i]);
            }
        }
        
    }
    public void activarFunciones(){
        for (int i = 1; i < NUM_FUNCIONES; i++) {
            //COLORES
            pricipalButtons[i].setEnabled(true);
            sucesosButtons[i].setEnabled(true);
        }
        sucesosButtons[0].setEnabled(true);
    }
    public void desactivarFunciones(){
        for (int i = 1; i < NUM_FUNCIONES; i++) {
            //COLORES
            pricipalButtons[i].setEnabled(false);
            sucesosButtons[i].setEnabled(false);
        }
        
        sucesosButtons[0].setEnabled(false);
    }
    public void setActionListeners(ActionListener actionListener){
        for (int i = 0; i < NUM_FUNCIONES; i++) {
            //LISTENERS
            pricipalButtons[i].addActionListener(actionListener);
            sucesosButtons[i].addActionListener(actionListener);
        }
    }
}
