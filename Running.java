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
	final private int fastestRunningTimeInMinutes = 18;
	
	
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
		//generates a value greater than or equal to 18 but less than 83
		generatedTime = fastestRunningTimeInMinutes + (Math.random() * 65);
		generatedTime = Math.round(generatedTime*100)/100.0; //Rounds to the hundreth power
	}
	//Returns the generated random time
	public double randomTime()
	{
		return generatedTime;
	}
}
