
public class Biking extends Athlete{
	
	private double bikeTimeInMinutes; //This is used for converting the double into something legible
	private double bikeTimeInSeconds; //This is used for converting the double into something legible
	private double generatedTime;
	final private int fastestbikingTimeInMinutes = 20;
	
	public Biking() {
		
	}
	public Biking(double bikeTimeInMinutes, double bikeTimeInSeconds)
	{
		this.bikeTimeInMinutes = bikeTimeInMinutes;
		this.bikeTimeInSeconds = bikeTimeInSeconds;
	}
	
	
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
		//Generates a random time greater than or equal to 39 but less than 89
		generatedTime = fastestbikingTimeInMinutes + (Math.random() * 40);
		generatedTime = Math.round(generatedTime * 100)/100.0; //Returns a value to the hundredths position
	}
	//Returns the generated random time
	public double randomTime()
	{
		return generatedTime;
	}


}
