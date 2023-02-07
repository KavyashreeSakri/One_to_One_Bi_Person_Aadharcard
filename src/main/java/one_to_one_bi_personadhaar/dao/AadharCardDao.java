package one_to_one_bi_personadhaar.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import one_to_one_bi_personadhaar.dto.AadharCard;
import one_to_one_bi_personadhaar.dto.Person;

public class AadharCardDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}
	public void saveAadharCard(AadharCard aadharCard)
	{
		EntityManager entityManager= getEntityManager();
		EntityTransaction entityTransaction= entityManager.getTransaction();
		Person person=aadharCard.getPerson();
		entityTransaction.begin();
		entityManager.persist(person);
		entityManager.persist(aadharCard);
		entityTransaction.commit();
		System.out.println("Saved successfully");
		
	}
	public void updateAadharCard(int id, AadharCard aadharCard) {
		EntityManager entityManager= getEntityManager();
		EntityTransaction entityTransaction= entityManager.getTransaction();
		AadharCard aadharCard2=entityManager.find(AadharCard.class, id);
		
		entityTransaction.begin();
		aadharCard.setId(id);
		aadharCard.setPerson(aadharCard2.getPerson());
		
		entityManager.merge(aadharCard);
		entityTransaction.commit();
		System.out.println("Updated successfully");
		
	}
	public void getdeleteAadharCard(int id) {
		EntityManager entityManager= getEntityManager();
		EntityTransaction entityTransaction= entityManager.getTransaction();
		AadharCard aadharCard2=entityManager.find(AadharCard.class, id);
		entityTransaction.begin();
		entityManager.remove(aadharCard2);
		entityTransaction.commit();
		System.out.println("Deleted successfully");

		
	}
	public void getAadharById(int id)
	{
		EntityManager entityManager= getEntityManager();
		AadharCard aadharCard2=entityManager.find(AadharCard.class, id);
		System.out.println(aadharCard2);


	}
	public void getAllAadhar()
	{
		EntityManager entityManager= getEntityManager();
		Query query= entityManager.createQuery("SELCT a FROM AadharCard a");
		List<AadharCard> aadharlist= query.getResultList();
		System.out.println(aadharlist);
	}


}
