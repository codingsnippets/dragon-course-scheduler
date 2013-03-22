/*
 * Dragon Course Scheduler
 * Author: Stan Kolakowski
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class SessionInfo 
{
	private static int NUM_TIMESLOTS;
	private Term term;
    private String major;
    private ArrayList<String> concentration ;
    private HashMap<Term, ArrayList<Schedule>> coursework; 
    private HashMap<Term, ArrayList<Boolean>> availability; 
    public Term[] planTerm;
    public ArrayList<Schedule> termOfferings = new ArrayList<Schedule>();



    public Action lastAction;

    public SessionInfo(){
    
    
    	NUM_TIMESLOTS = 504;
    	term=Term.Fall;
    	major = "";
    	concentration = new ArrayList<String>();
    	coursework = new HashMap<Term, ArrayList<Schedule>>();
    	availability = new HashMap<Term, ArrayList<Boolean>>();
    	for (Term t:Term.values()){
    		coursework.put(t, new ArrayList<Schedule>());
	    	availability.put(t, new ArrayList<Boolean>( Collections.nCopies(NUM_TIMESLOTS, false) ));
    	}
    
    }

    public Action getlastAction() {
        return lastAction;
    }

    public void setlastAction(Action lastAction) {
        this.lastAction = lastAction;
    }


    public void setConcentration( ArrayList<String> s){
            this.concentration = s;
    }
    

    
    /**
     * The <code>getMajor</code> function retrieves the major of the 
     * UserHistoryObject.
     * </br>
     * @return The major set in the UserHistoryObject.
     */
    public String getMajor()
    {
            return this.major;
            
    }
    
    /**
     * The <code>setMajor</code> function sets the major of the UserHistoryObject.
     * </br>
     * @param m The major represented as an integer.
     */
    public void setMajor(String m)
    {
            this.major = m;
    }
    
    /**
     * The <code>getCoursework</code> function retrieves the ArrayList of courses.
     * </br>
     * @return The courses saved in the coursework attribute.
     */
    public HashMap<Term, ArrayList<Schedule>> getCoursework()
    {
            return this.coursework;
    }
    
    /**
     * The <code>setTermOffer</code> function sets the provided ArrayList of 
     * Schedule objects as the classes offered in the current Term.
     * </br>
     * @param termClasses An ArrayList of 'Schedule' Objects
     * @see Schedule
     */
    public void setTermOffer(ArrayList<Schedule> termClasses)
    {
            this.termOfferings = termClasses;
    }

    public ArrayList<Schedule> getTermOffer()
    {
        return this.termOfferings;
    }
    
    /**
     * The <code>setClasses</code> function sets the provided classes to the 
     * provided term.
     * </br>
     * @param term History, Fall, Winter, Spring, or Summer
     * @param classes
     */
    public void setClasses(Term term, ArrayList<Schedule> classes)
    {
    	this.coursework.put(term, classes);
            
    }
    
    public Term getTerm() {
		return term;
	}


	public void setTerm(Term term) {
		this.term = term;
	}

	public HashMap<Term, ArrayList<Boolean>> getAvaliabiltiy() {
		return this.availability;
	}
	
	public ArrayList<String> getConcentration() {
		return concentration;
	}


	/**
     * The <code>addClass</code> function adds a class section to the provided 
     * term.
     * </br>
     * @param crn
     * @return
     */
    
    public void addClass( Integer crn)
    {
        Boolean avail = true;
        Schedule schedule = new Schedule();
        
        //find schedule matching crn in termOfferings, and set
        for (int i = 0; i < this.termOfferings.size(); i++ )
        {
            if ( this.termOfferings.get(i).getCRN().equals(crn) )
            {
                schedule = this.termOfferings.get(i);
                break;
            }
                
        }
        this.coursework.get(term).add(schedule);
        modAvail(term, avail, schedule.getTimes() );
        
    }
    
    /**
     * The <code>removeClass</code> function removes a class from the provided 
     * term.
     * </br>
     * @param  crn
     */
    public void removeClass(Integer crn)
    {
        Boolean no_avail = false;
        //remove schedules of matching crn from provided term
        for (int i = 0; i < this.coursework.get(term).size(); i++ )
        {
            if (this.coursework.get(term).get(i).getCRN().equals(crn) )
            {
                modAvail(term, no_avail, this.coursework.get(term).get(i).getTimes() );
                this.coursework.get(term).remove(i);

            }
                
        }
    }
            
    /**
     * The <code>modAvail</code> function updates the availability of a Schedule
     * provided the Schedule and a Term enum constant.
     * </br>
     * @param term - History, Fall, Winter, Spring, or Summer
     * @param status - available or not available timeslot
     * @param times - times to be affected.
     */
    private void modAvail(Term term, boolean status, ArrayList<Integer> times)
    {
        ArrayList<Boolean> x = this.availability.get(term);
        for (Integer t: times)
        {
               x.set( t.intValue(), status );
        }
        this.availability.put(term,x);
            
    } //End of modAvail()
    
    /**
     * The <code>toCsv()</code> function creates a string of comma separated
     * values of the UHO.
     * </br>
     * @return comma separated String defining the UserHistoryObject
     */
