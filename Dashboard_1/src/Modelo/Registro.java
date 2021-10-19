/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


public class Registro {
	private String cuenta;
	private String subCuenta;
	private String talonario;
	private String fecha;
	private String persona;
	private String detalle;
	private String cantidad;
	private String valorUnitario;
	private String valorTotal;
	
	public String getCuenta() {
		return cuenta;
	}
	
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	
	public String getSubCuenta() {
		return subCuenta;
	}
	
	public void setSubCuenta(String subCuenta) {
		this.subCuenta = subCuenta;
	}
	
	public String getTalonario() {
		return talonario;
	}
	
	public void setTalonario(String talonario) {
		this.talonario = talonario;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public String getPersona() {
		return persona;
	}
	
	public void setPersona(String persona) {
		this.persona = persona;
	}
	
	public String getDetalle() {
		return detalle;
	}
	
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	
	public String getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	
	public String getValorUnitario() {
		return valorUnitario;
	}
	
	public void setValorUnitario(String valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	
	public String getValorTotal() {
		return valorTotal;
	}
	
	public void setValorTotal(String valorTotal) {
		this.valorTotal = valorTotal;
	}
}


