/*
 * Dragon Course Scheduler
 * Author: Stan Kolakowski
 */

package couresbone;

import java.util.ArrayList;

public class SessionInfo 
{

	private long major = 0;
	private ArrayList<String> concentration = new ArrayList<String>();
	private ArrayList<ArrayList<schedule>> coursework = 
			new ArrayList<ArrayList<schedule>>();
	private ArrayList<ArrayList<Boolean>> availability = 
			new ArrayList<ArrayList<Boolean>>();
	public ArrayList<schedule> termOfferings = new ArrayList<schedule>();
	
	/**
	 * The default constructor.
	 * </br>
	 */
	public SessionInfo()
	{
		
	}

	public setConcentration( ArrayList<String> s){
		this.concentration=s;
	}
	
	public SessionInfo(Integer mj, ArrayList<Integer> tracks,
               ArrayList<ArrayList<schedule>> courses, ArrayList<schedule> termClasses,
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
	public ArrayList<ArrayList<schedule>> getCoursework()
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
//	 * schedule objects as the classes offered in the current Term.
//	 * </br>
//	 * @param termClasses An ArrayList of 'schedule' Objects
//	 * @see schedule
//	 */
//	public void setTermOffer(ArrayList<schedule> termClasses)
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
	public void setClasses(Term term, ArrayList<schedule> classes)
	{
		Integer crn;
		boolean exist = false;
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
		
		for(int i = 0; i < classes.size(); i++)
		{
			crn = classes.get(i).getCRN();
			
			for(int j = 0; j < this.coursework.get(index).size(); j++)
			{
				if( this.coursework.get(index).get(j).getCRN() == crn)
				{
					exist = true;
					break;
				}
			}
			
			if(!exist)
			{
				this.coursework.get(index).add( classes.get(i) );
			}
			
		} //end for
		
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
	public void addClass(Term term, schedule schedule)
	{
		Integer course_crn = schedule.getCRN();
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
				this.coursework.get(index).set(i, schedule);
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
	 * @param  timeslot
	 */
	public void removeClass(Term term, schedule timeslot)
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
	 * The <code>modAvail</code> function updates the availability of a schedule
	 * provided the schedule and a Term enum constant.
	 * </br>
	 * @param term History, Fall, Winter, Spring, or Summer
	 * @param add
	 * @param schedule
	 */
	public void modAvail(Term term, boolean add, schedule schedule)
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
