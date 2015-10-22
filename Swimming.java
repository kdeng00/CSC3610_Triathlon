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
		generatedTime = (1) + (Math.random()*60);
		generatedTime = Math.round(generatedTime * 100)/100.0;
	}
	//Returns the generated random time
	public double randomTime()
	{
		return generatedTime;
	}
}
