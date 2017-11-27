package br.ufal.aracomp.ufalagenda.persistencia.metamodel;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "agenda")
public class Agenda {
	//atributos
	@Id
	private int id;
	@Column
	private String nome;
	
	//associacoes
	private Usuario proprietario;
	private List<Definido> agendamentosDefinidos;
	
	//construtores
	public Agenda(String nome, Usuario proprietario) {
		this.nome = nome;
		this.proprietario = proprietario;
		this.agendamentosDefinidos = new ArrayList<>();
	}
	
	public Agenda(int id, String nome, Usuario proprietario) {
		this(nome, proprietario);
		this.id = id;
	}
	
	//metodos
	public int getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public Usuario getProprietario() {
		return proprietario;
	}
	public List<Definido> getAgendamentosDefinidos() {
		return agendamentosDefinidos;
	}
	
	public void addAgendamentoDefinido(Definido agendamento) {
		if(!this.agendamentosDefinidos.contains(agendamento))
			this.agendamentosDefinidos.add(agendamento);
	}
	
	public void removeAgendamentoDefinido(Definido agendamento) {
		if(this.agendamentosDefinidos.contains(agendamento))
			this.agendamentosDefinidos.remove(agendamento);
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean out = false;
	
		if(obj instanceof Agenda) {
			if(((Agenda)obj).getId()==this.id)
				obj = true;
		}
		return out;
	}
}
