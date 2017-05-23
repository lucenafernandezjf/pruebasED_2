package pgn.poo.examenMarzo2017.jerarquiaFiguras;

import pgn.poo.examenMarzo2017.estructuras.DimensionNoValidaException;

public class TrianguloRectangulo extends FiguraCerrada {
	private double base;
	private double altura;
	public TrianguloRectangulo(double base, double altura) throws DimensionNoValidaException {
		super();
		setAltura(dimensionValida(altura));
		setBase(dimensionValida(base));
		
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
		
		return redondear((getBase()*getAltura())/2);
	}

	@Override
	double calcularPerimetro() {
		
		return redondear(getBase()+getAltura()+Math.sqrt((Math.pow(getBase(),2)+Math.pow(getAltura(),2))));
		
	}

	@Override
	public String toString() {
		return super.toString()+", base="+redondear(getBase())+", altura="+redondear(getAltura())+"]";
	}
}
