package pgn.poo.examenMarzo2017.jerarquiaFiguras;

import pgn.poo.examenMarzo2017.estructuras.DimensionNoValidaException;

public class Circulo extends FiguraCerrada{
	private double radio;
	public Circulo(double radio) throws DimensionNoValidaException {
		super();
		setRadio(dimensionValida(radio));
	}
	public double getRadio() {
		return radio;
	}
	
	public void setRadio(double radio) {
		this.radio = radio;
	}
	@Override
	double calcularArea() {
		
		return redondear(Math.PI*Math.pow(getRadio(), 2));
	}

	@Override
	double calcularPerimetro() {
		return redondear(2*Math.PI*getRadio());
	}

	@Override
	public String toString() {
		return super.toString()+", radio="+redondear(getRadio())+"]";
				
	}

	

}
