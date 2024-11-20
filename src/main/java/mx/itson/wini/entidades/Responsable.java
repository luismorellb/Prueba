/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.wini.entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mx.itson.wini.persistencia.Conexion;

/**
 *En esta clase se realizan realizan todas las conexiones, obtenciones y otorgaciones de valores necesarios
 * para que en la base de datos en "Responsable" se pueda mostrar en nuestras tablas
 * @author pedrizquierdo
 */
public class Responsable {

    /**
     * @return regresa El id del responsable especificado segun la base de datos
     */
    public int getId() {
        return id;
    }

    /**
     * @param id se le otorga en la base de datos el id del responsable especificado
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return el nombre del responsable especificado segun la base de datos 
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre se coloca en la base de datos el nombre del responsable especificado
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return El puesto al que pertenece el responsable especificado
     */
    public String getPuesto() {
        return puesto;
    }

    /**
     * @param puesto se coloca en la base de datos el puesto del responsable especificado
     */
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    
    /**
     * Aqui se hace un reescritura del nombre desde la clase ServicioForm para que se convierta
     * a un string y el combobox aparezca el nombre del responsable
     * @return 
     */
    @Override
    public String toString() {
        return this.nombre;
    }
    
    private int id;
    private String nombre;
    private String puesto;
    
    /**
     * Esta seccion de codigo se usa para poder seleccionar todo lo que este dentro de "Responsable"
     * En la base de datos
     * @return todos los datos seleccionados de la base de datos
     */   
    public static List<Responsable> getAll() {
        List<Responsable> responsables = new ArrayList<>();
        try {
            Connection conexion = Conexion.obtener();
            Statement statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery("SELECT id, nombre, puesto FROM responsable");
            while(rs.next()) {
                Responsable r = new Responsable();
                r.setId(rs.getInt(1));
                r.setNombre(rs.getString(2));
                r.setPuesto(rs.getString(3));
                responsables.add(r);
            }
        } catch (Exception ex) {
            System.err.println("Ocurrió un error " + ex.getMessage());
        }
        return responsables;
    }
    
    /**
      * En esta seccion de codigo se utiliza para poder obtener el id del responsable en especifico
     * el id del responsable nombre del responsable y puesto del responsable especificado
     * @param id es un int el cual es el id del responsable espesifcado
     * @param nombre es un string el cual es el nombre del responsable especificado
     * @param puesto es un string el cual es el puesto asigado del responsable especificado
     * @return Un objeto de tipo Responsable que contiene los datos del registro correspondiente.
     * Si no se encuentra el registro, se devuelve un objeto vacío con valores predeterminados.
     */
    public static Responsable getById(int id){
        Responsable r = new Responsable ();
        try {
            Connection conexion = Conexion.obtener();
            
            String query = "SELECT id, nombre, puesto FROM responsable WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, id);
            
            ResultSet rs = rs = statement.executeQuery();
            while(rs.next()) {
 
                r.setId(rs.getInt(1));
                r.setNombre(rs.getString(2));
                r.setPuesto(rs.getString(3));

            }
        } catch (Exception ex) {
            System.err.println("Ocurrió un error " + ex.getMessage());
        }
        return r;
    }
    
    
    /**
     * Aqui esta seccion de codigo sirve para poder editar desde nuestro programa, la base de datos y poder 
     * modificar toda la tabla de Responsable
     * @param id es un int el cual es el identificador unico del responsable
     * @param nombre es un string el cual es el nombre del responsable especificado
     * @param puesto es un string el cual es el puesto del responsable especificado
     * @return la edicion de los elementos seleccionados del responsable especificado
     */
    public static boolean edit(int id,String nombre, String puesto) {
        boolean resultado = false;
        try{
                Connection conexion = Conexion.obtener();
                String consulta = "UPDATE responsable SET nombre = ?, puesto = ? WHERE id = ?";
                PreparedStatement statement = conexion.prepareStatement(consulta);
                statement.setString(1, nombre);
                statement.setString(2, puesto);
                statement.setInt(3, id);
                
                statement.execute();
                resultado = statement.getUpdateCount() == 1;
                conexion.close();
        }catch(Exception ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }return resultado;
    } 
    /**
     * En esta seccion de codigo se elimina el id especifico seleccionado de nuestra base de datos
     * @param id es un int el cual es el identificador unico de nuestro responsable especificado
     * @return La eliminacion del identificador unico de nuestro responsable especificado
     */
    
    public static boolean delete(int id) {
        boolean resultado = false;
        try{
                Connection conexion = Conexion.obtener();
                String consulta = "DELETE FROM responsable WHERE id = ?";
                PreparedStatement statement = conexion.prepareStatement(consulta);
                
                statement.setInt(1, id);
                
                statement.execute();
                resultado = statement.getUpdateCount() == 1;
                conexion.close();
        }catch(Exception ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }return resultado;
    } 
    /**
     * Guarda un registro de responsable en la base de datos
     * @param nombre Valor del nombre del responsable
     * @param puesto Valor del puesto del responsable
     * @return true si se guardo exitosamente ; de lo contrario, false.
     */
    public static boolean save(String nombre, String puesto) {
        boolean resultado = false;
        try{
                Connection conexion = Conexion.obtener();
                String consulta = "INSERT INTO responsable (nombre, puesto) VALUES (?, ?)";
                PreparedStatement statement = conexion.prepareStatement(consulta);
                statement.setString(1, nombre);
                statement.setString(2, puesto);
                
                statement.execute();
                resultado = statement.getUpdateCount() == 1;
                conexion.close();
        }catch(Exception ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }return resultado;
        
        
    } 
    
}


