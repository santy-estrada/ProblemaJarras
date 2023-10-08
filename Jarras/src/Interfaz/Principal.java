package Interfaz;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JTree;

import Solucion.Solucion;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextPane;

import java.util.ArrayList;

public class Principal {

	JFrame frame;
	private JTextArea textArea;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnNewButton;
	private Solucion s;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
		mostrarTodasLasSoluciones();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 611, 567);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 447, 485);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Árbol", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Soluciones", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Soluciones:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 10, 122, 25);
		panel_1.add(lblNewLabel);
		
		JLabel lblMejorSolucin = new JLabel("Mejor Soluci\u00F3n:");
		lblMejorSolucin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMejorSolucin.setBounds(10, 303, 185, 25);
		panel_1.add(lblMejorSolucin);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 45, 422, 238);
		panel_1.add(textArea);
		
		// Dentro de la clase Principal

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(10, 332, 422, 116);
		panel_1.add(textArea_1);
		
		JLabel lblNewLabel_1 = new JLabel("Jarra 1:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(467, 81, 45, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(textField.getText().length() != 0 || textField_1.getText().length() != 0 || textField_2.getText().length() != 0) {
					btnNewButton.setEnabled(true);
				}else {
					btnNewButton.setEnabled(false);

				}
			}
		});
		textField.setBounds(467, 104, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Jarra 2:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(467, 147, 45, 13);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(textField.getText().length() != 0 || textField_1.getText().length() != 0 || textField_2.getText().length() != 0) {
					btnNewButton.setEnabled(true);
				}else {
					btnNewButton.setEnabled(false);

				}
			}
		});
		textField_1.setColumns(10);
		textField_1.setBounds(467, 170, 96, 19);
		frame.getContentPane().add(textField_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Objetivo:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(467, 216, 75, 13);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(textField.getText().length() != 0 || textField_1.getText().length() != 0 || textField_2.getText().length() != 0) {
					btnNewButton.setEnabled(true);
				}else {
					btnNewButton.setEnabled(false);

				}
			}
		});
		textField_2.setColumns(10);
		textField_2.setBounds(467, 239, 96, 19);
		frame.getContentPane().add(textField_2);
		
		btnNewButton = new JButton("CAMBIAR");
		btnNewButton.setEnabled(false);
		btnNewButton.setBounds(467, 298, 96, 21);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Cambiar Datos:");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_2.setBounds(467, 45, 120, 16);
		frame.getContentPane().add(lblNewLabel_2);
	}
	
	// Dentro de la clase Principal

	public void mostrarTodasLasSoluciones() {
	    ArrayList<String> solucionesTexto = s.obtenerTodasLasSoluciones(); // Llama al método de Solucion
	    StringBuilder solucionesConcatenadas = new StringBuilder();
	    
	    for (String solucion : solucionesTexto) {
	        solucionesConcatenadas.append(solucion).append("\n"); // Concatena todas las soluciones
	    }
	    
	    // Ahora, muestra las soluciones en el TextArea
	    textArea.setText(solucionesConcatenadas.toString());
	}



}
