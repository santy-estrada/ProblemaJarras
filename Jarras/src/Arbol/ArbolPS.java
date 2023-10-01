package Arbol;

public class ArbolPS <E extends Comparable<E>>{

	private Nodo<E> raiz;
	
	public ArbolPS(Nodo<E> raiz) {
		this.raiz = raiz;
	}

	public Nodo<E> getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo<E> raiz) {
		this.raiz = raiz;
	}

	public Nodo<E> buscarNodo(E llave){
		return raiz;
		
	}
	
	private Nodo<E> buscarNodo(E llave, Nodo<E> n){
		Nodo<E> i = null;
		Nodo<E> d = null;
		
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
