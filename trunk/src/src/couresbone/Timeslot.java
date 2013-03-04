package couresbone;

import java.util.ArrayList;


public class Timeslot {
	private Integer startBlock;
	private Integer numBlock;
	public Timeslot(Integer s, Integer n){
		this.startBlock=s;
		this.numBlock=n;
	}
	public Integer getStartBlock() {
		return startBlock;
	}
	public void setStartBlock(Integer startBlock) {
		this.startBlock = startBlock;
	}
	public Integer getNumBlock() {
		return numBlock;
	}
	public void setNumBlock(Integer numBlock) {
		this.numBlock = numBlock;
	}
	public ArrayList<Integer> getSlots() {
		ArrayList<Integer> slots=new ArrayList<Integer>();
		for (Integer i=0;i<this.numBlock;i++){
			slots.add(this.startBlock+i);
		}
		return slots;
	}
}
