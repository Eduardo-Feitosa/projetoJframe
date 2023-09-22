package br.com.model.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.model.conexao.Conexao;
import br.com.model.entidades.Alcool;

public class AlcoolDAO {
	
	public void cadastrarCompra(Alcool alcool) {
		
		String sql = "INSERT INTO compra(idCompra,litros,preco,valorTotal,tipoCombustivel)VALUES(null,?,?,?,'A')";
		
		PreparedStatement ps = null;
		
		try {
			
			ps = Conexao.getConexao().prepareStatement(sql);
			
			ps.setDouble(1, alcool.getLitros());
			ps.setDouble(2, alcool.getPreco());		
			ps.setDouble(3, alcool.getValorTotal());
			
			ps.execute();
			ps.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
		public void alterarCompra(Alcool alcool, String tipo, int id) {
		
		String sql = "UPDATE compra SET litros =? ,preco = ? ,valorTotal = ?,tipoCombustivel = ? WHERE idCompra = ?";
		
		PreparedStatement ps = null;
		
		try {
			
			ps = Conexao.getConexao().prepareStatement(sql);
			
			ps.setDouble(1, alcool.getLitros());
			ps.setDouble(2, alcool.getPreco());		
			ps.setDouble(3, alcool.getValorTotal());
			ps.setString(4,tipo);
			ps.setInt(5, id);
			
			
			ps.execute();
			ps.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
		
		public void deletarCompra(int id) {
			
			String sql = "DELETE from compra WHERE idCompra = ?";
			
			PreparedStatement ps = null;
			
			try {
				
				ps = Conexao.getConexao().prepareStatement(sql);
				
				ps.setInt(1, id);
				
				ps.execute();
				ps.close();
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}
	
	
}
