package com.bolsadeideas.springboot.app.controllers;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bolsadeideas.springboot.app.models.entity.Cliente;
import com.bolsadeideas.springboot.app.models.entity.Factura;
import com.bolsadeideas.springboot.app.models.entity.ItemFactura;
import com.bolsadeideas.springboot.app.models.entity.Producto;
import com.bolsadeideas.springboot.app.models.service.IClienteService;

@Controller
@RequestMapping(value = "/factura")
@SessionAttributes("factura")
public class FacturaController {
	
	@Autowired
	IClienteService clienteService;
	
	private final Logger log = org.slf4j.LoggerFactory.getLogger(getClass());
	
	@GetMapping("/form/{clienteId}")
	public String crear(@PathVariable(value = "clienteId") Long clienteId, Map<String, Object> map, RedirectAttributes flash) {
		Cliente cliente = clienteService.findOne(clienteId);
		if(cliente == null) {
			flash.addFlashAttribute("error", "El cliente no existe ne la base de datos");
			return "redirect:/listar";			
		}
		Factura factura = new Factura();
		factura.setCliente(cliente);
		map.put("titulo", "Comprar");
		map.put("factura", factura);

		return "factura/form";
	}
	
	@GetMapping(value = "/cargar-productos/{term}", produces = {"application/json"})
	public @ResponseBody List<Producto> cargarProducto(@PathVariable String term){
		return clienteService.findByNombre(term);
	}
	
	@PostMapping("/form")	
	public String guardar(Factura factura,
			@RequestParam(name = "item_id[], required= false") Long[] itemId,
			@RequestParam(name = "cantidad[], required= false") Integer[] cantidad,
			RedirectAttributes flash,
			SessionStatus status
			) {
		for(int i= 0; i<itemId.length; i++) {			
			Producto producto = clienteService.findProductById(itemId[i]);
			
			ItemFactura linea = new ItemFactura();
			linea.setCantidad(cantidad[i]);
			linea.setProducto(producto);
			factura.addItemFactura(linea);
			
			log.info("ID: " + itemId[i].toString() + ", cantidad: " + cantidad[i].toString());
		}
		clienteService.saveFactura(factura);
		status.setComplete();
		flash.addFlashAttribute("success", "Factura creada con éxito");
		
		return "redirect:/ver/" +  factura.getCliente().getId();
		
	}
	
}
