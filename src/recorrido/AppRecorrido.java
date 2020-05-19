package recorrido;

import java.util.Scanner;

/**
 * Una empresa planifica recorridos en los 5 dias de la semana. Tiene recorridos
 * turisticos o transporte. Cada recorrido tiene un origen y un final
 * (Localidades) En el caso que el recorrido sea turistico tiene un nombre.
 * Ambos recorridos tienen un precio. Se pide ingresar los datos del recorrido
 * de cada de la semana usando una estructura de objetos con herencia por
 * teclado Mostrar los datos de todos los recorridos cargados
 *
 */

public class AppRecorrido {
    public static void main(String[] args) {

        Recorrido[] semana = new Recorrido[5];
        System.out.println("Sistema de recorridos semanales");
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("Tipo de recorrido (1. Turistico 2.Transporte");
            int tipo = sc.nextInt();

            System.out.println("Origen:");
            String origen = sc.next();
            System.out.println("Destino");
            String destino = sc.next();
            System.out.println("Precio");
            float precio = Float.valueOf(sc.next());

            switch (tipo) {
                case 1: {

                    System.out.println("Nombre:");
                    String nombre = sc.next();
                    semana[i] = new Turistico(origen, destino, precio, nombre);
                    break;
                }
                case 2:

                    semana[i] = new Transporte(origen, destino, precio);
                    break;

                default:
                    break;
            }
        }

        // Recorrer y mostrar resultado
        for (int i = 0; i < semana.length; i++) {
            System.out.print(semana[i]);
            if (semana[i] instanceof Turistico) {
                System.out.print(" (TURISTICO)");
            }
            else {
                System.out.print(" (TRANSPORTE)");
            }
            System.out.println();
        }

    }
}

