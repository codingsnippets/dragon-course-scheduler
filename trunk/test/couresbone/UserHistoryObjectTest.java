package couresbone;

import couresbone.Term;
import Filter.course_schedule;

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
	private static course_schedule test_new_course_sched = 
			new course_schedule(
					);
	
	private static course_schedule test_exist_course_sched = 
			new course_schedule();
	
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
	private static ArrayList<ArrayList<course_schedule>> coursework = 
		new ArrayList<ArrayList<course_schedule>>(){{
		add(
			new ArrayList(){{
				add( new course_schedule() );
				
				add( new course_schedule() );
				
			}}
		
		);
		add(
			new ArrayList(){{
				add( new course_schedule() 
				);
				add( new course_schedule() 
				);
					
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
		
		System.out.println("Testing constructor " + name.getMethodName().substring(4) + "()  ...");
		//System.out.println("class name: " + uho.getClass().getName());

		assertEquals("Checking default constructor: ", uho.getClass().getName(),
				"couresbone.UserHistoryObject");
		
		
	}

	@Test
	public void testSetMajor()
	{
		Integer m = 2;
		
		System.out.println("Testing method " + name.getMethodName().substring(4) + "() by " +
				"setting Major to Integer: " + m + " ...");
		
		
		full_uho.setMajor(m);
		
		assertEquals("Testing setMajor()", full_uho.getMajor(), m);
		
	}
	
	@Test
	public void testAddClass() 
	{
		System.out.println("Testing method " + name.getMethodName().substring(4) + "() by " +
				"adding a Section that is not-extistant in UHO...");
		
		boolean passed = false;
		
		full_uho.addClass(Term.Fall, test_new_course_sched);
		assertTrue(full_uho.getCoursework().get(1).contains(test_new_course_sched));
		
		
	}

	@Test
	public void testRemoveClass() 
	{
		System.out.println("Testing method " + name.getMethodName().substring(4) + "() by " +
				"removing a Section that is extistant in UHO...");
		
		full_uho.removeClass(Term.Fall, test_exist_course_sched);
		assertFalse(full_uho.getCoursework().get(1).contains(test_exist_course_sched));
		
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
