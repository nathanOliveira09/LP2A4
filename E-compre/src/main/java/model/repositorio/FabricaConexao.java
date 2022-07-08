package model.repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;


public class FabricaConexao {

	protected Connection conn;
	
	public Connection abrirConexao() {
		try {
			if(this.conn == null) {
				Class.forName("org.postgresql.Driver");
				String url = "jdbc:postgresql://localhost/ecommercemvc";
				
				Properties props = new Properties();
				props.setProperty("user", "postgres");
				props.setProperty("password", "root");
				props.setProperty("ssl", "false");
				
				this.conn =  DriverManager.getConnection(url, props);
				
				System.out.println("Conexão aberta!");
			}
			else {
				System.out.println("Conexão já está aberta!");
			}
		}
		catch (Exception e) {
			System.out.println("Erro ao criar conexão! " + e.getMessage());
		}
		
		return this.conn;
	}
	
	public void fecharConexao() {
		try {
			if(this.conn != null) {
				this.conn.close();
				this.conn = null;
				System.out.println("Conexão fechada!");
			}
			else
			{
				System.out.println("Conexão não existe!");
			}
		}
		catch (Exception e) {
			System.out.println("Erro ao fechar conexão! " + e.getMessage());
		}
	}
	
}
