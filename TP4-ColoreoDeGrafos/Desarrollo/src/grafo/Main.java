package grafo;

public class Main {

	public static void main(String[] args) {

		final String PATH_ARCHIVOS = "Preparacion de Prueba/Programa Probador/Entrada/";
		
		//Aleatorio
		GeneradorAleatorio ga = new GeneradorAleatorio();
		GrafoNDNP grafo = ga.generarPorPorcentajeAdyacencia(600, 40.0);
		grafo.grabarEntradaGrafo(PATH_ARCHIVOS + "grafo600y40.in");

		grafo = ga.generarPorPorcentajeAdyacencia(600, 60.0);
		grafo.grabarEntradaGrafo(PATH_ARCHIVOS + "grafo600y60.in");

		grafo = ga.generarPorPorcentajeAdyacencia(600, 90.0);
		grafo.grabarEntradaGrafo(PATH_ARCHIVOS + "grafo600y90.in");
		
		//Regular
		GeneradorRegular gr = new GeneradorRegular();
		grafo = gr.generarPorPorcentajeAdyacencia(1000, 75.0);
		grafo.grabarEntradaGrafo(PATH_ARCHIVOS + "grafo1000y75.in");

		grafo = gr.generarPorPorcentajeAdyacencia(1000, 50.0);
		grafo.grabarEntradaGrafo(PATH_ARCHIVOS + "grafo1000y50.in");
		
		grafo = gr.generarPorGrado(4, 3);
		grafo.grabarEntradaGrafo(PATH_ARCHIVOS + "grafoN4G3.in");
		
		grafo = gr.generarPorGrado(2, 1);
		grafo.grabarEntradaGrafo(PATH_ARCHIVOS + "grafoN2G1.in");
		
		//n-partito
		GeneradorNPartito gnp = new GeneradorNPartito();
		grafo = gnp.generarNPartito(4, 2);
		grafo.grabarEntradaGrafo(PATH_ARCHIVOS + "grafoBipartito4N.in");
		
		grafo = gnp.generarNPartito(5, 2);
		grafo.grabarEntradaGrafo(PATH_ARCHIVOS + "grafoBipartito5N.in");
		
		grafo = gnp.generarNPartito(5, 3);
		grafo.grabarEntradaGrafo(PATH_ARCHIVOS + "grafoTripartito5N.in");
		
		grafo = gnp.generarNPartito(6, 3);
		grafo.grabarEntradaGrafo(PATH_ARCHIVOS + "grafoTripartito6N.in");
	}
}
