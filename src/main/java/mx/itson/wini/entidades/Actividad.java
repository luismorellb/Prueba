/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.wini.entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import mx.itson.wini.persistencia.Conexion;

/**
 *
 * @author pedrizquierdo
 */
public class Actividad {

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
    
    
}
