package br.ufal.aracomp.ufalagenda.persistencia;

import java.util.List;

import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Definido;

public class DefinidoDAO extends DAOAcademico{
	
	/**
	 * Busca Definido por ID
	 * @param id ID da chave primária gerada pelo hibernate
	 * @return Um objeto do tipo Definido
	 */
	public Definido getById(final int id) {
        return entityManager.find(Definido.class, id);
	}
	
	/**
	 * Retorna todas as entidades do tipo Definido 
	 * @return Lista com todos os objetos do tipo Definido
	 */
	@SuppressWarnings("unchecked")
	public List<Definido> getAll() {
	        return entityManager.createQuery("FROM " + Definido.class.getName()).getResultList();
	}
	
	/**
	 * Insere Definido no DB
	 * @param definido Objeto do tipo Definido
	 */
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
	
	
	/**
	 * Atualiza Definido no BD
	 * @param definido Objeto do tipo Definido
	 */
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
	
	/**
	 * Remove Definido do BD
	 * @param definido Objeto do tipo Definido
	 */
	public void remove(Definido definido) {
        try{
             entityManager.getTransaction().begin();
             definido = entityManager.find(Definido.class, definido.getId());
             entityManager.remove(definido);
             entityManager.getTransaction().commit();
             
        }catch(Exception ex){
             ex.printStackTrace();
             entityManager.getTransaction().rollback();
        }
	}
	
	/**
	 * Remove Definido BD utilizando sua chave primaria
	 * @param id ID da chave primária associada a Definido
	 */
	public void removeById(final int id) {
        try{
        	Definido definido = getById(id);
        	remove(definido);
        	
        }catch(Exception ex){
        	ex.printStackTrace();
        }
	}
}
