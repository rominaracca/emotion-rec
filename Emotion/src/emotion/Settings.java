package emotion;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Romina Racca
 */
public class Settings extends javax.swing.JDialog{
    
    JLabel lblTimer = new JLabel("Ajustar cronometro: ");
    JLabel lblHour = new JLabel("hs");
    JLabel lblMin = new JLabel("min");
    JLabel lblSeg = new JLabel("seg");
    JLabel lblDirectory = new JLabel("Directorio en el que se encuentran las imagenes:", JLabel.CENTER);
    
    JSpinner spiHour = new JSpinner(new SpinnerNumberModel(0,0,24,1));
    JSpinner spiMin = new JSpinner(new SpinnerNumberModel(0,0,59,1));
    JSpinner spiSeg = new JSpinner(new SpinnerNumberModel(0,0,59,1));
    
    JTextField txtFileDirectory = new JTextField();
        
    Button btnDirectory = new Button("...");
    
    //Panel para acomodar los componentes
    JPanel panelMain = new JPanel(new BorderLayout());
    JPanel panelTimer = new JPanel(new FlowLayout());
    JPanel panelDirectory = new JPanel(new GridLayout(3, 1));
    
    public Settings(){
        super(new Frame(), "Ajutes", true);
    
        //Asignamos un valor por defecto de seguntos
        spiSeg.setValue(8);
        
        //Agregamos al panel timer los componentes
        panelTimer.add(lblTimer);
        panelTimer.add(spiHour);
        panelTimer.add(lblHour);
        panelTimer.add(spiMin);
        panelTimer.add(lblMin);
        panelTimer.add(spiSeg);
        panelTimer.add(lblSeg);
        
        //Agregamos al panel directory los componentes
        panelDirectory.add(lblDirectory);
        panelDirectory.add(txtFileDirectory);
        panelDirectory.add(btnDirectory);
        
        //Agregamos al panel main los paneles timer y directory que contienen los componentes
        panelMain.add("Center", panelTimer);
        panelMain.add("South", panelDirectory);
        
        //Agregamos el panel main al cuadro de dialogo Settings
        getContentPane().add(panelMain);
        
        //Definimos el tamaño del dialogo de acuerdo al numero de componente
	pack();

	//Indicamos que no se puede cambiar el tamaño del dialogo con el mouse
	setResizable(false);
                
        //Creamos el dialogo
	Dimension screen, box;
	screen = Toolkit.getDefaultToolkit().getScreenSize();
	box = this.getSize();

	this.setLocation(((screen.width - box.width)/2), (screen.height - box.height)/2);
    }
    
}