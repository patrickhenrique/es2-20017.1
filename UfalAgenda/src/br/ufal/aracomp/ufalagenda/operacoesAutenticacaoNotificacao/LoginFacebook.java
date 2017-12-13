package br.ufal.aracomp.ufalagenda.operacoesAutenticacaoNotificacao;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONObject;

public class LoginFacebook {
	
	/**
	 * Retorna os dados de um Usuario do facebook
	 * @param code token de acesso facebook
	 * @return Objeto json
	 **/
	public JSONObject obterUsuarioFacebook(String code) throws MalformedURLException, IOException {
		return new JSONObject(readURL(new URL("https://graph.facebook.com/me?fields=id,name,email&access_token=" + code)));
	}

	
	/**
	 * Retorna uma estrutura json em string
	 * @param url link da api facebook
	 * @return Objeto json no formato de string
	 **/
	public String readURL(URL url) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		InputStream is = url.openStream();
		int r;
		while ((r = is.read()) != -1) {
			baos.write(r);
		}
		return new String(baos.toByteArray());
	}

}