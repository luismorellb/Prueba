/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package mx.itson.wini.entidades;

import java.util.Date;
import java.util.List;
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
public class ServicioTest {
    
    public ServicioTest() {
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
     * Test of getId method, of class Servicio.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Servicio instance = new Servicio();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Servicio.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Servicio instance = new Servicio();
        instance.setId(id);
    }

    /**
     * Test of getFechaRealizacion method, of class Servicio.
     */
    @Test
    public void testGetFechaRealizacion() {
        System.out.println("getFechaRealizacion");
        Servicio instance = new Servicio();
        Date expResult = null;
        Date result = instance.getFechaRealizacion();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFechaRealizacion method, of class Servicio.
     */
    @Test
    public void testSetFechaRealizacion() {
        System.out.println("setFechaRealizacion");
        Date fechaRealizacion = null;
        Servicio instance = new Servicio();
        instance.setFechaRealizacion(fechaRealizacion);
    }

    /**
     * Test of getResponsable method, of class Servicio.
     */
    @Test
    public void testGetResponsable() {
        System.out.println("getResponsable");
        Servicio instance = new Servicio();
        Responsable expResult = null;
        Responsable result = instance.getResponsable();
        assertEquals(expResult, result);
    }

    /**
     * Test of setResponsable method, of class Servicio.
     */
    @Test
    public void testSetResponsable() {
        System.out.println("setResponsable");
        Responsable responsable = null;
        Servicio instance = new Servicio();
        instance.setResponsable(responsable);
    }

    /**
     * Test of getDescripcionProblema method, of class Servicio.
     */
    @Test
    public void testGetDescripcionProblema() {
        System.out.println("getDescripcionProblema");
        Servicio instance = new Servicio();
        String expResult = null;
        String result = instance.getDescripcionProblema();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDescripcionProblema method, of class Servicio.
     */
    @Test
    public void testSetDescripcionProblema() {
        System.out.println("setDescripcionProblema");
        String descripcionProblema = "";
        Servicio instance = new Servicio();
        instance.setDescripcionProblema(descripcionProblema);
    }

    /**
     * Test of getActividades method, of class Servicio.
     */
    @Test
    public void testGetActividades() {
        System.out.println("getActividades");
        Servicio instance = new Servicio();
        List<Actividad> expResult = null;
        List<Actividad> result = instance.getActividades();
        assertEquals(expResult, result);
    }

    /**
     * Test of setActividades method, of class Servicio.
     */
    @Test
    public void testSetActividades() {
        System.out.println("setActividades");
        List<Actividad> actividades = null;
        Servicio instance = new Servicio();
        instance.setActividades(actividades);
    }

    /**
     * Test of getById method, of class Servicio.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
        int id = 0;
        Servicio expResult = null;
        Servicio result = Servicio.getById(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of save method, of class Servicio.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Date fecha = null;
        int idResponsable = 0;
        String descripcionProblema = "";
        boolean expResult = false;
        boolean result = Servicio.save(fecha, idResponsable, descripcionProblema);
        assertEquals(expResult, result);
    }

    /**
     * Test of edit method, of class Servicio.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
        Date fecha = null;
        int idResponsable = 0;
        int idServicio = 0;
        String descripcionProblema = "";
        boolean expResult = false;
        boolean result = Servicio.edit(fecha, idResponsable, idServicio, descripcionProblema);
        assertEquals(expResult, result);
    }

    /**
     * Test of delete method, of class Servicio.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        int idServicio = 0;
        boolean expResult = false;
        boolean result = Servicio.delete(idServicio);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAll method, of class Servicio.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        List<Servicio> expResult = null;
        List<Servicio> result = Servicio.getAll();
        assertEquals(expResult, result);
    }
    
}
