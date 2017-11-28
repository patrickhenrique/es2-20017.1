package br.ufal.aracomp.ufalagenda.persistencia;

import java.util.List;

import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Usuario;

public class UsuarioDAO extends DAOAcademico{
	
	public Usuario getById(final int id) {
        return entityManager.find(Usuario.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> getAll() {
	        return entityManager.createQuery("FROM " + Usuario.class.getName()).getResultList();
	}
	
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

	public void removeById(final int id) {
        try{
        	Usuario usuario = getById(id);
        	remove(usuario);
        	
        }catch(Exception ex){
        	ex.printStackTrace();
        }
	}
}
