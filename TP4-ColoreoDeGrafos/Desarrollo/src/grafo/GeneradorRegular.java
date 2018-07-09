package grafo;

public class GeneradorRegular extends Generador {

	@Override
	public GrafoNDNP generarPorProbabilidad(int cantNodos, double probabilidad) {
		return null;
	}

	@Override
	public GrafoNDNP generarPorPorcentajeAdyacencia(int cantNodos, double porcentajeAdyacencia) {
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
					matriz.insertarArista(i, j);
				}
			}
			if (grado % 2 != 0) {
				for (int i = 0; i < cantNodos / 2; i++) {
					j = (i + cantNodos) / 2;
					matriz.insertarArista(i, j);
				}
			}
		}
		GrafoNDNP grafo = new GrafoNDNP(matriz, cantNodos, cantAristas, porcentajeAdyacencia, grado, grado);
		return grafo;
	}

	/**
	 * Generador de grafo regular dados la cantidad de nodos y el grado que
	 * tienen todos ellos.
	 * 
	 * @param path
	 *            Dirección del archivo a guardar. <br>
	 * @param cantidadNodos
	 *            Cantidad de nodos. <br>
	 * @param grado
	 *            Grado de los nodos. <br>
	 */
	@Override
	public GrafoNDNP generarPorGrado(final int cantidadNodos, int grado) {
		MatrizSimetrica matrizSimetrica = new MatrizSimetrica(cantidadNodos);
		int cantidadAristas = (cantidadNodos * grado) / 2;
		// Camino externo.
		for (int i = 0; i < cantidadNodos - 1; i++)
			matrizSimetrica.insertarArista(i, i + 1);
		if (cantidadNodos > 2) { // Caso m�s de un nodo.
			matrizSimetrica.insertarArista(0, cantidadNodos - 1);
			grado -= 2;
			// Cruz.
			if (grado % 2 != 0) {
				for (int i = 0; i < cantidadNodos / 2; i++)
					matrizSimetrica.insertarArista(i, i + (cantidadNodos / 2));
				grado--;
			}
			// Salteando.
			int cantVeces = grado / 2;
			int saltear = 2;
			for (int i = 0; i < cantVeces; i++) {
				for (int nodoActual = 0; nodoActual < cantidadNodos; nodoActual++) {
					int aux = nodoActual + saltear;
					if (aux > cantidadNodos - 1)
						aux -= cantidadNodos;
					matrizSimetrica.insertarArista(nodoActual, aux);
				}
				saltear++;
			}
		}

		calcularGradoMinYMax(matrizSimetrica, cantidadNodos);
		return new GrafoNDNP(matrizSimetrica, cantidadNodos, cantidadAristas, matrizSimetrica.getPorcentajeAdyacencia(), gradoMin, gradoMax);
	}

	@Override
	public GrafoNDNP generarNPartito(int cantNodos, int n) {
		return null;
	}

}
