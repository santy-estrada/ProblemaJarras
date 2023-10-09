package Arbol;

public class Nodo <E extends Comparable <E>>{

	private Nodo<E> primerHijo;
	private Nodo<E> siguienteHermano;
	private Nodo<E> padre;
	
	private E llave;
	
	//Constructor con todo
	public Nodo(Nodo<E> primerHijo, Nodo<E> siguienteHermano, Nodo<E> padre, E llave) {
		this.primerHijo = primerHijo;
		this.siguienteHermano = siguienteHermano;
		this.padre = padre;
		this.llave = llave;
	}
	
	//Constructor con la llave
	public Nodo(E llave) {
		this.primerHijo = null;
		this.padre = null;
		this.siguienteHermano = null;
		this.llave = llave;
	}

	public Nodo<E> getPrimerHijo() {
		return primerHijo;
	}
	
	//Al darle un primer hijo, también se le debe informar al hijo quién es su padre
	public void setPrimerHijo(Nodo<E> primerHijo) {
		this.primerHijo = primerHijo;
		primerHijo.setPadre(this);
	}

	public Nodo<E> getSiguienteHermano() {
		return siguienteHermano;
	}

	//Al darle un siguiente hermano, también se debe decir que el padre será el mismo
	public void setSiguienteHermano(Nodo<E> siguienteHermano) {
		this.siguienteHermano = siguienteHermano;
		siguienteHermano.setPadre(padre);
	}

	public Nodo<E> getPadre() {
		return padre;
	}

	public void setPadre(Nodo<E> padre) {
		this.padre = padre;
	}

	public E getLlave() {
		return llave;
	}

	public void setLlave(E llave) {
		this.llave = llave;
	}

	@Override
	public String toString() {
		return  ""+llave;
	}

	public int getAltura() {
		return getAltura(this);
	}
	
	//Obtiene la altura contando los padres hasta llegar a la raiz (nodo sin padre)
	private int getAltura(Nodo<E> h) {
		int a = 0;
		while(h.getPadre() != null) {
			a++;
			h = h.getPadre();
		}
	
		return a;
	}
	
}
