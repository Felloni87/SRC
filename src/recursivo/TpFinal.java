package recursivo;

import java.util.ArrayList;
import java.util.List;

public class TpFinal {

    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<Integer>();
        lista.add(new Integer(3));
        lista.add(new Integer(5));
        lista.add(new Integer(9));

        List<Integer> aTemp = new ArrayList<Integer>();
        List<Integer> bTemp = new ArrayList<Integer>();

        bTemp.addAll(lista);
        guardar(aTemp, bTemp);
        int index = 0;
        while (index < lista.size() - 1) {

            for (int i = index; i < lista.size(); i++) {
//			for (int j = 0; j < lista.size() - 1; j++) {

                if (!bTemp.isEmpty()) {
                    aTemp.add(bTemp.remove(0));
                    guardar(aTemp, bTemp);
                }
//			}
            }
            index++;
            aTemp = new ArrayList<Integer>();
            bTemp = lista;

        }

    }

    private static void guardar(List<Integer> aTemp, List<Integer> bTemp) {
        System.out.println(aTemp);
        System.out.println(bTemp);
        System.out.println("---------");
    }
}
