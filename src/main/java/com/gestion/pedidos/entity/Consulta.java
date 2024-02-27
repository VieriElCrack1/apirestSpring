package com.gestion.pedidos.entity;

public class Consulta {
	private Integer idpedido;
    private String nompedido;
    private String nomcategoria;
    private String fechaPedido;
    private String descrip;
    
	public Consulta() {
	
	}
	public Consulta(Integer idpedido, String nompedido, String nomcategoria, String fechaPedido, String descrip) {
		this.idpedido = idpedido;
		this.nompedido = nompedido;
		this.nomcategoria = nomcategoria;
		this.fechaPedido = fechaPedido;
		this.descrip = descrip;
	}
	public Integer getIdpedido() {
		return idpedido;
	}
	public void setIdpedido(Integer idpedido) {
		this.idpedido = idpedido;
	}
	public String getNompedido() {
		return nompedido;
	}
	public void setNompedido(String nompedido) {
		this.nompedido = nompedido;
	}
	public String getNomcategoria() {
		return nomcategoria;
	}
	public void setNomcategoria(String nomcategoria) {
		this.nomcategoria = nomcategoria;
	}
	public String getFechaPedido() {
		return fechaPedido;
	}
	public void setFechaPedido(String fechaPedido) {
		this.fechaPedido = fechaPedido;
	}
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
    
}
