package ejercicio8;

import java.util.Scanner;

public class Ejercicio8 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el número del DNI: ");
        int dni = sc.nextInt();

        char[] letras = {
            'T','R','W','A','G','M','Y','F','P','D','X',
            'B','N','J','Z','S','Q','V','H','L','C','K','E'
        };

        int resto = dni % 23;
        System.out.println("La letra del DNI es: " + letras[resto]);

        sc.close();
    }
}
