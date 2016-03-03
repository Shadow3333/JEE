package springapp.tests;

import java.text.ParseException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import springapp.model.Group;

/**
 * 
 * @author Frederic and Livia
 *
 */
public class TestGroup {
	Group group;
	
	/**
	 * initializes a group
	 * @throws ParseException
	 */
	@Before
	public void setUp() throws ParseException {
		group = new Group();
	}

	@Test
	public void testGetNameGr() {
		String name = "aaa";
		group.setNameGr(name);
		Assert.assertTrue(group.getNameGr().equals(name));
	}
	
	@Test
	public void testSetNameGr() {
		group.setNameGr("bbb");
		Assert.assertTrue(group.getNameGr().equals("bbb"));
	}
	
	@Test
	public void testGetYears() {
		group.setYears("2015/2016");
		Assert.assertTrue(group.getYears().equals("2015/2016"));
	}
	
	@Test
	public void testSetYears() {
		group.yearsCreator(2015, 2016);
		Assert.assertTrue(group.getYears().equals("2015/2016"));
	}
}
