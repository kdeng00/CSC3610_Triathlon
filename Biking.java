package tryMe;



public class Biking
{
	
	
	
	public Biking()
	{
		
	}
	public Biking(double bikeTimeInMinutes, double bikeTimeInSeconds)
	{
		this.bikeTimeInMinutes = bikeTimeInMinutes;
		this.bikeTimeInSeconds = bikeTimeInSeconds;
	}
	
	private double bikeTimeInMinutes;
	private double bikeTimeInSeconds;
	private double generatedTime;
	
	
	public void setBikeTimeInMinutes(double minutes)
	{
		bikeTimeInMinutes = minutes;
	}
	public void setBikeTimeInSeconds(double seconds)
	{
		bikeTimeInSeconds = seconds;
	}
	public double getBikeTimeInMinutes()
	{
		return bikeTimeInMinutes;
	}
	public double getBikeTimeInSeconds()
	{
		return bikeTimeInSeconds;
	}
	
	public void generateRandomTime()
	{
		generatedTime = 0 + (Math.random()*40);
		generatedTime = Math.round(generatedTime * 100)/100.0;
	}
	public double randomTime()
	{
		return generatedTime;
	}
}
