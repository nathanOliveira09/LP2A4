package model.repositorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.Compra;
import model.Produto;

public class CompraDAO extends FabricaConexao{
	
	private ProdutoDAO produto = new ProdutoDAO();
	private Produto p = new Produto();
	
	public int registrarCompra (Compra compra) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		int id = 0;
		int resultado = 0;
		
		try {
				String  stmt = "insert into compras (idProduto, numeroNF, quantidade) VALUES (?,?,?) returning idcompra";
				PreparedStatement pStmt = super.abrirConexao().prepareStatement(stmt);
				pStmt.setInt(1, p.getId());
				pStmt.setLong(2, compra.getNumeroNF());
				pStmt.setInt(3, compra.getQuantidade());
				
				ResultSet rs = pStmt.executeQuery();
				
				if(rs.next()) {
					id = rs.getInt(1);
					System.out.println("ID da compra registrada: " + id);
				}
				super.fecharConexao();
				
				System.out.println(rs);
				
				
				int quantidadeFinal = p.getQtd() + compra.getQuantidade();
				stmt="update produtos set qtd = ? where id = ?";
				pStmt = super.abrirConexao().prepareStatement(stmt);
				pStmt.setInt(1, quantidadeFinal);
				System.out.println(p.getId());
				pStmt.setInt(2, p.getId());
				
				resultado = pStmt.executeUpdate();
				super.fecharConexao();		
				
		} catch (Exception e) {
			System.out.println("Erro ao registrar nova compra " + e.getMessage());
		}
		
		return id;
	}
	
	public List<Compra> recuperarComprasEProdutos (){
		List<Compra> compras = new ArrayList<Compra>();
		
		try {
			String  stmt = "SELECT * FROM compras INNER JOIN produtos ON produtos.id = compras.idproduto";
			PreparedStatement pStmt = super.abrirConexao().prepareStatement(stmt);
			
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				Compra c = new Compra();
				Produto p1 = new ProdutoDAO().recuperarProdutoPorId(rs.getInt("idproduto"));
				
				c.setId(rs.getInt("idcompra"));
				c.setNumeroNF(rs.getLong("numeronf"));
				c.setProdutos(p1);
				c.setQuantidade(rs.getInt("quantidade"));
				
				compras.add(c);
			}
		} catch (Exception e) {
			System.out.println("Erro ao buscar compras" + e.getMessage());
		}
		
		return compras;
		
		
	}
	
	public Compra recuperarCompraPorId(int id) {
		Compra c = new Compra();
		
		try {
			String stmt = "SELECT * FROM compras WHERE idcompra = ? INNER JOIN produtos ON produtos.id = compras.idproduto";
			PreparedStatement pStmt = super.abrirConexao().prepareStatement(stmt);
			
			pStmt.setInt(1, id);
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				Produto p1 = new ProdutoDAO().recuperarProdutoPorId(rs.getInt("idproduto"));
				
				c.setId(rs.getInt("idcompra"));
				c.setNumeroNF(rs.getLong("numeronf"));
				c.setProdutos(p1);
				c.setQuantidade(rs.getInt("quantidade"));
				
			}
		} catch (Exception e) {
			System.out.println("Erro ao buscar compras" + e.getMessage());
		}
		
		return c;

		
	}
	
	public int editarCompra (Compra compra) throws SQLException {
		int resultado = 0;
		ProdutoDAO p1 = new ProdutoDAO();
		int quantidadeAtualProduto =p1.recuperarProdutoPorId(compra.getProdutos().getId()).getQtd();
		
		int quantidadeAtualizadaProduto= 0;
		CompraDAO c1 = new CompraDAO();
		int quantidadeAtualCompra= c1.recuperarCompraPorId(compra.getId()).getQuantidade();

		if(compra.getQuantidade()>=quantidadeAtualCompra) {
			quantidadeAtualizadaProduto = quantidadeAtualProduto + (compra.getQuantidade()-quantidadeAtualCompra);
			try {
				String stmt = "update compras set idproduto = ?, numeroNF = ?, quantidade = ? where id = ?";
				PreparedStatement pStmt = super.abrirConexao().prepareStatement(stmt);
				
				pStmt.setInt(1, compra.getProdutos().getId());
				pStmt.setDouble(2,compra.getNumeroNF());
				pStmt.setInt(3, compra.getQuantidade());
				pStmt.setInt(4, compra.getId());
				resultado = pStmt.executeUpdate();
				super.fecharConexao();
			} catch (Exception e) {
				System.out.println("Erro ao atualizar compras" + e.getMessage());
			}
			String stmt="update produtos set qtd = ? where id = ?";
			PreparedStatement pStmt = super.abrirConexao().prepareStatement(stmt);
			pStmt.setInt(1, quantidadeAtualizadaProduto);
			pStmt.setInt(2, p1.recuperarProdutoPorId(compra.getProdutos().getId()).getId());
			
			resultado = pStmt.executeUpdate();
			super.fecharConexao();		
		}else {
			quantidadeAtualizadaProduto = quantidadeAtualProduto - (quantidadeAtualCompra - compra.getQuantidade());
			try {
				String stmt = "update compras set idproduto = ?, numeroNF = ?, quantidade = ? where id = ?";
				PreparedStatement pStmt = super.abrirConexao().prepareStatement(stmt);
				
				pStmt.setInt(1, compra.getProdutos().getId());
				pStmt.setDouble(2,compra.getNumeroNF());
				pStmt.setInt(3, compra.getQuantidade());
				pStmt.setInt(4, compra.getId());
				resultado = pStmt.executeUpdate();
				super.fecharConexao();
			} catch (Exception e) {
				System.out.println("Erro ao atualizar compras" + e.getMessage());
			}
			String stmt="update produtos set qtd = ? where id = ?";
			PreparedStatement pStmt = super.abrirConexao().prepareStatement(stmt);
			pStmt.setInt(1, quantidadeAtualizadaProduto);
			pStmt.setInt(2, p1.recuperarProdutoPorId(compra.getProdutos().getId()).getId());
			
			resultado = pStmt.executeUpdate();
			super.fecharConexao();		
		}
		return resultado;
	}
	
	public int excluirCompra(int id) {
		int resultado = 0;
		
		try {
			String stmt = "delete from compras where id = ?";
			PreparedStatement pStmt = super.abrirConexao().prepareStatement(stmt);
			pStmt.setInt(1, id);
			
			resultado = pStmt.executeUpdate();
			super.fecharConexao();
		} catch (Exception e) {
			System.out.println("Erro ao remover a compra com o ID: " + id + ". " + e.getMessage());
		}
		
		return resultado;
	}
	
}
