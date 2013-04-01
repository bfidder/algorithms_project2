package src;

public class Work {
	private Class c;
	private int hours;
	
	public Work(Class c, int hours) {
		this.c = c;
		this.hours = hours;
	}
	
	public String toString() {
		return "Class: " +c.toString()+", Hours: "+hours;
	}

	public Class getC() {
		return c;
	}

	public int getHours() {
		return hours;
	}
	
	

}
