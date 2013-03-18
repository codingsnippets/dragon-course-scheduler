import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.ws.Action;

public class DragonCourseScheduler {
	
	public DragonCourseScheduler() {
	}
	
	public static SessionInfo updateAdd (SessionInfo s, Integer i) {
		s.addClass(i);
		return s;
		}
	
	public static SessionInfo updateRemove (SessionInfo s, Integer i) {
		s.removeClass(i);
		return s;
	}
	
	public static SessionInfo setTerms (SessionInfo s, Term[] i) {
		s.planTerm = i;
		s.termOfferings=Filter.getClasses(i[0], s);
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
		return Filter.getMajors();
	}
	private ArrayList<String> getConcentrations(String s){
		return Filter.getConcentrations(s);
	}
	private void setMajor(SessionInfo user, String s){
		user.setMajor(s);
	}
	
	private static ArrayList<Schedule> parseHistory(String s){
		ArrayList<Schedule> hist=new ArrayList<Schedule>();
		if (!s.isEmpty()) {
			String[] classes=s.split(",");
			for(String l:classes){
				Schedule x = new Schedule();
				int len=l.length();
				x.Course_no=Integer.parseInt(l.substring(len-3));
				x.Subject=l.substring(0,len-4).toUpperCase();
				hist.add(x);
			}
		}
		return hist;
	}
	/*
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
	*/
	
	private void addClass(SessionInfo user,Integer CRN){
		user.addClass(CRN);
	}
	
	private void removeClass(SessionInfo user, Integer CRN){
		user.removeClass(CRN);
	}
	
}
