package br.ufal.aracomp.ufalagenda.operacoesCalendario;

import java.util.Date;
import java.util.List;

import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Agenda;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Compromisso;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Definido;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Horario;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Usuario;

public class CalendarioController implements ICalendario {

	@Override
	public List<Definido> acessarEventosAgenda(Date inicio, Date fim, Agenda agenda) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Definido criarEvento(Compromisso compromisso, List<Horario> horariosDoCompromisso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean editarEvento(Definido evento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean excluirEvento(int idAgendamento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean confirmarPresenca(Usuario usuario, Definido definido) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean compartilharEvento(Definido agendamento, List<Usuario> usuarios) {
		// TODO Auto-generated method stub
		return false;
	}

}
