package br.ufal.aracomp.ufalagenda.persistencia;


import javax.persistence.*;

public class DAOAcademico {
	private static DAOAcademico instance;
    protected EntityManager entityManager;
    
    public static DAOAcademico getInstance(){
              if (instance == null){
                       instance = new DAOAcademico();
              }
              
              return instance;
    }

    protected DAOAcademico() {
              entityManager = getEntityManager();
    }
    
    //Metodo para gerar uma chamada Singleton para o Banco
    private EntityManager getEntityManager() {
              EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudHibernate"); // crudHibernate = nome da configuracao do persistence.xml
              if (entityManager == null) {
                       entityManager = factory.createEntityManager();
              }

              return entityManager;
    }
}
