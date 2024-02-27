package com.gestion.pedidos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gestion.pedidos.entity.Consulta;
import com.gestion.pedidos.entity.Pedidos;

public interface PedidosRepository extends JpaRepository<Pedidos, Integer>{
	@Query("select coalesce(max(p.idpedido), 0) + 1 from Pedidos p")
	int obtenerCOD();
	
	@Query("Select new com.gestion.pedidos.entity.Consulta(p.idpedido, p.nompedido, c.nomcategoria, p.fechaPedido, e.descrip) " +
	           "FROM Pedidos p " +
	           "JOIN p.cat c " +
	           "JOIN p.est e ")
	List<Consulta> obtenerPedidosConCategoriaYEstado();
}
