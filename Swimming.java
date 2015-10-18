package tryMe;

import java.util.Map;
import java.util.SortedMap;

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
	
	private double swimTimeInMinutes;
	private double swimTimeInSeconds;
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
	
	public void generateRandomTime()
	{
		generatedTime = (1) + (Math.random()*60);
		generatedTime = Math.round(generatedTime * 100)/100.0;
		//System.out.println(generatedTime);
	}
	public double randomTime()
	{
		return generatedTime;
	}
}
