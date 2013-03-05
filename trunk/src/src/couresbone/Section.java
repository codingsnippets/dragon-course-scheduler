package couresbone;

import java.util.ArrayList;

public class Section 
{
	private Integer courseId = 0;
	private Integer crn = 0;
	private String teacher = "";
	private Integer section = 0;
	private Boolean time_conflict = false;
	private Boolean depend_conflict = false;
	private Timeslot timeslot;
	private Boolean majorReq = false;
	private Integer concentrationReq = 0;
	
	public void Section()
	{
		
	}
	
	public void Section(Integer id,
						Integer c,
						String prof,
						Integer s,
						Boolean tConflict,
						Boolean depConflict,
						Timeslot ts,
						Boolean mjrReq,
						Integer trackReq )
	{
		courseId = id;
		crn = c;
		teacher = prof;
		section = s;
		time_conflict = tConflict;
		depend_conflict = depConflict;
		timeslot = ts;
		majorReq = mjrReq;
		concentrationReq = trackReq;
		
	}
	
	public Integer getCrn()
	{
		return this.crn;
	}
	
	public String toCsv()
	{
		String csv = "";
		
		return csv;
	}
	
	
	
	
	
	
	
	
	
	
} //End of Section class.
