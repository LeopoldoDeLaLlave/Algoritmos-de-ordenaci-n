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

    int[] nums = {13, 27, 455, 621, 23, 1, 15};

    public int[] ordenacionBurbuja(int[] numeros) {

        int aux = 0;
        boolean cambio = true;

        while (cambio) {
            cambio = false;
            for (int j = 0; j < numeros.length - 1; j++) {
             
                if (numeros[j] > numeros[j + 1]) {
                    aux = numeros[j ];
                    numeros[j] = numeros[j+1];
                    numeros[j + 1] = aux;
                    cambio = true;

                }
            }
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

        miAlgoritmo.imprimir(miAlgoritmo.ordenacionBurbuja(miAlgoritmo.nums));

    }

}
