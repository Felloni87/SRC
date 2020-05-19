package recursivo;

import proyecto.Recorrido;

import java.util.ArrayList;
import java.util.List;

public class Ciudades {
    public static List<Recorrido> result = new ArrayList<Recorrido>();

    public static void main(String[] args) {
        List<String> listaA = new ArrayList<String>();
        List<String> listaB = new ArrayList<String>();
        List<String> tempA = new ArrayList<String>();
        List<String> tempB = new ArrayList<String>();
        listaB.add("2"); // pos 0
        listaB.add("3"); // pos 1
        listaB.add("8"); // pos 2

        // guardar ambas
        guardar(listaA, listaB);
        int indice = 0;
        tempA.addAll(listaA);
        tempB.addAll(listaB);
        int indiceNC = 0;

        while (indiceNC < listaB.size()) {

            while (indice < listaB.size()) {
                // for/while ir cambiando de a una las ciudades hasta que pasen todas las
                while (!listaB.isEmpty() && indice != listaB.size() && indiceNC < listaB.size()) {
                    if (indice < listaB.size()) {

                        if (indiceNC == 0) {
                            cambiar(listaB, listaA, indice);
                            // guardar
                            guardar(listaA, listaB);

                        } else {
                            if (listaB.size() > indiceNC) {

                                cambiar(listaB, listaA, indiceNC);
                                // guardar
                                guardar(listaA, listaB);
                                indiceNC++;
                            }
                        }
                    }
                }

                // comenzar con listas originales, suma indice
                indice++;
                listaA.clear();
                listaA.addAll(tempA);
                listaB.clear();
                listaB.addAll(tempB);
            }
            if (listaB.size() - 1 > indiceNC) {
                cambiar(listaB, listaA, indiceNC);

            }
            indiceNC++;
            indice = 0;
        }

        // no contiguas
        listaA.clear();
        listaA.addAll(tempA);
        listaB.clear();
        listaB.addAll(tempB);

        mostrarRecorridoMenor();
    }

    private static void cambiar(List<String> listaB, List<String> listaA, int indice) {
        listaA.add(listaB.remove(indice));
    }

    private static void guardar(List listaA, List listaB) {

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

    private static void mostrarRecorridoMenor() {
        System.out.println("COMIENZO BUSCAR MENOR: " + result.size());
        Recorrido menor;
        if (!result.isEmpty()) {
            menor = result.get(0);
            for (int i = 1; i < result.size(); i++) {
                Recorrido itemRes = result.get(i);
//				System.out.println("A " + itemRes.getListA());
//				System.out.println("B " + itemRes.getListB());
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
