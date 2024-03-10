import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.DefaultListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;



public class Main_AdminTareas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textAsunto;
	DefaultListModel modelo = new DefaultListModel(); //Declarar el ListModel
	//Declaración de variables_Vianey
	private final ButtonGroup buttonGroup = new ButtonGroup();//Agrupar los botones de opciones
	DefaultListModel modelo2 = new DefaultListModel();//Almacena la importancia de la tarea (regular o muy importante)

	//Instanciando el constructor
	Tareas tarea = new Tareas();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_AdminTareas frame = new Main_AdminTareas();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main_AdminTareas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 859, 616);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("[Aquí irá el titúlo de la app junto con su decoración tipo banner]");
		lblNewLabel.setIcon(new ImageIcon("Banner/Banner.png"));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(0, 0, 845, 82);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Agregar Pendiente Nuevo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(88, 87, 224, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Asunto:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(22, 141, 87, 26);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Categoría:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(22, 192, 87, 26);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Importancia:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1.setBounds(22, 242, 101, 26);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Descripción:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1.setBounds(22, 296, 101, 26);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		textAsunto = new JTextField();
		textAsunto.setBounds(129, 146, 230, 20);
		contentPane.add(textAsunto);
		textAsunto.setColumns(10);
		
		JComboBox comboCategoria = new JComboBox();
		comboCategoria.setModel(new DefaultComboBoxModel(new String[] {"Trabajo", "Escuela", "Hogar", "Personal"}));
		comboCategoria.setBounds(129, 196, 230, 22);
		contentPane.add(comboCategoria);
		
		JRadioButton rdbtnRegular = new JRadioButton("Regular");
		buttonGroup.add(rdbtnRegular);
		rdbtnRegular.setBounds(135, 246, 111, 23);
		contentPane.add(rdbtnRegular);
		
		JRadioButton rdbtnImportante = new JRadioButton("Muy Importante");
		buttonGroup.add(rdbtnImportante);
		rdbtnImportante.setBounds(263, 246, 122, 23);
		contentPane.add(rdbtnImportante);
		
		JTextArea textDescripcion = new JTextArea();
		textDescripcion.setLineWrap(true);
		textDescripcion.setBounds(135, 300, 224, 93);
		contentPane.add(textDescripcion);
		
		JList listPendientes = new JList();
		listPendientes.setBounds(434, 141, 187, 252);
		contentPane.add(listPendientes);
		
		JList listImportancia = new JList();
		listImportancia.setBounds(615, 141, 187, 252);
		contentPane.add(listImportancia);
		
		JButton btnAgregar = new JButton("Agregar Pendiente");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//LLamado del método en el botón agregar - Yael
				//Primero se recaban los datos
				String importancia;
				String asunto = textAsunto.getText();
				String categoria = comboCategoria.getSelectedItem().toString();
				if(rdbtnRegular.isSelected()) {
					importancia = rdbtnRegular.getText();
				} else {
					importancia = rdbtnImportante.getText();
				}
				String descripcion = textDescripcion.getText();
				//Segundo se crea un nuevo objeto del tipo Tareas para pasarle al método agregar
				Tareas tareaNueva = new Tareas(asunto, categoria, importancia, descripcion);
				//Se llama al método y se pasa el objeto creado con los atributos.
				tarea.Agregar(tareaNueva);
				//Se informa al usuario que se ha agregado
				JOptionPane.showMessageDialog(null, "¡Pendiente agregado con éxito!");
				//Se limpian los campos para agregar una tarea nueva
				textAsunto.setText("");
				textDescripcion.setText("");
				//Como se agregan uno por uno siempre se toma el peek para reflejar el asunto y la
				//importancia
				modelo.addElement(tarea.tarea.peek().getAsunto());
				modelo2.addElement(tarea.tarea.peek().getImportancia());
				//Se pasa a los list los modelos ya rellenados.
				listPendientes.setModel(modelo);
				listImportancia.setModel(modelo2);
				
			}
		});
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAgregar.setBounds(129, 443, 179, 43);
		contentPane.add(btnAgregar);
		
		JButton btnFiltar = new JButton("Filtrar Pendientes");
		btnFiltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String seleccionar = JOptionPane.showInputDialog("Filtrar por importancia: "//Solicitar al usuario que seleccione una condición
						+ ""+"/n- Regular"+"/n -Muy importante");
				modelo.removeAllElements(); //Limpiar los ListModels
				modelo2.removeAllElements(); //Limpiar los ListModels
				Stack <Tareas> filtrado = tarea.filtrar(seleccionar); //Filtrar las tareas según el criterio
				for(Tareas filtro : filtrado) {
					//Agregar las tareas a los ListModels
					modelo.addElement(filtro.getAsunto());
					modelo2.addElement(filtro.getImportancia());
				}
				listPendientes.setModel(modelo); //Actualizar el List para mostrar los elementos
				listImportancia.setModel(modelo2);
				
			}
		});
		btnFiltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnFiltar.setBounds(434, 414, 179, 43);
		contentPane.add(btnFiltar);
		
		//Botón mostrar pendiente_Vianey
		/*Al seleccionar una tarea(asunto) del jlist y presionar el botón mostrar pendiente
		  este nos arroja el nombre del asunto, su descripción y su categoría*/
		 
		JButton btnMostrar = new JButton("Mostrar Pendiente");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tareas buscado = tarea.buscar(listPendientes.getSelectedValue().toString());/*obtiene el valor seleccionado de la lista pendientes y la utiliza 
				para buscar la tarea con ayuda del método buscar*/
				if(buscado != null) {//comprueba si se encontró la tarea que se seleccionó
					
					JOptionPane.showMessageDialog(null, "Asunto: " + buscado.getAsunto() + "\nDescripción del asunto: " + buscado.getDescripcion()+ 
							"\nCategoria: " + buscado.getCategoria());
				} else {
					JOptionPane.showMessageDialog(null, "El pendiente que intentas buscar no existe");
				}	
			}
		});
		
		btnMostrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMostrar.setBounds(623, 414, 179, 43);
		contentPane.add(btnMostrar);
		
		JLabel lblNewLabel_1_2 = new JLabel("Pendientes");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(563, 87, 111, 26);
		contentPane.add(lblNewLabel_1_2);
		
		/*Marca como "hecha" una tarea y 
		 actualiza el jlist con las tareas que no fueron eliminadas*/
		JButton btnHecho = new JButton("Pendiente Listo");
		btnHecho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String TareaQuitar = listPendientes.getSelectedValue().toString();//obtiene el valor seleccionado de la lista y lo almacena en la variable TareaQuitar, la cual representa a que la tarea ya se realizó
				modelo.removeAllElements();//Elimina del jlist el asunto que se seleccionó
				modelo2.removeAllElements();//Elimina la importancia del asunto seleccionado del jlist
				Stack <Tareas> actualizados = tarea.hecho(TareaQuitar);//llama al método hecho desde la instancia de Tareas pasando lo seleccionado como argumento
				for(Tareas actualizado : actualizados) {//recorre la lista ya actualizada (una vez que ya se eliminó la tarea seleccionada)
					modelo.addElement(actualizado.getAsunto());
					modelo2.addElement(actualizado.getImportancia());
				}
				//muestra las actualizaciones en el jlist
				listPendientes.setModel(modelo);
				listImportancia.setModel(modelo2);
				
			}
		});
		btnHecho.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnHecho.setBounds(530, 475, 179, 43);
		contentPane.add(btnHecho);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Asunto");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2_1.setBounds(489, 119, 111, 26);
		contentPane.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Importancia");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2_1_1.setBounds(654, 119, 111, 26);
		contentPane.add(lblNewLabel_1_2_1_1);
	}
}
