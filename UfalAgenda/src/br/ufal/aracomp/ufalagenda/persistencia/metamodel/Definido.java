package br.ufal.aracomp.ufalagenda.persistencia.metamodel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Definido extends Agendamento{
	//atributos
	
	//associacoes
	private List<Agenda> agendas;
	private List<Horario> horarios;
	
	//construtores
	public Definido(Compromisso compromisso) {
		super(compromisso);
		this.agendas = new ArrayList<>();
		this.horarios = new ArrayList<>();
	}
	
	public Definido(int id, Compromisso compromisso) {
		super(id, compromisso);
		this.agendas = new ArrayList<>();
		this.horarios = new ArrayList<>();
	}
	
	
	//metodos
	public List<Agenda> getAgendas() {
		return agendas;
	}
	public List<Horario> getHorarios() {
		return horarios;
	}
	
	public void addAgenda(Agenda agenda) {
		if(!this.agendas.contains(agenda))
			this.agendas.add(agenda);
	}
	
	public void addHorario(Horario horario) {
		if(!this.horarios.contains(horario))
			this.horarios.add(horario);
	}
	
	public void removeAgenda(Agenda agenda) {
		if(this.agendas.contains(agenda))
			this.agendas.remove(agenda);
	}
	
	public void removeHorario(Horario horario) {
		if(this.horarios.contains(horario))
			this.horarios.remove(horario);
	}
}
