/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instagram;

import java.util.ArrayList;

/**
 *
 * @author Manuel Del Pino Torres
 */
public class Usuario {
//De nuevo variables privadas al igual que en la clase foto para aumentar la seguridad
//uso ArrayList para almacenar de manera dinamica y con un orden establecido fotos,seguidores y seguidos

    private String email;
    //Las contraseñas se tienen que cifrar, pero para mostrar el funcionamiento no lo he visto necesario.
    private String password;
    private ArrayList<Foto> fotos;
    private ArrayList<Usuario> seguidores;
    private ArrayList<Usuario> seguidos;

    //uso sets en el constructor porque me parece mas versatil y adaptable que simplemente igualar
    public Usuario(String email, String password) {
        this.setEmail(email);
        this.setPassword(password);
        this.setFotos(new ArrayList<>());
        this.setSeguidores(new ArrayList<>());
        this.setSeguidos(new ArrayList<>());

    }

//Getters y setters
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Foto> getFotos() {
        return this.fotos;
    }

    public void setFotos(ArrayList<Foto> fotos) {
        this.fotos = fotos;
    }

    public ArrayList<Usuario> getSeguidores() {
        return this.seguidores;
    }

    public void setSeguidores(ArrayList<Usuario> seguidores) {
        this.seguidores = seguidores;
    }

    public ArrayList<Usuario> getSeguidos() {
        return this.seguidos;
    }

    public void setSeguidos(ArrayList<Usuario> seguidos) {
        this.seguidos = seguidos;
    }
//En este simple metodo igualo con un equalsignorecase 
// la contraseña de la clase con la que pasamos por parametro
// asi no se tiene en cuenta mayusculas o minusculas y devuelve
// directamente un booleano

    public boolean validarPassword(String password) {
        return this.password.equalsIgnoreCase(password);
    }
//Metodo toString para mostrar usuarios, con su email

    @Override
    public String toString() {
        return "Usuario:" + this.email;
    }
}
