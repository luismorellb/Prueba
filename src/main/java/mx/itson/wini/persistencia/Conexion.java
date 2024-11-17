/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.wini.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author pedrizquierdo
 */
public class Conexion {
    
    public static Connection obtener() {
        Connection conexion = null;
        try{
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/wini?user=root&password=administrador");
        } catch (Exception ex) {
            System.err.println("Ocurrió un error " + ex.getMessage());
        }
        return conexion;
    }
    
}
