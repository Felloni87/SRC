package proyecto;

import java.util.Scanner;

public class Ejercicio1Constructor {
    private int valor1;
    private int valor2;

    public Ejercicio1Constructor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese valor 1: ");
        valor1 = sc.nextInt();
        System.out.println("Ingrese valor 2: ");
        valor2 = sc.nextInt();
        int total = valor1 + valor2;
        System.out.println("El total es: " + total);
        sc.close();
    }

    // main = control + espacio
    public static void main(String[] args) {
        Ejercicio1Constructor ej1 = new Ejercicio1Constructor();
    }
}


