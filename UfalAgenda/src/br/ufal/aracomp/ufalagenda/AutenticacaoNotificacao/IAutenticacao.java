package br.ufal.aracomp.ufalagenda.AutenticacaoNotificacao;

import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Usuario;

public interface IAutenticacao {
	
	/*
	 * Verifica se o usu�rio � v�lido e tem como retorno true ou false
	 * aut_tipo = Campo de autentica��o, como email, login, facebook
	 * aut_valor = Valor do campo de autentica��o
	 * senha = Senha do usu�rio
	 * */
	
	public boolean autenticar(String aut_tipo, String aut_valor, String senha);
	
	/*
	 * Verifica se o usu�rio � v�lido e tem como retorno true ou false
	 * aut_valor = Valor do campo de autentica��o
	 * senha = Senha do usu�rio
	 * */
	public boolean autenticar(String aut_valor, String senha);
	
	/*
	 * Trata os dados do usu�rio e verifica se o mesmo est� autenticado como retorno true ou false
	 * usuario = Objeto do tipo Usuario
	 * */
	public boolean logar(Usuario usuario);
	
	
}
