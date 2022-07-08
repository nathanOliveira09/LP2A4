package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Compra {
	private int id;
	private Produto produtos;
	private int quantidade;
	private Date dataCompra;
	private long numeroNF;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Produto getProdutos() {
		return produtos;
	}
	public void setProdutos(Produto produtos) {
		this.produtos = produtos;
	}
	public Date getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}
	
	
	public long getNumeroNF() {
		return numeroNF;
	}
	public void setNumeroNF(long numeroNF) {
		this.numeroNF = numeroNF;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public Compra(int id, Produto produtos, Pessoa pessoa, Date dataCompra) {
		this.id = id;
		this.produtos = produtos;
		this.dataCompra = dataCompra;
	}
	
	public Compra() {
		
	}
	
	
	
	
	
}
