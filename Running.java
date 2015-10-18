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
	
	private double runningTimeInMinutes;
	private double runningTimeInSeconds;
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
	
	public void generateRandomTime()
	{
		generatedTime = 0 + (Math.random()*50);
		generatedTime = Math.round(generatedTime*100)/100.0;
	}
	public double randomTime()
	{
		return generatedTime;
	}
}
