package com.ivelaz.iridiocrm.services;

import java.util.List;

import com.ivelaz.iridiocrm.entities.Cliente;
import com.ivelaz.iridiocrm.models.ClienteModel;

public interface ClienteService {

	public abstract ClienteModel addCliente(ClienteModel clienteModel);
	
	public abstract List<ClienteModel> listarClientes();
	
	public abstract List<ClienteModel> buscarPorNombre(String palabraClave);
	
	public abstract List<ClienteModel> buscarPorDni(String palabraClave);
	
	public abstract List<ClienteModel> buscarPorTelefono(String palabraClave);
	
	public abstract Cliente buscarClientePorId(int id);
	
	public abstract ClienteModel buscarClienteModelPorId(int id);
	
	public abstract void borrarCliente(int id);
}
