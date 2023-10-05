package Solucion;

import Arbol.ENodo;

public class MainPrueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Solucion s = new Solucion(3,4,2);
			s.printSoluciones();
		} catch (ENodo e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());;
		}
		
		
	}

}
