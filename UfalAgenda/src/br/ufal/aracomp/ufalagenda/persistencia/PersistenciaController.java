package br.ufal.aracomp.ufalagenda.persistencia;

import java.util.List;

import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Agenda;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Compromisso;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Definido;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.EmAberto;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.FusoHorario;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Usuario;

public class PersistenciaController implements IPersistencia {
	
	private AgendaDAO agendaDAO;
	private DefinidoDAO definidoDAO;
	private EmAbertoDAO emAbertoDAO;
	private FusoHorarioDAO fusoHorarioDAO;
	private UsuarioDAO usuarioDAO;
	private CompromissoDAO compromissoDAO;
	
	public PersistenciaController() {
		agendaDAO = new AgendaDAO();
		definidoDAO = new DefinidoDAO();
		emAbertoDAO = new EmAbertoDAO();
		fusoHorarioDAO = new FusoHorarioDAO();
		usuarioDAO = new UsuarioDAO();
		compromissoDAO = new CompromissoDAO();
	}

	@Override
	/**
	 * Busca uma agenda por ID
	 * @param id ID da chave primária gerada pelo hibernate
	 * @return Um objeto do tipo Agenda
	 */
	public Agenda getAgendaById(int id) {
		return agendaDAO.getById(id);
	}

	@Override
	/**
	 * Retorna todas as entidades do tipo agenda
	 * @return Lista com todos os objetos do tipo Agenda
	 */
	public List<Agenda> getAllAgendas() {
		return agendaDAO.getAll();
	}
	
	@Override
	/**
	 * Insere uma agenda no BD
	 * @param agenda Objeto do tipo Agenda
	 */
	public void insert(Agenda agenda) {
		agendaDAO.insert(agenda);
	}
	
	@Override

	/**
	 * Atualiza uma agenda no BD
	 * @param agenda Objeto do tipo Agenda
	 */
	public void update(Agenda agenda) {
		agendaDAO.update(agenda);
	}

	@Override
	/**
	 * Remove uma agenda do BD
	 * @param agenda Objeto do tipo Agenda
	 */
	public void remove(Agenda agenda) {
		agendaDAO.remove(agenda);
	}

	@Override
	/**
	 * Remove uma agenda do BD utilizando sua chave primaria
	 * @param id ID da chave primária associada à Agenda
	 */
	public void removeAgendaById(int id) {
		agendaDAO.removeById(id);
	}

	@Override
	/**
	 * Busca um Usuario por ID
	 * @param id ID da chave primária gerada pelo hibernate
	 * @return Um objeto do tipo Usuario
	 */
	public Usuario getUsuarioById(int id) {
		return usuarioDAO.getById(id);
	}
	
	@Override
	/**
	 * Busca um Usuario pelo Login
	 * @param Login do usuario
	 * @return Um objeto do tipo Usuario
	 */
	public Usuario getUsuarioByLogin(String login) {
		return usuarioDAO.getByLogin(login);
	}
	@Override
	/**
	 * Busca um Usuario pelo E-mail
	 * @param Email do usuario
	 * @return Um objeto do tipo Usuario
	 */
	public Usuario getUsuarioByEmail(String email) {
		return usuarioDAO.getByEmail(email);
	}
	
	@Override
	/**
	 * Busca um Usuario pelo Facebook
	 * @param Facebook do usuario
	 * @return Um objeto do tipo Usuario
	 */
	public Usuario getUsuarioByFacebook(String facebook) {
		return usuarioDAO.getByFacebook(facebook);
	}

	@Override
	/**
	 * Retorna todas as entidades do tipo Usuario
	 * @return Lista com todos os objetos do tipo Usuario
	 */
	public List<Usuario> getAllUsuarios() {
		return usuarioDAO.getAll();
	}

	@Override
	/**
	 * Insere um Usuario no BD
	 * @param usuario Objeto do tipo Usuario
	 */
	public void insert(Usuario usuario) {
		usuarioDAO.insert(usuario);
	}

	@Override
	/**
	 * Atualiza um Usuario no BD
	 * @param usuario Objeto do tipo Usuario
	 */
	public void update(Usuario usuario) {
		usuarioDAO.update(usuario);
	}

	@Override
	/**
	 * Remove um Usuario do BD
	 * @param usuario Objeto do tipo Usuario
	 */
	public void remove(Usuario usuario) {
		usuarioDAO.remove(usuario);
	}

	@Override
	/**
	 * Remove um Usuario do BD utilizando sua chave primaria
	 * @param id ID da chave primária associada à Usuario
	 */
	public void removeUsuarioById(int id) {
		usuarioDAO.removeById(id);
	}

	@Override
	/**
	 * Busca um FusoHorario por ID
	 * @param id ID da chave primária gerada pelo hibernate
	 * @return Um objeto do tipo FusoHorario
	 */
	public FusoHorario getFusoHorarioById(int id) {
		return fusoHorarioDAO.getById(id);
	}

	@Override
	/**
	 * Retorna todas as entidades do tipo FusoHorario
	 * @return Lista com todos os objetos do tipo FusoHorario
	 */
	public List<FusoHorario> getAllFusosHorarios() {
		return fusoHorarioDAO.getAll();
	}

