package proyecto;

import java.util.Scanner;

public class Envio {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("SISTEMA DE ENVIOS");
        System.out.println("=================");
        System.out.println();
        System.out.print("Peso del envio:");
        int peso = sc.nextInt();
        System.out.println();
        if (peso > 5000) {
            System.out.println("No se da servicio para ese peso");
        }
        else {
            System.out.println("Zona del envio:");
            System.out.println("1) America del norte");
            System.out.println("2) America central");
            System.out.println("3) America del sur");
            System.out.println("4) Europa");
            System.out.println("5) Otro");
            System.out.print("Ingrese n�mero de opcion:");
            int opcionZ = sc.nextInt();
            float costo;
            switch (opcionZ) {
                case 1:
                    costo = 11 * peso;
                    break;
                case 2:
                    costo = 10 * peso;
                    break;
                case 3:
                    costo = 12 * peso;
                    break;
                case 4:
                    costo = 24 * peso;
                    break;
                default:
                    costo = 27 * peso;
                    break;
            }

            System.out.println("Costo:" + costo);
        }


    }
}
