package br.com.Meadow.modelos;

public class MusicaFav {
	
	private long id_musicaFav;
	private Usuario usuario;
	private Musica musica;
	
	public MusicaFav() {
		id_musicaFav = 0;
		usuario = null;
		musica = null;
	}

	public MusicaFav(long id_musicaFav, Usuario usuario, Musica musica) {
		super();
		this.id_musicaFav = id_musicaFav;
		this.usuario = usuario;
		this.musica = musica;
	}

	public long getId_musicaFav() {
		return id_musicaFav;
	}

	public void setId_musicaFav(long id_musicaFav) {
		this.id_musicaFav = id_musicaFav;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Musica getMusica() {
		return musica;
	}

	public void setMusica(Musica musica) {
		this.musica = musica;
	}

	
	@Override
	public String toString() {
		return "MusicaFav [id_musicaFav=" + id_musicaFav + ", usuario=" + usuario + ", musica=" + musica + "]";
	}
	
	
	
}
