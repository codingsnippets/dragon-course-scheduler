import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.ws.Action;

public class DragonCourseScheduler {
	private SessionInfo user;
	private Term currTerm;
	private ArrayList<ArrayList<Integer>> offerings;
	private Filter filter;
	
	//added
	private Term[] userTerms;
	
	/*
	public void update(Action a, Integer i, SessionInfo uho){
		if (a.equals(Add))){ uho.addClass(i);}
		else if (a.equals(Remove)){ uho.removeClass(i))}
		else{ uho.term=Term(i) )
	}
	*/
	
	public DragonCourseScheduler(SessionInfo sessioninfo) {
		user = sessioninfo;
	}
	
	public SessionInfo getSessionInfo() {
		return user;
	}
	
	public void updateAdd (Integer i) {
		addClass(i);
	}
	
	public void updateRemove(Integer i) {
		removeClass(i);
	}
	
	public void updateMajor(String major) {
		String result = "";
		Integer chartoint = null;
		char[] charArray = major.toUpperCase().toCharArray();
		for (char majorchar : charArray) {
			chartoint = Character.getNumericValue(majorchar)-9;
			if (chartoint < 10) {
				result += 0 + chartoint;
			}
			else {
				result += chartoint;
			}
		}
		setMajor(Integer.parseInt(result));
	}

	public void updateHistory(String s) {
		parseHistory(s);
	}

	public void updateTerms(Term[] t) {
		userTerms = t;
	}
	
	//TODO handle tracks selected by user
	
	private ArrayList<Integer> getMajors(){
		return filter.getMajors();
	}
	private ArrayList<String> getConcentrations(){
		return filter.getConcentrations();
	}
	private void setMajor(Integer i){
		user.setMajor(i);
	}
	
	private void parseHistory(String s){
		String[] classes=s.split(",");
		ArrayList<Integer> courses=new ArrayList<Integer>();
		for(String c:classes){
			String id="";
			for(char x:c.toCharArray()){
				if(Character.isDigit(x)){id+=x;	}
				else{
					Integer val=x-65;//set A to 00, Z to 25;
					String n=val.toString();
					if(n.length()==1){//pad single digit values to 2 spaces
						n="0"+n;
					}
					id+=n;
				}
			}
			courses.add(Integer.parseInt(id));
		}
		user.setClasses(Past, courses);
	}
	
	private void inputFile(String s){//expects CSV input, can be over multiple lines for readability
		BufferedReader inp;
		try {
			inp = new BufferedReader(new FileReader(s));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String parseme="";
		String next="";
		boolean eof=false;
		while(!eof){
			parseme+=next;
			try {
				next=inp.readLine();
			} catch (IOException e) {
				eof=true;
			}			
		}
		parseHistory(parseme);
	}
	
	private void addClass(Integer CRN){
		user.addClass(CRN);
	}
		
	
	private void removeClass(Integer CRN){
		user.removeClass(CRN);
	}
	
	private void changeTerm(Term t){
		currTerm=t;
	}
	
}
