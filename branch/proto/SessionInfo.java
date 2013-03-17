/*
 * Dragon Course Scheduler
 * Author: Stan Kolakowski
 */

import java.util.ArrayList;
import java.util.HashMap;

public class SessionInfo 
{

	private Integer major = 0;
	private ArrayList<String> concentration = new ArrayList<String>();
	private HashMap<Term, ArrayList<Schedule>> coursework = 
			new HashMap<Term, ArrayList<Schedule>>();
	private HashMap<Term, ArrayList<Boolean>> availability = 
			new HashMap<Term, ArrayList<Boolean>>();
	public Term[] planTerm;
	public ArrayList<Schedule> termOfferings = new ArrayList<Schedule>();
	
	/**
	 * The default constructor.
	 * </br>
	 */
	public SessionInfo()
	{
		
	}

	public void setConcentration( ArrayList<String> s){
		this.concentration = s;
	}
	
	
//	public SessionInfo(Integer mj, ArrayList<Integer> tracks,
//               ArrayList<ArrayList<Schedule>> courses, ArrayList<Schedule> termClasses,
//               ArrayList<ArrayList<Boolean>> avail)
//	{
//		this.major = mj;
//		this.concentration = tracks;
//		this.coursework = courses;
//		this.availability = avail;
//		this.termOfferings = termClasses;
//	}
	
	/**
	 * The <code>getMajor</code> function retrieves the major of the 
	 * UserHistoryObject.
	 * </br>
	 * @return The major set in the UserHistoryObject.
	 */
	public Integer getMajor()
	{
		return this.major;
		
	}
	
	/**
	 * The <code>getCoursework</code> function retrieves the ArrayList of courses.
	 * </br>
	 * @return The courses saved in the coursework attribute.
	 */
	public ArrayList<ArrayList<Schedule>> getCoursework()
	{
		return this.coursework;
	}
	
	/**
	 * The <code>setMajor</code> function sets the major of the UserHistoryObject.
	 * </br>
	 * @param m The major represented as an integer.
	 */
	public void setMajor(Integer m)
	{
		this.major = m;
	}
	
//	/**
//	 * The <code>setTermOffer</code> function sets the provided ArrayList of 
//	 * Schedule objects as the classes offered in the current Term.
//	 * </br>
//	 * @param termClasses An ArrayList of 'Schedule' Objects
//	 * @see Schedule
//	 */
//	public void setTermOffer(ArrayList<Schedule> termClasses)
//	{
//		this.termOfferings = termClasses;
//	}
	
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
	
	/**
	 * The <code>addClass</code> function adds a class section to the provided 
	 * term.
	 * </br>
	 * @param term
	 * @param schedule
	 * @return
	 */
	
    //TODO same thing here, code clone
	public void addClass(Term term, Schedule schedule)
	{
		Integer course_crn = schedule.getCRN();
		boolean exists = false;
								
		for (int i = 0; i < this.coursework.get(term).size(); i++ )
		{
			if (this.coursework.get(term).get(i).getCRN() == course_crn )
			{
				this.coursework.get(term).set(i, schedule);
				exists = true;
				break;
			}
			
		}
		
		if(exists != true)
		{
			this.coursework.get(index).add(schedule);
		}
	}
	
	/**
	 * The <code>removeClass</code> function removes a class from the provided 
	 * term.
	 * </br>
	 * @param  term
	 * @param  schedule
	 */
	public void removeClass(Term term, Schedule schedule)
	{
		Integer course_crn = schedule.getCRN();
		int 
				
		for (int i = 0; i < this.coursework.get(term).size(); i++ )
		{
			if (this.coursework.get(term).get(i).getCRN() == course_crn )
			{
				this.coursework.get(term).remove(i);
			}
			
		}
	}
		
	/**
	 * The <code>modAvail</code> function updates the availability of a Schedule
	 * provided the Schedule and a Term enum constant.
	 * </br>
	 * @param term - History, Fall, Winter, Spring, or Summer
	 * @param add
	 * @param schedule
	 */
	public void modAvail(Term term, boolean add, Schedule schedule)
	{
		Integer crn = schedule.getCRN();
		int schedule_index = -1;
		
		for (int i = 0; i < this.coursework.get(term).size(); i++ )
		{
			if (this.coursework.get(term).get(i).getCRN() == course_crn )
			{
				schedule_index = i;
				break;
			}
		}
		
		try
		{
			this.availability.get(term).set(schedule_index, add);
			
		}catch IndexOutOfBoundsException{
			System.out.err("SI: Schedule not found in coursework! Index out of bounds!");
		}
		
		
	} //End of modAvail()
	
