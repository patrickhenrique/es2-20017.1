package br.ufal.aracomp.ufalagenda.persistencia.metamodel;

import javax.persistence.*;

@Entity
@Table(name = "notificacao")
public abstract class Notificacao {
	//atributos
	@Id
	private int id;
	@Column
	private String mensagem;
	
	//associacoes
	private Agendamento agendamento;
	
	//construtores
	public Notificacao(String mensagem, Agendamento agendamento) {
		this.mensagem = mensagem;
		this.agendamento = agendamento;
	}

	public Notificacao(int id, String mensagem, Agendamento agendamento) {
		this(mensagem, agendamento);
		this.id = id;
	}
	
	//metodos
	public int getId() {
		return id;
	}

	public String getMensagem() {
		return mensagem;
	}

	public Agendamento getAgendamento() {
		return agendamento;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean out = false;
	
		if(obj instanceof Notificacao) {
			if(((Notificacao)obj).getId()==this.id)
				obj = true;
		}
		return out;
	}
}
