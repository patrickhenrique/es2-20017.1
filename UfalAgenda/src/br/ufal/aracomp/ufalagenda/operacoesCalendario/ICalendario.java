package br.ufal.aracomp.ufalagenda.operacoesCalendario;

import java.util.Date;
import java.util.List;

import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Agenda;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Compromisso;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Definido;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Horario;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Usuario;

public interface ICalendario {
	
	/**
	 * Retorna os eventos da agenda informada, no período informado
	 * @param inicio Data inicial do periodo. Se for null, indica qualquer inicio 
	 * @param fim Data final do periodo. Se for null, indica qualquer fim
	 * @param agenda agenda onde os eventos estão associados
	 * @return Lista de eventos Definidos respectiva. Caso não haja eventos para a agenda e periodo informados, deve ser retornada uma lista vazia
	 */
	public List <Definido> acessarEventosAgenda(Date inicio, Date fim, Agenda agenda);
	
	/**
	 * Cria um agendamento Definido para o commpromisso informado, nos horários informados. O compromisso deve informar seu autor e respectivos convidados. Deve ser informado pelo menos um horário
	 * @param compromisso compromisso para o qual deve ser feito um agendamento Definido 
	 * @return O agendamento Definido realizado
	 */
	public Definido criarEvento(Compromisso compromisso, List<Horario> horariosDoCompromisso);
	
	/**
	 * Altera os dados do evento, preservando apenas a informação do id
	 * @param evento evento com os novos dados desejados, preservando apenas o id
	 * @return true, se bem sucedido e false caso contrário
	 */
	public boolean editarEvento(Definido evento); 
	
	
	public boolean excluirEvento(int idAgendamento);
	
	public boolean confirmarPresenca(Usuario usuario, Definido definido);
	
	public boolean compartilharEvento(Definido agendamento, List<Usuario> usuarios);
	
	

}
