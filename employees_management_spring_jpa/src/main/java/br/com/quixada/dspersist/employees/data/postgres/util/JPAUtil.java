package br.com.quixada.dspersist.employees.data.postgres.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
  public static EntityManager getEntityManager() {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
    return factory.createEntityManager();
  }
}
