package springapp.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import springapp.model.Link;

/**
 * 
 * @author Frederic and Livia
 *
 */
public class LinkDAO implements ILinkDAO {

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
	 * returns the link associated to a mail address
	 * return Link link
	 */
	public Link getLink(String mail) {
		start();
		try {
			TypedQuery<Link> q = em.createQuery("FROM Link where mail = '" + mail+"'", Link.class);
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
	
	/**
	 * 
	 * return Link link
	 */
	public Link getMail(String link) {
		start();
		try {
			TypedQuery<Link> q = em.createQuery("FROM Link where link = '" + link+"'", Link.class);
			return q.getSingleResult();
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
	 * saves a link into the database
	 * return Link link
	 */
	public Link addLink(Link l) {
		start();
		try {
			tr.begin();
			em.merge(l);
			tr.commit();
			return l;
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
	 * deletes a link from the database
	 * return true if the link is successfully deleted
	 */
	public Boolean deleteLink(String mail) {
		Link l = getLink(mail);
		start();
		try {
			tr.begin();
			em.remove(l);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (em != null) {
				end();
			}
		}
		return false;
	}
}
