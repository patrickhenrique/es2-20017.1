package br.ufal.aracomp.ufalagenda.operacoesAutenticacaoNotificacao;

import java.util.ArrayList;

import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Agendamento;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Compromisso;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Notificacao;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Usuario;

public class NotificacaoController implements INotificacao{
	
	@Override
	public void notificar(Notificacao notificacao, ArrayList<Usuario> usuarios) {
		
		EmailNotificacao enoti = new EmailNotificacao();
		for(Usuario usuario:usuarios)
		{
			enoti.enviar(usuario.getEmail(), "UFAL Agenda", notificacao.getMensagem());
		}
	}

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
