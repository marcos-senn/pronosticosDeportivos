package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import org.example.Main;

import javax.swing.JTextField;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import datos.ConexionDB;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import modelos.IngresarDatos;
import modelos.Inicio;
import modelos.Partido;
import negocios.ObtenerDatos;
import modelos.CalculadorPuntaje;

import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.JTable;
import java.awt.Choice;
import javax.swing.ScrollPaneConstants;
public class VentanaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private CardLayout cardLayout = new CardLayout();
	protected Container panel2;
	private JTable table_1;


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
	    setBounds(100, 100, 799, 600);
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

	    JLabel item1 = new JLabel("1. Mostrar puntajes");
	    item1.setForeground(Color.BLACK);
	    item1.setFont(new Font("Georgia", Font.BOLD, 25));
	    item1.setBounds(173, 118, 361, 50);
	    item1.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	            cardLayout.show(panelPrincipal, "Panel 1");
	        }
	    });
	    panel.add(item1);

	    JLabel item2 = new JLabel("2. Configurar puntos");
	    item2.setForeground(Color.BLACK);
	    item2.setFont(new Font("Georgia", Font.BOLD, 25));
	    item2.setBounds(173, 193, 475, 50);
	    item2.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	            cardLayout.show(panelPrincipal, "Panel 2");
	        }
	    });
	    panel.add(item2);

	    JLabel item3 = new JLabel("3. Apostar por un pronóstico");
	    item3.setForeground(Color.BLACK);
	    item3.setFont(new Font("Georgia", Font.BOLD, 25));
	    item3.setBounds(173, 268, 475, 50);
	    item3.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	            cardLayout.show(panelPrincipal, "Panel 3");
	        }
	    });
	    panel.add(item3);

	    JLabel item4 = new JLabel("4. Salir");
	    item4.setForeground(Color.BLACK);
	    item4.setFont(new Font("Georgia", Font.BOLD, 25));
	    item4.setBounds(173, 340, 475, 50);
	    item4.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	            System.exit(0);
	        }
	    });
	    panel.add(item4);

	    JLabel lblPagPrincipal = new JLabel("Pagina principal de pronosticos futbolísticos");
	    lblPagPrincipal.setForeground(Color.BLACK);
	    lblPagPrincipal.setBounds(100, 11, 645, 46);
	    lblPagPrincipal.setBackground(new Color(255, 255, 255));
	    lblPagPrincipal.setFont(new Font("Georgia", Font.PLAIN, 30));
	    panel.add(lblPagPrincipal);

	    JPanel panel_1 = new JPanel();
	    panel_1.setBackground(Color.LIGHT_GRAY);
	    panel_1.setBounds(80, 11, 631, 46);
	    panel.add(panel_1);
	    
	    JPanel panel_2 = new JPanel();
	    panel_2.setBounds(161, 118, 397, 50);
	    panel.add(panel_2);
	    
	    JPanel panel_3 = new JPanel();
	    panel_3.setBounds(161, 193, 397, 50);
	    panel.add(panel_3);
	    
	    JPanel panel_4 = new JPanel();
	    panel_4.setBounds(161, 268, 397, 50);
	    panel.add(panel_4);
	    
	    JPanel panel_5 = new JPanel();
	    panel_5.setBounds(161, 340, 397, 50);
	    panel.add(panel_5);

	    return panel;
	}

	private JPanel crearPanel1(Container panelPrincipal) {
		JPanel panel1 = new JPanel();
	    panel1.setBackground(new Color(0, 100, 0));
	    panel1.setLayout(null);

	    JButton btnVolver1 = new JButton("Volver");
	    btnVolver1.setBounds(684, 532, 93, 23);
	    btnVolver1.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	cardLayout.show(panelPrincipal, "Panel 0");
	        }
	    });
	    panel1.add(btnVolver1);

	    JLabel lblPuntajes = new JLabel("---------------------------------------------- Puntajes ----------------------------------------------");
	    lblPuntajes.setHorizontalAlignment(SwingConstants.CENTER);
	    lblPuntajes.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    lblPuntajes.setBounds(0, 10, 787, 49);
	    panel1.add(lblPuntajes);

		String[] args = Main.commandLineArgs;
		Object[][] datosIniciales = Inicio.iniciar(args);
	    Object[][] data = new Object[datosIniciales.length + 1][];
	    data[0] = new Object[]{"Nombre", "Puntaje"};
	    for (int i = 0; i < datosIniciales.length; i++) {
	        data[i + 1] = datosIniciales[i];
	    }


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
		btnVolver2.setBounds(600, 527, 93, 23);
		btnVolver2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelPrincipal, "Panel 0");
			}
		});
		panel2.add(btnVolver2);

		JLabel lblCargaDe = new JLabel("----------------------------------------- Asignacion de puntos -----------------------------------------");
		lblCargaDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblCargaDe.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCargaDe.setBounds(-15, 6, 814, 49);
		panel2.add(lblCargaDe);

		// Primer input y botón
		JLabel lblLabel1 = new JLabel("Puntos por cada acierto");
		lblLabel1.setForeground(Color.WHITE);
		lblLabel1.setBounds(20, 100, 300, 20);
		panel2.add(lblLabel1);

		JTextField textField1 = new JTextField();
		textField1.setBounds(200, 100, 150, 20);
		panel2.add(textField1);

		JButton btnBoton1 = new JButton("Aplicar");
		btnBoton1.setBounds(textField1.getX() + textField1.getWidth() + 10, 100, 100, 23);
		btnBoton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int nuevosPuntosPorAcierto = Integer.parseInt(textField1.getText());
				Inicio.actualizarConfiguracion(nuevosPuntosPorAcierto);
				System.out.println("Nuevo valor de puntos: " + nuevosPuntosPorAcierto);
			}
		});
		panel2.add(btnBoton1);

		// Segundo input y botón
		// Segundo input y botón
		JLabel lblLabel2 = new JLabel("Puntos extra por acertar todo");
		lblLabel2.setForeground(Color.WHITE);
		lblLabel2.setBounds(20, 150, 300, 20);
		panel2.add(lblLabel2);

		JTextField textField2 = new JTextField();
		textField2.setBounds(200, 150, 150, 20);
		panel2.add(textField2);

		JButton btnBoton2 = new JButton("Aplicar");
		btnBoton2.setBounds(textField2.getX() + textField2.getWidth() + 10, 150, 100, 23);
		btnBoton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int nuevosPuntosPorAciertoTodo = Integer.parseInt(textField2.getText());
				Inicio.actualizarConfiguracion(nuevosPuntosPorAciertoTodo);
				System.out.println("Nuevo valor de puntos por acertar todo: " + nuevosPuntosPorAciertoTodo);
			}
		});
		panel2.add(btnBoton2);
		return panel2;
	}

    private JPanel crearPanel3(Container panelPrincipal) {
        JPanel panel3 = new JPanel(null); // Establece null para el administrador de diseño
        panel3.setBackground(new Color(0, 100, 0));
        
        
        contentPane.setLayout(null);

        JButton btnCalcPuntaje = new JButton("Ver puntaje");
        btnCalcPuntaje.setForeground(Color.BLACK);
		btnCalcPuntaje.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnCalcPuntaje.setBounds(310, 456, 148, 23);
		btnCalcPuntaje.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	cardLayout.show(panelPrincipal, "Panel 1");
	        }
	    });
		panel3.add(btnCalcPuntaje);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(342, 93, 86, 20);
		panel3.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lbl_ingreseNombre = new JLabel("Ingrese su nombre y presione Enter:");
		lbl_ingreseNombre.setForeground(Color.BLACK);
		lbl_ingreseNombre.setBounds(284, 67, 248, 14);
		panel3.add(lbl_ingreseNombre);
		
		JLabel lblPartido = new JLabel("Partidos:");
		lblPartido.setForeground(Color.BLACK);
		lblPartido.setBounds(175, 209, 59, 14);
		panel3.add(lblPartido);
		
		JRadioButton rdbtnGanaEquipo1 = new JRadioButton("Gana equipo 1");
		rdbtnGanaEquipo1.setForeground(Color.BLACK);
		rdbtnGanaEquipo1.setBounds(191, 401, 127, 23);
		panel3.add(rdbtnGanaEquipo1);
		
		JRadioButton rdbtnEmpate = new JRadioButton("Empate");
		rdbtnEmpate.setForeground(Color.BLACK);
		rdbtnEmpate.setBounds(330, 401, 86, 23);
		panel3.add(rdbtnEmpate);
		
		JRadioButton rdbtnGanaEquipo2 = new JRadioButton("Gana equipo 2");
		rdbtnGanaEquipo2.setForeground(Color.BLACK);
		rdbtnGanaEquipo2.setBounds(428, 401, 127, 23);
		panel3.add(rdbtnGanaEquipo2);
		
		ButtonGroup grupo1 = new ButtonGroup();//hace que solo se pueda seleccionar una opción
		grupo1.add(rdbtnGanaEquipo1);
		grupo1.add(rdbtnEmpate);
		grupo1.add(rdbtnGanaEquipo2);

		boolean ganaEquipo1 = rdbtnGanaEquipo1.isSelected();
		boolean empate = rdbtnEmpate.isSelected();
		boolean ganaEquipo2 = rdbtnGanaEquipo2.isSelected();
		
		JButton btnVolver3 = new JButton("Volver");
		btnVolver3.setForeground(Color.BLACK);
		btnVolver3.setBounds(684, 532, 93, 23);
		btnVolver3.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	cardLayout.show(panelPrincipal, "Panel 0");
	        }
	    });
		panel3.add(btnVolver3);
		
		JLabel lblPronstico = new JLabel("---------------------------------------------- Pronóstico ----------------------------------------------");
		lblPronstico.setForeground(Color.BLACK);
		lblPronstico.setHorizontalAlignment(SwingConstants.CENTER);
		lblPronstico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPronstico.setBounds(-17, 6, 814, 49);
		panel3.add(lblPronstico);
		
		
		DefaultTableModel model = new DefaultTableModel();
		table_1 = new JTable();

		// Agregar las columnas al modelo de la tabla
		model.addColumn("N°");
		model.addColumn("Equipo 1");
		model.addColumn("VS");
		model.addColumn("Equipo 2");

		ConexionDB conexion = null;
		try {
			conexion = new ConexionDB("jdbc:mysql://localhost:3306/programa", "root", "admin");
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		ObtenerDatos obtenerDatos = new ObtenerDatos(conexion);

		ArrayList<Partido> partidos = null;
		try {
			partidos = obtenerDatos.consultarDatosResultados();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		int numero = 1;
		for (Partido partido : partidos) {
		    model.addRow(new Object[] {
		        numero,
		        partido.getEquipo1().getNombre(),
		        "vs",
		        partido.getEquipo2().getNombre()
		    });
		    numero++;
		}
		

		table_1.setModel(model);

		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setSize(273, 123);
		scrollPane.setLocation(246, 196);
		scrollPane.setPreferredSize(new Dimension(500, 500));

		panel3.add(scrollPane);
		
		Choice choice = new Choice();
		choice.setForeground(Color.BLACK);
		for (int i = 1; i <= 15; i++) {
		    choice.add(Integer.toString(i));
		}
		choice.setBounds(330, 353, 98, 22);
		int indice_partido = Integer.parseInt(choice.getSelectedItem());
		panel3.add(choice);
		
		Partido partidoSeleccionado = partidos.get(indice_partido - 1);
		String nomEquipo1 = partidoSeleccionado.getEquipo1().getNombre();
		String nomEquipo2 = partidoSeleccionado.getEquipo2().getNombre();
		JLabel lblSelecPartido = new JLabel("Seleccione un partido a pronosticar:");
		
		lblSelecPartido.setForeground(Color.BLACK);
		lblSelecPartido.setBounds(284, 331, 210, 16);
		panel3.add(lblSelecPartido);

		choice.setVisible(false);
		lblSelecPartido.setVisible(false);
		scrollPane.setVisible(false);
		table_1.setVisible(false);
		rdbtnGanaEquipo1.setVisible(false);
		rdbtnEmpate.setVisible(false);
        rdbtnGanaEquipo2.setVisible(false);
		btnCalcPuntaje.setVisible(false);
		lblPartido.setVisible(false);
		panel3.add(lblSelecPartido);

		
		textFieldNombre.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e) {
		        String nombre = textFieldNombre.getText();
		        textFieldNombre.setVisible(true);
				choice.setVisible(true);
		        lblSelecPartido.setVisible(true);
		        scrollPane.setVisible(true);
		        lbl_ingreseNombre.setVisible(true);
		        btnCalcPuntaje.setVisible(true);
		        rdbtnGanaEquipo1.setVisible(true);
		        rdbtnEmpate.setVisible(true);
		        rdbtnGanaEquipo2.setVisible(true);
		        lblPartido.setVisible(true);
		        table_1.setVisible(true);      

		        //guardado de datos del pronostico y envio a la base de datos
		        IngresarDatos dat = new IngresarDatos();
		        dat.guardarPronostico(nombre, nomEquipo1, ganaEquipo1, empate, ganaEquipo2, nomEquipo2, indice_partido);
		    }
		});

        return panel3;
    }	
	}


