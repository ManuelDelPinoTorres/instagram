/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package instagram;

import java.time.LocalDate;

/**
 *
 * @author Manuel Del Pino Torres
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //main usado para relizar manualmente varias comprobaciones mientras escribo codigo

        Instagram plataforma = new Instagram();

        //añado 5 usuarios para comenzar a probar
        System.out.println(plataforma.agregarUsuario("manuel@gmail.com", "admin1234"));
        System.out.println(plataforma.agregarUsuario("sonia@gmail.com", "admin1234"));
        System.out.println(plataforma.agregarUsuario("raul@gmail.com", "admin1234"));
        System.out.println(plataforma.agregarUsuario("oscar@gmail.com", "admin1234"));
        System.out.println(plataforma.agregarUsuario("saul@gmail.com", "admin1234"));
        System.out.println(plataforma.getUsuariosPlataforma().toString());

        //usuario existente
        System.out.println(plataforma.agregarFoto("saul@gmail.com", "admin1234", "A000", LocalDate.now()));
        System.out.println(plataforma.agregarFoto("saul@gmail.com", "admin1234", "A001", LocalDate.now()));
        System.out.println(plataforma.agregarFoto("saul@gmail.com", "admin1234", "A002", LocalDate.now()));

        //usuario no existente
        System.out.println(plataforma.agregarFoto("sa@gmail.com", "admin1234", "A000", LocalDate.now()));

        //Damos like a una foto 
        System.out.println(plataforma.darLikeFoto("oscar@gmail.com", "admin1234", "A000"));
        //Vuelve a dar like
        System.out.println(plataforma.darLikeFoto("oscar@gmail.com", "admin1234", "A000"));

        //contraseña fallida
        System.out.println(plataforma.darLikeFoto("saul@gmail.com", "admin124", "A000"));

        //Seguir usuarios correctamente
        System.out.println("Seguir usuario");
        System.out.println(plataforma.seguirUsuario("oscar@gmail.com", "admin1234", "saul@gmail.com"));

        //mismo usuario se sigue a si mimsmo
        System.out.println(plataforma.seguirUsuario("saul@gmail.com", "admin1234", "saul@gmail.com"));

        //Alguno no existe
        System.out.println(plataforma.seguirUsuario("s@gmail.com", "admin1234", "saul@gmail.com"));

        //contraseña incorrecta
        System.out.println(plataforma.seguirUsuario("saul@gmail.com", "admin234", "oscar@gmail.com"));

        System.out.println("Etiquetar usuario");
        //valores correctos
        System.out.println(plataforma.etiquetarUsuario("saul@gmail.com", "admin1234", "A000", "oscar@gmail.com"));
        System.out.println(plataforma.etiquetarUsuario("saul@gmail.com", "admin1234", "A001", "oscar@gmail.com"));

        //Mostrar fotos
        //valores correctos
        System.out.println(plataforma.mostrarFotosUsuario("saul@gmail.com", "admin1234"));
        //valores gmail incorrectos
        System.out.println(plataforma.mostrarFotosUsuario("sal@gmail.com", "admin1234"));

        //valores password incorrectos
        System.out.println(plataforma.mostrarFotosUsuario("sal@gmail.com", "admin123"));

        //Mostrar fotos etiquetadas
        System.out.println("FOTOS ETIQUETADAS");
        System.out.println(plataforma.mostrarFotosEtiquetado("oscar@gmail.com", "admin1234"));

    }

}
