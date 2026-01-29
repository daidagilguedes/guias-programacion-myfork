package ejercicio12;

import java.util.Scanner;

public class Ejercicio12 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[][] matriz = new int[3][3];

        System.out.println("Introduce los valores de la matriz:");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = sc.nextInt();
            }
        }

        System.out.print("Introduce el número a buscar: ");
        int buscar = sc.nextInt();

        boolean encontrado = false;

        for (int i = 0; i < 3 && !encontrado; i++) {
            for (int j = 0; j < 3; j++) {
                if (matriz[i][j] == buscar) {
                    System.out.println("Encontrado en fila " + i + ", columna " + j);
                    encontrado = true;
                    break;
                }
            }
        }

        if (!encontrado) {
            System.out.println("El número no se encuentra en la matriz");
        }

        sc.close();
    }
}