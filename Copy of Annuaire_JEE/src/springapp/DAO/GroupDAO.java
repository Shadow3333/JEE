package springapp.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import springapp.model.Group;

/**
 * 
 * @author Frederic and Livia
 *
 */
public class GroupDAO implements IGroupDAO{

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
	 * lists all the groups
	 */
	public List<Group> findAllGroups() {
		start();
		tr.begin();
		try {
			TypedQuery<Group> q = em.createQuery("FROM Groupe", Group.class);
			return q.getResultList();
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
	
	/**
	 * saves a new group in the database
	 */
	public Group addGroup(Group gr)
	{
		start();
		tr.begin();
		try {
			em.persist(gr);
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (em != null) {
				end();
			}
		}
		return gr;
	}
	
	/**
	 * finds a group using its name
	 */
	public Group findGroup(String name) {
		start();
		Group gr = null;
		try {
			gr = em.find(Group.class, name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (em != null) {
				end();
			}
		}
		return gr;
	}
	
	/**
	 * looks for a group by name and if there is no result found, creates it
	 * return Group group
	 */
	public Group searchOrCreate(String name) {
		return searchOrCreate(name, null);
	}
	
	/**
	 * looks for a group by name and years and if there is no result found, creates it
	 * return Group found or Group gr
	 */
	public Group searchOrCreate(String name, String years) {
		Group found = findGroup(name);
		if (found == null) {
			Group gr;
			if (years == null) {
				gr = new Group(name);
			}
			else
				gr = new Group(name, years);
			return addGroup(gr);
		}
		return found;
	}
	
	/**
	 * looks for an already existing group and creates it if it doesn't exists
	 */
	public Group searchOrCreate(Group gr) {
		return searchOrCreate(gr.getNameGr());
	}

	
}
