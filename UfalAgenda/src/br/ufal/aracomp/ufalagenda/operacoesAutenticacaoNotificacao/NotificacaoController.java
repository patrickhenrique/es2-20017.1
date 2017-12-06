package br.ufal.aracomp.ufalagenda.operacoesAutenticacaoNotificacao;

import java.util.ArrayList;

import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Agendamento;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Compromisso;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Notificacao;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Usuario;

public class NotificacaoController implements INotificacao{
	
	@Override
	public void notificar(Notificacao notificao, ArrayList<Usuario> usuarios) {
		
		for(Usuario usuario:usuarios)
		{
			
		}
	}

	@Override
	public void notificarCompromisso(Notificacao notificacao, Compromisso compromisso) {
		// TODO Auto-generated method stub
		
	}

}
