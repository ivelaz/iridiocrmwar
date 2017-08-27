package com.ivelaz.iridiocrm.models;

import org.hibernate.validator.constraints.NotEmpty;

public class Busqueda {	
	
	
	private String tipoBusqueda;
	
	@NotEmpty
	private String palabraClave;
	
	public Busqueda() {}

	public Busqueda(String tipoBusqueda, String palabraClave) {
		super();
		this.tipoBusqueda = tipoBusqueda;
		this.palabraClave = palabraClave;
	}

	public String getTipoBusqueda() {
		return tipoBusqueda;
	}

	public void setTipoBusqueda(String tipoBusqueda) {
		this.tipoBusqueda = tipoBusqueda;
	}

	public String getPalabraClave() {
		return palabraClave;
	}

	public void setPalabraClave(String palabraClave) {
		this.palabraClave = palabraClave;
	}


	
}
