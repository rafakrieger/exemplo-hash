package br.com.senac.login.model.vo;

public class Usuario {
	
	private int idUsuario;
	private String nome;
	private char[] senha;
	
	public Usuario() {
		super();
	}

	public Usuario(int idUsuario, String nome, char[] senha) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.senha = senha;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public char[] getSenha() {
		return senha;
	}

	public void setSenha(char[] cs) {
		this.senha = cs;
	}
	
		
	

}
