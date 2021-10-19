/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import paneles.clases1;
/**
 *
 * @author Gerencia Proyectos
 */
public class lista_clases1 extends javax.swing.JPanel {
 Vector nuevafila;
    DefaultTableModel modelotabla;
    
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * Creates new form lista_clases
     */
    public lista_clases1() {
        initComponents();
        //lbprueba.setText("hola");
        //clases1 objtados = new clases1();
        //String dato = objtados.getdatos();
        //lbprueba.setText(dato);
         //Empleado tecnico = (Empleado) pnl.cbEmpleado.getSelectedItem();
       
    }
     public void prueba(clases1 pnl){ 
        lbprueba.setText(pnl.txtPersona.getText());
      
     }
    public lista_clases1(clases c) {
        initComponents();
        
        //this.Limpiar_Tabla();
        this.Agregar_Fila();
        
        this.tablaclases1.setValueAt(c.cmbCuenta.getSelectedItem().toString(), 1, 0);
        this.tablaclases1.setValueAt(c.cmbSubCuenta.getSelectedItem().toString(), 1, 1);
        this.tablaclases1.setValueAt(c.cmbTalonario.getSelectedItem().toString(), 1, 2);
        this.tablaclases1.setValueAt(df.format(c.fechaInicial.getDate()), 1, 3);
        this.tablaclases1.setValueAt(c.txtPersona.getText(), 1, 4);
        this.tablaclases1.setValueAt(c.txtDetalle.getText(), 1, 5);
        this.tablaclases1.setValueAt(c.txtCantidad.getText(), 1, 6);
        this.tablaclases1.setValueAt(c.txtValorUnitario.getText(), 1, 7);
        this.tablaclases1.setValueAt(c.txtValorTotal.getText(), 1, 8);
    }
    
    public void Agregar_Fila()
    {
        modelotabla = (DefaultTableModel) this.tablaclases1.getModel();
        nuevafila = new Vector();
        tablaclases1.setModel(modelotabla);
        nuevafila.add(null);
        modelotabla.addRow(nuevafila);
    }
    
    public void Limpiar_Tabla()
    {
        tablaclases1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Cuenta", "Codigo SubCuenta", "Codigo Talonario", "Fecha","Persona/Servicio", "Detalle", "Cantidad", "Valor_Unitario", "Valor_Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        control2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaclases1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        uno = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        lbprueba = new javax.swing.JLabel();

        tablaclases1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tablaclases1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tablaclases1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo_Cuenta", "Codigo_Subcuenta", "Codigo_Talonario", "Fecha", "Persona/Servicio", "Detalle", "Cantidad", "Valor_Unitaro", "Valor_Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaclases1);

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        uno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reportes.png"))); // NOI18N
        uno.setText("Reportes");
        uno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unoActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancel.png"))); // NOI18N
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lbprueba.setText("jLabel1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(uno)
                .addGap(32, 32, 32)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbprueba)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(uno)
                .addGap(0, 1, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbprueba))
        );

        javax.swing.GroupLayout control2Layout = new javax.swing.GroupLayout(control2);
        control2.setLayout(control2Layout);
        control2Layout.setHorizontalGroup(
            control2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(control2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(control2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(control2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1026, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        control2Layout.setVerticalGroup(
            control2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(control2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(control2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(control2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void unoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unoActionPerformed
        // TODO add your handling code here:
       control2.setLayout(new javax.swing.BoxLayout(control2, javax.swing.BoxLayout.LINE_AXIS));
        new CambiaPanel(control2,new Reportescajamenor1());
    }//GEN-LAST:event_unoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel control2;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbprueba;
    private javax.swing.JTable tablaclases1;
    private javax.swing.JButton uno;
    // End of variables declaration//GEN-END:variables

    private void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
