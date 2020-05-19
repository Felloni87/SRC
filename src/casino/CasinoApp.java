package casino;

import java.util.Random;

public class CasinoApp {
    // Simular la ejecucion de la ruleta y acumular las primeras 100
    // ejecuciones.
    // Mostrar los tres numeros que salieron mas veces
    // Usamos Ramdom y vectores.
    public static void main(String[] args) {

        Numero[] ruleta = new Numero[37];
        for (int i = 0; i < 37; i++) {
            ruleta[i] = new Numero(i);
        }

        for (int i = 0; i < 100; i++) {
            int sorteo = aleatorio(37);
            ruleta[sorteo].acumular();
        }

        for (int i = 0; i < ruleta.length; i++) {
            System.out.println(ruleta[i]);
        }

        Numero aux;
        for (int i = 0; i < ruleta.length; i++) {
            for (int j = 0; j < ruleta.length - 1; j++) {
                if (ruleta[i].getContador() > ruleta[j].getContador()) {
                    aux = ruleta[j];
                    ruleta[j] = ruleta[i];
                    ruleta[i] = aux;
                }
            }
        }
        System.out.println();
        System.out.println("Los tres numeros mas salidores son:");
        for (int i = 0; i < 3; i++) {
            System.out.println(ruleta[i]);

        }
    }

    public static int aleatorio(int upperRange) {
        Random random = new Random();
        return random.nextInt(upperRange);
    }

}
