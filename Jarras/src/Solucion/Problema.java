package Solucion;

public class Problema implements Comparable<Problema>{
	
	private Jarra jarra1;
	private Jarra jarra2;
	private int objetivo;
	private String accPrecedente;
	
	public Problema(int VMax1, int VMax2, int objetivo){
		this.jarra1 = new Jarra(VMax1);
		this.jarra2 = new Jarra(VMax2);
		this.objetivo= objetivo;
		this.accPrecedente = "Inicio";
	}
	public Problema(int VMax1, int act1, int VMax2, int act2, int objetivo, String accPrecedente){
		this.jarra1 = new Jarra(VMax1, act1);
		this.jarra2 = new Jarra(VMax2, act2);
		this.objetivo= objetivo;
		this.accPrecedente = accPrecedente;
	}
	
	//Obtiene el volumen actual de la jarra1
	public int getCant1() {
		int volumenActual1= jarra1.getVolumenActual();
		return volumenActual1;
	}
	
	//Obtiene el volumen actual de la jarra2
	public int getCant2() {
		int volumenActual2= jarra2.getVolumenActual();
		return volumenActual2;
	}

	public Jarra getJarra1() {
		return jarra1;
	}

	public void setJarra1(Jarra jarra1) {
		this.jarra1 = jarra1;
	}

	public Jarra getJarra2() {
		return jarra2;
	}

	public void setJarra2(Jarra jarra2) {
		this.jarra2 = jarra2;
	}

	public int getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(int objetivo) {
		this.objetivo = objetivo;
	}
	
	public String getAccPrecedente() {
		return accPrecedente;
	}
	
	public void setAccPrecedente(String a) {
		this.accPrecedente = a;
	}
	
	public boolean llenarJarra1() {
		accPrecedente = "Llenar Jarra 1";
		return jarra1.llenar();
	}
	
	public boolean llenarJarra2() {
		accPrecedente = "Llenar Jarra 2";

		return jarra2.llenar();
	}
	
	public boolean vaciarJarra1() {
		accPrecedente = "Vaciar Jarra 1";

		return jarra1.vaciarTotal();
	}
	
	public boolean vaciarJarra2() {
		accPrecedente = "Vaciar Jarra 2";

		return jarra2.vaciarTotal();
	}
	
	public boolean verter1en2() {
		//Toma cantidad máxima que se puede verter de 1 a 2
		int cant1 = jarra1.getVolumenActual();
		if(cant1 == 0) {
			return false;
		}
		int cant2 = jarra2.getVolumenActual();
		int max = jarra2.getVolumenTotal();
		int vert = 0;
		
		while((cant1 != 0) && (cant2 < max)) {
			cant1--;
			cant2++;
			vert++;
		}
		
		accPrecedente = "Verter " + vert + "lt de Jarra 1 a Jarra 2";

		return (jarra1.vaciarParcial(vert) && jarra2.llenarParcial(vert));
	}
	
	public boolean verter2en1() {
		//Toma cantidad máxima que se puede verter de 2 a 1

		int cant1 = jarra1.getVolumenActual();
		int cant2 = jarra2.getVolumenActual();
		if(cant2 == 0) {
			return false;
		}
		int max = jarra1.getVolumenTotal();
		int vert = 0;
		
		while((cant2 != 0) && (cant1 < max)) {
			cant1++;
			cant2--;
			vert++;
		}
		
		accPrecedente = "Verter " + vert + "lt de Jarra 2 a Jarra 1";

		return (jarra2.vaciarParcial(vert) && jarra1.llenarParcial(vert));
	}
	
	public boolean solucionado() {
		if(jarra1.getVolumenActual() == objetivo || jarra2.getVolumenActual() == objetivo) {
			return true;
		}
		return false;
	}

	public int getMax1() {
		return jarra1.getVolumenTotal();
	}
	
	public int getMax2() {
		return jarra2.getVolumenTotal();
	}
	@Override
	public String toString() {
		return accPrecedente + " (J1: " + jarra1 + "; J2: " + jarra2 + "; Obj: " + objetivo+")\n" ;
	}

	//Dos problemas son iguales si sus jarras y su objetivo son iguales
	@Override
	public int compareTo(Problema p) {
		// TODO Auto-generated method stub
		if(jarra1.compareTo(p.getJarra1()) == 0 && jarra2.compareTo(p.getJarra2()) == 0 && objetivo == p.getObjetivo()) {
			return 0; ///Si son iguales
		}
		return 1;//Si son diferentes
	}
	
	

}
