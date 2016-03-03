package springapp.manager;

import java.util.List;
import java.util.Map;

import springapp.model.Group;
import springapp.model.Link;
import springapp.model.Person;

/**
 * 
 * @author Frederic and Livia
 *
 */
public interface AnnuaireManager {
	
	 public Map<String, List<Person>> preparList();
	 public Person findPerson(Integer idP);
	 public void savePers(Person p);
	 public Person authPers (String mail, String pwd);
	 public List<Group> findAllGroups();
	 public Boolean checkMail(String mail);
	 public Link getLink(String mail);
	 public Link getMail(String link);
	 public Link addLink(Link l);
	 public Person findByMail(String mail);
	 public Boolean deleteLink(String mail);
	 public Group addGroup(Group gr);
}
