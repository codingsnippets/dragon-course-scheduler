package couresbone;

import java.util.ArrayList;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import org.junit.Rule;
import org.junit.rules.TestName;


public class TimeslotTest {
	
	@Rule public TestName name = new TestName();

	private Object constr_ts;
	private Timeslot ts;
	private static final Integer start = 1;
	private static final Integer num_intervals = 3;
	private static ArrayList<Integer> expected_slots;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		constr_ts = new Timeslot(start, num_intervals);
		ts = new Timeslot(start, num_intervals);
	}

	@Test
	public final void testTimeslot() {
		System.out.println("Testing constructor " + name.getMethodName().substring(4) + 
				"() with " + "<insert reason here>" + " ...");
		
		
		assertEquals("objecy name", constr_ts.getClass().getName(), "couresbone.Timeslot");
		assertEquals("start_block", ts.getStartBlock(), start);
		assertEquals("num_blocks", ts.getNumBlock(), num_intervals);
		
	}

	@Test
	public final void testGetStartBlock() {
		//fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetNumBlock() {
		//fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetSlots() 
	{
		System.out.println("Testing method " + name.getMethodName().substring(4) + 
				"() with " + "set start time and set number of intervals" + " ...");
		
		expected_slots = new ArrayList<Integer>(){{
			add(1);
			add(2);
			add(3);
			add(4);
		}};
		
		ArrayList<Integer> slots = new ArrayList<Integer>();
		
		slots = ts.getSlots();
		
		for(int i = 0; i < ts.getSlots().size(); i++)
		{
			assertEquals(slots.get(i), expected_slots.get(i));

		}
		
		
		
		
	}

}
