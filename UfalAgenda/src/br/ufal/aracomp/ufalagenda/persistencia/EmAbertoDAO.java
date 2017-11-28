package br.ufal.aracomp.ufalagenda.persistencia;

import java.util.List;

import br.ufal.aracomp.ufalagenda.persistencia.metamodel.EmAberto;

public class EmAbertoDAO extends DAOAcademico{
	
	public EmAberto getById(final int id) {
        return entityManager.find(EmAberto.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<EmAberto> getAll() {
	        return entityManager.createQuery("FROM " + EmAberto.class.getName()).getResultList();
	}
	
	public void insert(EmAberto emAberto) {
        try{
        	entityManager.getTransaction().begin();
            entityManager.persist(emAberto);
            entityManager.getTransaction().commit();
            
        }catch(Exception ex){
             ex.printStackTrace();
             entityManager.getTransaction().rollback();
        }
	}
	
	public void update(EmAberto emAberto){
        try{
             entityManager.getTransaction().begin();
             entityManager.merge(emAberto);
             entityManager.getTransaction().commit();
             
        }catch(Exception ex){
             ex.printStackTrace();
             entityManager.getTransaction().rollback();
        }
	}
	
	public void remove(EmAberto emAberto) {
        try{
             entityManager.getTransaction().begin();
             emAberto = entityManager.find(EmAberto.class, emAberto.getId());
             entityManager.remove(emAberto);
             entityManager.getTransaction().commit();
             
        }catch(Exception ex){
             ex.printStackTrace();
             entityManager.getTransaction().rollback();
        }
	}

	public void removeById(final int id) {
        try{
        	EmAberto emAberto = getById(id);
        	remove(emAberto);
        	
        }catch(Exception ex){
        	ex.printStackTrace();
        }
	}
}
