package ejercicio_1;

import java.util.Scanner;

public class Ejercicio_1 {
    public static void main(String[] args) {

        System.out.println("Aprendiendo Java");

        System.out.println("""
                Este es mi primer programa en Java
                """);

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce tu edad: ");
        int edad = sc.nextInt();
        sc.nextLine();

        System.out.print("Introduce tu nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Introduce tu nota: ");
        double nota = sc.nextDouble();

        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Nota: " + nota);

        sc.close();
    }
}

