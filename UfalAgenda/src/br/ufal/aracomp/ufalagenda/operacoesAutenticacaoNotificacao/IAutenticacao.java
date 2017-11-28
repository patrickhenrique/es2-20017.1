package br.ufal.aracomp.ufalagenda.operacoesAutenticacaoNotificacao;

import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Usuario;

public interface IAutenticacao {
	
	/**
	 * Verifica se as credenciais do usuario sao validas
	 * @param login Login do usuario
	 * @param senha Senha do usuario
	 * @return O usuario que corresponde ao login e senha informados. Null, caso contrario.
	 */
	public Usuario autenticarLogin(String login, String senha);
	
	/**
	 * Verifica se as credenciais do usuario sao validas
	 * @param email Email do usuario
	 * @param senha Senha do usuario
	 * @return O usuario que corresponde ao email e senha informados. Null, caso contrario.
	 */
	public Usuario autenticarEmail(String email, String senha);
	
	/**
	 * Verifica se as credenciais do usuario sao validas
	 * @param facebook Login do facebook do usuario
	 * @param senha Senha do usuario
	 * @return O usuario que corresponde ao login do facebook e senha informados. Null, caso contrario.
	 */
	public Usuario autenticarFacebook(String facebook, String senha);
}

