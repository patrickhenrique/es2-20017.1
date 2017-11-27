package br.ufal.aracomp.ufalagenda.persistencia;

import java.util.List;

import javax.persistence.*;

public class IBD {
	private static IBD instance;
    protected EntityManager entityManager;
    
    public static IBD getInstance(){
              if (instance == null){
                       instance = new IBD();
              }
              
              return instance;
    }

    protected IBD() {
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
