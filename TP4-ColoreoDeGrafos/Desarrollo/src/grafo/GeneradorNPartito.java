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

	@Override
	public GrafoNDNP generarNPartito(int cantNodos, int n) {
		MatrizSimetrica matriz;
		if (cantNodos % n != 0 && n >= cantNodos) {
			throw new RuntimeException("No se puede generar grafo n partito.");
		}
		int cantAristas = 0;
		matriz = new MatrizSimetrica(cantNodos);
		for (int i = 0; i < cantNodos; i += 2) {
			for (int j = i + 2; j < cantNodos; j++) {
				matriz.setMatrizSimetrica(i, j);
				cantAristas++;
			}
		}
		double porcAdyacencia = matriz.getPorcentajeAdyacencia();
		calcularGradoMinYMax(matriz, cantNodos);
		GrafoNDNP grafo = new GrafoNDNP(matriz, cantNodos, cantAristas, porcAdyacencia, gradoMax, gradoMax);
		return grafo;
	}

}
