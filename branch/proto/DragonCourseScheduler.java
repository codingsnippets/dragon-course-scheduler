import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.ws.Action;

public class DragonCourseScheduler {
	private Term currTerm;
	private Filter filter;
	
	//added
	private Term[] userTerms;
	
	/*
	public void update(Action a, Long i, SessionInfo uho){
		if (a.equals(Add))){ uho.addClass(i);}
		else if (a.equals(Remove)){ uho.removeClass(i))}
		else{ uho.term=Term(i) )
	}
	*/
	
	public DragonCourseScheduler() {
	}
	
	public SessionInfo updateAdd (SessionInfo s, Long i) {
		return s.addClass(i);
	}
	
	public SessionInfo updateRemove (SessionInfo s, Long i) {
		
		return s.removeClass(i);
	}
	
	public SessionInfo updateTerm (SessionInfo s, Long i) {
		currTerm=(Term)i;
		return s;
	}
	
	public SessionInfo updateConcentrations(SessionInfo s, ArrayList<String> c){
		s.setConcentration(c);
		return s;
	}
	
	
	public SessionInfo updateMajor(String major) {
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
		setMajor(Integer.parseInteger(result));
	}

	public SessionInfo updateHistory(SessionInfo s, String h) {
		s.setClasses( Term.History, parseHistory(s));
		return s;
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
	private void setMajor(Long i){
		user.setMajor(i);
	}
	
	private ArrayList<Long> parseHistory(String s){
		String[] classes=s.split(",");
		ArrayList<Long> courses=new ArrayList<Long>();
		for(String c:classes){
			String id="";
			for(char x:c.toCharArray()){
				if(Character.isDigit(x)){id+=x;	}
				else{
					Long val=x-65;//set A to 00, Z to 25;
					String n=val.toString();
					if(n.length()==1){//pad single digit values to 2 spaces
						n="0"+n;
					}
					id+=n;
				}
			}
			courses.add(Long.parseInt(id));
		}
		return courses;
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
	
	private void addClass(Long CRN){
		user.addClass(CRN);
	}
		
	
	private void removeClass(Long CRN){
		user.removeClass(CRN);
	}
	
	private void changeTerm(Term t){
		currTerm=t;
	}
	
}
