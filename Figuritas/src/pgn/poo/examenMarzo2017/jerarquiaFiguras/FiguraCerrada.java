package pgn.poo.examenMarzo2017.jerarquiaFiguras;

import pgn.poo.examenMarzo2017.estructuras.DimensionNoValidaException;

public abstract class FiguraCerrada{
	protected static int generateID = 0;
	private int identificador = 0;
	
	FiguraCerrada() throws DimensionNoValidaException{
		setIdentificador();
		incrementarIdentificador();
		
	}
	FiguraCerrada(int identificador){
		setIdentificador(identificador);
		
	}
	
	private void setIdentificador(int identificador) {
		this.identificador = identificador;
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + identificador;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		FiguraCerrada other = (FiguraCerrada) obj;
		if (identificador != other.identificador)
			return false;
		return true;
	}
	private void setIdentificador() {
		identificador = generateID;
		
	}

	private void incrementarIdentificador() {
		generateID += 1;
		
	}
	
	protected int getIdentificador(){
		return identificador;
	}
	
	abstract double calcularArea();
	abstract double calcularPerimetro();
	
	protected double dimensionValida(double dimension) throws DimensionNoValidaException{
		if(dimension<0.5)
			throw new DimensionNoValidaException("ERROR al crear el "+getClass().getSimpleName()+" "+dimension+" la dimensión ha de tener un mínimo de 0.5");
		return dimension;
	}
	protected double redondear(double numero){
		
		return Math.rint(numero*100)/100;
	}
	@Override
	public String toString() {
		return getClass().getSimpleName()+" [identificador="+ getIdentificador()+ ", area=" + calcularArea() + ", calcularPerimetro()=" + calcularPerimetro();
	}
	
	
}
