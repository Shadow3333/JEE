package springapp.tests;

import java.text.ParseException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import springapp.model.Group;
import springapp.model.Person;

/**
 * 
 * @author Frederic and Livia
 *
 */
public class TestPerson {
	
	Person p;
	Group group;
	
	/**
	 * creates a group in order to test methods
	 * @throws ParseException
	 */
	@Before
	public void setUp() throws ParseException {
		p = new Person();
		
		group = new Group();
		group.setNameGr("groupName");
		group.yearsCreator(0000, 0001);
	}
	 
	@Test
	public void testGetIdp() {
		int idP = 42;
		p.setIdP(idP);
		Assert.assertTrue(p.getIdP() == idP);
	}
	
	@Test
	public void testSetIdp() {
		p.setIdP(42);
		Assert.assertTrue(p.getIdP() == 42);
	}
	
	@Test
	public void testGetName() {
		String name = "aaa";
		p.setName(name);
		Assert.assertTrue(p.getName().equals(name));
	}
	
	@Test
	public void testSetName() {
		p.setName("bbb");
		Assert.assertTrue(p.getName().equals("bbb"));
	}
	
	@Test
	public void testGetFirstname() {
		String firstname = "ccc";
		p.setName(firstname);
		Assert.assertTrue(p.getName().equals(firstname));
	}
	
	@Test
	public void testSetFirstname() {
		p.setFirstname("ddd");
		Assert.assertTrue(p.getFirstname().equals("ddd"));
	}
	
	@Test
	public void testGetBirth() throws ParseException {
		String birthday = "1994-02-22";
		
		p.setBirth(birthday);
		Assert.assertTrue(p.getBirth().toString().equals(birthday.toString()));
	}
	
	@Test
	public void testSetBirth() throws ParseException {
		String birthday = "1994-02-22";
	    
		p.setBirth(birthday);
		Assert.assertTrue(p.getBirth().toString().equals(birthday.toString()));
	}
	
	@Test
	public void testGetMail() {
		String mail = "aaa@hotmail.fr";
		p.setMail(mail);
		Assert.assertTrue(p.getMail().equals(mail));
	}
	
	@Test
	public void testSetMail() {
		p.setMail("aaa@hotmail.fr");
		Assert.assertTrue(p.getMail().equals("aaa@hotmail.fr"));
	}
	
	@Test
	public void testGetWeb() {
		String web = "http://www.google.com";
		p.setWeb(web);
		Assert.assertTrue(p.getWeb().equals(web));
	}
	
	@Test
	public void testSetWeb() {
		p.setWeb("ddd");
		Assert.assertTrue(p.getWeb().equals("ddd"));
	}
	
	@Test
	public void testGetGr() {
		p.setGr(group);
		Assert.assertTrue(p.getGr().equals(group));
	}
	
	@Test
	public void testSetGr() {
		p.setGr(group);
		Assert.assertTrue(p.getGr().getNameGr().equals(group.getNameGr()));
		Assert.assertTrue(p.getGr().getYears().equals(group.getYears()));
	}
	
	@Test
	public void testcopy() {
		Person pers = new Person();
		pers.setBirth("24/2/19");
		pers.setFirstname("firstname");
		pers.setGr(group);
		pers.setIdP(1);
		pers.setMail("mail@mail.fr");
		pers.setName("name");
		pers.setPwd("pwd");
		pers.setWeb("www.web.fr");
		p.copy(pers);
		Assert.assertTrue(p.getGr().equals(group));
		Assert.assertTrue(p.getBirth().equals("24/2/19"));
		Assert.assertTrue(p.getFirstname().equals("firstname"));
		Assert.assertTrue(p.getIdP().equals(1));
		Assert.assertTrue(p.getMail().equals("mail@mail.fr"));
		Assert.assertTrue(p.getName().equals("name"));
		Assert.assertTrue(p.getPwd().equals("pwd"));
		Assert.assertTrue(p.getWeb().equals("www.web.fr"));
	}
	
	@Test
	public void testReset() {
		p.setBirth("24/2/19");
		p.setFirstname("firstname");
		p.setGr(group);
		p.setIdP(1);
		p.setMail("mail@mail.fr");
		p.setName("name");
		p.setPwd("pwd");
		p.setWeb("www.web.fr");
		p.reset();
		Assert.assertTrue(p.getGr() == null);
		Assert.assertTrue(p.getBirth() == null);
		Assert.assertTrue(p.getFirstname() == null);
		Assert.assertTrue(p.getIdP() == null);
		Assert.assertTrue(p.getMail() == null);
		Assert.assertTrue(p.getName() == null);
		Assert.assertTrue(p.getPwd() == null);
		Assert.assertTrue(p.getWeb() == null);
	}
	

}
