package com.majorbit.model;


public class Utenti {

	private Integer id;
	private String nome;
	private String cognome;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	@Override
	public String toString() {
		return "Utenti [id=" + id + ", nome=" + nome + ", cognome=" + cognome + "]";
	}
	public Utenti(Integer id, String nome, String cognome) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
	}
	public Utenti() {};
}
