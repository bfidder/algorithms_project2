
public class EasyClass implements Class {

	@Override
	public double calcGrade(int hours) {
		if(50* hours > 100)
		{
			return 100.0;
		}
		else
		{
			return 50.0*hours;
		}
	}
	
	public String toString()
	{
		return "Easy Class";
	}

}
