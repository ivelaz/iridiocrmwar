package com.ivelaz.iridiocrm.components;

import org.springframework.stereotype.Component;

import com.ivelaz.iridiocrm.entities.Cliente;
import com.ivelaz.iridiocrm.models.ClienteModel;

@Component("clienteConverter")
public class ClienteConverter {

	public Cliente ClienteModelACliente(ClienteModel clienteModel) {
		Cliente cliente = new Cliente();
		cliente.setId(clienteModel.getId());
		cliente.setLlamadas(clienteModel.getLlamadas());
		cliente.setNombre(clienteModel.getNombre());
		cliente.setDni(clienteModel.getDni());
		cliente.setTipoCliente(clienteModel.getTipoCliente());
		cliente.setTelefono(clienteModel.getTelefono());
		cliente.setEmail(clienteModel.getEmail());
		cliente.setDireccion(clienteModel.getDireccion());
		cliente.setNotas(clienteModel.getNotas());
		return cliente;
	}
	
	public ClienteModel ClienteAClienteModel(Cliente cliente) {
		ClienteModel clienteModel = new ClienteModel();
		clienteModel.setId(cliente.getId());
		clienteModel.setLlamadas(cliente.getLlamadas());
		clienteModel.setNombre(cliente.getNombre());
		clienteModel.setDni(cliente.getDni());
		clienteModel.setTipoCliente(cliente.getTipoCliente());
		clienteModel.setTelefono(cliente.getTelefono());
		clienteModel.setEmail(cliente.getEmail());
		clienteModel.setDireccion(cliente.getDireccion());
		clienteModel.setNotas(cliente.getNotas());
		return clienteModel;
	}
	
	
}
