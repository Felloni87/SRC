package usuario;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Usuario {

    public Date getFechaContrase;
    public Date getFechaContrasen;
    private String nombre;
    private String contraseña;
    private Date fechaNacimiento;
    private Date fechaContraseña;

    public Usuario(String nombre, Date fechaNacimiento, String contraseña) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.contraseña = contraseña;
        this.fechaContraseña = new Date();
    }


    public Date getFechaContraseña() {
        return fechaContraseña;
    }


    public void setFechaContraseña(Date fechaContraseña) {
        this.fechaContraseña = fechaContraseña;
    }


    public String getContraseña() {
        return contraseña;
    }


    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat( usuario.Constantes.FORMATO_FECHA_STD);
        // format pasa de data a string
        return nombre + " " + sdf.format(fechaNacimiento);
    }
}
