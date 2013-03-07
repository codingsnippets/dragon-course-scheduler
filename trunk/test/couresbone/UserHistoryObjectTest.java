package couresbone;

import couresbone.Term;

import java.util.ArrayList;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.TestName;


public class UserHistoryObjectTest {
	@Rule public TestName name = new TestName();
	
	private static final String CSV_STRING = "";
	private Object uho;
	private UserHistoryObject full_uho;
	private Integer major = 1;
	private ArrayList<Boolean> avalability;
	private ArrayList<Integer> classes;
	private static Section test_nonexistSection = 
			new Section(
					555, 55, "five", 5, true, false, 
					new Timeslot(5, 5), true, 5, "bobstreet");
	
	private static Section test_existSection = 
			new Section(
					111, 11, "one", 1, false, false, 
					new Timeslot(1, 2), false, 1, "market");
	
	@SuppressWarnings("serial")
	private static ArrayList<Integer> concentration = new ArrayList<Integer>(){{
		add(111);
		add(222);
		add(333);
		add(444);
		
	}};
	
	@SuppressWarnings({ "serial", "unchecked", "rawtypes" })
	private static ArrayList<ArrayList<Boolean>> availability =
			new ArrayList<ArrayList<Boolean>>(){{
		add(
			new ArrayList()
			{{
				add(true);
				add(false);
			}}
				
			);
		add(
			new ArrayList()
			{{
				add(true);
				add(false);
			}}
					
			);
		
	}};
	
	@SuppressWarnings({"serial", "unchecked", "rawtypes" })	
	private static ArrayList<ArrayList<Section>> coursework = 
		new ArrayList<ArrayList<Section>>(){{
		add(
			new ArrayList(){{
				add( new Section(111, 11, "one", 1, false, false, 
						new Timeslot(1, 2), false, 1, "market") );
				
				add( new Section(222, 22, "two", 2, true, true, 
						new Timeslot(3, 4), true, 2, "chestnut") );
				
			}}
		
		);
		add(
			new ArrayList(){{
				add( new Section(333, 33, "three", 3, false, false, new Timeslot(1, 2), false, 3, "Spruce") );
				add( new Section(444, 44, "four", 4, true, true, new Timeslot(3, 4), true, 4, "Spring") );
					
			}}
			
		);
		
	}};
/*---------------------------------------------------------------------------
 * 			
 * 					Begin Testing.
----------------------------------------------------------------------------*/	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		
		uho = new UserHistoryObject();
		
		major = 1;
		full_uho = new UserHistoryObject(major, concentration, coursework, availability);
		
	}

	@Test
	public void testUserHistoryObject() {
		
		assertEquals("Checking default constructor: ", uho.getClass().getName(), "UserHistoryObject");
		
	}

	@Test
	public void testSetMajor()
	{
		Integer m = 2;
		
		System.out.print("Testing method " + name.getMethodName().substring(4) + "() by " +
				"setting Major to Integer: " + m + " ...");
		
		
		full_uho.setMajor(m);
		
		assertEquals("Testing setMajor()", full_uho.getMajor(), m);
		
	}
	
	@Test
	public void testAddClass() 
	{
		System.out.print("Testing method " + name.getMethodName().substring(4) + "() by " +
				"adding a Section that is not-extistant in UHO...");
		
		boolean passed = false;
		
		full_uho.addClass(Term.Fall, test_nonexistSection);
		assertTrue(full_uho.getCoursework().get(1).contains(test_nonexistSection));
		
		
	}

	@Test
	public void testRemoveClass() 
	{
		System.out.print("Testing method " + name.getMethodName().substring(4) + "() by " +
				"removing a Section that is extistant in UHO...");
		
		full_uho.removeClass(Term.Fall, test_existSection);
		assertFalse(full_uho.getCoursework().get(1).contains(test_existSection));
		
	}

	@Test
	public void testModAvail() {
		fail("Not yet implemented");
	}

	@Test
	public void testToCSV() {
		fail("Not yet implemented");
	}

}
