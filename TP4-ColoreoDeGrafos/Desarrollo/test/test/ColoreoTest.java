package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import probador.ComparadorArchivos;

public class ColoreoTest {
	private static final String PATH_ARCHIVOS_ENT = "Preparacion de Prueba/Programa Probador/Entrada/";
	private static final String PATH_ARCHIVOS_SAL = "Preparacion de Prueba/Programa Probador/Salida Esperada/";
	
	private ComparadorArchivos probador;
	
	@Test
	public void probadorGrafoRegular5N() {
		probador = new ComparadorArchivos(PATH_ARCHIVOS_ENT + "grafoRegular5N.in",
				PATH_ARCHIVOS_SAL + "grafoRegular5N.out");
		assertTrue(probador.comparar());
	}

	@Test
	public void probadorGrafo6N() {
		probador = new ComparadorArchivos(PATH_ARCHIVOS_ENT + "grafo6N.in",
				PATH_ARCHIVOS_SAL + "grafo6N.out");
		assertTrue(probador.comparar());
	}

	@Test
	public void probadorGrafo7N() {
		probador = new ComparadorArchivos(PATH_ARCHIVOS_ENT + "grafo7N.in",
				PATH_ARCHIVOS_SAL + "grafo7N.out");
		assertTrue(probador.comparar());
	}

	@Test
	public void probadorGrafo600y40() {
		probador = new ComparadorArchivos(PATH_ARCHIVOS_ENT + "grafo600y40.in",
				PATH_ARCHIVOS_SAL + "grafo600y40.out");
		assertTrue(probador.comparar());
	}

	@Test
	public void probadorGrafoNPartito() {
		probador = new ComparadorArchivos(PATH_ARCHIVOS_ENT + "grafoNPartito800y400.in",
				PATH_ARCHIVOS_SAL + "grafoNPartito800y400.out");
		assertTrue(probador.comparar());
	}
}
