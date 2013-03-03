import java.util.ArrayList;

import sun.swing.SwingUtilities2.Section;


public class UserHistoryObject {

	private int major = 0;
	private ArrayList<Integer> concentration = new ArrayList<Integer>();
	private ArrayList<ArrayList<Section>> coursework = new ArrayList<ArrayList<Section>>();
	private ArrayList<ArrayList<Boolean>> availability = new ArrayList<ArrayList<Boolean>>();
	
	
	
	public UserHistoryObject()
	{
		
	}
	
	public UserHistoryObject(int mj, ArrayList<Integer> tracks,
			ArrayList<ArrayList<Section>> sections, 
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
	 * The <code>getMajor()</code> function retrieves the major of the User-History Object.
	 * </br>
	 * @param
	 * @return integer major
	 */
	public int getMajor()
	{
		return major;
		
	}
	
	/**
	 * The <code>setMajor()</code> function sets the major of the User-History
	 * Object.
	 * </br>
	 * @param Integer m
	 * @return
	 */
	public void setMajor(int m)
	{
		this.major = m;
	}
	
	/**
	 * The <code>setClasses()</code> function sets the provided classes to the 
	 * provided term.
	 * </br>
	 * @param Term
	 * @param ArrayList<Integer> classes
	 * @return
	 */
	/*public void setClasses(Term t, ArrayList<Section> classes)
	{
		switch(t)
		{
		
			case History:
				for (Integer i=0; i < classes.size(); i++ )
				{
					this.coursework.get(0).add(i);
				}
				
				break;
			case Fall:
				for (Integer i=0; i < classes.size(); i++ )
				{
					this.coursework.get(1).add(i);
				}
				
				break;
			
			case Winter:
				for (Integer i=0; i < classes.size(); i++ )
				{
					this.coursework.get(2).add(i);
				}
				
				break;
			
			case Spring:
				for (Integer i=0; i < classes.size(); i++ )
				{
					this.coursework.get(3).add(i);
				}
				
				break;
				
			case Summer:
				for (Integer i=0; i < classes.size(); i++ )
				{
					this.coursework.get(4).add(i);
				}
				
				break;
				
			default:
				System.err.println("UHO: You can selected invalid Term");
				break;
		}
		
	}*/
	
	
	/**
	 * The <code>addClass</code> function adds a class to the provided term.
	 * </br>
	 * @param Term t
	 * @param Integer CRN
	 * @return
	 */
	public void addClass(Term t, Section s)
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
						this.coursework.get(0).get(i).set(s);
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
						this.coursework.get(1).get(i).set(s);
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
					if (coursework.get(2).get(i).getCrnd() == course_crn )
					{
						this.coursework.get(2).get(i).set(s);
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
						this.coursework.get(3).get(i).set(s);
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
						this.coursework.get(4).get(i).set(s);
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
				System.err.println("UHO: You can selected invalid Term");
				break;
		}
	}
	
	/**
	 * The <code>addClass</code> function adds a class to the provided term.
	 * </br>
	 * @param Term term
	 * @param Timeslot time-slot
	 * @return
	 */
	public void removeClass(Term t, Section s)
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
				System.err.println("UHO: You can selected invalid Term");
				break;
		}
	}
	
	/**
	 * The <code>modAvail</code> function...
	 * </br>
	 * @param Term t
	 * @param Boolean 
	 * @param Timeslot
	 * @return
	 */
	public void modAvail(Term t, boolean add, Section s)
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
				System.err.println("UHO: You have selected an invalid Term");
				break;
		}
		
	} //End of modAvail()
	
	/*
	 * HELPER FUNCTIONS
	 */
	public String toCSV()
	{
		String csv = "";
		
		return csv;
	}
	
	public static void main(String[] args)
	{
		

	} // End of Main()

} //End of UserHistoryObject()
