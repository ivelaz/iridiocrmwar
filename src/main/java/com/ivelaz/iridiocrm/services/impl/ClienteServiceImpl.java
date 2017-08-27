package com.ivelaz.iridiocrm.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ivelaz.iridiocrm.components.ClienteConverter;
import com.ivelaz.iridiocrm.entities.Cliente;
import com.ivelaz.iridiocrm.models.ClienteModel;
import com.ivelaz.iridiocrm.repositories.ClienteRepository;
import com.ivelaz.iridiocrm.services.ClienteService;

@Service("clienteServiceImpl")
public class ClienteServiceImpl implements ClienteService{
	
	private static final Log LOG = LogFactory.getLog(ClienteServiceImpl.class);

	@Autowired
	@Qualifier("clienteRepository")
	private ClienteRepository clienteRepository;
	
	@Autowired
	@Qualifier("clienteConverter")
	private ClienteConverter clienteConverter;
	
	
	@Transactional()
	@Override
	public ClienteModel addCliente(ClienteModel clienteModel) {
		
		Cliente cliente = clienteRepository.save(clienteConverter.ClienteModelACliente(clienteModel));
		LOG.info("id clienteModel:" + clienteModel.getId() + " id cliente:" + cliente.getId());
		return clienteConverter.ClienteAClienteModel(cliente);
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<ClienteModel> listarClientes() {
		List<ClienteModel> clienteModels = new ArrayList<ClienteModel>();
		List<Cliente> clientes = clienteRepository.findAll();
		for(Cliente cliente : clientes) {
			clienteModels.add(clienteConverter.ClienteAClienteModel(cliente));
		}
		return clienteModels;
	}

	@Transactional(readOnly=true)
	@Override
	public List<ClienteModel> buscarPorNombre(String palabraClave) {
		List<ClienteModel> clienteModels = new ArrayList<ClienteModel>();
		List<Cliente> clientes = clienteRepository.buscarPorNombre(palabraClave);
		for(Cliente cliente : clientes) {
			clienteModels.add(clienteConverter.ClienteAClienteModel(cliente));
		}
		return clienteModels;
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<ClienteModel> buscarPorDni(String palabraClave) {
		List<ClienteModel> clienteModels = new ArrayList<ClienteModel>();
		List<Cliente> clientes = clienteRepository.buscarPorDni(palabraClave);
		for(Cliente cliente : clientes) {
			clienteModels.add(clienteConverter.ClienteAClienteModel(cliente));
		}		
		return clienteModels;
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<ClienteModel> buscarPorTelefono(String palabraClave) {
		List<ClienteModel> clienteModels = new ArrayList<ClienteModel>();
		List<Cliente> clientes = clienteRepository.buscarPorTelefono(palabraClave);
		for(Cliente cliente : clientes) {
			clienteModels.add(clienteConverter.ClienteAClienteModel(cliente));
		}		
		return clienteModels;
	}

	@Transactional(readOnly=true)
	@Override
	public Cliente buscarClientePorId(int id) {
		return clienteRepository.findById(id);
	}

	@Transactional(readOnly=true)
	@Override
	public ClienteModel buscarClienteModelPorId(int id) {
		return clienteConverter.ClienteAClienteModel(buscarClientePorId(id));
	}

	@Transactional
	@Override
	public void borrarCliente(int id) {
		Cliente cliente = buscarClientePorId(id);
		if (cliente != null) {
			clienteRepository.delete(cliente);
		}
	}
	

}
