package br.ufal.aracomp.ufalagenda.persistencia.metamodel;


public class Email extends Notificacao{
	//atributos
	
	//associacoes
	
	//construtores
	public Email(String mensagem, Agendamento agendamento) {
		super(mensagem, agendamento);
	}
		
	public Email(int id, String mensagem, Agendamento agendamento) {
		super(id, mensagem, agendamento);
	}
		
		//metodos
	
}
