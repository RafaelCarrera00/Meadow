package br.com.Meadow.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.Meadow.modelos.MusicaPlaylist;
import br.com.Meadow.modelos.Playlist;

public class MusicaPlaylistDAO {
	
private ConexaoMysql conexao;
	
	public MusicaPlaylistDAO() {
		this.conexao = new ConexaoMysql("localhost", "3306", "root", "root", "bd_comunicacao_java_mysql_2i_2023");
	}

	public void salvar(MusicaPlaylist musicaPlaylist) {
		try {
			this.conexao.abrirConexao();
			String sql = "INSERT INTO musica_playlist VALUES(null, ?, ?)";
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
			statement.setLong(1, musicaPlaylist.getPlaylist().getId_playlist());
			statement.setLong(2, musicaPlaylist.getMusica().getId_musica());
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
			String sql = "DELETE FROM musica_playlist WHERE id_musica_playlist=?";
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
			statement.setLong(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}
	
	public MusicaPlaylist buscarPorId(long id) {
		MusicaPlaylist musicaPlaylist = null;
		try {
			this.conexao.abrirConexao();
			String sql = "SELECT * FROM musica_playlist WHERE id_musica_playlist=?";
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			if (rs.next() == true) {
				musicaPlaylist = new MusicaPlaylist();
				musicaPlaylist.setId_musicaPlaylist(rs.getLong("id_musica_playlist"));
				musicaPlaylist.getPlaylist().setId_playlist(rs.getLong("id_playlist"));
				musicaPlaylist.getMusica().setId_musica(rs.getLong("id_musica"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return musicaPlaylist;
	}
	public List<MusicaPlaylist> buscarMusicasPlaylist(Playlist playlist) {
		MusicaPlaylist musicaPlaylist = null;
		List<MusicaPlaylist> listaMusicaPlaylist = new ArrayList<>();
		try {
			this.conexao.abrirConexao();
			String sql = "SELECT * FROM musica_album WHERE id_playlist";
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
			statement.setLong(1, playlist.getId_playlist());
			ResultSet rs = statement.executeQuery();

			while(rs.next() == true) {
				musicaPlaylist = new MusicaPlaylist();
				musicaPlaylist.setId_musicaPlaylist(rs.getLong("id_musica_playlist"));
                musicaPlaylist.getMusica().setId_musica(rs.getLong("id_musica"));
                musicaPlaylist.getPlaylist().setId_playlist(rs.getLong("id_playlist"));
				listaMusicaPlaylist.add(musicaPlaylist);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaMusicaPlaylist;
	}
}
