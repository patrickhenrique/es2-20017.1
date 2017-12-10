package br.ufal.aracomp.ufalagenda.operacoesAutenticacaoNotificacao;

import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Usuario;

public interface IAutenticacao {
	
	/**
	 * Verifica se as credenciais do usuario sao validas
	 * @param email Email do usuario
	 * @param senha Senha do usuario
	 * @return O usuario que corresponde ao login e senha informados. Null, caso contrario.
	 */
	public Usuario autenticarLogin(String email, String senha);
}

