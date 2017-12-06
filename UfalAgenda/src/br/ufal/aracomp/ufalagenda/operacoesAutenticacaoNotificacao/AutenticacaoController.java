package br.ufal.aracomp.ufalagenda.operacoesAutenticacaoNotificacao;

import java.util.ArrayList;

import br.ufal.aracomp.ufalagenda.persistencia.IPersistencia;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Usuario;

public class AutenticacaoController implements IAutenticacao{
	
	
	private IPersistencia persiste_ctl;
	
	
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
