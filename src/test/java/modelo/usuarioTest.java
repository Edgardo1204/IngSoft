/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package modelo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Jesus
 */
public class usuarioTest {
    
    public usuarioTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getRol method, of class usuario.
     */
    @Test
    public void testGetRol() {
        System.out.println("getRol");
        usuario instance = new usuario();
        int expResult = 0;
        int result = instance.getRol();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRol method, of class usuario.
     */
    @Test
    public void testSetRol() {
        System.out.println("setRol");
        int rol = 0;
        usuario instance = new usuario();
        instance.setRol(rol);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsuario method, of class usuario.
     */
    @Test
    public void testGetUsuario() {
        System.out.println("getUsuario");
        usuario instance = new usuario();
        String expResult = "";
        String result = instance.getUsuario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsuario method, of class usuario.
     */
    @Test
    public void testSetUsuario() {
    System.out.println("setUsuario");
    String usuario = "nombre_de_usuario"; // Ingresa aquí el valor del usuario que desees probar
    usuario instance = new usuario();
    instance.setUsuario(usuario);
    
    // Realiza las aserciones aquí, según la funcionalidad que estés probando
    // Por ejemplo, si el método setUsuario establece correctamente el atributo usuario,
    // podrías usar el siguiente código para verificarlo:
    assertEquals(usuario, instance.getUsuario());
}
    /**
     * Test of getPassword method, of class usuario.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        usuario instance = new usuario();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class usuario.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        usuario instance = new usuario();
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
