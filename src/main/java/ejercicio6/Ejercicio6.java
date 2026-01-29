package ejercicio6;

import java.util.Scanner;

public class Ejercicio6 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce un número: ");
        int num = sc.nextInt();

        boolean primo = num > 1;

        for (int i = 2; i <= Math.sqrt(num) && primo; i++) {
            if (num % i == 0) {
                primo = false;
            }
        }

        if (primo) {
            System.out.println("El número es primo");
        } else {
            System.out.println("El número no es primo");
        }

        sc.close();
    }
}