package ejercicio3;

import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce un número entero: ");
        int num = sc.nextInt();

        if (num % 2 == 0) {
            System.out.println("Número par");
        } else {
            System.out.println("Número impar");
        }

        if (num == 0) {
            System.out.println("Número cero");
        } else {
            System.out.println("Número distinto de cero");
        }

        if (num > 100) {
            System.out.println("Número elevado");
        } else {
            System.out.println("Número bajo");
        }

        sc.close();
    }
}