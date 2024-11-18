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
 *
 * @author pedrizquierdo
 */
public class Actividad {

    /**
     * @return the servicio
     */
    public Servicio getServicio() {
        return servicio;
    }

    /**
     * @param servicio the servicio to set
     */
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the orden
     */
    public int getOrden() {
        return orden;
    }

    /**
     * @param orden the orden to set
     */
    public void setOrden(int orden) {
        this.orden = orden;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public static List<Actividad> getList(int idServicio) {
        List<Actividad> actividades = new ArrayList<>();
        try {
            Connection conexion = Conexion.obtener();
            String consulta = "SELECT id, orden, descripcion FROM actividad WHERE id_servicio = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1, idServicio);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                Actividad a = new Actividad();
                a.setId(rs.getInt(1));
                a.setOrden(rs.getInt(2));
                a.setDescripcion(rs.getString(3));
                actividades.add(a);
                
            }
        } catch(Exception ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
        } return actividades;
      
    }
    
    private int id;
    private int orden;
    private String descripcion;
    private Servicio servicio;
    
    public static boolean delete(int id) {
        boolean resultado = false;
        try{
                Connection conexion = Conexion.obtener();
                String consulta = "DELETE FROM actividad WHERE id = ?";
                PreparedStatement statement = conexion.prepareStatement(consulta);
                
                statement.setInt(1, id);
                
                statement.execute();
                resultado = statement.getUpdateCount() == 1;
                conexion.close();
        }catch(Exception ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }return resultado;
    } 
    
    public static boolean edit(int id,int orden, String descripcion, int idServicio) {
        boolean resultado = false;
        try{
                Connection conexion = Conexion.obtener();
                String consulta = "UPDATE actividad SET orden = ?, descripcion = ?, id_servicio = ? WHERE id = ?";
                PreparedStatement statement = conexion.prepareStatement(consulta);
                statement.setInt(1, orden);
                statement.setString(2, descripcion);
                statement.setInt(3, idServicio);
                statement.setInt(4,id);
                
                statement.execute();
                resultado = statement.getUpdateCount() == 1;
                conexion.close();
        }catch(Exception ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }return resultado;
    } 
    
    public static boolean save(int orden, String descripcion, int idServicio) {
        boolean resultado = false;
        try{
                Connection conexion = Conexion.obtener();
                String consulta = "INSERT INTO actividad (orden, descripcion, id_servicio) VALUES (?, ?, ?)";
                PreparedStatement statement = conexion.prepareStatement(consulta);
                statement.setInt(1, orden);
                statement.setString(2, descripcion);
                statement.setInt(3, idServicio);
                
                statement.execute();
                resultado = statement.getUpdateCount() == 1;
                conexion.close();
        }catch(Exception ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }return resultado;
        
        
    } 
    
    public static Actividad getById(int id){
            Actividad a = new Actividad ();
        try {
            Connection conexion = Conexion.obtener();
            
            String query = "SELECT id, orden, descripcion FROM actividad WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, id);
            
            ResultSet rs = rs = statement.executeQuery();
            while(rs.next()) {
 
                a.setId(rs.getInt(1));
                a.setOrden(rs.getInt(2));
                a.setDescripcion(rs.getString(3));

            }
        } catch (Exception ex) {
            System.err.println("Ocurrió un error " + ex.getMessage());
        }
        return a;
    }
    
    public static List<Actividad> getAll (){
        List<Actividad> actividades = new ArrayList<>();
        try {
            Connection conexion = Conexion.obtener();
            Statement statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery("SELECT id, orden, descripcion, id_servicio FROM Actividad");
            while(rs.next()) {
                Actividad a = new Actividad ();
                a.setId(rs.getInt(1));
                a.setOrden(rs.getInt(2));               
                a.setDescripcion(rs.getString(3));
                
                Servicio s = Servicio.getById(rs.getInt(4));
                a.setServicio(s);
                
                actividades.add(a);
                
            }
            
        } catch(Exception ex){
            System.err.println("Ocurrió un error: " + ex.getMessage());
        } return actividades; 
    } 
    
}
