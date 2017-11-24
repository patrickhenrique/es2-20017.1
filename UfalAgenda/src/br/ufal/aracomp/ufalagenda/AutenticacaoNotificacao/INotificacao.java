package br.ufal.aracomp.ufalagenda.AutenticacaoNotificacao;

import java.util.ArrayList;

import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Compromisso;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Notificacao;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Usuario;

public interface INotificacao {
	
	/*
	 * Envia uma notificação para uma lista de usuários
	 * notificação = Objeto do tipo Notificacao. Notificação a ser enviada
	 * usuarios = Lista de objetos do tipo Usuario. Usuários a serem notificados
	 * */
	public void notificar(Notificacao notificao, ArrayList<Usuario> usuarios);
	
	
	/*
	 * Envia uma notificação para a lista de usuários de um compromisso
	 * notificação = Objeto do tipo Notificacao. Notificação a ser enviada
	 * Comrpomisso = Objeto do tipo Compromisso. O compromisso contém os usuários a serem notificados
	 * */
	public void notificarCompromisso(Notificacao notificacao, Compromisso compromisso);
	
}
