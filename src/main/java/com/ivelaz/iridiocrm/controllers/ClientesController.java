package com.ivelaz.iridiocrm.controllers;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ivelaz.iridiocrm.constants.ConstantesVistas;
import com.ivelaz.iridiocrm.models.ClienteModel;
import com.ivelaz.iridiocrm.services.ClienteService;


@Controller
@RequestMapping("/clientes")
public class ClientesController {
	
	private static final Log LOG = LogFactory.getLog(ClientesController.class);
	
	@Autowired
	@Qualifier("clienteServiceImpl")
	private ClienteService clienteService;
	

	@GetMapping("/crearcliente")
	public ModelAndView mostrarFormulario() {
		ModelAndView mav = new ModelAndView(ConstantesVistas.CLIENTES_FORM);
		ClienteModel cliente = new ClienteModel();	
				
		cliente.setTipoCliente("Particular");
		mav.addObject("cliente", cliente);
		mav.addObject("titulo", "Crear cliente");
		return mav;
	}
	
	@GetMapping("/editarcliente")
	public String editarCliente(@RequestParam(name="id", required=true) Integer id, Model model) {
		
		try {
			ClienteModel cliente = clienteService.buscarClienteModelPorId(id);	
			model.addAttribute("cliente", cliente);			
			model.addAttribute("titulo", "Editar cliente");
			return ConstantesVistas.CLIENTES_FORM;
		} catch(Exception ex) {
			return "redirect:/clientes/verclientes?result=2";
		}		
	}
	
	@GetMapping("/borrarcliente")
	public String borrarCliente(@RequestParam(name="id", required=true) Integer id) {
		
		try {			
			clienteService.borrarCliente(id);
			return "redirect:/clientes/verclientes?result=3";	//Confirmación borrado
		} catch(Exception ex) {
			return "redirect:/clientes/verclientes?result=2";	//Mensaje error al recuperar cliente de la BD.
		}		
	}

	@PostMapping("/addCliente")
	public String addCliente(@Valid @ModelAttribute(name="cliente") ClienteModel cliente, 
												BindingResult bindingResult, Model model) {		
							
		if(bindingResult.hasErrors()) {
			model.addAttribute("titulo", "Datos erróneos");
			return ConstantesVistas.CLIENTES_FORM;			
		} else {
			LOG.info("Método: addCliente() -- Parámetro: cliente: " + cliente.toString());
			if(null != clienteService.addCliente(cliente)) {	// Si se guarda correctamente en BD
				return "redirect:/clientes/verclientes?result=1";
			} else {
				return "redirect:/clientes/verclientes?result=0";
			}			
		}
				
				
	}
	
	@GetMapping("/verclientes")
	public ModelAndView listarClientes(@RequestParam(name="result", 
											required=false) Integer resultado) {
		
		// LOG.info("resultado al guardar cliente: " + resultado);
		ModelAndView mav = new ModelAndView(ConstantesVistas.CLIENTES_LIST);
		mav.addObject("clientes", clienteService.listarClientes());
		mav.addObject("resultado", resultado);
		
		return mav;
	}
	
}
