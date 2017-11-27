package br.ufal.aracomp.ufalagenda.AutenticacaoNotificacao;

import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Usuario;

public interface IAutenticacao {
	
	/*
	 * Verifica se as credenciais do usuário são válidas
	 * usuarios = Objeto do tipo usuário para obter os dados
	 * */
	public void autenticarLogin(Usuario usuario);
	
	/*
	 * Verifica se as credenciais do usuário são válidas
	 * usuarios = Objeto do tipo usuário para obter os dados
	 * */
	public void autenticarEmail(Usuario usuario);
	
	/*
	 * Verifica se as credenciais do usuário são válidas
	 * usuarios = Objeto do tipo usuário para obter os dados
	 * */
	public void autenticarFacebook(Usuario usuario);
	
	/*
	 * Trata os dados do usuário e verifica se o mesmo está autenticado como retorno true ou false
	 * usuario = Objeto do tipo Usuario
	 * */
	public boolean logar(Usuario usuario);
	
}

