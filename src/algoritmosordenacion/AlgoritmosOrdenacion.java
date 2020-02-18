/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosordenacion;

import java.util.Random;

/**
 *
 * @author Javier
 */
public class AlgoritmosOrdenacion {

    int[] nums = {5, 4, 3, 2, 1};

    int[] arrayParaBurbuja;
    int[] arrayParaInsercion;

    //Crea un array de tantos números aleatorios como le digas
    public int[] generaRandom(int dimension) {
        int[] numeros = new int[dimension];
        Random r = new Random();
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = r.nextInt();
        }
        return numeros;
    }

    //Algoritmo de la burbuna optimizado teniendo en cuenta que si no hay intercambio
    //de números es que está ordanado y que a n vueltas los n números mayores están ordenados
    //al final
    public int[] burbuja(int[] numeros) {

        int aux = 0;//Lo utilizamos para hacer el intercambio

        int nVueltas = numeros.length - 1;
        while (true) {
            boolean ordenado = true;
            for (int j = 0; j < nVueltas; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    aux = numeros[j + 1];
                    numeros[j + 1] = numeros[j];
                    numeros[j] = aux;
                    ordenado = false;
                }
            }

            if (ordenado || nVueltas <= 1) {
                return numeros;
            }

            nVueltas--;
        }

    }


    //Ordenación por insercción directa
    public int[] insercionDirecta2(int[] numeros) {
        int aux = 0;
        for (int i = 1; i < numeros.length; i++) {
            aux = numeros[i];
            int j = i;
            while (j > 0 && numeros[j - 1] < aux) {
                numeros[j] = numeros[j - 1];
                j--;
            }
            numeros[j] = aux;
        }
        return numeros;
    }

    //Ordenación por insercción directa
    public int[] insercionDirecta(int[] numeros) {
        for (int i = 1; i < numeros.length; i++) {
            int aux = numeros[i];
            int j = i;
            while (j > 0 && numeros[j - 1] > aux) {
                numeros[j] = numeros[j - 1];
                j--;
            }
            numeros[j] = aux;
        }
        return numeros;
    }
    
    public void shellSort(int[] numeros){
        int salto, aux;
        boolean intercambio;
        for(salto = numeros.length/2; salto !=0; salto/=2){
            intercambio=true;
            while(intercambio){
                intercambio=false;
                for (int i = salto; i < numeros.length; i+=salto) {
                    if(numeros[i-salto]>numeros[i]){
                        //si los dos números están desordenados entre sí
                        //Los intercambio y lo indico
                        aux=numeros[i];
                        numeros[i]=numeros[i-salto];
                        numeros[i-salto]= aux;
                        intercambio=true;
                    }
                }
            }
            
        }
    }

    public void imprimir(int[] n) {
        for (int i = 0; i < n.length; i++) {
            System.out.print(n[i] + " ");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        AlgoritmosOrdenacion miAlgoritmo = new AlgoritmosOrdenacion();
        //miAlgoritmo.imprimir(miAlgoritmo.insercionDirecta2(miAlgoritmo.nums));

        //Pruebas de rendimiento
        int rangoPrueba = 1000;  //Número de datos que probamos
        int[] numeros = miAlgoritmo.generaRandom(rangoPrueba);
        miAlgoritmo.arrayParaBurbuja = new int[rangoPrueba];
        miAlgoritmo.arrayParaInsercion = new int[rangoPrueba];

        for (int i = 0; i < rangoPrueba; i++) {
            miAlgoritmo.arrayParaBurbuja[i] = numeros[i];
            miAlgoritmo.arrayParaInsercion[i] = numeros[i];
        }

        //Aquí ya tengo dos copias exactas del array de datos aleatorios
        System.out.println("Empieza la insercion");
        long tiempoInicio = System.currentTimeMillis();
        miAlgoritmo.insercionDirecta2(miAlgoritmo.arrayParaInsercion);
        long tiempofinal = System.currentTimeMillis();

        System.out.println("La insercion ha tardado: " + (tiempofinal - tiempoInicio));

        System.out.println("Empieza burbuja");
        tiempoInicio = System.currentTimeMillis();
        miAlgoritmo.burbuja(miAlgoritmo.arrayParaBurbuja);
        tiempofinal = System.currentTimeMillis();

        System.out.println("La burbuja directa ha tardado: " + (tiempofinal - tiempoInicio));
    }

}
