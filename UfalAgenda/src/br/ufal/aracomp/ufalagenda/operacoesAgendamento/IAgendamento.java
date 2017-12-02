package br.ufal.aracomp.ufalagenda.operacoesAgendamento;

import java.util.Date;
import java.util.List;

import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Compromisso;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Definido;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.EmAberto;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Horario;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Usuario;

public interface IAgendamento {
	
	/**
	 * Retorna os agendamentos do usuario informado, no período informado
	 * @param inicio Data inicial do periodo. Se for null, indica qualquer inicio 
	 * @param fim Data final do periodo. Se for null, indica qualquer fim
	 * @param usuario autor ou participante do agendamento
	 * @return Lista de agendamentos EmAbertos respectiva. Caso não haja agendamentos para o usuario e periodo informados, deve ser retornada uma lista vazia
	 */
	public List <EmAberto> obterAgendamentos(Date inicio, Date fim, Usuario usuario);
	
	/**
	 * Cria um agendamento EmAberto para o commpromisso informado. O compromisso deve informar seu autor e respectivos convidados
	 * @param compromisso compromisso para o qual deve ser feito um agendamento EmAberto 
	 * @return O agendamento EmAberto realizado
	 */
	public EmAberto criarAgendamento(Compromisso compromisso, Date dataLimite);
	
	/**
	 * Altera os dados do agendamento, preservando apenas a informação do id
	 * @param agendamento agendamento com os novos dados desejados, preservando apenas o id
	 * @return true, se bem sucedido e false caso contrário
	 */
	public boolean editarAgendamento(EmAberto agendamento); 
	
	public boolean excluirAgendamento(int idAgendamento);
	
	public boolean definirOpcoesHorarios(Usuario usuario, Compromisso compromisso, List<Horario> horarios);
	
	public boolean compartilharAgendamento(EmAberto agendamento, List<Usuario> usuarios);
	
	/**
	 * Fecha um evento em aberto, definindo o melhor dia e horário para ocorrer.
	 * @param agendamento
	 * @return O evento fechado, com a definição de dia e horário realizada. Pode ser retornada a exceção ErroFechamentoException caso não tenha sido viável definir um horário. 
	 */
	public Definido fecharAgendamento(EmAberto agendamento) throws ErroFechamentoException;	

	/**
	 * Verifica todos os agendamentos em aberto e a data atual do sistema, para ver se eles devem ser fechados agora
	 * @return Lista de agendamentos em aberto que precisam ser fechados por conta do prazo
	 */
	public List<EmAberto> verificarEventosParaFechar();
}
