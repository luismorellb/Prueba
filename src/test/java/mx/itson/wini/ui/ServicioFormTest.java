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
public class ServicioFormTest {
    
    public ServicioFormTest() {
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
     * Test of cargarResponsables method, of class ServicioForm.
     */
    @Test
    public void testCargarResponsables() {
        System.out.println("cargarResponsables");
        ServicioForm instance = null;
        instance.cargarResponsables();
    }

    /**
     * Test of main method, of class ServicioForm.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        ServicioForm.main(args);
    }
    
}
