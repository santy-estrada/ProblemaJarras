package Solucion;

import Arbol.ENodo;

public class MainPrueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Solucion s = new Solucion(4,2,3);
			s.getSoluciones();
		} catch (ENodo e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());;
		} catch (ENumeroImposible e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());;
		}
		
		
	}

}
