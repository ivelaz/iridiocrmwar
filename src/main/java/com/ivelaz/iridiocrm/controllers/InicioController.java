package com.ivelaz.iridiocrm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.ivelaz.iridiocrm.constants.ConstantesVistas;

@Controller
public class InicioController {

	@GetMapping("/")
	public String inicio() {
		return ConstantesVistas.INICIO;
	}
}
