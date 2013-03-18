
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class mysqlDBExecute {

    public static ArrayList<String> PullMajors(){
        ArrayList<String> majors = new ArrayList<String>();

        ArrayList<ArrayList<String>> records =  mysqlStatement.startConnection("Select distinct `Subject`", "schedule", "");

        for( ArrayList<String> currentMajor : records){
            majors.add(currentMajor.toString());
        }

        return majors;
    }

    public static ArrayList<String> PullConcentrations(String MajorCode){
        ArrayList<String> concentrations =  new ArrayList<String>();
        String table="track";
        String fields="track_name";

        ArrayList<ArrayList<String>> records =  mysqlStatement.startConnection("Select `track_name`", "track", "");

        for( ArrayList<String> thisTrack : records){
            concentrations.add(thisTrack.toString());
        }

        return concentrations;
    }

    public static ArrayList<Schedule> PullSchedule(Term termName, SessionInfo userSession){

        ArrayList<Schedule> scheduleCollection =  new ArrayList<Schedule>();

        // based off termName

        String constraints = "where `Term` = \"" + termName.toString() + "\"";

        ArrayList<ArrayList<String>> records =  mysqlStatement.startConnection("SELECT *", "schedule", constraints);

        for( ArrayList<String> thisSchedule : records){

            Schedule thisCourse = new Schedule();

            thisCourse.CRN = Integer.parseInt(thisSchedule.get(0));
            thisCourse.Subject = thisSchedule.get(1);
            thisCourse.Course_no = Integer.parseInt(thisSchedule.get(2));
            thisCourse.Term = thisSchedule.get(3);
            thisCourse.Section = Integer.parseInt(thisSchedule.get(4));
            thisCourse.Instruction_type =   thisSchedule.get(5);
            thisCourse.Instructor =  thisSchedule.get(6);
            thisCourse.Location = thisSchedule.get(7);
            thisCourse.Weekday = thisSchedule.get(8);
            thisCourse.Start_time = thisSchedule.get(9);
            thisCourse.End_time =thisSchedule.get(10);
            //thisCourse.CourseName = 11

            thisCourse.Title ="Pending implemntation";
            thisCourse.Prerequisites = "Details comming";


            // Special treatment for the time slot information
            String timeSlots = thisSchedule.get(12);
            StringTokenizer stArr = new StringTokenizer(timeSlots, ", ");
            ArrayList<Integer> timeIndices = new ArrayList<Integer>();
            while(stArr.hasMoreTokens()){
                timeIndices.add(Integer.parseInt(stArr.nextToken()));
            }
            thisCourse.Times = timeIndices;


            //List<String> timeIndexes = Arrays.asList(slotsTaken);
            //thisCourse.Times =


            // Based off the Subject + Course_no




            scheduleCollection.add(thisCourse);

        }



        return scheduleCollection;

    }

    public void filterConflicts(SessionInfo userSession){

    }

}
