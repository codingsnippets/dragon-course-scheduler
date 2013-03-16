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

@SuppressWarnings("all")
public class SessionInfoTest {
	@Rule public TestName name = new TestName();
	
	private static final String CSV_STRING = "";
	private Object uho;
	private SessionInfo full_uho;
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
		
		uho = new SessionInfo();
		
		Integer mj = 2;;
		full_uho = new SessionInfo();

		
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
		
		final schedule test_exist_sched =  new schedule();
			
		PrivateAccessor.setField(	test_exist_sched, "CRN", new Integer(11111) );
		PrivateAccessor.setField(	test_exist_sched, "Subject", new String("") );
		PrivateAccessor.setField(	test_exist_sched, "Course_no", new Integer(11111) );
		PrivateAccessor.setField(	test_exist_sched, "Term", new String("") );
		PrivateAccessor.setField(	test_exist_sched, "Section", new Integer(11111) );
		PrivateAccessor.setField(	test_exist_sched, "Instruction_type", new String("") );
		PrivateAccessor.setField(	test_exist_sched, "Instructor", new String("") );
		PrivateAccessor.setField(	test_exist_sched, "Location", new String("") );
		PrivateAccessor.setField(	test_exist_sched, "Weekday", new String("") );
		PrivateAccessor.setField(	test_exist_sched, "Start_time", new String("") );
		PrivateAccessor.setField(	test_exist_sched, "End_time", new String("") );
		PrivateAccessor.setField(	test_exist_sched, "Start_block", new Integer(11111) );
		PrivateAccessor.setField(	test_exist_sched, "End_block", new Integer(11111)	);
		PrivateAccessor.setField(	test_exist_sched, "coursename", new Integer(11111) );
		
		
		final schedule test_new_sched = new schedule();
			
		PrivateAccessor.setField(	test_new_sched, "CRN",			new Integer(222) );
		PrivateAccessor.setField(	test_new_sched, "Subject", 		new String("ai") );
		PrivateAccessor.setField(	test_new_sched, "Course_no",		new Integer(22) );
		PrivateAccessor.setField(	test_new_sched, "Term", 			new String("Fall") );
		PrivateAccessor.setField(	test_new_sched, "Section", 		new Integer(2) );
		PrivateAccessor.setField(	test_new_sched, "Instruction_type", new String("mean"));
		PrivateAccessor.setField(	test_new_sched, "Instructor", 	new String("bob") );
		PrivateAccessor.setField(	test_new_sched, "Location", 		new String("elsewhere") );
		PrivateAccessor.setField(	test_new_sched, "Weekday", 		new String("today") );
		PrivateAccessor.setField(	test_new_sched, "Start_time", 	new String("negative infinity") );
		PrivateAccessor.setField(	test_new_sched, "End_time", 		new String("positive infinity") );
		PrivateAccessor.setField(	test_new_sched, "Start_block", 	new Integer(2) );
		PrivateAccessor.setField(	test_new_sched, "End_block", 		new Integer(3) );
		PrivateAccessor.setField(	test_new_sched, "coursename", 	new Integer(22222) );
			
		
		
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
						add( test_exist_sched );
						add( test_exist_sched );
							
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
		
		ArrayList<schedule> termClasses  = new ArrayList<schedule>(){{
			add(new schedule());
			
		}};
		
		full_uho = new SessionInfo(majorCode, concentration, 
				coursework, termClasses, availability);
		
		boolean passed = false;
		System.out.println("CHECKING IF OLD SCHEDULE EXISTS...");
		if (full_uho.getCoursework().get(1).contains( test_exist_sched ) == true )
		{
			passed = true;
		}
		
		System.out.print("" + passed);
		//assertTrue(full_uho.getCoursework().get(1).contains( test_exist_sched ));
		
		assertFalse(full_uho.getCoursework().get(1).contains(test_new_sched));
		full_uho.addClass(Term.Fall, test_new_sched);
		assertTrue(full_uho.getCoursework().get(1).contains(test_new_sched));
		
		System.out.println("\t" + "adding an existing course_schedule to the UHO...");
			
	}

	@Test
	public void testRemoveClass() throws Throwable
	{
		System.out.println("Testing method " + name.getMethodName().substring(4) + "() by " +
				"removing a Section that is extistant in UHO...");
		
		schedule test_exist_sched = new schedule();
		
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
