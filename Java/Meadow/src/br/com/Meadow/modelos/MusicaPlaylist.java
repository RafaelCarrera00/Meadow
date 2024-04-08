package br.com.Meadow.modelos;

public class MusicaPlaylist {
	private long id_musicaPlaylist;
	private Playlist playlist;
	private Musica musica;
	
	public MusicaPlaylist() {
		id_musicaPlaylist = 0;
		playlist = null;
		musica = null;
	}

	public MusicaPlaylist(long id_musicaPlaylist, Playlist playlist, Musica musica) {
		super();
		this.id_musicaPlaylist = id_musicaPlaylist;
		this.playlist = playlist;
		this.musica = musica;
	}

	public long getId_musicaPlaylist() {
		return id_musicaPlaylist;
	}

	public void setId_musicaPlaylist(long id_musicaPlaylist) {
		this.id_musicaPlaylist = id_musicaPlaylist;
	}

	public Playlist getPlaylist() {
		return playlist;
	}

	public void setPlaylist(Playlist playlist) {
		this.playlist = playlist;
	}

	public Musica getMusica() {
		return musica;
	}

	public void setMusica(Musica musica) {
		this.musica = musica;
	}

	@Override
	public String toString() {
		return "MusicaPlaylist [id_musicaPlaylist=" + id_musicaPlaylist + ", playlist=" + playlist + ", musica="
				+ musica + "]";
	}
	
	
	
}
