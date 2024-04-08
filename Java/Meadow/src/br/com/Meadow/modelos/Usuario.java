package br.com.Meadow.modelos;

import java.util.List;

public class Usuario {
	private long id_usuario;
    private String senha;
    private String email;
    private String nome;
    private String apelido;
    private String img;
    private List<ArtistaFav> artistaFav;
    private List<MusicaFav> musicaFav;
    private List<Playlist> playlist;
    
	public Usuario() {
		id_usuario = 0;
		senha = "";
		email = "";
		nome = "";
		apelido = "";
		img = "";
		artistaFav = null;
		musicaFav = null;
		playlist = null;
	}

	public Usuario(long id_usuario, String senha, String email, String nome, String apelido, String img, 
		List<ArtistaFav> artistaFav, List<MusicaFav> musicaFav, List<Playlist> playlist) {
		this.id_usuario = id_usuario;
		this.senha = senha;
		this.email = email;
		this.nome = nome;
		this.apelido = apelido;
		this.img = img;
		this.artistaFav = artistaFav;
		this.musicaFav = musicaFav;
		this.playlist = playlist;
	}

	public long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(long id_usuario) {
		this.id_usuario = id_usuario;
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

	public List<MusicaFav> getMusicaFav() {
		return musicaFav;
	}

	public void setMusicaFav(List<MusicaFav> musicaFav) {
		this.musicaFav = musicaFav;
	}

	public List<Playlist> getPlaylist() {
		return playlist;
	}

	public void setPlaylist(List<Playlist> playlist) {
		this.playlist = playlist;
	}

	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", senha=" + senha + ", email=" + email + ", nome=" + nome
				+ ", apelido=" + apelido + ", img=" + img + ", artistaFav=" + artistaFav + ", musicaFav=" + musicaFav
				+ ", playlist=" + playlist + "]";
	}

	
    
    
    
}
