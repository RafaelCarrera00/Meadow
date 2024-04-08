package br.com.Meadow.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.Meadow.modelos.Album;

public class AlbumDAO {
	private ConexaoMysql conexao;

	public AlbumDAO() {
		this.conexao = new ConexaoMysql("localhost", "3306", "root", "root", "bd_comunicacao_java_mysql_2i_2023");
	}
	
	public void salvar(Album album) {
		try {
			this.conexao.abrirConexao();
			String sql = "INSERT INTO album VALUES(null, ?, ?, ?)";
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
			statement.setString(1, album.getNome());
			statement.setString(2, album.getCapa());
			statement.setLong(3, album.getArtista().getId_artista());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}
	
	public void editar(Album album) {
  		 try {
  			 this.conexao.abrirConexao();
  			 String sql = "UPDATE album SET nome=?, capa=?, id_artista=? WHERE id_album=?";
  			 PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
  			 statement.setString(1, album.getNome());
  			 statement.setString(2, album.getCapa());
  			 statement.setLong(3, album.getArtista().getId_artista());
  			 statement.setLong(1, album.getId_album());
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
  			 String sql = "DELETE FROM album WHERE id_artista=?";
  			 PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
  			 statement.setLong(1, id);
  			 statement.executeUpdate();
  		 } catch (SQLException e) {
  			 e.printStackTrace();
  		 } finally {
  			 this.conexao.fecharConexao();
  		 }
  	 }


  	 public Album buscarPorNome(String nome) {
  		 Album album = null;
  		 try {
  			 this.conexao.abrirConexao();
  			 String sql = "SELECT * FROM album WHERE nome=?";
  			 PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
  			 statement.setString(1, nome);
  			 ResultSet rs = statement.executeQuery();

  			 if (rs.next() == true) {
  				 album = new Album();
  				 album.setId_album(rs.getLong("id_album"));
  				 album.setNome(rs.getString("nome"));
  				 album.setCapa(rs.getString("capa"));
  				 album.getArtista().setId_artista(rs.getLong("id_artista"));
  			 }
  		 } catch (SQLException e) {
  			 e.printStackTrace();
  		 }
  		 return album;
  	 }
  	 public List<Album> buscarPorArtista(long id) {
 		 Album album = null;
 		 List<Album>  listaAlbum = new ArrayList<>();
  		 try {
  			 this.conexao.abrirConexao();
  			 String sql = "SELECT * FROM album WHERE id_artista=?";
  			 PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
  			 statement.setLong(1, id);
  			 ResultSet rs = statement.executeQuery();

  			 while(rs.next() == true) {
  				 album = new Album();
  				 album.setId_album(rs.getLong("id_album"));
  				 album.setNome(rs.getString("nome"));
  				 album.setCapa(rs.getString("capa"));
  				 album.getArtista().setId_artista(rs.getLong("id_artista"));
  				 listaAlbum.add(album);
  			 }
  		 } catch (SQLException e) {
  			 e.printStackTrace();
  		 }
  		 return listaAlbum;
  	 }
}
