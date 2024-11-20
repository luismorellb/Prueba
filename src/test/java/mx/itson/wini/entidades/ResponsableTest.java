/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package mx.itson.wini.entidades;

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
public class ResponsableTest {
    
    public ResponsableTest() {
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
     * Test de el metodo Obtener Id de la clase Responsable
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Responsable instance = new Responsable();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     *  Test de el otorgar Id de la clase Responsable
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 4;
        Responsable instance = new Responsable();
        instance.setId(id);
    }

    /**
     * Test de el metodo Obtener Nombre de la clase Responsable
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Responsable instance = new Responsable();
        String expResult = null;
        String result = instance.getNombre();
        assertEquals(expResult, result);
    }

    /**
     * Test de el metodo Otorgar Nombre de la clase Responsable
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "Alan Godoy";
        Responsable instance = new Responsable();
        instance.setNombre(nombre);
    }

    /**
     * Test de el metodo Obtener Puesto de la clase Responsable
     */
    @Test
    public void testGetPuesto() {
        System.out.println("getPuesto");
        Responsable instance = new Responsable();
        String expResult = null;
        String result = instance.getPuesto();
        assertEquals(expResult, result);
    }

    /**
     * Test de el metodo Otorgar Puesto de la clase Responsable
     */
    @Test
    public void testSetPuesto() {
        System.out.println("setPuesto");
        String puesto = "Gerente de intendencia";
        Responsable instance = new Responsable();
        instance.setPuesto(puesto);
    }

    /**
     * Test de el metodo Sobreescrito de la clase Responsable
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Responsable instance = new Responsable();
        String expResult = null;
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test de el metodo Obtener Todos los datos de la clase Responsable
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        List<Responsable> expResult = null;
        List<Responsable> result = Responsable.getAll();
        assertEquals(expResult, result);
    }

    /**
     * Test de el metodo Obtener ById de la clase Responsable
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
        int id = 0;
        Responsable expResult = null;
        Responsable result = Responsable.getById(id);
        assertEquals(expResult, result);
    }

    /**
     * Test de el metodo Editar de la clase Responsable
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
        int id = 4;
        String nombre = "Ramón Carillo";
        String puesto = "Desarrollador Web";
        boolean expResult = true;
        boolean result = Responsable.edit(id, nombre, puesto);
        assertEquals(expResult, result);
    }

    /**
     * Test de el metodo Eliminar de la clase Responsable
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        int id = 13;
        boolean expResult = true;
        boolean result = Responsable.delete(id);
        assertEquals(expResult, result);
    }

    /**
     * Test de el metodo Guardar de la clase Responsable
     */
    @Test
    public void testSave() {
        System.out.println("save");
        String nombre = "Pedro Pascal";
        String puesto = "Desarrollador Backend";
        boolean expResult = true;
        boolean result = Responsable.save(nombre, puesto);
        assertEquals(expResult, result);
    }
    
}
