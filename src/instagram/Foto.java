/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instagram;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Manuel Del Pino Torres
 */
public class Foto {

    //Me decanto en fotos por usar un arraylist como coleccion para 
    //introducir dinamicacmente los usuarios en etiquetados y likes 
    //ademas de poder tener asi un orden
    //Las variables decido que sean privadas para que solo se pueda
    //acceder a ellas desde la misma clase, obligando asi a usar metodos get y set.
    private String id;
    //uso localDate para quedarme facilmente con la fecha de creacion
    //ya que considero que es la forma mas comoda de trabajar con fechas en Java.
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
//getters y setters para acceder y modificar la informacion.

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

    //Sobreescribo el metodo toString de la clase foto para poder 
    //sacar la informacion que deseo por pantalla
    @Override
    public String toString() {
        return "\n{Foto \n" + "Identificador: " + this.id + "\n" + "Fecha creacion: " + this.fechaCreacion + "\n}";
    }
}
