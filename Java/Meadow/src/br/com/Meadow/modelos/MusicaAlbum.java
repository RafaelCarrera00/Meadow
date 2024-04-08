package br.com.Meadow.modelos;

public class MusicaAlbum {
	
	private long id_musicaAlbum;
	private Musica musica;
	private Album album;
	
	public MusicaAlbum() {
		id_musicaAlbum = 0;
		musica = null;
		album = null;
	}

	public MusicaAlbum(long id_musicaAlbum, Musica musica, Album album) {
		super();
		this.id_musicaAlbum = id_musicaAlbum;
		this.musica = musica;
		this.album = album;
	}

	public long getId_musicaAlbum() {
		return id_musicaAlbum;
	}

	public void setId_musicaAlbum(long id_musicaAlbum) {
		this.id_musicaAlbum = id_musicaAlbum;
	}

	public Musica getMusica() {
		return musica;
	}

	public void setMusica(Musica musica) {
		this.musica = musica;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}
	@Override
	public String toString() {
		return "MusicaAlbum [id_musicaAlbum=" + id_musicaAlbum + ", musica=" + musica + ", album=" + album + "]";
	}
	
	
	
}
