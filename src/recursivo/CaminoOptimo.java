package recursivo;

import proyecto.Recorrido;

import java.util.ArrayList;
import java.util.List;

public class CaminoOptimo {

    List<Recorrido> result = new ArrayList<Recorrido>();

    public static void main(String[] args) {
        CaminoOptimo co = new CaminoOptimo();
        List<String> listaA = new ArrayList<String>();
        List<String> listaB = new ArrayList<String>();
        listaB.add("2"); // pos 0
        listaB.add("3"); // pos 1
        listaB.add("8"); // pos 2
        co.analizarCaminos(listaB, listaA);
        co.mostrarRecorridoMenor();
    }

    private void analizarCaminos(List<String> listaA, List<String> listaB) {
        guardar(listaA, listaB);

        for (int i = 0; i < listaA.size(); i++) {
            for (int j = 0; j < listaB.size(); j++) {
                guardar(listaA, listaB);
            }

            String nodo = listaA.remove(i);
            listaB.add(nodo);
        }


    }


    private void guardar(List listaA, List listaB) {

        System.out.println("guardar --- A: " + listaA + " --- B: " + listaB);

        Recorrido recorrido = new Recorrido();
        List liA = new ArrayList();
        liA.addAll(listaA);
        List liB = new ArrayList();
        liB.addAll(listaB);
        recorrido.setListA(liA);
        recorrido.setListB(liB);
        System.out.println(liA);
        System.out.println(liB);
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
