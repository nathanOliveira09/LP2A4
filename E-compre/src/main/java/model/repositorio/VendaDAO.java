package model.repositorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.Pessoa;
import model.Produto;
import model.Venda;

public class VendaDAO extends FabricaConexao{

	private PessoaDAO pessoa = new PessoaDAO();
	private ProdutoDAO produtos = new ProdutoDAO();
	private Produto produto = new Produto();
	
	public int registrarVenda(Venda venda) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		int id = 0;
		
		try {
			String stmt = "insert into vendas (idPessoa, valorTotal, dataVenda, quantidadeproduto)";
			PreparedStatement pStmt = super.abrirConexao().prepareStatement(stmt);
			pStmt.setInt(1, venda.getId());
			pStmt.setDouble(2, venda.getValorTotal());
			String data = dateFormat.format(venda.getDataVenda());
			pStmt.setString(3, data);
			pStmt.setInt(4, venda.getQuantidade());
			
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
				id = rs.getInt(1);
			}
			
				stmt="insert into venda_produtos (idVenda, idProduto)";
				pStmt.setInt(1, venda.getId());
				pStmt.setInt(2, produto.getId());
			
			super.fecharConexao();
			
		} catch (Exception e) {
			System.out.println("Erro ao cadastrar nova venda" + e.getMessage());
		}
		
		return id;
	}
	
	
//	public Venda consultarVendaPorId(int id) {
//		Venda resultado = null;
//		try {
//			String stmt = "select idVenda, idPessoa, valorTotal, dataVenda from vendas where id = ?";
//			PreparedStatement pStmt = super.abrirConexao().prepareStatement(stmt);
//			pStmt.setInt(1, id);
//			
//			ResultSet rs = pStmt.executeQuery();
//			
//			while(rs.next()) {
//				resultado = new Venda();
//				resultado.setId(rs.getInt("idVenda"));
//				resultado.set
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
	
	public int excluirVenda(int id) {
		int resultado = 0;
				
				try {
					String stmt = "delete from vendas where id = ?";
					PreparedStatement pStmt = super.abrirConexao().prepareStatement(stmt);
					pStmt.setInt(1, id);
					
					resultado = pStmt.executeUpdate();
					super.fecharConexao();
				}catch (Exception e) {
					System.out.println("Erro ao remover a venda com o Id: " + id + ". " + e.getMessage());
				}
				
				return resultado;
	}
}
