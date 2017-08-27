package com.ivelaz.iridiocrm.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ivelaz.iridiocrm.entities.Llamada;
import com.ivelaz.iridiocrm.repositories.LlamadaRepository;
import com.ivelaz.iridiocrm.services.LlamadaService;

@Service("llamadaServiceImpl")
public class LlamadaServiceImpl implements LlamadaService{

	@Autowired
	@Qualifier("llamadaRepository")
	private LlamadaRepository llamadaRepository;
	
	@Transactional
	@Override
	public Llamada addLlamada(Llamada llamada) {
		Llamada llamadaGuardada = llamadaRepository.save(llamada);
		return llamadaGuardada;
	}

	@Transactional(readOnly=true)
	@Override
	public List<Llamada> listarLLamadas() {
		List<Llamada> llamadas = llamadaRepository.findAll();
		return llamadas;
	}

	@Transactional(readOnly=true)
	@Override
	public Llamada buscarLlamadaPorId(int id) {
		return llamadaRepository.findById(id);
	}

	@Transactional
	@Override
	public void borrarLlamada(int id) {
		Llamada llamada = buscarLlamadaPorId(id);
		if(llamada != null) {
			llamadaRepository.delete(llamada);
		}
	}
	
	
}
