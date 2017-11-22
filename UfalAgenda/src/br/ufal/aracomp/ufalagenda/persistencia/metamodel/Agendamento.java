package br.ufal.aracomp.ufalagenda.persistencia.metamodel;

import java.util.ArrayList;
import java.util.List;

public class Agendamento {
	//atributos
	private int id;
	
	//associacoes
	private Compromisso compromisso;
	private List<Notificacao> notificacoes;
	
	//construtores
	public Agendamento(Compromisso compromisso) {
		this.compromisso = compromisso;
		this.notificacoes = new ArrayList<>();
	}
	
	public Agendamento(int id, Compromisso compromisso) {
		this(compromisso);
		this.id = id;
	}
	
	//metodos
	public int getId() {
		return id;
	}
	public Compromisso getCompromisso() {
		return compromisso;
	}
	public List<Notificacao> getNotificacoes() {
		return notificacoes;
	}
	
	public void addNotificacao(Notificacao notificacao) {
		if(!this.notificacoes.contains(notificacao))
			this.notificacoes.add(notificacao);
	}
	
	public void removerNotificacao(Notificacao notificacao) {
		if(this.notificacoes.contains(notificacao))
			this.notificacoes.remove(notificacao);
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean out = false;
	
		if(obj instanceof Agendamento) {
			if(((Agendamento)obj).getId()==this.id)
				obj = true;
		}
		return out;
	}
}
