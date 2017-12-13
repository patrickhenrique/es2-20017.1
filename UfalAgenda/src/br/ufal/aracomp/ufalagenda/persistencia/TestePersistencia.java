package br.ufal.aracomp.ufalagenda.persistencia;

import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Usuario;

public class TestePersistencia {
	public static void main(String[] args) {
		IPersistencia persist = new PersistenciaController();
		System.out.println("Instanciou.");
		
		//Usuario u = new Usuario(0, "admin", "1234", "admin@eu.com", "facebook");
		//persist.insert(u);
		
		//Usuario u = persist.getUsuarioByEmail("admin@eu.com");
		
		//Usuario u = persist.getUsuarioByFacebook("facebook");
		
		Usuario u = persist.getUsuarioByLogin("admin");
		
		System.out.println("Usuario Recuperado:");
		System.out.println(u.getLogin());
		System.out.println(u.getEmail());
		System.out.println(u.getFacebook());
	}

}
