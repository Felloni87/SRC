package recaudacion;

public class Recaudacion {

    private int efectivo;
    private int tarjeta;

    public Recaudacion(int efe, int tar) {
        efectivo = efe;
        tarjeta = tar;
    }

    public int getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(int efectivo) {
        this.efectivo = efectivo;
    }

    public int getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(int tarjeta) {
        this.tarjeta = tarjeta;
    }

}
