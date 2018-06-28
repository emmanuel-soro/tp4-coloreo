package test;

import org.junit.Test;

import grafo.GeneradorAleatorio;
import grafo.GeneradorRegular;
import grafo.GrafoNDNP;

public class GeneracionTest {
	private static final String PATH_ARCHIVOS = "Preparacion de Prueba/Programa Probador/Entrada/";

	@Test
	public void generarGrafoAleatorioNyPorcAdy600y40() {
		GeneradorAleatorio ga = new GeneradorAleatorio();
		GrafoNDNP grafo = ga.generarPorPorcentajeAdyacencia(600, 40.0);
		grafo.grabarEntradaGrafo(PATH_ARCHIVOS + "grafo600y40.in");
	}

	@Test
	public void generarGrafoAleatorioNyPorcAdy600y60() {
		GeneradorAleatorio ga = new GeneradorAleatorio();
		GrafoNDNP grafo = ga.generarPorPorcentajeAdyacencia(600, 60.0);
		grafo.grabarEntradaGrafo(PATH_ARCHIVOS + "grafo600y60.in");
	}

	@Test
	public void generarGrafoAleatorioNyPorcAdy600y90() {
		GeneradorAleatorio ga = new GeneradorAleatorio();
		GrafoNDNP grafo = ga.generarPorPorcentajeAdyacencia(600, 90.0);
		grafo.grabarEntradaGrafo(PATH_ARCHIVOS + "grafo600y90.in");
	}

	@Test
	public void generarGrafoRegular1000y75() {
		GeneradorRegular gr = new GeneradorRegular();
		GrafoNDNP grafo = gr.generarPorPorcentajeAdyacencia(1000, 75.0);
		grafo.grabarEntradaGrafo(PATH_ARCHIVOS + "grafo1000y75.in");
	}

	@Test
	public void generarGrafoRegular1000y50() {
		GeneradorRegular gr = new GeneradorRegular();
		GrafoNDNP grafo = gr.generarPorPorcentajeAdyacencia(1000, 50.0);
		grafo.grabarEntradaGrafo(PATH_ARCHIVOS + "grafo1000y50.in");
	}
}
