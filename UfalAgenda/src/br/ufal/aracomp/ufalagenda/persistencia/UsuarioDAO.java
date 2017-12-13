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
	
	/**
	 * Busca um Usuario pelo Login
	 * @param Login do usuario
	 * @return Um objeto do tipo Usuario
	 */
	public Usuario getByLogin(final String login) {
		List result = entityManager.createQuery("SELECT u FROM Usuario u WHERE u.login = :login")
				.setParameter("login", login)
				.getResultList();
		
		return (Usuario) result.get(0);
	}
	
	/**
	 * Busca um Usuario pelo E-mail
	 * @param Email do usuario
	 * @return Um objeto do tipo Usuario
	 */
	public Usuario getByEmail(final String email) {
		List result = entityManager.createQuery("SELECT u FROM Usuario u WHERE u.email = :email")
				.setParameter("email", email)
				.getResultList();
		
		return (Usuario) result.get(0);
	}
	
	/**
	 * Busca um Usuario pelo Facebook
	 * @param Facebook do usuario
	 * @return Um objeto do tipo Usuario
	 */
	public Usuario getByFacebook(final String facebook) {
		List result = entityManager.createQuery("SELECT u FROM Usuario u WHERE u.facebook = :facebook")
				.setParameter("facebook", facebook)
				.getResultList();
		
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
