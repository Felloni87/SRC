package recaudacion;

import java.util.Random;

public class App {

    // Guardar un objeto de clase Recaudacion por dia del a�o
    // considerando un a�o de 360 dias y 12 meses de 30 dias cada uno
    // El objeto recaudacion debera tener importe en efectivo y tarjeta
    // cargados aleatoriamente
    // 1. Mostrar totales de recaudacion de ultimos 6 meses
    // 2. Mostrar totales de recaudacion de mes 4

    public static void main(String[] args) {
        Recaudacion[] rec = new Recaudacion[360];
        for (int i = 0; i < rec.length; i++) {
            rec[i] = new Recaudacion(App.aleatorio(50), App.aleatorio(50));
        }

        float total = 0;
        for (int i = 180; i < rec.length; i++) {
            total += rec[i].getEfectivo() + rec[i].getTarjeta();
        }
        System.out.println("1. Totales ultimos 6 meses: " + total);

        float total4 = 0;
        for (int i = 30 * 3; i < 30 * 4; i++) {
            total4 += rec[i].getEfectivo() + rec[i].getTarjeta();
        }
        System.out.println("2. Totalmes mes 4: " + total4);

        for (int i = 0; i < rec.length; i++) {
            if (i % 7 == 0) {
                System.out.println();
            }
            System.out.print(rec[i].getEfectivo() + " ");
        }

    }

    public static int aleatorio(int upperRange) {
        Random random = new Random();
        return random.nextInt(upperRange);
    }
}
