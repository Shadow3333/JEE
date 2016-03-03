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
@Entity(name="Groupe")
public class Group implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id()
	
	@Basic(optional = false)
    @Column(name = "nameGr", length = 200,
            nullable = false)
	String nameGr;
	
	@Basic()
    @Column(name = "years", length = 200)
	String years;
	
	public Group() {
		super();
	}
	
	/**
	 * constructor
	 * @param nameGr
	 */
	public Group(String nameGr) {
		super();
		this.nameGr = nameGr;
	}

	/**
	 * constructor
	 * @param nameGr
	 * @param years
	 */
	public Group(String nameGr, String years) {
		super();
		this.nameGr = nameGr;
		this.years = years;
	}

	/**
	 * returns the name of a group
	 * @return String nameGr
	 */
	public String getNameGr() {
		return nameGr;
	}
	
	/**
	 * sets the name for a group 
	 * @param nameGr
	 */
	public void setNameGr(String nameGr) {
		this.nameGr = nameGr;
	}
	
	/**
	 * returns the years of a group
	 * @return String years
	 */
	public String getYears() {
		return years;
	}
	
	/**
	 * formates the years given to the right format for the database
	 */
	public void yearsCreator(int year1, int year2) {
		this.years = Integer.toString(year1)+"/"+Integer.toString(year2);
	}

	/**
	 * sets the years for a group
	 * @param year1
	 * @param year2
	 */
	public void setYears(String years) {
		this.years = years;
	}
}
