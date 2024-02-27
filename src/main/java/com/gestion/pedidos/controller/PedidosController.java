package com.gestion.pedidos.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.pedidos.entity.Categoria;
import com.gestion.pedidos.entity.Consulta;
import com.gestion.pedidos.entity.Estado;
import com.gestion.pedidos.entity.Pedidos;
import com.gestion.pedidos.service.PedidosService;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200/")
public class PedidosController {
	@Autowired
	private PedidosService ser;
	
	@GetMapping("/consulta")
	public List<Consulta> lista2(){
		return ser.listaConsulta();
	}
 	
	@GetMapping("/idpedido")
	public int generarCOD() {
		return ser.obtenerIdPedido();
	}
	
	@GetMapping("/pedidos")
	public List<Pedidos> pedidos() {
	   return ser.pedidos();
	}
	
	@GetMapping("/categorias")
	public List<Categoria> categorias() {
		return ser.categorias();
	}
	
	@GetMapping("/estados")
	public List<Estado> estados() {
		return ser.estados();
	}
	
	@PostMapping("/registrar")
	public void registrar(@RequestBody Pedidos p) {
		ser.guardar(p);
	}
	
	@GetMapping("/pedido/{idpedido}")
	public ResponseEntity<Pedidos> buscar(@PathVariable Integer idpedido) {
		Pedidos p = ser.buscar(idpedido);
		return ResponseEntity.ok(p);
	}
	
	@PutMapping("/actualizar/{idpedido}")
	public ResponseEntity<Pedidos> actualizar(@PathVariable Integer idpedido, @RequestBody Pedidos pd) {
		Pedidos p = ser.buscar(idpedido);
		p.setNompedido(pd.getNompedido());
		p.setIdcategoria(pd.getIdcategoria());
		p.setFechaPedido(pd.getFechaPedido());
		p.setIdestado(pd.getIdestado());
		ser.guardar(p);
		return ResponseEntity.ok(p);
	}
	
	@DeleteMapping("/eliminar/{idpedido}")
	public ResponseEntity<Map<String, Boolean>> eliminar(@PathVariable Integer idpedido) {
		ser.eliminar(idpedido);
		Map<String, Boolean> rs = new HashMap<>();
		rs.put("eliminado", Boolean.TRUE);
		return ResponseEntity.ok(rs);
	}
}
