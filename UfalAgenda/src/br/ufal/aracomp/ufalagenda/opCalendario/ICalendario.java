package br.ufal.aracomp.ufalagenda.opCalendario;

import java.util.Date;
import java.util.List;

import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Agenda;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Agendamento;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Definido;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Usuario;

public interface ICalendario {
	
	public List <Agendamento> acessarCalendario(Date inicio, Date fim, Agenda agenda);
	
	public boolean criarEvento(Definido definido);
	
	public boolean editarEvento(Definido agendamento); 
	
	public boolean excluirEvento(int idAgendamento);
	
	public boolean confirmarPresenca(Usuario usuario, Definido definido);
	
	public boolean compartilharEvento(Agendamento agendamento, List<Usuario> usuarios);
	
	

}
