package br.ufal.aracomp.ufalagenda.operacoesAutenticacaoNotificacao;

import java.util.ArrayList;

import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Compromisso;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Notificacao;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Usuario;

public interface INotificacao {
	
	
	/**
	 * Envia uma notificacao para uma lista de usuarios
	 * @param notificao Objeto do tipo Notificacao. Notificacao a ser enviada
	 * @param usuarios Lista de objetos do tipo Usuario. Usuarios a serem notificados
	 */
	public void notificar(Notificacao notificao, ArrayList<Usuario> usuarios);
	
	
	/**
	 * Envia uma notificacao para a lista de usuarios de um compromisso
	 * @param notificacao Objeto do tipo Notificacao. Notificacao a ser enviada
	 * @param compromisso Objeto do tipo Compromisso. O compromisso contem os usuarios a serem notificados
	 */
	public void notificarCompromisso(Notificacao notificacao, Compromisso compromisso);
	
}