//    public String toCSV()
//    {
//        String sprtr = ",";
//        String csv = "";
//
//        csv+=this.major;
//
//        csv+=sprtr;
//
//        for(Integer i:this.concentration)
//        {
//            csv+=i;
//            csv+=sprtr;
//        }
//
//            Iterator it = this.coursework.entrySet().iterator();
//        while (it.hasNext()) {
//            Map.Entry pairs = (Map.Entry)it.next();
//
//            for (int i = 0; i < pairs.getValue().size(); i++ )
//            {
//                csv+=pairs.getValue().get(i).getCRN();
//                csv+=sprtr;
//                csv+=pairs.getValue().get(i).getSubject();
//                csv+=sprtr;
//                csv+=pairs.getValue().get(i).getCourse_no();
//                csv+=sprtr;
//                csv+=pairs.getValue().get(i).getTerm();
//                csv+=sprtr;
//                csv+=pairs.getValue().get(i).getSection();
//                csv+=sprtr;
//                csv+=pairs.getValue().get(i).getInstruction_type();
//                csv+=sprtr;
//                csv+=pairs.getValue().get(i).getInstructor();
//                csv+=sprtr;
//                csv+=pairs.getValue().get(i).getLocation();
//                csv+=sprtr;
//                csv+=pairs.getValue().get(i).getWeekday();
//                csv+=sprtr;
//                csv+=pairs.getValue().get(i).getStart_time();
//                csv+=sprtr;
//                csv+=pairs.getValue().get(i).getEnd_time();
//                csv+=sprtr;
//                csv+=pairs.getValue().get(i).getStart_block();
//                csv+=sprtr;
//                csv+=pairs.getValue().get(i).getEnd_block();
//                csv+=sprtr;
//                csv+=pairs.getValue().get(i).getCoursename();
//                csv+=sprtr;
//            }
//            it.remove(); // avoids a ConcurrentModificationException
//        }
//
//        Iterator ia = this.availability.entrySet().iterator();
//        while (ia.hasNext())
//        {
//            Map.Entry pairs = (Map.Entry)ia.next();
//
//            for (int i = 0; i < pairs.getValue().size(); i++ )
//            {
//                    csv+=pairs.getValue().get(i);
//                            csv+=sprtr;
//            }
//            ia.remove(); // avoids a ConcurrentModificationException
//        }
//
//        //last attribute to add. if not the last element add a comma.
//        for(int i = 0; i < this.termOfferings.size(); i++)
//        {
//            csv+=this.termOfferings.get(i).getCRN();
//            csv+=sprtr;
//            csv+=this.termOfferings.get(i).getSubject();
//            csv+=sprtr;
//            csv+=this.termOfferings.get(i).getCourse_no();
//            csv+=sprtr;
//            csv+=this.termOfferings.get(i).getTerm();
//            csv+=sprtr;
//            csv+=this.termOfferings.get(i).getSection();
//            csv+=sprtr;
//            csv+=this.termOfferings.get(i).getInstruction_type();
//            csv+=sprtr;
//            csv+=this.termOfferings.get(i).getInstructor();
//            csv+=sprtr;
//            csv+=this.termOfferings.get(i).getLocation();
//            csv+=sprtr;
//            csv+=this.termOfferings.get(i).getWeekday();
//            csv+=sprtr;
//            csv+=this.termOfferings.get(i).getStart_time();
//            csv+=sprtr;
//            csv+=this.termOfferings.get(i).getEnd_time();
//            csv+=sprtr;
//            csv+=this.termOfferings.get(i).getStart_block();
//            csv+=sprtr;
//            csv+=this.termOfferings.get(i).getEnd_block();
//            csv+=sprtr;
//            csv+=this.termOfferings.get(i).getCoursename();
//            if(i < this.termOfferings.size()-1)
//            {
//                    csv+=sprtr;
//            }
//        }
//
//
//        return csv;
//    }

}
