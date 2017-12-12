package br.ufal.aracomp.ufalagenda.persistencia.metamodel;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="notificacao")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo", discriminatorType=DiscriminatorType.STRING)
public abstract class Notificacao {
	//atributos
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String mensagem;
	
	//associacoes
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_agendamento", insertable=true, updatable=true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Agendamento agendamento;
	
	//construtores
	public Notificacao() {
		// Gerado para o Hibernate
	}
	
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
