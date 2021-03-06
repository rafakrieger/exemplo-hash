package br.com.senac.login.model.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.senac.login.model.vo.Usuario;

public class UsuarioDao {	

	public boolean entrar(Usuario usuario) throws NoSuchAlgorithmException {
		Connection conexao = Banco.getConnection();
		
		boolean entrou = false;
		String hash = new String(this.getHash(usuario));
		
		String sql = " SELECT * FROM USUARIO "
				   + " WHERE SENHA=? ";
		
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);		
		
		try {
			query.setString(1, hash);
			
			ResultSet rs = query.executeQuery();
			if(rs.next()) {
				entrou = true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar usuário por nome.\nCausa: " + e.getMessage());
		} finally {
			Banco.closeStatement(query);
			Banco.closeConnection(conexao);
		}
		
		return entrou;
	}

	private String getHash(Usuario usuario) throws NoSuchAlgorithmException {
		String senha = new String(usuario.getSenha());		
		byte[] digest = md5(senha);        
        String hash = hexaToString(digest);		
		return hash;
	}
	
	 public static byte[] md5(String message) throws NoSuchAlgorithmException{   
	        MessageDigest md = MessageDigest.getInstance("MD5");
	        md.update(message.getBytes());
	        byte[] digest = md.digest();
	        return digest;
	    }
	    
	    
	    public static String hexaToString(byte[] digest ){
	        // Convert digest to a string
	        StringBuffer hexString = new StringBuffer();
	        for (int i = 0; i < digest.length; i++) {
	            if ((0xff & digest[i]) < 0x10) {
	                hexString.append("0" + Integer.toHexString((0xFF & digest[i])));
	              } else {
	                hexString.append(Integer.toHexString(0xFF & digest[i]));
	            }
	        }  
	        return hexString.toString();  
	    }
	
}
