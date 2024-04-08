package br.com.Meadow.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.Meadow.modelos.Album;
import br.com.Meadow.modelos.MusicaAlbum;

public class MusicaAlbumDAO {
	
private ConexaoMysql conexao;
	
	public MusicaAlbumDAO() {
		this.conexao = new ConexaoMysql("localhost", "3306", "root", "root", "bd_comunicacao_java_mysql_2i_2023");
	}

	public void salvar(MusicaAlbum musicaAlbum) {
		try {
			this.conexao.abrirConexao();
			String sql = "INSERT INTO musica_album VALUES(null, ?, ?)";
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
			statement.setLong(1, musicaAlbum.getAlbum().getId_album());
			statement.setLong(2, musicaAlbum.getMusica().getId_musica());
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
			String sql = "DELETE FROM musica_album WHERE id_musica_album=?";
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
			statement.setLong(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}
	
	public MusicaAlbum buscarPorId(long id) {
		MusicaAlbum musicaAlbum = null;
		try {
			this.conexao.abrirConexao();
			String sql = "SELECT * FROM musica_album WHERE id_musica_album=?";
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			if (rs.next() == true) {
				musicaAlbum = new MusicaAlbum();
				musicaAlbum.setId_musicaAlbum(rs.getLong("id_musica_album"));
				musicaAlbum.getAlbum().setId_album(rs.getLong("id_album"));
				musicaAlbum.getMusica().setId_musica(rs.getLong("id_musica"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return musicaAlbum;
	}
	public List<MusicaAlbum> buscarMusicasAlbum(Album album) {
		MusicaAlbum musicaAlbum = null;
		List<MusicaAlbum> listaMusicaAlbum = new ArrayList<>();
		try {
			this.conexao.abrirConexao();
			String sql = "SELECT * FROM musica_album WHERE id_album";
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
			statement.setLong(1, album.getId_album());
			ResultSet rs = statement.executeQuery();

			while(rs.next() == true) {
				musicaAlbum = new MusicaAlbum();
				musicaAlbum.setId_musicaAlbum(rs.getLong("id_musica_album"));
                musicaAlbum.getMusica().setId_musica(rs.getLong("id_musica"));
                musicaAlbum.getAlbum().setId_album(rs.getLong("id_album"));
				listaMusicaAlbum.add(musicaAlbum);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaMusicaAlbum;
	}
}
