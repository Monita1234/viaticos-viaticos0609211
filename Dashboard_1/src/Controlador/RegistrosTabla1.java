/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import paneles.*;
import Modelo.Registrogeneral;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gerencia Proyectos
 */
class RegistrosTabla1 {
  private static RegistrosTabla1 singleton = null;
	private ArrayList<Registrogeneral> registrogeneral;
	
	private RegistrosTabla1() {}
	
	public static RegistrosTabla1 getRegistrosTabla() {
		if(singleton == null) {
			singleton = new RegistrosTabla1();
			singleton.registrogeneral = new ArrayList<>();
		}
		return singleton;
	}
	
	public void add(Registrogeneral registro) {
		this.registrogeneral.add(registro);
	}


    public List<Registrogeneral> getList() {
         return registrogeneral;
    }  
}

    

