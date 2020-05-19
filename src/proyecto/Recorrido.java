package proyecto;

import java.util.List;

public class Recorrido {
    List<String> listA;
    List<String> listB;

    public int getDistanciaTotalRecorrido() {
        int totalA, totalB, total = 0;
        totalA = calcularDistancia(listA);
        totalB = calcularDistancia(listB);
//		System.out.println("Distancias: listaA= " + totalA + " listaB= " + totalB);
        total = totalA + totalB;
        return total;
    }

    private int calcularDistancia(List<String> list) {
        int total = 0;
        if (list.size() > 1) {
            for (int i = 1; i < list.size(); i++) {
                total += (Integer.parseInt(list.get(i)) - Integer.parseInt(list.get(i - 1)));
            }
        }

        return total;
    }

    public List<String> getListA() {
        return listA;
    }

    public void setListA(List<String> listA) {
        this.listA = listA;
    }

    public List<String> getListB() {
        return listB;
    }

    public void setListB(List<String> listB) {
        this.listB = listB;
    }

}


