package br.com.Meadow.modelos;

import java.util.List;

public class Album {
	
	private long id_album;
	private String nome;
	private String capa;
	private Artista artista;
	private List<MusicaAlbum> album;
	
	public Album() {
		id_album = 0;
		nome = "";
		capa = "";
		artista = null;
		album = null;
	}
	public Album(long id_artista, String nome, String capa, Artista artista, List<MusicaAlbum> album) {
		this.id_album = id_artista;
		this.nome = nome;
		this.capa = capa;
		this.artista = artista;
		this.album = album;
	}
	
	public long getId_album() {
		return id_album;
	}
	public void setId_album(long id_artista) {
		this.id_album = id_artista;
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
	public Artista getArtista() {
		return artista;
	}
	public void setArtista(Artista artista) {
		this.artista = artista;
	}
	public List<MusicaAlbum> getAlbum() {
		return album;
	}
	public void setAlbum(List<MusicaAlbum> album) {
		this.album = album;
	}
	
	@Override
	public String toString() {
		return "Album: \nid_artista=" + id_album + ", \nnome=" + nome + ", \ncapa=" + capa + ", \nartista=" + artista
				+ ", \nalbum=" + album + "]";
	}
	
	
	
	
	
	
}
