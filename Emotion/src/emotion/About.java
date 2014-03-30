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
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Romina Racca
 */
public class About extends javax.swing.JDialog{
    
	JLabel lblSoftware = new JLabel("Programa de reconocimiento de emociones", JLabel.CENTER);
        JLabel lblClient = new JLabel("Facultad de Psicologia - Universidad Nacional de Córdoba", JLabel.CENTER);
	//JLabel lblIcon = new JLabel(new javax.swing.ImageIcon(getClass().getResource("/icon/flag.png")));
        JLabel lblAuthor = new JLabel("Desarrollado por Romina Carla Racca", JLabel.CENTER);
        JLabel lblEmail = new JLabel("romina.racca@gmail.com", JLabel.CENTER);
        JLabel lblYear = new JLabel("Marzo 2014", JLabel.CENTER);
        
	JButton btnClose = new JButton("Cerrar");

	//Paneles para acomodar los componentes
	JPanel panelMain = new JPanel(new BorderLayout());
	JPanel panelInfo = new JPanel(new GridLayout(5, 1));
	JPanel panelButton = new JPanel(new FlowLayout());

	public About(){
		super(new Frame(), "Acerca de...", true);
                
		//Agregamos al panel info los label creados
		panelInfo.add(lblSoftware);
		panelInfo.add(lblClient);
                //panelInfo.add(lblIcon);
                panelInfo.add(lblAuthor);
                panelInfo.add(lblEmail);
                panelInfo.add(lblYear);

		//Agregamos al panel button el boton close
		panelButton.add(btnClose);
                
		//Agregamos al panel main los paneles info y button que contiene los componentes
		panelMain.add("Center", panelInfo);
		panelMain.add("South", panelButton);

		//Agregamos el panel main al cuadro de dialogo About
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


		//Agregamos el evento al boton close
		btnClose.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();  //oculta la ventana pero no finaliza la aplicacion
			}
		});
	}
    
}
