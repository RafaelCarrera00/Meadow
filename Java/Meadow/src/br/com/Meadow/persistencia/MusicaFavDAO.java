package br.com.Meadow.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.Meadow.modelos.MusicaFav;
import br.com.Meadow.modelos.Usuario;

public class MusicaFavDAO {
	
private ConexaoMysql conexao;
	
	public MusicaFavDAO() {
		this.conexao = new ConexaoMysql("localhost", "3306", "root", "root", "bd_comunicacao_java_mysql_2i_2023");
	}

	public void salvar(MusicaFav musicaFav) {
		try {
			this.conexao.abrirConexao();
			String sql = "INSERT INTO musica_favorita VALUES(null, ?, ?)";
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
			statement.setLong(1, musicaFav.getUsuario().getId_usuario());
			statement.setLong(2, musicaFav.getMusica().getId_musica());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}
	
	public void excluir(long id) {
		try {
			this.conexao.abrirConexao();
			String sql = "DELETE FROM musica_favorita WHERE id_musica_favorita=?";
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
			statement.setLong(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}
	
	public MusicaFav buscarPorId(long id) {
		MusicaFav musicaFav = null;
		try {
			this.conexao.abrirConexao();
			String sql = "SELECT * FROM musica_favorita WHERE id_musica_favorita=?";
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			if (rs.next() == true) {
				musicaFav = new MusicaFav();
				musicaFav.setId_musicaFav(rs.getLong("id_musica_favorita"));
				musicaFav.getUsuario().setId_usuario(rs.getLong("id_usuario"));
				musicaFav.getMusica().setId_musica(rs.getLong("id_musica"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return musicaFav;
	}
	public List<MusicaFav> buscarMusicasFavoritas(Usuario usuario) {
		MusicaFav musicasFav = null;
		List<MusicaFav> listaMusicasFav = new ArrayList<>();
		try {
			this.conexao.abrirConexao();
			String sql = "SELECT * FROM musica_favorita WHERE id_usuario=?";
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
			statement.setLong(1, usuario.getId_usuario());
			ResultSet rs = statement.executeQuery();

			while(rs.next() == true) {
				musicasFav = new MusicaFav();
                musicasFav.setId_musicaFav(rs.getLong("id_musica_favorita"));
                musicasFav.getMusica().setId_musica(rs.getLong("id_musica"));
                musicasFav.getUsuario().setId_usuario(rs.getLong("id_usuario"));
				listaMusicasFav.add(musicasFav);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaMusicasFav;
	}
}
