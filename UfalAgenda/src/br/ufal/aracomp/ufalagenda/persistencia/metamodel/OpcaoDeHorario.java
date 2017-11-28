package br.ufal.aracomp.ufalagenda.persistencia.metamodel;

import java.util.List;
import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "opcaodehorario")
public class OpcaoDeHorario{
	//atributos
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	//associacoes
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_usuario", insertable=true, updatable=true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Usuario usuario;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_agendamento", insertable=true, updatable=true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private EmAberto agendamentoEmAberto;
	
	@OneToMany(mappedBy="opcaoDeHorario", fetch=FetchType.LAZY)
	private List<Horario> horarios;
	
	//construtores
	public OpcaoDeHorario() {
		// Gerado para o Hibernate
	}
	
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
