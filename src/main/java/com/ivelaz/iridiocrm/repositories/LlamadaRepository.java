package com.ivelaz.iridiocrm.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ivelaz.iridiocrm.entities.Llamada;

@Repository("llamadaRepository")
public interface LlamadaRepository extends JpaRepository<Llamada, Serializable>{
	
	public abstract Llamada findById(int id);
	
}
