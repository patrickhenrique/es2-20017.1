package br.ufal.aracomp.ufalagenda.persistencia;

import java.util.List;

import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Agenda;

public class AgendaDAO extends IBD{
	
	/**
	 * Busca uma agenda por ID
	 * @param id ID da chave primária gerada pelo hibernate
	 * @return Um objeto do tipo Agenda
	 */
	public Agenda getById(final int id) {
        return entityManager.find(Agenda.class, id);
	}
	
	/**
	 * Retorna todas as entidades do tipo agenda
	 * @return Lista com todos os objetos do tipo Agenda
	 */
	@SuppressWarnings("unchecked")
	public List<Agenda> getAll() {
	        return entityManager.createQuery("FROM " + Agenda.class.getName()).getResultList();
	}
	
	/**
	 * Insere uma agenda no BD
	 * @param agenda Objeto do tipo Agenda
	 */
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
	
	/**
	 * Atualiza uma agenda no BD
	 * @param agenda Objeto do tipo Agenda
	 */
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
	
	/**
	 * Remove uma agenda do BD
	 * @param agenda Objeto do tipo Agenda
	 */
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
	
	/**
	 * Remove uma agenda do BD utilizando sua chave primaria
	 * @param id ID da chave primária associada à Agenda
	 */
	public void removeById(final int id) {
        try{
        	Agenda agenda = getById(id);
        	remove(agenda);
        	
        }catch(Exception ex){
        	ex.printStackTrace();
        }
	}
}
