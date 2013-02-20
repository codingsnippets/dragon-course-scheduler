import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class UHO{};
class Term{};
class Filter{

	public ArrayList<Integer> getMajors() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<String> getConcentrations() {
		// TODO Auto-generated method stub
		return null;
	}};
public class DragonCourseScheduler {
	private UHO user;
	private Term currTerm;
	private ArrayList<ArrayList<Integer>> offerings;
	private Filter filter;
	
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
