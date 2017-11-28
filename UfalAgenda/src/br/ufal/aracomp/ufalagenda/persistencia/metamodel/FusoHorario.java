package br.ufal.aracomp.ufalagenda.persistencia.metamodel;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "fusohorario")
public class FusoHorario {
	//atributos
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nome;
	private int horaRelativa;
	
	//associacoes
	@OneToMany(mappedBy="fusoHorario", fetch=FetchType.LAZY)
	private List<Horario> horarios;
	
	//construtores
	public FusoHorario() {
		// Criado para o Hibernate
	}
	
	public FusoHorario(String nome, int horaRelativa) {
		this.nome = nome;
		this.horaRelativa = horaRelativa;
		this.horarios = new ArrayList<>();
	}
	
	public FusoHorario(int id, String nome, int horaRelativa) {
		this(nome, horaRelativa);
		this.id = id;
	}
	
	//metodos
	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public int getHoraRelativa() {
		return horaRelativa;
	}

	public List<Horario> getHorarios() {
		return horarios;
	}
	
	public void addHorario(Horario horario) {
		if(!this.horarios.contains(horario))
			this.horarios.add(horario);
	}
	
	public void removeHorario(Horario horario) {
		if(this.horarios.contains(horario))
			this.horarios.remove(horario);
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean out = false;
	
		if(obj instanceof FusoHorario) {
			if(((FusoHorario)obj).getId()==this.id)
				obj = true;
		}
		return out;
	}
}
