package ejercicio7;

import java.util.Scanner;

public class Ejercicio7 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char continuar;

        do {
            System.out.print("Operador (+ - * /): ");
            char op = sc.next().charAt(0);

            System.out.print("Primer número: ");
            double a = sc.nextDouble();

            System.out.print("Segundo número: ");
            double b = sc.nextDouble();

            double resultado;

            switch (op) {
                case '+':
                    resultado = a + b;
                    break;
                case '-':
                    resultado = a - b;
                    break;
                case '*':
                    resultado = a * b;
                    break;
                case '/':
                    if (b == 0) {
                        System.out.println("La división no puede realizarse porque el divisor es cero");
                        resultado = Double.NaN;
                    } else {
                        resultado = a / b;
                    }
                    break;
                default:
                    System.out.println("Opción incorrecta");
                    resultado = Double.NaN;
            }

            System.out.println("Resultado: " + resultado);

            System.out.print("¿Desea realizar otra operación? (s/n): ");
            continuar = sc.next().charAt(0);

        } while (continuar == 's');

        sc.close();
    }
}