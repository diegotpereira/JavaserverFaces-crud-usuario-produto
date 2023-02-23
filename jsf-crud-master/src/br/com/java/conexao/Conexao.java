package br.com.java.conexao;

import java.sql.*;

public class Conexao {
	
	private final static String url = "jdbc:postgresql://localhost:5432/jsf_crud_01";
	private final static String usuario = "postgres";
	private final static String senha = "123";
	private static Connection con = null;
	private static PreparedStatement ps;
	private static ResultSet rs;
	
	public static Connection getConnection() {
		
		if (con == null) {
			
			try {
				
				Class.forName("org.postgresql.Driver");
				
			} catch (ClassNotFoundException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			try {
				
				con = DriverManager.getConnection(url, usuario, senha);
				
				System.err.println("Conectado com sucesso");
				
			} catch (SQLException e) {
				// TODO: handle exception
				System.out.println("Erro ao conectar: " + e.getMessage());
			}
		}
		
		return con;
	}
	
	public static void fecharConexao(Connection con) {
		
		if (con != null) {
			
			try {
				
				System.out.println("Conexão Fechada");
				con.close();
				
			} catch (SQLException e) {
				// TODO: handle exception
				System.err.println("Erro: " + e.getMessage());
			}
		}
	}
	
	public static void fecharConexao(Connection con, PreparedStatement ps) {
		
		if (ps != null) {
			
			try {
				
				ps.close();
				
			} catch (SQLException e) {
				// TODO: handle exception
				System.err.println("Erro: " + e.getMessage());
				
			} finally {
				
				fecharConexao(con);
			}
		}
	}
	
	public static void fecharConexao(Connection con, PreparedStatement ps, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.err.println("Erro: " + e);

			} finally {
				fecharConexao(con, ps);
			}
		}
	}
}
