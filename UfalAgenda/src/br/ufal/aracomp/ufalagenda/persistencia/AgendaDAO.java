package br.ufal.aracomp.ufalagenda.persistencia;

import java.util.List;

import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Agenda;

public class AgendaDAO extends DAOAcademico{
	
	public Agenda getById(final int id) {
        return entityManager.find(Agenda.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Agenda> getAll() {
	        return entityManager.createQuery("FROM " + Agenda.class.getName()).getResultList();
	}
	
	public void insert(Agenda agenda) {
        try{
        	entityManager.getTransaction().begin();
            entityManager.persist(agenda);
            entityManager.getTransaction().commit();
            
        }catch(Exception ex){
             ex.printStackTrace();
             entityManager.getTransaction().rollback();
        }
	}
	
	public void update(Agenda agenda){
        try{
             entityManager.getTransaction().begin();
             entityManager.merge(agenda);
             entityManager.getTransaction().commit();
             
        }catch(Exception ex){
             ex.printStackTrace();
             entityManager.getTransaction().rollback();
        }
	}
	
	public void remove(Agenda agenda) {
        try{
             entityManager.getTransaction().begin();
             agenda = entityManager.find(Agenda.class, agenda.getId());
             entityManager.remove(agenda);
             entityManager.getTransaction().commit();
             
        }catch(Exception ex){
             ex.printStackTrace();
             entityManager.getTransaction().rollback();
        }
	}

	public void removeById(final int id) {
        try{
        	Agenda agenda = getById(id);
        	remove(agenda);
        	
        }catch(Exception ex){
        	ex.printStackTrace();
        }
	}
}
