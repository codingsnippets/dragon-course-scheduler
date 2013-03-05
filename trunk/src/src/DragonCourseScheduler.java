/*
 * Dragon Course Scheduler
 * Author: 
 * Copyright © 2013
 */

import couresbone.Section;
import couresbone.Term;
import couresbone.UserHistoryObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//class UHO{};
class Filter
{

	public ArrayList<Integer> getMajors() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<String> getConcentrations() 
	{
		// TODO Auto-generated method stub
		return null;
	}
};

public class DragonCourseScheduler 
{
	private UserHistoryObject user;
	private Term currTerm;
	private ArrayList<ArrayList<Integer>> offerings;
	private Filter filter;
	
	/**
	 * The <code>getMajors()</code> function retrieves the user's major(s) from
	 * the filter
	 * </br>
	 * @return ArrayList<Integer> majors
	 */
	private ArrayList<Integer> getMajors()
	{
		return filter.getMajors();
	}
	
	/**
	 * The <code>getConcentrations()</code> function retrieves the user's
	 * concentrations from the filter.  
	 * </br>
	 * @return ArrayList concentrations
	 */
	private ArrayList<String> getConcentrations()
	{
		return filter.getConcentrations();
	}
	
	/**
	 * The <code>setMajor()</code> function sets the major of the user in the 
	 * UHO.
	 * </br>
	 * @param Integer major
	 * @return 
	 */
	private void setMajor(Integer m)
	{
		user.setMajor(m);
	}
	
	/**
	 * The <code>parseHistory()</code> function parses the csv String of the 
	 * user's history courses and creates an ArrayList of courses to be added
	 * to the UHO.
	 * </br>
	 * @param String csv
	 */
	private void parseHistory(String s)
	{
		String[] classes=s.split(",");
		ArrayList<Integer> courses = new ArrayList<Integer>();
		
		for(String c:classes)
		{
			String id="";
			
			for(char x:c.toCharArray())
			{
				if(Character.isDigit(x))
				{
					id+=x;	
				}
				else
				{
					Integer val=x-65; //set A to 00, Z to 25;
					String n=val.toString();
					
					if(n.length()==1) //pad single digit values to 2 spaces
					{
						n="0"+n;
					}
					
					id+=n;
				}
			}
			
			courses.add(Integer.parseInt(id));
			
		} //End of for loop.
		
		user.setClasses(Term.History, courses);
		
	} //End of parseHistory()
	
	
	/**
	 * The <code>inputFile()</code> function ...
	 * </br>
	 * @param String
	 */
	private void inputFile(String s)//expects CSV input, can be over multiple lines for readability
	{
		BufferedReader inp;
		
		try 
		{
			inp = new BufferedReader(new FileReader(s));
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String parseme = "";
		String next = "";
		
		boolean eof = false;
		
		while(!eof)
		{
			parseme += next;
			
			try 
			{
				next = inp.readLine();
			} 
			catch (IOException e) 
			{
				eof = true;
			}	
			
		} //End while loop.
		
		parseHistory(parseme);
		
	} 
	
	/**
	 * The <code>addClass()</code> function adds a Section provided a 
	 * constant of the Term enumeration.
	 * </br>
	 * @param Term
	 * @param Section
	 */
	private void addClass(Term t, Section s)
	{
		user.addClass(t, s);
	}
		
	/**
	 * The <code>removeClass()</code> function removes a Section provided a 
	 * constant of the Term enumeration.
	 * </br>
	 * @param Term
	 * @param Section
	 */
	private void removeClass(Term t, Section s)
	{
		user.removeClass(t, s);
	}
	
	/**
	 * The <code>changeTerm()</code> function 
	 * </br>
	 * @param Term
	 */
	private void changeTerm(Term t)
	{
		currTerm = t;
	}

	
} //End of class.
