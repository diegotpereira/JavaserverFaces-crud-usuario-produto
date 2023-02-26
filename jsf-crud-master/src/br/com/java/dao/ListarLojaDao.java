package br.com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.java.conexao.Conexao;
import br.com.java.modelo.Loja;

public class ListarLojaDao {
	
static Connection con = Conexao.getConnection();
	
	public List<Loja> listarLojas() {
		
		String SQL = "SELECT * FROM LOJA";
		
		List<Loja> lista = new ArrayList<Loja>();
		
		try {
			
			PreparedStatement ps = con.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				Loja loja = new Loja();
				
				loja.setID(rs.getInt("ID"));
				loja.setNome(rs.getString("nome"));
				
				lista.add(loja);
			}
			
			if (!rs.next()) {
				
				System.out.println("Não existem dados no banco para serem exibidos");
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return lista;	
	}

}
