package br.com.senac.login.model.bo;

import java.security.NoSuchAlgorithmException;

import br.com.senac.login.model.dao.UsuarioDao;
import br.com.senac.login.model.vo.Usuario;

public class UsuarioBO {
	
	UsuarioDao usuarioDao = new UsuarioDao();

	public boolean entrar(Usuario usuario) throws NoSuchAlgorithmException {		
		return usuarioDao.entrar(usuario);		
	}

}
