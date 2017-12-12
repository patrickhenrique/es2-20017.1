package br.ufal.aracomp.ufalagenda.persistencia;

import java.util.List;

import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Compromisso;

public class CompromissoDAO extends IBD{
	
	/**
	 * Busca Compromisso por ID
	 * @param id ID da chave primária gerada pelo hibernate
	 * @return Um objeto do tipo Compromisso
	 */
	public Compromisso getById(final int id) {
        return entityManager.find(Compromisso.class, id);
	}
	
	/**
	 * Retorna todas as entidades do tipo Compromisso 
	 * @return Lista com todos os objetos do tipo Compromisso
	 */
	@SuppressWarnings("unchecked")
	public List<Compromisso> getAll() {
	        return entityManager.createQuery("FROM " + Compromisso.class.getName()).getResultList();
	}
	
	/**
	 * Insere Compromisso no DB
	 * @param compromisso Objeto do tipo Compromisso
	 */
	public void insert(Compromisso compromisso) {
        try{
        	entityManager.getTransaction().begin();
            entityManager.persist(compromisso);
            entityManager.getTransaction().commit();
            
        }catch(Exception ex){
             ex.printStackTrace();
             entityManager.getTransaction().rollback();
        }
	}
	
	
	/**
	 * Atualiza Compromisso no BD
	 * @param compromisso Objeto do tipo Compromisso
	 */
	public void update(Compromisso compromisso){
        try{
             entityManager.getTransaction().begin();
             entityManager.merge(compromisso);
             entityManager.getTransaction().commit();
             
        }catch(Exception ex){
             ex.printStackTrace();
             entityManager.getTransaction().rollback();
        }
	}
	
	/**
	 * Remove Compromisso do BD
	 * @param compromisso Objeto do tipo Compromisso
	 */
	public void remove(Compromisso compromisso) {
        try{
             entityManager.getTransaction().begin();
             compromisso = entityManager.find(Compromisso.class, compromisso.getId());
             entityManager.remove(compromisso);
             entityManager.getTransaction().commit();
             
        }catch(Exception ex){
             ex.printStackTrace();
             entityManager.getTransaction().rollback();
        }
	}
	
	/**
	 * Remove Compromisso BD utilizando sua chave primaria
	 * @param id ID da chave primária associada a Compromisso
	 */
	public void removeById(final int id) {
        try{
        	Compromisso compromisso = getById(id);
        	remove(compromisso);
        	
        }catch(Exception ex){
        	ex.printStackTrace();
        }
	}
}
