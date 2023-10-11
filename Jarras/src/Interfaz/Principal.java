package Interfaz;

import java.awt.EventQueue;
import Solucion.ENumeroImposible;
import Solucion.Solucion;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Arbol.ENodo;

import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;

public class Principal {

    JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JButton btnNewButton;
    private Solucion s;
    private JScrollPane scrollPaneTextArea; // JScrollPane for textArea
    private JScrollPane scrollPaneTextArea1; // JScrollPane for textArea_1
    private JTextArea textArea;
    private JTextArea textArea_1;

    public Principal(Solucion s) {
        this.s = s;
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 806, 567);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(10, 10, 650, 507);
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

        JLabel lblMejorSolucin = new JLabel("Mejor Solución:");
        lblMejorSolucin.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblMejorSolucin.setBounds(10, 303, 185, 25);
        panel_1.add(lblMejorSolucin);

        // Create a JScrollPane for textArea
        scrollPaneTextArea = new JScrollPane();
        scrollPaneTextArea.setBounds(10, 46, 625, 238);
        panel_1.add(scrollPaneTextArea);
        textArea = new JTextArea();
        textArea.setEditable(false);
        scrollPaneTextArea.setViewportView(textArea);
        s.getSoluciones(textArea);

        // Create a JScrollPane for textArea_1
        scrollPaneTextArea1 = new JScrollPane();
        scrollPaneTextArea1.setBounds(10, 332, 625, 136);
        panel_1.add(scrollPaneTextArea1);
        textArea_1 = new JTextArea();
        textArea_1.setEditable(false);
        scrollPaneTextArea1.setViewportView(textArea_1);
        s.getMejorSolucion(textArea_1);

        JLabel lblNewLabel_1 = new JLabel("Jarra 1:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1.setBounds(684, 83, 45, 13);
        frame.getContentPane().add(lblNewLabel_1);

        textField = new JTextField();
        textField.setToolTipText("Nuevo volumen máximo de la jarra 1");
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
        textField.setBounds(684, 106, 96, 19);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("Jarra 2:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(684, 146, 45, 13);
		frame.getContentPane().add(lblNewLabel_1_1);
		
        textField_1 = new JTextField();
        textField_1.setToolTipText("Nuevo volumen máximo de la jarra 2");
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
        textField_1.setColumns(10);
        textField_1.setBounds(684, 170, 96, 19);
        frame.getContentPane().add(textField_1);

        JLabel lblNewLabel_1_1_1 = new JLabel("Objetivo:");
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1_1_1.setBounds(684, 217, 75, 13);
        frame.getContentPane().add(lblNewLabel_1_1_1);

        textField_2 = new JTextField();
        textField_2.setToolTipText("Nuevo volumen deseado en una jarra");
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
        textField_2.setColumns(10);
        textField_2.setBounds(684, 241, 96, 19);
        frame.getContentPane().add(textField_2);

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
                              Principal window = new Principal(s);
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
        btnNewButton.setBounds(684, 298, 96, 21);
        frame.getContentPane().add(btnNewButton);

        JLabel lblNewLabel_2 = new JLabel("Cambiar Datos:");
        lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 13));
        lblNewLabel_2.setBounds(670, 56, 120, 16);
        frame.getContentPane().add(lblNewLabel_2);
    }

}
