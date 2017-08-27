package com.ivelaz.iridiocrm.services;

import java.util.List;

import com.ivelaz.iridiocrm.entities.Llamada;

public interface LlamadaService {

	public abstract Llamada addLlamada(Llamada llamada);
	
	public abstract List<Llamada> listarLLamadas();
	
	public abstract Llamada buscarLlamadaPorId(int id);
	
	public abstract void borrarLlamada(int id);
}
