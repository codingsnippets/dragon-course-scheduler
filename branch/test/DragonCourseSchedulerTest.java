import junitx.util.PrivateAccessor;
import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.TestName;
import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
/**
 * Created with IntelliJ IDEA.
 * User: Stan K
 * Date: 3/22/13
 * Time: 12:37 AM
 * To change this template use File | Settings | File Templates.
 */
public class DragonCourseSchedulerTest extends Object {
    @Rule public TestName name = new TestName();


    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testParseHistory() throws Throwable {
        System.out.println("Testing method " + name.getMethodName().substring(4) + "() by: ");
        /****   New Test Case *********/
        System.out.println("\t" + "passing a valid String... ");

        ArrayList<Schedule> expected = new ArrayList<Schedule>(){{
            add(new Schedule(){{
                    Course_no = 123;
                    Subject = "CS";
            }});
            add(new Schedule(){{
                Course_no = 171;
                Subject = "CS";
            }});
            add(new Schedule(){{
                Course_no = 172;
                Subject = "CS";
            }});
        }};
        String historyStr = "CS123,CS171,CS172";


//        System.out.println("test: " + test.get(1).getCourse_no());
//        System.out.println("expected " + expected.get(1).getCourse_no());

        try
        {
            ArrayList<Schedule> test = (ArrayList<Schedule>) PrivateAccessor.invoke(DragonCourseScheduler.class,
                "parseHistory",
                new Class[]{String.class},
                new Object[]{historyStr}
            );
          assertTrue(test.get(1).getCourse_no().equals(expected.get(1).getCourse_no()));
          System.out.println("Passed!");
        }
        catch(AssertionError e)
        {
          System.out.println("Failed!");
        }

        /****   New Test Case *********/
        System.out.println("\t" + "passing a String beginning with a comma... ");

        String invalidHistoryStr = ",CS123,CS171,CS172";
        ArrayList<Schedule> test2 = new ArrayList<Schedule>();
//        String[] classes = invalidHistoryStr.split(",");
//        String err = (String) Array.get(classes, 0);
//        System.out.println("isempty: " + err.isEmpty());
        try
        {
            test2 = (ArrayList<Schedule>) PrivateAccessor.invoke(DragonCourseScheduler.class,
                    "parseHistory",
                    new Class[]{String.class},
                    new Object[]{invalidHistoryStr}
            );

        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("test: " + test2.get(1).getCourse_no());
        System.out.println("expected " + expected.get(1).getCourse_no());
        try
        {
            assertTrue( test2.get(1).getCourse_no().equals(expected.get(1).getCourse_no()) );
            System.out.println("Passed!");
        }
        catch(AssertionError e)
        {
            System.out.println("Failed!");
            e.printStackTrace();
        }

    }
}
