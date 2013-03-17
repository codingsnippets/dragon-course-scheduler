import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.ws.Action;

public class DragonCourseScheduler {
	//added
	/*
	public void update(Action a, Long i, SessionInfo uho){
		if (a.equals(Add))){ uho.addClass(i);}
		else if (a.equals(Remove)){ uho.removeClass(i))}
		else{ uho.term=Term(i) )
	}
	*/
	
	public DragonCourseScheduler() {
	}
	
	public static SessionInfo updateAdd (SessionInfo s, Long i) {
		return s.addClass(i);
	}
	
	public static SessionInfo updateRemove (SessionInfo s, Long i) {
		
		return s.removeClass(i);
	}
	
	public static SessionInfo setTerms (SessionInfo s, Term[] i) {
		s.planTerm = i;
		return s;
	}
	
	public static SessionInfo updateTerms (SessionInfo s, Term[] i) {
		userTerms = i;
		return s;
	}
	
	public static SessionInfo updateConcentrations(SessionInfo s, ArrayList<String> c){
		s.setConcentration(c);
		return s;
	}
	
	
	public static SessionInfo updateMajor(SessionInfo s, String major) {
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
		s.setMajor(Long.parseLong(result));
		return s;
		
	}

	public static SessionInfo updateHistory(SessionInfo s, String h) {
		s.setClasses( Term.History, parseHistory(h));
		return s;
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
	
	private static ArrayList<Schedule> parseHistory(String s){
		String[] classes=s.split(",");
		ArrayList<Schedule> hist=new ArrayList<Schedule>();
		for(String l:classes){
			Schedule x = new Schedule();
			int l=x.length();
			x.Course_no=l.substring(l-3);
			x.Subject=l.toUpperCase().substring(0,l-4);
			hist.add(x);
		}
		return hist;
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
