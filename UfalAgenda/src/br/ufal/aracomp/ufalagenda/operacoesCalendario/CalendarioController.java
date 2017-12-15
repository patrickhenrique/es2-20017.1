package br.ufal.aracomp.ufalagenda.operacoesCalendario;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.ufal.aracomp.ufalagenda.persistencia.IPersistencia;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Agenda;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Agendamento;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Compromisso;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Definido;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Horario;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Usuario;

public class CalendarioController implements ICalendario {
	
	private IPersistencia bd;
	
	public CalendarioController(IPersistencia bd) {
		this.bd=bd;
	}

	@Override
	public List<Definido> acessarEventosAgenda(Date inicio, Date fim, Agenda agenda) {
		List<Definido> eventosDefinidos = agenda.getAgendamentosDefinidos();
		List<Definido> eventosDefinidosFiltrados = new ArrayList<Definido>();
		List<Horario>horario = null;
		
		for(int i=0;i<eventosDefinidos.size();i++) {
			horario=eventosDefinidos.get(i).getHorarios();
			for(int j=0;j<horario.size();j++) {
				if(fim != null && inicio!= null){
					if((horario.get(i).getDtHoraInicio().after(inicio) || horario.get(i).getDtHoraInicio().equals(inicio))  && (horario.get(i).getDtHoraFim().equals(fim) || horario.get(i).getDtHoraFim().before(fim))) {
						eventosDefinidosFiltrados.add(eventosDefinidos.get(i));
						j=horario.size();
					}
				}else if(inicio != null && fim==null ){
					if((horario.get(i).getDtHoraInicio().after(inicio) || horario.get(i).getDtHoraInicio().equals(inicio))) {
						eventosDefinidosFiltrados.add(eventosDefinidos.get(i)); 
						j=horario.size(); 
					}	
				}else {
					if(inicio == null && fim !=null){
						if((horario.get(i).getDtHoraInicio().equals(fim) || horario.get(i).getDtHoraInicio().before(fim))) {
							eventosDefinidosFiltrados.add(eventosDefinidos.get(i)); 
							j=horario.size();
						}
						
					}
				}
			}
		}
		if(eventosDefinidosFiltrados.size()==0)
			eventosDefinidosFiltrados=null;
		
		return eventosDefinidosFiltrados;
	
}

	@Override
	public Definido criarEvento(Compromisso compromisso, List<Horario> horariosDoCompromisso) {
		Agendamento agendamento = new Agendamento(compromisso){};
		compromisso.setAgendamento(agendamento);
		Horario hor = null;
		Definido definido = new Definido(compromisso);
		
		for(int i=0;i<horariosDoCompromisso.size();i++){
			hor = (horariosDoCompromisso).get(i);
			definido.addHorario(hor);
		}
		this.bd.insert(definido);
		
		return definido;
	}

	@Override
	public boolean editarEvento(Definido evento) {
		try {
			this.bd.update(evento);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean excluirEvento(int idAgendamento) {
		try {
			this.bd.removeAgendamentoById(idAgendamento);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean confirmarPresenca(Usuario usuario, Definido definido) {
		
		return false;
	}

	@Override
	public boolean compartilharEvento(Definido agendamento, List<Usuario> usuarios) {
		boolean status = true;
		Compromisso compromisso = agendamento.getCompromisso();
		Usuario usu = null;
		try{
			for (int i = 0; i < usuarios.size(); i++) {
				usu = (usuarios).get(i);
				compromisso.addConvidado(usu);
			}
		}catch(Exception e){
			status = false;
		}
		
		this.bd.update(agendamento);
		
		return status;
	
	}
}
