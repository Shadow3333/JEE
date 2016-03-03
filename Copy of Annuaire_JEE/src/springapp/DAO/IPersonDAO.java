package springapp.DAO;

import java.util.List;

import springapp.model.Person;

/**
 * 
 * @author Frederic and Livia
 *
 */
public interface IPersonDAO {
	// récupérer les personnes
	public List<Person> findByGroup(String nameGr);

   // lire une personne
	public Person findPerson(Integer id);
	
	// modification ou ajout d'une nouvelle personne
	public void savePerson(Person p);
	   
	public Person auth(String mail, String pwd);
	
	public Boolean checkMail(String mail);
	
	public Person findByMail(String mail);
	   
	   
}
