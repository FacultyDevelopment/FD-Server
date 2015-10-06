package Clases;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String correo;
    private String password;
    private String nombre;

    public Usuario() {
    }

    public Usuario(String correo, String password, String nombre) {
        this.correo = correo;
        this.password = password;
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "Correo: "+ correo + "Password: "+ password + "\n";
    }

}