	@Override
	/**
	 * Insere um FusoHorario no BD
	 * @param fuso Objeto do tipo FusoHorario
	 */
	public void insert(FusoHorario fuso) {
		fusoHorarioDAO.insert(fuso);

	}

	@Override
	/**
	 * Atualiza um FusoHorario no BD
	 * @param fuso Objeto do tipo FusoHorario
	 */
	public void update(FusoHorario fuso) {
		fusoHorarioDAO.update(fuso);

	}

	@Override
	/**
	 * Remove um FusoHorario do BD
	 * @param fuso Objeto do tipo FusoHorario
	 */
	public void remove(FusoHorario fuso) {
		fusoHorarioDAO.remove(fuso);
	}

	@Override
	/**
	 * Remove um FusoHorario do BD utilizando sua chave primaria
	 * @param id ID da chave primária associada à FusoHorario
	 */
	public void removeFusoHorarioById(int id) {
		fusoHorarioDAO.removeById(id);

	}

	@Override
	/**
	 * Busca agendamento Definido por ID
	 * @param id ID da chave primária gerada pelo hibernate
	 * @return Um objeto do tipo Definido
	 */
	public Definido getEventoById(int id) {
		return definidoDAO.getById(id);
	}

	@Override
	/**
	 * Retorna todas as entidades do tipo Definido
	 * @return Lista com todos os objetos do tipo Definido
	 */
	public List<Definido> getAllEventos() {
		return definidoDAO.getAll();
	}

	@Override
	/**
	 * Insere um agendamento Definido no BD
	 * @param evento Objeto do tipo Definido
	 */
	public void insert(Definido evento) {
		definidoDAO.insert(evento);
	}

	@Override
	/**
	 * Atualiza um agendamento Definido no BD
	 * @param evento Objeto do tipo Definido
	 */
	public void update(Definido evento) {
		definidoDAO.update(evento);
	}

	@Override
	/**
	 * Remove um agendamento Definido no BD
	 * @param evento Objeto do tipo Definido
	 */
	public void remove(Definido evento) {
		definidoDAO.remove(evento);
	}

	@Override
	/**
	 * Remove um agendamento Definido do BD utilizando sua chave primaria
	 * @param id ID da chave primária associada à Definido
	 */
	public void removeEventoById(int id) {
		definidoDAO.removeById(id);
	}

	@Override
	/**
	 * Busca um Agendamento EmAberto por ID
	 * @param id ID da chave primária gerada pelo hibernate
	 * @return Um objeto do tipo EmAberto
	 */
	public EmAberto getAgendamentoById(int id) {
		return emAbertoDAO.getById(id);
	}

	@Override
	/**
	 * Retorna todas as entidades do tipo EmAberto
	 * @return Lista com todos os objetos do tipo EmAberto
	 */
	public List<EmAberto> getAllAgendamentos() {
		return emAbertoDAO.getAll();
	}

	@Override
	/**
	 * Insere um agendamento EmAberto no BD
	 * @param agendamento Objeto do tipo EmAberto
	 */
	public void insert(EmAberto agendamento) {
		emAbertoDAO.insert(agendamento);

	}

	@Override
	/**
	 * Atualiza um agendamento Definido no BD
	 * @param agendamento Objeto do tipo EmAberto
	 */
	public void update(EmAberto agendamento) {
		emAbertoDAO.update(agendamento);

	}

	@Override
	/**
	 * Remove um agendamento Definido no BD
	 * @param agendamento Objeto do tipo EmAberto
	 */
	public void remove(EmAberto agendamento) {
		emAbertoDAO.remove(agendamento);

	}
	
	@Override
	/**
	 * Remove um agendamento EmAberto do BD utilizando sua chave primaria
	 * @param id ID da chave primária associada à EmAberto
	 */
	public void removeAgendamentoById(int id) {
		emAbertoDAO.removeById(id);

	}

	@Override
	/**
	 * Busca um Compromisso por ID
	 * @param id ID da chave primária gerada pelo hibernate
	 * @return Um objeto do tipo Compromisso
	 */
	public Compromisso getCompromissoById(int id) {
		return compromissoDAO.getById(id);
	}

	@Override
	
	/**
	 * Retorna todas as entidades do tipo Compromisso
	 * @return Lista com todos os objetos do tipo Compromisso
	 */
	public List<Compromisso> getAllCompromissos() {
		return compromissoDAO.getAll();
	}

	@Override
	/**
	 * Insere um Compromisso no BD
	 * @param compromisso Objeto do tipo Compromisso
	 */
	public void insert(Compromisso compromisso) {
		compromissoDAO.insert(compromisso);
	}

	@Override
	/**
	 * Atualiza um Compromisso no BD
	 * @param compromisso Objeto do tipo Compromisso
	 */
	public void update(Compromisso compromisso) {
		compromissoDAO.update(compromisso);
	}

	@Override
	/**
	 * Remove um Compromisso do BD
	 * @param compromisso Objeto do tipo Compromisso
	 */
	public void remove(Compromisso compromisso) {
		compromissoDAO.remove(compromisso);
	}

	@Override
	/**
	 * Remove um Compromisso do BD utilizando sua chave primaria
	 * @param id ID da chave primária associada à Compromisso
	 */
	public void removeCompromissoById(int id) {
		compromissoDAO.removeById(id);

	}

}
