package br.ufal.aracomp.ufalagenda.persistencia;

import java.util.List;

import br.ufal.aracomp.ufalagenda.persistencia.metamodel.FusoHorario;

public class FusoHorarioDAO extends IBD{
	
	/**
	 * Busca FusoHorario por ID
	 * @param id ID da chave primária gerada pelo hibernate
	 * @return Um objeto do tipo FusoHorario
	 */
	public FusoHorario getById(final int id) {
        return entityManager.find(FusoHorario.class, id);
	}

	/**
	 * Retorna todas as entidades do tipo FusoHorario
	 * @return Lista com todos os objetos do tipo FusoHorario
	 */
	@SuppressWarnings("unchecked")
	public List<FusoHorario> getAll() {
	        return entityManager.createQuery("FROM " + FusoHorario.class.getName()).getResultList();
	}
	
	/**
	 * Insere FusoHorario no DB
	 * @param fusoHorario Objeto do tipo FusoHorario
	 */
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
	
	/**
	 * Atualiza FusoHorario no BD
	 * @param fusoHorario Objeto do tipo FusoHorario
	 */
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
	
	/**
	 * Remove FusoHorario do BD
	 * @param fusoHorario Objeto do tipo fusoHorario
	 */	
	public void remove(FusoHorario fusoHorario) {
        try{
             entityManager.getTransaction().begin();
             fusoHorario = entityManager.find(FusoHorario.class, fusoHorario.getId());
             entityManager.remove(fusoHorario);
             entityManager.getTransaction().commit();
             
        }catch(Exception ex){
             ex.printStackTrace();
             entityManager.getTransaction().rollback();
        }
	}

	/**
	 * Remove FusoHorario utilizando sua chave primaria
	 * @param id ID da chave primária associada à FusoHorario
	 */
	public void removeById(final int id) {
        try{
        	FusoHorario fusoHorario = getById(id);
        	remove(fusoHorario);
        	
        }catch(Exception ex){
        	ex.printStackTrace();
        }
	}
}
