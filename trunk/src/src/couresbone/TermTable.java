/*
 * Dragon Course Scheduler
 */

package couresbone;

import java.util.HashMap;
public class TermTable 
{
	private HashMap<Integer, Timeslot> times;
	private HashMap<Integer, String> offerings;
	private HashMap<Integer, String> descriptions;
	private Boolean dirty;
	
	/**
	 * The <code>getTimes()</code> function returns a HashMap of Integer to
	 * Timeslot.
	 * </br>
	 * @return HashMap<Integer, Timeslot> times
	 */
    public HashMap<Integer, Timeslot> getTimes() 
    {
		return times;
	}
    
    /**
     * The <code>setTimes()</code> function sets the times of TernTable.
     * </br>
     * @param times
     */
	public void setTimes(HashMap<Integer, Timeslot> times) 
	{
		this.times = times;
	}
	
	/**
	 * The <code>getOfferings()</code> function returns the offerings attribute.
	 * </br>
	 * @return HashMap<Integer, String> offerings
	 */
	public HashMap<Integer, String> getOfferings() 
	{
		return offerings;
	}
	
	/**
	 * The <code>setOfferings()</code> function sets offerings provided a HashMap
	 * of Integer to String.
	 * </br>
	 * @param HashMap<Integer, String> offerings
	 */
	public void setOfferings(HashMap<Integer, String> offerings) 
	{
		this.offerings = offerings;
	}
	
	/**
	 * The <code>getDescriptions()</code> function returns the descriptions.
	 * </br>
	 * @return HashMap<Integer, String> descriptions
	 */
	public HashMap<Integer, String> getDescriptions() 
	{
		return descriptions;
	}
	
	/**
	 * The <code>setDescriptions()</code> function sets the descriptions.
	 * </br>
	 * @param HashMap<Integer, String> descriptions
	 */
	public void setDescriptions(HashMap<Integer, String> descriptions) 
	{
		this.descriptions = descriptions;
	}
	
	/**
	 * The <code>getDirty()</code> function ...
	 * </br>
	 * @return Boolean dirty
	 */
	public Boolean getDirty() 
	{
		return dirty;
	}
	
	/**
	 * The <code>setDirty()</code> function sets dirty to true of false;
	 * </br>
	 * @param Boolean dirty
	 */
	public void setDirty(Boolean dirty) 
	{
		this.dirty = dirty;
	}
	
	
	
} //End of TermTable class.
