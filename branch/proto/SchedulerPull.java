
import java.util.ArrayList;


public interface SchedulerPull {

    public ArrayList<String> PullMajors();

    public ArrayList<String> PullConcentrations(String MajorCode);

    public ArrayList<Schedule> PullSchedule(Term termName, SessionInfo userSession);

    public void filterConflicts(SessionInfo userSession);

}
