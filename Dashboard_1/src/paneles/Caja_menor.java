/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import Controlador.CtrlProgramacion;
import Controlador.CtrlReportes;
import Controlador.CtrlTecnicos;
import Controlador.CtrlUsuarios;
import Modelo.ConsultaEmpleados;
import Modelo.ConsultaUsuarios;
import Modelo.Registro;
import Modelo.Registrogeneral;
import java.awt.Color;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PopupMenu;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.text.SimpleDateFormat;
import java.util.Vector;
import Modelo.RegistrosTabla;
import java.io.File;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import paneles.CambiaPanel;
import paneles.pnlAutorizacion;
import paneles.Caja_menor;
import paneles.pnlListaTecnicos;
import paneles.pnlProgramacion;
import paneles.pnlSettings;
import paneles.pnlUsuarios;
import paneles.Agregar_cuentas;
import paneles.clases;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTable;

/**
 *
 * @author Gerencia Proyectos
 */
public class Caja_menor extends javax.swing.JPanel {

    CtrlReportes ctrl = new CtrlReportes();
    File archivo;
    Vector nuevafila;
    JFileChooser selecArchivo = new JFileChooser();
    DefaultTableModel modelotabla;
    RegistrosTabla registrosTabla = RegistrosTabla.getRegistrosTabla();
    RegistrosTabla1 registrosTabla1 = RegistrosTabla1.getRegistrosTabla();
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    JTable tablaclases2 = new JTable();
    
