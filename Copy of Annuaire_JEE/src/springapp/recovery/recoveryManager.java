package springapp.recovery;

import springapp.mailer.Mailer;
import springapp.mailer.MailerSTMP;
import springapp.manager.AnnuaireManager;
import springapp.manager.InMemoryAnnuaire;
import springapp.model.Link;

/**
 * 
 * @author Frederic and Livia
 *
 */
public class recoveryManager {
	private static recoveryManager rM;
	private Mailer m;
	private AnnuaireManager manager;
	
	/**
	 * constructor
	 */
	private recoveryManager() {
		manager = new InMemoryAnnuaire();
		m = new MailerSTMP();
	}
	
	public static recoveryManager init() {
		if (rM == null) {
			rM = new recoveryManager();
		}
		return rM;
	}
	
	/**
	 * resets the password associated to the person with the given mail address
	 * @return String
	 */
	public String resetPwd(String mail) {
		return listAdd(mail);
	}
	
	/**
	 * checks the validity of a link
	 * @return Boolean true if the link is the good one
	 */
	public Boolean checkLink(String mail, String link) {
		Link l = manager.getLink(mail);
		if (l.getLink().equals(link)) {
			return true;
		}
		return false;
	}
	
	/**
	 * returns the mail address associated to a link
	 * @return Strin mail
	 */
	public String getMail(String link) {
		Link l = manager.getMail(link);
		if (l == null) {
			return null;
		}
		return l.getMail();
	}
	
	/**
	 * adds a mail address to a list
	 * @return String link
	 */
	private String listAdd(String mail) {
		Link l = manager.getLink(mail);
		if (l == null) {
			l = new Link();
			l.setMail(mail);
			l.setLink(linkCreator(10));
			l = manager.addLink(l);
		}
		m.sendmail(mail, "To recover your password, go to http://localhost:8080/JEE/goto/Annuaire/newPassword?link="+l.getLink());
		return l.getLink();
	}
	
	/**
	 * creates a link to the good format
	 * @return String link
	 */
	private String linkCreator(int length) {
		    String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		    String link = "";
		    for(int x=0;x<length;x++)
		    {
		       int i = (int)Math.floor(Math.random() * 62);
		       link += chars.charAt(i);
		    }
		    System.out.println(link);
		    return link;
	}
	
	/**
	 * deletes a link in the database
	 * @return true if the link is successfully deleted
	 */
	public Boolean deleteLink(String mail) {
		return manager.deleteLink(mail);
	}
}
