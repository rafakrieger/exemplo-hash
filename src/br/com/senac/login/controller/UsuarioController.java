package br.com.senac.login.controller;

import java.security.NoSuchAlgorithmException;

import br.com.senac.login.model.bo.UsuarioBO;
import br.com.senac.login.model.exception.NomeInvalidoException;
import br.com.senac.login.model.exception.SenhaInvalidaException;
import br.com.senac.login.model.vo.Usuario;

public class UsuarioController {

	private UsuarioBO bo = new UsuarioBO();

	public String entrar(Usuario usuario) throws NoSuchAlgorithmException {
		String mensagem = "";
		boolean valido = true;

		try {
			this.validarNome(usuario.getNome());
		} catch (NomeInvalidoException excecao) {
			valido = false;
			mensagem = excecao.getMessage();
		}
		try {
			this.validarSenha(usuario.getSenha());
		} catch (SenhaInvalidaException excecao) {
			valido = false;
			mensagem = excecao.getMessage();
		}
		
		if (valido) {			
			if (bo.entrar(usuario)) {
				mensagem = "Bem-vindo!";
			} else {
				mensagem = "Credenciais incorretas";
			}
		}

		return mensagem;
	}
	
	
	private void validarNome(String nome) throws NomeInvalidoException {
		if (nome == null || nome.isEmpty() || nome.length() < 3) {
			throw new NomeInvalidoException("Nome deve possuir ao menos 3 caracteres");
		}

	}
	
	private void validarSenha(char[] senha) throws SenhaInvalidaException {
		if (senha.length < 5) {
			throw new SenhaInvalidaException("Senha deve possuir ao menos 5 caracteres");
		}

	}

}
