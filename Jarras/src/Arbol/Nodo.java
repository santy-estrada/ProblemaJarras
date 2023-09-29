package Arbol;

public class Nodo <E extends Comparable <E>>{

	private Nodo<E> primerHijo;
	private Nodo<E> siguienteHermano;
	private Nodo<E> padre;
	
	private E llave;
	
	public Nodo(Nodo<E> primerHijo, Nodo<E> siguienteHermano, Nodo<E> padre, E llave) {
		this.primerHijo = primerHijo;
		this.siguienteHermano = siguienteHermano;
		this.padre = padre;
		this.llave = llave;
	}

	public Nodo(E llave) {
		this.primerHijo = null;
		this.padre = null;
		this.siguienteHermano = null;
		this.llave = llave;
	}

	public Nodo<E> getPrimerHijo() {
		return primerHijo;
	}

	public void setPrimerHijo(Nodo<E> primerHijo) {
		this.primerHijo = primerHijo;
	}

	public Nodo<E> getSiguienteHermano() {
		return siguienteHermano;
	}

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
		return "Nodo [llave=" + llave + "]";
	}

	public int getAltura() {
		return getAltura(this);
	}
	
	private int getAltura(Nodo<E> h) {
		int a = 0;
		while(h.getPadre() != null) {
			a++;
			h = h.getPadre();
		}
	
		return a;
	}
	

}
