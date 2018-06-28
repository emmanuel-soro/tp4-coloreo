package grafo;

public class GeneradorRegular extends Generador {

	@Override
	protected GrafoNDNP generarPorProbabilidad(int cantNodos, double probabilidad) {
		return null;
	}

	@Override
	protected GrafoNDNP generarPorPorcentajeAdyacencia(int cantNodos, double porcentajeAdyacencia) {
		MatrizSimetrica matriz;
		int grado = (int) (((porcentajeAdyacencia / 100) * (cantNodos - 1)));
		int cantAristas = (cantNodos * grado) / 2;
		int saltoMax, j;
		matriz = new MatrizSimetrica(cantNodos);
		if (((cantNodos % 2) == 0) || ((grado % 2) == 0)) {
			saltoMax = (grado) / 2;
			for (int salto = 0; salto <= saltoMax; salto++) {
				for (int i = 1; i < cantNodos; i++) {
					j = (i + salto) % cantNodos;
					matriz.setMatrizSimetrica(i, j);
				}
			}
			if (grado % 2 != 0) {
				for (int i = 0; i < cantNodos / 2; i++) {
					j = (i + cantNodos) / 2;
					matriz.setMatrizSimetrica(i, j);
				}
			}
		}
		GrafoNDNP grafo = new GrafoNDNP(matriz, cantNodos, cantAristas, porcentajeAdyacencia, grado, grado);
		return grafo;
	}

	@Override
	protected GrafoNDNP generarPorGrado(int cantNodos, int grado) {
		MatrizSimetrica matriz;
		int cantidadAristas = 0;
		double porcentajeDeAdyacencia;
		int saltoMax, j;
		if (grado >= cantNodos) {
			throw new RuntimeException("No se puede generar el grafo.");
		}
		matriz = new MatrizSimetrica(cantNodos);
		if (((cantNodos % 2) == 0) || ((grado % 2) == 0)) {
			saltoMax = (grado) / 2;
			for (int salto = 0; salto <= saltoMax; salto++) {
				for (int i = 1; i < cantNodos; i++) {
					j = (i + salto) % cantNodos;
					matriz.setMatrizSimetrica(i, j);
					cantidadAristas++;
				}
			}
			if (grado % 2 != 0) {
				for (int i = 0; i < cantNodos / 2; i++) {
					j = (i + cantNodos) / 2;
					matriz.setMatrizSimetrica(i, j);
					cantidadAristas++;
				}
			}
		}
		porcentajeDeAdyacencia = (grado * (cantNodos - 1)) * 100;
		GrafoNDNP grafo = new GrafoNDNP(matriz, cantNodos, cantidadAristas, porcentajeDeAdyacencia, grado, grado);
		return grafo;
	}

	@Override
	protected GrafoNDNP generarNPartito(int cantNodos, int n) {
		// TODO Auto-generated method stub
		return null;
	}

}
