package pgn.poo.examenMarzo2017.presentacion;

import pgn.poo.examenMarzo2017.estructuras.DimensionNoValidaException;
import pgn.poo.examenMarzo2017.estructuras.FiguraNoExisteException;
import pgn.poo.examenMarzo2017.estructuras.IDNoExisteException;
import pgn.poo.examenMarzo2017.estructuras.ListaVaciaException;
import pgn.poo.examenMarzo2017.estructuras.NumeroListaNoValidoException;
import pgn.poo.examenMarzo2017.jerarquiaFiguras.FigurasCerradas;
import pgn.poo.utiles.Menu;
import pgn.poo.utiles.Teclado;

public class TestFiguras {
	static FigurasCerradas figuritas = new FigurasCerradas();
	static Menu menuPrincipal = new Menu("**General", new String[] { "Alta", "Baja", "Listar" });
	static Menu menuAltas = new Menu("**Altas", new String[] {
			"Masiva (dimensiones aleatorias, 3 figuras de cada tipo)", "Selectiva (dimensiones por teclado)" });
	static Menu menuFiguras = new Menu("**Elige una figura a crear",
			new String[] { "Circulo", "Cuadrado", "Rectangulo", "Triángulo" });
	static Menu menuListar = new Menu("**Listar", new String[] { "Todos", "Triangulos", "Del Reves" });
	static Menu menuBajas = new Menu("**Bajas", new String[] { "Por identificador", "Por indice de lista" });

	public static void main(String[] args) throws DimensionNoValidaException {
		int opcion;
		do {
			opcion = menuPrincipal.gestionar();
			switch (opcion) {
			case 1:
				darAltas();
				break;
			case 2:
				try{
					if(!figuritas.isEmpty())
						darBajas();
				}catch(ListaVaciaException e){
					System.err.println(e.getMessage());
				}
					
				
				
				break;
			case 3:
				try{
					if(!figuritas.isEmpty())
						listar();
				}catch(ListaVaciaException e){
					System.err.println(e.getMessage());
				}

			}
		} while (opcion != menuPrincipal.SALIR);

	}

	private static void listar() {
		int opcion;
		do {
			opcion = menuListar.gestionar();
			switch (opcion) {
			case 1:
				System.out.println(figuritas.toString());
				break;
			case 2:
				System.out.println(figuritas.listarTriangulos());
				break;
			case 3:
				System.out.println(figuritas.listarDelReves());
			}
		} while (opcion != menuListar.SALIR);

	}

	private static void darBajas() {
		int opcion;
		do {
			opcion = menuBajas.gestionar();
			switch (opcion) {
			case 1:
				bajaIdentficador();
				break;
			case 2:
				bajaPorLista();
				break;
			}
		} while (opcion != menuBajas.SALIR);

	}

	private static void bajaPorLista() {
		try {
			System.out.println(figuritas.toString());
			int numero = Teclado.leerEntero("Introduzca el numero del identificador");

			figuritas.borrarPorLista(numero - 1);
		} catch (NumeroListaNoValidoException e) {
			System.err.println(e.getMessage());
		}

	}

	private static void bajaIdentficador() {
		try {
			System.out.println(figuritas.toString());
			int identificador = Teclado.leerEntero("Introduzca el numero del identificador");

			figuritas.borrarPorId(identificador);
		} catch (IDNoExisteException | FiguraNoExisteException e) {
			System.err.println(e.getMessage());
		}

	}

	private static void darAltas() throws DimensionNoValidaException {
		int opcion;
		do {
			opcion = menuAltas.gestionar();
			switch (opcion) {
			case 1:
				figuritas.altaMasiva();
				break;
			case 2:
				altaSelectiva();
				break;
			}
		} while (opcion != menuAltas.SALIR);

	}

	private static void altaSelectiva() {
		int opcion;
		do {
			opcion = menuFiguras.gestionar();

			switch (opcion) {
			case 1:
				figuritas.addCirculo(Teclado.leerDecimal("Introduce el radio del Circulo: "));
				break;
			case 2:
				figuritas.addCuadrado(Teclado.leerDecimal("Introduce el lado del Cuadrado: "));
				break;
			case 3:
				figuritas.addRectangulo(Teclado.leerDecimal("Introduce la base del Rectangulo: "), Teclado.leerDecimal("Introduce la"
						+ " altura del Rectangulo: "));
				break;
			case 4:
				figuritas.addTrianguloRectangulo(Teclado.leerDecimal("Introduce la base del Triangulo Rectangulo: "), Teclado.leerDecimal("Introduce la"
						+ " altura del Triangulo Rectangulo: "));

			}

		} while (opcion != menuFiguras.SALIR);

	}

}
