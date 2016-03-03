package springapp.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import springapp.DAO.GroupDAO;
import springapp.DAO.IGroupDAO;
import springapp.DAO.ILinkDAO;
import springapp.DAO.IPersonDAO;
import springapp.DAO.LinkDAO;
import springapp.DAO.PersonDAO;
import springapp.model.Group;
import springapp.model.Link;
import springapp.model.Person;

/**
 * 
 * @author Frederic and Livia
 *
 */
@Service("AnnuaireManager")
public class InMemoryAnnuaire implements AnnuaireManager {

	final IGroupDAO DAO_gp;
	final IPersonDAO DAO_pers;
	final ILinkDAO DAO_link;
	int cpt = 0;
	
    int maxId = 0;

    /**
     * constructor
     */
    public InMemoryAnnuaire() {
    	DAO_gp = new GroupDAO();
    	DAO_pers = new PersonDAO();
    	DAO_link = new LinkDAO();
        maxId = 300;
    }
    
    /**
     * creates a group with two associated people
     * @param gp
     */
    public void createGp(String gp)
    {
    	Person p = new Person();
		p.setFirstname("p"+cpt);								
		p.setName("p"+cpt);
		p.setMail("p"+cpt+"@rien.truc");
		p.setWeb("p"+cpt+".fr");
		p.setPwd("p"+cpt);
		cpt++;
		
		Person p2 = new Person();
		p2.setFirstname("p"+cpt);								
		p2.setName("p"+cpt);
		p2.setMail("p"+cpt+"@rien.truc");
		p2.setPwd("p"+cpt);
		cpt++;
		
		Group g = new Group();
		g.setNameGr(gp);
		g.yearsCreator(2015, 2016);
		p.setGr(g);
		p2.setGr(g);
		
		DAO_gp.searchOrCreate(g);
		
		DAO_pers.savePerson(p);
		DAO_pers.savePerson(p2);
    }
    
    /**
     * prepares a list of people
     * return Map map
     */
    public Map<String, List<Person>> preparList()
    {
    	Map<String, List<Person>> map = new HashMap<String, List<Person>>();
    	List<Group> listGr = DAO_gp.findAllGroups();
    	if (listGr.isEmpty()) {
			return null;
		}
    	
    	for (Group group : listGr) {
    		map.put(group.getNameGr(), DAO_pers.findByGroup(group.getNameGr()));
		}
    	
    	return map;
    }
    
    /**
     * finds all groups
     */
    public List<Group> findAllGroups()
    {
    	return DAO_gp.findAllGroups();
    }

    /**
     * finds a person by id
     */
    public Person findPerson(Integer idP) {
		return DAO_pers.findPerson(idP);
	}
    
    /**
     * saves a Person bean in the database
     */
    public void savePers(Person p) {
		DAO_pers.savePerson(p);
	}

    /**
     * 
     */
	public Person authPers(String mail, String pwd) {
		return DAO_pers.auth(mail, pwd);
	}
	
	/**
	 * checks the mail address
	 */
	public Boolean checkMail(String mail) {
		return DAO_pers.checkMail(mail);
	}
	
	/**
	 * returns the link associated to a mail address
	 * return Link link
	 */
	public Link getLink(String mail) {
		return DAO_link.getLink(mail);
	}
	
	/**
	 * 
	 */
	public Link getMail(String link) {
		return DAO_link.getMail(link);
	}
	
	/**
	 * saves a link into the database
	 * return Link link
	 */
	public Link addLink(Link l) {
		return DAO_link.addLink(l);
	}
	
	/**
	 * finds the person associated to a mail address
	 * return Person person
	 */
	public Person findByMail(String mail) {
		return DAO_pers.findByMail(mail);
	}
	
	/**
	 * deletes a link into the database
	 * return true if the link was successfully deleted, false otherwise
	 */
	public Boolean deleteLink(String mail) {
		return DAO_link.deleteLink(mail);
	}
	
	/**
	 * saves a group into the database
	 * return Group group
	 */
	public Group addGroup(Group gr) {
		return DAO_gp.addGroup(gr);
	}

	public List<Person> findByGroup(String nameGr) {
		return DAO_pers.findByGroup(nameGr);
	}
}
