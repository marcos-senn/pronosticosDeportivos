package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;

import org.example.Main;

import javax.swing.JTextField;
import javax.swing.JToolBar;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerListener;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;

import modelos.Inicio;
import modelos.Partido;
import javax.swing.SwingConstants;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.JTable;
public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private CardLayout cardLayout = new CardLayout();
	protected Container panel2;
	private JTable table;
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
	public VentanaPrincipal() {
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(100, 100, 850, 600);
	    contentPane = new JPanel();
	    contentPane.setBackground(new Color(64, 128, 128));
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    JPanel panelPrincipal = new JPanel(cardLayout);

	    JPanel panel0 = crearPanel0(panelPrincipal);
	    JPanel panel1 = crearPanel1(panelPrincipal);
	    JPanel panel2 = crearPanel2(panelPrincipal);
	    JPanel panel3 = crearPanel3(panelPrincipal);
	
	    panelPrincipal.add(panel0, "Panel 0");
	    panelPrincipal.add(panel1, "Panel 1");
	    panelPrincipal.add(panel2, "Panel 2");
	    panelPrincipal.add(panel3, "Panel 3");

	    cardLayout.show(panelPrincipal, "Panel 0");

	    getContentPane().add(panelPrincipal);

	    setVisible(true);
	}


	private JPanel crearPanel0(Container panelPrincipal) {
	    JPanel panel = new JPanel();
	    panel.setBackground(new Color(0, 100, 0));
	    panel.setLayout(null);

	    JToolBar toolBar = new JToolBar();
	    toolBar.setOrientation(SwingConstants.VERTICAL);
	    toolBar.setSize(413, 259);
	    toolBar.setLocation(203, 50);

	    JButton item1 = new JButton("1. Mostrar puntajes");
	    item1.setFont(new Font("Georgia", Font.BOLD, 17));
	    item1.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	cardLayout.show(panelPrincipal, "Panel 1");
	        }
	    });
	    toolBar.add(item1);

	    JButton item4 = new JButton("4. Salir");
	    item4.setFont(new Font("Georgia", Font.BOLD, 16));
	    item4.setHorizontalAlignment(SwingConstants.LEFT);
	    item4.setVerticalAlignment(SwingConstants.TOP);
	    item4.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	System.exit(0);
	        }
	    });
	    
	    JButton item2 = new JButton("2. Cargar datos");
	    item2.setFont(new Font("Georgia", Font.BOLD, 17));
	    item2.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	cardLayout.show(panelPrincipal, "Panel 2");
	        }
	    });
	    toolBar.add(item2);
	    
	    JButton item3 = new JButton("3. Apostar por un pronóstico");
	    item3.setFont(new Font("Georgia", Font.BOLD, 17));
	    item3.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	cardLayout.show(panelPrincipal, "Panel 3");
	        }
	    });
	    toolBar.add(item2);
	    toolBar.add(item3); 
	    toolBar.add(item4);

	    panel.add(toolBar, BorderLayout.PAGE_START);
	   
	    
	    JLabel lblPagPrincipal = new JLabel("Pagina principal de pronosticos futbolísticos");
	    lblPagPrincipal.setBackground(new Color(255, 255, 255));
	    lblPagPrincipal.setFont(new Font("Georgia", Font.PLAIN, 15));
	    lblPagPrincipal.setBounds(265, 11, 318, 28);
	    panel.add(lblPagPrincipal);

	    return panel;
	}

	private JPanel crearPanel1(Container panelPrincipal) {
		JPanel panel1 = new JPanel();
	    panel1.setBackground(new Color(0, 100, 0));
	    panel1.setLayout(null);
	    
	    JButton btnVolver1 = new JButton("Volver");
	    btnVolver1.setBounds(731, 527, 93, 23);
	    btnVolver1.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	cardLayout.show(panelPrincipal, "Panel 0");
	        }
	    });
	    panel1.add(btnVolver1);
	    
	    JLabel lblPuntajes = new JLabel("------------------------------------------------- Puntajes -------------------------------------------------");
	    lblPuntajes.setHorizontalAlignment(SwingConstants.CENTER);
	    lblPuntajes.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    lblPuntajes.setBounds(10, 11, 814, 49);
	    panel1.add(lblPuntajes);
	    
		String[] args = Main.commandLineArgs;
		Object[][] datosIniciales = Inicio.iniciar(args);
	    Object[][] data = new Object[datosIniciales.length + 1][];
	    data[0] = new Object[]{"Nombre", "Puntaje"};
	    for (int i = 0; i < datosIniciales.length; i++) {
	        data[i + 1] = datosIniciales[i];
	    }
	    
	    String[] columnNames = {"Nombre", "Puntajes"};
	    JTable table = new JTable(data, new String[] {"", ""}); 
	    table.setBounds(145, 71, 546, 323);
	    
	
	    panel1.add(table);
	    
	    return panel1;
	
	}
	
	private JPanel crearPanel2(Container panelPrincipal) {
		JPanel panel2 = new JPanel();
	    panel2.setBackground(new Color(0, 100, 0));
	    panel2.setLayout(null);
	    
	    JButton btnVolver2 = new JButton("Volver");
	    btnVolver2.setBounds(731, 527, 93, 23);
	    btnVolver2.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	cardLayout.show(panelPrincipal, "Panel 0");
	        }
	    });
	    panel2.add(btnVolver2);
	    
	    JLabel lblCargaDe = new JLabel("-------------------------------------------- Carga de partidos --------------------------------------------");
	    lblCargaDe.setHorizontalAlignment(SwingConstants.CENTER);
	    lblCargaDe.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    lblCargaDe.setBounds(10, 11, 814, 49);
	    panel2.add(lblCargaDe);
	    
	    return panel2;
	}
	
	
	
	
	
	
	
	
    private JPanel crearPanel3(Container panelPrincipal) {
        JPanel panel3 = new JPanel(null); // Establece null para el administrador de diseño
        panel3.setBackground(new Color(0, 100, 0));
        
        
        contentPane.setLayout(null);

        JButton btnCalcPuntaje = new JButton("Calcular puntaje");
		btnCalcPuntaje.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnCalcPuntaje.setBounds(454, 413, 148, 23);
		panel3.add(btnCalcPuntaje);
		
		JLabel lblSelecOpcion = new JLabel("Seleccione una opcion:");
		lblSelecOpcion.setBackground(new Color(255, 255, 255));
		lblSelecOpcion.setBounds(67, 328, 165, 14);
		panel3.add(lblSelecOpcion);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(313, 95, 86, 20);
		panel3.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lbl_ingreseNombre = new JLabel("Ingrese su nombre y presione Enter:");
		lbl_ingreseNombre.setBounds(67, 98, 248, 14);
		panel3.add(lbl_ingreseNombre);
		
		JLabel lblPartido = new JLabel("Partido:");
		lblPartido.setBounds(67, 146, 59, 14);
		panel3.add(lblPartido);
		
		JFormattedTextField frmtdtxtfldInfoPartido = new JFormattedTextField();
		frmtdtxtfldInfoPartido.setText("(ver como traigo la info a este panel)");
		frmtdtxtfldInfoPartido.setBounds(197, 139, 349, 121);
		panel3.add(frmtdtxtfldInfoPartido);
		
		JRadioButton rdbtnGanaEquipo1 = new JRadioButton("Gana equipo 1");
		rdbtnGanaEquipo1.setBounds(283, 324, 127, 23);
		panel3.add(rdbtnGanaEquipo1);
		
		JRadioButton rdbtnEmpate = new JRadioButton("Empate");
		rdbtnEmpate.setBounds(428, 324, 86, 23);
		panel3.add(rdbtnEmpate);
		
		JRadioButton rdbtnGanaEquipo2 = new JRadioButton("Gana equipo 2");
		rdbtnGanaEquipo2.setBounds(533, 324, 127, 23);
		panel3.add(rdbtnGanaEquipo2);
		
		ButtonGroup grupo1 = new ButtonGroup();//hace que solo se pueda seleccionar una opción
		grupo1.add(rdbtnGanaEquipo1);
		grupo1.add(rdbtnEmpate);
		grupo1.add(rdbtnGanaEquipo2);
		
		JButton btnVolver3 = new JButton("Volver");
		btnVolver3.setBounds(731, 527, 93, 23);
		btnVolver3.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	cardLayout.show(panelPrincipal, "Panel 0");
	        }
	    });
		panel3.add(btnVolver3);
		
		JLabel lblPronstico = new JLabel("------------------------------------------------- Pronóstico -------------------------------------------------");
		lblPronstico.setHorizontalAlignment(SwingConstants.CENTER);
		lblPronstico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPronstico.setBounds(10, 11, 814, 49);
		panel3.add(lblPronstico);
		
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
				textFieldNombre.setVisible(true);
				lbl_ingreseNombre.setVisible(true);
				btnCalcPuntaje.setVisible(true);
		        rdbtnGanaEquipo1.setVisible(true);
		        rdbtnEmpate.setVisible(true);
		        rdbtnGanaEquipo2.setVisible(true);
		        lblSelecOpcion.setVisible(true);
		        lblPartido.setVisible(true);
		        frmtdtxtfldInfoPartido.setVisible(true);
			}
		
		});
        return panel3;
    }	
	}


