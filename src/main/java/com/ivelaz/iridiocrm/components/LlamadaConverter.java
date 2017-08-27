package com.ivelaz.iridiocrm.components;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ivelaz.iridiocrm.entities.Llamada;
import com.ivelaz.iridiocrm.models.LlamadaModel;
import com.ivelaz.iridiocrm.services.ClienteService;

@Component("llamadaConverter")
public class LlamadaConverter {
	
	@Autowired
	@Qualifier("clienteServiceImpl")
	ClienteService clienteService;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	
	private Log LOG = LogFactory.getLog(LlamadaConverter.class);
	
	
	
	public Llamada llamadaModelALlamada(LlamadaModel llamadaModel) {
		Llamada llamada = new Llamada();
		llamada.setId(llamadaModel.getId());	
		try {
		llamada.setCliente(clienteService.buscarClientePorId(llamadaModel.getCliente()));
		} catch (Exception ex) {
			LOG.info("Método: llamadaModelALlamada(), Error buscando cliente");
		}
		try {
			llamada.setFecha(sdf.parse(llamadaModel.getFecha()));

		} catch (Exception ex) {
			LOG.info("Clase LlamadaConverter, Error convirtiendo fecha.");
			llamada.setFecha(new Date());
		}
		llamada.setTipo(llamadaModel.getTipo());
		llamada.setTelefono(llamadaModel.getTelefono());
		llamada.setAsunto(llamadaModel.getAsunto());
		llamada.setObservaciones(llamadaModel.getObservaciones());
		
		return llamada;
	}
	
	public LlamadaModel llamadaALlamadaModel(Llamada llamada) {
		LlamadaModel llamadaModel = new LlamadaModel();
		llamadaModel.setId(llamada.getId());
		llamadaModel.setCliente(llamada.getCliente().getId());
		llamadaModel.setFecha(sdf.format(llamada.getFecha()));
		llamadaModel.setTipo(llamada.getTipo());
		llamadaModel.setTelefono(llamada.getTelefono());
		llamadaModel.setAsunto(llamada.getAsunto());
		llamadaModel.setObservaciones(llamada.getObservaciones());
		return llamadaModel;
	}
	
	
	
	
	

}
