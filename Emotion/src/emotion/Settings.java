package emotion;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JButton;
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
    
    private String hour, min, seg, directory;

    JLabel lblTimer = new JLabel("Ajustar cronometro: ");
    JLabel lblHour = new JLabel("hs");
    JLabel lblMin = new JLabel("min");
    JLabel lblSeg = new JLabel("seg");
    JLabel lblDirectory = new JLabel("Directorio en el que se encuentran las imagenes:", JLabel.CENTER);
    
    JSpinner spiHour = new JSpinner(new SpinnerNumberModel(0,0,24,1));
    JSpinner spiMin = new JSpinner(new SpinnerNumberModel(0,0,59,1));
    JSpinner spiSeg = new JSpinner(new SpinnerNumberModel(0,0,59,1));
    
    JTextField txtFileDirectory = new JTextField();
        
    JButton btnDirectory = new JButton();
    JButton btnSave = new JButton("Guardar");
    JButton btnExit = new JButton("Salir");
            
    //Paneles para acomodar los componentes
    JPanel panelMain = new JPanel(new BorderLayout());
    JPanel panelTimer = new JPanel(new FlowLayout());
    JPanel panelDirectory = new JPanel(new BorderLayout());
    JPanel panelDirectoryLbl = new JPanel(new FlowLayout());
    JPanel panelDirectoryFunction = new JPanel(new GridLayout(1, 2, 10, 10));
    JPanel panelButton = new JPanel(new FlowLayout());
    
    public Settings(){
        super(new Frame(), "Ajutes", true);
        
        initComponents();
        
        btnSave.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                btnSaveActionPerformed(e);
            }
        });
        
        btnExit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btnExitActionPerformed(e);
            }
        });
    }

    
     private void btnSaveActionPerformed(ActionEvent e) {
         setHour(spiHour.getValue());
         setMin(spiMin.getValue());
         setSeg(spiSeg.getValue());
         //setDirectory(txtFileDirectory.getText());
        // configSettings();
         dispose();
    }
     
     
     private void btnExitActionPerformed(ActionEvent e) {
         dispose();
    }
     
     /**
      * Escribo el archivo de configuración
      */
     public void configSettings(){       
         FileWriter file = null;
         PrintWriter pw;
         try{
             // Obtengo el camino absoluto de mi directorio actual
             //String directory = System.getProperty("user.dir");
             file = new FileWriter(System.getProperty("user.dir")+"/src/config/settings", true);
             pw = new PrintWriter(file);
             
             pw.println(getHour());
             pw.println(getMin());
             pw.println(getSeg());
         }catch(IOException e){
             System.err.println("Error:"+e.toString());
         }finally{
             try{
                 if(file != null)
                     file.close();
             }catch(IOException ex){
                 System.err.println("Error:"+ex.toString());
             }
         }
     }
     
    /**
     * @return the hour
     */
    public String getHour() {
        return hour;
    }

    /**
     * @param hour the hour to set
     */
    public void setHour(Object hour) {
        // spiHour.setValue(hour);
        this.hour = hour.toString();
    }

    /**
     * @return the min
     */
    public String getMin() {
        return min;
    }

    /**
     * @param min the min to set
     */
    public void setMin(Object min) {
       // spiMin.setValue(min);
        this.min = min.toString();
    }

    /**
     * @return the seg
     */
    public String getSeg() {
        return seg;
    }

    /**
     * @param seg the seg to set
     */
    public void setSeg(Object seg) {
       // spiSeg.setValue(seg);
        this.seg = seg.toString();
    }

    private void initComponents() {  
        //Asignamos un valor por defecto de seguntos
        spiSeg.setValue(8);
        
        btnDirectory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/load32x32.png")));
        
        //Agregamos al panel timer los componentes
        panelTimer.add(lblTimer);
        panelTimer.add(spiHour);
        panelTimer.add(lblHour);
        panelTimer.add(spiMin);
        panelTimer.add(lblMin);
        panelTimer.add(spiSeg);
        panelTimer.add(lblSeg);
        
        //Agregamos al panel DirectoryLbl el label deldirectorio
        panelDirectoryLbl.add(lblDirectory);
         
        //Agregamos al panel Directory Function los componentes
        panelDirectoryFunction.add(txtFileDirectory);
        panelDirectoryFunction.add(btnDirectory);
        
        //Agregamos al panel Directory los paneles DirectoryLbl y DirectoryFunction
        panelDirectory.add("Center", panelDirectoryLbl);
        panelDirectory.add("South", panelDirectoryFunction);
        
        //Agregamos al panel Button los botones
        panelButton.add(btnSave);
        
        //Agregamos al panel main los paneles timer y directory que contienen los componentes
        panelMain.add("North", panelTimer);
       // panelMain.add("Center", panelDirectory);
       // panelMain.add("South", panelButton);
        
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

    /**
     * @return the directory
     */
    public String getDirectory() {
        return directory;
    }

    /**
     * @param directory the directory to set
     */
    public void setDirectory(String directory) {
        this.directory = directory;
    }
    
}