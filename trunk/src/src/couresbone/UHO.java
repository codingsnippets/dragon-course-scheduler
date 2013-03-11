/*
 * Dragon Course Scheduler
 * Author: Stan Kolakowski
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
	 * @param  MajorCode
	 */
	public void setMajor(int MajorCode)
	{
		this.major = MajorCode;
	}
	
	/**
	 * The <code>setClasses()</code> function sets the provided classes to the 
	 * provided term.
	 * </br>
	 * @param term
	 * @param classes
	 */


    //TODO  obvious problem, code smell: code clone, all four terms does not differ that much but have to many lines of
    //TODO  similar code. Change them, otherwise there is no point in having a enum class
	public void setClasses(Term term, ArrayList<schedule> classes)
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
	 * @param term
	 * @param schedule
	 * @return
	 */
    //TODO same thing here, code clone
	public void addClass(Term term, schedule schedule)
	{
		Integer course_crn = schedule.getCRN();
		boolean exists = false;
		
		switch(term)
		{
			case History:
				
				for (int i = 0; i < coursework.get(0).size(); i++ )
				{
					if (coursework.get(0).get(i).getCRN() == course_crn )
					{
						this.coursework.get(0).set(i, schedule);
						exists = true;
						break;
					}
					
				}
				
				if(exists != true)
				{
					this.coursework.get(0).add(schedule);
				}
				
				
				break;
		
			case Fall:
				
				for (int i = 0; i < coursework.get(1).size(); i++ )
				{
					if (coursework.get(1).get(i).getCRN() == course_crn )
					{
						this.coursework.get(1).set(i, schedule);
						exists = true;
						break;
					}
					
				}
				
				if(exists != true)
				{
					this.coursework.get(1).add(schedule);
				}
				
				break;
			
			case Winter:
				for (int i = 0; i < coursework.get(2).size(); i++ )
				{
					if (coursework.get(2).get(i).getCRN() == course_crn )
					{
						this.coursework.get(2).set(i, schedule);
						exists = true;
						break;
					}
					
				}
				
				if(exists != true)
				{
					this.coursework.get(2).add(schedule);
				}
				
				break;
			
			case Spring:
				for (int i = 0; i < coursework.get(3).size(); i++ )
				{
					if (coursework.get(3).get(i).getCRN() == course_crn )
					{
						this.coursework.get(3).set(i, schedule);
						exists = true;
						break;
					}
					
				}
				
				if(exists != true)
				{
					this.coursework.get(3).add(schedule);
				}
				
				break;
				
			case Summer:
				for (int i = 0; i < coursework.get(4).size(); i++ )
				{
					if (coursework.get(4).get(i).getCRN() == course_crn )
					{
						this.coursework.get(4).set(i, schedule);
						exists = true;
						break;
					}
					
				}
				
				if(exists != true)
				{
					this.coursework.get(4).add(schedule);
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
	 * @param  term
	 * @param  timeslot
	 */
	public void removeClass(Term term, schedule timeslot)
	{
		Integer course_crn = timeslot.getCRN();
		
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
	 * The <code>modAvail</code> function updates the availability of a schedule
	 * provided the schedule and a Term enum constant.
	 * </br>
	 * @param term
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
