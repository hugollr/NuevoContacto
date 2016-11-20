package com.llavador.nuevocontacto;

import java.util.ArrayList;

/**
 * Created by unhugo on 20/11/16.
 */

public class Contacto {
    private String nombre;
    private String fecha;
    private String telefono;
    private String email;
    private String descripcion;

    public Contacto() {
        this.nombre = "";
        this.fecha = "";
        this.telefono = "";
        this.email = "";
        this.descripcion = "";
    }

    public Contacto(String nombre, String fecha, String telefono, String email, String descripcion) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.telefono = telefono;
        this.email = email;
        this.descripcion = descripcion;
    }

    public Contacto(ArrayList<String> datos){
        this.nombre = datos.get(0);
        this.fecha = datos.get(1);
        this.telefono = datos.get(2);
        this.email = datos.get(3);
        this.descripcion = datos.get(4);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public  ArrayList<String> nombres(){
        ArrayList<String> salida = new ArrayList<>();
        salida.add("nombre");
        salida.add("fecha");
        salida.add("telefono");
        salida.add("email");
        salida.add("descripcion");

        return salida;
    }

    public ArrayList<String> valores(){
        ArrayList<String> salida = new ArrayList<>();
        salida.add(nombre);
        salida.add(fecha);
        salida.add(telefono);
        salida.add(email);
        salida.add(descripcion);

        return salida;
    }
}
