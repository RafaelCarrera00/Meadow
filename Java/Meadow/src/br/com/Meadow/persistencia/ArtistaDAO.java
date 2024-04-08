package br.com.Meadow.persistencia;

	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;

	import br.com.Meadow.modelos.Artista;
	
public class ArtistaDAO {

		private ConexaoMysql conexao;

		public ArtistaDAO() {
			this.conexao = new ConexaoMysql("localhost", "3306", "root", "root", "bd_comunicacao_java_mysql_2i_2023");
		}

		public void salvar(Artista artista) {
			try {
				this.conexao.abrirConexao();
				String sql = "INSERT INTO artista VALUES(null, ?, ?, ?, ?, ?, ?)";
				PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
				statement.setString(1, artista.getNome());
				statement.setString(2, artista.getSenha());
				statement.setString(3, artista.getEmail());
	            statement.setString(4, artista.getDescricao());
	            statement.setString(5, artista.getImg());
	            statement.setString(6, artista.getApelido());
				statement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				this.conexao.fecharConexao();
			}
		}

		public void editar(Artista artista) {
			try {
				this.conexao.abrirConexao();
				String sql = "UPDATE artista SET nome=? , senha=?, email=?, descricao=?, imagem=?, apelido=? WHERE id_artista=?";
				PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
				statement.setString(1, artista.getNome());
				statement.setString(2, artista.getSenha());
				statement.setString(3, artista.getEmail());
	            statement.setString(4, artista.getDescricao());
	            statement.setString(5, artista.getImg());
	            statement.setString(6, artista.getApelido());
				statement.setLong(7, artista.getId_artista());
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
				String sql = "DELETE FROM artista WHERE id_artista=?";
				PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
				statement.setLong(1, id);
				statement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				this.conexao.fecharConexao();
			}
		}

		public Artista buscarPorId(long id) {
			Artista artista = null;
			try {
				this.conexao.abrirConexao();
				String sql = "SELECT * FROM artista WHERE id_artista=?";
				PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
				statement.setLong(1, id);
				ResultSet rs = statement.executeQuery();

				if (rs.next() == true) {
					artista = new Artista();
					artista.setId_artista(rs.getLong("id_artista"));
					artista.setSenha(rs.getString("senha"));
					artista.setEmail(rs.getString("email"));
					artista.setNome(rs.getString("nome"));
	                artista.setApelido(rs.getString("apelido"));
	                artista.setDescricao(rs.getString("descricao"));
	                artista.setImg(rs.getString("imagem"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return artista;
		}

		public List<Artista> buscarTodos() {
			Artista artista = null;
			List<Artista> listaArtistas = new ArrayList<>();
			try {
				this.conexao.abrirConexao();
				String sql = "SELECT * FROM artista";
				PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
				ResultSet rs = statement.executeQuery();

				while(rs.next() == true) {
					Artista a = new Artista();
					a.setId_artista(rs.getLong("id_artista"));
					a.setSenha(rs.getString("senha"));
					a.setEmail(rs.getString("email"));
					a.setNome(rs.getString("nome"));
	                a.setDescricao(rs.getString("descricao"));
	                a.setImg(rs.getString("imagem"));
					listaArtistas.add(artista);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return listaArtistas;
		}
		public Artista buscarPorApelido(String apelido) {
			Artista artista = null;
			try {
				this.conexao.abrirConexao();
				String sql = "SELECT * FROM artista WHERE apelido=?";
				PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
				statement.setString(1, apelido);
				ResultSet rs = statement.executeQuery();

				if (rs.next() == true) {
					Artista a = new Artista();
					a.setId_artista(rs.getLong("id_artista"));
					a.setSenha(rs.getString("senha"));
					a.setEmail(rs.getString("email"));
					a.setNome(rs.getString("nome"));
	                a.setApelido(rs.getString("apelido"));
	                a.setDescricao(rs.getString("descricao"));
	                a.setImg(rs.getString("imagem"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return artista;
		}

}
