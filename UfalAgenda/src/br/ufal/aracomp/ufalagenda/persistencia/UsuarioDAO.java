package br.ufal.aracomp.ufalagenda.persistencia;

import java.util.List;

import javax.persistence.Query;

import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Usuario;

public class UsuarioDAO extends IBD{
	
	/**
	 * Busca Usuario por ID
	 * @param id ID da chave primária gerada pelo hibernate
	 * @return Um objeto do tipo Usuario
	 */
	public Usuario getById(final int id) {
        return entityManager.find(Usuario.class, id);
	}
	
	//TODO:
	public Usuario getByLogin(final String login) {
		Query q = entityManager.createQuery("SELECT u FROM Usuario u WHERE login = "+login);
		List result = q.getResultList();
		
		return (Usuario) result.get(0);
	}
	
	//TODO:
	public Usuario getByEmail(final String email) {
		Query q = entityManager.createQuery("SELECT u FROM Usuario u WHERE login = "+email);
		List result = q.getResultList();
		
		return (Usuario) result.get(0);
	}
	
	//TODO:
	public Usuario getByFacebook(final String facebook) {
		Query q = entityManager.createQuery("SELECT u FROM Usuario u WHERE login = "+facebook);
		List result = q.getResultList();
		
		return (Usuario) result.get(0);
	}

	/**
	 * Retorna todas as entidades do tipo Usuario 
	 * @return Lista com todos os objetos do tipo Usuario
	 */
	@SuppressWarnings("unchecked")
	public List<Usuario> getAll() {
	        return entityManager.createQuery("FROM " + Usuario.class.getName()).getResultList();
	}
	
	/**
	 * Insere Usuario no DB
	 * @param usuario Objeto do tipo Usuario
	 */
	public void insert(Usuario usuario) {
        try{
        	entityManager.getTransaction().begin();
            entityManager.persist(usuario);
            entityManager.getTransaction().commit();
            
        }catch(Exception ex){
             ex.printStackTrace();
             entityManager.getTransaction().rollback();
        }
	}
	
	/**
	 * Atualiza Usuario no BD
	 * @param usuario Objeto do tipo Usuario
	 */
	public void update(Usuario usuario){
        try{
             entityManager.getTransaction().begin();
             entityManager.merge(usuario);
             entityManager.getTransaction().commit();
             
        }catch(Exception ex){
             ex.printStackTrace();
             entityManager.getTransaction().rollback();
        }
	}
	
	/**
	 * Remove Usuario do BD
	 * @param usuario Objeto do tipo Usuario
	 */	
	public void remove(Usuario usuario) {
        try{
             entityManager.getTransaction().begin();
             usuario = entityManager.find(Usuario.class, usuario.getId());
             entityManager.remove(usuario);
             entityManager.getTransaction().commit();
             
        }catch(Exception ex){
             ex.printStackTrace();
             entityManager.getTransaction().rollback();
        }
	}

	/**
	 * Remove Usuario utilizando sua chave primaria
	 * @param id ID da chave primária associada a Usuario
	 */
	public void removeById(final int id) {
        try{
        	Usuario usuario = getById(id);
        	remove(usuario);
        	
        }catch(Exception ex){
        	ex.printStackTrace();
        }
	}
}
