/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mx.itson.wini.ui;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mx.itson.wini.entidades.Actividad;
import mx.itson.wini.entidades.Responsable;
import mx.itson.wini.entidades.Servicio;

/**
 *En esta clase se muestra toda la lista de nuestra base de datos de actividades 
 * y se permite realizar con botones la eliminacion, edicion o creacion de nuevas actividades y todo su formulario
 * @author pedrizquierdo
 */
public class ActividadListado extends javax.swing.JFrame {

    private int idServicio;
    
    /**
    * Constructor de la clase ActividadListado.
    *
    * Este formulario muestra una lista de actividades relacionadas con un servicio específico. 
    * El constructor inicializa los componentes del formulario y carga los datos de la tabla 
    * de actividades correspondientes al identificador del servicio proporcionado.
    * @param idServicio Identificador único del servicio del cual se listarán las actividades.
    */

    public ActividadListado(int IdServicio) {
        
        this.idServicio = IdServicio;
        initComponents();
        loadTable(idServicio);

        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblActividades = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SF Pro Display", 3, 24)); // NOI18N
        jLabel1.setText("Lista de Actividades");

        tblActividades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Orden", "Descripción"
            }
        ));
        jScrollPane1.setViewportView(tblActividades);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregar)
                        .addGap(68, 68, 68)
                        .addComponent(btnEditar)
                        .addGap(67, 67, 67)
                        .addComponent(btnEliminar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 933, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnAgregar)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(168, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        /**
         * Es un metodo el cual inicializa la tabla y que pueda ejecutarse de manera correcta
         */
        loadTable(idServicio);
        tblActividades.removeColumn(tblActividades.getColumnModel().getColumn(0));
        
        
    }//GEN-LAST:event_formWindowOpened

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
            /**
             * Esta seccion crea una nueva instancia para agregar una nueva actividad
             * el idActividad se inica en 0 para indicar que se esta creando una nueva actividad
             * y al final se reinicia la tabla con el metodo loadTable
             */
        int idActividad = 0;
        ActividadForm form = new ActividadForm(this, true, idActividad, idServicio);
        form.setVisible(true);
        
        loadTable(idServicio);
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        /**
         * Esta seccion obtiene un id de actividad seleccionada en la tabla abre el formulario de esa actividad
         * y permite editar toda la informacion dentro de ella
         * al final se reinicia la tabla con el metodo loadTable
         */
        int renglon = tblActividades.getSelectedRow();
        int idActividad = Integer.parseInt(tblActividades.getModel().getValueAt(renglon, 0).toString());
        
        ActividadForm form = new ActividadForm(this, true, idActividad, idServicio);
         form.setVisible(true);
        
        loadTable(idServicio);
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        /**
         * Esta seccion obtiene un id de actividd seleccionada y permite eliminar ese id y todo el renglon
         * de esa actividad
         * Al eliminarla pregunta si desea eliminarla y si es asi lanza un texto de que se logro eliminar
         * si no lanza un texto donde marca un error
         * y al final se recarga la tabla con el metodo loadTable
         */
        int renglon = tblActividades.getSelectedRow();
        int idResponsable = Integer.parseInt(tblActividades.getModel().getValueAt(renglon, 0).toString());
        
        if (JOptionPane.showConfirmDialog(this, "¿Está seguro que desea eliminar el registro?", "Eliminar registro", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
        
        if(Actividad.delete(idResponsable)){
            JOptionPane.showMessageDialog(this, "El registro se eliminó con éxito", "Registro eliminado", JOptionPane.INFORMATION_MESSAGE);
            loadTable(idServicio);
        } else {
            JOptionPane.showMessageDialog(this, "Ocurrió un error", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        } 
    }//GEN-LAST:event_btnEliminarActionPerformed

        /**
         * Esta seccion sirve para poder recargar la tabla al cerrar una accion
         * @param Actvidad Dato de tipo Actividad el cual es la lista de todas las actividades realizadas en nuestra
         * base de datos en la cual contiene toda su informacion
         * @return el recargado de la tabla ya con las acciones realizadas
         */
    private void loadTable(int idServicio){
        List<Actividad> actividades = Actividad.getAll();
        DefaultTableModel modeloTabla = (DefaultTableModel)tblActividades.getModel();
        modeloTabla.setRowCount(0);
        
    
        for(Actividad a: actividades) {
            if(a.getServicio().getId() == idServicio) {
            modeloTabla.addRow(new Object[] {
            a.getId(),
            a.getOrden(),
            a.getDescripcion(),
           
            
            
            });
            }
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ActividadListado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ActividadListado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActividadListado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActividadListado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                int idServicio = 1;
                new ActividadListado(idServicio).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblActividades;
    // End of variables declaration//GEN-END:variables
}
