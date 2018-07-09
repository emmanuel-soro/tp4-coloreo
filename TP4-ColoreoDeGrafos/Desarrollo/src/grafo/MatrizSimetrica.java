package grafo;

/**
 * Clase que administra la matriz simétrica de un grafo. <br>
 */
public class MatrizSimetrica {
	/**
	 * Indicador de si hay relación de nodos en la matriz simétrica. <br>
	 */
	private boolean[] matrizEnVector;
	/**
	 * Cantidad de nodos. <br>
	 */
	private int posiciones;

	/**
	 * Crea una matriz simétrica a partir de la cantidad de nodos de un grafo. <br>
	 * 
	 * @param cantidadDeNodos
	 *            Cantidad de nodos del grafo. <br>
	 */
	public MatrizSimetrica(final int cantidadDeNodos) {
		this.posiciones = cantidadDeNodos;
		int cantidadDePosiciones = (cantidadDeNodos * (cantidadDeNodos - 1)) / 2;
		this.matrizEnVector = new boolean[cantidadDePosiciones];
	}

	/**
	 * Establece la adyacencia entre 2 nodos. <br>
	 * 
	 * @param fila
	 *            Nodo1. <br>
	 * @param columna
	 *            Nodo2. <br>
	 */
	public void insertarArista(int fila, int columna) {
		if (columna < fila) {
			int aux = fila;
			fila = columna;
			columna = aux;
		}
		// Calculo I = F * N + C – ( F^2 + 3 * F + 2) / 2
		int indice = (int) (fila * this.posiciones + columna - (Math.pow(fila, 2) + 3 * fila + 2) / 2);
		this.matrizEnVector[indice] = true;
	}

	/**
	 * Devuelve si 2 nodos son adyacentes. <br>
	 * 
	 * @param fila
	 *            Nodo1. <br>
	 * @param columna
	 *            Nodo2. <br>
	 * @return true si existe la relación, false de lo contrario. <br>
	 */
	public boolean sonAdyecentes(int fila, int columna) {
		if (columna < fila) {
			int aux = fila;
			fila = columna;
			columna = aux;
		}
		// Calculo I = F * N + C – ( F^2 + 3 * F + 2) / 2
		int indice = (int) (fila * this.posiciones + columna - (Math.pow(fila, 2) + 3 * fila + 2) / 2);
		return this.matrizEnVector[indice];
	}

	/**
	 * Devuelve la cantidad de posiciones en la matriz simétrica. <br>
	 * 
	 * @return Cantidad de posiciones. <br>
	 */
	public int getPosiciones() {
		return this.posiciones;
	}

	/**
	 * Calcula el porcentaje de adyacencia del grafo representado
	 * 
	 * @return porcentaje de adyacencia
	 */
	public double getPorcentajeAdyacencia() {

		int cantAristas = 0;
		for (int i = 0; i < matrizEnVector.length; i++) {
			if (matrizEnVector[i]) {
				cantAristas++;
			}
		}
		int cantMaxAristas = posiciones * (posiciones - 1) / 2;

		return Math.rint((double) cantAristas * 100 / cantMaxAristas);
	}
}