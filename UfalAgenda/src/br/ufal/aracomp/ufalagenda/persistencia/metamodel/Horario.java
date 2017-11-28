package br.ufal.aracomp.ufalagenda.persistencia.metamodel;

import java.sql.Date;
import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "horario")
public class Horario {
	//atributos
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private Date dtHoraInicio;
	private Date dtHoraFim;
	
	//associacoes
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_opcao_horario", insertable=true, updatable=true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private OpcaoDeHorario opcaoDeHorario;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_agendamento", insertable=true, updatable=true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Definido agendamentoDefinido;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_fuso", insertable=true, updatable=true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private FusoHorario fusoHorario;
	
	//construtores
	public Horario() {
		// Gerado para o Hibernate
	}
	
	public Horario(Date dtHoraInicio, Date dtHoraFim, OpcaoDeHorario opcaoDeHorario, Definido agendamentoDefinido, FusoHorario fusoHorario) {
		this.dtHoraInicio = dtHoraInicio;
		this.dtHoraFim = dtHoraFim;
		this.opcaoDeHorario = opcaoDeHorario;
		this.agendamentoDefinido = agendamentoDefinido;
		this.fusoHorario = fusoHorario;
	}
	
	public Horario(long id, Date dtHoraInicio, Date dtHoraFim, OpcaoDeHorario opcaoDeHorario, Definido agendamentoDefinido, FusoHorario fusoHorario) {
		this(dtHoraInicio, dtHoraFim, opcaoDeHorario, agendamentoDefinido, fusoHorario);
		this.id = id;
	}
	
	//metodos
	public long getId() {
		return id;
	}
	public Date getDtHoraInicio() {
		return dtHoraInicio;
	}
	public Date getDtHoraFim() {
		return dtHoraFim;
	}
	public OpcaoDeHorario getOpcaoDeHorario() {
		return opcaoDeHorario;
	}
	public Definido getAgendamentoDefinido() {
		return agendamentoDefinido;
	}
	public FusoHorario getFusoHorario() {
		return fusoHorario;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean out = false;
	
		if(obj instanceof Horario) {
			if(((Horario)obj).getId()==this.id)
				obj = true;
		}
		return out;
	}
}
