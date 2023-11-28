package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;

import modelos.Partido;
public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCalcPuntaje = new JButton("Calcular puntaje");
		btnCalcPuntaje.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnCalcPuntaje.setBounds(161, 227, 146, 23);
		contentPane.add(btnCalcPuntaje);
		
		JLabel lblSelecOpcion = new JLabel("Seleccione una opcion:");
		lblSelecOpcion.setBackground(new Color(255, 255, 255));
		lblSelecOpcion.setBounds(61, 149, 207, 14);
		contentPane.add(lblSelecOpcion);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(59, 30, 86, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lbl_ingreseNombre = new JLabel("Ingrese su nombre y presione Enter:");
		lbl_ingreseNombre.setBounds(59, 10, 248, 14);
		contentPane.add(lbl_ingreseNombre);
		
		JLabel lblPartido = new JLabel("Partido:");
		lblPartido.setBounds(61, 61, 46, 14);
		contentPane.add(lblPartido);
		
		JFormattedTextField frmtdtxtfldInfoPartido = new JFormattedTextField();
		frmtdtxtfldInfoPartido.setText("(ver como traigo la info a este panel)");
		frmtdtxtfldInfoPartido.setBounds(61, 86, 231, 39);
		contentPane.add(frmtdtxtfldInfoPartido);
		
		JRadioButton rdbtnGanaEquipo1 = new JRadioButton("Gana equipo 1");
		rdbtnGanaEquipo1.setBounds(42, 180, 107, 23);
		contentPane.add(rdbtnGanaEquipo1);
		
		JRadioButton rdbtnEmpate = new JRadioButton("Empate");
		rdbtnEmpate.setBounds(161, 180, 107, 23);
		contentPane.add(rdbtnEmpate);
		
		JRadioButton rdbtnGanaEquipo2 = new JRadioButton("Gana equipo 2");
		rdbtnGanaEquipo2.setBounds(279, 180, 107, 23);
		contentPane.add(rdbtnGanaEquipo2);
		
		ButtonGroup grupo1 = new ButtonGroup();//hace que solo se pueda seleccionar una opción
		grupo1.add(rdbtnGanaEquipo1);
		grupo1.add(rdbtnEmpate);
		grupo1.add(rdbtnGanaEquipo2);
		
		rdbtnGanaEquipo1.setVisible(false);
        rdbtnEmpate.setVisible(false);
        rdbtnGanaEquipo2.setVisible(false);
		btnCalcPuntaje.setVisible(false);
		lblSelecOpcion.setVisible(false);
		lblPartido.setVisible(false);
		frmtdtxtfldInfoPartido.setVisible(false);

		
		textFieldNombre.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String nombre = textFieldNombre.getText(); //ver en que variable se esta guardando
				btnCalcPuntaje.setVisible(true);
		        rdbtnGanaEquipo1.setVisible(true);
		        rdbtnEmpate.setVisible(true);
		        rdbtnGanaEquipo2.setVisible(true);
		        lblSelecOpcion.setVisible(true);
		        lblPartido.setVisible(true);
		        frmtdtxtfldInfoPartido.setVisible(true);
			}
		
		});
	}
}

