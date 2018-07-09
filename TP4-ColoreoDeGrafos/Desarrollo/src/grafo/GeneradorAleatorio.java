package grafo;

import java.util.Random;

public class GeneradorAleatorio extends Generador {

	@Override
	public GrafoNDNP generarPorProbabilidad(int cantNodos, double probabilidad) {
		int cantAristas = 0;
		MatrizSimetrica matriz = new MatrizSimetrica(cantNodos);
		for (int i = 0; i < cantNodos; i++) {
			for (int j = i + 1; j < cantNodos; j++) {
				if (!matriz.sonAdyecentes(i, j)) {
					if (Math.random() < probabilidad) {
						matriz.insertarArista(i, j);
						cantAristas++;
					}
				}
			}
		}
		double porcentajeDeAdyacencia = matriz.getPorcentajeAdyacencia();
		calcularGradoMinYMax(matriz, cantNodos);
		return new GrafoNDNP(matriz, cantNodos, cantAristas, porcentajeDeAdyacencia, gradoMax, gradoMin);
	}

	@Override
	public GrafoNDNP generarPorPorcentajeAdyacencia(int cantNodos, double porcentajeAdyacencia) {
		Random arista = new Random();
		MatrizSimetrica matriz = new MatrizSimetrica(cantNodos);
		int maximoAristas = (cantNodos * (cantNodos - 1)) / 2;
		//Calculo de T = ( N^2 – N ) / 2
		int cantAristas = (int) (Math.rint((cantNodos * cantNodos - cantNodos) * 0.5 * (porcentajeAdyacencia / 100.0)));
		int aristasAplicadas = 0;
		while (aristasAplicadas != cantAristas) {
			for (int i = 0; i < cantNodos; i++) {
				for (int j = i + 1; j < cantNodos; j++) {
					if (!matriz.sonAdyecentes(i, j)) {
						if (arista.nextInt(2) == 1) {
							matriz.insertarArista(i, j);
							aristasAplicadas++;
						}
					}
					if (aristasAplicadas == cantAristas) {
						break;
					}
				}
				if (aristasAplicadas == cantAristas) {
					break;
				}
			}
		}
		calcularGradoMinYMax(matriz, cantNodos);
		return new GrafoNDNP(matriz, cantNodos, cantAristas, porcentajeAdyacencia, gradoMax, gradoMin);
	}

	@Override
	public GrafoNDNP generarPorGrado(int cantNodos, int grado) {
		return null;
	}

	@Override
	public GrafoNDNP generarNPartito(int cantNodos, int n) {
		return null;
	}

}
