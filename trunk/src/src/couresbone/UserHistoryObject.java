/*
 * Dragon Course Scheduler
 * Author: Stan Kolakowski
 */

package couresbone;

import java.util.ArrayList;

public class UserHistoryObject 
{

	private Integer major = 0;
	private ArrayList<Integer> concentration = new ArrayList<Integer>();
	private ArrayList<ArrayList<schedule>> coursework = 
			new ArrayList<ArrayList<schedule>>();
	private ArrayList<ArrayList<Boolean>> availability = 
			new ArrayList<ArrayList<Boolean>>();	
	
	/**
	 * The default constructor.
	 * </br>
	 */
	public UserHistoryObject()
	{
		
	}

	public UserHistoryObject(Integer mj, ArrayList<Integer> tracks,
               ArrayList<ArrayList<schedule>> courses,
               ArrayList<ArrayList<Boolean>> avail)
	{
		this.major = major;
		this.concentration = tracks;
		this.coursework = courses;
		this.availability = availability;
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
	 * @param majorCode The major represented as an integer.
	 */
	public void setMajor(int majorCode)
	{
		this.major = majorCode;
	}
	
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
		String csv = "";
		
		return csv;
	}
	

} //End of couresbone.UHO()
