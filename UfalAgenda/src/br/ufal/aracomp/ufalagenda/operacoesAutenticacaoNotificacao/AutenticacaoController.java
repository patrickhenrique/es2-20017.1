package br.ufal.aracomp.ufalagenda.operacoesAutenticacaoNotificacao;

import java.util.ArrayList;

import br.ufal.aracomp.ufalagenda.persistencia.IPersistencia;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Usuario;

public class AutenticacaoController implements IAutenticacao{
	
	
	private IPersistencia persiste_ctl;
	
	/**
	 * Verifica se as credenciais do usuario sao validas
	 * @param login Login do usuario
	 * @param senha Senha do usuario
	 * @return O usuario que corresponde ao login e senha informados. Null, caso contrario.
	 */
	@Override
	public Usuario autenticarLogin(String login, String senha) {
		
		Usuario usuario = persiste_ctl.getUsuarioByLogin(login);
		
		if(usuario != null)
		{
			if(usuario.validarSenha(senha))
			{
				return usuario;
			}
			
			return null;
			
		}
		
		return null;
		
	}
	
	/**
	 * Verifica se as credenciais do usuario sao validas
	 * @param email Email do usuario
	 * @param senha Senha do usuario
	 * @return O usuario que corresponde ao email e senha informados. Null, caso contrario.
	 */
	@Override
	public Usuario autenticarEmail(String email, String senha) {
		
		Usuario usuario = persiste_ctl.getUsuarioByEmail(email);
		
		if(usuario != null)
		{
			if(usuario.validarSenha(senha))
			{
				return usuario;
			}
			
			return null;
		}
		
		return null;
		
	}
	
	/**
	 * Verifica se as credenciais do usuario sao validas
	 * @param facebook Login do facebook do usuario
	 * @param senha Senha do usuario
	 * @return O usuario que corresponde ao login do facebook e senha informados. Null, caso contrario.
	 */
	@Override
	public Usuario autenticarFacebook(String facebook, String senha) {
		
		Usuario usuario = persiste_ctl.getUsuarioByFacebook(facebook);
		
		if(usuario != null)
		{
			if(usuario.validarSenha(senha))
			{
				return usuario;
			}
			
			return null;
		}
		
		return null;
	}



}
