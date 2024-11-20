/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.wini.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * En esta clase se hace la conexion de nuestro programa a la base de datos de mysql
 * @author pedrizquierdo
 */

public class Conexion {
    
   /**
   * Establece y devuelve una conexión con la base de datos.
    * @return Un objeto de tipo Connection que representa la conexión activa con la base de datos.
    * Si ocurre un error durante la conexión, se devuelve null.
    * En caso de error, se imprime un mensaje en la consola con los detalles del problema.
    */
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
