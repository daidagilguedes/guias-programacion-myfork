package ejercicio9;

import java.util.Scanner;

public class Ejercicio9 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[10];

        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Introduce número " + (i + 1) + ": ");
            numeros[i] = sc.nextInt();
        }

        int max = numeros[0];
        int min = numeros[0];
        int suma = 0;

        for (int n : numeros) {
            suma += n;
            if (n > max) max = n;
            if (n < min) min = n;
        }

        double media = (double) suma / numeros.length;

        System.out.println("Máximo: " + max);
        System.out.println("Mínimo: " + min);
        System.out.println("Media: " + media);

        sc.close();
    }
}