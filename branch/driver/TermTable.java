import java.util.HashMap;
public class TermTable {
	private HashMap<Integer, Timeslot> times;
	private HashMap<Integer, String> offerings;
	private HashMap<Integer, String> descriptions;
	private Boolean dirty;
	public HashMap<Integer, Timeslot> getTimes() {
		return times;
	}
	public void setTimes(HashMap<Integer, Timeslot> times) {
		this.times = times;
	}
	public HashMap<Integer, String> getOfferings() {
		return offerings;
	}
	public void setOfferings(HashMap<Integer, String> offerings) {
		this.offerings = offerings;
	}
	public HashMap<Integer, String> getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(HashMap<Integer, String> descriptions) {
		this.descriptions = descriptions;
	}
	public Boolean getDirty() {
		return dirty;
	}
	public void setDirty(Boolean dirty) {
		this.dirty = dirty;
	}
	
	
	
	
	
}
