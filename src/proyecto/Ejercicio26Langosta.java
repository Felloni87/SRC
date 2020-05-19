package proyecto;

import java.util.Scanner;

public class Ejercicio26Langosta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese cantidad de personas (0=salir)");
        int numPer = sc.nextInt();
        int total = 0;
        while (numPer != 0) {
            if (numPer > 300) {
                total = numPer * 750;
            } else {
                if (numPer > 200) {
                    total = numPer * 850;
                } else {
                    total = numPer * 950;
                }
            }
            System.out.println("Total a pagar es:" + total);
            System.out.println();
            System.out.println("Ingrese cantidad de personas (0=salir)");
            numPer = sc.nextInt();
        }
    }
}


