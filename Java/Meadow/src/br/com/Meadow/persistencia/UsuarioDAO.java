package br.com.Meadow.persistencia;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.Meadow.modelos.Usuario;

public class UsuarioDAO {
	private ConexaoMysql conexao;

	public UsuarioDAO() {
		this.conexao = new ConexaoMysql("localhost", "3306", "root", "93645522nS.", "meadow");
	}

	// INSERT INTO usuario VALUES(id, nome, email, senha)
	public void salvar(Usuario usuario) {
		try {
			this.conexao.abrirConexao();
			String sql = "INSERT INTO usuario VALUES(null, ?, ?, ?, ?, ?)";
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
			statement.setString(1, usuario.getSenha());
			statement.setString(2, usuario.getEmail());
			statement.setString(3, usuario.getNome());
            statement.setString(4, usuario.getApelido());
            statement.setString(5, usuario.getImg());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}

	public void editar(Usuario usuario) {
		try {
			this.conexao.abrirConexao();
			String sql = "UPDATE usuario SET senha=? , email=?, nome=?, apelido=?, imagem=? WHERE id_usuario=?";
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
			statement.setString(1, usuario.getSenha());
			statement.setString(2, usuario.getEmail());
			statement.setString(3, usuario.getNome());
            statement.setString(4, usuario.getApelido());
            statement.setString(5, usuario.getImg());
			statement.setLong(6, usuario.getId_usuario());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}

	// DELETE FROM usuario WHERE id_usuario=1
	public void excluir(long id) {
		try {
			this.conexao.abrirConexao();
			String sql = "DELETE FROM usuario WHERE id_usuario=?";
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
			statement.setLong(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}

	
	}

