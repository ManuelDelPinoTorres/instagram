/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package instagram;

import java.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Manuel Del Pino Torres
 */
public class InstagramTest {

    public InstagramTest() {
    }

    /**
     * Test of agregarUsuario method, of class Instagram. Introduzco un usuario
     * y compruebo si la logitud de las lista de usuarios es mayor que 0
     */
    @Test
    public void testAgregarUsuario() {

        Instagram plataformaPrueba = new Instagram();
        plataformaPrueba.agregarUsuario("manuel@gmail.com", "admin1234");

        assertTrue(plataformaPrueba.getUsuariosPlataforma().size() > 0);
    }

    /**
     * Test of agregarFoto method, of class Instagram. Al añadir una foto
     * comprobamos que las primeras possicones de usuarios y fotos no sean nulas
     */
    @Test
    public void testAgregarFoto() {
        Instagram plataformaPrueba = new Instagram();
        plataformaPrueba.agregarUsuario("manuel@gmail.com", "admin1234");
        plataformaPrueba.agregarFoto("manuel@gmail.com", "admin1234", "AX00", LocalDate.now());

        assertNotNull(plataformaPrueba.getUsuariosPlataforma().get(0));
        assertNotNull(plataformaPrueba.getUsuariosPlataforma().get(0).getFotos().get(0));
    }

    /**
     * Test of darLikeFoto method, of class Instagram. Creamos dos usuarios y
     * comprobamos que se devuelve resultado correcto al dar like a una foto de
     * un usuario a otro.
     */
    @Test
    public void testDarLikeFoto() {
        Instagram plataformaPrueba = new Instagram();
        plataformaPrueba.agregarUsuario("manuel@gmail.com", "admin1234");
        plataformaPrueba.agregarUsuario("oscar@gmail.com", "admin1234");
        plataformaPrueba.agregarFoto("oscar@gmail.com", "admin1234", "AX00", LocalDate.now());

        final int RESULTADO = 1;
        int resultado = plataformaPrueba.darLikeFoto("manuel@gmail.com", "admin1234", "AX00");

        assertEquals(RESULTADO, resultado);
    }

    /**
     * Test of darLikeFoto method, of class Instagram. Intentamos dar me gusta a
     * una foto con un usuario que no existe
     */
    @Test
    public void testDarLikeFotoCuentaFalsa() {
        Instagram plataformaPrueba = new Instagram();
        plataformaPrueba.agregarUsuario("oscar@gmail.com", "admin1234");
        plataformaPrueba.agregarFoto("oscar@gmail.com", "admin1234", "AX00", LocalDate.now());

        final int RESULTADO = -2;
        int resultado = plataformaPrueba.darLikeFoto("m@gmail.com", "admin1234", "AX00");

        assertEquals(RESULTADO, resultado);
    }

    /**
     * Test of seguirUsuario method, of class Instagram. Comprobamos que un
     * usuario no puede seguirse a si mismo
     */
    @Test
    public void testSeguirUsuario() {
        Instagram plataformaPrueba = new Instagram();
        plataformaPrueba.agregarUsuario("oscar@gmail.com", "admin1234");

        final int RESULTADO = -2;
        int resultado = plataformaPrueba.seguirUsuario("oscar@gmail.com", "admin1234", "oscar@gmail.com");

        assertEquals(RESULTADO, resultado);
    }

    /**
     * Test of etiquetarUsuario method, of class Instagram.
     */
    @Test
    public void testEtiquetarUsuario() {
        Instagram plataformaPrueba = new Instagram();
        plataformaPrueba.agregarUsuario("oscar@gmail.com", "admin1234");
        plataformaPrueba.agregarUsuario("jose@gmail.com", "admin1234");
        plataformaPrueba.agregarFoto("jose@gmail.com", "admin1234", "X890", LocalDate.now());

        int resultado = plataformaPrueba.etiquetarUsuario("jose@gmail.com", "admin1234", "X890", "oscar@gmail.com");

        assertTrue(resultado > 0);
    }

    /**
     * Test of mostrarFotosUsuario method, of class Instagram. Comprobamos que
     * se ha mostrado un mensaje distinto a los dos de fallo para verificar que
     * esta bien
     */
    @Test
    public void testMostrarFotosUsuario() {
        String mensajeFalloPassword = "No es posible mostrar fotos: Password incorrecta";
        String mensajeFalloUsuario = "No es posible mostrar fotos:  El usuario proporcionado no existe";
        Instagram plataformaPrueba = new Instagram();

        plataformaPrueba.agregarUsuario("oscar@gmail.com", "admin1234");
        plataformaPrueba.agregarFoto("oscar@gmail.com", "admin1234", "AX00", LocalDate.now());

        String resultado = plataformaPrueba.mostrarFotosUsuario("oscar@gmail.com", "admin1234");

        assertTrue(mensajeFalloPassword.length() != resultado.length());
        assertTrue(mensajeFalloUsuario.length() != resultado.length());
    }

    /**
     * Test of mostrarFotosEtiquetado method, of class Instagram. De nuevo
     * comparamos las salidas para verificar que se ha devuelto en este metodo
     */
    @Test
    public void testMostrarFotosEtiquetado() {
        String mensajeFalloPassword = "No es posible mostrar fotos: Password incorrecta";
        String mensajeFalloUsuario = "No es posible mostrar fotos:  El usuario proporcionado no existe";
        Instagram plataformaPrueba = new Instagram();

        plataformaPrueba.agregarUsuario("jose@gmail.com", "admin1234");
        plataformaPrueba.agregarUsuario("oscar@gmail.com", "admin1234");
        plataformaPrueba.agregarFoto("oscar@gmail.com", "admin1234", "AX00", LocalDate.now());

        plataformaPrueba.etiquetarUsuario("oscar@gmail.com", "admin1234", "AX00", "jose@gmail.com");

        String resultado = plataformaPrueba.mostrarFotosEtiquetado("oscar@gmail", "admin1234");

        assertTrue(mensajeFalloPassword.length() != resultado.length() && mensajeFalloUsuario.length() != resultado.length());

    }

}
