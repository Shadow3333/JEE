package springapp.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import springapp.model.Person;

/**
 * 
 * @author Frederic and Livia
 *
 */
public class PersonDAO implements IPersonDAO{

	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static EntityTransaction tr;
	
	public static void start()
	{
		if (emf == null || emf.isOpen() == false) {
			emf = Persistence.createEntityManagerFactory("Annuaire");			
		}
		em = emf.createEntityManager();
		tr = em.getTransaction();
	}
	
	public static void end()
	{
		if (em != null) {
			em.close();
		}
		if (emf != null) {
			emf.close();
		}
	}
	
	/**
	 * finds a person using her group
	 */
	public List<Person> findByGroup(String nameGr) {
		
		start();
		try {
			TypedQuery<Person> q = em.createQuery("FROM Person where nameGr = '" + nameGr+"'", Person.class);
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (em != null) {
				end();
			}
		}
		end();
		return null;
	}
	
	/**
	 * finds a person by id
	 */
	public Person findPerson(Integer id) {
		start();
		try {
			return em.find(Person.class, id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (em != null) {
				end();
			}
		}
		end();
		return null;
	}

	/**
	 * saves a person in the database
	 */
	public void savePerson(Person p) {
		start();
		try {
			tr.begin();
			em.merge(p);
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (em != null) {
				end();
			}
		}
		
	}
	
	/**
	 * removes a person from the database
	 * @param p
	 */
	public void remove(Person p)
	{
		start();
		tr.begin();
		try {
			em.remove(p);
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (em != null) {
				end();
			}
		}
	}
	
	public Person auth(String mail, String pwd)
	{
		start();
		try {
			TypedQuery<Person> q = em.createQuery("SELECT P FROM Person P WHERE mail = '" + mail + 
					                     "' AND pwd = '" + pwd + "'", Person.class);
			if (q != null) {
				if (q.getResultList().isEmpty()) {
					return null;					
				}
				return q.getSingleResult();
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (em != null) {
				end();
			}
		}
		return null;
	}

	public Boolean checkMail(String mail) {
		start();
		try {
			TypedQuery<Person> q = em.createQuery("FROM Person WHERE mail = '" + mail+"'", Person.class);
			if (q != null) {
				if (q.getResultList().isEmpty()) {
					return false;					
				}
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (em != null) {
				end();
			}
		}
		return null;
	}

	public Person findByMail(String mail) {
		start();
		try {
			TypedQuery<Person> q = em.createQuery("FROM Person WHERE mail = '" + mail+"'", Person.class);
			if (q != null) {
				if (q.getResultList().isEmpty()) {
					return null;					
				}
				return q.getSingleResult();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (em != null) {
				end();
			}
		}
		return null;
	}
	
	
}
