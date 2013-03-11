/*
 * Dragon Course Scheduler
 * Author: Stan Kolakowski
 * Copyright � 2013
 */

package couresbone;

import java.util.ArrayList;

public class UHO {

	private Integer major = 0;
	private ArrayList<Integer> concentration = new ArrayList<Integer>();
	private ArrayList<ArrayList<schedule>> coursework = new ArrayList<ArrayList<schedule>>();
	private ArrayList<ArrayList<Boolean>> availability = new ArrayList<ArrayList<Boolean>>();
	
	
	/**
	 * The <code>UHO()</code> function is the default constructor.
	 * </br>
	 */
	public UHO()
	{
		
	}
	
	public UHO(Integer mj, ArrayList<Integer> tracks,
               ArrayList<ArrayList<schedule>> sections,
               ArrayList<ArrayList<Boolean>> avail)
	{
		this.major = mj;
		this.concentration = tracks;
		this.coursework = sections;
		this.availability = avail;
	}
	
	
	/*------------------------------------------------------------------------
	 *  			F U N C T I O N S
	 *  ----------------------------------------------------------------------
	 */
	
	/**
	 * The <code>getMajor()</code> function retrieves the major of the 
	 * UHO.
	 * </br>
	 * @return Integer major
	 */
	public Integer getMajor()
	{
		return major;
		
	}
	
	/**
	 * The <code>setMajor()</code> function sets the major of the User-History
	 * Object.
	 * </br>
	 * @param Integer m
	 */
	public void setMajor(int m)
	{
		this.major = m;
	}
	
	/**
	 * The <code>setClasses()</code> function sets the provided classes to the 
	 * provided term.
	 * </br>
	 * @param couresbone.Term
	 * @param ArrayList<Integer> classes
	 */
	public void setClasses(Term t, ArrayList<schedule> classes)
	{
		Integer crn;
		boolean exist = false;
		
		switch(t)
		{
		
			case History:
				
				for(int i = 0; i < classes.size(); i++)
				{
					crn = classes.get(i).getCrn();
					
					for(int j = 0; j < this.coursework.get(0).size(); j++)
					{
						if( this.coursework.get(0).get(j).getCrn() == crn)
						{
							//this.coursework.get(0).get(j).set( classes.get(i) );
							exist = true;
							break;
						}
					}
					
					if(!exist)
					{
						this.coursework.get(0).add( classes.get(i) );
					}
				}
					
				break;
				
			case Fall:
				
				for(int i = 0; i < classes.size(); i++)
				{
					crn = classes.get(i).getCrn();
					
					for(int j = 0; j < this.coursework.get(1).size(); j++)
					{
						if( this.coursework.get(1).get(j).getCrn() == crn)
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
					crn = classes.get(i).getCrn();
					
					for(int j = 0; j < this.coursework.get(2).size(); j++)
					{
						if( this.coursework.get(2).get(j).getCrn() == crn)
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
					crn = classes.get(i).getCrn();
					
					for(int j = 0; j < this.coursework.get(3).size(); j++)
					{
						if( this.coursework.get(3).get(j).getCrn() == crn)
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
					crn = classes.get(i).getCrn();
					
					for(int j = 0; j < this.coursework.get(4).size(); j++)
					{
						if( this.coursework.get(4).get(j).getCrn() == crn)
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
	 * @param coursebone.Term t
	 * @param Integer CRN
	 * @return
	 */
	public void addClass(Term t, schedule s)
	{
		Integer course_crn = s.getCrn();
		boolean exists = false;
		
		switch(t)
		{
			case History:
				
				for (int i = 0; i < coursework.get(0).size(); i++ )
				{
					if (coursework.get(0).get(i).getCrn() == course_crn )
					{
						this.coursework.get(0).set(i, s);
						exists = true;
						break;
					}
					
				}
				
				if(exists != true)
				{
					this.coursework.get(0).add(s);
				}
				
				
				break;
		
			case Fall:
				
				for (int i = 0; i < coursework.get(1).size(); i++ )
				{
					if (coursework.get(1).get(i).getCrn() == course_crn )
					{
						this.coursework.get(1).set(i, s);
						exists = true;
						break;
					}
					
				}
				
				if(exists != true)
				{
					this.coursework.get(1).add(s);
				}
				
				break;
			
			case Winter:
				for (int i = 0; i < coursework.get(2).size(); i++ )
				{
					if (coursework.get(2).get(i).getCrn() == course_crn )
					{
						this.coursework.get(2).set(i, s);
						exists = true;
						break;
					}
					
				}
				
				if(exists != true)
				{
					this.coursework.get(2).add(s);
				}
				
				break;
			
			case Spring:
				for (int i = 0; i < coursework.get(3).size(); i++ )
				{
					if (coursework.get(3).get(i).getCrn() == course_crn )
					{
						this.coursework.get(3).set(i, s);
						exists = true;
						break;
					}
					
				}
				
				if(exists != true)
				{
					this.coursework.get(3).add(s);
				}
				
				break;
				
			case Summer:
				for (int i = 0; i < coursework.get(4).size(); i++ )
				{
					if (coursework.get(4).get(i).getCrn() == course_crn )
					{
						this.coursework.get(4).set(i, s);
						exists = true;
						break;
					}
					
				}
				
				if(exists != true)
				{
					this.coursework.get(4).add(s);
				}
				
				break;
				
			default:
				System.err.println("UHO: You can selected invalid couresbone.Term");
				break;
		}
	}
	
	/**
	 * The <code>removeClass()</code> function removes a class from the provided 
	 * term.
	 * </br>
	 * @param coursebone.Term term
	 * @param Timeslot time-slot
	 */
	public void removeClass(Term t, schedule s)
	{
		Integer course_crn = s.getCrn();
		
		switch(t){
		
			case History:
				for (int i = 0; i < coursework.get(0).size(); i++ )
				{
					if (coursework.get(0).get(i).getCrn() == course_crn )
					{
						this.coursework.get(0).remove(i);
					}
					
				}
				
				break;
				
			case Fall:
				for (int i = 0; i < coursework.get(1).size(); i++ )
				{
					if (coursework.get(1).get(i).getCrn() == course_crn )
					{
						this.coursework.get(1).remove(i);
					}
					
				}
				
				break;
			
			case Winter:
				for (int i = 0; i < coursework.get(2).size(); i++ )
				{
					if (coursework.get(2).get(i).getCrn() == course_crn )
					{
						this.coursework.get(2).remove(i);
					}
					
				}
				
				break;
			
			case Spring:
				for (int i = 0; i < coursework.get(3).size(); i++ )
				{
					if (coursework.get(3).get(i).getCrn() == course_crn )
					{
						this.coursework.get(3).remove(i);
					}
					
				}
				
				break;
				
			case Summer:
				for (int i = 0; i < coursework.get(0).size(); i++ )
				{
					if (coursework.get(4).get(i).getCrn() == course_crn )
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
	 * The <code>modAvail</code> function updates the availability of a schedule
	 * provided the schedule and a Term enum constant.
	 * </br>
	 * @param Term term
	 * @param Boolean add 
	 * @param Section section
	 */
	public void modAvail(Term t, boolean add, schedule s)
	{
		
		switch(t)
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
	 * @return String csv
	 */
	public String toCSV()
	{
		String csv = "";
		
		return csv;
	}
	
	public static void main(String[] args)
	{
		

	} // End of Main()

} //End of couresbone.UHO()
