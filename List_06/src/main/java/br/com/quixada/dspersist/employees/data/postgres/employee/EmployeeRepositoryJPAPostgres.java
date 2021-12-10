package br.com.quixada.dspersist.employees.data.postgres.employee;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import br.com.quixada.dspersist.employees.data.postgres.util.JPAUtil;
import br.com.quixada.dspersist.employees.domain.business.repositories.employee.IEmployeeRepository;
import br.com.quixada.dspersist.employees.domain.entities.Employee;

@Repository
@Primary
public class EmployeeRepositoryJPAPostgres implements IEmployeeRepository {

  private final List<String> uniqueKeys = new ArrayList<>(Arrays.asList("id", "registration", "cpf"));

  @Override
  public void create(Employee employee) {
    EntityManager em = JPAUtil.getEntityManager();
    em.getTransaction().begin();
    try {
      em.persist(employee);
      em.getTransaction().commit();
    } catch(Exception err) {
      em.getTransaction().rollback();
    }

  }

  @Override
  public Employee findBy(String uniqueKey, Object value) {
    if(!this.uniqueKeys.contains(uniqueKey))
      throw new RuntimeException("Invalid unique key!");
  
    try {
      EntityManager em = JPAUtil.getEntityManager();
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<Employee> cr = cb.createQuery(Employee.class);
  
      Root<Employee> root = cr.from(Employee.class);
      cr.select(root).where(cb.equal(root.get(uniqueKey), value));
      return em.createQuery(cr).getSingleResult();
    } catch(NoResultException err) {
      return null;
    }

  }

  @Override
  public List<Employee> findAll(Integer page, Integer limit) {
    EntityManager em = JPAUtil.getEntityManager();
    return em.createQuery("SELECT e FROM Employee e", Employee.class).setMaxResults(limit).setFirstResult((page - 1) * limit).getResultList();
  }

  @Override
  public void deleteBy(String uniqueKey, Object value) {
    if(!this.uniqueKeys.contains(uniqueKey))
      throw new RuntimeException("Invalid unique key!");
    
    EntityManager em = JPAUtil.getEntityManager();
    try {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaDelete<Employee> cd = cb.createCriteriaDelete(Employee.class);
  
      Root<Employee> root = cd.from(Employee.class);
      cd.where(cb.equal(root.get(uniqueKey), value));
      em.getTransaction().begin();
      em.createQuery(cd).executeUpdate();
      em.getTransaction().commit();
    } catch(Exception err) {
     em.getTransaction().rollback();
    }
   
  }

  @Override
  public void updateBy(String uniqueKey, Object valueUniqueKey, Employee employee) {
    if(!this.uniqueKeys.contains(uniqueKey))
      throw new RuntimeException("Invalid unique key!");

    EntityManager em = JPAUtil.getEntityManager();
    try {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaUpdate<Employee> cup = cb.createCriteriaUpdate(Employee.class);
      Root<Employee> root = cup.from(Employee.class);

      Field[] fields = employee.getClass().getDeclaredFields();

      for(Field field : fields) {
        field.setAccessible(true);
        cup.set(field.getName(), field.get(employee));
      }

      em.getTransaction().begin();
      cup.where(cb.equal(root.get(uniqueKey), valueUniqueKey));
      em.createQuery(cup).executeUpdate();
      em.getTransaction().commit();
    } catch(Exception err) {
      em.getTransaction().rollback();
    }
  }
  
}
