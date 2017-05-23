package pgn.poo.examenMarzo2017.jerarquiaFiguras;

import pgn.poo.examenMarzo2017.estructuras.DimensionNoValidaException;

public class Cuadrado extends Rectangulo {
	
	public Cuadrado(double lado) throws DimensionNoValidaException {
		super(lado, lado);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName()+" [identificador="+getIdentificador()+", perimetro="+calcularPerimetro()+", area="+calcularArea()+", lado=" + redondear(getBase())
				+ "]";
	}
	
	

}
