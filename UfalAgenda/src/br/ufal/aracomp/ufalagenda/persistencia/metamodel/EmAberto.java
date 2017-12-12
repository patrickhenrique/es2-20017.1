package br.ufal.aracomp.ufalagenda.persistencia.metamodel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "A")
public class EmAberto extends Agendamento{
	//atributos
	private Date dataLimite;
	
	//associacoes
	@OneToMany(mappedBy="agendamentoEmAberto", fetch=FetchType.LAZY)
	private List<OpcaoDeHorario> opcoesHorario;
	
	//construtores
	public EmAberto() {
		super();
		// Gerado para o Hibernate
	}
	public EmAberto(Compromisso compromisso, Date dataLimite) {
		super(compromisso);
		this.dataLimite = dataLimite;
		this.opcoesHorario = new ArrayList<>();
	}
	
	public EmAberto(int id, Compromisso compromisso, Date dataLimite) {
		super(id, compromisso);
		this.dataLimite = dataLimite;
		this.opcoesHorario = new ArrayList<>();
	}
	
	//metodos
	public Date getDataLimite() {
		return dataLimite;
	}

	public List<OpcaoDeHorario> getOpcoesHorario() {
		return opcoesHorario;
	}
	
	public void addOpcaoHorario(OpcaoDeHorario opcaoHorario) {
		if(!this.opcoesHorario.contains(opcaoHorario))
			this.opcoesHorario.add(opcaoHorario);
	}
	
	public void removeOpcaoHorario(OpcaoDeHorario opcaoHorario) {
		if(this.opcoesHorario.contains(opcaoHorario))
			this.opcoesHorario.remove(opcaoHorario);
	}
}
