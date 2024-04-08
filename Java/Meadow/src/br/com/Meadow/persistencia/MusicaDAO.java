package br.com.Meadow.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.Meadow.modelos.Artista;
import br.com.Meadow.modelos.Genero;
import br.com.Meadow.modelos.Musica;

public class MusicaDAO {
	
	private ConexaoMysql conexao;

	public MusicaDAO() {
		this.conexao = new ConexaoMysql("localhost", "3306", "root", "root", "bd_comunicacao_java_mysql_2i_2023");
	}
	
	public void salvar(Musica musica) {
		try {
			this.conexao.abrirConexao();
			String sql = "INSERT INTO musica VALUES(null, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
			statement.setString(1, musica.getNome());
			statement.setString(2, musica.getAudio());
			statement.setDate(3, (java.sql.Date) musica.getDt_lancamento());
            statement.setTime(4, (java.sql.Time) musica.getTemp_duracao());
            statement.setString(5, musica.getCapa());
            statement.setLong(6, musica.getArtista().getId_artista());
            statement.setLong(7, musica.getGenero().getId_genero());
              
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}
	
	public void editar(Musica musica) {
  		 try {
  			 this.conexao.abrirConexao();
  			 String sql = "UPDATE musica SET nome=?, audio=?, dt_lancamento=?, temp_duracao=?, capa=?, id_artista=?, id_genero WHERE id_musica=?";
  			 PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
  			 statement.setString(1, musica.getNome());
  			 statement.setString(2, musica.getAudio());
  			 statement.setDate(3, (java.sql.Date) musica.getDt_lancamento());
  			 statement.setTime(4, musica.getTemp_duracao());
  			 statement.setString(5, musica.getCapa());
  			 statement.setLong(6, musica.getArtista().getId_artista());
  			statement.setLong(7, musica.getGenero().getId_genero());
  			 statement.setLong(8, musica.getId_musica());
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
  			 String sql = "DELETE FROM musica WHERE id_musica=?";
  			 PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
  			 statement.setLong(1, id);
  			 statement.executeUpdate();
  		 } catch (SQLException e) {
  			 e.printStackTrace();
  		 } finally {
  			 this.conexao.fecharConexao();
  		 }
  	 }

  	 public Musica buscarPorId(long id) {
  		Musica musica = null;
  		 try {
  			 this.conexao.abrirConexao();
  			 String sql = "SELECT * FROM musica WHERE id_musica=?";
  			 PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
  			 statement.setLong(1, id);
  			 ResultSet rs = statement.executeQuery();

  			 if (rs.next() == true) {
  				 musica = new Musica();
  				 musica.setId_musica(rs.getLong("id_musica"));
  				 musica.setNome(rs.getString("nome"));
  				 musica.setAudio(rs.getString("audio"));
  				 musica.setDt_lancamento(rs.getDate("dt_lancamento"));
  				 musica.setTemp_duracao(rs.getTime("temp_duracao"));
  				 musica.setCapa(rs.getString("capa"));
  				 musica.getArtista().setId_artista(rs.getLong("id_artista"));
  				 musica.getGenero().setId_genero(rs.getLong("id_genero"));
  			 }
  		 } catch (SQLException e) {
  			 e.printStackTrace();
  		 }
  		 return musica;
  	 }

  	 public List<Musica> buscarTodos() {
 		 Musica musica = null;
 		 List<Musica>  listaMusicas = new ArrayList<>();
  		 try {
  			 this.conexao.abrirConexao();
  			 String sql = "SELECT * FROM musica";
  			 PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
  			 ResultSet rs = statement.executeQuery();

  			 while(rs.next() == true) {
  				 musica = new Musica();
  				 musica.setId_musica(rs.getLong("id_musica"));
  				 musica.setNome(rs.getString("nome"));
  				 musica.setAudio(rs.getString("audio"));
  				 musica.setDt_lancamento(rs.getDate("dt_lancamento"));
  				 musica.setTemp_duracao(rs.getTime("temp_duracao"));
  				 musica.setCapa(rs.getString("capa"));
  				 musica.getArtista().setId_artista(rs.getLong("id_artista"));
  				 musica.getGenero().setId_genero(rs.getLong("id_genero"));
  				 listaMusicas.add(musica);
  			 }
  		 } catch (SQLException e) {
  			 e.printStackTrace();
  		 }
  		 return listaMusicas;
  	 }
  	public List<Musica> buscarPorNome(String nome) {
		 Musica musica = null;
		 List<Musica>  listaMusicas = new ArrayList<>();
 		 try {
 			 this.conexao.abrirConexao();
 			 String sql = "SELECT * FROM musica WHERE nome=?";
 			 PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
 			 ResultSet rs = statement.executeQuery();
  			 statement.setString(1, nome);
 			 while(rs.next() == true) {
 				 musica = new Musica();
 				 musica.setId_musica(rs.getLong("id_musica"));
 				 musica.setNome(rs.getString("nome"));
 				 musica.setAudio(rs.getString("audio"));
 				 musica.setDt_lancamento(rs.getDate("dt_lancamento"));
 				 musica.setTemp_duracao(rs.getTime("temp_duracao"));
 				 musica.setCapa(rs.getString("capa"));
 				 musica.getArtista().setId_artista(rs.getLong("id_artista"));
 				 musica.getGenero().setId_genero(rs.getLong("id_genero"));
 				 listaMusicas.add(musica);
 			 }
 		 } catch (SQLException e) {
 			 e.printStackTrace();
 		 }
 		 return listaMusicas;
 	 }
  	public List<Musica> buscarPorGenero(Genero genero) {
		 Musica musica = null;
		 List<Musica>  listaMusicas = new ArrayList<>();
		 try {
			 this.conexao.abrirConexao();
			 String sql = "SELECT * FROM musica WHERE genero=?";
			 PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
			 ResultSet rs = statement.executeQuery();
 			 statement.setLong(1, genero.getId_genero());
			 while(rs.next() == true) {
				 musica = new Musica();
				 musica.setId_musica(rs.getLong("id_musica"));
				 musica.setNome(rs.getString("nome"));
				 musica.setAudio(rs.getString("audio"));
				 musica.setDt_lancamento(rs.getDate("dt_lancamento"));
				 musica.setTemp_duracao(rs.getTime("temp_duracao"));
				 musica.setCapa(rs.getString("capa"));
				 musica.getArtista().setId_artista(rs.getLong("id_artista"));
				 musica.getGenero().setId_genero(rs.getLong("id_genero"));
				 listaMusicas.add(musica);
			 }
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
		 return listaMusicas;
	 }
  	public List<Musica> buscarPorArtista(Artista artista) {
		 Musica musica = null;
		 List<Musica>  listaMusicasArtista = new ArrayList<>();
		 try {
			 this.conexao.abrirConexao();
			 String sql = "SELECT * FROM musica WHERE id_artista=?";
			 PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
			 ResultSet rs = statement.executeQuery();
			 statement.setLong(1, artista.getId_artista());
			 while(rs.next() == true) {
				 musica = new Musica();
				 musica.setId_musica(rs.getLong("id_musica"));
				 musica.setNome(rs.getString("nome"));
				 musica.setAudio(rs.getString("audio"));
				 musica.setDt_lancamento(rs.getDate("dt_lancamento"));
				 musica.setTemp_duracao(rs.getTime("temp_duracao"));
				 musica.setCapa(rs.getString("capa"));
				 musica.getArtista().setId_artista(rs.getLong("id_artista"));
				 musica.getGenero().setId_genero(rs.getLong("id_genero"));
				 listaMusicasArtista.add(musica);
			 }
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
		 return listaMusicasArtista;
	 }
	
}
