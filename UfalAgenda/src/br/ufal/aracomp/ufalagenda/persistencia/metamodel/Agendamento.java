package br.ufal.aracomp.ufalagenda.persistencia.metamodel;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@MappedSuperclass
public abstract class Agendamento {
	//atributos
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	//associacoes
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_compromisso", insertable=true, updatable=true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Compromisso compromisso;
	
	@OneToMany(mappedBy="agendamento", fetch=FetchType.LAZY)
	private List<Notificacao> notificacoes;
	
	//construtores
	public Agendamento() {
		// Gerado para o Hibernate
	}
	
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
