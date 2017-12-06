package br.ufal.aracomp.ufalagenda.persistencia.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.dialect.HSQLDialect;
import org.hibernate.service.ServiceRegistry;

import br.ufal.aracomp.ufalagenda.persistencia.metamodel.*;


@SuppressWarnings("deprecation")
public class HibernateConfig {

	private Configuration cfg;
    private SessionFactory factory;
    
    public HibernateConfig() {
    	
    	
		cfg = new Configuration();
		cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		cfg.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/agenda");
		cfg.setProperty("hibernate.connection.username", "root");
		cfg.setProperty("hibernate.connection.password", "12345");
		cfg.setProperty("hibernate.hbm2ddl.auto", "update");
		
		cfg.addAnnotatedClass(Agenda.class);
		cfg.addAnnotatedClass(Agendamento.class);
		cfg.addAnnotatedClass(Compromisso.class);
		cfg.addAnnotatedClass(Definido.class);
		cfg.addAnnotatedClass(EmAberto.class);
		cfg.addAnnotatedClass(FusoHorario.class);
		cfg.addAnnotatedClass(Horario.class);
		cfg.addAnnotatedClass(Notificacao.class);
		cfg.addAnnotatedClass(Email.class);
		cfg.addAnnotatedClass(Facebook.class);
		cfg.addAnnotatedClass(OpcaoDeHorario.class);
		cfg.addAnnotatedClass(Usuario.class);
		
	    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();

	    factory = cfg.buildSessionFactory(serviceRegistry);
	}
            
    public Session getSession() {
        //Retorna a sessão aberta
    	return this.factory.openSession();
    }
    
    public Configuration getConfiguration() {
        //Retorna a configuracao
    	return this.cfg;
    }
    
    
}