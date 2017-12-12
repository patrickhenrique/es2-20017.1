package br.ufal.aracomp.ufalagenda.operacoesAutenticacaoNotificacao;

import java.util.ArrayList;

import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Agendamento;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Compromisso;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Notificacao;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Usuario;

public class NotificacaoController implements INotificacao{
	
	/**
	 * Envia uma notificacao para uma lista de usuarios
	 * @param notificao Objeto do tipo Notificacao. Notificacao a ser enviada
	 * @param usuarios Lista de objetos do tipo Usuario. Usuarios a serem notificados
	 */
	@Override
	public void notificar(Notificacao notificacao, ArrayList<Usuario> usuarios) {
		
		EmailNotificacao enoti = new EmailNotificacao();
		for(Usuario usuario:usuarios)
		{
			enoti.enviar(usuario.getEmail(), "UFAL Agenda", notificacao.getMensagem());
		}
	}
	
	/**
	 * Envia uma notificacao para a lista de usuarios de um compromisso
	 * @param notificacao Objeto do tipo Notificacao. Notificacao a ser enviada
	 * @param compromisso Objeto do tipo Compromisso. O compromisso contem os usuarios a serem notificados
	 */
	@Override
	public void notificarCompromisso(Notificacao notificacao, Compromisso compromisso) {
		EmailNotificacao enoti = new EmailNotificacao();
		String mensagem = "";
		
		for(Usuario usuario:compromisso.getConvidados())
		{
			mensagem = "Autor: " + compromisso.getAutor() + " convidou você para participar de um compromisso no Local: " + compromisso.getLocal() + " <br> " + compromisso.getDescricao(); 
			enoti.enviar(compromisso.getAutor().getEmail(), usuario.getEmail(), "UFAL Agenda Alerta de Compromisso!", mensagem);
		}
	}

}
