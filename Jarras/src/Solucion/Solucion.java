package Solucion;

import Arbol.ArbolPS;
import Arbol.Nodo;

public class Solucion {
	private ArbolPS<Problema> problema;


	public void solucion(int contenidoJ1,int contenidoJ2,int  objetivo) {
		Problema problema= new Problema(contenidoJ1, contenidoJ2, objetivo);
		Nodo<Problema> nodo = new Nodo<Problema>(problema);
		this.problema = new ArbolPS<Problema>(nodo);
	}
	
	public void getSoluciones() { //se tiene que cambiar el void por un array
		solucionar(problema.getRaiz());
	}
	
	private void solucionar(Nodo<Problema> raiz) {
		if(raiz.getLlave().getJarra1().getVolumenActual() == raiz.getLlave().getObjetivo() || raiz.getLlave().getJarra2().getVolumenActual() == raiz.getLlave().getObjetivo()) {
			
		}
	}
}
