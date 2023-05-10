/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package instagram;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Manuel Del Pino Torres
 */
public class Instagram {

    private ArrayList<Usuario> usuariosPlataforma;
    private ArrayList<Foto> fotosPlataforma;

    //Al crear la plataforma el numero de seguidores interpreto que sera 0
    public Instagram() {
        this.setUsuariosPlataforma(new ArrayList<>());
    }

    public ArrayList<Usuario> getUsuariosPlataforma() {
        return this.usuariosPlataforma;
    }

    public void setUsuariosPlataforma(ArrayList<Usuario> usuariosPlataforma) {
        this.usuariosPlataforma = usuariosPlataforma;
    }

    public ArrayList<Foto> getFotosPlataforma() {
        return this.fotosPlataforma;
    }

    public void setFotosPlataforma(ArrayList<Foto> fotosPlataforma) {
        this.fotosPlataforma = fotosPlataforma;
    }

    //Si el usuario existe devolvera una posicion, si no devolvera un -1
    //podria usar un for ecach pero para poder reutilizar el metodo en para agregar foto devuelvo posicion o -1
    public int existeUsuario(String email) {
        for (int i = 0; i < this.usuariosPlataforma.size(); i++) {
            if (this.usuariosPlataforma.get(i).getEmail().equalsIgnoreCase(email)) {
                return i;
            }
        }
        return -1;
    }

    public boolean agregarUsuario(String email, String password) {

        if (existeUsuario(email) > -1) {
            this.getUsuariosPlataforma().add(new Usuario(email, password));
            return true;
        }
        return false;
    }

    public int agregarFoto(String email, String password, String idFoto, LocalDate fechaCreacion) {
        int posicionUsuario = existeUsuario(email);
        if (posicionUsuario > -1) {
            //compruebo si la contraseña es correcta, en caso de no serlo devolvera un -2
            if (this.usuariosPlataforma.get(posicionUsuario).getPassword().equalsIgnoreCase(password)) {
                this.usuariosPlataforma.get(posicionUsuario).getFotos().add(new Foto(idFoto, fechaCreacion));
                return 1;
            }
            return -2;
        }
        return -1;
    }
}
