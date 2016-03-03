package springapp.DAO;

import java.util.List;

import springapp.model.Group;

/**
 * 
 * @author Frederic and Livia
 *
 */
public interface IGroupDAO {
	// récupérer les groupes
	List<Group> findAllGroups();
	Group addGroup(Group gr);
	Group searchOrCreate(String name);
	Group searchOrCreate(String name, String years);
	Group searchOrCreate(Group gr);
	Group findGroup(String name);
}
