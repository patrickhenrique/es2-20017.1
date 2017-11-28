package br.ufal.aracomp.ufalagenda.persistencia.metamodel;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "agenda")
public class Agenda {
	//atributos
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nome;
	
	//associacoes
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_usuario", insertable=true, updatable=true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Usuario proprietario;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="agenda_eventos", joinColumns={@JoinColumn(name="id_agenda")},
	inverseJoinColumns={@JoinColumn(name="id_evento")})
	@Cascade(CascadeType.ALL)
	private List<Definido> agendamentosDefinidos;
	
	//construtores
	public Agenda() {
		// Gerado para o Hibernate
	}
	
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
