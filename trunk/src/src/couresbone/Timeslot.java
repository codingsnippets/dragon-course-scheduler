/*
 * Dragon Course Scheduler
 */

package couresbone;

import java.util.ArrayList;


public class Timeslot 
{
	private Integer startBlock;
	private Integer numBlock;
	
	/**
	 * The <code>Timeslot()</code> constructor creates a new Timeslot Object,
	 * provided an Integer start time  and number of 10 min intervals it 
	 * will contain. 
	 * </br>
	 * Start time is formatted in the following way:
	 * (0=Monday 8:00am, 83=Monday 9:50pm, 84=Tuesday 8:00am)
	 * @param Integer start_time
	 * @param Integer number_of_10_min_timeblocks
	 */
	public Timeslot(Integer s, Integer n)
	{
		this.startBlock=s;
		this.numBlock=n;
	}
	
	/**
	 * The <code>getStartBlock()</code> function retrieves the start time of
	 * the Timeslot.
	 * </br>
	 * @return Integer start_time
	 */
	public Integer getStartBlock()
	{
		return startBlock;
	}
	
	/**
	 * The <code>setStartBlock()</code> function sets the start time of Timeslot.
	 * </br>
	 * @param Integer start_time
	 */
	public void setStartBlock(Integer startBlock) 
	{
		this.startBlock = startBlock;
	}
	
	/**
	 * The <code>getNumBlock()</code> function retrieves the number of 10-
	 * minute intervals the Timeslot object includes.
	 * </br>
	 * @return Integer num_intervals
	 */
	public Integer getNumBlock() 
	{
		return numBlock;
	}
	
	/**
	 * The <code>setNumBlock()</code> function sets the number of 10-minute 
	 * intervals of the Timeslot.
	 * </br>
	 * @param Integer num_intervals
	 */
	public void setNumBlock(Integer numBlock) 
	{
		this.numBlock = numBlock;
	}
	
	/**
	 * The <code>getSlots()</code> function returns an ArrayList of the
	 * 10-minute interval times of the Timeslot object.
	 * </br>
	 * @return ArrayList<Integer> time_slots
	 */
	public ArrayList<Integer> getSlots() 
	{
		ArrayList<Integer> slots=new ArrayList<Integer>();
		
		for (Integer i=0;i<this.numBlock;i++)
		{
			slots.add(this.startBlock+i);
		}
		
		return slots;
	}
}
