/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author AUXINVTIC
 */
public class clases1 {
    
    String cmbCuenta;
    String cmbSubCuenta;
    String cmbTalonario;
    String fechaInicial;
    String txtPersona;
    String txtDetalle;
    String txtCantidad;
    String txtValorUnitario;
    String txtValorTotal;

    
  

    public String cmbCuenta() {
        return cmbCuenta;
    }

    public void getSelectedItem(String cmbCuenta) {
        this.cmbCuenta = cmbCuenta;
    }

    public String cmbSubCuenta() {
        return cmbSubCuenta;
    }

    public void cmbSubCuenta(String cmbSubCuenta) {
        this.cmbSubCuenta = cmbSubCuenta;
    }

    public String cmbTalonario() {
        return cmbTalonario;
    }

    public void cmbTalonario(String cmbTalonario) {
        this.cmbTalonario = cmbTalonario;
    }

    public String fechaInicial() {
        return fechaInicial;
    }

    public void fechaInicial(String fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public String txtPersona() {
        return txtPersona;
    }

    public void txtPersona(String txtPersona) {
        this.txtPersona = txtPersona;
    }

    public String txtDetalle() {
        return txtDetalle;
    }

    public void txtDetalle(String txtDetalle) {
        this.txtDetalle = txtDetalle;
    }

    public String txtValorUnitario() {
        return txtValorUnitario;
    }

    public void txtValorUnitario(String txtValorUnitario) {
        this.txtValorUnitario = txtValorUnitario;
    }
    
     public String txtValorTotal() {
        return txtValorTotal;
    }

    public void txtValorTotal(String txtValorTotal) {
        this.txtValorTotal = txtValorTotal;
    }
    
}