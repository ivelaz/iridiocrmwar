package com.ivelaz.iridiocrm.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@OneToMany(mappedBy = "cliente")
	private List<Llamada> llamadas;

	@Column(name = "nombre", nullable = false, length = 40)
	private String nombre;

	@Column(name = "dni", length = 10)
	private String dni;

	@Column(name = "tipocliente", length = 20)
	private String tipoCliente;

	@Column(name = "telefono", length = 14)
	private String telefono;

	@Column(name = "email", length = 40)
	private String email;

	@Column(name = "direccion", length = 50)
	private String direccion;

	@Column(name = "notas", length = 80)
	private String notas;

	public Cliente() {
	}

	public Cliente(List<Llamada> llamadas, String nombre, String dni, String tipoCliente, String telefono, String email,
			String direccion, String notas) {
		super();
		this.llamadas = llamadas;
		this.nombre = nombre;
		this.dni = dni;
		this.tipoCliente = tipoCliente;
		this.telefono = telefono;
		this.email = email;
		this.direccion = direccion;
		this.notas = notas;
	}
	
	

	public Cliente(String nombre, String dni, String tipoCliente, String telefono, String email, String direccion,
			String notas) {
		super();
		this.nombre = nombre;
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

	public List<Llamada> getLlamadas() {
		return llamadas;
	}

	public void setLlamadas(List<Llamada> llamadas) {
		this.llamadas = llamadas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
		return "Cliente [id=" + id + ", llamadas=" + llamadas + ", nombre=" + nombre + ", dni=" + dni + ", tipoCliente="
				+ tipoCliente + ", telefono=" + telefono + ", email=" + email + ", direccion=" + direccion + ", notas="
				+ notas + "]";
	}

}
