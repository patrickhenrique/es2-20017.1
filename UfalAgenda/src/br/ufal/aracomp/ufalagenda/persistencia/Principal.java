package br.ufal.aracomp.ufalagenda.persistencia;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Agenda;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Agendamento;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Compromisso;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Definido;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.EmAberto;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.FusoHorario;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Horario;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.OpcaoDeHorario;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Usuario;
import br.ufal.aracomp.ufalagenda.persistencia.util.HibernateConfig;

public class Principal {
	public static void main(String[] args) {
		/*
		Session s = new HibernateConfig().getSession();
		FusoHorario fusohorario1 = new FusoHorario("Maceio",2);
		
		Transaction t = s.beginTransaction();
		s.saveOrUpdate(fusohorario1);
		t.commit();
		s.close(); */
		
		Usuario usuario = new Usuario("usuario1", "1234", "usuario1@gmail.com", "fb.com/usuario1");
		
		UsuarioDAO usrbd = new UsuarioDAO();
		usrbd.insert(usuario);
		
		System.out.println(usrbd.getByLogin("usuario1"));
		
	}
	
	public static void main2(String[] args) {
		
		Date date1 = new Date(01,01,01);
		Date date2 = new Date(02,02,02);
		
		FusoHorario fusohorario1 = new FusoHorario("Maceio",2);
		FusoHorario fusohorario2 = new FusoHorario("Recife",3);
		FusoHorario fusohorario3 = new FusoHorario("Bahia",4);
		FusoHorario fusohorario4 = new FusoHorario("Sao Paulo",5);
		
		Agendamento agendamento1 = new EmAberto();
		
		AgendaDAO agendaDao = new AgendaDAO();
		EmAbertoDAO emabertoDao = new EmAbertoDAO();
		DefinidoDAO definidoDao = new DefinidoDAO();
		FusoHorarioDAO fusohorarioDao = new FusoHorarioDAO();
		UsuarioDAO usuarioDao = new UsuarioDAO();
		
		
		ArrayList<Horario> horarios = new ArrayList<Horario>(); 
		
		Usuario usuario1 = new Usuario("usuario1", "1234", "usuario1@gmail.com", "fb.com/usuario1");
		Compromisso compromisso1 = new Compromisso("teste de banco", "laboratorio", agendamento1, usuario1);
		EmAberto emaberto1 = new EmAberto(compromisso1, date1);
		Definido definido1 = new Definido(compromisso1);
		OpcaoDeHorario opcaoh2 = new OpcaoDeHorario();

		Horario horario1 = new Horario();
		Horario horario2 = new Horario();
		Horario horario3 = new Horario();
		horarios.add(horario1);
		horarios.add(horario2);
		horarios.add(horario3);
		OpcaoDeHorario opcaoh1 = new OpcaoDeHorario(usuario1, emaberto1, horarios);
		
		Agenda agenda1 = new Agenda("Agenda1", usuario1);
		
		

		ArrayList<Horario> horarios2 = new ArrayList<Horario>(); 
		
		Usuario usuario2 = new Usuario("usuario2", "12357", "usuario2@gmail.com", "fb.com/usuario2");
		Compromisso compromisso2 = new Compromisso("teste de banco 2", "laboratorio 2", agendamento1, usuario2);
		EmAberto emaberto2 = new EmAberto(compromisso2, date2);
		Definido definido2 = new Definido(compromisso2);
		OpcaoDeHorario opcaoh20 = new OpcaoDeHorario();

		Horario horario10 = new Horario();
		Horario horario20 = new Horario();
		Horario horario30 = new Horario();
		horarios.add(horario10);
		horarios.add(horario20);
		horarios.add(horario30);
		OpcaoDeHorario opcaoh10 = new OpcaoDeHorario(usuario1, emaberto1, horarios);
		
		Agenda agenda2 = new Agenda("Agenda2", usuario2);
		
		
		
		ArrayList<Horario> horarios3 = new ArrayList<Horario>(); 
		
		Usuario usuario3 = new Usuario("usuario3", "12345", "usuario3@gmail.com", "fb.com/usuario3");
		Compromisso compromisso3 = new Compromisso("teste de banco 3", "laboratorio 3", agendamento1, usuario2);
		EmAberto emaberto3 = new EmAberto(compromisso3, date2);
		Definido definido3 = new Definido(compromisso3);
		OpcaoDeHorario opcaoh22 = new OpcaoDeHorario();

		Horario horario11 = new Horario();
		Horario horario22 = new Horario();
		Horario horario33 = new Horario();
		horarios.add(horario11);
		horarios.add(horario22);
		horarios.add(horario33);
		OpcaoDeHorario opcaoh11 = new OpcaoDeHorario(usuario3, emaberto3, horarios);
		
		Agenda agenda22 = new Agenda("Agenda3", usuario3);
		
		
		
		ArrayList<Horario> horarios4 = new ArrayList<Horario>(); 
		
		Usuario usuario4 = new Usuario("usuario4", "1234567", "usuario4@gmail.com", "fb.com/usuario4");
		Compromisso compromisso4 = new Compromisso("teste de banco 4", "laboratorio 4", agendamento1, usuario4);
		EmAberto emaberto4 = new EmAberto(compromisso4, date2);
		Definido definido4 = new Definido(compromisso4);
		OpcaoDeHorario opcaoh24 = new OpcaoDeHorario();

		Horario horario14 = new Horario();
		Horario horario24 = new Horario();
		Horario horario34 = new Horario();
		horarios.add(horario14);
		horarios.add(horario24);
		horarios.add(horario34);
		OpcaoDeHorario opcaoh14 = new OpcaoDeHorario(usuario4, emaberto4, horarios);
		
		Agenda agenda24 = new Agenda("Agenda4", usuario4);
		
		agendaDao.insert(agenda1);
		agendaDao.insert(agenda2);
		agendaDao.insert(agenda22);
		agendaDao.insert(agenda24);
		
		emabertoDao.insert(emaberto1);
		emabertoDao.insert(emaberto2);
		emabertoDao.insert(emaberto3);
		emabertoDao.insert(emaberto4);
		
		definidoDao.insert(definido1);
		definidoDao.insert(definido2);
		definidoDao.insert(definido3);
		definidoDao.insert(definido4);
		
		fusohorarioDao.insert(fusohorario1);
		fusohorarioDao.insert(fusohorario2);
		fusohorarioDao.insert(fusohorario3);
		fusohorarioDao.insert(fusohorario4);
		
		usuarioDao.insert(usuario1);
		usuarioDao.insert(usuario2);
		usuarioDao.insert(usuario3);
		usuarioDao.insert(usuario4);
	}
}
