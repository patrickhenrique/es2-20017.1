package br.ufal.aracomp.ufalagenda.persistencia;

import java.util.List;

import br.ufal.aracomp.ufalagenda.persistencia.metamodel.FusoHorario;

public class IPersistenciaFusoHorario extends IBD{
	
	public FusoHorario getById(final int id) {
        return entityManager.find(FusoHorario.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<FusoHorario> getAll() {
	        return entityManager.createQuery("FROM " + FusoHorario.class.getName()).getResultList();
	}
	
	public void insert(FusoHorario fusoHorario) {
        try{
        	entityManager.getTransaction().begin();
            entityManager.persist(fusoHorario);
            entityManager.getTransaction().commit();
            
        }catch(Exception ex){
             ex.printStackTrace();
             entityManager.getTransaction().rollback();
        }
	}
	
	public void update(FusoHorario fusoHorario){
        try{
             entityManager.getTransaction().begin();
             entityManager.merge(fusoHorario);
             entityManager.getTransaction().commit();
             
        }catch(Exception ex){
             ex.printStackTrace();
             entityManager.getTransaction().rollback();
        }
	}
	
	public void remove(FusoHorario fusoHorario) {
        try{
             entityManager.getTransaction().begin();
             cliente = entityManager.find(FusoHorario.class, fusoHorario.getId());
             entityManager.remove(fusoHorario);
             entityManager.getTransaction().commit();
             
        }catch(Exception ex){
             ex.printStackTrace();
             entityManager.getTransaction().rollback();
        }
	}

	public void removeById(final int id) {
        try{
        	FusoHorario fusoHorario = getById(id);
        	remove(fusoHorario);
        	
        }catch(Exception ex){
        	ex.printStackTrace();
        }
	}
}
