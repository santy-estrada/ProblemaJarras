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
	
	public void insertarNodo(Nodo<E> n, Nodo<E> padre) throws ENodo {
		if(n == null) {	//Insertar un nodo nulo
			throw new ENodo("No se puede insertar un nodo nulo");
		}
		if(padre == null && raiz != null) {
			if(raiz != null) { //insertar un nodo sin padre pero ya hay raiz
				throw new ENodo("No se puede insertar un nodo sin padre");
			}
		}
		
		if(padre.getPrimerHijo() == null) {	//Si el padre no tiene hijos, n es primer hijo
			padre.setPrimerHijo(n);
		}else {
			Nodo<E> aux = padre.getPrimerHijo();	//Primer hijo del padre
			while(aux.getSiguienteHermano() != null) {	//Mientras hayan hermanos
				if(aux.getLlave().compareTo(n.getLlave()) == 0) {
					throw new ENodo("El nodo ya está insertado");
				}
				aux = aux.getSiguienteHermano();	//aux es el último hermano encontrado
			}
			/*
			 * El ciclo de arriba para cuando aux no tiene siguiente hermano. En este caso,
			 * n se convierte en el siguiente hermano
			 */
			aux.setSiguienteHermano(n);
		}
		
	}

	public Nodo<E> buscarNodo(E llave) throws ENodo{
		Nodo<E> s = buscarNodo(llave, raiz);
		
		if(s == null) {
			throw new ENodo("El nodo no fue encontrado");
		}
		
		return s;
	}
	
	private Nodo<E> buscarNodo(E llave, Nodo<E> n) throws ENodo{
		Nodo<E> i = null;	//Primer hijo
		Nodo<E> d = null;	//Siguiente hermano
		
		if(llave.compareTo(n.getLlave()) == 0) {	//Cuando encuentra el nodo
			return n;
		}
		
		if(n.getPrimerHijo() != null) {	//Si tiene hijo, busca en los nodos que se desprenden de él
			i = buscarNodo(llave, n.getPrimerHijo());
		}
		
		if(n.getSiguienteHermano() != null) { 	//Si tiene hermano, busca en los nodos que se desprenden de él
			d = buscarNodo(llave, n.getSiguienteHermano());
		}
		
		if(i != null) {	//Si i no es nulo, i es el buscado
			return i;
		}else if(d != null) {
			return d;	//Si d no es nulo, d es el buscado
		}else {
			return null;	//Si no lo encuentra, retorne nulo
		}
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer i1 = 12;
		Integer i2 = 13;
		Integer i3 = 14;
		Integer i4 = 15;
		Integer i5 = 16;
		Integer i6 = 17;
		Integer i7 = 18;
		
		Nodo<Integer> n1 = new Nodo<Integer>(i1);
		Nodo<Integer> n2 = new Nodo<Integer>(i2);
		Nodo<Integer> n3 = new Nodo<Integer>(i3);
		Nodo<Integer> n4 = new Nodo<Integer>(i4);
		Nodo<Integer> n5 = new Nodo<Integer>(i5);
		Nodo<Integer> n6 = new Nodo<Integer>(i6);
		Nodo<Integer> n7 = new Nodo<Integer>(i7);
		
		ArbolPS a1 = new ArbolPS(n1);
		
		try {
			a1.insertarNodo(n2, n1);
			a1.insertarNodo(n3, n1);
			a1.insertarNodo(n4, n3);
			a1.insertarNodo(n5, n3);
			a1.insertarNodo(n6, n3);
			a1.insertarNodo(n7, n5);
			System.out.println(a1.buscarNodo(12).getAltura());
			
		} catch (ENodo e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
