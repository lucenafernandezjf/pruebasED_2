package pgn.poo.examenMarzo2017.jerarquiaFiguras;

import java.util.ArrayList;
import java.util.ListIterator;

import pgn.poo.examenMarzo2017.estructuras.DimensionNoValidaException;
import pgn.poo.examenMarzo2017.estructuras.FiguraNoExisteException;
import pgn.poo.examenMarzo2017.estructuras.IDNoExisteException;
import pgn.poo.examenMarzo2017.estructuras.ListaVaciaException;
import pgn.poo.examenMarzo2017.estructuras.NumeroListaNoValidoException;

public class FigurasCerradas {
	private ArrayList<FiguraCerrada> figuritas;

	public FigurasCerradas() {
		figuritas = new ArrayList<FiguraCerrada>();

	}

	public void addCuadrado(double lado) {
		try {
			figuritas.add(new Cuadrado(lado));
		} catch (DimensionNoValidaException e) {
			System.err.println(e.getMessage());
		}

	}

	public void addCirculo(double radio) {
		try {
			figuritas.add(new Circulo(radio));
		} catch (DimensionNoValidaException e) {
			System.err.println(e.getMessage());
		}

	}

	public void addRectangulo(double base, double altura) {
		try {
			figuritas.add(new Rectangulo(base, altura));
		} catch (DimensionNoValidaException e) {

			System.err.println(e.getMessage());
		}

	}

	public void addTrianguloRectangulo(double base, double altura) {
		try {
			figuritas.add(new TrianguloRectangulo(base, altura));
		} catch (DimensionNoValidaException e) {

			System.err.println(e.getMessage());
		}

	}
	@Override
	public String toString() {
		int i = 1;
		String cadena = figuritas.size() + " figuritas [\n\t";
		for (FiguraCerrada figurita : figuritas){
			cadena += i+". " + figurita.toString() + "\n\t";
			i++;
		}
		cadena += "]";
		return cadena;
	}
	
	public boolean isEmpty() throws ListaVaciaException{
		if(figuritas.isEmpty())
			throw new ListaVaciaException("ERROR. La lista está vacía.");
		return false;
	}
	public String listarTriangulos() {
		int contadorTriangulos = 0;
		String cadena = "Triangulos en la lista [\n\t";
		for (FiguraCerrada triangulo : figuritas) {
			if (triangulo instanceof TrianguloRectangulo){
				cadena += triangulo.toString() + "\n\t";
				contadorTriangulos++;
			}
		}
		cadena += "\n Total de triángulos: "+ contadorTriangulos +" ]";
		return cadena;
	}

	public String listarDelReves() {
		ListIterator<FiguraCerrada> listIterator = figuritas.listIterator(figuritas.size());
		String cadena = "Lista de figuras del reves [ \n\t";
		while (listIterator.hasPrevious()) {
			cadena += listIterator.previous().toString() + "\n\t";
		}
		cadena += "]";
		return cadena;
	}

	public String borrarPorId(int identificador) throws IDNoExisteException, FiguraNoExisteException {
		
		FiguraCerrada figura = figuritas.get(figuritas.indexOf(new Rectangulo(comprobarIdentificador(identificador))));
		
		if(!figuritas.remove(figura))
			throw new FiguraNoExisteException("La figura que ha introducido no está en la lista.");
			
		return "Se ha borrado de la lista: "+figura.toString();
		
		

	}

	private int comprobarIdentificador(int identificador) throws IDNoExisteException {
		if(identificador<0 || identificador>figuritas.get(figuritas.size()-1).getIdentificador())
			throw new IDNoExisteException("No existe el id que ha introducido en la lista.");
		return identificador;
	}

	public String borrarPorLista(int numero) throws NumeroListaNoValidoException {
		
			FiguraCerrada figura = figuritas.get(comprobarnumerolista(numero));
			figuritas.remove(figuritas.get(numero));
			
			return "Se ha borrado de la lista: "+figura.toString();
		
		
		
		

	}

	private int comprobarnumerolista(int numero) throws NumeroListaNoValidoException {
		if(numero<0 || numero>figuritas.size()-1)
			throw new NumeroListaNoValidoException("ERROR. No se encuentra el numero de la lista.");
		return numero;
	}

	public void altaMasiva() {
		for (int i = 0; i < 3; i++) {
			addCuadrado(numeroAleatorio());
			addRectangulo(numeroAleatorio(), numeroAleatorio());
			addCirculo(numeroAleatorio());
			addTrianguloRectangulo(numeroAleatorio(), numeroAleatorio());
		}

	}

	public double numeroAleatorio() {
		return Math.random();
	}

}
