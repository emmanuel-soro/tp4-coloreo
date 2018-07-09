package grafo;

public class GeneradorNPartito extends Generador{

	@Override
	public GrafoNDNP generarPorProbabilidad(int cantNodos, double probabilidad) {
		return null;
	}

	@Override
	public GrafoNDNP generarPorPorcentajeAdyacencia(int cantNodos, double porcentajeAdyacencia) {
		return null;
	}

	@Override
	public GrafoNDNP generarPorGrado(int cantNodos, int grado) {
		return null;
	}
	
	/**
	 * Generador de grafo N partitos dados la cantidad de nodos y la cantidad de
	 * conjuntos.
	 * 
	 * @param cantidadNodos
	 *            Cantidad de nodos. <br>
	 * @param nPartito
	 *            N-partitos. <br>
	 */
	@Override
	public GrafoNDNP generarNPartito(final int cantidadNodos, final int nPartito) {
		MatrizSimetrica matrizSimetrica = new MatrizSimetrica(cantidadNodos);
		int cantidadAristas = 0;
		if (cantidadNodos == nPartito) {
			for (int fil = 0; fil < cantidadNodos; fil++)
				for (int col = fil + 1; col < cantidadNodos; col++) {
					matrizSimetrica.insertarArista(fil, col);
					cantidadAristas++;
				}
		} else {
			if (cantidadNodos % nPartito == 0) {
				int islas = nPartito;
				int nodosPorIsla = cantidadNodos / nPartito;
				for (int i = 0; i < nodosPorIsla; i++)
					for (int j = 0; j < nodosPorIsla; j++) {
						matrizSimetrica.insertarArista(i, j + nodosPorIsla);
						cantidadAristas++;
					}
				islas -= 2;
				int nodoActual = 2 * nodosPorIsla;
				int cantidad = nodoActual;
				while (islas != 0) {
					for (int i = 0; i < nodosPorIsla; i++) {
						for (int j = 0; j < cantidad; j++) {
							matrizSimetrica.insertarArista(nodoActual, j);
							cantidadAristas++;
						}
						nodoActual++;
					}
					cantidad += nodosPorIsla;
					islas--;
				}
			} else {
				int islas = nPartito;
				int nodosIsla1 = Math.round(cantidadNodos / (float) nPartito);
				int nodosIsla2 = Math.round(cantidadNodos / (float) nPartito);
				while (nodosIsla1 + nodosIsla2 > cantidadNodos)
					nodosIsla2--;
				int acum = nodosIsla1 + nodosIsla2;
				for (int i = 0; i < nodosIsla1; i++)
					for (int j = 0; j < nodosIsla2; j++) {
						matrizSimetrica.insertarArista(i, j + nodosIsla1);
						cantidadAristas++;
					}
				islas -= 2;
				int nodoActual = acum;
				int nodosNuevaIsla = 0;
				while (islas != 0) {
					if (islas != 1) {
						nodosNuevaIsla = Math.round(cantidadNodos / (float) nPartito);
					} else {
						nodosNuevaIsla = cantidadNodos - acum;
					}
					while (nodosNuevaIsla + acum > cantidadNodos) {
						nodosNuevaIsla--;
					}
					for (int i = 0; i < nodosNuevaIsla; i++) {
						for (int j = 0; j < acum; j++) {
							matrizSimetrica.insertarArista(nodoActual, j);
							cantidadAristas++;
						}
						nodoActual++;
					}
					acum += nodosNuevaIsla;
					islas--;
				}
			}
		}
		
		calcularGradoMinYMax(matrizSimetrica, cantidadNodos);
		return new GrafoNDNP(matrizSimetrica, cantidadNodos, cantidadAristas, matrizSimetrica.getPorcentajeAdyacencia(), gradoMin, gradoMax);
	}

}
