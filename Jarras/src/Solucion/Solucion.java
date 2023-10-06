package Solucion;

import java.util.ArrayList;
import java.util.Stack;

import Arbol.ArbolPS;
import Arbol.ENodo;
import Arbol.Nodo;

public class Solucion {
	private ArbolPS<Problema> problema;
	private ArrayList<ArrayList<Nodo<Problema>>> soluciones;


	public Solucion(int contenidoJ1,int contenidoJ2,int  objetivo) throws ENodo {
		Problema problema= new Problema(contenidoJ1, contenidoJ2, objetivo);
		Nodo<Problema> nodo = new Nodo<Problema>(problema);
		this.problema = new ArbolPS<Problema>(nodo);
		solucionar(this.problema.getRaiz());
	}
	
	public void printSoluciones() {
		for(int i = 0; i < soluciones.size(); i++) {
			ArrayList<Nodo<Problema>> s = soluciones.get(i);
			for(int j = 0; j < s.size(); j++) {
				System.out.println(s.get(j));
			}
			System.out.println();
		}
	}
	
	
	private void saveSolucion(Nodo<Problema> n) {
	    ArrayList<Nodo<Problema>> solucion = new ArrayList<>();
	    Stack<Nodo<Problema>> ruta = new Stack<>(); // crea una pila
	    Nodo<Problema> nodo = n;

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
		Nodo<Problema> aux = copiarNodo(p);
		ArrayList<Nodo<Problema>> hijos = new ArrayList<Nodo<Problema>>();
		ArrayList<Nodo<Problema>> hijosBuenos = new ArrayList<Nodo<Problema>>();
		
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
		
		for(int i = 0; i < hijos.size(); i++) {
			if(valido(hijos.get(i), p)) {
				problema.insertarNodo(hijos.get(i), p);
				hijosBuenos.add(hijos.get(i));
			}
		}
		
		return hijosBuenos;
	}
	
	private boolean valido (Nodo<Problema> n, Nodo<Problema>p) {
		Nodo<Problema> padre = p;
		while(padre != null && n.getLlave().compareTo(padre.getLlave()) == 1) {
			p = (padre.getPadre() != null)? padre.getPadre().getPrimerHijo(): null;
			while(p != null && p.getSiguienteHermano().getLlave().compareTo(n.getLlave()) == 1) {
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
		Nodo<Problema> nuevo = new Nodo<Problema>(p.getPrimerHijo(), p.getSiguienteHermano(),
				p.getPadre(), new Problema(p.getLlave().getJarra1().getVolumenTotal(), p.getLlave().getCant1(),
						p.getLlave().getJarra2().getVolumenTotal(),p.getLlave().getCant2(), p.getLlave().getObjetivo()));
		return nuevo;
	}
	
	
}
