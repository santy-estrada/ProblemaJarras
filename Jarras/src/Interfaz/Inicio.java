package Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import Arbol.ENodo;
import Solucion.ENumeroImposible;
import Solucion.Solucion;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inicio {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio window = new Inicio();
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
	public Inicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 574, 568);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Problema de las Jarras");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setEnabled(false);
		lblNewLabel.setBounds(22, 12, 306, 45);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setToolTipText("Volumen m\u00E1ximo de la jarra 1");
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(textField.getText().length() != 0 && textField_1.getText().length() != 0 && textField_2.getText().length() != 0) {
					btnNewButton.setEnabled(true);
				}else {
					btnNewButton.setEnabled(false);

				}
			}
		});
		textField.setBounds(45, 105, 131, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Jarra 1:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(45, 86, 92, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Jarra 2:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(316, 86, 92, 13);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Volumen m\u00E1ximo de la jarra 2");
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(textField.getText().length() != 0 && textField_1.getText().length() != 0 && textField_2.getText().length() != 0) {
					btnNewButton.setEnabled(true);
				}else {
					btnNewButton.setEnabled(false);

				}
			}
		});
		textField_1.setColumns(10);
		textField_1.setBounds(316, 105, 131, 19);
		frame.getContentPane().add(textField_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Objetivo:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(45, 167, 92, 19);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("Volumen deseado en una jarra");
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(textField.getText().length() != 0 && textField_1.getText().length() != 0 && textField_2.getText().length() != 0) {
					btnNewButton.setEnabled(true);
				}else {
					btnNewButton.setEnabled(false);

				}
			}
		});
		textField_2.setColumns(10);
		textField_2.setBounds(45, 192, 131, 19);
		frame.getContentPane().add(textField_2);
		
		btnNewButton = new JButton("SOLUCIONAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int j1 = Integer.parseInt(textField.getText());
					int j2 = Integer.parseInt(textField_1.getText());
					int o = Integer.parseInt(textField_2.getText());
					Solucion s = new Solucion(j1, j2, o);
					
					try {
						Principal window = new Principal(s);
						frame.dispose();	//Cerrar ventana
						window.frame.setVisible(true);
						
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}catch ( NumberFormatException ex ) {
					JOptionPane.showMessageDialog(null, "Debe ingresar un entero", "Error", JOptionPane.ERROR_MESSAGE);
			    } catch (ENodo e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				} catch (ENumeroImposible e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

				}
			
			}
		});
		
		btnNewButton.setEnabled(false);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(316, 154, 141, 51);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Inicio.class.getResource("/Interfaz/giphy.gif")));
		lblNewLabel_2.setBounds(135, 238, 294, 273);
		frame.getContentPane().add(lblNewLabel_2);
		
	}
}
