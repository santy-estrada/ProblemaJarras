package Solucion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import javax.swing.JTextArea;

import Arbol.ArbolPS;
import Arbol.ENodo;
import Arbol.Nodo;

public class Solucion {
	private ArbolPS<Problema> problema;
	private ArrayList<ArrayList<Nodo<Problema>>> soluciones;


	public Solucion(int contenidoJ1,int contenidoJ2,int  objetivo) throws ENodo, ENumeroImposible {
		 // Verifica las restricciones de los par�metros iniciales
		if(contenidoJ1 <= 0 || contenidoJ2 <= 0 || contenidoJ1 == contenidoJ2) {
			throw new ENumeroImposible();
		}
		
		if(objetivo > contenidoJ2 && objetivo > contenidoJ1) {
			throw new ENumeroImposible();
		}
		 // Crea un problema inicial y un nodo ra�z para el �rbol de b�squeda
		Problema problema= new Problema(contenidoJ1, contenidoJ2, objetivo);
		Nodo<Problema> nodo = new Nodo<Problema>(problema);
		this.problema = new ArbolPS<Problema>(nodo);
		this.soluciones = new ArrayList<ArrayList<Nodo<Problema>>>();
		// Inicia el proceso de b�squeda de soluciones
		solucionar(this.problema.getRaiz());
	}
	
	public void getSoluciones(JTextArea textArea) {
		  // Muestra las soluciones en un JTextArea
		for(int i = 0; i < soluciones.size(); i++) {
			ArrayList<Nodo<Problema>> s = soluciones.get(i);
			textArea.append("|�_�|");
			for(int j = 0; j < s.size(); j++) {
				textArea.append("     \n"+s.get(j).toString());
			}
			System.out.println();
		}
	}
	
	
	private void saveSolucion(Nodo<Problema> n) {
		 // Guarda una soluci�n encontrada en la lista de soluciones
	    ArrayList<Nodo<Problema>> solucion = new ArrayList<>();
	    Stack<Nodo<Problema>> ruta = new Stack<>(); // crea una pila
	    Nodo<Problema> nodo = n;
	    // Construye la ruta desde el nodo actual hasta la ra�z
	    while (nodo != null) {
	        ruta.push(nodo);
	        nodo = nodo.getPadre();
	    }
	    while (!ruta.isEmpty()) {
	        solucion.add(ruta.pop());
	    }
	    
	    this.soluciones.add(solucion);
	}
	
	private void solucionar(Nodo<Problema> n) throws ENodo {
		// Realiza la b�squeda recursiva de soluciones en el �rbol
		if(n.getLlave().solucionado()) {
			saveSolucion(n);
		}else {
			ArrayList<Nodo<Problema>> hijosValidos = siguientePaso(n);
			for(int i = 0; i < hijosValidos.size(); i++) {
				solucionar(hijosValidos.get(i));
			}
		}
	}
	
	private ArrayList<Nodo<Problema>> siguientePaso(Nodo<Problema> p) throws ENodo{
		 // Genera los posibles estados siguientes a partir del estado actual
		Nodo<Problema> aux = copiarNodo(p);
		ArrayList<Nodo<Problema>> hijos = new ArrayList<Nodo<Problema>>();
		ArrayList<Nodo<Problema>> hijosBuenos = new ArrayList<Nodo<Problema>>();
		  // Intenta realizar cada acci�n posible y agrega los nodos resultantes
		if(aux.getLlave().llenarJarra1()) {
			hijos.add(aux);
			aux = copiarNodo(p);
		}
		if(aux.getLlave().llenarJarra2()) {
			hijos.add(aux);
			aux = copiarNodo(p);
		}
		if(aux.getLlave().vaciarJarra1()) {
			hijos.add(aux);
			aux = copiarNodo(p);
		}
		if(aux.getLlave().vaciarJarra2()) {
			hijos.add(aux);
			aux = copiarNodo(p);
		}
		if(aux.getLlave().verter1en2()) {
			hijos.add(aux);
			aux = copiarNodo(p);
		}
		if(aux.getLlave().verter2en1()) {
			hijos.add(aux);
			aux = copiarNodo(p);
		}
		  // Filtra los nodos v�lidos y los agrega a la lista de hijos buenos
		for(int i = 0; i < hijos.size(); i++) {
			if(valido(hijos.get(i), p)) {
				problema.insertarNodo(hijos.get(i), p);
				hijosBuenos.add(hijos.get(i));
			}
		}
		
		return hijosBuenos;
	}
	
