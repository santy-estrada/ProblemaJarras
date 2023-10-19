import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import java.awt.Font;
import java.awt.Color;
import java.util.ArrayList;

public class InterfazArbol {
	
	private JPanel panel;
	private JPanel panel2;
	private JPanel panel3;
	private JFrame ventana;
	
	public static void main(String[] args) {
		InterfazArbol interfaz = new InterfazArbol();
	}

	private InterfazArbol() {

		panel = new JPanel();
		
		panel2 = new JPanel();
		panel2.setBackground(Color.WHITE);
		panel2.setBounds(30,500,730,200);
		panel3 = new JPanel();
		panel3.setBackground(Color.WHITE);
		panel3.setBounds(30,730,730,200);
		
		ventana = new JFrame();
		ventana.setSize(800,1000);
		ventana.add(panel);
		
		panel.add(panel2);
		panel.add(panel3);
		panel.setLayout(null);

		JLabel titulo = new JLabel("ARBOL DE SOLUCIONES");
		titulo.setBounds(30,10,500,60);
		titulo.setFont(new Font("Serif", Font.BOLD, 30));
		panel.add(titulo);

		JTree arbol = CrearArbol();
		arbol.setBounds(30,70,730,400);
		panel.add(arbol);

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

                    Font letras = new Font("Serif", Font.BOLD, 20);

                    JLabel vJarra1 = new JLabel("Volumen Primera Jarra: " + pSeleccionado.getCant1());
                    vJarra1.setFont(letras);
                    vJarra1.setBounds(20,20,400,30);

                    JLabel vJarra2 = new JLabel("Volumen Segunda Jarra: " + pSeleccionado.getCant2());
                    vJarra2.setFont(letras);
                    vJarra2.setBounds(20,50,400,30);

                    JLabel alturaNodo = new JLabel("Altura Nodo: " + x.getAltura());
                    alturaNodo.setFont(new Font("Serif", Font.BOLD, 20));
                    alturaNodo.setBounds(20,20,400,30);

                    boolean tieneHijo = false;
                    boolean tieneHermano = false;
                    if (x.getPrimerHijo() != null) tieneHijo = true;
                    if (x.getSiguienteHermano() != null) tieneHermano = true;

                    JLabel NodoHijo = new JLabel("Tiene hijo: " + tieneHijo);
                    NodoHijo.setFont(new Font("Serif", Font.BOLD, 20));
                    NodoHijo.setBounds(20,50,400,30);

                    JLabel NodoHermano = new JLabel("Tiene Hermano: " + tieneHermano);
                    NodoHermano.setFont(new Font("Serif", Font.BOLD, 20));
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

		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public JTree CrearArbol() {

		//No he creado el objeto de solucion
		ArrayList<ArrayList><Nodo<Problema>>> nodes = Solucion.getRaiz(); //Aun no he escrito el metodo getRaiz() en solucion
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