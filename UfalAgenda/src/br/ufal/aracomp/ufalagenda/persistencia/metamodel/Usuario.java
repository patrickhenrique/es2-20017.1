package br.ufal.aracomp.ufalagenda.persistencia.metamodel;

import java.util.List;

import br.ufal.aracomp.ufalagenda.persistencia.util.SecurityUtil;

public class Usuario {
	//atributos
	private int id;
	private String login;
	private String hashSenha;
	private String email;
	private String facebook;
	
	//associacoes
	private List<OpcaoDeHorario> opcoesHorario;
	private Agenda agenda;
	
	//construtores
	public Usuario(String login, String senha, String email, String facebook) {
		this.login = login;
		this.hashSenha = SecurityUtil.gerarHash(senha);
		this.email = email;
		this.facebook = facebook;
	}
	
	public Usuario(int id, String login, String senha, String email, String facebook) {
		this(login, senha, email, facebook);
		this.id = id;
	}
	
	//metodos
	public int getId() {
		return id;
	}
	public String getLogin() {
		return login;
	}
	public boolean validarSenha(String senha) {
		if(SecurityUtil.gerarHash(senha).equals(this.hashSenha))
			return true;
		else
			return false;
	}
	public String getEmail() {
		return email;
	}
	public String getFacebook() {
		return facebook;
	}
	public List<OpcaoDeHorario> getOpcoesHorario() {
		return opcoesHorario;
	}
	public Agenda getAgenda() {
		return agenda;
	}
	
	public void definirSenha(String senha) {
		this.hashSenha = SecurityUtil.gerarHash(senha);
	}
	
	
	@Override
	public boolean equals(Object obj) {
		boolean out = false;
	
		if(obj instanceof Usuario) {
			if(((Usuario)obj).getId()==this.id)
				obj = true;
		}
		return out;
	}
}
