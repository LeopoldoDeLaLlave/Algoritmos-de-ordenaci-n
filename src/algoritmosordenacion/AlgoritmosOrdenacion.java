/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosordenacion;

/**
 *
 * @author Javier
 */
public class AlgoritmosOrdenacion {

    int[] nums = {3,1,5,2,4};

    //Algoritmo de la burbuna optimizado teniendo en cuenta que si no hay intercambio
    //de números es que está ordanado y que a n vueltas los n números mayores están ordenados
    //al final
    public int[] burbuja(int[] numeros) {
        
        int aux = 0;//Lo utilizamos para hacer el intercambio

        int nVueltas = numeros.length - 1;
        while(true) {
            boolean ordenado = true;
            for (int j = 0; j < nVueltas; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    aux = numeros[j + 1];
                    numeros[j + 1] = numeros[j];
                    numeros[j] = aux;
                    ordenado = false;
                }
            }
            System.out.println(nVueltas);
            if (ordenado || nVueltas<=1) {
                return numeros;
            }
            
            nVueltas--;
        }
       
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
        miAlgoritmo.imprimir(miAlgoritmo.burbuja(miAlgoritmo.nums));

    }

}
