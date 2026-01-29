package ejercicio5;

import java.util.Scanner;

public class Ejercicio5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n;

        do {
            System.out.print("Introduce un número positivo: ");
            n = sc.nextInt();
        } while (n <= 0);

        int suma = 0;
        int numeroPar = 2;

        for (int i = 0; i < n; i++) {
            suma += numeroPar;
            numeroPar += 2;
        }

        System.out.println("Suma de los " + n + " primeros números pares: " + suma);
        sc.close();
    }
}