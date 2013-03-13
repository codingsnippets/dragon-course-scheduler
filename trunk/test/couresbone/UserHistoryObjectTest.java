package couresbone;

import junitx.util.PrivateAccessor;

import java.lang.reflect.Method;
import java.util.ArrayList;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.TestName;

import couresbone.Term;

public class UserHistoryObjectTest {
	@Rule public TestName name = new TestName();
	
	private static final String CSV_STRING = "";
	private Object uho;
	private UserHistoryObject full_uho;
	private Integer major = 1;
	private ArrayList<Boolean> avalability;
	private ArrayList<Integer> classes;
	
/*-----------------------------------------------------------------
 * 			
 * 					Begin Testing.
----------------------------------------------------------------------------*/	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		
		uho = new UserHistoryObject();
		
		Integer mj = 2;;
		full_uho = new UserHistoryObject();

		
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
	public void testAddClass() throws Throwable
	{
		System.out.println("Testing method " + name.getMethodName().substring(4) + "() by.. ");
		System.out.println("\t" + "adding a new course_schedule to the UHO...");
	
		Integer majorCode = 2;
		
		final schedule test_new_sched =  new schedule(){{
			
			PrivateAccessor.setField(	schedule.class, "CRN",				new Integer(11111)	);
			PrivateAccessor.setField(	schedule.class, "Subject", 			new String("") 		);
			PrivateAccessor.setField(	schedule.class, "Course_no",		new Integer(11111)	);
			PrivateAccessor.setField(	schedule.class, "Term", 			new String("")		);
			PrivateAccessor.setField(	schedule.class, "Section", 			new Integer(11111)	);
			PrivateAccessor.setField(	schedule.class, "Instructor_type", 	new String("")		);
			PrivateAccessor.setField(	schedule.class, "Instructor", 		new String("")		);
			PrivateAccessor.setField(	schedule.class, "Location", 		new String("")		);
			PrivateAccessor.setField(	schedule.class, "Weekday", 			new String("")		);
			PrivateAccessor.setField(	schedule.class, "Start_time", 		new String("")		);
			PrivateAccessor.setField(	schedule.class, "End_time", 		new String("")		);
			PrivateAccessor.setField(	schedule.class, "Start_block", 		new Integer(11111)	);
			PrivateAccessor.setField(	schedule.class, "End_block", 		new Integer(11111)	);
			PrivateAccessor.setField(	schedule.class, "coursename", 		new Integer(11111)	);
		
		}};
		
		final schedule test_exist_sched = new schedule(){{
			
			PrivateAccessor.setField(	schedule.class, "CRN",				new Integer(11111)	);
			PrivateAccessor.setField(	schedule.class, "Subject", 			new String("") 		);
			PrivateAccessor.setField(	schedule.class, "Course_no",		new Integer(11111)	);
			PrivateAccessor.setField(	schedule.class, "Term", 			new String("")		);
			PrivateAccessor.setField(	schedule.class, "Section", 			new Integer(11111)	);
			PrivateAccessor.setField(	schedule.class, "Instructor_type", 	new String("")		);
			PrivateAccessor.setField(	schedule.class, "Instructor", 		new String("")		);
			PrivateAccessor.setField(	schedule.class, "Location", 		new String("")		);
			PrivateAccessor.setField(	schedule.class, "Weekday", 			new String("")		);
			PrivateAccessor.setField(	schedule.class, "Start_time", 		new String("")		);
			PrivateAccessor.setField(	schedule.class, "End_time", 		new String("")		);
			PrivateAccessor.setField(	schedule.class, "Start_block", 		new Integer(11111)	);
			PrivateAccessor.setField(	schedule.class, "End_block", 		new Integer(11111)	);
			PrivateAccessor.setField(	schedule.class, "coursename", 		new Integer(11111)	);
			
		}};
		
		ArrayList<Integer> concentration = new ArrayList<Integer>(){{
			add(111);
			add(222);
			add(333);
			add(444);
			
		}};
		
		ArrayList<ArrayList<schedule>> coursework = 
				new ArrayList<ArrayList<schedule>>(){{
				add(
					new ArrayList(){{
						add( test_exist_sched );
						
						add( test_exist_sched );
						
					}}
				
				);
				add(
					new ArrayList(){{
						add( test_exist_sched 
						);
						add( test_exist_sched 
						);
							
					}}
					
				);
				
			}};
		
		ArrayList<ArrayList<Boolean>> availability =
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
		
		full_uho = new UserHistoryObject(majorCode, concentration, 
				coursework, availability);
		
		boolean passed = false;
		
		full_uho.addClass(Term.Fall, test_new_sched);
		assertTrue(full_uho.getCoursework().get(1).contains(test_new_sched));
		
		System.out.println("\t" + "adding an existing course_schedule to the UHO...");
			
	}

	@Test
	public void testRemoveClass() throws Throwable
	{
		System.out.println("Testing method " + name.getMethodName().substring(4) + "() by " +
				"removing a Section that is extistant in UHO...");
		
		schedule test_exist_sched = 
				new schedule() {{
						PrivateAccessor.invoke(schedule.class, "getRecord", 
								new Class[]{String.class, String.class, String.class},
								new Object[]{new String(""), new String(""), new String("")}
						);
					 
				}};
		
		full_uho.removeClass(Term.Fall, test_exist_sched);
		assertFalse(full_uho.getCoursework().get(1).contains(test_exist_sched));
		
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
