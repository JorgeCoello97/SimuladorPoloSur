package vista_secundaria;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import modelo.Modelo;
/**
 *
 * @author JORCH
 */
public class DetallesVentana extends JFrame{
    public final int ANCHO_VENTANA = 800;
    public final int ALTO_VENTANA = 850;
    private Modelo modelo;
    private PrincipalPanel principalPanel;
    public DetallesVentana(Modelo modelo) {
        setTitle("DETALLES DEL ECOSISTEMA");
        setLayout(new BorderLayout());
        this.modelo = modelo;
        
        //PARAMETROS
        setResizable(false);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(ANCHO_VENTANA, ALTO_VENTANA);
        setMinimumSize(new Dimension(ANCHO_VENTANA, ALTO_VENTANA));
        setMaximumSize(new Dimension(ANCHO_VENTANA, ALTO_VENTANA));
        
        
        //ICONO DIALOG
        ImageIcon icono = new ImageIcon("./src/images/detalles.png");
        setIconImage(icono.getImage());
        
        principalPanel = new PrincipalPanel();
        add(principalPanel);
        
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
            
            cabeceraPanel = new CabeceraPanel(modelo);
            cuerpoPanel = new CuerpoPanel(modelo);
            
            add(cabeceraPanel, BorderLayout.NORTH);
            add(cuerpoPanel, BorderLayout.CENTER);
        }
        //SETTERS CONECTORES A LOS PANELES 
        public void actualizarInformacionAnimal(int valor){
            cuerpoPanel.actualizarInformacionAnimal(valor);
        }
        public void setItemListener(ItemListener itemListener){
            cuerpoPanel.setItemListener(itemListener);
        }
        public void actualizarContadoresAnimales(){
            cabeceraPanel.actualizarContadoresAnimales();
        }
        public void actualizarSucesos(){
            cabeceraPanel.actualizarSucesos();
        }
        public void actualizarEstados(){
            cabeceraPanel.actualizarDiaActual();
            cabeceraPanel.actualizarTemperatura();
            cabeceraPanel.actualizarNumKrill();
        }
        public void setActionListener(ActionListener actionListener){
            cuerpoPanel.setActionListener(actionListener);
        }
    }
    //SETTERS CONECTORES A LOS PANELES
    public void actualizarInformacionAnimal(int valor){
        principalPanel.actualizarInformacionAnimal(valor);
    }
    public void setItemListener(ItemListener itemListener){
        principalPanel.setItemListener(itemListener);
    }
    public void actualizarDetalles(){
        principalPanel.actualizarSucesos();
        principalPanel.actualizarContadoresAnimales();
        principalPanel.actualizarEstados();
    }
    
    public static void main(String[] args) {
        DetallesVentana detallesDialog = new DetallesVentana(new Modelo() );
        detallesDialog.setVisible(true);
        detallesDialog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        detallesDialog.setLocationRelativeTo(null);
    }
    public void setActionListener(ActionListener actionListener){
        principalPanel.setActionListener(actionListener);
    }
}