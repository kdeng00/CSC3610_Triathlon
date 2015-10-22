package tryMe;



public class Running
{
	
	public Running()
	{
		
	}
	public Running(double runningTimeInMinutes, double runningTimeInSeconds)
	{
		this.runningTimeInMinutes = runningTimeInMinutes;
		this.runningTimeInSeconds = runningTimeInSeconds;
	}
	
	private double runningTimeInMinutes; //This is used for converting the double into something legible
	private double runningTimeInSeconds; //This is used for converting the double into something legible
	private double generatedTime;
	
	
	public void setRunningTimeInMinutes(double minutes)
	{
		runningTimeInMinutes = minutes;
	}
	public void setRunningTimeInSeconds(double seconds)
	{
		runningTimeInSeconds = seconds;
	}
	public double getRunningTimeInMinutes()
	{
		return runningTimeInMinutes;
	}
	public double getRunningTimeInSeconds()
	{
		return runningTimeInSeconds;
	}
	
	//Generates the random time
	public void generateRandomTime()
	{
		generatedTime = 0 + (Math.random()*50);
		generatedTime = Math.round(generatedTime*100)/100.0;
	}
	//Returns the generated random time
	public double randomTime()
	{
		return generatedTime;
	}
}
