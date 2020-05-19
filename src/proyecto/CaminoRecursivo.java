package proyecto;

import java.util.ArrayList;
import java.util.List;

public class CaminoRecursivo {

    List<Recorrido> result = new ArrayList<Recorrido>();

    public static void main(String[] args) {
        CaminoRecursivo cr = new CaminoRecursivo();
        List<String> listaB = new ArrayList<String>();
        listaB.add("2"); // pos 0
        listaB.add("3"); // pos 1
        listaB.add("8"); // pos 2
//		listaB.add("8"); // pos 3
//		listaB.add("1"); // pos 4

        cr.buscar(new ArrayList(), listaB, 0, 0);

        System.out.println("opciones: " + cr.result.size());
        cr.mostrarRecorridoMenor();

    }

    public void buscar(List listaA, List listaB, int indexA, int indexB) {
        // pos A es menor que el tama�o de A
        if (indexA < listaA.size()) {
            guardar(listaA, listaB);
            while (listaA.size() > 1) {
//				int ultimo = listaA.size() - 1;
                cambiar(listaA, listaB, 0);
                System.out.println("cambiar 2");
                guardar(listaA, listaB);

            }
            System.out.println("cambiar b 1");
            cambiar(listaB, listaA, 0);
            guardar(listaA, listaB);
            System.out.println("cambiar b 2");

            cambiar(listaB, listaA, 0);
        } else {
            // si pos B es menor que el tama�o B
            if (indexB < listaB.size()) {
                // llama recursivo con B+1
                buscar(listaA, listaB, indexA, indexB + 1);
                while (indexB < listaB.size()) {
                    System.out.println("cambiar 1 " + indexB);
                    cambiar(listaB, listaA, 0);
                }
                buscar(listaA, listaB, indexA, indexB);

            } else {
                guardar(listaA, listaB);
            }
        }
    }

    private void cambiar(List<String> listaOrigen, List listaDest, int indexOrigen) {
        String valor = listaOrigen.remove(indexOrigen);
        listaDest.add(valor);
//		System.out.println("cambiar [" + valor + " ]  -- A: " + listaA + "-- B: " + listaB);
        System.out.println("           [" + valor + " ] ");

    }

    private void guardar(List listaA, List listaB) {

        System.out.println("guardar --- A: " + listaA + " --- B: " + listaB);

        Recorrido recorrido = new Recorrido();
        recorrido.setListA(listaA);
        recorrido.setListB(listaB);
        System.out.println(recorrido.getListA());
        System.out.println(recorrido.getListB());
        System.out.println("Distancia: " + recorrido.getDistanciaTotalRecorrido());
        result.add(recorrido);
    }

    private void mostrarRecorridoMenor() {
        System.out.println("COMIENZO BUSCAR MENOR: " + result.size());
        Recorrido menor;
        if (!result.isEmpty()) {
            menor = result.get(0);
            for (int i = 1; i < result.size(); i++) {
                Recorrido itemRes = result.get(i);
                System.out.println("A " + itemRes.getListA());
                System.out.println("B " + itemRes.getListB());
                if (itemRes.getDistanciaTotalRecorrido() < menor.getDistanciaTotalRecorrido()) {
                    menor = itemRes;
                }
            }

            System.out.println("La menor distancia es: " + menor.getDistanciaTotalRecorrido());
            System.out.println("Lista A: " + menor.getListA());
            System.out.println("Lista B: " + menor.getListB());
        }

    }

}
