/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instagram;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author Manuel Del Pino Torres
 */
public class Foto {

    private String id;
    private LocalDate fechaCreacion;
    private ArrayList<Usuario> etiquetados;
    private ArrayList<Usuario> likes;

    //Realizo una sobrecarga de constructores para poder crear fotos con la fecha de creacion por defecto y otras
    //con una fecha establecida por parametro.
    public Foto(String id) {
        this.id = id;
        this.setEtiquetados(etiquetados);
        this.setFechaCreacion(LocalDate.now());
        this.setLikes(new ArrayList<>());
    }

    public Foto(String id, LocalDate fechaCreacion) {
        this.id = id;
        this.setEtiquetados(new ArrayList<>());
        this.setFechaCreacion(fechaCreacion);
        this.setLikes(new ArrayList<>());
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFechaCreacion() {
        return this.fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public ArrayList<Usuario> getEtiquetados() {
        return this.etiquetados;
    }

    public void setEtiquetados(ArrayList<Usuario> etiquetados) {
        this.etiquetados = etiquetados;
    }

    public ArrayList<Usuario> getLikes() {
        return this.likes;
    }

    public void setLikes(ArrayList<Usuario> likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "\n{Foto \n" + "Identificador: " + this.id + "\n" + "Fecha creacion: " + this.fechaCreacion + "\n}";
    }
}
