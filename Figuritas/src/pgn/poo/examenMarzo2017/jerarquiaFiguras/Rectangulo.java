package pgn.poo.examenMarzo2017.jerarquiaFiguras;

import pgn.poo.examenMarzo2017.estructuras.DimensionNoValidaException;

public class Rectangulo extends FiguraCerrada {
	private double base;
	private double altura;
	public Rectangulo(double base, double altura) throws DimensionNoValidaException {
		super();
		setAltura(dimensionValida(altura));
		setBase(dimensionValida(base));
		
	}
	public Rectangulo(int identificador){
		super(identificador);
	}
	
	protected double getBase() {
		return base;
	}

	private void setBase(double base) {
		this.base = base;
	}
	
	private void setAltura(double altura){
		
		this.altura = altura;
	}
	
	protected double getAltura() {
		return altura;
	}
	
	@Override
	double calcularArea() {
		
		return redondear(getBase()*getAltura());
	}

	@Override
	double calcularPerimetro() {
		
		return redondear(2*getBase() + 2*getAltura());
		
	}

	@Override
	public String toString() {
		return super.toString()+", base="+redondear(getBase())+", altura="+redondear(getAltura())+"]";
	}

}
