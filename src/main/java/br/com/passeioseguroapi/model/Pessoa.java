package br.com.passeioseguroapi.model;

public class Pessoa {
	private String nome;
	private String email;
	private String telefone;
	private String endereco;
	
	public Pessoa() {
		
	}
	
	public Pessoa(String nome, String email,String telefone,String endereco) {
		setNome(nome);
		setEmail(email);
		setTelefone(telefone);
		setEndereco(endereco);
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
}
