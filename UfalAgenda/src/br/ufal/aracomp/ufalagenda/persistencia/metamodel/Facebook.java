package br.ufal.aracomp.ufalagenda.persistencia.metamodel;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("F")
public class Facebook extends Notificacao{
	//atributos
	
	//associacoes
	
	//construtores
	public Facebook() {
		super();
		// Criado para o Facebook
	}
	
	public Facebook(String mensagem, Agendamento agendamento) {
		super(mensagem, agendamento);
	}
	
	public Facebook(int id, String mensagem, Agendamento agendamento) {
		super(id, mensagem, agendamento);
	}
	
	//metodos
	
}
