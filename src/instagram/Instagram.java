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

    //uso un arraylist para añadir de forma dinamica los usuarios y poder acceder a ellos por posicion
    private ArrayList<Usuario> usuariosPlataforma;

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

    //Si el usuario existe devolvera una posicion, si no devolvera un -1
    public int existeUsuario(String email) {
        for (int i = 0; i < this.usuariosPlataforma.size(); i++) {
            if (this.usuariosPlataforma.get(i).getEmail().equalsIgnoreCase(email)) {
                return i;
            }
        }
        return -1;
    }

    //compruebo que el usuario no exista para añadirlo
    public boolean agregarUsuario(String email, String password) {

        if (existeUsuario(email) < 0) {
            this.getUsuariosPlataforma().add(new Usuario(email, password));
            return true;
        }
        return false;
    }

    //compruebo que el usuario exista para añadir la foto
    public int agregarFoto(String email, String password, String idFoto, LocalDate fechaCreacion) {
        int posicionUsuario = existeUsuario(email);
        if (posicionUsuario > -1) {
            //compruebo si la contraseña es correcta, en caso de no serlo devolvera un -1
            if (this.usuariosPlataforma.get(posicionUsuario).validarPassword(password)) {
                this.usuariosPlataforma.get(posicionUsuario).getFotos().add(new Foto(idFoto, fechaCreacion));
                return 1;
            }
            return -1;
        }
        return -2;
    }

    //buscamos en los usuarios si existe la foto y devolvemos la posicion del usuario que las tiene
    public int fotoExiste(String idFoto) {
        for (int i = 0; i < this.usuariosPlataforma.size(); i++) {
            ArrayList<Foto> fotosUsuario = this.usuariosPlataforma.get(i).getFotos();
            for (int j = 0; j < fotosUsuario.size(); j++) {
                if (fotosUsuario.get(j).getId().equalsIgnoreCase(idFoto)) {
                    return i;
                }
            }
        }
        return -1;
    }

    //valido si el usuario ha dado ya like a es foto
    public boolean usuarioHaDadoLike(String email, String idFoto) {
        int posicionUsuarioFoto = this.fotoExiste(idFoto);
        if (posicionUsuarioFoto > -1) {
            //recorro los likes de la foto para cotejar los emails
            ArrayList<Foto> fotosUsuario = this.usuariosPlataforma.get(posicionUsuarioFoto).getFotos();
            for (Foto fotoPosibleLike : fotosUsuario) {
                //Recorro los usuario que han dado like en la foto y compruebo si esta el pasado por parametro
                if (fotoPosibleLike.getId().equalsIgnoreCase(idFoto)) {
                    ArrayList<Usuario> likesFoto = fotoPosibleLike.getLikes();
                    for (Usuario usuarioLike : likesFoto) {
                        if (usuarioLike.getEmail().equalsIgnoreCase(email)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    //metodo para devolver la posicion de la foto, si la foto no existiera tambien devolveria -1.
    public int posicionFotoUsar(String idFoto) {
        int posicionUsuarioFoto = this.fotoExiste(idFoto);
        if (posicionUsuarioFoto > -1) {
            for (int i = 0; i < this.usuariosPlataforma.get(posicionUsuarioFoto).getFotos().size(); i++) {
                if (this.usuariosPlataforma.get(posicionUsuarioFoto).getFotos().get(i).getId().equalsIgnoreCase(idFoto)) {
                    return i;
                }
            }
        }
        return -1;
    }

    //devuelvo enteros para tener una interpretacion de lo que me devuelve el metodo si falla al dar like
    public int darLikeFoto(String email, String password, String idFoto) {
        if (this.fotoExiste(idFoto) > -1 && !this.usuarioHaDadoLike(email, idFoto)) {
            if (this.existeUsuario(email) > -1) {
                if (this.usuariosPlataforma.get(this.existeUsuario(email)).validarPassword(password)) {
                    this.usuariosPlataforma.get(this.fotoExiste(idFoto)).getFotos().get(posicionFotoUsar(idFoto)).getLikes().add(this.usuariosPlataforma.get(this.existeUsuario(email)));
                    return 1;
                }
            }
            return -2;

        }
        return -1;
    }

    //tengo los usuarios en la plataforma lo que hago es localizarlos y añadirlos mutuamente en seguidores y seguidos
    public int seguirUsuario(String emailUsuario, String passwordUsuario, String emailSeguidor) {
        //compruebo que no se pueda seguir a si mismo
        if (!emailUsuario.equalsIgnoreCase(emailSeguidor)) {
            int posicionUsuarioSeguidor = this.existeUsuario(emailSeguidor);
            int posicionUsuario = this.existeUsuario(emailUsuario);
            //si ambos existen y la contraseña es correcta, los recojo de la lista de usuarios de instagram y los añado en los respectivos objetos.
            if (this.existeUsuario(emailSeguidor) > -1 && this.existeUsuario(emailUsuario) > -1) {
                //calido la contraseña
                if (this.usuariosPlataforma.get(posicionUsuario).validarPassword(passwordUsuario)) {
                    //añado el usuario seguidor en la lista de seguidores del usuario y viceversa
                    this.usuariosPlataforma.get(posicionUsuario).getSeguidores().add(this.usuariosPlataforma.get(posicionUsuarioSeguidor));
                    this.usuariosPlataforma.get(posicionUsuarioSeguidor).getSeguidos().add(this.usuariosPlataforma.get(posicionUsuario));
                    return 1;
                }
            }
            return -1;
        }
        return -2;
    }

    //para poder etiquetar a un usuario en alguna foto las fotos deben pertenecer al etiquetador
    public boolean fotoPerteneceUsuario(String email, String idFoto) {
        if (this.existeUsuario(email) > -1) {
            //si la posicion es mayor que -1 tengo la posicion del dueño de la foto y debe coincidire con la del dueño del emil que pasamos
            if (this.usuariosPlataforma.get(this.existeUsuario(email)) == this.usuariosPlataforma.get(this.fotoExiste(idFoto))) {
                return true;
            }
        }
        return false;
    }

    public int etiquetarUsuario(String email, String password, String idFoto, String emailUsuarioEtiquetado) {
        if (this.existeUsuario(email) > -1 && existeUsuario(emailUsuarioEtiquetado) > -1) {
            if (this.fotoExiste(idFoto) > -1 && this.usuariosPlataforma.get(this.existeUsuario(email)).validarPassword(password)) {
                //controlo que la foto pertenezca al usuario antes de etiquetar
                if (this.fotoPerteneceUsuario(email, idFoto)) {
                    //recojo la posicion del usuario que posee la foto obtengo sus fotos y añado el usuario etiquetado
                    this.usuariosPlataforma.get(this.fotoExiste(idFoto)).getFotos().get(posicionFotoUsar(idFoto)).getEtiquetados().add(this.usuariosPlataforma.get(existeUsuario(emailUsuarioEtiquetado)));
                    return 1;
                }
            }
            return -1;
        }
        return -2;
    }

    //Devuelvo el toString del array list para mostrar directamente las fotos por pantalla 
    public String mostrarFotosUsuario(String email, String password) {
        if (this.existeUsuario(email) > -1) {
            if (this.usuariosPlataforma.get(existeUsuario(email)).validarPassword(password)) {
                return this.usuariosPlataforma.get(existeUsuario(email)).getFotos().toString();
            }
            return "No es posible mostrar fotos: Password incorrecta";
        }
        return "No es posible mostrar fotos:  El usuario proporcionado no existe";
    }
    //Realizo 3 iteraciones con un bucle para recorrer todos los usuarios y llegar a las fotos etiquetadas de cada uno
    //pudiendo asi ver si hay fotos en las que esta el usuario etiquetado o no
    public String mostrarFotosEtiquetado(String email, String password) {
        String fotosEtiquetadas = "";
        if (this.existeUsuario(email) > -1) {
            if (this.usuariosPlataforma.get(existeUsuario(email)).validarPassword(password)) {
                for (int i = 0; i < this.usuariosPlataforma.size(); i++) {
                    for (int j = 0; j < this.usuariosPlataforma.get(i).getFotos().size(); j++) {
                        for (int k = 0; k < this.usuariosPlataforma.get(i).getFotos().get(j).getEtiquetados().size(); k++) {
                            if (this.usuariosPlataforma.get(i).getFotos().get(j).getEtiquetados().get(k).getEmail().equalsIgnoreCase(email)) {
                                fotosEtiquetadas += this.usuariosPlataforma.get(i).getFotos().get(j).toString() + "\n";
                            }
                        }
                    }
                }
                return fotosEtiquetadas;
            }
            return "No es posible mostrar fotos etiquetadas: Password incorrecta";
        }
        return "No es posible mostrar fotos etiquetadas:  El usuario proporcionado no existe";
    }

}
