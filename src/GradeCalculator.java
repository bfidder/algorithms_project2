package src;

import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;


public class GradeCalculator 
{
	
	public static void main(String[] args)
	{
		Stack<Class> classList = new Stack<Class>();
		Class csci261 = new EasyClass("csci261");
		classList.push(csci261);
		
		Class csci262 = new MediumClass("csci262");
		classList.push(csci262);
		
		Class csci407 = new MediumClass("csci407");
		classList.push(csci407);
		
		Class eecs230 = new MediumClass("eecs230");
		classList.push(eecs230);
		
		int time = 14;
		gradeAllocation(time, classList);
		
		System.out.println("Result is... " + averages.get(averages.size()-1) );
		System.out.println("Traceback path:");
		for ( Work c : resultPath )
		{
			System.out.println(c);
		}
	}
	
	public static ArrayList<Double> averages = new ArrayList<Double>();
	public static Map<String, Double> calculations =  new TreeMap<String, Double>();
	public static ArrayList<Work> path = new ArrayList<Work>();
	public static ArrayList<Work> tempPath = new ArrayList<Work>();
	public static ArrayList<Work> resultPath = new ArrayList<Work>();
	public static double maxGrade = 0;
	
	public static double gradeAllocation(int time, Stack<Class> classes)
	{
		
		double sum =  0;
		
		if (classes.size() == 1)
		{
			Class currentClass = classes.peek();
			if( ! calculations.containsKey(currentClass.toString() + ","+ time) )
			{
				calculations.put(currentClass.toString() + ","+ time, currentClass.calcGrade(time));
			}
			Work work = new Work(currentClass, time);
			tempPath.add(work);
			return calculations.get(currentClass.toString() + ","+ time);
		}
		else
		{
			for(int i = 0; i <= time; i++ )
			{
				Class currentClass = classes.pop();
				Work work = new Work(currentClass, i);
				tempPath.add(work);
				double grade = 0;
				
				if( calculations.containsKey(currentClass.toString() + ","+ i) )
				{
					
					grade = calculations.get(currentClass.toString() + ","+ i);
				}
				else
				{
					grade = currentClass.calcGrade(i);
					calculations.put(currentClass.toString() + ","+ i, grade);
				}
				sum = Math.max(sum,grade + gradeAllocation(time-i, classes));
				int count = 0;
				if (path.size() == 0){
					path.addAll(tempPath);
				}
				else{
					for(int j = tempPath.size()-1; j >= 0; --j){
						path.set((path.size()-1-count), tempPath.get(j));
						count++;
					}
				}
				double sum2 = 0;
				for (Work s : path)
				{
					sum2 += s.getC().calcGrade(s.getHours());	
				}
				if (sum2 > maxGrade) {
					resultPath.clear();
					resultPath.addAll(path);
				}
				tempPath.clear();
				if (sum > maxGrade) {
					maxGrade = sum;
				    averages.add(sum/4.0);
				}
				classes.push(currentClass);
			}
			return sum;
		}
	}

}
