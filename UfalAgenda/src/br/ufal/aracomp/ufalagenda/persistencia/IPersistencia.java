package br.ufal.aracomp.ufalagenda.persistencia;

import java.util.List;

import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Agenda;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Compromisso;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Definido;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.EmAberto;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.FusoHorario;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Usuario;

public interface IPersistencia {
	
	//CRUD DE Agenda
	Agenda getAgendaById(int id);
	List<Agenda> getAllAgendas();
	void insert(Agenda agenda);
	void update(Agenda agenda);
	void remove(Agenda agenda);
	void removeAgendaById(int id);

	//CRUD DE Usuario
	Usuario getUsuarioById(int id);
	Usuario getUsuarioByLogin(String login);
	Usuario getUsuarioByEmail(String email);
	Usuario getUsuarioByFacebook(String facebook);
	List<Usuario> getAllUsuarios();
	void insert(Usuario usuario);
	void update(Usuario usuario);
	void remove(Usuario usuario);
	void removeUsuarioById(int id);
	
	//CRUD DE FusoHorario
	FusoHorario getFusoHorarioById(int id);
	List<FusoHorario> getAllFusosHorarios();
	void insert(FusoHorario fuso);
	void update(FusoHorario fuso);
	void remove(FusoHorario fuso);
	void removeFusoHorarioById(int id);

	//CRUD DE Agendamento Definido (Evento)
	Definido getEventoById(int id);
	List<Definido> getAllEventos();
	void insert(Definido evento);
	void update(Definido evento);
	void remove(Definido evento);
	void removeEventoById(int id);
	
	//CRUD DE Agendamento EmAberto (Agendamento)
	EmAberto getAgendamentoById(int id);
	List<EmAberto> getAllAgendamentos();
	void insert(EmAberto agendamento);
	void update(EmAberto agendamento);
	void remove(EmAberto agendamento);
	void removeAgendamentoById(int id);
	
	//CRUD DE Compromisso
	Compromisso getCompromissoById(int id);
	List<Compromisso> getAllCompromissos();
	void insert(Compromisso compromisso);
	void update(Compromisso compromisso);
	void remove(Compromisso compromisso);
	void removeCompromissoById(int id);
}
