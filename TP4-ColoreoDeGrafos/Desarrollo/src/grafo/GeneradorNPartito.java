package grafo;

import java.util.Random;

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
	/*
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
	*/
	
	@Override
	public GrafoNDNP generarNPartito (int cantNodos, int n){
		MatrizSimetrica matriz = new MatrizSimetrica (cantNodos);	
		if (cantNodos % n != 0 && n >= cantNodos) {
			throw new RuntimeException("No se puede generar grafo n partito.");
		}
		int grado[] = new int[cantNodos];
		int [] nodoYGrupo = new int[cantNodos];
		int rdmCant, rdmPos;
		int nodoXGrupo = cantNodos / n;
		int cantAristas = 0;
		//gnd = new GrafoNDNP(matriz, cantNodos, 0, 0, 0 , 0 );
		barajar(cantNodos, n, nodoYGrupo, nodoXGrupo);
		
		for(int i = 0; i < nodoYGrupo.length; i++)
		{
			rdmCant = (int) (Math.random() * nodoXGrupo - 1);
			if(rdmCant == 0)
				rdmCant++;
			for(int j = 0; j < rdmCant; j++)
			{
				rdmPos = (int) (Math.random() * cantNodos);
				while(i == rdmPos || nodoYGrupo[i] == nodoYGrupo[rdmPos])
				{
					rdmPos = (rdmPos + 1) % cantNodos;
				}
				if(matriz.matrizEnVector[matriz.posicionVector(i, rdmPos, cantNodos)] != true)
				{
					matriz.matrizEnVector[matriz.posicionVector(i, rdmPos, cantNodos)] = true;
					cantAristas++;
					grado[i]++;
					grado[rdmPos]++;
				}
			}
		}
		int min, max;
		min = max = grado[0];
		for(int ind = 1; ind < cantNodos; ind++)
		{
			if(grado[ind] < min)
				min = grado[ind];
			if(grado[ind] > max)
				max = grado[ind];
		}
		gradoMax = max;
		gradoMin = min;
		double porcAdyacencia = matriz.getPorcentajeAdyacencia();
		GrafoNDNP grafo = new GrafoNDNP (matriz, cantNodos, cantAristas, porcAdyacencia, gradoMin, gradoMax);
		return grafo;
	}


	private void barajar(int cantNodos, int grupos, int [] nodoYGrupo, int nodoXGrupo)
	{
		int n = cantNodos;  //numeros aleatorios
		int k = n;  //auxiliar;
		Random rnd = new Random();
		int res;
		int cont = 0;
		
		int[] nodoGrupo = new int[cantNodos];
		
		for(int i = 0; i < grupos; i++)
		{
			for(int j = 0; j < nodoXGrupo; j++)
			{	
				nodoGrupo[cont] = i;
				cont++;
			}
		}
					
		for(int i = 0; i < n; i++)
		{
			res = rnd.nextInt(k);            
			nodoYGrupo[i] = nodoGrupo[res];
			nodoGrupo[res] = nodoGrupo[k - 1];
			k--;  
		}
	}



}



