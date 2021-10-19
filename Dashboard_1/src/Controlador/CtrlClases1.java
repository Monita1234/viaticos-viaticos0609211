/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cargo;
import Modelo.ConsultaUsuarios;
import Modelo.User;
import java.awt.Color;
import java.awt.Font;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import static org.eclipse.persistence.expressions.ExpressionMath.mod;
import paneles.IconCellRenderer;
import paneles.clases1;
import paneles.pnlUsuarios;
import principal.diaRegUsuarios;

/**
 *
 * @author Gerencia Proyectos
 */

public class CtrlClases1 {
     clases1 clases1;
    private clases1 mod;
    
 public CtrlClases1(){
        
    }
    
    public CtrlClases1(clases1 clases1, ConsultaUsuarios mod){
        this.clases1 = clases1;
    
        try {
            llenarTablaclases1(this.clases1.tablaclases1);
        } catch (Exception ex) {
            Logger.getLogger(CtrlClases1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void registrarclases1(clases1 clases1) throws Exception{
        if(!clases1.cmbCuenta.getSelectedItem().equals(""))if (clases1.cmbCuenta.getSelectedItem().equals("")){
        if(!clases1.cmbSubCuenta.getSelectedItem().equals(""))if (clases1.cmbSubCuenta.getSelectedItem().equals("")){
        if(!clases1.cmbTalonario.getSelectedItem().equals(""))if (clases1.cmbTalonario.getSelectedItem().equals("")){
        if(!clases1.fechaInicial.getDate().equals(""))if (clases1.fechaInicial.getDate().equals("")){
        }else if (clases1.txtPersona.getText().equals("")){
        }else if (clases1.txtDetalle.getText().equals("")){
        }else if (clases1.txtCantidad.getText().equals("")){
        }else if (clases1.txtValorUnitario.getText().equals("")){
       }else if (clases1.txtValorTotal.getText().equals("")){
        
            clases1.setValueAt(clases1.cmbCuenta.getSelectedItem());
            clases1.setValueAt(clases1.cmbSubCuenta.getSelectedItem());
            clases1.setValueAt(clases1.cmbTalonario.getSelectedItem());
            clases1.setValueAt(clases1.fechaInicial.getDate());
            clases1.setValueAt(clases1.txtPersona.getText());
            clases1.setValueAt(clases1.txtDetalle.getText());
            clases1.setValueAt(clases1.txtCantidad.getText());
            clases1.setValueAt(clases1.txtValorUnitario.getText());
            clases1.setValueAt(clases1.txtValorTotal.getText());
            
            if(regiclases1(clases1)){
                
     
                clases1.cmbCuenta.getSelectedItem();
                clases1.cmbSubCuenta.getSelectedItem();
                clases1.cmbTalonario.getSelectedItem();
                clases1.fechaInicial.getDate();
                clases1.txtDetalle.setText("");
                clases1.txtCantidad.setText("");
                clases1.txtValorUnitario.setText("");
                clases1.txtValorTotal.setText("");
                llenarTablaclases1(clases1.tablaclases1);
                clases1.setVisible(false);
                clases1.dispose();
            }   
       }
    }
}        
        }
    }

    private void llenarTablaclases1(JTable tablaclases1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean regiclases1(clases1 clases1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param tablaclases1
     * @throws Exception
     */
    public void llenartablaclases1(JTable tablaclases1) throws Exception {
        tablaclases1.setDefaultRenderer(Object.class,new IconCellRenderer());
        DefaultTableModel modeloT = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaclases1.setModel(modeloT);
        tablaclases1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tablaclases1.getTableHeader().setOpaque(false);
        tablaclases1.getTableHeader().setBackground(new Color (204, 0, 0));
        tablaclases1.getTableHeader().setForeground(new Color(255,255,255));
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) tablaclases1.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        
        
        modeloT.addColumn("#");
        modeloT.addColumn("Codigo_Cuenta");
        modeloT.addColumn("Codigo_Subcuenta");
        modeloT.addColumn("Codigo_Talonario");
        modeloT.addColumn("Fecha");
        modeloT.addColumn("persona");
        modeloT.addColumn("Detalle");
        modeloT.addColumn("Cantidad");
        modeloT.addColumn("Valor_Unitario");
        modeloT.addColumn("Valor_Total");
       
        
        TableColumnModel columnModel = tablaclases1.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(30);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(150);
        columnModel.getColumn(3).setPreferredWidth(100);
        columnModel.getColumn(4).setPreferredWidth(120);
        columnModel.getColumn(5).setPreferredWidth(150);
        columnModel.getColumn(6).setPreferredWidth(100);
        columnModel.getColumn(7).setPreferredWidth(100);
        columnModel.getColumn(8).setPreferredWidth(100);
        columnModel.getColumn(9).setPreferredWidth(100);
       
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        
        columnModel.getColumn(0).setCellRenderer(tcr);
        columnModel.getColumn(3).setCellRenderer(tcr); 
         
        List<clases1> usuarios = new ArrayList<clases1>();
        clases1 = (clases1) mod.listaclases1();
        Object[] columna = new Object[11];
        
        int i = 1;
        
        
        for(clases1 clases1 : usuarios){
            columna[0] = i;
            columna[1] = clases1.cmbCuenta();
            columna[2] = clases1.cmbSubCuenta();
            columna[3] = clases1.cmbTalonario();
            columna[4] = clases1.fechaInicial();
             columna[5] = clases1.txtPersona();
            columna[6] = clases1.txtDetalle();
            columna[7] = clases1.txtCantidad();            
            columna[8] = clases1.txtValorUnitario();
            columna[9] = clases1.txtValorTotal();
            
            modeloT.addRow(columna);
            i++;
        } 
    }
   
}
