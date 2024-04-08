package br.com.Meadow.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.Meadow.modelos.ArtistaFav;
import br.com.Meadow.modelos.Usuario;

public class ArtistaFavDAO {
	
	private ConexaoMysql conexao;
	
	public ArtistaFavDAO() {
		this.conexao = new ConexaoMysql("localhost", "3306", "root", "root", "bd_comunicacao_java_mysql_2i_2023");
	}

	public void salvar(ArtistaFav artistaFav) {
		try {
			this.conexao.abrirConexao();
			String sql = "INSERT INTO artista_favorita VALUES(null, ?, ?)";
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
			statement.setLong(1, artistaFav.getArtista().getId_artista());
			statement.setLong(2, artistaFav.getUsuario().getId_usuario());
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
			String sql = "DELETE FROM artista_favorita WHERE id_artista_favorita=?";
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
			statement.setLong(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}
	
	public ArtistaFav buscarPorId(long id) {
		ArtistaFav artistaFav = null;
		try {
			this.conexao.abrirConexao();
			String sql = "SELECT * FROM artista_favorita WHERE id_artista_favorita=?";
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			if (rs.next() == true) {
				artistaFav = new ArtistaFav();
				artistaFav.setId_artistaFav(rs.getLong("id_artista_favorita"));
				artistaFav.getArtista().setId_artista(rs.getLong("id_artista"));
				artistaFav.getUsuario().setId_usuario(rs.getLong("id_usuario"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return artistaFav;
	}
	public List<ArtistaFav> buscarFavoritos(Usuario usuario) {
		ArtistaFav artistaFav = null;
		List<ArtistaFav> listaArtistasFav = new ArrayList<>();
		try {
			this.conexao.abrirConexao();
			String sql = "SELECT * FROM artista_favorita WHERE id_usuario=?";
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
			statement.setLong(1, usuario.getId_usuario());
			ResultSet rs = statement.executeQuery();

			while(rs.next() == true) {
				artistaFav = new ArtistaFav();
                artistaFav.setId_artistaFav(rs.getLong("id_artista_favorita"));
                artistaFav.getArtista().setId_artista(rs.getLong("id_artista"));
                artistaFav.getUsuario().setId_usuario(rs.getLong("id_usuario"));
				listaArtistasFav.add(artistaFav);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaArtistasFav;
	}
}
