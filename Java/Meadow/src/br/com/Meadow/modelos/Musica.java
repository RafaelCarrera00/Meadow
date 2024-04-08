package br.com.Meadow.modelos;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public class Musica {
	
	private long id_musica;
	 private String nome;
	 //audio é o link da musica no drive
	 private String audio;
	 private Time temp_duracao;
	 private Date dt_lancamento;
	 private String capa;
	 private Artista artista;
	 private Genero genero;
	 private List<MusicaFav> musicaFav;
	 private List<MusicaPlaylist> musicaPlaylist;
	 private List<MusicaAlbum> musicaAlbum;
	 
	public Musica() {
		id_musica = 0;
		nome = "";
		audio = "";
		temp_duracao = null;
		dt_lancamento = null;
		capa = "";
		artista = null;
		genero = null;
		musicaFav = null;
		musicaPlaylist = null;
		musicaAlbum = null;
	}
	public Musica(long id_musica, String nome, String audio, Time temp_duracao, Date dt_lancamento, String capa,
			Artista artista, Genero genero, List<MusicaFav> musicaFav, List<MusicaPlaylist> musicaPlaylist,
			List<MusicaAlbum> musicaAlbum) {
		super();
		this.id_musica = id_musica;
		this.nome = nome;
		this.audio = audio;
		this.temp_duracao = temp_duracao;
		this.dt_lancamento = dt_lancamento;
		this.capa = capa;
		this.artista = artista;
		this.genero = genero;
		this.musicaFav = musicaFav;
		this.musicaPlaylist = musicaPlaylist;
		this.musicaAlbum = musicaAlbum;
	}
	
	public long getId_musica() {
		return id_musica;
	}
	public void setId_musica(long id_musica) {
		this.id_musica = id_musica;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAudio() {
		return audio;
	}
	public void setAudio(String audio) {
		this.audio = audio;
	}
	public Time getTemp_duracao() {
		return temp_duracao;
	}
	public void setTemp_duracao(Time temp_duracao) {
		this.temp_duracao = temp_duracao;
	}
	public Date getDt_lancamento() {
		return dt_lancamento;
	}
	public void setDt_lancamento(Date dt_lancamento) {
		this.dt_lancamento = dt_lancamento;
	}
	public String getCapa() {
		return capa;
	}
	public void setCapa(String capa) {
		this.capa = capa;
	}
	public Artista getArtista() {
		return artista;
	}
	public void setArtista(Artista artista) {
		this.artista = artista;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public List<MusicaFav> getMusicaFav() {
		return musicaFav;
	}
	public void setMusicaFav(List<MusicaFav> musicaFav) {
		this.musicaFav = musicaFav;
	}
	public List<MusicaPlaylist> getMusicaPlaylist() {
		return musicaPlaylist;
	}
	public void setMusicaPlaylist(List<MusicaPlaylist> musicaPlaylist) {
		this.musicaPlaylist = musicaPlaylist;
	}
	public List<MusicaAlbum> getMusicaAlbum() {
		return musicaAlbum;
	}
	public void setMusicaAlbum(List<MusicaAlbum> musicaAlbum) {
		this.musicaAlbum = musicaAlbum;
	}
	
	@Override
	public String toString() {
		return "Musica [id_musica=" + id_musica + ", nome=" + nome + ", audio=" + audio + ", temp_duracao="
				+ temp_duracao + ", dt_lancamento=" + dt_lancamento + ", capa=" + capa + ", artista=" + artista
				+ ", genero=" + genero + ", musicaFav=" + musicaFav + ", musicaPlaylist=" + musicaPlaylist
				+ ", musicaAlbum=" + musicaAlbum + "]";
	}
	
	
	
}
