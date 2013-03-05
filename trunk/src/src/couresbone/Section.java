package couresbone;

public class Section 
{
	@SuppressWarnings("unused")
	private Integer courseId = 0;
	private Integer crn = 0;
	private String teacher = "";
	private Integer section = 0;
	private Boolean time_conflict = false;
	private Boolean depend_conflict = false;
	private Timeslot time;
	private Boolean majorReq = false;
	private Integer concentrationReq = 0;
	private String location = "";
	
	public Section()
	{
		
	}
	
	public Section(Integer id,
						Integer c,
						String prof,
						Integer s,
						Boolean tConflict,
						Boolean depConflict,
						Timeslot ts,
						Boolean mjrReq,
						Integer trackReq,
						String loc )
	{
		this.courseId = id;
		this.crn = c;
		this.teacher = prof;
		this.section = s;
		this.time_conflict = tConflict;
		this.depend_conflict = depConflict;
		this.time = ts;
		this.majorReq = mjrReq;
		this.concentrationReq = trackReq;
		this.location = loc;
		
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
