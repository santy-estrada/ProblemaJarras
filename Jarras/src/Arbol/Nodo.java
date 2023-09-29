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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer i = 10;
		Integer i2 = 12;
		
		Nodo<Integer> n1 = new Nodo<Integer>(i);
		Nodo<Integer> n2 = new Nodo<Integer>(i2);
		Nodo<Integer> n3 = new Nodo<Integer>(i2);
		Nodo<Integer> n4 = new Nodo<Integer>(i2);
		Nodo<Integer> n5 = new Nodo<Integer>(i2);
		Nodo<Integer> n6 = new Nodo<Integer>(i2);
		
		n2.setPadre(n1);
		n3.setPadre(n2);
		n3.setSiguienteHermano(n4);
		n5.setPadre(n4);
		n6.setPadre(n4);
		//n2.setPadre(n6);
		
		System.out.println(n1.getAltura());
		System.out.println(n5.getAltura());
	}
	
}