    private void initComponents2() {
        tablaclases2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tablaclases2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tablaclases2.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null}
                },
                new String[]{
                    "Fecha", "Detalle", "ValorTotalIngresos", "ValorTotalEgresos"}
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
    }
    
    public Caja_menor(String nombre, String id_usuario, String cargo) {
        initComponents();
        initComponents2();
        
        lblUsuario.setText(nombre.toUpperCase());
        txtId.setText(id_usuario);
        txtId.setVisible(false);

        listacuentas.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                llenarTabla();
            }
        });
        
        lblUsuario.setText(nombre.toUpperCase());
        txtId.setText(id_usuario);
        txtId.setVisible(false);

        listacuentas2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                llenarTabla1();
            }
        });
    }

    public Caja_menor() {
        initComponents();
//        this.uno.setSelected(true);
        listacuentas.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                llenarTabla();
            }
        });


    }

    public void llenarregistro() {
        // Generas un nuevo registro para llevarlo a la tabla
        Registro r = new Registro();
        r.setCuenta(cmbCuenta.getSelectedItem().toString());
        r.setSubCuenta(cmbSubCuenta.getSelectedItem().toString());
        r.setTalonario(cmbTalonario.getSelectedItem().toString());
        r.setFecha(df.format(fechaInicial.getDate()));
        r.setPersona(txtPersona.getText());
        r.setDetalle(txtDetalle.getText());
        r.setCantidad(txtCantidad.getText());
        r.setValorUnitario(txtValorUnitario.getText());
        r.setValorTotal(txtValorTotal.getText());
        registrosTabla.add(r);

        llenarTabla();
    }
    
    public void llenarregistrogeneral() {
        // Generas un nuevo registro para llevarlo a la tabla
        Registrogeneral r = new Registrogeneral();
        r.setFecha(df.format(fechaInicial.getDate()));
        r.setDetalle(txtDetalle.getText());
        r.setValorcuenta(txtValorcuenta.getText());
        r.setValorTotal(txtValorTotal.getText());
        registrosTabla1.add(r);

        llenarTabla1();
    }

    public void llenarTabla() {
        // rellena la tabla según la información guardada en registrosTabla y lo seleccionado en el comboBox
        modelotabla = (DefaultTableModel) this.tablaclases1.getModel();
        modelotabla.setRowCount(0);
        for (Registro registro : registrosTabla.getList()) {
            if (Integer.parseInt(String.valueOf(registro.getCuenta().charAt(0))) == listacuentas.getSelectedIndex()) {
                int ultimaFila = this.Agregar_Fila() - 1;
                this.tablaclases1.setValueAt(registro.getCuenta(), ultimaFila, 0);
                this.tablaclases1.setValueAt(registro.getSubCuenta(), ultimaFila, 1);
                this.tablaclases1.setValueAt(registro.getTalonario(), ultimaFila, 2);
                this.tablaclases1.setValueAt(registro.getFecha(), ultimaFila, 3);
                this.tablaclases1.setValueAt(registro.getPersona(), ultimaFila, 4);
                this.tablaclases1.setValueAt(registro.getDetalle(), ultimaFila, 5);
                this.tablaclases1.setValueAt(registro.getCantidad(), ultimaFila, 6);
                this.tablaclases1.setValueAt(registro.getValorUnitario(), ultimaFila, 7);
                this.tablaclases1.setValueAt(registro.getValorTotal(), ultimaFila, 8);
            }
        }
        jScrollPane2.setViewportView(tablaclases1);
    }
    
    
    
    //llenartablageneralo
     public void llenarTabla1() {
        // rellena la tabla según la información guardada en registrosTabla y lo seleccionado en el comboBox
        modelotabla = (DefaultTableModel) this.tablaclases2.getModel();
        modelotabla.setRowCount(0);
        for (Registrogeneral registrogeneral : registrosTabla1.getList()) {
            if (Integer.parseInt(String.valueOf(registrogeneral.getCuenta().charAt(0))) == listacuentas2.getSelectedIndex()) {
                int ultimaFila = this.Agregar_Fila() - 1;
                this.tablaclases2.setValueAt(registrogeneral.getFecha(), ultimaFila, 1);
                this.tablaclases2.setValueAt(registrogeneral.getDetalle(), ultimaFila, 2);
                this.tablaclases2.setValueAt(registrogeneral.getValorcuenta(), ultimaFila, 3);
                this.tablaclases2.setValueAt(registrogeneral.getValorTotal(), ultimaFila, 4);
            }
        }
        jScrollPane2.setViewportView(tablaclases2);
    }



    public int Agregar_Fila() {
        tablaclases1.setModel(modelotabla);
        nuevafila = new Vector<>();
        nuevafila.add(null);
        modelotabla.addRow(nuevafila);
        return modelotabla.getRowCount();
    }

    public int getCuentasIndex() {
        return listacuentas.getSelectedIndex();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        listacuentas = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        cajaPanel = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtPersona = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtValorUnitario = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtValorTotal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDetalle = new javax.swing.JTextArea();
        fechaInicial = new com.toedter.calendar.JDateChooser();
        jPanel8 = new javax.swing.JPanel();
        cmbCuenta = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbSubCuenta = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cmbTalonario = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        guadar = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaclases1 = new javax.swing.JTable();
        Lbtotal = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        fechaInicial1 = new com.toedter.calendar.JDateChooser();
        fechaFinal = new com.toedter.calendar.JDateChooser();
        seleccionarreportes = new javax.swing.JComboBox<>();
        buscar = new javax.swing.JButton();
        limpiar = new javax.swing.JButton();
        exportar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblReporte = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        fechaInicial2 = new com.toedter.calendar.JDateChooser();
        fechaFinal1 = new com.toedter.calendar.JDateChooser();
        seleccionarreportes1 = new javax.swing.JComboBox<>();
        buscar1 = new javax.swing.JButton();
        limpiar1 = new javax.swing.JButton();
        exportar1 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablageneral = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel2.setBackground(new java.awt.Color(204, 0, 0));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Lista de Cuentas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        listacuentas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        listacuentas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lista de Cuentas", "1. Ingresos", "4. Egresos" }));
        listacuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listacuentasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listacuentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(listacuentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jPanel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Fecha");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Persona/Servicio");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Detalle");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Cantidad");

        txtCantidad.setText("1");
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Valor Unitario");

        txtValorUnitario.setText("0.00");
        txtValorUnitario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtValorUnitarioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorUnitarioKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Valor Total");

        txtValorTotal.setEditable(false);
        txtValorTotal.setText("0.00");

        txtDetalle.setColumns(20);
        txtDetalle.setRows(5);
        jScrollPane1.setViewportView(txtDetalle);

        fechaInicial.setDateFormatString("d-MM-yyyy");
        fechaInicial.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9))
                .addGap(67, 67, 67)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1)
                    .addComponent(fechaInicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPersona))
                .addGap(0, 613, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(fechaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel5))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel6))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(148, Short.MAX_VALUE))
        );

        jPanel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cmbCuenta.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmbCuenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar la Cuenta:", "1. Ingresos", "2. Pasivos", "3. Patrimonio", "4. Egresos", "5. Gastos" }));
        cmbCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCuentaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Codigo_Cuenta");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Codigo_SubCuenta");

        cmbSubCuenta.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmbSubCuenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione la Subcuenta:", "11. Disponible", "1105. Caja", "110505. Caja General", "110510. Cajas Menores", "121595. Otros", "21. Obligaciones Financieras", "2105. Bancos Nacionales", "210505. Sobregiros", "210510. Pagares", "210515. Cartas de Credito", "210520. Aceptaciones Bancarias", "2110 Bancos del Exterior", "211005. Sobregiros", "211015. Cartas de Credito", "31. Capital Social", "3105. Capital Suscrito y Pago", "310505. Capital Autorizado", "310510. Capital por suscriptor(Bd)", "319515. Capital Suscrito por Cobrar", "3114. Aportes Sociales", "311505. Cuotas o partes de Interes Social", "31330.Capital de Persona Natural", "330595. Otros", "4. Egresos", "51. Operacionales de Administración", "5105. Gasto de Personal", "510503. Salario Integral", "510506. Sueldos", "510512. Jornales", "510515. Horas Extras y Recargos", "510518. Comiciones", "510521. Viaticos", "510595. Otros" }));
        cmbSubCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSubCuentaActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Codigo_Talonario");

        cmbTalonario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmbTalonario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el No del Talonario:", "Activos", "Item 1", "Item 2", "Item 3", "Item 4", "Pasivos", "Item 1", "Item 2", "Item 3", "Item 4", "Patrimonio", "Item 1", "Item 2", "Item 3", "Item 4", "Ingresos", "Item 1", "Item 2", "Item 3", "Item 4", "Gatos", "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTalonario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTalonarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(cmbCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(178, 178, 178)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(cmbSubCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(cmbTalonario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(145, 145, 145))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbSubCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTalonario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        guadar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/diskette.png"))); // NOI18N
        guadar.setText("Guardar");
        guadar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guadarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(390, 390, 390)
                .addComponent(guadar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(guadar))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jTabbedPane1.addTab("Cuentas", jPanel6);

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
        jScrollPane2.setViewportView(tablaclases1);

        Lbtotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Valor total:");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1026, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Lbtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Lbtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel14)))
                .addGap(14, 14, 14))
        );

        jTabbedPane1.addTab("SubCuentas", jPanel10);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Fecha_Inicial");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Fecha_final");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Reportes");

        fechaInicial1.setDateFormatString("d-MM-yyyy");
        fechaInicial1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        fechaFinal.setDateFormatString("d-MM-yyyy");
        fechaFinal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        seleccionarreportes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        seleccionarreportes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar Reporte:", "Reporte Cuentas Ingresos", "Reporte Cuenta Egresos", "Reporte General" }));
        seleccionarreportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarreportesActionPerformed(evt);
            }
        });

        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/broom2.png"))); // NOI18N
        limpiar.setText("Limpiar");
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });

        exportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/excel2.png"))); // NOI18N
        exportar.setText("Exportar");
        exportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportarActionPerformed(evt);
            }
        });

        tblReporte.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblReporte.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblReporte.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblReporte.setGridColor(new java.awt.Color(204, 204, 204));
        tblReporte.setRowHeight(25);
        tblReporte.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tblReporte.setSelectionForeground(new java.awt.Color(204, 51, 0));
        tblReporte.setShowVerticalLines(false);
        tblReporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblReporteMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblReporte);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(fechaInicial1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(79, 79, 79)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(fechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(seleccionarreportes, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addComponent(buscar)
                        .addGap(30, 30, 30)
                        .addComponent(limpiar)
                        .addGap(31, 31, 31)
                        .addComponent(exportar))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 971, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fechaInicial1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(seleccionarreportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(limpiar)
                        .addComponent(exportar)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1054, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(26, Short.MAX_VALUE)))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 641, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Reportes de Cuentas", jPanel12);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Fecha_Inicial");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Fecha_final");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Reportes");

        fechaInicial2.setDateFormatString("d-MM-yyyy");
        fechaInicial2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        fechaFinal1.setDateFormatString("d-MM-yyyy");
        fechaFinal1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        seleccionarreportes1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        seleccionarreportes1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar Reporte:", "Reporte General" }));
        seleccionarreportes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarreportes1ActionPerformed(evt);
            }
        });

        buscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        buscar1.setText("Buscar");
        buscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar1ActionPerformed(evt);
            }
        });

        limpiar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/broom2.png"))); // NOI18N
        limpiar1.setText("Limpiar");
        limpiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiar1ActionPerformed(evt);
            }
        });

        exportar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/excel2.png"))); // NOI18N
        exportar1.setText("Exportar");
        exportar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportar1ActionPerformed(evt);
            }
        });

        tablageneral.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tablageneral);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Valor Total:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setText("0");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(fechaInicial2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(79, 79, 79)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16)
                            .addComponent(fechaFinal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(seleccionarreportes1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addComponent(buscar1)
                        .addGap(30, 30, 30)
                        .addComponent(limpiar1)
                        .addGap(31, 31, 31)
                        .addComponent(exportar1))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 929, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(79, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addGap(189, 189, 189))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fechaInicial2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fechaFinal1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(seleccionarreportes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(limpiar1)
                        .addComponent(exportar1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1054, Short.MAX_VALUE)
            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel15Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(26, Short.MAX_VALUE)))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 641, Short.MAX_VALUE)
            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Reporte General", jPanel15);

        javax.swing.GroupLayout cajaPanelLayout = new javax.swing.GroupLayout(cajaPanel);
        cajaPanel.setLayout(cajaPanelLayout);
        cajaPanelLayout.setHorizontalGroup(
            cajaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cajaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        cajaPanelLayout.setVerticalGroup(
            cajaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cajaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cajaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cajaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void listacuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listacuentasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listacuentasActionPerformed

    private void tblReporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblReporteMouseClicked
        int fila = tblReporte.rowAtPoint(evt.getPoint());
        int columna = tblReporte.columnAtPoint(evt.getPoint());

        if (columna == 12) {
            //JOptionPane.showMessageDialog(null,"Bien");
            validarSeleccion(fila);
        }
    }//GEN-LAST:event_tblReporteMouseClicked

    private void exportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportarActionPerformed
        // TODO add your handling code here:
        archivo = selecArchivo.getSelectedFile();
        archivo = new File(archivo.toString() + ".csv");
        ctrl.caja_menorreportes(this, archivo);

    }//GEN-LAST:event_exportarActionPerformed

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_limpiarActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed

        if (fechaInicial1.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Ingrese una fecha inicial.");
        }
        if (fechaFinal.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Ingrese una fecha final.");
        }/*else if(tipo.getIdTipoDoc().equals("0")){
            JOptionPane.showMessageDialog(null, "Seleccione un tipo de reporte");
        }*/ else {

            //                ctrl.consultarreportecaja_menor(this, 1);
            ctrl.consultarreportecaja_menor(this);

        }
    }//GEN-LAST:event_buscarActionPerformed

    private void seleccionarreportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarreportesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seleccionarreportesActionPerformed

    private void guadarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guadarActionPerformed
        // TODO add your handling code here:
        this.CalcularSubTotal();
        //Control1.setLayout(new javax.swing.BoxLayout(Control1, javax.swing.BoxLayout.LINE_AXIS));
        //new CambiaPanel(Control1,new lista_clases1());
        //lista_clases1 p = new lista_clases1();
        //Principal f = new Principal();
        //f.getContentPane().add(p);
        //lista_clases1 ctrl = new lista_clases1();

        //ctrl.prueba(this);
        //Caja_menor ctrl = new Caja_menor();
        //ctrl.prueba(this);
        //String persona = txtPersona.getText();
        //lbprueba.setText(persona);
        llenarregistro();

        contartotal();

        String strDateFormat = "yyy-MM-dd"; // El formato de fecha está especificado  
        SimpleDateFormat f = new SimpleDateFormat(strDateFormat);
        Date fechaprueba = fechaInicial.getDate();
        String feActual = f.format(fechaprueba);

        /*Date hora = new Date();
        String strHoraFormat = "hh:mm:ss"; // El formato de fecha está especificado  
        SimpleDateFormat h = new SimpleDateFormat(strHoraFormat);
        String hoActual = h.format(hora);*/
        // llenarregistro();
        //contartotal();
        String Codigo_Cuenta = cmbCuenta.getSelectedItem().toString();
        String Codigo_Subcuenta = cmbSubCuenta.getSelectedItem().toString();
        String Codigo_Talonario = cmbTalonario.getSelectedItem().toString();

        int c = 0, d = 0, e = 0, p = 0;
        //Date Fechaprueba = fechaInicial.getDate();
        fechaInicial.setDate(fechaprueba);

        /*for(int i=0; i<tablaCostoViaticos.getRowCount(); i++){
            if(IsSelected(i, 3, tablaCostoViaticos)){
                if(tablaCostoViaticos.getValueAt(i, 0).equals("1")){
                    p++;
                }
                c++;                
            }
        }
        for(int i=0; i<tablaCostoViaticos_dos.getRowCount(); i++){
            if(IsSelected(i, 3, tablaCostoViaticos_dos)){
                d++;                
            }
        }
        
        for(int i=0; i<tablaCostoViaticos_otros.getRowCount(); i++){
            if(IsSelected(i, 5, tablaCostoViaticos_otros)){
                d++;                
            }
        }*/
 /*if (dep.getId_dependencia().equals("0")){
            JOptionPane.showMessageDialog(null, "Seleccione una dependencia.", "Importante", JOptionPane.WARNING_MESSAGE);
        }       
        else if(empleado.getId().equals("0")){
            JOptionPane.showMessageDialog(null, "Seleccione un empleado.", "Importante", JOptionPane.WARNING_MESSAGE);
        }else if (munici.getCodigo().equals("0")){
            JOptionPane.showMessageDialog(null, "Seleccione un destino.", "Importante", JOptionPane.WARNING_MESSAGE);
        }else if(jdFechaSalida.getDate() == null){
            JOptionPane.showMessageDialog(null, "Ingrese la fecha de salida.", "Importante", JOptionPane.WARNING_MESSAGE);
        }else if(jdFechaRegreso.getDate() == null){
            JOptionPane.showMessageDialog(null, "Ingrese la fecha de regreso.", "Importante", JOptionPane.WARNING_MESSAGE);
        }else if(c == 0 && d == 0 && e == 0){
            JOptionPane.showMessageDialog(null, "Debe marcar mínimo una opción \nde la lista.", "Importante", JOptionPane.WARNING_MESSAGE);
        }else if(fechaFinal.before(fechaInicial) ){
            JOptionPane.showMessageDialog(null, "La fecha de regreso debe ser igual \no superior a la fecha de salida. ", "Importante", JOptionPane.WARNING_MESSAGE);
        }else if(((fechaInicial.getTime()-fechaActual.getTime())/86400000) < 0){
            JOptionPane.showMessageDialog(null, "La fecha de salida debe ser igual \no superior a la fecha actual.", "Importante", JOptionPane.WARNING_MESSAGE);
        }else if(p > 1){
            JOptionPane.showMessageDialog(null, "Solo puede seleccionar una opción \npara el viático de parqueaderos", "Importante", JOptionPane.WARNING_MESSAGE);
        }else{
            //JOptionPane.showMessageDialog(null, "ok", "Importante", JOptionPane.WARNING_MESSAGE);
            CtrlProgramacion ctrl = new CtrlProgramacion();
            ctrl.registrarViatico(this);
        }^*/
        CtrlProgramacion ctrl = new CtrlProgramacion();
        ctrl.registrarCaja_menor(this);


    }//GEN-LAST:event_guadarActionPerformed

    private void cmbTalonarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTalonarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTalonarioActionPerformed

    private void cmbSubCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSubCuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbSubCuentaActionPerformed

    private void txtValorUnitarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorUnitarioKeyTyped
        // TODO add your handling code here:
        //CalcularSubTotal();
    }//GEN-LAST:event_txtValorUnitarioKeyTyped

    private void txtValorUnitarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorUnitarioKeyPressed
        // TODO add your handling code here:
        //this.CalcularSubTotal();
    }//GEN-LAST:event_txtValorUnitarioKeyPressed

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        // TODO add your handling code here:
        //CalcularSubTotal();
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void txtCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyPressed
        // TODO add your handling code here:
        //this.CalcularSubTotal();
    }//GEN-LAST:event_txtCantidadKeyPressed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void cmbCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCuentaActionPerformed

    private void seleccionarreportes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarreportes1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seleccionarreportes1ActionPerformed

    
    //reportegeneral
    private void buscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar1ActionPerformed
        // TODO add your handling code here:
         if (fechaInicial1.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Ingrese una fecha inicial.");
        }
        if (fechaFinal.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Ingrese una fecha final.");
        }/*else if(tipo.getIdTipoDoc().equals("0")){
            JOptionPane.showMessageDialog(null, "Seleccione un tipo de reporte");
        }*/ else {

            //                ctrl.consultarreportecaja_menor(this, 1);
            ctrl.consultarreportegeneralcaja_menor(this);

        }
    }//GEN-LAST:event_buscar1ActionPerformed

    private void limpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiar1ActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_limpiar1ActionPerformed

    private void exportar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportar1ActionPerformed
        // TODO add your handling code here:
          archivo = selecArchivo.getSelectedFile();
        archivo = new File(archivo.toString() + ".csv");
        ctrl.caja_menorreportes(this, archivo);
    }//GEN-LAST:event_exportar1ActionPerformed

    public void CalcularSubTotal() {
        int cantidad = 0;
        double valor_unitario = 0.00;

        cantidad = Integer.parseInt(this.txtCantidad.getText());
        valor_unitario = Double.parseDouble(this.txtValorUnitario.getText());

        this.txtValorTotal.setText(String.valueOf(cantidad * valor_unitario));
    }

    public void limpiar() {
        fechaInicial.setDate(null);
        fechaFinal.setDate(null);
        seleccionarreportes.setSelectedIndex(0);
        DefaultTableModel modelo = (DefaultTableModel) tblReporte.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        
    
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Lbtotal;
    private javax.swing.JButton buscar;
    private javax.swing.JButton buscar1;
    private javax.swing.JPanel cajaPanel;
    public javax.swing.JComboBox<String> cmbCuenta;
    public javax.swing.JComboBox<String> cmbSubCuenta;
    public javax.swing.JComboBox<String> cmbTalonario;
    private javax.swing.JButton exportar;
    private javax.swing.JButton exportar1;
    public com.toedter.calendar.JDateChooser fechaFinal;
    public com.toedter.calendar.JDateChooser fechaFinal1;
    public com.toedter.calendar.JDateChooser fechaInicial;
    public com.toedter.calendar.JDateChooser fechaInicial1;
    public com.toedter.calendar.JDateChooser fechaInicial2;
    private javax.swing.JButton guadar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton limpiar;
    private javax.swing.JButton limpiar1;
    private javax.swing.JComboBox<String> listacuentas;
    private javax.swing.JComboBox<String> seleccionarreportes;
    private javax.swing.JComboBox<String> seleccionarreportes1;
    private javax.swing.JTable tablaclases1;
    public javax.swing.JTable tablageneral;
    public javax.swing.JTable tblReporte;
    public javax.swing.JTextField txtCantidad;
    public javax.swing.JTextArea txtDetalle;
    public javax.swing.JTextField txtPersona;
    public javax.swing.JTextField txtValorTotal;
    public javax.swing.JTextField txtValorUnitario;
    // End of variables declaration//GEN-END:variables
   private javax.swing.JTextField txtId;
   public javax.swing.JTextField txtValorcuenta;
   private javax.swing.JLabel lblUsuario;
   private javax.swing.JPanel pnlBarraMenu;
   private javax.swing.JPanel pnlCentro;
   private javax.swing.JPanel pnlMenu;
   private javax.swing.JPanel pnlPrincipal;
   private javax.swing.JComboBox<String> listacuentas2;

    private void pack() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void validarSeleccion(int fila) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void Settext(JLabel jLabel15) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static class Agregar_Cuentas {

        public Agregar_Cuentas() {
        }
    }

    public void contartotal() {
        double t = 0;
        double p = 0;
        if (tablaclases1.getRowCount() > 0) {
            for (int i = 0; i < tablaclases1.getRowCount(); i++) {
                p = Double.parseDouble(tablaclases1.getValueAt(i, 8).toString());
                t += p;
            }
            Lbtotal.setText("" + t);

        } else {
        }
    }

}
