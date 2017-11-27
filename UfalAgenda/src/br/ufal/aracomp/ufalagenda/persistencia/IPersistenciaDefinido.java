package br.ufal.aracomp.ufalagenda.persistencia;

import java.util.List;

import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Definido;

public class IPersistenciaDefinido extends IBD{
	
	public Definido getById(final int id) {
        return entityManager.find(Definido.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Definido> getAll() {
	        return entityManager.createQuery("FROM " + Definido.class.getName()).getResultList();
	}
	
	public void insert(Definido definido) {
        try{
        	entityManager.getTransaction().begin();
            entityManager.persist(definido);
            entityManager.getTransaction().commit();
            
        }catch(Exception ex){
             ex.printStackTrace();
             entityManager.getTransaction().rollback();
        }
	}
	
	public void update(Definido definido){
        try{
             entityManager.getTransaction().begin();
             entityManager.merge(definido);
             entityManager.getTransaction().commit();
             
        }catch(Exception ex){
             ex.printStackTrace();
             entityManager.getTransaction().rollback();
        }
	}
	
	public void remove(Definido definido) {
        try{
             entityManager.getTransaction().begin();
             cliente = entityManager.find(Definido.class, definido.getId());
             entityManager.remove(definido);
             entityManager.getTransaction().commit();
             
        }catch(Exception ex){
             ex.printStackTrace();
             entityManager.getTransaction().rollback();
        }
	}

	public void removeById(final int id) {
        try{
        	Definido definido = getById(id);
        	remove(definido);
        	
        }catch(Exception ex){
        	ex.printStackTrace();
        }
	}
}
