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

	private IPersistencia p; //Associação com o IPersistência
	
	public AgendamentoController(IPersistencia p) {
		this.p = p;
	}
	
	
	@SuppressWarnings("null")
	@Override
	public List<EmAberto> obterAgendamentos(Date inicio, Date fim, Usuario usuario) {		
		
		EmAberto a = null; //Inicializa a variável para o evento em aberto
		int i = 0;
		Date atual = new Date(); //Data Atual do sistema
		Calendar c = Calendar.getInstance(); //Manipulador de datas
		
		//Lista de Eventos Em Aberto
		List<EmAberto> agendamentos = null;	//Inicializa a variável de lista de eventos em aberto
		
		c.setTime(inicio); //Seta a data Início no manipulador de datas
		c.add(Calendar.DATE, -30);  //Valor referente a 1 mês
		Date data = c.getTime(); //Obtém a data adicionada ao manipulador de datas
		
		//Se a data início não for informada, a data usada será a data atual -30 dias
		inicio = inicio == null ? data : inicio; 
		
		//Se não for informado o fim, o loop terminará com a data atual do sistema
		while (a.getDataLimite().before(fim) || a.getDataLimite().before(atual)) { 
			a = p.getAgendamentoById(usuario.getId()); //Obtém o agendamento pelo Id do usuário
			inicio = a.getDataInicio(); 
			c.setTime(inicio);
			c.add(Calendar.DATE, i); //O contador "i" acrescenta dias a data início			
			
			//Se o na lista de eventos não houver o evento passado e tiver a data superior a de início, então ele é adicionado a lista
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
		
		//Inicializa a variável com o parâmetro Compromisso informado
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
		
		boolean acao = false; //Varável de retorno do método
		try {
			p.update(agendamento); //Atualiza o evento em aberto no banco
			acao = true; //Retorna true informado que foi atualizado com êxito
		}
		catch(Exception erro) {
			System.out.println(erro.getMessage()); 
		}
		
		
		return acao;
	}

	@Override
	public boolean excluirAgendamento(int idAgendamento) {
		boolean acao = false; //Varável de retorno do método
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
	
		boolean acao = false; //Varável de retorno do método
		
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
		
		//Varável de retorno do método
		boolean acao = false;
		
		//Obtém o compromisso
		Compromisso c = agendamento.getCompromisso(); 
		 
		//Inicia o loop e Adiciona o os convidados
		for (int i = 0; i < usuarios.size(); i++) {
			c.addConvidado(usuarios.get(i));			
		}
		//Se a lista de convidados for diferente de nula, então o retorno é "true" indicando êxito
		if (c.getConvidados() != null) {
			acao = true;
		}
		
		return acao;
	}

	@SuppressWarnings("null")
	@Override
	public Definido fecharAgendamento(EmAberto agendamento) throws ErroFechamentoException {		
		
		//Obtém as opções de Horários
		List<OpcaoDeHorario> opcoesHorarios = agendamento.getOpcoesHorario(); 
		
		List<Horario> horarios = null; //Inicializa variável da lista de Horários
		
		Map<Horario, Integer> map = new TreeMap<Horario, Integer>(); //Cria um dicionário para os horários como chaves e insere um inteiro como valor
		
		//Percorre a lista de opções de horários e adiciona os horários a lista de horários
		for (int i = 0; i < opcoesHorarios.size(); i++) {
			horarios.add(opcoesHorarios.get(i).getHorarios().get(i));
			
			//Se o dicionário não contiver o horário, então o horário é adicionado com o valor zero
			if (!map.containsKey(horarios.get(i))){
		         map.put(horarios.get(i), 0);		         
			}
			//Adiciona o horário acumulado a frequência
			map.put(horarios.get(i), map.get(horarios.get(i)) + 1);
		}
		int valor = Collections.max(map.values()); //Obtém o maior inteiro do dicionário
		
		Horario h = null; //Inicializa nova variável Horário
		
		//Loop para obter as chaves e valores do dicionário
		for (Map.Entry<Horario, Integer> horarioEntry : map.entrySet()) {
			//Se o valor inteiro for igual a variável "valor" então pega a chave que é o Horário que mais aparece
			if(horarioEntry.getValue().equals(valor)) {
				h = horarioEntry.getKey(); // pega o horário que mais aparece
			}
			
		}
		
		Definido definido = h.getAgendamentoDefinido(); 
		
		return definido;
	}

	@SuppressWarnings("null")
	@Override
	public List<EmAberto> verificarEventosParaFechar() {
	
		List<EmAberto> todosEventos = p.getAllAgendamentos(); //Obtém a lista de eventos em aberto do banco
		
		List<EmAberto> eventosFechar = null; //Inicializa como nula a lista de eventos desejada
		
		Date atual = new Date(); //Data attual do sistema	
		
		//verifica se existe agendamento
		if (todosEventos.size() != 0) {
			for (int i = 0; i < todosEventos.size(); i++) {
				//Se a data limite tiver sido ultrapassada então adicione o evento na lista para fechar
				if (todosEventos.get(i).getDataLimite().before(atual)) {
					eventosFechar.add(i, todosEventos.get(i));
				}
			}
		}		
		
		return eventosFechar;
	}

}
