package br.ufal.aracomp.ufalagenda.persistencia.metamodel;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "compromisso")
public class Compromisso {
	//atributos
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String descricao;
	private String local;
	
	//associacoes
	@OneToOne(mappedBy="compromisso", fetch=FetchType.LAZY)
	private Agendamento agendamento;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_usuario", insertable=true, updatable=true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Usuario autor;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="convidados_compromissos", joinColumns={@JoinColumn(name="id_compromisso")},
	inverseJoinColumns={@JoinColumn(name="id_usuario")})
	@Cascade(CascadeType.ALL)
	private List<Usuario> convidados;
	
	private List<Convite>convidadoConvites;
	
	//construtores
	public Compromisso() {
		// Gerado para o Hibernate
	}
	
	public Compromisso(String descricao, String local, Agendamento agendamento, Usuario autor) {
		this.descricao = descricao;
		this.local = local;
		this.agendamento = agendamento;
		this.autor = autor;
		this.convidados = new ArrayList<>();
		this.convites = new ArrayList<>();
	}
	
	public Compromisso(int id, String descricao, String local, Agendamento agendamento, Usuario autor) {
		this(descricao, local, agendamento, autor);
		this.id = id;
	}
	
	//metodos
	public int getId() {
		return id;
	}
	public String getDescricao() {
		return descricao;
	}
	public String getLocal() {
		return local;
	}
	public Agendamento getAgendamento() {
		return agendamento;
	}
	public Usuario getAutor() {
		return autor;
	}
	public List<Usuario> getConvidados() {
		return convidados;
	}
	
	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}
	
	public void addConvidado(Usuario convidado) {
		if(!this.convidados.contains(convidado))
			this.convidados.add(convidado);
	}
	
	public void removeConvidado(Usuario convidado) {
		if(this.convidados.contains(convidado))
			this.convidados.remove(convidado);
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean out = false;
	
		if(obj instanceof Compromisso) {
			if(((Compromisso)obj).getId()==this.id)
				obj = true;
		}
		return out;
	}
}
