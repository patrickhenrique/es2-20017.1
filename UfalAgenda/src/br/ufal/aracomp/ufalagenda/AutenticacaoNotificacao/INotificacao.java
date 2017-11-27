package br.ufal.aracomp.ufalagenda.AutenticacaoNotificacao;

import java.util.ArrayList;

import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Compromisso;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Notificacao;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Usuario;

public interface INotificacao {
	
	/*
	 * Envia uma notifica��o para uma lista de usu�rios
	 * notifica��o = Objeto do tipo Notificacao. Notifica��o a ser enviada
	 * usuarios = Lista de objetos do tipo Usuario. Usu�rios a serem notificados
	 * */
	public void notificar(Notificacao notificao, ArrayList<Usuario> usuarios);
	
	
	/*
	 * Envia uma notifica��o para a lista de usu�rios de um compromisso
	 * notifica��o = Objeto do tipo Notificacao. Notifica��o a ser enviada
	 * Comrpomisso = Objeto do tipo Compromisso. O compromisso cont�m os usu�rios a serem notificados
	 * */
	public void notificarCompromisso(Notificacao notificacao, Compromisso compromisso);
	
}
