package br.ufal.aracomp.ufalagenda.AutenticacaoNotificacao;

import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Usuario;

public interface IAutenticacao {
	
	/*
	 * Verifica se o usuário é válido e tem como retorno true ou false
	 * aut_tipo = Campo de autenticação, como email, login, facebook
	 * aut_valor = Valor do campo de autenticação
	 * senha = Senha do usuário
	 * */
	
	public boolean autenticar(String aut_tipo, String aut_valor, String senha);
	
	/*
	 * Verifica se o usuário é válido e tem como retorno true ou false
	 * aut_valor = Valor do campo de autenticação
	 * senha = Senha do usuário
	 * */
	public boolean autenticar(String aut_valor, String senha);
	
	/*
	 * Trata os dados do usuário e verifica se o mesmo está autenticado como retorno true ou false
	 * usuario = Objeto do tipo Usuario
	 * */
	public boolean logar(Usuario usuario);
	
	
}
