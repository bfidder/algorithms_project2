import java.util.ArrayList;
import java.util.Stack;


public class GradeCalculator 
{
	
	public static void main(String[] args)
	{
		Stack<Class> classList = new Stack<Class>();
		Class csci261 = new EasyClass();
		classList.push(csci261);
		
		Class csci262 = new MediumClass();
		classList.push(csci262);
		
		Class csci407 = new MediumClass();
		classList.push(csci407);
		
		int time = 4;
		gradeAllocation(time, classList);
		
		for ( double i : averages)
		{
			System.out.println("Result of " + i);
		}
	}
	
	public static ArrayList<Double> averages = new ArrayList<Double>();
	public static int counter = 0;
	
	public static double gradeAllocation(int time, Stack<Class> classes)
	{
		System.out.println("gradeAllocation("+time+", classes)");
		double total = 0;
		counter++;
		//System.out.println(counter + " Iterations ");
		
		if (classes.size() == 1)
		{
			//System.out.println("in if");
			Class currentClass = classes.peek();
			return currentClass.calcGrade(time);
		}
		else
		{
			for(int i = 0; i <= time; i++ )
			{
				Class currentClass = classes.pop();
				System.out.println(currentClass.toString());
				System.out.println("Time" + i);
				System.out.println("Grade " + currentClass.calcGrade(i)+"\n");
				total =  currentClass.calcGrade(i)+gradeAllocation(time-i, classes);
				System.out.println(total);
				classes.push(currentClass);
				averages.add(total/3.0);
			}
			return total;
		}
	}

}