	private boolean valido (Nodo<Problema> n, Nodo<Problema>p) {
		 // Verifica si un nodo es v�lido compar�ndolo con nodos anteriores en la ruta	
		Nodo<Problema> padre = p;
		while(padre != null && n.getLlave().compareTo(padre.getLlave()) == 1) {
			p = (padre.getPadre() != null)? padre.getPadre().getPrimerHijo(): null;
			while(p != null && p.getLlave().compareTo(n.getLlave()) == 1) {
				p = p.getSiguienteHermano();
			}
			
			if(p != null) {
				return false;
			}
			
			padre = padre.getPadre();
		}
		
		return(padre == null)? true: false;
		
	}

	
	private Nodo<Problema> copiarNodo(Nodo<Problema> p){ // el metodo copia la informacion de un nodo en otro completamente nuevo
		Nodo<Problema> nuevo = new Nodo<Problema>(null, null, p, new Problema(p.getLlave().getJarra1().getVolumenTotal(), p.getLlave().getCant1(),
						p.getLlave().getJarra2().getVolumenTotal(),p.getLlave().getCant2(), p.getLlave().getObjetivo()));
		return nuevo;
	}
	
	private void cambiarJarra1(int v1) throws ENodo, ENumeroImposible {
		   // Cambia el volumen de la jarra 1 y reinicia la b�squeda
		int v2 = problema.getRaiz().getLlave().getMax2();
		int o = problema.getRaiz().getLlave().getObjetivo();
		int v1a = problema.getRaiz().getLlave().getMax1();
		
		if(v1a == v1) {
			throw new ENumeroImposible("El volumen de la jarra 1 es el actual");
		}
		
		if(v1 <= 0 || v1 == v2) {
			throw new ENumeroImposible();
		}
		
		Problema problema= new Problema(v1, v2, o);
		Nodo<Problema> nodo = new Nodo<Problema>(problema);
		this.problema = new ArbolPS<Problema>(nodo);
		this.soluciones = new ArrayList<ArrayList<Nodo<Problema>>>();
		solucionar(this.problema.getRaiz());
	}
	
	private void cambiarJarra2(int v2) throws ENodo, ENumeroImposible {
		   // Cambia el volumen de la jarra 2 y reinicia la b�squeda
		int v1 = problema.getRaiz().getLlave().getMax1();
		int o = problema.getRaiz().getLlave().getObjetivo();
		int v2a = problema.getRaiz().getLlave().getMax2();
		
		if(v2a == v2) {
			throw new ENumeroImposible("El volumen de la jarra 2 es el actual");
		}
		
		if(v2 <= 0 || v1 == v2) {
			throw new ENumeroImposible();
		}
		
		Problema problema= new Problema(v1, v2, o);
		Nodo<Problema> nodo = new Nodo<Problema>(problema);
		this.problema = new ArbolPS<Problema>(nodo);
		this.soluciones = new ArrayList<ArrayList<Nodo<Problema>>>();
		solucionar(this.problema.getRaiz());
	}
	
	private void cambiarObjetivo(int o) throws ENodo, ENumeroImposible {
		// Cambia el objetivo y reinicia la b�squeda
		int v1 = problema.getRaiz().getLlave().getMax1();
		int v2 = problema.getRaiz().getLlave().getMax2();
		int ov = problema.getRaiz().getLlave().getObjetivo();
		
		if(ov == o) {
			throw new ENumeroImposible("El objetivo es el actual");
		}
		
		if(o > v2 && o > v1) {
			throw new ENumeroImposible();
		}
		
		Problema problema= new Problema(v1, v2, o);
		Nodo<Problema> nodo = new Nodo<Problema>(problema);
		this.problema = new ArbolPS<Problema>(nodo);
		this.soluciones = new ArrayList<ArrayList<Nodo<Problema>>>();
		solucionar(this.problema.getRaiz());
	}
	
	public void cambiar(int j1, int j2, int o) throws ENodo, ENumeroImposible {
		  // Realiza cambios en las jarras y el objetivo seg�n los par�metros proporcionados
		
		if(j1 != 0) {
			cambiarJarra1(j1);
		}
		if(j2 != 0) {
			cambiarJarra2(j2);
		}
		if(o != 0) {
			cambiarObjetivo(0);
		}
	}
	
	public void getMejorSolucion(JTextArea textArea) {
		ArrayList<Nodo<Problema>> mejorSolucion = soluciones.get(0);
		for(int i=1;i<soluciones.size();i++) {
			if(mejorSolucion.size()>soluciones.get(i).size()) {
				mejorSolucion=soluciones.get(i);
			}
		}
		
		textArea.append("|�_�|");
		for(int i=0;i<mejorSolucion.size();i++) {
			textArea.append("     \n"+mejorSolucion.get(i).toString());
		}
		System.out.println();
		
	}
}
