/*
 * Dragon Course Scheduler
 * Author: Stan Kolakowski
 * Copyright © 2013
 */

package couresbone;

import java.util.ArrayList;

import Filter.course_schedule;

public class UserHistoryObject 
{

	private Integer major = 0;
	private ArrayList<Integer> concentration = new ArrayList<Integer>();
	private ArrayList<ArrayList<course_schedule>> coursework = 
			new ArrayList<ArrayList<course_schedule>>();
	private ArrayList<ArrayList<Boolean>> availability = 
			new ArrayList<ArrayList<Boolean>>();
	
	
	/**
	 * The default constructor.
	 * 
	 */
	public UserHistoryObject()
	{
		
	}
	
	public UserHistoryObject(Integer major, ArrayList<Integer> tracks,
			ArrayList<ArrayList<course_schedule>> courses, 
			ArrayList<ArrayList<Boolean>> availability)
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
	public ArrayList<ArrayList<course_schedule>> getCoursework()
	{
		return this.coursework;
	}
	
	/**
	 * The <code>setMajor</code> function sets the major of the User-History
	 * Object.
	 * </br>
	 * @param major
	 */
	public void setMajor(int major)
	{
		this.major = major;
	}
	
	/**
	 * The <code>setClasses</code> function sets the provided classes to the 
	 * provided term.
	 * </br>
	 * @param term
	 * @param classes
	 */
	public void setClasses(Term term, ArrayList<course_schedule> classes)
	{
		Integer crn;
		boolean exist = false;
		
		switch(term)
		{
			case History:
				
				for(int i = 0; i < classes.size(); i++)
				{
					crn = classes.get(i).getCRN();
					
					for(int j = 0; j < this.coursework.get(0).size(); j++)
					{
						if( this.coursework.get(0).get(j).getCRN() == crn)
						{
							exist = true;
							break;
						}
					}
					
					if(!exist)
					{
						this.coursework.get(0).add( classes.get(i) );
					}
				} //end for
					
				break;
				
			case Fall:
				
				for(int i = 0; i < classes.size(); i++)
				{
					crn = classes.get(i).getCRN();
					
					for(int j = 0; j < this.coursework.get(1).size(); j++)
					{
						if( this.coursework.get(1).get(j).getCRN() == crn)
						{
							exist = true;
							break;
						}
					}
					
					if(!exist)
					{
						this.coursework.get(1).add( classes.get(i) );
					}
				}
				
				break;
			
			case Winter:
				for(int i = 0; i < classes.size(); i++)
				{
					crn = classes.get(i).getCRN();
					
					for(int j = 0; j < this.coursework.get(2).size(); j++)
					{
						if( this.coursework.get(2).get(j).getCRN() == crn)
						{
							exist = true;
							break;
						}
					}
					
					if(!exist)
					{
						this.coursework.get(2).add( classes.get(i) );
					}
				}
				
				break;
			
			case Spring:
				for(int i = 0; i < classes.size(); i++)
				{
					crn = classes.get(i).getCRN();
					
					for(int j = 0; j < this.coursework.get(3).size(); j++)
					{
						if( this.coursework.get(3).get(j).getCRN() == crn)
						{
							exist = true;
							break;
						}
					}
					
					if(!exist)
					{
						this.coursework.get(3).add( classes.get(i) );
					}
				}
				
				break;
				
			case Summer:
				for(int i = 0; i < classes.size(); i++)
				{
					crn = classes.get(i).getCRN();
					
					for(int j = 0; j < this.coursework.get(4).size(); j++)
					{
						if( this.coursework.get(4).get(j).getCRN() == crn)
						{
							exist = true;
							break;
						}
					}
					
					if(!exist)
					{
						this.coursework.get(4).add( classes.get(i) );
					}
				}
				
				break;
				
			default:
				System.err.println("UHO: You can selected invalid couresbone.Term");
				break;
		}
		
	}
	