	/**
	 * The <code>toCsv()</code> function creates a string of comma separated
	 * values of the UHO.
	 * </br>
	 * @return comma separated String defining the UserHistoryObject
	 */
	public String toCSV()
	{
		String sprtr = ",";
		String csv = "";
		
		csv+=this.major;
		
		csv+=sprtr;
		
		for(Integer i:this.concentration)
		{
			csv+=i;
			csv+=sprtr;
		}
		
		Iterator it = this.coursework.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pairs = (Map.Entry)it.next();
	   
	        for (int i = 0; i < pairs.getValue().size(); i++ )
	        {
	        	csv+=pairs.getValue().get(i).getCRN();
				csv+=sprtr;
				csv+=pairs.getValue().get(i).getSubject();
				csv+=sprtr;
				csv+=pairs.getValue().get(i).getCourse_no();
				csv+=sprtr;
				csv+=pairs.getValue().get(i).getTerm();
				csv+=sprtr;
				csv+=pairs.getValue().get(i).getSection();
				csv+=sprtr;
				csv+=pairs.getValue().get(i).getInstruction_type();
				csv+=sprtr;
				csv+=pairs.getValue().get(i).getInstructor();
				csv+=sprtr;
				csv+=pairs.getValue().get(i).getLocation();
				csv+=sprtr;
				csv+=pairs.getValue().get(i).getWeekday();
				csv+=sprtr;
				csv+=pairs.getValue().get(i).getStart_time();
				csv+=sprtr;
				csv+=pairs.getValue().get(i).getEnd_time();
				csv+=sprtr;
				csv+=pairs.getValue().get(i).getStart_block();
				csv+=sprtr;
				csv+=pairs.getValue().get(i).getEnd_block();
				csv+=sprtr;
				csv+=pairs.getValue().get(i).getCoursename();
				csv+=sprtr;
	        }
	        it.remove(); // avoids a ConcurrentModificationException
	    }
		
//		for(int i = 0; i < this.coursework.size(); i++)
//		{
//			for (int k = 0; k < this.coursework.get(i).size(); k++)
//			{
//				csv+=this.coursework.get(i).get(k).getCRN();
//				csv+=sprtr;
//				csv+=this.coursework.get(i).get(k).getSubject();
//				csv+=sprtr;
//				csv+=this.coursework.get(i).get(k).getCourse_no();
//				csv+=sprtr;
//				csv+=this.coursework.get(i).get(k).getTerm();
//				csv+=sprtr;
//				csv+=this.coursework.get(i).get(k).getSection();
//				csv+=sprtr;
//				csv+=this.coursework.get(i).get(k).getInstruction_type();
//				csv+=sprtr;
//				csv+=this.coursework.get(i).get(k).getInstructor();
//				csv+=sprtr;
//				csv+=this.coursework.get(i).get(k).getLocation();
//				csv+=sprtr;
//				csv+=this.coursework.get(i).get(k).getWeekday();
//				csv+=sprtr;
//				csv+=this.coursework.get(i).get(k).getStart_time();
//				csv+=sprtr;
//				csv+=this.coursework.get(i).get(k).getEnd_time();
//				csv+=sprtr;
//				csv+=this.coursework.get(i).get(k).getStart_block();
//				csv+=sprtr;
//				csv+=this.coursework.get(i).get(k).getEnd_block();
//				csv+=sprtr;
//				csv+=this.coursework.get(i).get(k).getCoursename();
//				csv+=sprtr;
//				
//				
//			}
//		}
		
	    Iterator ia = this.availability.entrySet().iterator();
	    while (ia.hasNext()) 
	    {
	        Map.Entry pairs = (Map.Entry)ia.next();
	   
	        for (int i = 0; i < pairs.getValue().size(); i++ )
	        {
	        	csv+=pairs.getValue().get(i);
				csv+=sprtr;
	        }
	        ia.remove(); // avoids a ConcurrentModificationException
	    }
	    
/*	    for(int i = 0; i < this.availability.size(); i++)
		{
			for (int k = 0; k < this.availability.get(i).size(); k++)
			{
				csv+=this.availability.get(i).get(k);
				csv+=sprtr;
			}
		}
*/
		//last attribute to add. if not the last element add a comma.
		for(int i = 0; i < this.termOfferings.size(); i++)
		{
			csv+=this.termOfferings.get(i).getCRN();
			csv+=sprtr;
			csv+=this.termOfferings.get(i).getSubject();
			csv+=sprtr;
			csv+=this.termOfferings.get(i).getCourse_no();
			csv+=sprtr;
			csv+=this.termOfferings.get(i).getTerm();
			csv+=sprtr;
			csv+=this.termOfferings.get(i).getSection();
			csv+=sprtr;
			csv+=this.termOfferings.get(i).getInstruction_type();
			csv+=sprtr;
			csv+=this.termOfferings.get(i).getInstructor();
			csv+=sprtr;
			csv+=this.termOfferings.get(i).getLocation();
			csv+=sprtr;
			csv+=this.termOfferings.get(i).getWeekday();
			csv+=sprtr;
			csv+=this.termOfferings.get(i).getStart_time();
			csv+=sprtr;
			csv+=this.termOfferings.get(i).getEnd_time();
			csv+=sprtr;
			csv+=this.termOfferings.get(i).getStart_block();
			csv+=sprtr;
			csv+=this.termOfferings.get(i).getEnd_block();
			csv+=sprtr;
			csv+=this.termOfferings.get(i).getCoursename();
			if(i < this.termOfferings.size()-1)
			{
				csv+=sprtr;
			}
		}
		
		
		return csv;
	}
	

} //End of couresbone.UHO()
