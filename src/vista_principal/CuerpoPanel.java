package vista_principal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import modelo.Modelo;

/**
 *
 * @author JORCH
 */
public class CuerpoPanel extends JPanel{
    private Modelo modelo;
    private ContadoresAnimalesPanel contadoresAnimalesPanel;
    private FuncionesPanel funcionesPanel;

    public CuerpoPanel(Modelo modelo) {
        setLayout(new BorderLayout());
        this.modelo = modelo;
        this.contadoresAnimalesPanel = new ContadoresAnimalesPanel(modelo);
        this.funcionesPanel = new FuncionesPanel(modelo);
        
        //COLOR DEL PANEL
        setBackground(new Color(60, 66, 69));
        
        //BORDES DEL PANEL
        Border borderExterior = BorderFactory.createEmptyBorder(25, 25, 25, 25);
        Border borderInterior = BorderFactory.createLineBorder(Color.BLACK, 1);
        setBorder(BorderFactory.createCompoundBorder( borderInterior, borderExterior));
        
        add(contadoresAnimalesPanel,BorderLayout.WEST);
        add(funcionesPanel, BorderLayout.CENTER);
    }
    //SETTERS CONECTORES A LOS PANELES
    public void setActionListener(ActionListener actionListener){
        this.funcionesPanel.setActionListeners(actionListener);
    }
    public void actualizarContadoresAnimales(){
        this.contadoresAnimalesPanel.actualizarContadoresAnimales();
    }
    public void activarFunciones(){
        this.funcionesPanel.activarFunciones();
    }
    public void desactivarFunciones(){
        this.funcionesPanel.desactivarFunciones();
    }
}
