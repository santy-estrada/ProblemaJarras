package Solucion;

public class Problema <E extends Comparable<E>>{
	
	private Jarra jarra1;
	private Jarra jarra2;
	private int objetivo;
	
	Problema(int VMax1, int VMax2, int objetivo){
		this.objetivo= objetivo;
	}
	
	public int getCant1() {
		int volumenActual1= getVolumenActual();
		return volumenActual1;
	}
	
	public int getCant2() {
		int volumenActual2= getVolumenActual();
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
	
	

}
