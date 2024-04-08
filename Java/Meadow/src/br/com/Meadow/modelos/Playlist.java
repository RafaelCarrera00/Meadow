package br.com.Meadow.modelos;

import java.util.List;

public class Playlist {
	
	private long id_playlist;
	private String nome;
	private String capa;
	private Usuario usuario;
	private List<MusicaPlaylist> MusicaPlaylist;
	
	public Playlist() {
		id_playlist = 0;
		nome = "";
		capa = "";
		usuario = null;
		MusicaPlaylist = null;
	}

	public Playlist(long id_playlist, String nome, String capa, Usuario usuario,
			List<MusicaPlaylist> musicaPlaylist) {
		super();
		this.id_playlist = id_playlist;
		this.nome = nome;
		this.capa = capa;
		this.usuario = usuario;
		MusicaPlaylist = musicaPlaylist;
	}

	public long getId_playlist() {
		return id_playlist;
	}

	public void setId_playlist(long id_playlist) {
		this.id_playlist = id_playlist;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCapa() {
		return capa;
	}

	public void setCapa(String capa) {
		this.capa = capa;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<MusicaPlaylist> getMusicaPlaylist() {
		return MusicaPlaylist;
	}

	public void setMusicaPlaylist(List<MusicaPlaylist> musicaPlaylist) {
		MusicaPlaylist = musicaPlaylist;
	}

	@Override
	public String toString() {
		return "Playlist [id_playlist=" + id_playlist + ", nome=" + nome + ", capa=" + capa
				+ ", usuario=" + usuario + ", MusicaPlaylist=" + MusicaPlaylist + "]";
	}
	
	
	
}
