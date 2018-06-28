package grafo;

public abstract class Generador {
	/**
	 * Grado máximo del gráfo. <br>
	 */
	protected int gradoMax;
	/**
	 * Grado mínimo del gráfo. <br>
	 */
	protected int gradoMin;

	/**
	 * Genera un gráfo dado su cantidad de nodos y su porcentaje de adyacencia. <br>
	 * 
	 * @param cantNodos
	 *            Cantidad de nodos. <br>
	 * @param porcentajeAdyacencia
	 *            Porcentaje de adyacencia. <br>
	 * @return Gráfo. <br>
	 */
	protected abstract GrafoNDNP generarPorProbabilidad(final int cantNodos, final double probabilidad);

	/**
	 * Genera un gráfo dado su cantidad de nodos y el porcentaje de adyacencia. <br>
	 * 
	 * @param cantNodos
	 *            Cantidad de nodos. <br>
	 * @param porcAdyacencia
	 *            Porcentaje de adyacencia. <br>
	 * @return Gráfo. <br>
	 */
	protected abstract GrafoNDNP generarPorPorcentajeAdyacencia(final int cantNodos, final double porcentajeAdyacencia);

	/**
	 * Genera un gráfo dado sun cantidad de nodos y el grado. <br>
	 * 
	 * @param cantNodos
	 *            Cantidad de nodos. <br>
	 * @param grado
	 *            Grado. <br>
	 * @return Gráfo. <br>
	 */
	protected abstract GrafoNDNP generarPorGrado(final int cantNodos, final int grado);

	/**
	 * Genera un gráfo n-partitos. <br>
	 * 
	 * @param cantNodos
	 *            Cantidad de nodos. <br>
	 * @param n
	 *            Partitos. <br>
	 * @return Gráfo. <br>
	 */
	protected abstract GrafoNDNP generarNPartito(final int cantNodos, final int n);

	/**
	 * Calcula el grado mínimo y el grado máximo del gráfo. <br>
	 * 
	 * @param matriz
	 *            Matriz simétrica del gráfo. <br>
	 * @param cantNodos
	 *            Cantidad de nodos del gráfo. <br>
	 */
	protected void calcularGradoMinYMax(MatrizSimetrica matriz, int cantNodos) {
		int[] sumador = new int[cantNodos];
		for (int i = 0; i < cantNodos; i++) {
			for (int j = i + 1; j < cantNodos; j++) {
				if (matriz.getMatrizSimetrica(i, j)) {
					sumador[i] += 1;
					sumador[j] += 1;
				}
			}
		}
		gradoMax = 0;
		for (int j = 0; j < sumador.length; j++) {
			if (sumador[j] > gradoMax) {
				gradoMax = sumador[j];
			}
		}
		gradoMin = gradoMax - 1;
		for (int j = 0; j < sumador.length; j++) {
			if (sumador[j] < gradoMin) {
				gradoMin = sumador[j];
			}
		}
	}
}
