package br.ufal.aracomp.ufalagenda.operacoesAgendamento;


import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import br.ufal.aracomp.ufalagenda.persistencia.IPersistencia;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Agendamento;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Compromisso;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Definido;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.EmAberto;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Horario;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.OpcaoDeHorario;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Usuario;

public class AgendamentoController implements IAgendamento {

	private IPersistencia p; //Associa��o com o IPersist�ncia
	
	public AgendamentoController(IPersistencia p) {
		this.p = p;
	}
	
	
	@SuppressWarnings("null")
	@Override
	public List<EmAberto> obterAgendamentos(Date inicio, Date fim, Usuario usuario) {		
		
		EmAberto a = null; //Inicializa a vari�vel para o evento em aberto
		int i = 0;
		Date atual = new Date(); //Data Atual do sistema
		Calendar c = Calendar.getInstance(); //Manipulador de datas
		
		//Lista de Eventos Em Aberto
		List<EmAberto> agendamentos = null;	//Inicializa a vari�vel de lista de eventos em aberto
		
		c.setTime(inicio); //Seta a data In�cio no manipulador de datas
		c.add(Calendar.DATE, -30);  //Valor referente a 1 m�s
		Date data = c.getTime(); //Obt�m a data adicionada ao manipulador de datas
		
		//Se a data in�cio n�o for informada, a data usada ser� a data atual -30 dias
		inicio = inicio == null ? data : inicio; 
		
		//Se n�o for informado o fim, o loop terminar� com a data atual do sistema
		while (a.getDataLimite().before(fim) || a.getDataLimite().before(atual)) { 
			a = p.getAgendamentoById(usuario.getId()); //Obt�m o agendamento pelo Id do usu�rio
			inicio = a.getDataInicio(); 
			c.setTime(inicio);
			c.add(Calendar.DATE, i); //O contador "i" acrescenta dias a data in�cio			
			
			//Se o na lista de eventos n�o houver o evento passado e tiver a data superior a de in�cio, ent�o ele � adicionado a lista
			if (!agendamentos.contains(a) && inicio.after(inicio)) {				
				agendamentos.add(a);
			}
			
			i++; //Acumulador
			
		}			
		
		//Se a lista for nula, retorna uma lista vazia
		if (agendamentos == null) {
			agendamentos = Collections.emptyList();
		}
		
		return agendamentos;
	}

	@Override
	public EmAberto criarAgendamento(Compromisso compromisso, Date dataLimite) {
		
		//Inicializa a vari�vel com o par�metro Compromisso informado
		Agendamento a = new Agendamento(compromisso) {
		}; 
		
		//Seta o agendamento no compromisso
		compromisso.setAgendamento(a);
		
		
		EmAberto agendamento = new EmAberto(compromisso, dataLimite);
		
		
		//Grava no banco
		p.insert(agendamento);
		
		
		
		return agendamento;
	}

	@Override
	public boolean editarAgendamento(EmAberto agendamento) {
		
		boolean acao = false; //Var�vel de retorno do m�todo
		try {
			p.update(agendamento); //Atualiza o evento em aberto no banco
			acao = true; //Retorna true informado que foi atualizado com �xito
		}
		catch(Exception erro) {
			System.out.println(erro.getMessage()); 
		}
		
		
		return acao;
	}

	@Override
	public boolean excluirAgendamento(int idAgendamento) {
		boolean acao = false; //Var�vel de retorno do m�todo
		try {
			p.removeAgendamentoById(idAgendamento);	//Remove o agendamento do Banco pelo Id
			acao = true;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return acao;
		
		
	}

	@Override
	public boolean definirOpcoesHorarios(Usuario usuario, Compromisso compromisso, List<Horario> horarios) {
	
		boolean acao = false; //Var�vel de retorno do m�todo
		
		EmAberto agendamento = new EmAberto(usuario.getId(), compromisso, null); 
		OpcaoDeHorario opcaoHorario = new OpcaoDeHorario(usuario, agendamento, horarios);  
		try {
			agendamento.addOpcaoHorario(opcaoHorario); 
			acao = true;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		return acao;
	}

	@Override
	public boolean compartilharAgendamento(EmAberto agendamento, List<Usuario> usuarios) {
		
		//Var�vel de retorno do m�todo
		boolean acao = false;
		
		//Obt�m o compromisso
		Compromisso c = agendamento.getCompromisso(); 
		 
		//Inicia o loop e Adiciona o os convidados
		for (int i = 0; i < usuarios.size(); i++) {
			c.addConvidado(usuarios.get(i));			
		}
		//Se a lista de convidados for diferente de nula, ent�o o retorno � "true" indicando �xito
		if (c.getConvidados() != null) {
			acao = true;
		}
		
		return acao;
	}

	@SuppressWarnings("null")
	@Override
	public Definido fecharAgendamento(EmAberto agendamento) throws ErroFechamentoException {		
		
		//Obt�m as op��es de Hor�rios
		List<OpcaoDeHorario> opcoesHorarios = agendamento.getOpcoesHorario(); 
		
		List<Horario> horarios = null; //Inicializa vari�vel da lista de Hor�rios
		
		Map<Horario, Integer> map = new TreeMap<Horario, Integer>(); //Cria um dicion�rio para os hor�rios como chaves e insere um inteiro como valor
		
		//Percorre a lista de op��es de hor�rios e adiciona os hor�rios a lista de hor�rios
		for (int i = 0; i < opcoesHorarios.size(); i++) {
			horarios.add(opcoesHorarios.get(i).getHorarios().get(i));
			
			//Se o dicion�rio n�o contiver o hor�rio, ent�o o hor�rio � adicionado com o valor zero
			if (!map.containsKey(horarios.get(i))){
		         map.put(horarios.get(i), 0);		         
			}
			//Adiciona o hor�rio acumulado a frequ�ncia
			map.put(horarios.get(i), map.get(horarios.get(i)) + 1);
		}
		int valor = Collections.max(map.values()); //Obt�m o maior inteiro do dicion�rio
		
		Horario h = null; //Inicializa nova vari�vel Hor�rio
		
		//Loop para obter as chaves e valores do dicion�rio
		for (Map.Entry<Horario, Integer> horarioEntry : map.entrySet()) {
			//Se o valor inteiro for igual a vari�vel "valor" ent�o pega a chave que � o Hor�rio que mais aparece
			if(horarioEntry.getValue().equals(valor)) {
				h = horarioEntry.getKey(); // pega o hor�rio que mais aparece
			}
			
		}
		
		Definido definido = h.getAgendamentoDefinido(); 
		
		return definido;
	}

	@SuppressWarnings("null")
	@Override
	public List<EmAberto> verificarEventosParaFechar() {
	
		List<EmAberto> todosEventos = p.getAllAgendamentos(); //Obt�m a lista de eventos em aberto do banco
		
		List<EmAberto> eventosFechar = null; //Inicializa como nula a lista de eventos desejada
		
		Date atual = new Date(); //Data attual do sistema	
		
		//verifica se existe agendamento
		if (todosEventos.size() != 0) {
			for (int i = 0; i < todosEventos.size(); i++) {
				//Se a data limite tiver sido ultrapassada ent�o adicione o evento na lista para fechar
				if (todosEventos.get(i).getDataLimite().before(atual)) {
					eventosFechar.add(i, todosEventos.get(i));
				}
			}
		}		
		
		return eventosFechar;
	}

}
