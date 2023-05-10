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

    private String email;
    private String password;
    private ArrayList<Foto> fotos;
    private ArrayList<Usuario> seguidores;
    private ArrayList<Usuario> seguidos;

    /*DECIR PORQUE HE USADO ARRAY LIST*/
    public Usuario(String email, String password) {
        this.setEmail(email);
        this.setPassword(password);
        this.setFotos(new ArrayList<>());
        this.setSeguidores(new ArrayList<>());
        this.setSeguidos(new ArrayList<>());

    }

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

    public boolean validarPassword(String password) {
        return this.password.equalsIgnoreCase(password);
    }

}
