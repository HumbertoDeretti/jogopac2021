package br.edu.catolicasc.services;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Encrypt {
	private String hash;
	
	
	public String gerarMD5(String string) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
		}
	    md.update(string.getBytes());
	    
	    hash = new BigInteger(1,md.digest()).toString(16);
	
	    return hash;
	}
	public boolean validMD5(String senha,String hash) {
		String hashAtual = gerarMD5(senha);
		if(!hashAtual.equals(hash)) {
			return false;
		}
		else if(hashAtual.equals(hash)) {
			return true;
		}
		else {
			return false;
		}
	}
}
