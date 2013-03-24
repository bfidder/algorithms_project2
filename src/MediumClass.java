
public class MediumClass implements Class {

	@Override
	public double calcGrade(int hours) {
		if(25*hours > 100)
		{
			return 100.0;
		}
		else
		{
			return 25.0*hours;
		}
	}
	public String toString()
	{
		return "Medium Class";
	}

}
