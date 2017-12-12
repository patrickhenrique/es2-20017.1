package br.ufal.aracomp.ufalagenda.operacoesAutenticacaoNotificacao;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailNotificacao {
	
	private Email commonEmail;
	private String emailAplicacao;
	private String senhaEmailAplicacao;
	
	public EmailNotificacao() {
		
		this.emailAplicacao = "emailvalido@gmail.com";
		this.senhaEmailAplicacao = "senhavalida";
		
		this.commonEmail = new SimpleEmail();
		this.commonEmail = new SimpleEmail();
		this.commonEmail.setHostName("smtp.googlemail.com");
		this.commonEmail.setSmtpPort(465);
		this.commonEmail.setAuthentication(this.emailAplicacao, this.senhaEmailAplicacao);
		this.commonEmail.setSSLOnConnect(true);
	}
	
	public void enviar(String emailDestino,String assunto, String mensagem) {
		try {
			this.commonEmail.setFrom(this.emailAplicacao);
			this.commonEmail.setSubject(assunto);
			this.commonEmail.setMsg(mensagem);
			this.commonEmail.addTo(emailDestino);
			this.commonEmail.send();
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void enviar(String emailEnvia, String emailDestino,String assunto, String mensagem) {
		try {
			this.commonEmail.setFrom(emailEnvia);
			this.commonEmail.setSubject(assunto);
			this.commonEmail.setMsg(mensagem);
			this.commonEmail.addTo(emailDestino);
			this.commonEmail.send();
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
