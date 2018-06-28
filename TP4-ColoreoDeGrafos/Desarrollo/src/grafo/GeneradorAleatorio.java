package grafo;

import java.util.Random;

public class GeneradorAleatorio extends Generador {

	@Override
	public GrafoNDNP generarPorProbabilidad(int cantNodos, double probabilidad) {
		// Probabilidad ejemplo= 0,5
		int cantAristas = 0;
		MatrizSimetrica matriz = new MatrizSimetrica(cantNodos);
		for (int i = 0; i < cantNodos; i++) {
			for (int j = i + 1; j < cantNodos; j++) {
				if (!matriz.getMatrizSimetrica(i, j)) {
					if (Math.random() < probabilidad) {
						matriz.setMatrizSimetrica(i, j);
						cantAristas++;
					}
				}
			}
		}
		int cantTotAristas = (cantNodos * (cantNodos - 1)) / 2;
		double porcentajeDeAdyacencia = Math.rint((cantAristas / cantTotAristas) * 100.0);
		calcularGradoMinYMax(matriz, cantNodos);
		GrafoNDNP grafo = new GrafoNDNP(matriz, cantNodos, cantAristas, porcentajeDeAdyacencia, gradoMax, gradoMin);
		return grafo;
	}

	@Override
	public GrafoNDNP generarPorPorcentajeAdyacencia(int cantNodos, double porcentajeAdyacencia) {
		Random arista = new Random();
		MatrizSimetrica matriz = new MatrizSimetrica(cantNodos);
		int maximoAristas = (cantNodos * (cantNodos - 1)) / 2;
		int cantAristas = (int) (Math.rint((cantNodos * cantNodos - cantNodos) * 0.5 * (porcentajeAdyacencia / 100.0)));
		int aristasAplicadas = 0;
		double porcAdy = porcentajeAdyacencia;
		while (aristasAplicadas != cantAristas) {
			for (int i = 0; i < cantNodos; i++) {
				for (int j = i + 1; j < cantNodos; j++) {
					if (!matriz.getMatrizSimetrica(i, j)) {
						if (arista.nextInt(2) == 1) {
							matriz.setMatrizSimetrica(i, j);
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
		GrafoNDNP grafo = new GrafoNDNP(matriz, cantNodos, cantAristas, porcAdy, gradoMax, gradoMin);
		return grafo;
	}

	@Override
	public GrafoNDNP generarPorGrado(int cantNodos, int grado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected GrafoNDNP generarNPartito(int cantNodos, int n) {
		// TODO Auto-generated method stub
		return null;
	}

}
