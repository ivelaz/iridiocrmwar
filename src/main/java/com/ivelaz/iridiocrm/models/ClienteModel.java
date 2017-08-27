package com.ivelaz.iridiocrm.models;

import java.util.List;

//import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.ivelaz.iridiocrm.entities.Llamada;

public class ClienteModel {

	private int id;

	@NotEmpty
	@Size(min = 2, max = 40)
	private String nombre;	
	
	private List<Llamada> llamadas;	// Lista de llamadas

	@NotEmpty
	@Size(min = 6, max = 10)
	private String dni;

	private String tipoCliente; 	// Particular, Autónomo o Empresa

	@NotEmpty
	@Size(min = 9, max = 14)
	private String telefono;

	@Email
	@NotEmpty
	private String email;

	@NotEmpty
	@Size(min = 2, max = 50)
	private String direccion;

	@Size(max = 80)
	private String notas;

	public ClienteModel() {
	}

	public ClienteModel(int id, String nombre, List<Llamada> llamadas, String dni, String tipoCliente, String telefono,
			String email, String direccion, String notas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.llamadas = llamadas;
		this.dni = dni;
		this.tipoCliente = tipoCliente;
		this.telefono = telefono;
		this.email = email;
		this.direccion = direccion;
		this.notas = notas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Llamada> getLlamadas() {
		return llamadas;
	}

	public void setLlamadas(List<Llamada> llamadas) {
		this.llamadas = llamadas;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	@Override
	public String toString() {
		return "ClienteModel [id=" + id + ", nombre=" + nombre + ", dni=" + dni + ", tipoCliente=" + tipoCliente
				+ ", telefono=" + telefono + ", email=" + email + ", direccion=" + direccion + ", notas=" + notas + "]";
	}

}
