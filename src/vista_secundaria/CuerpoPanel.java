package vista_secundaria;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import modelo.Modelo;

/**
 *
 * @author JORCH
 */
public class CuerpoPanel extends JPanel{
    public static final int ESQUIMAL = 0;
    public static final int OSO_POLAR = 1;
    public static final int MORSA = 2;
    public static final int FOCA = 3;
    public static final int PEZ = 4; 
    private Modelo modelo;
    private SeleccionPanel seleccionPanel;
    private DetallesPanel detallesPanel;
    private JButton volverButton;
    public CuerpoPanel(Modelo modelo) {
        setLayout(new BorderLayout(20, 20));
        this.modelo = modelo;
        
        
        //COLOR DEL PANEL
        setBackground(new Color(95, 103, 105));
        
        //BORDES DEL PANEL
        Border borderExterior = BorderFactory.createEmptyBorder(25, 25, 25, 25);
        Border borderInterior = BorderFactory.createLineBorder(Color.BLACK, 1);
        setBorder(BorderFactory.createCompoundBorder( borderInterior, borderExterior));
        
        seleccionPanel = new SeleccionPanel();
        detallesPanel = new DetallesPanel();
        
        volverButton = new JButton("VOLVER");
        volverButton.setBackground(new Color(230, 230, 255));
        volverButton.setActionCommand("VOLVER_DETALLES");
        
        
        add(seleccionPanel, BorderLayout.WEST);
        add(detallesPanel, BorderLayout.CENTER);
        add(volverButton, BorderLayout.SOUTH);
    }
    class SeleccionPanel extends JPanel{
        private JLabel numAnimalLabel;
        private JComboBox<String> comboBox;
        private String[] animales = {"ESQUIMAL","OSO POLAR", "MORSA", "FOCA", "PEZ"};
        public SeleccionPanel() {
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            
            //COLOR DEL PANEL
            setBackground(new Color(95, 103, 105));
            //BORDES DEL PANEL
            Border borderExterior = BorderFactory.createEmptyBorder(15, 15, 15, 15);
            Border borderInterior = BorderFactory.createLineBorder(Color.BLACK, 1);
            setBorder(BorderFactory.createCompoundBorder( borderInterior, borderExterior));
            
            JPanel seleccionPanel = new JPanel();
            seleccionPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
            seleccionPanel.setBackground(new Color(95, 103, 105));
            comboBox = new JComboBox<>(animales);
            
            numAnimalLabel = new JLabel(String.valueOf(modelo.getPolo().getNumEsquimales()),SwingConstants.CENTER);
            numAnimalLabel.setHorizontalTextPosition(JLabel.CENTER);
            numAnimalLabel.setVerticalTextPosition(JLabel.BOTTOM);   
            numAnimalLabel.setForeground(Color.WHITE);
            seleccionPanel.add(numAnimalLabel);
            seleccionPanel.add(comboBox);
            
            actualizarIconoAnimal(comboBox.getSelectedIndex());
            
            add(Box.createRigidArea(new Dimension(50, 100)));
            add(seleccionPanel);
        }
        //SETTERS CONECTORES A LOS PANELES 
        public void actualizarIconoAnimal(int valor){
            Icon icono = new ImageIcon();
            switch(valor){
                case ESQUIMAL:
                    icono = new ImageIcon("./src/images/esquimal.png");
                    numAnimalLabel.setText("x"+String.valueOf(modelo.getPolo().getNumEsquimales()));
                    break;
                case OSO_POLAR:
                    icono = new ImageIcon("./src/images/oso_polar.png");
                    numAnimalLabel.setText("x"+String.valueOf(modelo.getPolo().getNumOsosPolares()));
                    break;
                case MORSA:
                    icono = new ImageIcon("./src/images/morsa.png");
                    numAnimalLabel.setText("x"+String.valueOf(modelo.getPolo().getNumMorsas()));
                    break;
                case FOCA:
                    icono = new ImageIcon("./src/images/foca.png");
                    numAnimalLabel.setText("x"+String.valueOf(modelo.getPolo().getNumFocas()));
                    break;
                case PEZ:
                    icono = new ImageIcon("./src/images/pez.png");
                    numAnimalLabel.setText("x"+String.valueOf(modelo.getPolo().getNumPeces()));
                    break;
            }
            numAnimalLabel.setIcon(icono);
            numAnimalLabel.setHorizontalTextPosition(JLabel.CENTER);
            numAnimalLabel.setVerticalTextPosition(JLabel.BOTTOM); 
        }
        public void setItemListener(ItemListener itemListener){
            comboBox.addItemListener(itemListener);
        }
    }
    class DetallesPanel extends JPanel{
        private JTextArea textArea;
        private JScrollPane scrollPane;

        public DetallesPanel() {
            setLayout(new BorderLayout());
            
            //COLOR DEL PANEL
            setBackground(new Color(95, 103, 105));
            
            //BORDES DEL PANEL
            Border borderExterior = BorderFactory.createEmptyBorder(15, 15, 15, 15);
            Border borderInterior = BorderFactory.createLineBorder(Color.BLACK, 1);
            setBorder(BorderFactory.createCompoundBorder( borderInterior, borderExterior));
            
            textArea = new JTextArea();
            textArea.setEditable(false);
            textArea.setLineWrap(false);
            textArea.setMargin(new Insets(10, 50, 10, 10));
            textArea.setBackground(new Color( 254, 249, 231 ));
            scrollPane = new JScrollPane(textArea);
            
            add(scrollPane, BorderLayout.CENTER);
        }
        //SETTERS CONECTORES A LOS PANELES 
        public void actualizarDetalles(int valor){
            switch(valor){
                case ESQUIMAL:
                    textArea.setText(modelo.toStringEsquimales());
                    break;
                case OSO_POLAR:
                    textArea.setText(modelo.toStringOsosPolares());
                    break;
                case MORSA:
                    textArea.setText(modelo.toStringMorsas());
                    break;
                case FOCA:
                    textArea.setText(modelo.toStringFocas());
                    break;
                case PEZ:
                    textArea.setText(modelo.toStringPeces());
                    break;
            }
            
        }
    }
    //SETTERS CONECTORES A LOS PANELES     
    public void actualizarInformacionAnimal(int valor){
        seleccionPanel.actualizarIconoAnimal(valor);
        detallesPanel.actualizarDetalles(valor);
    }
    public void setItemListener(ItemListener itemListener){
        seleccionPanel.setItemListener(itemListener);
    }
    public void setActionListener(ActionListener actionListener){
        volverButton.addActionListener(actionListener);
    }
}

