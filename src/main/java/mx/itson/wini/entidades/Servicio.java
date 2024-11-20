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
import java.util.Date;
import java.util.List;
import mx.itson.wini.persistencia.Conexion;

/**
 *En esta clase se realizan realizan todas las conexiones, obtenciones y otorgaciones de valores necesarios
 * para que en la base de datos en "Servicio" se pueda mostrar en nuestras tablas
 * @author pedrizquierdo
 */
public class Servicio {

    /**
     * @return identificador unico de servicio realizado
     */
    public int getId() {
        return id;
    }

    /**
     * @param id se le otorga en la base de datos el id del servicio especificado
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return regresa un dato tipo date la cual es la fecha de realizacion
     */
    public Date getFechaRealizacion() {
        return fechaRealizacion;
    }

    /**
     * @param fechaRealizacion se coloca en la base de datos una fecha de realizacion especificada
     */
    public void setFechaRealizacion(Date fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }
    
    /**
    * Obtiene el objeto de tipo Responsable asociado a esta instancia.
    * @return Un objeto de tipo Responsable que contiene información como el ID, 
    * el nombre, y el puesto del responsable.
    */
    public Responsable getResponsable() {
        return responsable;
    }

    /**
    * Asigna un objeto de tipo Responsable al atributo de esta clase.
    * @param responsable Objeto de tipo Responsable que representa al responsable asociado.
    * Puede incluir información como el ID, el nombre, y el puesto del responsable.
    */
    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }

    /**
     * En esta seccion se obtiene el string de la descripcion del problema del servicio especificado
     * @return regresa un dato de tipo string el cual es la descripcion del problema del servicio especificado
     */
    public String getDescripcionProblema() {
        return descripcionProblema;
    }

    /**
     * @param descripcionProblema Dato de tipo string que representa la descripcion del problema, del servicio realizado
     */
    public void setDescripcionProblema(String descripcionProblema) {
        this.descripcionProblema = descripcionProblema;
    }

    /**
     * En esta seccion se obtiene la lista de tipo actividad de cada servicio realizado
     * @return regresa una lista de tipo Actividad la cual es el total de actividades realizadas en el servicio
     * realizado
     */
    public List<Actividad> getActividades() {
        return actividades;
    }

    /**
    * Asigna una lista de actividades al atributo de esta clase.
    * @param actividades Una lista de objetos de tipo Actividad que representan 
    * las actividades asociadas. Cada actividad puede incluir información 
    * como su ID, orden, descripción, y el servicio al que pertenece.
    */
    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }
    
    private int id;
    private Date fechaRealizacion;
    private Responsable responsable;
    private String descripcionProblema;
    private List<Actividad> actividades;
    
    /**
     * En esta seccion de codigo se utiliza para poder obtener el id del servicio en especifico
     * la fecha de realizacion y la descripcion del problema del servicio
     * @param id es un int el cual es el id del servicio
     * @param fecha_realizacion es un dato tipo date el cual es la fecha que se realizo el servicio
     * @param descripcion_problema es un dato tipo string el cual es la descripcion del problema del servicio realizado
     * @return Un objeto de tipo Servicio que contiene los datos del registro correspondiente.
     * Si no se encuentra el registro, se devuelve un objeto vacío con valores predeterminados.
     */
    public static Servicio getById(int id){
            Servicio s = new Servicio ();
        try {
            Connection conexion = Conexion.obtener();
            
            String query = "SELECT id, fecha_realizacion, descripcion_problema FROM servicio WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, id);
            
            ResultSet rs = rs = statement.executeQuery();
            while(rs.next()) {
 
                s.setId(rs.getInt(1));
                s.setFechaRealizacion(rs.getDate(2));
                s.setDescripcionProblema(rs.getString(3));

            }
        } catch (Exception ex) {
            System.err.println("Ocurrió un error " + ex.getMessage());
        }
        return s;
    }
      /**
     * Guarda un registro de Servicio en la base de datos
     * @param fecha dato de tipo date el cual es la fecha de realizacion del servicio
     * @param idResponsable Dato de tipo int el cual es el identificador unico del responsable que realizo el servicio
     * @param descripcionProblema Dato de tipo String el cual es la descripcion del problema del servicio realizado
     * @return true si se guardo exitosamente ; de lo contrario, false.
     */
    public static boolean save(Date fecha, int idResponsable, String descripcionProblema) {
        boolean resultado = false;
        try{
                Connection conexion = Conexion.obtener();
                String consulta = "INSERT INTO servicio (fecha_realizacion, id_responsable, descripcion_problema) VALUES (?, ?, ?)";
                PreparedStatement statement = conexion.prepareStatement(consulta);
                statement.setDate(1, new java.sql.Date(fecha.getTime()));
                statement.setInt(2, idResponsable);
                statement.setString(3, descripcionProblema);
                statement.execute();
                resultado = statement.getUpdateCount() == 1;
                conexion.close();
        }catch(Exception ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }return resultado;
        
        
    }
        /**
     * Aqui esta seccion de codigo sirve para poder editar desde nuestro programa, la base de datos y poder 
     * modificar toda la tabla de Servicio
     * @param fecha dato de tipo date el cual es la fecha de realizacion del servicio
     * @param idResponsable Dato de tipo int el cual es el identificador unico del responsable que realizo el servicio
     * @param descripcionProblema Dato de tipo String el cual es la descripcion del problema del servicio realizado
     * @return la edicion de los elementos seleccionados del servicio especificado
     */
    
    public static boolean edit(Date fecha, int idResponsable, int idServicio, String descripcionProblema) {
        boolean resultado = false;
        try{
                Connection conexion = Conexion.obtener();
                String consulta = "UPDATE servicio SET fecha_realizacion = ?, descripcion_problema = ?, id_responsable = ? WHERE id = ?";
                PreparedStatement statement = conexion.prepareStatement(consulta);
                statement.setDate(1, new java.sql.Date(fecha.getTime()));
                statement.setString(2, descripcionProblema);
                statement.setInt(3, idResponsable);
                statement.setInt(4, idServicio);
                
                statement.execute();
                resultado = statement.getUpdateCount() == 1;
                conexion.close();
        }catch(Exception ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }return resultado;
    } 
     /**
     * En esta seccion de codigo se elimina el id especifico seleccionado de nuestra base de datos
     * @param idServicio es un int el cual es el identificador unico de nuestro servicio especificado
     * @return La eliminacion del identificador unico de nuestro servicio especificado
     */
    public static boolean delete(int idServicio) {
        boolean resultado = false;
        try{
                Connection conexion = Conexion.obtener();
                String consulta = "DELETE FROM Servicio WHERE id = ?";
                PreparedStatement statement = conexion.prepareStatement(consulta);
                
                statement.setInt(1, idServicio);
                
                statement.execute();
                resultado = statement.getUpdateCount() == 1;
                conexion.close();
        }catch(Exception ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }return resultado;
    } 
    
     /**
     * Esta seccion de codigo se usa para poder seleccionar todo lo que este dentro de "Servicio"
     * En la base de datos
     * @return todos los datos seleccionados de la base de datos
     */   
    public static List<Servicio> getAll (){
        List<Servicio> servicios = new ArrayList<>();
        try {
            Connection conexion = Conexion.obtener();
            Statement statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery("SELECT id, fecha_realizacion, id_responsable, descripcion_problema FROM servicio");
            while(rs.next()) {
                Servicio s = new Servicio ();
                s.setId(rs.getInt(1));
                s.setFechaRealizacion(rs.getDate(2));
                
                //Obtenemos un ejemplo de tipo responsable 
                Responsable r = Responsable.getById(rs.getInt(3));
                s.setResponsable(r);
                
                s.setDescripcionProblema(rs.getString(4));
                
                //Obtenemos una lista de tipo Actividad
                List<Actividad> actividades = Actividad.getList(rs.getInt(1));
                s.setActividades(actividades);
                
                servicios.add(s);
                
            }
            
        } catch(Exception ex){
            System.err.println("Ocurrió un error: " + ex.getMessage());
        } return servicios; 
    } 
}
