/*
 * Dragon Course Scheduler
 * Author: 
 * Copyright © 2013
 */

import Filter.course_schedule;
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
	 * The <code>getMajors</code> function retrieves the user's major(s) from
	 * the filter
	 * </br>
	 * @return ArrayList of major integers.
	 */
	private ArrayList<Integer> getMajors()
	{
		return filter.getMajors();
	}
	
	/**
	 * The <code>getConcentrations</code> function retrieves the user's
	 * concentrations from the filter.  
	 * </br>
	 * @return An ArrayList of string concentrations
	 */
	private ArrayList<String> getConcentrations()
	{
		return filter.getConcentrations();
	}
	
	/**
	 * The <code>setMajor</code> function sets the major of the user in the 
	 * UHO.
	 * </br>
	 * @param major The major represented as an integer.
	 */
	private void setMajor(Integer major)
	{
		user.setMajor(major);
	}
	
	/**
	 * The <code>parseHistory</code> function parses the csv String of the 
	 * user's history courses and creates an ArrayList of courses to be added
	 * to the UHO.
	 * </br>
	 * @param history_csv
	 */
	private void parseHistory(String history_csv)
	{
		String[] classes = history_csv.split(",");
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
					
					id += n;
				}
			}
			
			courses.add(Integer.parseInt(id));
			
		} //End of for loop.
		
		user.setClasses(Term.History, courses);
		
	} //End of parseHistory()
	
	
	/**
	 * The <code>inputFile</code> function ...
	 * </br>
	 * @param csv
	 */
	private void inputFile(String csv)//expects CSV input, can be over multiple lines for readability
	{
		BufferedReader inp;
		
		try 
		{
			inp = new BufferedReader(new FileReader(csv));
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
	 * The <code>addClass</code> function adds a Section provided a 
	 * constant of the Term enumeration.
	 * </br>
	 * @param term History, Fall, Winter, Spring, or Summer
	 * @param course
	 */
	private void addClass(Term term, course_schedule course)
	{
		user.addClass(term, course);
	}
		
	/**
	 * The <code>removeClass</code> function removes a Section provided a 
	 * constant of the Term enumeration.
	 * </br>
	 * @param term History, Fall, Winter, Spring, or Summer
	 * @param course
	 */
	private void removeClass(Term term, course_schedule course)
	{
		user.removeClass(term, course);
	}
	
	/**
	 * The <code>changeTerm</code> function 
	 * </br>
	 * @param term History, Fall, Winter, Spring, or Summer
	 */
	private void changeTerm(Term term)
	{
		currTerm = term;
	}

	
} //End of DragonCourseScheduler.
