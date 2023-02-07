package one_to_one_bi_personadhaar.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import one_to_one_bi_personadhaar.dao.PersonDao;
import one_to_one_bi_personadhaar.dto.AadharCard;
import one_to_one_bi_personadhaar.dto.Person;

public class PersonAadharMain {

	public static void main(String[] args) {
		Person person= new Person();
		person.setId(2);
		person.setName("Kavya");
		person.setAddress("Dvg");
		person.setPhone(701980);
		
		AadharCard aadharCard= new AadharCard();
		aadharCard.setId(1002);
		aadharCard.setName("Kavyashree.A");
		aadharCard.setAddress("Davangere");
		
		
		//to build one to one relationship
		
		person.setAadharCard(aadharCard);
		aadharCard.setPerson(person);
	
//		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("vinod");
//		EntityManager entityManager= entityManagerFactory.createEntityManager();
//		EntityTransaction entityTransaction= entityManager.getTransaction();
////		entityTransaction.begin();	
////		entityManager.persist(person);
////		entityManager.persist(aadharCard);
////		entityTransaction.commit();
		
//		Person person=entityManager.find(Person.class, 1);
//		System.out.println(person);
//		AadharCard aadharCard= entityManager.find(AadharCard.class,1001);
//		System.out.println(aadharCard);
		
		PersonDao personDao= new PersonDao();
		personDao.savePerson(person);
		
	}

}
