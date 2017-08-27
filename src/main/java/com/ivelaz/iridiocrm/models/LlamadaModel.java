package com.ivelaz.iridiocrm.models;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class LlamadaModel {	

	private int id;		

	private int cliente;

	private String fecha;

	private String tipo;	

	@NotEmpty
	@Size(min=2, max=14)
	private String telefono;

	@NotEmpty
	@Size(min=2, max=50)
	private String asunto;
	
	@NotEmpty
	@Size(min=2, max=200)
	private String observaciones;
	
	public LlamadaModel() {}

	public LlamadaModel(int cliente, String fecha, String tipo, String telefono, String asunto, String observaciones) {
		super();
		this.cliente = cliente;
		this.fecha = fecha;
		this.tipo = tipo;
		this.telefono = telefono;
		this.asunto = asunto;
		this.observaciones = observaciones;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCliente() {
		return cliente;
	}

	public void setCliente(int cliente) {
		this.cliente = cliente;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	
}
