package springapp.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 
 * @author Frederic and Livia
 *
 */
@Entity(name="Link")
public class Link implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id()
	private String mail;
	
	@Basic(optional = false)
	@Column(name = "link", length = 50,
    nullable = false, unique = true)
	private String link;
	
	public Link(){}
	
	/**
	 * constructor
	 * @param pers
	 * @param group
	 */
	public Link(String mail, String link) {
		super();
		this.mail = mail;
		this.link = link;
	}
	
	/**
	 * returns the mail address assigned to a link
	 * @return String mail
	 */
	public String getMail() {
		return mail;
	}
	
	/**
	 * assigns a mail address to a link
	 * @param mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	/**
	 * returns the link into a String format
	 * @return String link
	 */
	public String getLink() {
		return link;
	}
	
	/**
	 * sets a link
	 */
	public void setLink(String link) {
		this.link = link;
	}
	
}
