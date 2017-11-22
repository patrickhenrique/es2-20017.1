package br.ufal.aracomp.ufalagenda.persistencia.metamodel;

import java.util.List;

public class OpcaoDeHorario{
	//atributos
	private int id;
	
	//associacoes
	private Usuario usuario;
	private EmAberto agendamentoEmAberto;
	private List<Horario> horarios;
	
	//construtores
	public OpcaoDeHorario(Usuario usuario, EmAberto agendamentoEmAberto, List<Horario> horarios) {
		this.usuario = usuario;
		this.agendamentoEmAberto = agendamentoEmAberto;
		this.horarios = horarios;
	}
	
	public OpcaoDeHorario(int id, Usuario usuario, EmAberto agendamentoEmAberto, List<Horario> horarios) {
		this(usuario, agendamentoEmAberto, horarios);
		this.id = id;
	}
	
	//metodos
	public int getId() {
		return id;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public EmAberto getAgendamentoEmAberto() {
		return agendamentoEmAberto;
	}
	public List<Horario> getHorarios() {
		return horarios;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		boolean out = false;
	
		if(obj instanceof OpcaoDeHorario) {
			if(((OpcaoDeHorario)obj).getId()==this.id)
				obj = true;
		}
		return out;
	}
}
