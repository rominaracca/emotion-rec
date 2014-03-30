package emotion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Romina Racca
 */
public class Information extends javax.swing.JDialog{
    
    JLabel lblLastName = new JLabel("Apellido:");
    JLabel lblName = new JLabel("Nombre:");
    JLabel lblSex = new JLabel("Sexo:");
    JLabel lblAge = new JLabel("Edad:");
    JLabel lblCivilStatus = new JLabel("Estado civil:");
    JLabel lblOccupation = new JLabel("Ocupación:");
    JLabel lblOccupationYears = new JLabel("Años en la ocupación:");
    JLabel lblEducationYears = new JLabel("Años de escolaridad:");
    JLabel lblCaseNumber = new JLabel("Número de caso:");
    JLabel lblCode = new JLabel("Código:");
    JLabel lblMedicalHistory = new JLabel("Antecedentes médicos:");
    JLabel lblPsychologicalHistory = new JLabel("Antecedentes psicológicos:");
    JLabel lblPharmacologicalTreatment = new JLabel("Tratamiento farmacológico:");
    JLabel lblObservations = new JLabel("Observaciones:");
    
    JTextField txtFileLastName = new JTextField();
    JTextField txtFileName = new JTextField();
    JTextField txtFileCaseNumber = new JTextField();
    JTextField txtFileCode = new JTextField();
    
    String strCivilStatus[] = {"Soltero", "Casado", "Divorciado", "Separado", "Viudo"};
    String strOccupation[] = {"Empleado administrativo", "Estudiante", "Docente", "Otra ocupación"};
    String strSex[] = {"Femenino", "Masculino"};
    
    JComboBox boxCivilStatus = new JComboBox(strCivilStatus);
    JComboBox boxOccupation = new JComboBox(strOccupation);
    JComboBox boxSex = new JComboBox(strSex);
    
    JSpinner spiAge = new JSpinner(new SpinnerNumberModel(0,0,100,1));
    JSpinner spiOccupationYears = new JSpinner(new SpinnerNumberModel(0,0,100,1));
    JSpinner spiEducationYears = new JSpinner(new SpinnerNumberModel(0,0,100,1));
    
    JTextArea txtAreaMedicalHistory = new JTextArea("Sin antecedentes.", 5, 20);
    JTextArea txtAreaPsychologicalHistory = new JTextArea("Sin antecedentes", 5, 20);
    JTextArea txtAreaPharmacologicalTreatment = new JTextArea("Sin tratamiento", 5, 20);
    JTextArea txtAreaObservations = new JTextArea("Sin observaciones", 5, 20);
    
    JScrollPane scrollMedicalHistory = new JScrollPane();
    JScrollPane scrollPsychologicalHistory = new JScrollPane();
    JScrollPane scrollPharmacologicalTreatment = new JScrollPane();
    JScrollPane scrollObservations = new JScrollPane();
        
    JButton btnSave = new JButton("Guardar");
    JButton btnExit = new JButton("Salir");
    
    //Paneles para acomodar los componentes
    JPanel panelMain = new JPanel(new BorderLayout());
    JPanel panelInformation = new JPanel(new GridLayout(5, 4, 40, 15));
    JPanel panelArea = new JPanel(new GridLayout(2, 4, 40, 15));
    JPanel panelButton = new JPanel(new FlowLayout());
    
    
    public Information(){
        super(new Frame(), "Cargar datos", true);
        
        //Para que en los textArea haga el salto de línea buscando espacios entre las palabras 
        txtAreaMedicalHistory.setWrapStyleWord(true);
        txtAreaPsychologicalHistory.setWrapStyleWord(true);
        txtAreaPharmacologicalTreatment.setWrapStyleWord(true);
        txtAreaObservations.setWrapStyleWord(true);
        
        //Agregamos el scroll a las area de texto
        scrollMedicalHistory.setViewportView(txtAreaMedicalHistory);
        scrollPsychologicalHistory.setViewportView(txtAreaPsychologicalHistory);
        scrollPharmacologicalTreatment.setViewportView(txtAreaPharmacologicalTreatment);
        scrollObservations.setViewportView(txtAreaObservations);
        
        //Agregamos al panel Information los componentes
        panelInformation.add(lblLastName);
        panelInformation.add(txtFileLastName);
        panelInformation.add(lblName);
        panelInformation.add(txtFileName); 
        
        panelInformation.add(lblSex);
        panelInformation.add(boxSex);
        panelInformation.add(lblAge);
        panelInformation.add(spiAge);
        
        panelInformation.add(lblCivilStatus);
        panelInformation.add(boxCivilStatus);
        panelInformation.add(lblEducationYears);
        panelInformation.add(spiEducationYears);
        
        panelInformation.add(lblOccupation);
        panelInformation.add(boxOccupation);
        panelInformation.add(lblOccupationYears);
        panelInformation.add(spiOccupationYears);
        
        panelInformation.add(lblCaseNumber);
        panelInformation.add(txtFileCaseNumber);
        panelInformation.add(lblCode);
        panelInformation.add(txtFileCode);
        
        panelArea.add(lblMedicalHistory);
        panelArea.add(scrollMedicalHistory);
        panelArea.add(lblPsychologicalHistory);
        panelArea.add(scrollPsychologicalHistory);
        
        panelArea.add(lblPharmacologicalTreatment);
        panelArea.add(scrollPharmacologicalTreatment);
        panelArea.add(lblObservations);
        panelArea.add(scrollObservations);
        
        //Agregamos al panel Button los componentes
        panelButton.add(btnSave);
        panelButton.add(btnExit);
        
        //Agregamos al panel Main los paneles Information y Button que contienen los componentes
        panelMain.add("North", panelInformation);
        panelMain.add("Center", panelArea);
        panelMain.add("South", panelButton);
        
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
        
        
        //Agregamos evento a los botones
        btnExit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();    //oculta la ventana pero no finaliza la aplicacion
            }
        });
        
        btnSave.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("Presiono gusradas");
                
            }
        });
    
    }
}
