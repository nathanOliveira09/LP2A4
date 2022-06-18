package model.repositorio;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Pessoa;

public class PessoaDAO extends FabricaConexao{

	public int criarPessoa(Pessoa pessoa) {
		int id = 0;
		
		try {
			String stmt = "insert into pessoas (nome, cpf, sexo, dataNasc, telefone, rua, bairro, cidade, estado, email, senha, pessoaRole) values (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) returning id";
			
			PreparedStatement pStmt = super.abrirConexao().prepareStatement(stmt);
			
			pStmt.setString(1, pessoa.getNome());
			pStmt.setString(2, pessoa.getCpf());
			pStmt.setString(3, pessoa.getSexo());
			pStmt.setDate(4, (Date) pessoa.getDataNasc());
			pStmt.setString(5, pessoa.getTelefone());
			pStmt.setString(6, pessoa.getRua());
			pStmt.setString(7, pessoa.getBairro());
			pStmt.setString(8, pessoa.getCidade());
			pStmt.setString(9, pessoa.getEstado());
			pStmt.setString(10, pessoa.getEmail());
			pStmt.setString(11, pessoa.getSenha());
			pStmt.setString(12, pessoa.getRole());
		
			
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
				id = rs.getInt(1);
			}
			
			super.fecharConexao();
		}
		catch (Exception e) {
			System.out.println("Erro ao tentar cadastrar pessoa." + e.getMessage());
		}
		
		return id;
	}
	
	public ArrayList<Pessoa> recuperarPessoas(){
		ArrayList<Pessoa> resultado = null;
		
		try {
			String stmt = "select nome, cpf, sexo, telefone, rua, bairro, cidade, estado, email, senha, pessoapessoapessoapessoaRolefrom pessoas";
			
			PreparedStatement pStmt = super.abrirConexao().prepareStatement(stmt);
			ResultSet rs = pStmt.executeQuery();
			resultado = new ArrayList<Pessoa>();
			
			while(rs.next()) {
				Pessoa p = new Pessoa();
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
				p.setCpf(rs.getString("cpf"));
				p.setSexo(rs.getString("sexo"));
				p.setDataNasc(rs.getDate("dataNasc"));
				p.setTelefone(rs.getString("telefone"));
				p.setRua(rs.getString("rua"));
				p.setBairro(rs.getString("bairro"));
				p.setCidade(rs.getString("cidade"));
				p.setEstado(rs.getString("estado"));
				p.setEmail(rs.getString("email"));
				
				resultado.add(p);
			}
			super.fecharConexao();
		}catch (Exception e){
			System.out.println("Erro ao retornar cadastro de pessoas! " + e.getMessage());
			
		}
		
		return resultado;
	}
	
	public Pessoa recuperarPessoa(int id) {
		Pessoa resultado = null;
		
		try {
			String stmt = "select nome, cpf, sexo, telefone, rua, bairro, cidade, estado, email, senha, pessoaRole from pessoas where id = ?";
			
			PreparedStatement pStmt = super.abrirConexao().prepareStatement(stmt);
			pStmt.setInt(1, id);
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				Pessoa p = new Pessoa();
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
				p.setCpf(rs.getString("cpf"));
				p.setSexo(rs.getString("sexo"));
				p.setDataNasc(rs.getDate("dataNasc"));
				p.setTelefone(rs.getString("telefone"));
				p.setRua(rs.getString("rua"));
				p.setBairro(rs.getString("bairro"));
				p.setCidade(rs.getString("cidade"));
				p.setEstado(rs.getString("estado"));
				p.setEmail(rs.getString("email"));
			}
			super.fecharConexao();
		}catch (Exception e){
			System.out.println("Erro ao retornar cadastro da pessoa com o ID: " + e.getMessage());
			
		}
		
		return resultado;
	}
	
	public int editarPessoa(Pessoa pessoa) {
		int resultado = 0;
		
		try {
			String stmt = "update pessoas set nome = ?, cpf = ?, sexo = ?, telefone = ?, rua = ?, bairro = ?, cidade = ?, estado = ?, email = ?, senha = ? where id = ?";
			
			PreparedStatement pStmt = super.abrirConexao().prepareStatement(stmt);
			
			pStmt.setString(1, pessoa.getNome());
			pStmt.setString(2, pessoa.getCpf());
			pStmt.setString(3, pessoa.getSexo());
			pStmt.setDate(4, (Date) pessoa.getDataNasc());
			pStmt.setString(5, pessoa.getTelefone());
			pStmt.setString(6, pessoa.getRua());
			pStmt.setString(7, pessoa.getBairro());
			pStmt.setString(8, pessoa.getCidade());
			pStmt.setString(9, pessoa.getEstado());
			pStmt.setString(10, pessoa.getEmail());
			pStmt.setString(11, pessoa.getSenha());
			
			resultado = pStmt.executeUpdate();
			
			super.fecharConexao();
		}catch (Exception e) {
			System.out.println("Erro ao editar a pessoa " + e.getMessage());
		}
		
		return resultado;
		
		
	}
	
	public int removerPessoa(int id) {
		int resultado = 0;
		
		try {
			String stmt = "delete from pessoas where id = ?";
			PreparedStatement pStmt = super.abrirConexao().prepareStatement(stmt);
			pStmt.setInt(1, id);
			
			resultado = pStmt.executeUpdate();
			super.fecharConexao();
		}catch (Exception e) {
			System.out.println("Erro ao remover a pessoa com o Id: " + id + ". " + e.getMessage());
		}
		
		return resultado;
		
	}
}
