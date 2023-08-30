package main;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import huespedes.Huesped;
import huespedes.HuespedDTO;
import reservas.Reserva;
import reservas.ReservaDTO;
import services.ConsultarInformacion;
import services.EliminarInformacion;
import services.ModificarInformacion;
import services.MostrarInformacion;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("serial")
public class Busqueda extends JFrame {

	private ConsultarInformacion consultarInformacion;
	private MostrarInformacion mostrarInformacion;
	private ModificarInformacion modificarInformacion;
	private EliminarInformacion eliminarInformacion;
	
	private JPanel contentPane;
	private JTextField txtBuscar;
	private JTable tbHuespedes;
	private JTable tbReservas;
	private DefaultTableModel modeloReservas;
	private DefaultTableModel modeloHuesped;
	private JLabel labelAtras;
	private JLabel labelExit;
	private JPanel btnAtras;
	private JPanel btnexit;
	private JTabbedPane panel;
	private JButton btnEditar;
	private JButton btnEliminar;
	private JButton btnbuscar;
	int xMouse, yMouse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Busqueda frame = new Busqueda();
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
	public Busqueda() {
		
		mostrarInformacion = new MostrarInformacion();
		consultarInformacion = new ConsultarInformacion();
		modificarInformacion = new ModificarInformacion();
		eliminarInformacion = new EliminarInformacion();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("/imagenes/lupa2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 571);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(536, 127, 193, 31);
		txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		
		JLabel lblNewLabel_4 = new JLabel("SISTEMA DE BÚSQUEDA");
		lblNewLabel_4.setForeground(new Color(12, 138, 199));
		lblNewLabel_4.setFont(new Font("Roboto Black", Font.BOLD, 24));
		lblNewLabel_4.setBounds(331, 62, 330, 42);
		contentPane.add(lblNewLabel_4);
		
		panel = new JTabbedPane(JTabbedPane.TOP);
		panel.setBackground(new Color(12, 138, 199));
		panel.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.setBounds(20, 169, 865, 328);
		contentPane.add(panel);

		modeloReservas = new DefaultTableModel() {
			@Override
		    public boolean isCellEditable(int row, int column) {
				// Column 0 is the id column, editing this column is dangerous because can alter other registers
				if(column==0) {
					return false;
				}
				return true;
		    }
		};
		modeloReservas.addColumn("Número de Reserva");
		modeloReservas.addColumn("Fecha Check In");
		modeloReservas.addColumn("Fecha Check Out");
		modeloReservas.addColumn("Valor");
		modeloReservas.addColumn("Forma de Pago");
		modeloReservas.addColumn("Número de Huesped");	
		
		tbReservas = new JTable(modeloReservas);
		tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
		
		JScrollPane scroll_table = new JScrollPane(tbReservas);
		panel.addTab("Reservas", new ImageIcon(Busqueda.class.getResource("/imagenes/reservado.png")), scroll_table, null);
		scroll_table.setVisible(true);
		
		cargarTablaReservasIniciales();

		modeloHuesped = new DefaultTableModel() {
			@Override
		    public boolean isCellEditable(int row, int column) {
				// Column 0 is the id column, editing this column is dangerous because can alter other registers
				if(column==0) {
					return false;
				}
				return true;
		    }
		};
		modeloHuesped.addColumn("Número de Huesped");
		modeloHuesped.addColumn("Nombre");
		modeloHuesped.addColumn("Apellido");
		modeloHuesped.addColumn("Fecha de Nacimiento");
		modeloHuesped.addColumn("Nacionalidad");
		modeloHuesped.addColumn("Telefono");
		//modeloHuesped.addColumn("Número de Reserva");
		
		tbHuespedes = new JTable(modeloHuesped);
		tbHuespedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbHuespedes.setFont(new Font("Roboto", Font.PLAIN, 16));
		
		JScrollPane scroll_tableHuespedes = new JScrollPane(tbHuespedes);
		panel.addTab("Huéspedes", new ImageIcon(Busqueda.class.getResource("/imagenes/pessoas.png")), scroll_tableHuespedes, null);
		scroll_tableHuespedes.setVisible(true);

		cargarTablaHuespedesIniciales();
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/Ha-100px.png")));
		lblNewLabel_2.setBounds(56, 51, 104, 107);
		contentPane.add(lblNewLabel_2);
		
		JPanel header = new JPanel();
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);
			     
			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);
		
		btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnAtras.setBackground(Color.white);
			     labelAtras.setForeground(Color.black);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);
		
		labelAtras = new JLabel("<");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);
		
		btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) { //Al usuario pasar el mouse por el botón este cambiará de color
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) { //Al usuario quitar el mouse por el botón este volverá al estado original
				 btnexit.setBackground(Color.white);
			     labelExit.setForeground(Color.black);
			}
		});
		btnexit.setLayout(null);
		btnexit.setBackground(Color.WHITE);
		btnexit.setBounds(857, 0, 53, 36);
		header.add(btnexit);
		
		labelExit = new JLabel("X");
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(Color.BLACK);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(new Color(12, 138, 199));
		separator_1_2.setBackground(new Color(12, 138, 199));
		separator_1_2.setBounds(539, 159, 193, 2);
		contentPane.add(separator_1_2);
		
		btnbuscar = new JButton();
		/*btnbuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});*/
		btnbuscar.setLayout(null);
		btnbuscar.setBackground(new Color(12, 138, 199));
		btnbuscar.setBounds(748, 125, 122, 35);
		btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnbuscar);
		
		JLabel lblBuscar = new JLabel("BUSCAR");
		lblBuscar.setBounds(0, 0, 122, 35);
		btnbuscar.add(lblBuscar);
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		btnEditar = new JButton();
		btnEditar.setLayout(null);
		btnEditar.setBackground(new Color(12, 138, 199));
		btnEditar.setBounds(635, 508, 122, 35);
		btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEditar);
		
		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEditar.setBounds(0, 0, 122, 35);
		btnEditar.add(lblEditar);
		
		btnEliminar = new JButton();
		btnEliminar.setLayout(null);
		btnEliminar.setBackground(new Color(12, 138, 199));
		btnEliminar.setBounds(767, 508, 122, 35);
		btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEliminar);
		
		JLabel lblEliminar = new JLabel("ELIMINAR");
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setForeground(Color.WHITE);
		lblEliminar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEliminar.setBounds(0, 0, 122, 35);
		btnEliminar.add(lblEliminar);
		setResizable(false);
		
		
		
		/**
		 * 
		 * 
		 * 
		 * 
		 * */
		
		configurarAccionesDelFormulario();
	}
	
