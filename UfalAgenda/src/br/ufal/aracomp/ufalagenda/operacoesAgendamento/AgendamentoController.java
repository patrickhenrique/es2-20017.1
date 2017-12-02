package br.ufal.aracomp.ufalagenda.operacoesAgendamento;


import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import br.ufal.aracomp.ufalagenda.persistencia.IPersistencia;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Agendamento;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Compromisso;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Definido;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.EmAberto;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Horario;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Usuario;

public class AgendamentoController implements IAgendamento {

	private IPersistencia p;
	@SuppressWarnings("null")
	@Override
	public List<EmAberto> obterAgendamentos(Date inicio, Date fim, Usuario usuario) {		// TODO Auto-generated method stub
		
		EmAberto a = null;
		int i = 0;
		Date atual = new Date();
		Calendar c = Calendar.getInstance();
		
		//Lista de Eventos Em Aberto
		List<EmAberto> agendamentos = null;	
		
		c.setTime(inicio);
		c.add(Calendar.DATE, -30);
		Date data = c.getTime();
		inicio = inicio == null ? data : inicio; 
		
		
		while (a.getDataLimite().before(fim) | a.getDataLimite().before(atual)) {
			a = p.getAgendamentoById(usuario.getId());
			inicio = a.getDataInicio();
			c.setTime(inicio);
			c.add(Calendar.DATE, i);			
			
			
			if (!agendamentos.contains(a) && inicio.after(inicio)) {				
				agendamentos.add(a);
			}
			
			i++;
			
		}			
		
		if (agendamentos == null) {
			agendamentos = Collections.emptyList();
		}
		
		return agendamentos;
	}

	@Override
	public EmAberto criarAgendamento(Compromisso compromisso, Date dataLimite) {
		// TODO Auto-generated method stub
		Compromisso c = new Compromisso();
		Agendamento a = new Agendamento(c) {
		}; 
		
		
		c.setAgendamento(a);
		
		EmAberto agendamento = new EmAberto(c, dataLimite);
		
		
		//Grava no banco
		p.insert(agendamento);
		
		
		
		return agendamento;
	}

	@Override
	public boolean editarAgendamento(EmAberto agendamento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean excluirAgendamento(int idAgendamento) {
		// TODO Auto-generated method stub
		
		List<EmAberto> agendamentos = p.getAllAgendamentos();
		boolean acao = false;
		for (int i = 0; agendamentos.size() < i; i++) {
			if (agendamentos.get(i).getId() == idAgendamento) {	
				
				//exclui do banco e retorna true
				p.removeAgendaById(idAgendamento);
				acao = true;
			}
		}
		
		
		return acao;
	}

	@Override
	public boolean definirOpcoesHorarios(Usuario usuario, Compromisso compromisso, List<Horario> horarios) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean compartilharAgendamento(EmAberto agendamento, List<Usuario> usuarios) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Definido fecharAgendamento(EmAberto agendamento) throws ErroFechamentoException {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("null")
	@Override
	public List<EmAberto> verificarEventosParaFechar() {
		// TODO Auto-generated method stub
		List<EmAberto> todosEventos = p.getAllAgendamentos();
		List<EmAberto> eventosFechar = null;
		Date atual = new Date();		
		if (todosEventos.size() != 0) {
			for (int i = 0; i < todosEventos.size(); i++) {
				if (todosEventos.get(i).getDataLimite().before(atual)) {
					eventosFechar.add(i, todosEventos.get(i));
				}
			}
		}		
		
		return eventosFechar;
	}

}
