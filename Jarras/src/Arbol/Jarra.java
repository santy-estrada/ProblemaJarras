public class Jarra {
	
	private int volumenActual;
	private int volumenTotal;

	public Jarra(int volumenTotal) {
		this.volumenTotal = volumenTotal;
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

	public boolean llenar() {
		boolean toReturn = false;
		if (volumenTotal > volumenActual) { 
			volumenActual = volumenTotal;
			toReturn = true;
		}
		return toReturn;

	}
	public boolean llenarParcial(int cantidad) {
		boolean toReturn = false;
		if ((volumenActual + cantidad) <= volumenTotal) {
			volumenActual = volumenActual + cantidad;
			toReturn = true;
		}
		return toReturn;
	}
	public boolean vaciarTotal() {
		boolean toReturn = false;
		if (volumenActual != 0) {
			volumenActual = 0;
			toReturn = true;
		}
		return toReturn;
	}
	public boolean vaciarParcial(int cantidad) {
		boolean toReturn = false;
		if ((volumenActual - cantidad) >= 0) {
			volumenActual = volumenActual - cantidad;
			toReturn = true;
		}
		return toReturn;
	}

}