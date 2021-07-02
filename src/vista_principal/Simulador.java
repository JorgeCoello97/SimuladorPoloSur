
package vista_principal;

import controlador.Controlador;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import modelo.Modelo;
import utils.Estado;

/**
 *
 * @author JORCH
 */
public class Simulador extends JFrame{
    public final int ANCHO_VENTANA = 400;
    public final int ALTO_VENTANA = 800;
    
    private Modelo modelo;
    
    private PrincipalPanel principalPanel;
    public Simulador(Modelo modelo) {
        super("PRÁCTICA 3: SIMULADOR DE ECOSISTEMA");
        this.modelo = modelo;
        
        //PARAMETROS DE LA VENTANA
        setLayout(new BorderLayout());
        setSize(ANCHO_VENTANA, ALTO_VENTANA);
        setMinimumSize(new Dimension(ANCHO_VENTANA, ALTO_VENTANA));
        setMaximumSize(new Dimension(ANCHO_VENTANA, ALTO_VENTANA));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setAlwaysOnTop(true);
        //CENTRAR VENTANA
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((dim.width/2-this.getSize().width/2)-450, dim.height/2-this.getSize().height/2);
        
        //ICONO APLICACIÓN
        ImageIcon icono = new ImageIcon("./src/images/iglu.png");
        setIconImage(icono.getImage());
        
        this.principalPanel = new PrincipalPanel();
        add( principalPanel);
        pack();
    }
    class PrincipalPanel extends JPanel{
        private CabeceraPanel cabeceraPanel;
        private CuerpoPanel cuerpoPanel;
        public PrincipalPanel() {
            setLayout(new BorderLayout());
            
            //COLOR DEL PANEL
            setBackground(new Color(38, 50, 56));
            
            //BORDE DEL PANEL
            setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
            
            this.cabeceraPanel = new CabeceraPanel(modelo);
            this.cuerpoPanel = new CuerpoPanel(modelo);

            add(cabeceraPanel, BorderLayout.NORTH);
            add(cuerpoPanel, BorderLayout.CENTER);

        }
        
        //SETTERS CONECTORES A LOS PANELES
        public void setActionListener(ActionListener actionListener){
            this.cuerpoPanel.setActionListener(actionListener);
        }
        public void actualizarDiaActual(){
            this.cabeceraPanel.actualizarDiaActual();
        }
        public void actualizarTemperatura(){
            this.cabeceraPanel.actualizarTemperatura();
        }
        public void actualizarSucesoCalentamientoGlobal(){
            this.cabeceraPanel.actualizarSucesoCalentamientoGlobal();
        }
        public void actualizarSucesoCazaFurtiva(){
            this.cabeceraPanel.actualizarSucesoCazaFurtiva();
        }
        public void actualizarSucesoVolcan(){
            this.cabeceraPanel.actualizarSucesoVolcan();
        }
        public void actualizarSucesoTornado(){
            this.cabeceraPanel.actualizarSucesoTornado();
        }
        public void actualizarSucesoTsunami(){
            this.cabeceraPanel.actualizarSucesoTsunami();
        }
        public void actualizarContadoresAnimales(){
            this.cuerpoPanel.actualizarContadoresAnimales();
        }
        public void activarFunciones(){
            this.cuerpoPanel.activarFunciones();
        }
        public void desactivarFunciones(){
            this.cuerpoPanel.desactivarFunciones();
        }
        public void actualizarDiaYTemperatura(){
            this.cabeceraPanel.actualizarDiaYTemperatura();
        }
    }
    //SETTERS CONECTORES A LOS PANELES
    public void setActionListener(ActionListener actionListener){
        this.principalPanel.setActionListener(actionListener);
    }
    public void actualizarDiaActual(){
        this.principalPanel.actualizarDiaActual();
    }
    public void actualizarTemperatura(){
        this.principalPanel.actualizarTemperatura();
    }
    public void actualizarSucesoCalentamientoGlobal(){
        this.principalPanel.actualizarSucesoCalentamientoGlobal();
    }
    public void actualizarSucesoCazaFurtiva(){
        this.principalPanel.actualizarSucesoCazaFurtiva();
    }
    public void actualizarSucesoVolcan(){
        this.principalPanel.actualizarSucesoVolcan();
    }
    public void actualizarSucesoTornado(){
        this.principalPanel.actualizarSucesoTornado();
    }
    public void actualizarSucesoTsunami(){
        this.principalPanel.actualizarSucesoTsunami();
    }
    public void actualizarContadoresAnimales(){
        this.principalPanel.actualizarContadoresAnimales();
    }
    public void activarFunciones(){
        this.principalPanel.activarFunciones();
    }
    public void desactivarFunciones(){
        this.principalPanel.desactivarFunciones();
    }
    public void actualizarDiaYTemperatura(){
        this.principalPanel.actualizarDiaYTemperatura();
    }
    public void actualizarSucesos(){
        actualizarSucesoCalentamientoGlobal();
        actualizarSucesoCazaFurtiva();
        actualizarSucesoVolcan();
        actualizarSucesoTornado();
        actualizarSucesoTsunami();
    }
    //APLICACIÓN PRINCIPAL
    public static void main(String[] args) {
        Modelo modelo = new Modelo();
        
        boolean hayDatosGuardados = cargarEstadoEcosistema(modelo);
        
        Simulador simuladorEcosistema = new Simulador(modelo);
        
        if (hayDatosGuardados) {
            simuladorEcosistema.activarFunciones();
            simuladorEcosistema.actualizarContadoresAnimales();
            simuladorEcosistema.actualizarDiaYTemperatura();
            simuladorEcosistema.actualizarSucesos();
        }
        simuladorEcosistema.setVisible(true);
        Controlador controlador = new Controlador(modelo,simuladorEcosistema);
        
    }
    private static boolean cargarEstadoEcosistema(Modelo modelo){
        boolean haCargado = false;
        try {
            FileInputStream fis = new FileInputStream("./src/utils/datosEcosistema.bin");
            BufferedInputStream bis = new BufferedInputStream(fis, 16384);
            ObjectInputStream ois = new ObjectInputStream(bis);
            Object object =  ois.readObject();
            ois.close();
            Estado estado = (Estado) object;
            modelo.getPolo().cargarEstado(estado);
            haCargado = true;
        } catch (FileNotFoundException ex) {
            haCargado = false;
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Simulador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return haCargado;
    }
    
}
