/*
 * Dragon Course Scheduler
 * Author: Stan Kolakowski
 */

import java.util.ArrayList;
import java.util.HashMap;

public class SessionInfo 
{

	private long major = 0;
	private ArrayList<String> concentration = new ArrayList<String>();
	private HashMap<Term, ArrayList<Schedule>> coursework = 
			new HashMap<Term, ArrayList<Schedule>>();
	private ArrayList<ArrayList<Boolean>> availability = 
			new ArrayList<ArrayList<Boolean>>();
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
	
	public SessionInfo(Integer mj, ArrayList<Integer> tracks,
               ArrayList<ArrayList<Schedule>> courses, ArrayList<Schedule> termClasses,
               ArrayList<ArrayList<Boolean>> avail)
	{
		this.major = mj;
		this.concentration = tracks;
		this.coursework = courses;
		this.availability = avail;
		this.termOfferings = termClasses;
	}
	
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
	 * @param l The major represented as an integer.
	 */
	public void setMajor(long l)
	{
		this.major = l;
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
	 * @param Schedule
	 * @return
	 */
	
    //TODO same thing here, code clone
	public void addClass(Term term, Schedule Schedule)
	{
		Integer course_crn = Schedule.getCRN();
		boolean exists = false;
		int index = -1;
		
		switch(term)
		{
			case History:
				index = 0;
				
				break;
				
			case Fall:
				index = 1;
				
				break;
			
			case Winter:
				index = 2;
				
				break;
				
			case Spring:
				index = 3;
				
				break;
				
			case Summer:
				index = 4;
				
				break;
			
			default:
				System.out.println("UHO: Invalid Term passed: " + term);
				break;
			
		} //end switch
						
		for (int i = 0; i < coursework.get(index).size(); i++ )
		{
			if (coursework.get(index).get(i).getCRN() == course_crn )
			{
				this.coursework.get(index).set(i, Schedule);
				exists = true;
				break;
			}
			
		}
		
		if(exists != true)
		{
			this.coursework.get(index).add(Schedule);
		}
	}
	
	/**
	 * The <code>removeClass</code> function removes a class from the provided 
	 * term.
	 * </br>
	 * @param  term
	 * @param  timeslot
	 */
	public void removeClass(Term term, Schedule timeslot)
	{
		Integer course_crn = timeslot.getCRN();
		int index = -1;
		
		switch(term)
		{
			case History:
				index = 0;
				
				break;
				
			case Fall:
				index = 1;
				
				break;
			
			case Winter:
				index = 2;
				
				break;
				
			case Spring:
				index = 3;
				
				break;
				
			case Summer:
				index = 4;
				
				break;
			
			default:
				System.out.println("UHO: Invalid Term passed: " + term);
				break;
			
		} //end switch
		
		for (int i = 0; i < coursework.get(index).size(); i++ )
		{
			if (coursework.get(index).get(i).getCRN() == course_crn )
			{
				this.coursework.get(index).remove(i);
			}
			
		}
	}
		
	/**
	 * The <code>modAvail</code> function updates the availability of a Schedule
	 * provided the Schedule and a Term enum constant.
	 * </br>
	 * @param term History, Fall, Winter, Spring, or Summer
	 * @param add
	 * @param Schedule
	 */
	public void modAvail(Term term, boolean add, Schedule Schedule)
	{
		
		switch(term)
		{
		
			case Fall:
				
				
				break;
			
			case Winter:
				
				
				break;
			
			case Spring:
				
				
				break;
				
			case Summer:
				
				
				break;
				
			default:
				System.err.println("UHO: You have selected an invalid couresbone.Term");
				break;
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
		
		for(int i = 0; i < this.coursework.size(); i++)
		{
			for (int k = 0; k < this.coursework.get(i).size(); k++)
			{
				csv+=this.coursework.get(i).get(k).getCRN();
				csv+=sprtr;
				csv+=this.coursework.get(i).get(k).getSubject();
				csv+=sprtr;
				csv+=this.coursework.get(i).get(k).getCourse_no();
				csv+=sprtr;
				csv+=this.coursework.get(i).get(k).getTerm();
				csv+=sprtr;
				csv+=this.coursework.get(i).get(k).getSection();
				csv+=sprtr;
				csv+=this.coursework.get(i).get(k).getInstruction_type();
				csv+=sprtr;
				csv+=this.coursework.get(i).get(k).getInstructor();
				csv+=sprtr;
				csv+=this.coursework.get(i).get(k).getLocation();
				csv+=sprtr;
				csv+=this.coursework.get(i).get(k).getWeekday();
				csv+=sprtr;
				csv+=this.coursework.get(i).get(k).getStart_time();
				csv+=sprtr;
				csv+=this.coursework.get(i).get(k).getEnd_time();
				csv+=sprtr;
				csv+=this.coursework.get(i).get(k).getStart_block();
				csv+=sprtr;
				csv+=this.coursework.get(i).get(k).getEnd_block();
				csv+=sprtr;
				csv+=this.coursework.get(i).get(k).getCoursename();
				csv+=sprtr;
				
				
			}
		}
		
		for(int i = 0; i < this.availability.size(); i++)
		{
			for (int k = 0; k < this.availability.get(i).size(); k++)
			{
				csv+=this.availability.get(i).get(k);
				csv+=sprtr;
			}
		}
		
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
