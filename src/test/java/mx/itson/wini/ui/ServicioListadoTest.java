/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package mx.itson.wini.ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author luismorellb
 */
public class ServicioListadoTest {
    
    public ServicioListadoTest() {
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
     * Test del metodo Main de la clase ServicioListado.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        ServicioListado.main(args);
    }

    /**
     * Test del metodo sendEmail de la clase ServicioListado.
     */
    @Test
    public void testSendEmail() {
        System.out.println("sendEmail");
        String recipient = "";
        String subject = "";
        String body = "";
        ServicioListado.sendEmail(recipient, subject, body);
    }
    
}
