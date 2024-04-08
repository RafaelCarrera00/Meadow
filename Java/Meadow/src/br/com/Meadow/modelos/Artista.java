package br.com.Meadow.modelos;

import java.util.List;

public class Artista {
	private long id_artista;
    private String senha;
    private String email;
    private String nome;
    private String apelido;
    private String descricao;
    private String img;
    private List<ArtistaFav> artistaFav;
    private List<Musica> musica;
    private List<Album> album;
    
	public Artista() {
		id_artista = 0;
		senha = "";
		email = "";
		nome = "";
		apelido = "";
		descricao = "";
		img = "";
		artistaFav = null;
		musica = null;
		album = null;
	}
	public Artista(long id_artista, String senha, String email, String nome, String apelido, String descricao,
			String img, List<ArtistaFav> artistaFav, List<Musica> musica, List<Album> album) {
		this.id_artista = id_artista;
		this.senha = senha;
		this.email = email;
		this.nome = nome;
		this.apelido = apelido;
		this.descricao = descricao;
		this.img = img;
		this.artistaFav = artistaFav;
		this.musica = musica;
		this.album = album;
	}

	public long getId_artista() {
		return id_artista;
	}
	public void setId_artista(long id_artista) {
		this.id_artista = id_artista;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public List<ArtistaFav> getArtistaFav() {
		return artistaFav;
	}
	public void setArtistaFav(List<ArtistaFav> artistaFav) {
		this.artistaFav = artistaFav;
	}
	public List<Musica> getMusica() {
		return musica;
	}
	public void setMusica(List<Musica> musica) {
		this.musica = musica;
	}
	public List<Album> getAlbum() {
		return album;
	}
	public void setAlbum(List<Album> album) {
		this.album = album;
	}
	@Override
	public String toString() {
		return "Artista [id_artista=" + id_artista + ", senha=" + senha + ", email=" + email + ", nome=" + nome
				+ ", apelido=" + apelido + ", descricao=" + descricao + ", img=" + img + ", artistaFav=" + artistaFav
				+ ", musica=" + musica + ", album=" + album + "]";
	}

	
	
    
	
	
    
}
