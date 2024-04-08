package br.com.Meadow.modelos;

import java.util.List;

public class Genero {
	private long id_genero;
	private String nome;
	private List<Musica> musica;;
	
	public Genero() {
		id_genero = 0;
		nome = "";
		musica = null;
	}
	public Genero(long id_genero, String nome, List<Musica> musica) {
		super();
		this.id_genero = id_genero;
		this.nome = nome;
		this.musica = musica;
	}
	
	public long getId_genero() {
		return id_genero;
	}
	public void setId_genero(long id_genero) {
		this.id_genero = id_genero;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Musica> getMusica() {
		return musica;
	}
	public void setMusica(List<Musica> musica) {
		this.musica = musica;
	}
	
	@Override
	public String toString() {
		return "Genero [id_genero=" + id_genero + ", nome=" + nome + ", musica=" + musica + "]";
	}
	
	
}
