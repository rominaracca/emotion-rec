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
    
    private String lastName="", name="", sex, age, civilStatus, educationYears,
            occupation, occupationYears, caseNumber="", code="", medicalHistory,
            PsychologicalHistory, PharmacologicalTreatment, Observations;
    
    JLabel lblLastName = new JLabel("Apellido:");
    JLabel lblName = new JLabel("Nombre:");
    JLabel lblSex = new JLabel("Sexo:");
    JLabel lblAge = new JLabel("Edad:");
    JLabel lblCivilStatus = new JLabel("Estado civil:");
    JLabel lblEducationYears = new JLabel("Años de escolaridad:");
    JLabel lblOccupation = new JLabel("Ocupación:");
    JLabel lblOccupationYears = new JLabel("Años en la ocupación:");
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
               btnExitActionPerformed(e);
                //dispose();    //oculta la ventana pero no finaliza la aplicacion
            }
        });
        
        btnSave.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("Presiono gusradar");
                setLastName(txtFileLastName.getText());
                
                setName(txtFileName.getText());
             
                setSex(boxSex.getSelectedItem().toString());
             
                setAge(spiAge.getValue().toString());
                
                setCivilStatus(boxCivilStatus.getSelectedItem().toString());
                
                setEducationYears(spiEducationYears.getValue().toString());
                
                setOccupation(boxOccupation.getSelectedItem().toString());
                
                setOccupationYears(spiOccupationYears.getValue().toString());
                
                System.out.println("Años de coaupacion "+getOccupationYears());
                
                setCaseNumber(txtFileCaseNumber.getText());
                
                setCode(txtFileCode.getText());
                
                setMedicalHistory(txtAreaMedicalHistory.getText());
                
                setPsychologicalHistory(txtAreaPsychologicalHistory.getText());
                
                setPharmacologicalTreatment(txtAreaPharmacologicalTreatment.getText());
                
                setObservations(txtAreaObservations.getText());
            }
        });
    
    }

     private void btnExitActionPerformed(ActionEvent e) {
        dispose();
    }
    
    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return the age
     */
    public String getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * @return the civilStatus
     */
    public String getCivilStatus() {
        return civilStatus;
    }

    /**
     * @param civilStatus the civilStatus to set
     */
    public void setCivilStatus(String civilStatus) {
        this.civilStatus = civilStatus;
    }

    /**
     * @return the occupation
     */
    public String getOccupation() {
        return occupation;
    }

    /**
     * @param occupation the occupation to set
     */
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    /**
     * @return the occupationYears
     */
    public String getOccupationYears() {
        return occupationYears;
    }

    /**
     * @param occupationYears the occupationYears to set
     */
    public void setOccupationYears(String occupationYears) {
        this.occupationYears = occupationYears;
    }

    /**
     * @return the educationYears
     */
    public String getEducationYears() {
        return educationYears;
    }

    /**
     * @param educationYears the educationYears to set
     */
    public void setEducationYears(String educationYears) {
        this.educationYears = educationYears;
    }

    /**
     * @return the caseNumber
     */
    public String getCaseNumber() {
        return caseNumber;
    }

    /**
     * @param caseNumber the caseNumber to set
     */
    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the medicalHistory
     */
    public String getMedicalHistory() {
        return medicalHistory;
    }

    /**
     * @param medicalHistory the medicalHistory to set
     */
    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    /**
     * @return the PsychologicalHistory
     */
    public String getPsychologicalHistory() {
        return PsychologicalHistory;
    }

    /**
     * @param PsychologicalHistory the PsychologicalHistory to set
     */
    public void setPsychologicalHistory(String PsychologicalHistory) {
        this.PsychologicalHistory = PsychologicalHistory;
    }

    /**
     * @return the PharmacologicalTreatment
     */
    public String getPharmacologicalTreatment() {
        return PharmacologicalTreatment;
    }

    /**
     * @param PharmacologicalTreatment the PharmacologicalTreatment to set
     */
    public void setPharmacologicalTreatment(String PharmacologicalTreatment) {
        this.PharmacologicalTreatment = PharmacologicalTreatment;
    }

    /**
     * @return the Observations
     */
    public String getObservations() {
        return Observations;
    }

    /**
     * @param Observations the Observations to set
     */
    public void setObservations(String Observations) {
        this.Observations = Observations;
    }
}
