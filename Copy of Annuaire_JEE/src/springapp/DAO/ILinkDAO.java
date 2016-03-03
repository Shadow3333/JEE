package springapp.DAO;

import springapp.model.Link;

public interface ILinkDAO {
	Link getLink(String mail);
	Link addLink(Link l);
	Link getMail(String link);
	Boolean deleteLink(String mail);
}
