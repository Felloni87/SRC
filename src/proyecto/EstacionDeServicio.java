package proyecto;

import java.util.Scanner;

public class EstacionDeServicio {
    public static void main(String[] args) {

        int[][] matriz = new int[3][3];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = 0; // Para inicializar la matriz y ponerla en 0
            }
        }
        int totalPorNafta[] = { 0, 0, 0 }; // Totales por Nafta
        int totalPorEstacion[] = { 0, 0, 0 }; // Totales por Estacion
        String nombres[] = { "Centro", "Norte", "Sur" };
        String[] naftas = { "Gasoil", "Super", "Premium" };
        System.out.println("Ingrese cantidad de litros: ");
        Scanner scan = new Scanner(System.in);
        int litros = scan.nextInt();

        while (litros != 0) { // al ingresar 0, se termina el loop
            System.out.println("Ingrese tipo de nafta: 0= Gasoil, 1= Super , 2= Premium ");
            int nafta = scan.nextInt();
            int costoTotal = 0;

            switch (nafta) {
                case 0:
                    costoTotal = litros * 10;
                    break;
                case 1:
                    costoTotal = litros * 20;
                    break;
                case 2:
                    costoTotal = litros * 40;
                    break;

            }

            System.out.println("Ingrese estaci�n de Servicio: 0) Estacion A, 1) Estacion B, 2) Estacion C");

            int estacion = scan.nextInt();

            matriz[nafta][estacion] += costoTotal; // Costos totales por Nafta y Estacion
            totalPorNafta[nafta] += costoTotal;
            totalPorEstacion[estacion] += costoTotal;

            System.out.println("Ingrese cantidad de litros: ");
            litros = scan.nextInt();

        }

        System.out.println("Total ganado por Estacion");

        for (int i = 0; i < totalPorEstacion.length; i++) {
            System.out.println("Estacion " + nombres[i] + ": " + totalPorEstacion[i]);
        }

        System.out.println("Total ganado por Tipo de Nafta");
        for (int i = 0; i < totalPorNafta.length; i++) {
            System.out.println("Nafta: " + naftas[i] + " " + totalPorNafta[i]);
        }

        System.out.println("Tipo de nafta m�s vendido");
        int masVendido = 0;
        int indiceMasVendido = 0;

        for (int i = 0; i < totalPorNafta.length; i++) {
            if (totalPorNafta[i] > masVendido) {
                masVendido = totalPorNafta[i];
                indiceMasVendido = i;
            }
        }

        System.out.println(naftas[indiceMasVendido] +": " + masVendido);

    }

}
