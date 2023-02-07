package one_to_one_bi_personadhaar.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import one_to_one_bi_personadhaar.dto.AadharCard;
import one_to_one_bi_personadhaar.dto.Person;

public class PersonDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void savePerson(Person person) {
		EntityManager entityManager = getEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();

		entityManager.persist(person);
		entityTransaction.commit();
		System.out.println("Saved successfully");
	}

	public void updatePerson(int id, Person person) {
		EntityManager entityManager = getEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();

		Person newperson = entityManager.find(Person.class, id);
		entityTransaction.begin();

		person.setId(id);
		person.setAadharCard(newperson.getAadharCard());
		entityManager.merge(person);
		entityTransaction.commit();
		System.out.println("updated successfully");

	}

	public void deletePerson(int id) {
		EntityManager entityManager = getEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();

		Person person = entityManager.find(Person.class, id);
		entityTransaction.begin();
		entityManager.remove(person);
		entityTransaction.commit();
		System.out.println("Deleted successfully");
	}

	public void getById(int id) {
		EntityManager entityManager = getEntityManager();

		Person person = entityManager.find(Person.class, id);
		System.out.println(person);

	}

	public void getAllPerson() {
		EntityManager entityManager = getEntityManager();

		Query query = entityManager.createQuery("SELECT p from Person p");

		List<Person> personlist = query.getResultList();
		System.out.println(personlist);

	}
}
