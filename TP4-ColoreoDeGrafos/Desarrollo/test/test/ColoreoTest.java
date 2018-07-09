package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import grafo.GrafoNDNP;
import probador.ComparadorArchivos;

public class ColoreoTest {
	private static final String PATH_ENTRADA = "Preparacion de Prueba/Programa Probador/Entrada/";
	private static final String PATH_EJECUCION = "Ejecucion de Prueba/Salida Obtenida/";
	private static final String PATH_SALIDA_ESPERADA = "Preparacion de Prueba/Programa Probador/Salida Esperada/";
	
	private ComparadorArchivos probador;
	private GrafoNDNP grafo;
	
	//REGULARES
	@Test
	public void probadorGrafoRegular4Grado3SecencialAleatorio() {
		
		grafo = new GrafoNDNP(PATH_ENTRADA + "grafoN4G3.in");
		grafo.colorearSecuencialAleatorio();
		grafo.grabarSalidaGrafo(PATH_EJECUCION + "grafoN4G3AS.out");
		
		probador = new ComparadorArchivos(PATH_EJECUCION + "grafoN4G3AS.out",
				PATH_SALIDA_ESPERADA + "grafoN4G3AS.out");
		assertTrue(probador.comparar());
	}
	
	@Test
	public void probadorGrafoRegular4Grado3WelshPowell() {
		
		grafo = new GrafoNDNP(PATH_ENTRADA + "grafoN4G3.in");
		grafo.colorearPowell();;
		grafo.grabarSalidaGrafo(PATH_EJECUCION + "grafoN4G3WP.out");
		
		probador = new ComparadorArchivos(PATH_EJECUCION + "grafoN4G3WP.out",
				PATH_SALIDA_ESPERADA + "grafoN4G3WP.out");
		assertTrue(probador.comparar());
	}
	
	@Test
	public void probadorGrafoRegular4Grado3Matula() {
		
		grafo = new GrafoNDNP(PATH_ENTRADA + "grafoN4G3.in");
		grafo.colorearMatula();
		grafo.grabarSalidaGrafo(PATH_EJECUCION + "grafoN4G3M.out");
		
		probador = new ComparadorArchivos(PATH_EJECUCION + "grafoN4G3M.out",
				PATH_SALIDA_ESPERADA + "grafoN4G3M.out");
		assertTrue(probador.comparar());
	}
	
	@Test
	public void probadorGrafoRegular2Grado1SecencialAleatorio() {
		
		grafo = new GrafoNDNP(PATH_ENTRADA + "grafoN2G1.in");
		grafo.colorearSecuencialAleatorio();
		grafo.grabarSalidaGrafo(PATH_EJECUCION + "grafoN2G1AS.out");
		
		probador = new ComparadorArchivos(PATH_EJECUCION + "grafoN2G1AS.out",
				PATH_SALIDA_ESPERADA + "grafoN2G1AS.out");
		assertTrue(probador.comparar());
	}
	
	@Test
	public void probadorGrafoRegular2Grado1WelshPowell() {
		
		grafo = new GrafoNDNP(PATH_ENTRADA + "grafoN2G1.in");
		grafo.colorearPowell();
		grafo.grabarSalidaGrafo(PATH_EJECUCION + "grafoN2G1WP.out");
		
		probador = new ComparadorArchivos(PATH_EJECUCION + "grafoN2G1WP.out",
				PATH_SALIDA_ESPERADA + "grafoRegular6NWP.out");
		assertTrue(probador.comparar());
	}
	
	@Test
	public void probadorGrafoRegular2Grado1Matula() {
		
		grafo = new GrafoNDNP(PATH_ENTRADA + "grafoN2G1.in");
		grafo.colorearMatula();
		grafo.grabarSalidaGrafo(PATH_EJECUCION + "grafoN2G1M.out");
		
		probador = new ComparadorArchivos(PATH_EJECUCION + "ggrafoN2G1M.out",
				PATH_SALIDA_ESPERADA + "grafoN2G1M.out");
		assertTrue(probador.comparar());
	}
	
	//PARTITOS
	@Test
	public void probadorGrafoBipartito4NSecencialAleatorio() {
		
		grafo = new GrafoNDNP(PATH_ENTRADA + "grafoBipartito4N.in");
		grafo.colorearSecuencialAleatorio();
		grafo.grabarSalidaGrafo(PATH_EJECUCION + "grafoBipartito4NAS.out");
		
		probador = new ComparadorArchivos(PATH_EJECUCION + "grafoBipartito4NAS.out",
				PATH_SALIDA_ESPERADA + "grafoBipartito4NAS.out");
		assertTrue(probador.comparar());
	}
	
	@Test
	public void probadorGrafoBipartito4NWelshPowell() {
		
		grafo = new GrafoNDNP(PATH_ENTRADA + "grafoBipartito4N.in");
		grafo.colorearPowell();
		grafo.grabarSalidaGrafo(PATH_EJECUCION + "grafoBipartito4NWP.out");
		
		probador = new ComparadorArchivos(PATH_EJECUCION + "grafoBipartito4NWP.out",
				PATH_SALIDA_ESPERADA + "grafoBipartito4NWP.out");
		assertTrue(probador.comparar());
	}
	
	@Test
	public void probadorGrafoBipartito4NMatula() {
		
		grafo = new GrafoNDNP(PATH_ENTRADA + "grafoBipartito4N.in");
		grafo.colorearMatula();
		grafo.grabarSalidaGrafo(PATH_EJECUCION + "grafoBipartito4NM.out");
		
		probador = new ComparadorArchivos(PATH_EJECUCION + "grafoBipartito4NM.out",
				PATH_SALIDA_ESPERADA + "grafoBipartito4NM.out");
		assertTrue(probador.comparar());
	}
	
	@Test
	public void probadorGrafoTripartito6NSecencialAleatorio() {
		
		grafo = new GrafoNDNP(PATH_ENTRADA + "grafoTripartito6N.in");
		grafo.colorearSecuencialAleatorio();
		grafo.grabarSalidaGrafo(PATH_EJECUCION + "grafoTripartito6NAS.out");
		
		probador = new ComparadorArchivos(PATH_EJECUCION + "grafoTripartito6NAS.out",
				PATH_SALIDA_ESPERADA + "grafoTripartito6NAS.out");
		assertTrue(probador.comparar());
	}
	
	@Test
	public void probadorGrafoTripartito6NWelshPowell() {
		
		grafo = new GrafoNDNP(PATH_ENTRADA + "grafoTripartito6N.in");
		grafo.colorearPowell();
		grafo.grabarSalidaGrafo(PATH_EJECUCION + "grafoTripartito6NWP.out");
		
		probador = new ComparadorArchivos(PATH_EJECUCION + "grafoTripartito6NWP.out",
				PATH_SALIDA_ESPERADA + "grafoTripartito6NWP.out");
		assertTrue(probador.comparar());
	}
	
	@Test
	public void probadorGrafoTripartito6NMatula() {
		
		grafo = new GrafoNDNP(PATH_ENTRADA + "grafoTripartito6N.in");
		grafo.colorearMatula();
		grafo.grabarSalidaGrafo(PATH_EJECUCION + "grafoTripartito6NM.out");
		
		probador = new ComparadorArchivos(PATH_EJECUCION + "grafoTripartito6NM.out",
				PATH_SALIDA_ESPERADA + "grafoTripartito6NM.out");
		assertTrue(probador.comparar());
	}
}
