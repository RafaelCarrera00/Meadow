package br.com.Meadow.modelos;

public class ArtistaFav {
	private long id_artistaFav;
    private Artista artista;
    private Usuario usuario;
    
	public ArtistaFav() {
		id_artistaFav = 0;
		artista = null;
		usuario = null;
	}
	public ArtistaFav(long id_artistaFav, Artista artista, Usuario usuario) {
		super();
		this.id_artistaFav = id_artistaFav;
		this.artista = artista;
		this.usuario = usuario;
	}
	
	public long getId_artistaFav() {
		return id_artistaFav;
	}
	public void setId_artistaFav(long id_artistaFav) {
		this.id_artistaFav = id_artistaFav;
	}
	public Artista getArtista() {
		return artista;
	}
	public void setArtista(Artista artista) {
		this.artista = artista;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "ArtistaFav [id_artistaFav=" + id_artistaFav + ", artista=" + artista + ", usuario=" + usuario + "]";
	}
    
    
}
