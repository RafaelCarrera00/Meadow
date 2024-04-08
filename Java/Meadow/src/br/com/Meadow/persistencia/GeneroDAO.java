package br.com.Meadow.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.Meadow.modelos.Genero;

public class GeneroDAO {

	private ConexaoMysql conexao;
	
	public GeneroDAO() {
		this.conexao = new ConexaoMysql("localhost", "3306", "root", "root", "bd_comunicacao_java_mysql_2i_2023");
	}
	
	public Genero buscarPorId(long id) {
		Genero genero = null;
		try {
			this.conexao.abrirConexao();
			String sql = "SELECT * FROM genero WHERE id_genero=?";
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();

			if (rs.next() == true) {
				genero = new Genero();
				genero.setId_genero(rs.getLong("id_genero"));
				genero.setNome(rs.getString("nome"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return genero;
	}

	public Genero buscarPorNome(String nome) {
		Genero genero = null;
		try {
			this.conexao.abrirConexao();
			String sql = "SELECT * FROM genero WHERE nome=?";
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
			statement.setString(1, nome);
			ResultSet rs = statement.executeQuery();

			if (rs.next() == true) {
				genero = new Genero();
				genero.setId_genero(rs.getLong("id_genero"));
				genero.setNome(rs.getString("nome"));	
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return genero;
	}

}
