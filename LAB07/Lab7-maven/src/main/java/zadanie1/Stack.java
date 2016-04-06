package zadanie1;

import java.util.ArrayList;
import java.util.List;

public class Stack {
	private List<Integer> start;

	public Stack() {
		start = new ArrayList<Integer>();
	}

	
	public Stack(List<Integer> list) {
		start = list;
	}


	public boolean IsEmpty(){
		if(start.isEmpty())
			return true;
		else 
			return false;
	}
	
	public int MyTop() {
		if (start.isEmpty()) {
			throw new NullPointerException();
		}
		return start.get(start.size()-1);
	}

	public void MyPush(int x) {
		start.add(x);
	}

	public void MyPop() {
		if (start.isEmpty()) {
			throw new NullPointerException();
		}
		else {
			start.remove(start.size()-1);
		} 
	}
}