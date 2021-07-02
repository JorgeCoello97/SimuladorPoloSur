package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modelo.Modelo;
import modelo.Polo;
import utils.Estado;
import vista_principal.Simulador;
import vista_secundaria.DetallesVentana;

/**
 *
 * @author JORCH
 */
public class Controlador{
    private Modelo modelo;
    private Simulador vista;
    private DetallesVentana detallesVentana;
    public Controlador(Modelo modelo, Simulador vista) {
        this.modelo = modelo;
        this.vista = vista;
        
        detallesVentana = new DetallesVentana(modelo);
        detallesVentana.setVisible(false);
        detallesVentana.setLocationRelativeTo(vista);
        
        detallesVentana.setItemListener(new ComboBoxControlador());
        detallesVentana.setActionListener( new BotonesControlador());
        vista.setActionListener(new BotonesControlador());
        vista.addWindowListener(new WindowAdapterControlador());
    }

    class WindowAdapterControlador extends WindowAdapter{

        @Override
        public void windowClosing(WindowEvent e) {
            Icon guardarIcon = new ImageIcon("./src/images/guardar.png");
            int opcionSeleccionada = JOptionPane.showConfirmDialog(vista,
                    "¿Quieres guardar el estado actual del ecosistema?", 
                    "ALERTA", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, guardarIcon);
            switch(opcionSeleccionada){
                case JOptionPane.YES_OPTION:
                    Estado estadoActual = modelo.getPolo().obtenerEstadoActual();
                    guardarEstadoActualEcosistema(estadoActual);
                    JOptionPane.showMessageDialog(vista, "Guardado con éxito.","INFORMACIÓN",JOptionPane.INFORMATION_MESSAGE);
                    break;
                case JOptionPane.NO_OPTION:
                    System.out.println("NO");
                    Polo nuevo_polo = new Polo();
                    
                    guardarEstadoActualEcosistema(nuevo_polo.obtenerEstadoActual());
                    break;
            }
        }

        
    }
    
    //CONTROLADOR DE LAS FUNCIONES DEL PANEL
    class ComboBoxControlador implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent e) {
            JComboBox<String> comboBox = (JComboBox<String>) e.getSource();
            if (ItemEvent.SELECTED == e.getStateChange()) {
                detallesVentana.actualizarInformacionAnimal(comboBox.getSelectedIndex());
            }
        }
        
    }
    class BotonesControlador implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String actionCommand = e.getActionCommand();
            switch( actionCommand ){
                //VENTANA PRINCIPAL
                case "CREAR_POLO":
                    crearNuevoPolo();
                    break;
                case "UN_DIA":
                    transcurrirUnDia();
                    break;
                case "DETALLES":
                    mostrarDetalles();
                    break;
                case "DIEZ_DIAS":
                    avanzar10Dias();
                    break;
                case "CALENTAMIENTO":
                    provocarCalentamientoGlobal();
                    break;
                case "CAZA":
                    provocarCazaFurtiva();
                    break;
                case "VOLCAN":
                    provocarVolcan();
                    break;
                case "TORNADO":
                    provocarTornado();
                    break;
                case "TSUNAMI":
                    provocarTsunami();
                    break;
                case "SALIR":
                    salirPrograma();
                    break;
                //VENTANA DETALLES
                case "VOLVER_DETALLES":
                    detallesVentana.setVisible(false);
                    vista.setVisible(true);
                    break;
            }
        }

        //FUNCIONES DE LOS BOTONES
        public void crearNuevoPolo(){
            Polo nuevoPolo = new Polo();
            modelo.nuevoPolo(nuevoPolo);
            vista.actualizarDiaYTemperatura();
            vista.actualizarContadoresAnimales();
            vista.actualizarSucesos();
            vista.activarFunciones();
        }
        
        public void transcurrirUnDia(){
            boolean extincion = false;
            
            extincion = modelo.getPolo().avanzarDia();
            
            modelo.getPolo().desactivarSucesos();
            vista.actualizarSucesos();
            
            vista.actualizarDiaYTemperatura();
            vista.actualizarContadoresAnimales();
            
            if(extincion){
                JOptionPane.showMessageDialog(vista,
                        "Extincion del ecosistema. DIA:"+modelo.getDiaActual());
                vista.desactivarFunciones();
                
            }
            
        }

        public void mostrarDetalles(){
            vista.setVisible(false);
            detallesVentana.actualizarInformacionAnimal(0);
            detallesVentana.actualizarDetalles();
            detallesVentana.setVisible(true);
        }

        public void avanzar10Dias(){
            boolean extincion = false;
            int i = 0;
            while (i < 10 && extincion!=true) {                
                extincion = modelo.getPolo().avanzarDia();
                vista.actualizarContadoresAnimales();
                i++;
            }
            
            modelo.getPolo().desactivarSucesos();
            vista.actualizarSucesos();
            vista.actualizarDiaYTemperatura();
            vista.actualizarContadoresAnimales();
            
            if(extincion){
                JOptionPane.showMessageDialog(vista,
                        "Extincion del ecosistema. DIA:"+modelo.getDiaActual());
                vista.desactivarFunciones();
            }
            
            
        }

        public void provocarCalentamientoGlobal(){
            modelo.getPolo().calentamientoGlobal();
            vista.actualizarSucesoCalentamientoGlobal();
            vista.actualizarTemperatura();
        }

        public void provocarCazaFurtiva(){
             modelo.getPolo().provocarCazaFurtiva(true);
             vista.actualizarSucesoCazaFurtiva();
        }
        
        public void provocarVolcan(){
             modelo.getPolo().provocarVolcan(true);
             vista.actualizarSucesoVolcan();
        }
        
        public void provocarTornado(){
             modelo.getPolo().provocarTornado(true);
             vista.actualizarSucesoTornado();
        }
        public void provocarTsunami(){
             modelo.getPolo().provocarTsunami(true);
             vista.actualizarSucesoTsunami();
        }
        
        public void salirPrograma(){
            Icon guardarIcon = new ImageIcon("./src/images/guardar.png");
            int opcionSeleccionada = JOptionPane.showConfirmDialog(vista,
                    "¿Quieres guardar el estado actual del ecosistema?", 
                    "ALERTA", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, guardarIcon);
            switch(opcionSeleccionada){
                case JOptionPane.YES_OPTION:
                    System.out.println("SI");
                    Estado estadoActual = modelo.getPolo().obtenerEstadoActual();
                    guardarEstadoActualEcosistema(estadoActual);
                    JOptionPane.showMessageDialog(vista, "Guardado con éxito.","INFORMACIÓN",JOptionPane.INFORMATION_MESSAGE);
                    break;
                case JOptionPane.NO_OPTION:
                    System.out.println("NO");
                    Polo nuevo_polo = new Polo();
                    
                    guardarEstadoActualEcosistema(nuevo_polo.obtenerEstadoActual());
                    break;
            }
            
            System.exit(0);
        }

    }
    private static void guardarEstadoActualEcosistema(Estado estado) {
            
        try {
            FileOutputStream fos = new FileOutputStream("./src/utils/datosEcosistema.bin");
            BufferedOutputStream bos = new BufferedOutputStream(fos, 16384);
            ObjectOutputStream oos = new ObjectOutputStream(bos);

            oos.writeObject(estado);
            oos.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
}
