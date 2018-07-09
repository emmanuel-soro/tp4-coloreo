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
		
		calcularGradoMinYMax(matriz, cantNodos);
		double porcAdyacencia = matriz.getPorcentajeAdyacencia();
		GrafoNDNP grafo = new GrafoNDNP(matriz, cantNodos, cantAristas, porcAdyacencia, gradoMax, gradoMax);
		return grafo;
	}
	*/

	@Override
	public GrafoNDNP generarNPartito(int cantNodos, int n) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
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
	*/
	
	/**
	 * Mas chances de funcionar si se corrige que el resto
	 */
	
	/*
	@Override
	public GrafoNDNP generarNPartito (int cantNodos, int cantGrupos){
		
		GrafoNDNP gnd = new GrafoNDNP(cantNodos);
		gnd.matriz = new MatrizSimetrica(cantNodos);
		int [] grados = new int[cantNodos];
		int cantAristas = 0;
		if (cantNodos % cantGrupos != 0 && cantGrupos >= cantNodos) {
				throw new RuntimeException("No se puede generar grafo n partito.");
			}
		
		if( cantGrupos != cantNodos ) 
		{
			int [] nodoYGrupo = new int[cantNodos]; //Vector para el grupo de cada nodo
							
			int nodosPorGrupo = cantNodos / cantGrupos; // 6 nodos / 3 grupos --> 2 (3 grupos de 2 nodos)
											// 5 nodos / 3 grupos --> 1 (2 grupos de 1 nodo y 1 de 3 nodos)
											// 4 nodos / 2 grupos --> 2 (2 grupos de 2 nodos)
			
			//GrafoNDNP grafo = new GrafoNDNP (matriz, cantNodos, cantAristas, porcAdyacencia, gradoMin, gradoMax);
			
			barajar(cantNodos, cantGrupos, nodoYGrupo, nodosPorGrupo); //Define a que grupo pertenecera cada nodo
			
			
			//Aca ocurre la magia
			for(int nodoAct = 0; nodoAct < cantNodos-1; nodoAct++)
			{
				for(int i=nodoAct+1; i<cantNodos; i++)
				{
					if( nodoYGrupo[nodoAct]!=nodoYGrupo[i] ) //Si son de distintos grupo, le mando arista
					{
						gnd.matriz.setMatrizSimetrica(nodoAct, i);
						cantAristas++;
					}
				}
			}

		}
		//FIN if(cantGrupos!=cantNodos)
		
		else //Si hay igual cantidad de grupos y de nodos -> Grafo Regular
		{
			//GrafoNDNP gnd = new GrafoNDNP(cantNodos);
			
			for(int i=0; i<gnd.matriz.matrizEnVector.length; i++)
			{
				gnd.matriz.matrizEnVector[i]= true;
			}
			
			cantAristas = (cantNodos * (cantNodos-1)) / 2;
		}
		
			int min,
				max;
			min = max = grados[0];
		
		if( cantGrupos != cantNodos ) //DE NUEVO - Si las cant de grupos y nodos no son iguales)
		{
			//CALCULA EL MAYOR Y EL MENOR GRADO
		
			for(int ind = 1; ind < cantNodos; ind++)
			{
				if(grados[ind] < min)
					min = grados[ind];
				if(grados[ind] > max)
					max = grados[ind];
			}
			gradoMax = max;
			gradoMin = min;
		}
		else //DE NUEVO - Si hay igual cantidad de grupos y de nodos -> Grafo Regular
		{
			gradoMax = gradoMin = cantNodos-1;
		}	
		gnd.setPorcentajeAdyacencia(gnd.matriz.getPorcentajeAdyacencia());
		//GrafoNDNP grafo = new GrafoNDNP(matriz, cantNodos, cantAristas, porcAdyacencia, gradoMax, gradoMax);
		return gnd;
		//return grafo
	}
	*/
	/*
	public GrafoNDNP generarNPartito(final int cantidadDeNodos, final int nPartito) {
		// recibo por parametro cantNodos (param 2)
		//GrafoNDNP grafo = new GrafoNDNP();
		//grafo.cantidadDeNodos = cantidadDeNodos;
		MatrizSimetrica matrizSimetrica = new MatrizSimetrica(cantidadDeNodos); //la matriz para el grafo (param 1)
		int cantidadDeAristas = 0; //cantidad de aristas para el grafo (param 3)
		double porcentajeAdyacencia = 100;
		int gradoMax = 0;
		int gradoMin = nPartito +1;
		int grado = 0;
		
		if (cantidadDeNodos == nPartito) {
			for (int fil = 0; fil < cantidadDeNodos; fil++)
				for (int col = fil + 1; col < cantidadDeNodos; col++) {
					matrizSimetrica.insertarArista(fil, col, cantidadDeNodos);
					cantidadDeAristas++;
				}

			
			for (int i = 0; i < nPartito; i++) {
				grado = matrizSimetrica.calcularGrado(i, cantidadDeNodos);
				if (grado > gradoMax) {
					gradoMax = grado;
				}
				if (grado < gradoMin) {
					gradoMin = grado;
				}
			}
			
		} else {
			if (cantidadDeNodos % nPartito == 0) {
				int grupos = nPartito;
				int nodosPorGrupo = cantidadDeNodos / nPartito;
				for (int i = 0; i < nodosPorGrupo; i++)
					for (int j = 0; j < nodosPorGrupo; j++) {
						matrizSimetrica.insertarArista(i, j + nodosPorGrupo, cantidadDeNodos);
						cantidadDeAristas++;
					}
				grupos -= 2;
				int nodoActual = 2 * nodosPorGrupo;
				int cantidad = nodoActual;
				while (grupos != 0) {
					for (int i = 0; i < nodosPorGrupo; i++) {
						for (int j = 0; j < cantidad; j++) {
							matrizSimetrica.insertarArista(nodoActual, j, cantidadDeNodos);
							cantidadDeAristas++;
						}
						nodoActual++;
					}
					cantidad += nodosPorGrupo;
					grupos--;
				}
				gradoMax = 0;
				gradoMin = nPartito + 1;
				int gradoTotal = 0;
				for (int i = 0; i < nPartito; i++) {
					gradoTotal = matrizSimetrica.calcularGrado(i, cantidadDeNodos);
					if (grado > gradoMax) {
						gradoMax = gradoTotal;
					}
					if (gradoTotal < gradoMin) {
						gradoMin = gradoTotal;
					}
				}
				
			} else {
				int grupos = nPartito;
				int nodosGrupoA = Math.round(cantidadDeNodos / (float) nPartito);
				int nodosGrupoB = Math.round(cantidadDeNodos / (float) nPartito);
				while (nodosGrupoA + nodosGrupoB > cantidadDeNodos)
					nodosGrupoB--;
				int aux = nodosGrupoA + nodosGrupoB;
				for (int i = 0; i < nodosGrupoA; i++)
					for (int j = 0; j < nodosGrupoB; j++) {
						matrizSimetrica.insertarArista(i, j + nodosGrupoA, cantidadDeNodos);
						cantidadDeAristas++;
					}
				grupos -= 2;
				int nodoActual = aux;
				int nodosGrupoN = 0;
				while (grupos != 0) {
					if (grupos != 1) {
						nodosGrupoN = Math.round(cantidadDeNodos / (float) nPartito);
					} else {
						nodosGrupoN = cantidadDeNodos - aux;
					}
					while (nodosGrupoN + aux > cantidadDeNodos) {
						nodosGrupoN--;
					}
					for (int i = 0; i < nodosGrupoN; i++) {
						for (int j = 0; j < aux; j++) {
							matrizSimetrica.insertarArista(nodoActual, j, cantidadDeNodos);
							cantidadDeAristas++;
						}
						nodoActual++;
					}
					aux += nodosGrupoN;
					grupos--;
				}
				gradoMax = 0;
				gradoMin = nPartito + 1;
				int gradoTotal = 0;
				for (int i = 0; i < nPartito; i++) {
					grado = matrizSimetrica.calcularGrado(i, cantidadDeNodos);
					if (grado > gradoMax) {
						gradoMax = grado;
					}
					if (grado < gradoMin) {
						gradoMin = grado;
					}
				}
			}
			
		}
	porcentajeAdyacencia = matrizSimetrica.getPorcentajeAdyacencia(); // (param 4)
	return new GrafoNDNP(matrizSimetrica, cantidadDeNodos, cantidadDeAristas, porcentajeAdyacencia, gradoMin, gradoMax );
	}
	*/
	
	/*
	@Override
	public GrafoNDNP generarNPartito(int cantidadNodos, int nPartito) {
		GrafoNDNP grafo = new GrafoNDNP(cantidadNodos);
		//grafo.cantidadNodos = cantidadNodos;
		grafo.matriz = new MatrizSimetrica(cantidadNodos);
		grafo.cantidadDeAristas = 0;
		grafo.porcentajeAdyacencia = 100;
		if (cantidadNodos == nPartito) {
			for (int fil = 0; fil < cantidadNodos; fil++)
				for (int col = fil + 1; col < cantidadNodos; col++) {
					grafo.matriz.insertarArista(fil, col, cantidadNodos);
					grafo.cantidadDeAristas++;
				}

			grafo.gradoMaximo = 0;
			grafo.gradoMinimo = nPartito + 1;
			int gr = 0;
			for (int i = 0; i < nPartito; i++) {
				gr = grafo.matriz.calcularGrado(i, cantidadNodos);
				if (gr > grafo.gradoMaximo) {
					grafo.gradoMaximo = gr;
				}
				if (gr < grafo.gradoMinimo) {
					grafo.gradoMinimo = gr;
				}
			}
			
		} else {
			if (cantidadNodos % nPartito == 0) {
				int islas = nPartito;
				int nodosPorIsla = cantidadNodos / nPartito;
				for (int i = 0; i < nodosPorIsla; i++)
					for (int j = 0; j < nodosPorIsla; j++) {
						grafo.matriz.insertarArista(i, j + nodosPorIsla, cantidadNodos);
						grafo.cantidadDeAristas++;
					}
				islas -= 2;
				int nodoActual = 2 * nodosPorIsla;
				int cantidad = nodoActual;
				while (islas != 0) {
					for (int i = 0; i < nodosPorIsla; i++) {
						for (int j = 0; j < cantidad; j++) {
							grafo.matriz.insertarArista(nodoActual, j, cantidadNodos);
							grafo.cantidadDeAristas++;
						}
						nodoActual++;
					}
					cantidad += nodosPorIsla;
					islas--;
				}
				grafo.gradoMaximo = 0;
				grafo.gradoMinimo = nPartito + 1;
				int gr = 0;
				for (int i = 0; i < nPartito; i++) {
					gr = grafo.matriz.calcularGrado(i, cantidadNodos);
					if (gr > grafo.gradoMaximo) {
						grafo.gradoMaximo = gr;
					}
					if (gr < grafo.gradoMinimo) {
						grafo.gradoMinimo = gr;
					}
				}
				
			} else {// (cantidadNodos % nPartito != 0)
				int islas = nPartito;
				int nodosIsla1 = Math.round(cantidadNodos / (float) nPartito);
				//int nodosIsla2 = Math.round(cantidadNodos / (float) nPartito);
				int nodosIsla2 = cantidadNodos - nodosIsla1;
				
				int acum = nodosIsla1 + nodosIsla2;
				for (int i = 0; i < nodosIsla1; i++)
					for (int j = 0; j < nodosIsla2; j++) {
						grafo.matriz.insertarArista(i, j + nodosIsla1, cantidadNodos);
						grafo.cantidadDeAristas++;
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
							grafo.matriz.insertarArista(nodoActual, j, cantidadNodos);
							grafo.cantidadDeAristas++;
						}
						nodoActual++;
					}
					acum += nodosNuevaIsla;
					islas--;
				}
				grafo.gradoMaximo = 0;
				grafo.gradoMinimo = nPartito + 1;
				int gr = 0;
				for (int i = 0; i < nPartito; i++) {
					gr = grafo.matriz.calcularGrado(i, cantidadNodos);
					if (gr > grafo.gradoMaximo) {
						grafo.gradoMaximo = gr;
					}
					if (gr < grafo.gradoMinimo) {
						grafo.gradoMinimo = gr;
					}
				}
			}
			
		}
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
	*/
}



