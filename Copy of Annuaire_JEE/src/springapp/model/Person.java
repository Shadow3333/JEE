package springapp.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Frederic and Livia
 *
 */
@Entity(name = "Person")
@Component()
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Person implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idP;
	
	@Basic(optional = false)
    @Column(name = "name", length = 200,
            nullable = false)
	private String name;
	
	@Basic(optional = false)
	@Column(name = "first_name", length = 200,
	        nullable = false)
	private String firstname;
	
	@Basic()
	@Column(name = "birth_day")
	private String birth;
	
	@Basic(optional = false)
	@Column(name = "mail", length = 200,
	        nullable = false, unique = true)
	@NotNull
	@Size(min = 1, message = "Le mail est obligatoire")
	private String mail;
	
	@Basic()
	@Column(name = "web", length = 200)
	private String web;
	
	@OneToOne
	@JoinColumn(name="nameGr")
	private Group Gr;
	
	@Basic()
	@Column(name = "pwd", length = 50)
	@NotNull
	@Size(min = 1, message = "Le password est obligatoire")
	private String pwd;
	
	public Person() {
		super();
	}
	
	/**
	 * constructor
	 * @param idP
	 * @param pwd
	 * @param name
	 * @param firstname
	 * @param mail
	 * @param gr
	 */
	public Person(int idP,String pwd, String name, String firstname, String mail, Group gr) {
		super();
		this.idP = idP;
		this.name = name;
		this.firstname = firstname;
		this.mail = mail;
		this.Gr = gr;
		this.pwd = pwd;
	}
	
	/**
	 * constructor
	 * @param idP
	 * @param pwd
	 * @param name
	 * @param firstname
	 * @param birth
	 * @param mail
	 * @param web
	 * @param gr
	 */
	public Person(int idP,String pwd, String name, String firstname, String birth, String mail, String web, Group gr) {
		super();
		this.idP = idP;
		this.name = name;
		this.firstname = firstname;
		this.birth = birth;
		this.mail = mail;
		this.web = web;
		this.Gr = gr;
		this.pwd = pwd;
	}

	/**
	 * returns the id called idP of a person
	 * @return int idP
	 */
	public Integer getIdP() {
		return idP;
	}
	
	/**
	 * sets the id of a person
	 * @param idP
	 */
	public void setIdP(int idP) {
		this.idP = idP;
	}
	
	/**
	 * returns the name of a person
	 * @return String name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * sets the name of a person
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * returns the firstname of a person
	 * @return String firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	
	/**
	 * sets the firstname of a person
	 * @param firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	/**
	 * returns the birthdate of a person
	 * @return Date birth
	 */
	public String getBirth() {
		return birth;
	}
	
	/**
	 * sets the birthdate of a person
	 * @param birth
	 */
	public void setBirth(String birth) {
		this.birth = birth;
	}
	
	/**
	 * returns the mail address of a person
	 * @return String mail
	 */
	public String getMail() {
		return mail;
	}
	
	/**
	 * sets the mail address of a person
	 * @param mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	/**
	 * returns the website of a person
	 * @return String web
	 */
	public String getWeb() {
		return web;
	}
	
	/**
	 * sets the website of a person
	 * @param web
	 */
	public void setWeb(String web) {
		this.web = web;
	}
	
	/**
	 * returns the group in which the person is
	 * @return Group Gr
	 */
	public Group getGr() {
		return Gr;
	}
	
	/**
	 * assigns a group to a person
	 * @param gr
	 */
	public void setGr(Group gr) {
		this.Gr = gr;
	}
	
	public String getPwd() {
		return pwd;
	}

	/**
	 * returns the password of a person
	 * @return String pwd
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	/**
	 * resets all information about a person in the database
	 */
	public void reset() {
		this.idP = null;
		this.name = null;
		this.firstname = null;
		this.birth = null;
		this.mail = null;
		this.web = null;
		this.Gr = null;
		this.pwd = null;
	}
	
	/**
	 * creates a copy of a person already in the database
	 */
	public void copy(Person p) {
		this.idP = p.getIdP();
		this.name = p.getName();
		this.firstname = p.getFirstname();
		this.birth = p.getBirth();
		this.mail = p.getMail();
		this.web = p.getWeb();
		this.Gr = p.getGr();
		this.pwd = p.getPwd();
	}
}