//Código que permite mover la ventana por la pantalla según la posición de "x" y "y"
	private void headerMousePressed(java.awt.event.MouseEvent evt) {
	       xMouse = evt.getX();
	       yMouse = evt.getY();
	}

	private void headerMouseDragged(java.awt.event.MouseEvent evt) {
        int x = evt.getXOnScreen();
	    int y = evt.getYOnScreen();
	    this.setLocation(x - xMouse, y - yMouse);
	}
	
	private void limpiarTabla(DefaultTableModel tabla) {
		tabla.getDataVector().clear();
	}
	
	public void cargarTablaReservasIniciales() {
		List<Reserva> lista = consultarInformacion.todasLasReservas();
		mostrarInformacion.agregarReservas(modeloReservas, lista);
	}
	
	private void cargarTablaReservasFiltradas(List<Reserva> reservasFiltradas) {
		mostrarInformacion.agregarReservas(modeloReservas, reservasFiltradas);
	}
	
	private void cargarTablaHuespedesIniciales() {
		/*
		List<HuespedConReserva> lista =  consultarInformacion.todosLosHuespedes();
		mostrarInformacion.agregarHuespedes(modeloHuesped, lista);
		*/
		List<Huesped> lista =  consultarInformacion.todosLosHuespedes();
		mostrarInformacion.agregarHuespedes(modeloHuesped, lista);
	}
	
	private void configurarAccionesDelFormulario() {
		
		btnbuscar.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// If panel.getSelectedIndex() = 0 reservas is selected
				if(panel.getSelectedIndex()==0) {
					// Check if there is a value to search for
					String searchingTerm = txtBuscar.getText(); 
			        if(searchingTerm.trim().length() == 0 || searchingTerm == null) {
			            JOptionPane.showMessageDialog(null, "El valor de id buscado es requerido");
			            return;
			        }
			        //Check if it's a number
			        try {
						Integer.valueOf(searchingTerm);
					} catch (Exception e) {
			            JOptionPane.showMessageDialog(null, "El valor de busqueda es invalido. Ingrese un ID valido.");
			            return;
					}
			        //El termino a buscar en el caso de reservas es el numero de reserva
					List<Reserva> reservasFiltradas = consultarInformacion.buscarReserva(searchingTerm);
					if(reservasFiltradas.size() == 0) {
			            JOptionPane.showMessageDialog(null, "La busqueda no arrojo ningun resultado");
			            return;
					}
					limpiarTabla(modeloReservas);
					cargarTablaReservasFiltradas(reservasFiltradas);
				}
				// If panel.getSelectedIndex() = 1 huespedes is selected				
				if(panel.getSelectedIndex()==1) {
					// Check if there is a value to search for
					String searchingTerm = txtBuscar.getText(); 
			        if(searchingTerm.trim().length() == 0 || searchingTerm == null) {
			            JOptionPane.showMessageDialog(null, "El apellido del huesped buscado es requerido");
			            return;
			        }
			        // El termino a buscar en el caso de reservas es el numero de reserva
			        //List<HuespedConReserva> list = consultarInformacion.buscarHuesped(searchingTerm);
			        List<Huesped> list = consultarInformacion.buscarHuesped(searchingTerm);
			        if(list.size()==0) {
			        	JOptionPane.showMessageDialog(null, "La busqueda no arrojo ningun resultado, ingrese un apellido valido");
			            return;
			        }
			        limpiarTabla(modeloHuesped);
			        mostrarInformacion.agregarHuespedes(modeloHuesped, list);
				}
			}

		});
		
		btnEliminar.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// If panel.getSelectedIndex() = 0 reservas is selected
				if(panel.getSelectedIndex()==0) {
			        if (tieneFilaElegida(tbReservas)) {
			            JOptionPane.showMessageDialog(null, "Por favor, elija una reserva");
			            return;
			        }
			        
			        Optional.ofNullable(modeloReservas.getValueAt(tbReservas.getSelectedRow(), tbReservas.getSelectedColumn()))
		        	.ifPresentOrElse(fila -> {
		        		// int columnaSeleccionada = tbReservas.getSelectedColumn();
		        		int filaSeleccionada = tbReservas.getSelectedRow();

		        		Integer id  = (Integer) modeloReservas.getValueAt(filaSeleccionada, 0);

		                // Conseguir el objeto reseva con el id y eliminarlo a partir del dto
		         		eliminarInformacion.eliminarReserva(id);
		                JOptionPane.showMessageDialog(null, String.format("Item eliminado con éxito!"));
		                limpiarTabla(modeloReservas);
		                cargarTablaReservasIniciales();
		                
		            }, () -> JOptionPane.showMessageDialog(null, "Por favor, elije un item"));  
			        
				}
				// If panel.getSelectedIndex() = 1 huespedes is selected				
				if(panel.getSelectedIndex()==1) {
			        if (tieneFilaElegida(tbHuespedes)) {
			            JOptionPane.showMessageDialog(null, "Por favor, elija un huesped");
			            return;
			        }
			        
			        Optional.ofNullable(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), tbHuespedes.getSelectedColumn()))
		        	.ifPresentOrElse(fila -> {
		        		// int columnaSeleccionada = tbReservas.getSelectedColumn();
		        		int filaSeleccionada = tbHuespedes.getSelectedRow();

		        		Integer id  = (Integer) modeloHuesped.getValueAt(filaSeleccionada, 0);

		                // Conseguir el objeto reseva con el id y eliminarlo a partir del dto
		         		eliminarInformacion.eliminarHuesped(id);
		                JOptionPane.showMessageDialog(null, String.format("Item eliminado con éxito!"));
		                limpiarTabla(modeloHuesped);
		                cargarTablaHuespedesIniciales();
		                limpiarTabla(modeloReservas);
		                cargarTablaReservasIniciales();
		            }, () -> JOptionPane.showMessageDialog(null, "Por favor, elije un item"));  
				}
			}
		});
		
		btnEditar.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// If panel.getSelectedIndex() = 0 reservas is selected
				if(panel.getSelectedIndex()==0) {
					
					// Si no hay fila seleccionada sal de la funcion
	        		if(tbReservas.getSelectedRow() ==-1) {
	        			JOptionPane.showMessageDialog(null, "Por favor, elije un item");
	        			return;
	        		}
			        Optional.ofNullable(modeloReservas.getValueAt(tbReservas.getSelectedRow(), tbReservas.getSelectedColumn()))
		        	.ifPresentOrElse(fila -> {
		        		// int columnaSeleccionada = tbReservas.getSelectedColumn();
		        		int filaSeleccionada = tbReservas.getSelectedRow();

		        		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		        		
		        		Integer id  = (Integer) modeloReservas.getValueAt(filaSeleccionada, 0);;
		        		LocalDate fechaDeEntrada;
		        		LocalDate fechaDeSalida;
		        		BigDecimal valor;
		        		String formaDePago = (String) modeloReservas.getValueAt(filaSeleccionada, 4);
		        		Integer huesped;	
		        		
		        		// If a value is change by the user, the type of that column will be change to String automatically
		        		// That's why I use a double cast, the firstis there is nothing to change, and the second if the user 
		        		// change something to string
		        		try {
		        			fechaDeEntrada = (LocalDate) modeloReservas.getValueAt(filaSeleccionada, 1);
		        			System.out.println("1 fechaDeEntrada " +fechaDeEntrada);
						} catch (Exception e) {
							fechaDeEntrada = LocalDate.parse((String) modeloReservas.getValueAt(filaSeleccionada, 1), formatter);
							System.out.println("2 fechaDeEntrada " +fechaDeEntrada);
						}
		        		try {
		        			fechaDeSalida = (LocalDate) modeloReservas.getValueAt(filaSeleccionada, 2);
		        			System.out.println("1 fechaDeSalida " +fechaDeSalida);
						} catch (Exception e) {
							fechaDeSalida = LocalDate.parse((String) modeloReservas.getValueAt(filaSeleccionada, 2), formatter);
							System.out.println("2 fechaDeSalida " +fechaDeSalida);
						}
		        		try {
		        			valor = (BigDecimal) modeloReservas.getValueAt(filaSeleccionada, 3);
		        			System.out.println("1 valor " +valor);
						} catch (Exception e) {
							valor = new BigDecimal((String) modeloReservas.getValueAt(filaSeleccionada, 3));
							System.out.println("2 valor " +valor);
						}
		        		try {
							huesped = (Integer) modeloReservas.getValueAt(filaSeleccionada, 5);
							System.out.println("1 huesped " +huesped);
						} catch (Exception e) {
							huesped = Integer.parseInt((String) modeloReservas.getValueAt(filaSeleccionada, 5));
							System.out.println("2 huesped " +huesped);
						}
		        		
		        		ReservaDTO reservaModificada = new ReservaDTO(
		        			id,
		        			fechaDeEntrada,
		        			fechaDeSalida,
		        			valor,
		        			formaDePago,
		        			huesped
		        		);
		        		
		                // Conseguir el objeto reseva con el id y modificarlo a partir del dto
		         		modificarInformacion.modificarReserva(reservaModificada);
		                JOptionPane.showMessageDialog(null, String.format("Item modificado con éxito!"));
		                limpiarTabla(modeloReservas);
		                cargarTablaReservasIniciales();
		                
		            }, () -> JOptionPane.showMessageDialog(null, "Por favor, elije un item"));  
				}
				
				
				// If panel.getSelectedIndex() = 1 huespedes is selected				
				if(panel.getSelectedIndex()==1) {
					// Si no hay fila seleccionada sal de la funcion
	        		if(tbHuespedes.getSelectedRow() ==-1) {
	        			JOptionPane.showMessageDialog(null, "Por favor, elije un item");
	        			return;
	        		}
			        Optional.ofNullable(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), tbHuespedes.getSelectedColumn()))
		        	.ifPresentOrElse(fila -> {
		        		// int columnaSeleccionada = tbHuespedes.getSelectedColumn();
		        		int filaSeleccionada = tbHuespedes.getSelectedRow();

		        		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		        		
		        		Integer id = (Integer) modeloHuesped.getValueAt(filaSeleccionada, 0);
	        			String nombre = (String) modeloHuesped.getValueAt(filaSeleccionada, 1);
	        			String apellido = (String) modeloHuesped.getValueAt(filaSeleccionada, 2);
	        			LocalDate fechaDeNacimiento;
	        			String nacionalidad = (String) modeloHuesped.getValueAt(filaSeleccionada, 4);
	        			String telefono = (String) modeloHuesped.getValueAt(filaSeleccionada, 5);
	
		        		
		        		// If a value is change by the user, the type of that column will be change to String automatically
		        		// That's why I use a double cast, the firstis there is nothing to change, and the second if the user 
		        		// change something to string
	        			try {
	        				fechaDeNacimiento = (LocalDate) modeloHuesped.getValueAt(filaSeleccionada, 3);
	        				System.out.println("1 fechaDeNacimiento " + fechaDeNacimiento);
						} catch (Exception e) {
							fechaDeNacimiento = LocalDate.parse((String) modeloHuesped.getValueAt(filaSeleccionada, 3), formatter);
							System.out.println("2 fechaDeNacimiento " + fechaDeNacimiento);
						}
		        		
		        		HuespedDTO huespedModificado = new HuespedDTO(
		        			id,
		        			nombre,
		        			apellido,
		        			fechaDeNacimiento,
		        			nacionalidad,
		        			telefono
		        		);
		        		
		                // Conseguir el objeto huesped con el id y modificarlo a partir del dto
		         		modificarInformacion.modificarHuesped(huespedModificado);
		                JOptionPane.showMessageDialog(null, String.format("Item modificado con éxito!"));
		                limpiarTabla(modeloHuesped);
		                cargarTablaHuespedesIniciales();
		                
		            }, () -> JOptionPane.showMessageDialog(null, "Por favor, elije un item"));
				}
			}
		});
	}
	
    private boolean tieneFilaElegida(JTable tabla) {
        return tabla.getSelectedRowCount() == 0 || tabla.getSelectedColumnCount() == 0;
    }
    
}
