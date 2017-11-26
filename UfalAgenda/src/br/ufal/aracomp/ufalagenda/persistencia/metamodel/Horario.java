package br.ufal.aracomp.ufalagenda.persistencia.metamodel;

import java.sql.Date;
import javax.persistence.*;

@Entity
@Table(name = "horario")
public class Horario {
	//atributos
	@Id
	private int id;
	@Column
	private Date dtHoraInicio;
	@Column
	private Date dtHoraFim;
	
	//associacoes
	private OpcaoDeHorario opcaoDeHorario;
	private Definido agendamentoDefinido;
	private FusoHorario fusoHorario;
	
	//construtores
	public Horario(Date dtHoraInicio, Date dtHoraFim, OpcaoDeHorario opcaoDeHorario, Definido agendamentoDefinido, FusoHorario fusoHorario) {
		this.dtHoraInicio = dtHoraInicio;
		this.dtHoraFim = dtHoraFim;
		this.opcaoDeHorario = opcaoDeHorario;
		this.agendamentoDefinido = agendamentoDefinido;
		this.fusoHorario = fusoHorario;
	}
	
	public Horario(int id, Date dtHoraInicio, Date dtHoraFim, OpcaoDeHorario opcaoDeHorario, Definido agendamentoDefinido, FusoHorario fusoHorario) {
		this(dtHoraInicio, dtHoraFim, opcaoDeHorario, agendamentoDefinido, fusoHorario);
		this.id = id;
	}
	
	//metodos
	public int getId() {
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
