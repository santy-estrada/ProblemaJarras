package Solucion;

public class Jarra implements Comparable<Jarra>{
	
	private int volumenActual;
	private int volumenTotal;

	public Jarra(int volumenTotal) {
		this.volumenTotal = volumenTotal;
	}
	
	public Jarra(int volumenTotal, int volumenActual) {
		this.volumenTotal = volumenTotal;
		this.volumenActual = volumenActual;
	}

	public void setVolumenActual(int volumenActual) {
		this.volumenActual = volumenActual;
	}

	public int getVolumenActual() {
		return volumenActual;
	}
	
	public int getVolumenTotal() {
		return volumenTotal;
	}

	//Llena la jarra si el volumenTotal es mayor al actual
	public boolean llenar() {
		boolean toReturn = false;
		if (volumenTotal > volumenActual) { 
			volumenActual = volumenTotal;
			toReturn = true;
		}
		
		return toReturn;
	}
	
	//Llena parcialmente la jarra si la cantidad a verter más la cantidad actual no sobrepasan el máximo
	public boolean llenarParcial(int cantidad) {
		if(cantidad == 0) {
			return false;
		}
		boolean toReturn = false;
		if ((volumenActual + cantidad) <= volumenTotal) {
			volumenActual = volumenActual + cantidad;
			toReturn = true;
		}
		
		return toReturn;
	}
	
	@Override
	public String toString() {
		return " [volumenActual=" + volumenActual + ", volumenTotal=" + volumenTotal + "]";
	}

	//Vacea totalmente la jarra si tiene algo de volumenActual
	public boolean vaciarTotal() {
		boolean toReturn = false;
		if (volumenActual != 0) {
			volumenActual = 0;
			toReturn = true;
		}
		
		return toReturn;
	}
	
	//Vacea parcialmente la jarra si, al restarle la cantidad, el volumen restante es mayor o igual a 0
	public boolean vaciarParcial(int cantidad) {
		if(cantidad == 0) {
			return false;
		}
		boolean toReturn = false;
		if ((volumenActual - cantidad) >= 0) {
			volumenActual = volumenActual - cantidad;
			toReturn = true;
		}
		
		return toReturn;
	}

	//Dos jarras son iguales si sus volúmenes actuales y totales lo son
	@Override
	public int compareTo(Jarra j) {
		// TODO Auto-generated method stub
		if(j.getVolumenActual() == volumenActual && j.getVolumenTotal() == volumenTotal) {
			return 0;
		}
		return 1;
	}



}
