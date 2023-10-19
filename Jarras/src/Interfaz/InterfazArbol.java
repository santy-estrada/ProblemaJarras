package Interfaz;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

import Arbol.ENodo;
import Arbol.Nodo;
import Solucion.ENumeroImposible;
import Solucion.Problema;
import Solucion.Solucion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import java.awt.Font;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InterfazArbol {
	
	private JPanel panel;
	private JPanel panel2;
	private JPanel panel3;
	JFrame frame;
	private Solucion s;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnNewButton;
	private JButton btnArbol;

	InterfazArbol(Solucion s) {

		this.s = s;
        panel = new JPanel();
        
        panel2 = new JPanel();
        panel2.setBackground(Color.WHITE);
        panel2.setBounds(30, 500, 730, 200);
        panel3 = new JPanel();
        panel3.setBackground(Color.WHITE);
        panel3.setBounds(30, 730, 730, 70);
        frame = new JFrame();
        frame.setSize(1061, 882);
        frame.getContentPane().add(panel);
        panel.add(panel2);
        panel.add(panel3);
        JScrollPane scrollPane = new JScrollPane(panel);  // Wrap the entire panel in a JScrollPane
        frame.getContentPane().add(scrollPane);  // Add the JScrollPane to the frame
        panel.setLayout(null);
		
		frame = new JFrame();
		frame.setSize(1061,882);
		frame.getContentPane().add(panel);
		
		panel.add(panel2);
		panel.add(panel3);
		panel.setLayout(null);

		JLabel titulo = new JLabel("ÁRBOL DE SOLUCIONES");
		titulo.setBounds(30,10,500,60);
		titulo.setFont(new Font("Serif", Font.BOLD, 30));
		panel.add(titulo);

		JTree arbol = CrearArbol();
		arbol.setBounds(30,70,730,400);
		panel.add(arbol);
		
		JLabel lblNewLabel_2 = new JLabel("Cambiar Datos:");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_2.setBounds(786, 85, 214, 39);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Jarra 1:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(800, 144, 45, 13);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (textField.getText().length() != 0 || textField_1.getText().length() != 0 || textField_2.getText().length() != 0) {
                    btnNewButton.setEnabled(true);
                } else {
                    btnNewButton.setEnabled(false);
                }
			}
		});
		textField.setToolTipText("Nuevo volumen m\u00E1ximo de la jarra 1");
		textField.setColumns(10);
		textField.setBounds(800, 167, 96, 19);
		panel.add(textField);
		
		JLabel lblNewLabel_1_1 = new JLabel("Jarra 2:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(800, 207, 45, 13);
		panel.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (textField.getText().length() != 0 || textField_1.getText().length() != 0 || textField_2.getText().length() != 0) {
                    btnNewButton.setEnabled(true);
                } else {
                    btnNewButton.setEnabled(false);
                }
			}
		});
		textField_1.setToolTipText("Nuevo volumen m\u00E1ximo de la jarra 2");
		textField_1.setColumns(10);
		textField_1.setBounds(800, 231, 96, 19);
		panel.add(textField_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Objetivo:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(800, 278, 75, 13);
		panel.add(lblNewLabel_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (textField.getText().length() != 0 || textField_1.getText().length() != 0 || textField_2.getText().length() != 0) {
                    btnNewButton.setEnabled(true);
                } else {
                    btnNewButton.setEnabled(false);
                }
			}
		});
		textField_2.setToolTipText("Nuevo volumen deseado en una jarra");
		textField_2.setColumns(10);
		textField_2.setBounds(800, 302, 96, 19);
		panel.add(textField_2);
		
		btnNewButton = new JButton("CAMBIAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                try {
                    int j1 = (textField.getText().length() != 0) ? Integer.parseInt(textField.getText()) : 0;
                    int j2 = (textField_1.getText().length() != 0) ? Integer.parseInt(textField_1.getText()) : 0;
                    int o = (textField_2.getText().length() != 0) ? Integer.parseInt(textField_2.getText()) : 0;
                    
                    if(j1 != 0 || j2 != 0 || o != 0) {
                    	  s.cambiar(j1, j2, o);
                          
                          try {
                              InterfazArbol window = new InterfazArbol(s);
                              frame.dispose(); // Cerrar ventana
                              window.frame.setVisible(true);

                          } catch (Exception e2) {
                              e2.printStackTrace();
                          }
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un entero", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (ENodo e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (ENumeroImposible e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
		btnNewButton.setEnabled(false);
		btnNewButton.setBounds(800, 359, 96, 21);
		panel.add(btnNewButton);
		
		btnArbol = new JButton("LISTA");
		btnArbol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
       		 try {
                    Principal window = new Principal(s);
                    frame.dispose(); // Cerrar ventana
                    window.frame.setVisible(true);

                } catch (Exception e2) {
                    e2.printStackTrace();
                }
       	}
       });
		btnArbol.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnArbol.setBounds(818, 726, 153, 60);
		panel.add(btnArbol);

		arbol.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent e) {
            	panel2.repaint();
            	panel3.repaint();
            	panel2.setLayout(null);
            	panel3.setLayout(null);
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) arbol.getLastSelectedPathComponent();
                if (selectedNode != null) {
                    
                    Object selectedObject = selectedNode.getUserObject();
                    Nodo<Problema> x = (Nodo<Problema>) selectedNode.getUserObject();
                    System.out.println(x);
                    panel2.removeAll();
                    panel3.removeAll();

                    Problema pSeleccionado = x.getLlave();

                    Font letras = new Font("Serif", Font.BOLD, 15);

                    JLabel vJarra1 = new JLabel("Volumen Primera Jarra: " + pSeleccionado.getCant1());
                    vJarra1.setFont(letras);
                    vJarra1.setBounds(20,20,400,30);

                    JLabel vJarra2 = new JLabel("Volumen Segunda Jarra: " + pSeleccionado.getCant2());
                    vJarra2.setFont(letras);
                    vJarra2.setBounds(20,50,400,30);

                    JLabel alturaNodo = new JLabel("Altura Nodo: " + x.getAltura());
                    alturaNodo.setFont(new Font("Serif", Font.BOLD, 15));
                    alturaNodo.setBounds(20,20,400,30);

                    boolean tieneHijo = false;
                    boolean tieneHermano = false;
                    if (x.getPrimerHijo() != null) tieneHijo = true;
                    if (x.getSiguienteHermano() != null) tieneHermano = true;

                    JLabel NodoHijo = new JLabel("Tiene hijo: " + tieneHijo);
                    NodoHijo.setFont(new Font("Serif", Font.BOLD, 15));
                    NodoHijo.setBounds(20,50,400,30);

                    JLabel NodoHermano = new JLabel("Tiene Hermano: " + tieneHermano);
                    NodoHermano.setFont(new Font("Serif", Font.BOLD, 15));
                    NodoHermano.setBounds(20,80,400,30);


                    if (x.getPadre() != null) {
	                    Nodo<Problema> nodoAnterior = x.getPadre();
	                    Problema pAnterior = nodoAnterior.getLlave();

	                    JLabel vAnteriorJarra1 = new JLabel("Volumen Anterior Primera Jarra: " + pAnterior.getCant1());
	                    vAnteriorJarra1.setFont(letras);
	                    vAnteriorJarra1.setBounds(300,20,400,30);

	                    JLabel vAnteriorJarra2 = new JLabel("Volumen Anterior Segunda Jarra: " + pAnterior.getCant2());
	                    vAnteriorJarra2.setFont(letras);
	                    vAnteriorJarra2.setBounds(300,50,400,30);

	                    panel2.add(vAnteriorJarra1);
	                    panel2.add(vAnteriorJarra2);
                	}
                    
                    panel2.add(vJarra1);
                    panel2.add(vJarra2);
                    panel3.add(alturaNodo);
                    panel3.add(NodoHijo);
                    panel3.add(NodoHermano);

                }
            }
        });

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public JTree CrearArbol() {

		//No he creado el objeto de solucion
		Nodo<Problema> raiz = s.getProblema().getRaiz() ; //Aun no he escrito el metodo getRaiz() en solucion
		DefaultMutableTreeNode jRaiz = new DefaultMutableTreeNode(raiz);

		return new JTree(crearSubArbol(raiz,jRaiz));

	}

	//Metodo que crea subarboles inferiores recursivamente
	public DefaultMutableTreeNode crearSubArbol(Nodo<Problema> raiz,DefaultMutableTreeNode jRaiz) {
		
		Nodo<Problema> primerHijo = raiz.getPrimerHijo();
		Nodo<Problema> segundoHijo = primerHijo.getSiguienteHermano();

		DefaultMutableTreeNode jPrimerHijo = new DefaultMutableTreeNode(primerHijo);
		if (primerHijo.getPrimerHijo() != null) jPrimerHijo = crearSubArbol(primerHijo, jPrimerHijo);
		jRaiz.add(jPrimerHijo);

		if (segundoHijo != null) {
			DefaultMutableTreeNode jSegundoHijo = new DefaultMutableTreeNode(segundoHijo);
			if (segundoHijo.getPrimerHijo() != null) jSegundoHijo = crearSubArbol(segundoHijo,jSegundoHijo);
			jRaiz.add(jSegundoHijo);
		}

		return jRaiz;

	}
}