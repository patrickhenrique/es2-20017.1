package br.ufal.aracomp.ufalagenda.persistencia;

import java.util.List;

import br.ufal.aracomp.ufalagenda.persistencia.metamodel.EmAberto;

public class EmAbertoDAO extends DAOAcademico{
	
	/**
	 * Busca EmAberto por ID
	 * @param id ID da chave primária gerada pelo hibernate
	 * @return Um objeto do tipo EmAberto
	 */
	public EmAberto getById(final int id) {
        return entityManager.find(EmAberto.class, id);
	}
	
	/**
	 * Retorna todas as entidades do tipo EmAberto 
	 * @return Lista com todos os objetos do tipo EmAberto
	 */
	@SuppressWarnings("unchecked")
	public List<EmAberto> getAll() {
	        return entityManager.createQuery("FROM " + EmAberto.class.getName()).getResultList();
	}
	
	/**
	 * Insere EmAberto no BD
	 * @param emAberto Objeto do tipo EmAberto
	 */
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
	
	/**
	 * Atualiza EmAberto no BD
	 * @param emAberto Objeto do tipo EmAberto
	 */
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
	
	/**
	 * Remove EmAberto do BD
	 * @param emAberto Objeto do tipo EmAberto
	 */	
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

	/**
	 * Remove EmAberto utilizando sua chave primaria
	 * @param id ID da chave primária associada à EmAberto
	 */
	public void removeById(final int id) {
        try{
        	EmAberto emAberto = getById(id);
        	remove(emAberto);
        	
        }catch(Exception ex){
        	ex.printStackTrace();
        }
	}
}
