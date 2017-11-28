package br.ufal.aracomp.ufalagenda.persistencia.metamodel;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("E")
public class Email extends Notificacao{
	//atributos
	
	//associacoes
	
	//construtores
	public Email() {
		super();
		// Criado para o Hibernate
	}
	
	public Email(String mensagem, Agendamento agendamento) {
		super(mensagem, agendamento);
	}
		
	public Email(int id, String mensagem, Agendamento agendamento) {
		super(id, mensagem, agendamento);
	}
		
		//metodos
	
}
