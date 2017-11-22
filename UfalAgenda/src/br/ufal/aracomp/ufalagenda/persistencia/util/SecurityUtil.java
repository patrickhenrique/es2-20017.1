package br.ufal.aracomp.ufalagenda.persistencia.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityUtil {

	public static String gerarHash(String frase) {
		String out = "";
		
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
		md.update(frase.getBytes());
		byte[] hashMd5 = md.digest();
		out = stringHexa(hashMd5);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return out;
	}
	
	private static String stringHexa(byte[] bytes) {
		   StringBuilder s = new StringBuilder();
		   for (int i = 0; i < bytes.length; i++) {
		       int parteAlta = ((bytes[i] >> 4) & 0xf) << 4;
		       int parteBaixa = bytes[i] & 0xf;
		       if (parteAlta == 0) s.append('0');
		       s.append(Integer.toHexString(parteAlta | parteBaixa));
		   }
		   return s.toString();
		}
}
