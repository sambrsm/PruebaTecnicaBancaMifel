package com.pruebatecnicamifel.PruebaTecnicaMifel.vo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class ClaveSecretaVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String datos;
	private String clave;

	
	@Override
	public String toString() {
		return "ClaveSecretaVO [datos=" + datos + ", clave=" + clave + "]";
	}

	public ClaveSecretaVO() {
		
	}
	
	public ClaveSecretaVO( String datos,String clave) {
		this.datos = datos;
		this.clave = clave;
	
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getDatos() {
		return datos;
	}

	public void setDatos(String datos) {
		this.datos = datos;
	}
	
	
}