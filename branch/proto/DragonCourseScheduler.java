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
		s.addClass(i);
		return s;
		}
	
	public static SessionInfo updateRemove (SessionInfo s, Long i) {
		s.removeClass(i);
		return s;
	}
	
	public static SessionInfo setTerms (SessionInfo s, Term[] i) {
		s.planTerm = i;
		return s;
	}
	
	public static SessionInfo updateTerm (SessionInfo s, Term[] i) {
		return s;
	}
	
	public static SessionInfo updateConcentrations(SessionInfo s, ArrayList<String> c){
		s.setConcentration(c);
		return s;
	}
	
	
	public static SessionInfo updateMajor(SessionInfo s, String major) {
		s.setMajor(major);
		return s;
		
	}

	public static SessionInfo updateHistory(SessionInfo s, String h) {
		s.setClasses( Term.History, parseHistory(h));
		return s;
	}
	
	private ArrayList<String> getMajors(){
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
			int len=x.length();
			x.Course_no=Integer.parseInt(l.substring(len-3));
			x.Subject=l.toUpperCase(l.substring(0,len-4);
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
	
	private  addClass(Integer CRN){
		user.addClass(CRN);
	}
	
	private void removeClass(Integer CRN){
		user.removeClass(CRN);
	}
	
}
