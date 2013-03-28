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
		
		//Class eecs230 = new MediumClass("eecs230");
		//classList.push(eecs230);
		
		int time = 5;
		gradeAllocation(time, classList);
		
		System.out.println("Result is... " + averages.lastKey() );
		for ( Class c : averages.get(averages.lastKey() ) )
		{
			//TODO This doesn't work either
			System.out.println("Class: " + c.toString() +" Hours: " + c.getTime()) ;
		}
	}
	
	public static TreeMap<Double, Stack<Class> > averages = new TreeMap<Double, Stack<Class> >();
	public static int counter = 0;
	public static Map<String, Double> calculations =  new TreeMap<String, Double>();
	//public static Stack<String> path = new Stack<String>();
	
	public static double gradeAllocation(int time, Stack<Class> classes)
	{
		double sum =  0;
		counter++;
		
		if (classes.size() == 1)
		{
			Class currentClass = classes.peek();
			if( ! calculations.containsKey(currentClass.toString() + ","+ time) )
			{
				calculations.put(currentClass.toString() + ","+ time, currentClass.calcGrade(time));
			}
			//path.push(currentClass.toString() + ", time to spend: " + time);
			return calculations.get(currentClass.toString() + ","+ time);
		}
		else
		{
			for(int i = 0; i <= time; i++ )
			{
				Class currentClass = classes.pop();
				//path.push(currentClass.toString() + ", time to spend: " + i);
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
				sum = grade + gradeAllocation(time-i, classes);
				classes.push(currentClass);
				averages.put(sum/3.0, classes);//TODO FIX THIS
			}
			return sum;
		}
	}

}
