package br.com.model.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.model.conexao.Conexao;
import br.com.model.entidades.Gasolina;

public class GasolinaDAO {
	public void cadastrarCompra(Gasolina gasolina) {
		
		String sql = "INSERT INTO compra(idCompra,litros,preco,valorTotal,tipoCombustivel)VALUES(null,?,?,?,'G')";
		
		PreparedStatement ps = null;
		
		try {
			
			ps = Conexao.getConexao().prepareStatement(sql);
			
			ps.setDouble(1, gasolina.getLitros());
			ps.setDouble(2, gasolina.getPreco());		
			ps.setDouble(3, gasolina.getValorTotal());
			
			ps.execute();
			ps.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
