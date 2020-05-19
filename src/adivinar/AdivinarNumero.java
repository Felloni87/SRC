package adivinar;

import java.util.Random;
import java.util.Scanner;

public class AdivinarNumero {
    public static void main(String[] args) {

        // calcular numero en forma aleatoria
//		int numAleatorio = new Random().nextInt(10);
        NumeroAleatorio na = new NumeroAleatorio(new Random().nextInt(10));

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese valor para adivinar");
        int intento = sc.nextInt();

        // ingresar intento mientras sea diferente al numero sorteado, hacer bucle
        while (intento != na.getValor()) {

            // si no coincide -> Acumular intentos
            na.acumularIntento();

            System.out.println("Ingrese valor ");
            intento = sc.nextInt();

        }

        // si coincide, salir del bucle y mostrar resultados
        System.out.println("Acerto el numero en " + na.getIntentos() + " intentos");
    }
}


