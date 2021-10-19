/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Gerencia Proyectos
 */
public class CajaMenor {
    private int id;
    private String  Codigo_Cuenta; 
    private String Codigo_Subcuenta;
    private String Codigo_Talonario;
    private String Fecha;
    private String Persona_Servicio;
    private String Detalle;
    private int Cantidad;
    private double Valor_Unitario;
    private double Valor_Total;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo_Cuenta() {
        return Codigo_Cuenta;
    }

    public void setCodigo_Cuenta(String Codigo_Cuenta) {
        this.Codigo_Cuenta = Codigo_Cuenta;
    }

    public String getCodigo_Subcuenta() {
        return Codigo_Subcuenta;
    }

    public void setCodigo_Subcuenta(String Codigo_Subcuenta) {
        this.Codigo_Subcuenta = Codigo_Subcuenta;
    }

    public String getCodigo_Talonario() {
        return Codigo_Talonario;
    }

    public void setCodigo_Talonario(String Codigo_Talonario) {
        this.Codigo_Talonario = Codigo_Talonario;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getPersona_Servicio() {
        return Persona_Servicio;
    }

    public void setPersona_Servicio(String Persona_Servicio) {
        this.Persona_Servicio = Persona_Servicio;
    }

    public String getDetalle() {
        return Detalle;
    }

    public void setDetalle(String Detalle) {
        this.Detalle = Detalle;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getValor_Unitario() {
        return Valor_Unitario;
    }

    public void setValor_Unitario(double Valor_Unitario) {
        this.Valor_Unitario = Valor_Unitario;
    }

    public double getValor_Total() {
        return Valor_Total;
    }

    public void setValor_Total(double Valor_Total) {
        this.Valor_Total = Valor_Total;
    }

     
 
}
