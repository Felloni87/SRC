package interfaz1;

import java.util.ArrayList;

public class Cliente implements Ordenable {

    private int id;
    private String nombre;
    private ArrayList<String> cuentas = new ArrayList<String>();

    public void agregarCuenta(String cuenta) {
        cuentas.add(cuenta);
        cuentas.size();
    }

    @Override
    public void ordenarPorCodigo() {
        // TODO Auto-generated method stub

    }
    @Override
    public void ordenarAlfabetico() {
        // TODO Auto-generated method stub

    }

}
