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
	
	private double bikeTimeInMinutes; //This is used for converting the double into something legible
	private double bikeTimeInSeconds; //This is used for converting the double into something legible
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
	
	//Generates a random time
	public void generateRandomTime()
	{
		generatedTime = 0 + (Math.random()*40);
		generatedTime = Math.round(generatedTime * 100)/100.0;
	}
	//Returns the generated random time
	public double randomTime()
	{
		return generatedTime;
	}
}
