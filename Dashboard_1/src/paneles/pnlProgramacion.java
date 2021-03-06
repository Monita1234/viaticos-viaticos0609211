/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import Controlador.CtrlProgramacion;
import Modelo.Dependencia;
import Modelo.Empleado;
import Modelo.Municipio;
import dialogs.diaEditViatico;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AUXINVTIC
 */
public class pnlProgramacion extends javax.swing.JPanel {

    
    public pnlProgramacion() {
        initComponents();   
        ScrollTabla.setVisible(false);
        lblOtros.setVisible(false);
        txtObservaciones.setLineWrap(true);
        txtObservaciones.setWrapStyleWord(true);
        JLabel lab = new JLabel("Registro de programaciones"); 
        lab.setFont(new Font("Tahoma", Font.BOLD, 12));
        lab.setForeground(new Color(102,102,102));
        lab.setPreferredSize(new Dimension(180, 30)); 
        tp.setTabComponentAt(0, lab);
        
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tp = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtObservaciones = new javax.swing.JTextArea();
        jLabel27 = new javax.swing.JLabel();
        jdFechaSalida = new com.toedter.calendar.JDateChooser();
        jLabel24 = new javax.swing.JLabel();
        cbEmpleado = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        cbDestino = new javax.swing.JComboBox<>();
        jdFechaRegreso = new com.toedter.calendar.JDateChooser();
        jLabel23 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        cbDependencia = new javax.swing.JComboBox<>();
        checkDiaNoche = new javax.swing.JCheckBox();
        pnlCheck = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCostoViaticos = new javax.swing.JTable();
        tblHospedaje = new javax.swing.JScrollPane();
        tablaCostoViaticos_dos = new javax.swing.JTable();
        ScrollTabla = new javax.swing.JScrollPane();
        tablaCostoViaticos_otros = new javax.swing.JTable();
        lblHosped = new javax.swing.JLabel();
        lblOtros = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        btnClean = new javax.swing.JButton();
        btnSaveViatico = new javax.swing.JButton();
        txtIdUsuario = new javax.swing.JTextField();
        txtCargo = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProgramaciones = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblProgramacionesMun = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        tp.setBackground(new java.awt.Color(255, 255, 255));
        tp.setForeground(new java.awt.Color(102, 102, 102));
        tp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tpMouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informaci??n preliminar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N

        txtObservaciones.setColumns(20);
        txtObservaciones.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtObservaciones.setRows(5);
        jScrollPane5.setViewportView(txtObservaciones);

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel27.setText("Observaciones:");

        jdFechaSalida.setDateFormatString("d-MM-yyyy");
        jdFechaSalida.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel24.setText("Fecha de salida:");

        cbEmpleado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbEmpleado.setForeground(new java.awt.Color(51, 51, 51));
        cbEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbEmpleado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbEmpleadoItemStateChanged(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel25.setText("Fecha de regreso:");

        cbDestino.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbDestino.setForeground(new java.awt.Color(51, 51, 51));
        cbDestino.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbDestino.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbDestinoItemStateChanged(evt);
            }
        });

        jdFechaRegreso.setDateFormatString("d-MM-yyyy");
        jdFechaRegreso.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setText("Seleccione un empleado:");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel26.setText("Seleccione el destino:");

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel28.setText("Seleccione una dependencia:");

        cbDependencia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbDependencia.setForeground(new java.awt.Color(51, 51, 51));
        cbDependencia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbDependencia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbDependenciaItemStateChanged(evt);
            }
        });

        checkDiaNoche.setBackground(new java.awt.Color(255, 255, 255));
        checkDiaNoche.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        checkDiaNoche.setText("Dia y noche");
        checkDiaNoche.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkDiaNoche, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane5)
                        .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jdFechaSalida, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jLabel25)
                    .addComponent(jdFechaRegreso, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(cbDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbDependencia, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbEmpleado, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel28)
                .addGap(4, 4, 4)
                .addComponent(cbDependencia, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdFechaRegreso, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkDiaNoche)
                .addGap(36, 36, 36))
        );

        pnlCheck.setBackground(new java.awt.Color(255, 255, 255));
        pnlCheck.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Vi??ticos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N

        tablaCostoViaticos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tablaCostoViaticos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaCostoViaticos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaCostoViaticos.setGridColor(new java.awt.Color(204, 204, 204));
        tablaCostoViaticos.setRowHeight(25);
        tablaCostoViaticos.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tablaCostoViaticos.setSelectionForeground(new java.awt.Color(204, 51, 0));
        tablaCostoViaticos.setShowVerticalLines(false);
        jScrollPane1.setViewportView(tablaCostoViaticos);

        tablaCostoViaticos_dos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tablaCostoViaticos_dos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaCostoViaticos_dos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaCostoViaticos_dos.setGridColor(new java.awt.Color(204, 204, 204));
        tablaCostoViaticos_dos.setRowHeight(25);
        tablaCostoViaticos_dos.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tablaCostoViaticos_dos.setSelectionForeground(new java.awt.Color(204, 51, 0));
        tablaCostoViaticos_dos.setShowVerticalLines(false);
        tblHospedaje.setViewportView(tablaCostoViaticos_dos);

        tablaCostoViaticos_otros.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tablaCostoViaticos_otros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaCostoViaticos_otros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaCostoViaticos_otros.setGridColor(new java.awt.Color(204, 204, 204));
        tablaCostoViaticos_otros.setRowHeight(25);
        tablaCostoViaticos_otros.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tablaCostoViaticos_otros.setSelectionForeground(new java.awt.Color(204, 51, 0));
        tablaCostoViaticos_otros.setShowVerticalLines(false);
        ScrollTabla.setViewportView(tablaCostoViaticos_otros);

        lblHosped.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblHosped.setForeground(new java.awt.Color(102, 102, 102));
        lblHosped.setText("Hospedaje y alimentaci??n");

        lblOtros.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblOtros.setForeground(new java.awt.Color(102, 102, 102));
        lblOtros.setText("Vi??ticos autorizados");

        javax.swing.GroupLayout pnlCheckLayout = new javax.swing.GroupLayout(pnlCheck);
        pnlCheck.setLayout(pnlCheckLayout);
        pnlCheckLayout.setHorizontalGroup(
            pnlCheckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
            .addComponent(tblHospedaje, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(ScrollTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(lblHosped, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblOtros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlCheckLayout.setVerticalGroup(
            pnlCheckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCheckLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHosped)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tblHospedaje, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblOtros)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Panel de acciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N

        btnClean.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnClean.setForeground(new java.awt.Color(102, 102, 102));
        btnClean.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/broom.png"))); // NOI18N
        btnClean.setText("Limpiar");
        btnClean.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClean.setIconTextGap(6);
        btnClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanActionPerformed(evt);
            }
        });

        btnSaveViatico.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSaveViatico.setForeground(new java.awt.Color(102, 102, 102));
        btnSaveViatico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/diskette.png"))); // NOI18N
        btnSaveViatico.setText("Guardar");
        btnSaveViatico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSaveViatico.setIconTextGap(6);
        btnSaveViatico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveViaticoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(btnSaveViatico)
                .addGap(18, 18, 18)
                .addComponent(btnClean)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveViatico)
                    .addComponent(btnClean)
                    .addComponent(txtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(pnlCheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(35, 35, 35))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlCheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        tp.addTab("Registro programaciones", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tblProgramaciones.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblProgramaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblProgramaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblProgramaciones.setGridColor(new java.awt.Color(204, 204, 204));
        tblProgramaciones.setRowHeight(30);
        tblProgramaciones.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tblProgramaciones.setSelectionForeground(new java.awt.Color(204, 51, 0));
        tblProgramaciones.setShowVerticalLines(false);
        tblProgramaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProgramacionesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblProgramaciones);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
                .addContainerGap())
        );

        tp.addTab("Programaciones asignadas", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        tblProgramacionesMun.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblProgramacionesMun.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblProgramacionesMun.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblProgramacionesMun.setGridColor(new java.awt.Color(204, 204, 204));
        tblProgramacionesMun.setRowHeight(30);
        tblProgramacionesMun.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tblProgramacionesMun.setSelectionForeground(new java.awt.Color(204, 51, 0));
        tblProgramacionesMun.setShowVerticalLines(false);
        tblProgramacionesMun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProgramacionesMunMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblProgramacionesMun);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
                .addContainerGap())
        );

        tp.addTab("Programaciones t??cnicos municipios", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tp, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tp)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbEmpleadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbEmpleadoItemStateChanged
        CtrlProgramacion ctrl = new CtrlProgramacion();
        ctrl.llenarMunicipios(cbDestino);
        Empleado emp = (Empleado) cbEmpleado.getSelectedItem();
        Municipio mun = (Municipio) cbDestino.getSelectedItem();
        cbDestino.setSelectedIndex(0);
        DefaultTableModel modeloT = (DefaultTableModel) tablaCostoViaticos_dos.getModel();
        while(modeloT.getRowCount()>0)modeloT.removeRow(0);
        if(!emp.getId().equals("0")){
           if(emp.getId_municipio().equals(mun.getCodigo()) && !emp.getId_municipio().equals("01")){
                tblHospedaje.setVisible(false);
                lblHosped.setVisible(false);
            }else{
                tblHospedaje.setVisible(true);
                lblHosped.setVisible(true);
            }
            
            ctrl.agregarChecks(this, emp.getId_cargo(), emp.getId());
            ctrl.agregarChecksOtros(this, emp.getId());             
        }
        
        
        
        
    }//GEN-LAST:event_cbEmpleadoItemStateChanged

    private void btnCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanActionPerformed
        limpiar();
    }//GEN-LAST:event_btnCleanActionPerformed

    private void btnSaveViaticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveViaticoActionPerformed
        Empleado empleado = (Empleado) cbEmpleado.getSelectedItem();
        Municipio munici = (Municipio) cbDestino.getSelectedItem();
        Dependencia dep = (Dependencia) cbDependencia.getSelectedItem();
        int c = 0, d = 0, e = 0, p = 0;
        Date fechaInicial = jdFechaSalida.getDate();
        Date fechaFinal = jdFechaRegreso.getDate();
        Date fechaActual = new Date();
      
        for(int i=0; i<tablaCostoViaticos.getRowCount(); i++){
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
        }
        if (dep.getId_dependencia().equals("0")){
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
            JOptionPane.showMessageDialog(null, "Debe marcar m??nimo una opci??n \nde la lista.", "Importante", JOptionPane.WARNING_MESSAGE);
        }else if(fechaFinal.before(fechaInicial) ){
            JOptionPane.showMessageDialog(null, "La fecha de regreso debe ser igual \no superior a la fecha de salida. ", "Importante", JOptionPane.WARNING_MESSAGE);
        }else if(((fechaInicial.getTime()-fechaActual.getTime())/86400000) < 0){
            JOptionPane.showMessageDialog(null, "La fecha de salida debe ser igual \no superior a la fecha actual.", "Importante", JOptionPane.WARNING_MESSAGE);
        }else if(p > 1){
            JOptionPane.showMessageDialog(null, "Solo puede seleccionar una opci??n \npara el vi??tico de parqueaderos", "Importante", JOptionPane.WARNING_MESSAGE);
        }else{
            //JOptionPane.showMessageDialog(null, "ok", "Importante", JOptionPane.WARNING_MESSAGE);
            CtrlProgramacion ctrl = new CtrlProgramacion();
            ctrl.registrarViatico(this);
        }
        
    }//GEN-LAST:event_btnSaveViaticoActionPerformed

    private void cbDestinoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbDestinoItemStateChanged
        
        Municipio mun = (Municipio) cbDestino.getSelectedItem();
        Empleado empleado = (Empleado) cbEmpleado.getSelectedItem();
        if(!empleado.getId().equals("0")){
//            if(empleado.getId_municipio().equals(mun.getCodigo()) && !empleado.getId_municipio().equals("01")){
//                tblHospedaje.setVisible(false);
//                lblHosped.setVisible(false);
//            }else{
//                tblHospedaje.setVisible(true);
//                lblHosped.setVisible(true);
//            }
            CtrlProgramacion ctrl = new CtrlProgramacion();
            ctrl.agregarChecksMunicipio(this, mun.getCodigo());
        }
        
    }//GEN-LAST:event_cbDestinoItemStateChanged

    private void cbDependenciaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbDependenciaItemStateChanged
        Dependencia dep = (Dependencia) cbDependencia.getSelectedItem();
        Municipio mun = (Municipio) cbDestino.getSelectedItem();
        CtrlProgramacion ctrl = new CtrlProgramacion();
        ctrl.llenarEmpleados(cbEmpleado, dep.getId_dependencia());      
        
    }//GEN-LAST:event_cbDependenciaItemStateChanged

    private void tpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tpMouseClicked
        
        if(tp.getSelectedIndex() == 1){ 
            CtrlProgramacion ctrl = new CtrlProgramacion();
            if(txtCargo.getText().equals("1")){
                ctrl.listarProgramaciones(this);
            }
            if(txtCargo.getText().equals("2")){
                ctrl.listarProgramacionesDos(this);
            }
            if(txtCargo.getText().equals("3")){
                ctrl.listarProgramacionesTres(this);
            }            
        }
        if(tp.getSelectedIndex() == 2){
            CtrlProgramacion ctrl = new CtrlProgramacion();
            //JOptionPane.showMessageDialog(null, "");
            ctrl.listarProgramacionesTecMunicipios(this);
        }
    }//GEN-LAST:event_tpMouseClicked

    private void tblProgramacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProgramacionesMouseClicked
        int fila = tblProgramaciones.rowAtPoint(evt.getPoint());
        int columna = tblProgramaciones.columnAtPoint(evt.getPoint());
        
        if(columna == 9){
            validarSeleccion(fila, tblProgramaciones);
        }
        if(columna == 10){
            anularViatico(fila, tblProgramaciones, 1);
        }
    }//GEN-LAST:event_tblProgramacionesMouseClicked

    private void tblProgramacionesMunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProgramacionesMunMouseClicked
        int fila = tblProgramacionesMun.rowAtPoint(evt.getPoint());
        int columna = tblProgramacionesMun.columnAtPoint(evt.getPoint());
        
        if(columna == 9){
            validarSeleccion(fila, tblProgramacionesMun);
        }
        if(columna == 10){
            anularViatico(fila, tblProgramacionesMun, 2);
        }
    }//GEN-LAST:event_tblProgramacionesMunMouseClicked

    
    private void validarSeleccion(int fila, JTable tabla) {
        String id_viatico = tabla.getValueAt(fila, 11).toString();
        
        diaEditViatico dialog = new diaEditViatico(new java.awt.Frame(), true, id_viatico, this);
        dialog.setVisible(true);
    }
    
    private void anularViatico(int fila, JTable table, int p){
        String mensaje = "Desea anular los vi??ticos de: \n";
        mensaje += table.getValueAt(fila, 1).toString()+"\n";
        mensaje += "Con destino: "+table.getValueAt(fila, 2).toString()+"\n";
        
        int resp = JOptionPane.showConfirmDialog(null, mensaje, "Alerta!", JOptionPane.YES_NO_OPTION);
        switch(resp){
            case JOptionPane.YES_OPTION:
                CtrlProgramacion ctrl = new CtrlProgramacion();
                if(p == 1){
                    ctrl.cancelarViatico(Integer.parseInt(table.getValueAt(fila, 11).toString()), 3, this, table.getValueAt(fila, 12).toString());
                }else{
                    ctrl.cancelarViaticoMunicipio(Integer.parseInt(table.getValueAt(fila, 11).toString()), 3, this, table.getValueAt(fila, 12).toString());
                }
                
                
            break;
            case JOptionPane.NO_OPTION:
                
            break;        
        }
    }
    
    public boolean IsSelected(int row, int column, JTable tabla){
        Boolean checked = false;
        checked = Boolean.valueOf(tabla.getValueAt(row,column).toString());
        return checked;        
    }
    
    private void limpiar(){
        Dependencia dep = (Dependencia) cbDependencia.getSelectedItem();
        Municipio mun = (Municipio) cbDestino.getSelectedItem();
        Empleado empleado = (Empleado) cbEmpleado.getSelectedItem();
        
        if(!dep.getId_dependencia().equals("0")){
            cbDependencia.setSelectedIndex(0);
            if(!empleado.getId().equals("0")){
                cbEmpleado.setSelectedIndex(0);
                if(!mun.getCodigo().equals("0")){
                    cbDestino.setSelectedIndex(0);
                }
            }            
        }
        
        
        jdFechaSalida.setDate(null);
        jdFechaRegreso.setDate(null);
        txtObservaciones.setText("");
        DefaultTableModel modeloT = (DefaultTableModel) tablaCostoViaticos_dos.getModel();
        while(modeloT.getRowCount()>0)modeloT.removeRow(0);
        try {
            DefaultTableModel modelo=(DefaultTableModel) tablaCostoViaticos.getModel();
            int filas=tablaCostoViaticos.getRowCount();
            for (int i = 0;filas>i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JScrollPane ScrollTabla;
    private javax.swing.JButton btnClean;
    private javax.swing.JButton btnSaveViatico;
    public javax.swing.JComboBox<String> cbDependencia;
    public javax.swing.JComboBox<String> cbDestino;
    public javax.swing.JComboBox<String> cbEmpleado;
    public javax.swing.JCheckBox checkDiaNoche;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    public com.toedter.calendar.JDateChooser jdFechaRegreso;
    public com.toedter.calendar.JDateChooser jdFechaSalida;
    private javax.swing.JLabel lblHosped;
    public javax.swing.JLabel lblOtros;
    public javax.swing.JPanel pnlCheck;
    public javax.swing.JTable tablaCostoViaticos;
    public javax.swing.JTable tablaCostoViaticos_dos;
    public javax.swing.JTable tablaCostoViaticos_otros;
    private javax.swing.JScrollPane tblHospedaje;
    public javax.swing.JTable tblProgramaciones;
    public javax.swing.JTable tblProgramacionesMun;
    private javax.swing.JTabbedPane tp;
    public javax.swing.JTextField txtCargo;
    public javax.swing.JTextField txtIdUsuario;
    public javax.swing.JTextArea txtObservaciones;
    // End of variables declaration//GEN-END:variables

    
}
