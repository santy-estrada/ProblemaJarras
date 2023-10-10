package Solucion;

public class ENumeroImposible extends Exception {
	 public  ENumeroImposible() {
	        super("La cantidad indicada es imposible");
	    }

	 public ENumeroImposible(String mensaje) {
	        super(mensaje);
	    }
}
