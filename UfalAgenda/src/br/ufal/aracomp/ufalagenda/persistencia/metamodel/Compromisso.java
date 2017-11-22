package br.ufal.aracomp.ufalagenda.persistencia.metamodel;

import java.util.ArrayList;
import java.util.List;

public class Compromisso {
	//atributos
	private int id;
	private String descricao;
	private String local;
	
	//associacoes
	private Agendamento agendamento;
	private Usuario autor;
	private List<Usuario> convidados;
	
	//construtores
	public Compromisso(String descricao, String local, Agendamento agendamento, Usuario autor) {
		this.descricao = descricao;
		this.local = local;
		this.agendamento = agendamento;
		this.autor = autor;
		this.convidados = new ArrayList<>();
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