	/**
	 * The <code>addClass</code> function adds a class section to the provided 
	 * term.
	 * </br>
	 * @param term History, Fall, Winter, Spring, or Summer
	 * @param course A course_schedule object
	 * @see course_schedule
	 */
	public void addClass(Term term, course_schedule course)
	{
		Integer course_crn = course.getCRN();
		boolean exists = false;
		
		switch(term)
		{
			case History:
				
				for (int i = 0; i < coursework.get(0).size(); i++ )
				{
					if (coursework.get(0).get(i).getCRN() == course_crn )
					{
						this.coursework.get(0).set(i, course);
						exists = true;
						break;
					}
					
				}
				
				if(exists != true)
				{
					this.coursework.get(0).add(course);
				}
				
				break;
		
			case Fall:
				
				for (int i = 0; i < coursework.get(1).size(); i++ )
				{
					if (coursework.get(1).get(i).getCRN() == course_crn )
					{
						this.coursework.get(1).set(i, course);
						exists = true;
						break;
					}
					
				}
				
				if(exists != true)
				{
					this.coursework.get(1).add(course);
				}
				
				break;
			
			case Winter:
				for (int i = 0; i < coursework.get(2).size(); i++ )
				{
					if (coursework.get(2).get(i).getCRN() == course_crn )
					{
						this.coursework.get(2).set(i, course);
						exists = true;
						break;
					}
					
				}
				
				if(exists != true)
				{
					this.coursework.get(2).add(course);
				}
				
				break;
			
			case Spring:
				for (int i = 0; i < coursework.get(3).size(); i++ )
				{
					if (coursework.get(3).get(i).getCRN() == course_crn )
					{
						this.coursework.get(3).set(i, course);
						exists = true;
						break;
					}
					
				}
				
				if(exists != true)
				{
					this.coursework.get(3).add(course);
				}
				
				break;
				
			case Summer:
				for (int i = 0; i < coursework.get(4).size(); i++ )
				{
					if (coursework.get(4).get(i).getCRN() == course_crn )
					{
						this.coursework.get(4).set(i, course);
						exists = true;
						break;
					}
					
				}
				
				if(exists != true)
				{
					this.coursework.get(4).add(course);
				}
				
				break;
				
			default:
				System.err.println("UHO: You can selected invalid couresbone.Term");
				break;
		}
	}
	
	/**
	 * The <code>removeClass</code> function removes a class from the provided 
	 * term.
	 * </br>
	 * @param term History, Fall, Winter, Spring, or Summer
	 * @param course
	 */
	public void removeClass(Term term, course_schedule course)
	{
		Integer course_crn = course.getCRN();
		
		switch(term){
		
			case History:
				for (int i = 0; i < coursework.get(0).size(); i++ )
				{
					if (coursework.get(0).get(i).getCRN() == course_crn )
					{
						this.coursework.get(0).remove(i);
					}
					
				}
				
				break;
				
			case Fall:
				for (int i = 0; i < coursework.get(1).size(); i++ )
				{
					if (coursework.get(1).get(i).getCRN() == course_crn )
					{
						this.coursework.get(1).remove(i);
					}
					
				}
				
				break;
			
			case Winter:
				for (int i = 0; i < coursework.get(2).size(); i++ )
				{
					if (coursework.get(2).get(i).getCRN() == course_crn )
					{
						this.coursework.get(2).remove(i);
					}
					
				}
				
				break;
			
			case Spring:
				for (int i = 0; i < coursework.get(3).size(); i++ )
				{
					if (coursework.get(3).get(i).getCRN() == course_crn )
					{
						this.coursework.get(3).remove(i);
					}
					
				}
				
				break;
				
			case Summer:
				for (int i = 0; i < coursework.get(0).size(); i++ )
				{
					if (coursework.get(4).get(i).getCRN() == course_crn )
					{
						this.coursework.get(4).remove(i);
					}
					
				}
				
				break;
				
			default:
				System.err.println("UHO: You can selected invalid couresbone.Term");
				break;
		}
	}
		
	/**
	 * The <code>modAvail</code> function updates the availability of a Section
	 * provided the Section and a Term enum constant.
	 * </br>
	 * @param term History, Fall, Winter, Spring, or Summer
	 * @param add 
	 * @param course
	 */
	public void modAvail(Term term, boolean add, course_schedule course)
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
	 * The <code>toCsv</code> function creates a string of comma separated
	 * values of the UserHistoryObject.
	 * </br>
	 * @return comma separated String defining the UserHistoryObject
	 */
	public String toCSV()
	{
		String csv = "";
		
		return csv;
	}
	

} //End of couresbone.UserHistoryObject()
