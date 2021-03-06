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
	
	
	public int registrarCompra (Compra compra) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		int id = 0;
		int resultado = 0;
		
		try {
				String  stmt = "insert into compras (idProduto, numeroNF, quantidade) VALUES (?,?,?) returning idcompra";
				PreparedStatement pStmt = super.abrirConexao().prepareStatement(stmt);
				pStmt.setInt(1, compra.getProdutos().getId());
				pStmt.setLong(2, compra.getNumeroNF());
				pStmt.setInt(3, compra.getQuantidade());
				
				ResultSet rs = pStmt.executeQuery();
				
				if(rs.next()) {
					id = rs.getInt(1);
					System.out.println("ID da compra registrada: " + id);
				}
				super.fecharConexao();
				
				System.out.println(rs);
				
				
				int quantidadeFinal = compra.getProdutos().getQtd() + compra.getQuantidade();
				stmt="update produtos set qtd = ? where id = ?";
				pStmt = super.abrirConexao().prepareStatement(stmt);
				pStmt.setInt(1, quantidadeFinal);
				System.out.println(compra.getProdutos().getId());
				pStmt.setInt(2, compra.getProdutos().getId());
				
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
				super.fecharConexao();
			}
		} catch (Exception e) {
			System.out.println("Erro ao buscar compras" + e.getMessage());
		}
		
		return compras;
		
		
	}
	
	public Compra recuperarCompraPorId(int id) {
		Compra c = new Compra();
		
		try {
			String stmt = "SELECT * FROM compras INNER JOIN produtos ON produtos.id = compras.idproduto WHERE compras.idcompra = ?";
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
	
	public int editarCompra (Compra compra){
		int resultado = 0;
		ProdutoDAO p1 = new ProdutoDAO();
		int quantidadeAtualProduto =p1.recuperarProdutoPorId(compra.getProdutos().getId()).getQtd();
		
		int quantidadeAtualizadaProduto= 0;
		CompraDAO c1 = new CompraDAO();
		int quantidadeAtualCompra= c1.recuperarCompraPorId(compra.getId()).getQuantidade();

		if(compra.getQuantidade()>=quantidadeAtualCompra) {
			quantidadeAtualizadaProduto = quantidadeAtualProduto + (compra.getQuantidade()-quantidadeAtualCompra);
			try {
				String stmt = "update compras set idproduto = ?, numeroNF = ?, quantidade = ? where idcompra = ?";
				PreparedStatement pStmt = super.abrirConexao().prepareStatement(stmt);
				
				pStmt.setInt(1, compra.getProdutos().getId());
				System.out.println(compra.getProdutos().getId());
				pStmt.setDouble(2,compra.getNumeroNF());
				pStmt.setInt(3, compra.getQuantidade());
				pStmt.setInt(4, compra.getId());
				resultado = pStmt.executeUpdate();
				super.fecharConexao();
			} catch (Exception e) {
				System.out.println("Erro ao atualizar compras" + e.getMessage());
			}
			try {
				String stmt="update produtos set qtd = ? where id = ?";
				PreparedStatement pStmt = super.abrirConexao().prepareStatement(stmt);
				pStmt.setInt(1, quantidadeAtualizadaProduto);
				pStmt.setInt(2, p1.recuperarProdutoPorId(compra.getProdutos().getId()).getId());
				
				resultado = pStmt.executeUpdate();
				super.fecharConexao();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}else {
			quantidadeAtualizadaProduto = quantidadeAtualProduto - (quantidadeAtualCompra - compra.getQuantidade());
			try {
				String stmt = "update compras set idproduto = ?, numeroNF = ?, quantidade = ? where idcompra = ?";
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
			try {
				String stmt="update produtos set qtd = ? where id = ?";
				PreparedStatement pStmt = super.abrirConexao().prepareStatement(stmt);
				pStmt.setInt(1, quantidadeAtualizadaProduto);
				pStmt.setInt(2, p1.recuperarProdutoPorId(compra.getProdutos().getId()).getId());
				
				resultado = pStmt.executeUpdate();
				super.fecharConexao();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		return resultado;
	}
	
	public int excluirCompra(int id) {
		int resultado = 0;
		
		
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			Produto produto = new Produto();
			CompraDAO compraDAO = new CompraDAO();
			Compra compra = new CompraDAO().recuperarCompraPorId(id);
			
			produto = compra.getProdutos();
			int quantidadeAtual = produto.getQtd();
			int quantidadeCompra = compra.getQuantidade();

			int quantidadeAtualizada = quantidadeAtual - quantidadeCompra;
			
			String stmt = "update produtos set qtd = ? WHERE id = ?";
			PreparedStatement pStmt = super.abrirConexao().prepareStatement(stmt);
			pStmt.setInt(1, quantidadeAtualizada);
			pStmt.setInt(2, produto.getId());
			
			resultado = pStmt.executeUpdate();
			super.fecharConexao();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			String stmt = "delete from compras where idcompra = ?";
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
