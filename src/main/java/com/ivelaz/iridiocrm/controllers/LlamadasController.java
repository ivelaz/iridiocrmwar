package com.ivelaz.iridiocrm.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import com.ivelaz.iridiocrm.components.LlamadaConverter;
import com.ivelaz.iridiocrm.constants.ConstantesVistas;
import com.ivelaz.iridiocrm.entities.Llamada;
import com.ivelaz.iridiocrm.models.ClienteModel;
import com.ivelaz.iridiocrm.models.LlamadaModel;
import com.ivelaz.iridiocrm.services.ClienteService;
import com.ivelaz.iridiocrm.services.LlamadaService;

@Controller
@RequestMapping("/llamadas")
public class LlamadasController {
	
	private static final Log LOG = LogFactory.getLog(LlamadasController.class);
	
	@Autowired
	@Qualifier("clienteServiceImpl")
	private ClienteService clienteService;
	
	@Autowired
	@Qualifier("llamadaServiceImpl")
	private LlamadaService llamadaService;
	
	@Autowired
	@Qualifier("llamadaConverter")
	LlamadaConverter llamadaConverter;
	
	@GetMapping("/nuevallamada")
	public ModelAndView llamadaForm(@RequestParam(name="id", required=true) Integer id) {			
		
		ModelAndView mav = new ModelAndView(ConstantesVistas.LLAMADAS_FORM);
		LOG.info("Método llamadaForm() Parámetro id=" + id);
		ClienteModel cliente = clienteService.buscarClienteModelPorId(id);
		LlamadaModel llamada = new LlamadaModel();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		String fechaStr = sdf.format(new Date());
		llamada.setFecha(fechaStr);
		llamada.setCliente(id);		
		llamada.setTipo("Recibida");
		llamada.setTelefono(cliente.getTelefono());			
		mav.addObject("fechastr", fechaStr);		
		mav.addObject("llamada", llamada);		
		mav.addObject("titulo", "Registrar nueva llamada");
		
		return mav;
	}
	
	@PostMapping("/addllamada")
	public String addLlamada(@Valid @ModelAttribute(name="llamada") LlamadaModel llamadaModel,
			BindingResult bindingResult, Model model) {	
		if(bindingResult.hasErrors()) {
			model.addAttribute("titulo", "Datos erróneos");
			return ConstantesVistas.LLAMADAS_FORM;
		} else {
			Llamada llamada = new Llamada();
			llamada = llamadaConverter.llamadaModelALlamada(llamadaModel);
			if(null != llamadaService.addLlamada(llamada)) {	// Si se guarda correctamente en BD
				return "redirect:/llamadas/listarllamadas?id=" + llamada.getCliente().getId() + "&result=2";
			} else {
				return "redirect:/llamadas/listarllamadas?id=" + llamada.getCliente().getId() + "&result=1";
			}
		}
	}
	

	@GetMapping("/listarllamadas")
	public String listarLlamadas(@RequestParam(name="id", required=false) Integer id,
				@RequestParam(name="result", required=false) Integer result, Model model) {
		
		model.addAttribute("result", result);
		List<Llamada> llamadas = new ArrayList<Llamada>();
		llamadas = llamadaService.listarLLamadas();
		if(id != null) {
			List<Llamada> resultados = new ArrayList<Llamada>();
			for(Llamada llamada : llamadas) {
				if(llamada.getCliente().getId() == id) {
					resultados.add(llamada);
				}
			}
			llamadas = resultados;
			model.addAttribute("cliente", clienteService.buscarClientePorId(id).getNombre());
		} 
			
		if(llamadas.isEmpty()) {
			model.addAttribute("vacia", 1);
		} else {
			model.addAttribute("vacia", 2);
		}		
		
		model.addAttribute("lista", llamadas);
		return ConstantesVistas.LISTAR_LLAMADAS;
	}
	
	@GetMapping("/verllamada")
	public String verLlamada(@RequestParam(name="id", required=true) Integer id,
			Model model) {
		try {
			Llamada llamada = llamadaService.buscarLlamadaPorId(id);
			model.addAttribute("llamada", llamada);
			return ConstantesVistas.VER_LLAMADA;
		} catch(Exception ex) {
			return "redirect:/llamadas/listarllamadas?result=1";
		}		
	}
	
	@GetMapping("/borrarllamada")
	public String borrarLlamada(@RequestParam(name="id", required=true) Integer id,
			Model model) {
		try {
			int idCliente = llamadaService.buscarLlamadaPorId(id).getCliente().getId();				
			llamadaService.borrarLlamada(id);
			LOG.info("Método borrarLLAmada id=" + idCliente);
			return "redirect:/llamadas/listarllamadas?id=" + idCliente;
		} catch(Exception ex) {
			return "redirect:/llamadas/listarllamadas?result=1";
		}		
	}
	
	

}
