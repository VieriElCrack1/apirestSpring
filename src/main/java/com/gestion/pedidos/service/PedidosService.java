package com.gestion.pedidos.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gestion.pedidos.entity.Categoria;
import com.gestion.pedidos.entity.Consulta;
import com.gestion.pedidos.entity.Estado;
import com.gestion.pedidos.entity.Pedidos;
import com.gestion.pedidos.repository.CategoriaRepository;
import com.gestion.pedidos.repository.EstadoRepository;
import com.gestion.pedidos.repository.PedidosRepository;

@Service
public class PedidosService {
	@Autowired
	private PedidosRepository repo;
	
	@Autowired
	private CategoriaRepository repoCat;
	
	@Autowired
	private EstadoRepository repoEst;
	
	public void guardar(Pedidos p) {
		repo.save(p);
	}
	
	public void eliminar(int id) {
		repo.deleteById(id);
	}
	
	public Pedidos buscar(int id) {
		return repo.findById(id).orElse(null);
	}
	
	public List<Pedidos> pedidos() {
		return repo.findAll();
	}
	
	public List<Categoria> categorias() {
		return repoCat.findAll();
	}
	
	public List<Estado> estados() {
		return repoEst.findAll();
	}
	
	public int obtenerIdPedido() {
		return repo.obtenerCOD();
	}
	
	public List<Consulta> listaConsulta() {
		return repo.obtenerPedidosConCategoriaYEstado();
	}
}
