package tryMe;



public class Swimming
{
	public Swimming()
	{
		
	}
	public Swimming(double swimTimeInMinutes, double swimTimeInSeconds)
	{
		this.swimTimeInMinutes = swimTimeInMinutes;
		this.swimTimeInSeconds = swimTimeInSeconds;
	}
	
	private double swimTimeInMinutes; //This is used to convert the doubles into somtething legible
	private double swimTimeInSeconds; //This is used to convert the doubles into something legible
	private double generatedTime;
	final private int fastestSwimTimeInMinutes = 10;
	
	
	public void setSwimTimeInMinutes(double minutes)
	{
		swimTimeInMinutes = minutes;
	}
	public void setSwimTimeInSeconds(double seconds)
	{
		swimTimeInSeconds = seconds;
	}
	public double getSwimTimeInMinutes()
	{
		return swimTimeInMinutes;
	}
	public double getSwimTimeInSeconds()
	{
		return swimTimeInSeconds;
	}
	
	//Generates a random time
	public void generateRandomTime()
	{
		//Generates a random time greater than or equal to 8 but less than 68
		generatedTime = (fastestSwimTimeInMinutes) + (Math.random()*60);
		generatedTime = Math.round(generatedTime * 100)/100.0; //Rounds it to the nearest place
	}
	//Returns the generated random time
	public double randomTime()
	{
		return generatedTime;
	}
}
