/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;

public class RegistrosTabla {
	private static RegistrosTabla singleton = null;
	private ArrayList<Registro> registros;
	
	private RegistrosTabla() {}
	
	public static RegistrosTabla getRegistrosTabla() {
		if(singleton == null) {
			singleton = new RegistrosTabla();
			singleton.registros = new ArrayList<>();
		}
		return singleton;
	}
	
	public void add(Registro registro) {
		this.registros.add(registro);
	}


    public List<Registro> getList() {
         return registros;
    }
     }
