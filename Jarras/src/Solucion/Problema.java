package Solucion;

public class Problema implements Comparable<Problema>{
	
	private Jarra jarra1;
	private Jarra jarra2;
	private int objetivo;
	
	public Problema(int VMax1, int VMax2, int objetivo){
		this.jarra1 = new Jarra(VMax1);
		this.jarra2 = new Jarra(VMax2);
		this.objetivo= objetivo;
	}
	
	public int getCant1() {
		int volumenActual1= jarra1.getVolumenActual();
		return volumenActual1;
	}
	
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

	@Override
	public String toString() {
		return "Problema [jarra1=" + jarra1 + ", jarra2=" + jarra2 + ", objetivo=" + objetivo + "]";
	}


	@Override
	public int compareTo(Problema p) {
		// TODO Auto-generated method stub
		if(jarra1.getVolumenActual() == p.getCant1() && jarra2.getVolumenActual() == p.getCant2()) {
			return 0;
		}
		return 1;
	}
	
	

}
