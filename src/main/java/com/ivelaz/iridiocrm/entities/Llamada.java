package com.ivelaz.iridiocrm.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "llamadas")
public class Llamada {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
		
	@ManyToOne
	@JoinColumn(name = "clienteid")
	private Cliente cliente;

	@Column(name = "fecha")
	private Date fecha;

	@Column(name = "tipo", length = 20)
	private String tipo;	
	
	@Column(name = "telefono", length = 14)
	private String telefono;
	
	@Column(name = "asunto", length = 50)
	private String asunto;

	@Column(name = "observaciones", length = 200)
	private String observaciones;

	public Llamada() {
	}

	public Llamada(Cliente cliente, Date fecha, String tipo, String telefono, String asunto, String observaciones) {
		super();
		this.cliente = cliente;
		this.fecha = fecha;
		this.tipo = tipo;
		this.telefono = telefono;
		this.asunto = asunto;
		this.observaciones = observaciones;
	}

	public Llamada(Date fecha, String tipo, String telefono, String asunto, String observaciones) {
		super();
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
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

	@Override
	public String toString() {
		return "Llamada [id=" + id + ", cliente=" + cliente + ", fecha=" + fecha + ", tipo=" + tipo + ", telefono="
				+ telefono + ", asunto=" + asunto + ", observaciones=" + observaciones + "]";
	}

}
