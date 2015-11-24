package ares_kheneahm;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.Queue;

import database_triatholon.Triatholon_Main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Athlete extends Application
{
	
	public Athlete()
	{
		
	}
	public Athlete(String firstName, String lastName, String gender, String athleteNumber)
	{
		Athlete.firstName = firstName;
		Athlete.lastName = lastName;
		Athlete.gender = gender;
		Athlete.athleteNumber = athleteNumber;
	}
	
	private static String firstName;
	private static String lastName;
	private static String gender;
	private static String athleteNumber;
	private static String[][] athletes;
	private static int swimTimeMinute;
	private static int swimTimeSecond;
	private static int bikeTimeMinute;
	private static int bikeTimeSecond;
	private static int runTimeMinute;
	private static int runTimeSecond;
	private static int totalTimeMinute;
	private static int totalTimeSecond;
	private static int hours;
	private static int minutes;
	private static int seconds;
	private Stage primaryStage;
	private BorderPane rootLayout;
	private AnchorPane controlData;
	
	public String[][] getAthletesData()
	{
		return athletes;
	}
	public void setAthletesData(String[][] athletes)
	{
		Athlete.athletes = athletes;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		Athlete.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		Athlete.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		Athlete.gender = gender;
	}
	public String getAthleteNumber() {
		return athleteNumber;
	}
	public void setAthleteNumber(String athleteNumber) {
		Athlete.athleteNumber = athleteNumber;
	}
	public static void setHours(double totalMinutes)
	{
		hours = (int)(totalMinutes / 60);
	}
	public static void setMinutes(double totalMinutes)
	{
		minutes = ((int) totalMinutes % 60);
	}
	public static void setSeconds(double totalMinutes)
	{
		double s = (totalMinutes - ((int)totalMinutes)) * 60;
		seconds = (int)s;
	}
	public static int getHours()
	{
		return hours;
	}
	public static int getMinutes()
	{
		return minutes;
	}
	public static int getSeconds()
	{
		return seconds;
	}
	public static void setRandomSwimTimeMinute()
	{
		swimTimeMinute = (int) (Math.random() * 23) + 7;
	}
	public static int getRandomSwimTimeMinute()
	{
		return swimTimeMinute;
	}
	public static void setRandomSwimTimeSecond()
	{
		swimTimeSecond = (int) (Math.random() * 60);
	}
	public static int getRandomSwimTimeSecond()
	{
		return swimTimeSecond;
	}
	public static void setRandomBikeTimeMinute()
	{
		bikeTimeMinute = (int) (Math.random() * 13) + 35;
	}
	public static int getRandomBikeTimeMinute()
	{
		return bikeTimeMinute;
	}
	public static void setRandomBikeTimeSecond()
	{
		bikeTimeSecond = (int) (Math.random() * 60);
	}
	public static int getRandomBikeTimeSecond()
	{
		return bikeTimeSecond;
	}
	public static void setRandomRunTimeMinute()
	{
		runTimeMinute = (int) (Math.random() * 25) + 35;
	}
	public static int getRandomRunTimeMinute()
	{
		return runTimeMinute;
	}
	public static void setRandomRunTimeSecond()
	{
		runTimeSecond = (int) (Math.random() * 60);
	}
	public static int getRandomRunTimeSecond()
	{
		return runTimeSecond;
	}
	public static void setTotalTimeMinute(int minutes, int seconds)
	{
		totalTimeMinute = minutes + (int)(seconds / 60);
	}
	public static int getTotalTimeMinute()
	{
		return totalTimeMinute;
	}
	public static void setTotalTimeSecond(int seconds)
	{
		totalTimeSecond = (seconds % 60);
	}
	public static int getTotalTimeSecond()
	{
		return totalTimeSecond;
	}
	
	public static void fillItUp(String athletes[][], int numberOfAthletes, int numberOfParameters)
	{
		Scanner userInput = new Scanner(System.in);
		
		for (int i = 0; i < numberOfAthletes; i++)
		{
			for (int j = 0; j < numberOfParameters; j++)
			{
				switch(j)
				{
				case 0:
					System.out.println("Enter the Athlete's First Name: ");
					athletes[i][j] = userInput.nextLine();
					break;
				case 1:
					System.out.println("Enter the Athlete's Last Name: ");
					athletes[i][j] = userInput.nextLine();
					break;
				case 2:
					System.out.println("Enter 0 for female and 1 for male: ");
					athletes[i][j] = userInput.nextLine();
					if (athletes[i][j].equals("0"))
					{
						athletes[i][j] = "Female";
					}
					else if (athletes[i][j].equals("1"))
					{
						athletes[i][j] = "Male";
					}
					else
						while ( !athletes[i][j].equals("0")  || !athletes[i][j].equals("1") )
						{
							System.out.println("Does not equal to 0 or 1");
							System.out.println("Try again: ");
							athletes[i][j] = userInput.nextLine();
							
							if (athletes[i][j].equals("0"))
							{
								athletes[i][j] = "Female";
								break;
							}
							else if (athletes[i][j].equals("1"))
							{
								athletes[i][j] = "Male";
								break;
							}
							else if (!athletes[i][j].equals("0") || !athletes[i][j].equals("1"))
							{
								athletes[i][j] = ""+(int)(Math.random()*10);
							}
						}
					break;
				case 3:
					athletes[i][j] =""+ (i + (int) (Math.random() * 10));
					break;
				}
			}
		}
		userInput.close();
	}
	public static void print(String athletes[][])
	{
		Arrays.sort(athletes);
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				System.out.print(athletes[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void assign(int amountOfAthletes)
	{
		Stack<Object> athletes = new Stack<>();
		Queue<Object> allAthleteQueue = new LinkedList<>();
		
		String gender = "";
		String firstName;
		String lastName;
		int athleteNumber;
		String[][] test = new String [3][8];
		boolean truStory = true;
		
		for (int i = 0; i < amountOfAthletes; i++)
		{
			List<Object> athleteInfo = new ArrayList<>();
			Scanner userInput = new Scanner(System.in);
			
			setRandomSwimTimeMinute();
			setRandomSwimTimeSecond();
			
			setRandomBikeTimeMinute();
			setRandomBikeTimeSecond();
			
			setRandomRunTimeMinute();
			setRandomRunTimeSecond();
			
			setTotalTimeMinute((getRandomSwimTimeMinute() + getRandomBikeTimeMinute() + 
					getRandomRunTimeMinute()), (getRandomSwimTimeSecond() + getRandomBikeTimeSecond() + 
					getRandomRunTimeSecond()));
			setTotalTimeSecond((getRandomSwimTimeSecond() + getRandomBikeTimeSecond() + getRandomRunTimeSecond()));
			
			test[i][0] = "" + Math.round((getTotalTimeMinute() + (getTotalTimeSecond()/60.0))*100)/100.0;
			
			System.out.println("Enter First Name: ");
			firstName = userInput.nextLine();
			test[i][1] = firstName;
			athleteInfo.add(firstName);
			
			System.out.println("Enter Last Name: ");
			lastName = userInput.nextLine();
			test[i][2] = lastName;
			athleteInfo.add(lastName);
			
			System.out.println("Enter Male for Male and Female for Female: ");
			while (truStory)
			{
				gender =  userInput.nextLine();
				if (gender.equalsIgnoreCase("Male"))
				{
					athleteInfo.add(gender);
					test[i][3] = gender;
					break;
				}
				else if (gender.equalsIgnoreCase("Female"))
				{
					athleteInfo.add(gender);
					test[i][3] = gender;
					break;
				}
				else
					System.out.println("Does not Compute");
					System.out.println("Try again: ");
			}
			athleteNumber = (int) (Math.random()*300);
			athleteInfo.add(athleteNumber);
			test[i][4] = ""+athleteNumber;
				
			athleteInfo.add(getRandomSwimTimeMinute() + ":" + getRandomSwimTimeSecond());
			athleteInfo.add(getRandomBikeTimeMinute() + ":" + getRandomBikeTimeSecond());
			athleteInfo.add(getRandomRunTimeMinute() + ":" + getRandomRunTimeSecond());
			athleteInfo.add(getTotalTimeMinute() + ":" + getTotalTimeSecond());
			
			athletes.add(athleteInfo);
			allAthleteQueue.add(athleteInfo);
			
			userInput.close();
		}
				
		Iterator<Object> itQueue = allAthleteQueue.iterator();
		Iterator<Object> itStack = athletes.iterator();
		
		System.out.println("Queue Iterator: ");
		while (itQueue.hasNext())
		{
			System.out.println(itQueue.next());
		}
		
		System.out.println("\nStack Iterator: ");
		while (itStack.hasNext())
		{
			System.out.println(itStack.next());
		}
		
		for (int j = 0; j < amountOfAthletes; j++)
		{
			Arrays.sort(test, new Comparator<String[]>() 
			{
				@Override
				public int compare(String[] one, String[] two)
				{
					String time1 = one[0];
					String time2 = two[0];
					
					return time1.compareTo(time2);
				}
			});
		}
			
		System.out.println("\nString: ");
		for (String[] ob: test)
		{
			setHours(Double.parseDouble(ob[0]));
			setMinutes(Double.parseDouble(ob[0]));
			setSeconds(Double.parseDouble(ob[0]));
			System.out.println( getHours()+ ":" + getMinutes() + ":" + getSeconds() + " " + ob[1] + " " + ob[2] + " " + ob[3] + " " + ob[4]);
		}
	}
	/*
	 * The reason for this method being here is because initially when you initialize an array
	 * all of the elements are either null or zero depending on the type of the array. In this
	 * case the array is filled with zereo's. Why is even here you ask. Well the reason is because
	 * we are checking the array for duplicates and if the array is filled with zero's then that 
	 * means the array is filled with nothing but duplicates. Randomizing the array gets us to
	 * a better start. If the array has random numbers then there is a better chance that the
	 * array does not have any duplicates and if there are less duplicates the program runs
	 * quicker.
	 */
	public static void removingZeros(int[] theArray)
	{
		for (int i = 0; i < (theArray.length); i++)
		{
			theArray[i] = (int)(Math.random()*10);
		}
	}
	//This method populates the Array with random integers that are not already apart of the array.
	public static void populatingArrayWithNoDuplicates(int[] theArray)
	{
		for (int i = 0; i < (theArray.length); i++)
		{
			theArray[i] = checkingDuplicatesInArray(theArray);
		}
	}
	//This returns a random integer that is not in the array
	public static int checkingDuplicatesInArray(int[] theArray)
	{
		int random;
		int loopItAgain; //determines if there is a duplicate number greater than 0
		
		while (true)
	        {
	            random = (int) (Math.random()*20);
	            loopItAgain = 0;
	            for (int i = 0; i < (theArray.length); i++)
	            {
	            	if (random == theArray[i])
	            	{
	            		loopItAgain++;
	            	}
	            }
	
	            if (loopItAgain == 0)
	            {
	                return random;
	            }
	        }
	}
	/* 
	 * This is the assign method revised. I didn't bother removing the original assign method because it is good to keep
	 * a history of the what has been used.
	 * This method just assigns the athlete's Data.
	 * The reason why there are so many arguments for the method is because all of the maps are being used to assign information
	 */
	public static void assignRevised(Map<Integer, String> firstNames, Map<Integer, String> lastNames, Map<Integer, String> genders, 
			Map<Integer, String> firstNamesMale, Map<Integer, String> lastNamesMale, Map<Integer, String> gendersMale, 
			Map<Integer, String> firstNamesFemale, Map<Integer, String> lastNamesFemale, Map<Integer, String> gendersFemale, 
			int amountOfAthletes, int[] athleteNumbers)
	{
		Scanner userInput = new Scanner(System.in);
		/*
		 * 
		 */
		String firstName = ""; 
		String lastName = "";
		String gender = "";
		int athleteNumber;
		
		for (int i = 0; i < amountOfAthletes; i++)
		{
			//Athlete Object to store Athlete Information and assign it within the loop
			Athlete athleteInformation = new Athlete();
			
			System.out.println("Enter First Name of the Athlete: ");
			firstName = userInput.nextLine();
			athleteInformation.setFirstName(firstName);
			
			System.out.println("Enter the Last Name of the Athlete: ");
			lastName = userInput.nextLine();
			athleteInformation.setLastName(lastName);
			
			/*
			 * The gender determines whether or not which Map the athlete goes into
			 */
			System.out.println("Male or Female: ");
			while (true)
			{
				gender = userInput.nextLine();
				if (gender.equalsIgnoreCase("Male"))
				{
					athleteInformation.setGender(gender);
					break;
				}
				else if (gender.equalsIgnoreCase("Female"))
				{
					athleteInformation.setGender(gender);
					break;
				}
				else
					System.out.println("Try again: ");
			}
			athleteNumber = athleteNumbers[i]; //Assigns an athleteNumber
			athleteInformation.setAthleteNumber(""+athleteNumber); //Concatenates the int to a String
			
			//Assigns the athletes to their corresponding Maps
			if (gender.equalsIgnoreCase("Male"))
			{
				//System.out.println("This Athlete is a male: ");
				firstNamesMale.put(athleteNumbers[i], athleteInformation.getFirstName());
				lastNamesMale.put(athleteNumbers[i], athleteInformation.getLastName());
				gendersMale.put(athleteNumbers[i], athleteInformation.getGender());
			}
			else if (gender.equalsIgnoreCase("Female"))
			{
				//System.out.println("This Athlete is a female: ");
				firstNamesFemale.put(athleteNumbers[i], athleteInformation.getFirstName());
				lastNamesFemale.put(athleteNumbers[i], athleteInformation.getLastName());
				gendersFemale.put(athleteNumbers[i], athleteInformation.getGender());
			}
			firstNames.put(athleteNumbers[i], athleteInformation.getFirstName());
			lastNames.put(athleteNumbers[i], athleteInformation.getLastName());
			genders.put(athleteNumbers[i], athleteInformation.getGender());
		}
		
		userInput.close();
	}
	/*
	 * This method takes all the Maps and adds the swimming times to the maps. If the times exceed 60 then it will
	 * Disqualify the athlete's time for the other times. That's why there are other events in this method.
	 */
	public static void swimStuff(Map<Integer, String> firstNames, Map<Integer, String> lastNames, Map<Integer, String> genders, 
			Map<Integer, String> firstNamesMale, Map<Integer, String> lastNamesMale, Map<Integer, String> gendersMale, 
			Map<Integer, String> firstNamesFemale, Map<Integer, String> lastNamesFemale, Map<Integer, String> gendersFemale, 
			Map<Integer, Double> swimmingTimes, Map<Integer, Double> swimmingTimesMale, Map<Integer, Double> swimmingTimesFemale, 
			Map<Integer, Double> bikingTimes, Map<Integer, Double> bikingTimesMale, Map<Integer, Double> bikingTimesFemale, 
			Map<Integer, Double> runningTimes, Map<Integer, Double> runningTimesMale, Map<Integer, Double> runningTimesFemale, 
			Map<Integer, Double> total, Map<Integer, Double> totalFemales, Map<Integer, Double> totalMales, 
			int amountOfAthletes, int[] athleteNumbers)
	{
		Swimming times = new Swimming(); //Instance of the swimming class to store data
		//The loop only does three loops because there are only three athletes. You can change the amount of 
		//Athletes in the main method
		for (int i = 0; i < amountOfAthletes; i++)
		{
			times.generateRandomTime(); //Generates a random time but does not return it
			
			
			 //If not greater than 60 than it assigns the time to the Map
		
			swimmingTimes.put(athleteNumbers[i], times.randomTime());
			/*
			 * The reason why this if statement is not an else-if statement and continuing from the
			 * last statement because this assigns information to the gender-specific Maps
			 * Essentially repeating the last step but for the specific Maps
			 */
			if (gendersMale.containsKey(athleteNumbers[i])) //The containsKey method checks the key if it's available
			{
				swimmingTimesMale.put(athleteNumbers[i], times.randomTime()); //Assigns the data
			}
			else if (gendersFemale.containsKey(athleteNumbers[i])) //Repeat of the beginning if Statement
			{
				swimmingTimesFemale.put(athleteNumbers[i], times.randomTime());
			}
		}
	}
	/*
	 * A repeat of the previous Method, the only difference is that it checks to see if the Athlete is already
	 * disqualified and repeats the statements from the previous method
	 */
	public static void bikeStuff(Map<Integer, String> firstNames, Map<Integer, String> lastNames, Map<Integer, String> genders, 
			Map<Integer, String> firstNamesMale, Map<Integer, String> lastNamesMale, Map<Integer, String> gendersMale, 
			Map<Integer, String> firstNamesFemale, Map<Integer, String> lastNamesFemale, Map<Integer, String> gendersFemale, 
			Map<Integer, Double> swimmingTimes, Map<Integer, Double> swimmingTimesMale, Map<Integer, Double> swimmingTimesFemale, 
			Map<Integer, Double> bikingTimes, Map<Integer, Double> bikingTimesMale, Map<Integer, Double> bikingTimesFemale, 
			Map<Integer, Double> runningTimes, Map<Integer, Double> runningTimesMale, Map<Integer, Double> runningTimesFemale, 
			Map<Integer, Double> total, Map<Integer, Double> totalFemales, Map<Integer, Double> totalMales, 
			int amountOfAthletes, int[] athleteNumbers)
	{
		Biking times = new Biking(); //Biking object
		for (int i = 0; i < amountOfAthletes; i++)
		{
			
			times.generateRandomTime(); //Generates random time but does not return anything
			
		
			bikingTimes.put(athleteNumbers[i], times.randomTime());
						
			/*
			 * Gender-specific time assigning, nothing new here except for:
			 * does not disqualify the athlete for swimming because the swimming
			 * event is before the biking event. Swimming is outside of the scope.
			 */
			if (gendersMale.containsKey(athleteNumbers[i]))
			{
				bikingTimesMale.put(athleteNumbers[i], times.randomTime());
			}
			else if (gendersFemale.containsKey(athleteNumbers[i]))
			{
				bikingTimesFemale.put(athleteNumbers[i], times.randomTime());
			}
		}
	}
	//Same method with some slight changes 
	public static void runStuff(Map<Integer, String> firstNames, Map<Integer, String> lastNames, Map<Integer, String> genders, 
			Map<Integer, String> firstNamesMale, Map<Integer, String> lastNamesMale, Map<Integer, String> gendersMale, 
			Map<Integer, String> firstNamesFemale, Map<Integer, String> lastNamesFemale, Map<Integer, String> gendersFemale, 
			Map<Integer, Double> swimmingTimes, Map<Integer, Double> swimmingTimesMale, Map<Integer, Double> swimmingTimesFemale, 
			Map<Integer, Double> bikingTimes, Map<Integer, Double> bikingTimesMale, Map<Integer, Double> bikingTimesFemale, 
			Map<Integer, Double> runningTimes, Map<Integer, Double> runningTimesMale, Map<Integer, Double> runningTimesFemale, 
			Map<Integer, Double> total, Map<Integer, Double> totalFemales, Map<Integer, Double> totalMales, 
			int amountOfAthletes, int[] athleteNumbers)
	{
		Running times = new Running(); //Running object
		for (int i = 0; i < amountOfAthletes; i++)
		{
			times.generateRandomTime(); //Generates but does not return anything
			
			runningTimes.put(athleteNumbers[i], times.randomTime());				
			if (gendersMale.containsKey(athleteNumbers[i]))
			{
				runningTimesMale.put(athleteNumbers[i], times.randomTime());
			}
			else if (gendersFemale.containsKey(athleteNumbers[i]))
			{
				runningTimesFemale.put(athleteNumbers[i], times.randomTime());
			}
		}
	}
	//Calculates everything
	public static void totalStuff(Map<Integer, String> firstNames, Map<Integer, String> lastNames, Map<Integer, String> genders, 
			Map<Integer, String> firstNamesMale, Map<Integer, String> lastNamesMale, Map<Integer, String> gendersMale, 
			Map<Integer, String> firstNamesFemale, Map<Integer, String> lastNamesFemale, Map<Integer, String> gendersFemale, 
			Map<Integer, Double> swimmingTimes, Map<Integer, Double> swimmingTimesMale, Map<Integer, Double> swimmingTimesFemale, 
			Map<Integer, Double> bikingTimes, Map<Integer, Double> bikingTimesMale, Map<Integer, Double> bikingTimesFemale, 
			Map<Integer, Double> runningTimes, Map<Integer, Double> runningTimesMale, Map<Integer, Double> runningTimesFemale, 
			Map<Integer, Double> total, Map<Integer, Double> totalFemales, Map<Integer, Double> totalMales, 
			int amountOfAthletes, int[] athleteNumbers)
	{
		for (int i = 0; i < amountOfAthletes; i++)
		{
			double swimTime, bikeTime, runTime, totalTime;
			//If the athlete is not already disqualified then it will not calculate the data
			//You cannot calculate a String
			if (runningTimes.get(athleteNumbers[i]).equals(100.0))
			{
				System.out.println("DQ: "+total.get(athleteNumbers[i])); //This can be omitted
			}
			else
			{
				/*
				 * Since the Maps have values of the String type it has to be parsed into a double
				 * then assigned to a double variable and calculated
				 */
				swimTime = (swimmingTimes.get(athleteNumbers[i]));
				bikeTime = (bikingTimes.get(athleteNumbers[i]));
				runTime = (runningTimes.get(athleteNumbers[i]));
				totalTime = Math.round((100.0) * (swimTime + bikeTime + runTime))/100.0; //A number to the hundreths place
				total.put(athleteNumbers[i], totalTime); //Assigns that time to the total Map
				
				if (swimmingTimesMale.containsKey(athleteNumbers[i])) //Calculates the times for the males
				{
					swimTime = (swimmingTimesMale.get(athleteNumbers[i]));
					bikeTime = (bikingTimesMale.get(athleteNumbers[i]));
					runTime = (runningTimesMale.get(athleteNumbers[i]));
					totalTime = Math.round((100) * (swimTime + bikeTime + runTime))/100.0;;
					totalMales.put(athleteNumbers[i], totalTime);
				}
				else if (swimmingTimesFemale.containsKey(athleteNumbers[i])) //Calculates the times for the females
				{
					swimTime = (swimmingTimesFemale.get(athleteNumbers[i]));
					bikeTime = (bikingTimesFemale.get(athleteNumbers[i]));
					runTime = (runningTimesFemale.get(athleteNumbers[i]));
					totalTime = Math.round((100) * (swimTime + bikeTime + runTime))/100.0;;
					totalFemales.put(athleteNumbers[i], totalTime);
				}
			}
		}
	}
	public static void printAllAthletes(Map<Integer, Double> athletesTotalTime, Map<Integer, String> firstNames, Map<Integer, String> lastNames, 
			Map<Integer, String> genders, Map<Integer, Double> swimmingTimes, Map<Integer, Double> bikingTimes, Map<Integer, Double> runningTimes, 
			int[] gs, int zero)
	{
		if (athletesTotalTime.size() >= 1)
		{
			if (swimmingTimes.get(gs[0]) >= 60 || bikingTimes.get(gs[0]) >= 60 || runningTimes.get(gs[0]) >= 60)
			{
				System.out.println("All " + genders.get(gs[0]) + " are disqualified");
			}
			else
			{			
				System.out.println("First Name: " + firstNames.get(gs[0]) + " Last Name: " + lastNames.get(gs[0]) + " Gender: " + genders.get(gs[0]) + 
						" Athlete Number: " + gs[0] + " Swimming: " + 
				change(swimmingTimes.get(gs[0])) + " Biking: " + change(bikingTimes.get(gs[0])) + " Running: " + 
						change(runningTimes.get(gs[0])) + " Total: " + change(athletesTotalTime.get(gs[0])));
			}
		}
		else
			System.out.println("No " + genders.get(gs[0]) + " athletes entered");
		
	}
	//Prints the data
	public static void printAllAthletes(Map<Integer, Double> athletesTotalTime, Map<Integer, String> firstNames, Map<Integer, String> lastNames, 
			Map<Integer, String> genders, Map<Integer, Double> swimmingTimes, Map<Integer, Double> bikingTimes, Map<Integer, Double> runningTimes, 
			int[] gs) 
	{

		Set<Integer> dq = new HashSet<Integer>();
	
		System.out.println("All Athletes: \n");
		//Prints the data, all of it.
		for (int j = 0; j < (athletesTotalTime.size()); j++)
		{
			if (swimmingTimes.get(gs[j]) >= 60 || bikingTimes.get(gs[j]) >= 60 || runningTimes.get(gs[j]) >= 60)
			{
				dq.add(gs[j]);
			}
			else
			{
				System.out.println("First Name: " + firstNames.get(gs[j]) + " Last Name: " + lastNames.get(gs[j]) + " Gender: " + genders.get(gs[j]) + 
					" Athlete Number: " + gs[j] + " Swimming: " + 
			change(swimmingTimes.get(gs[j])) + " Biking: " + change(bikingTimes.get(gs[j])) + " Running: " + 
					change(runningTimes.get(gs[j])) + " Total: " + change(athletesTotalTime.get(gs[j])));
			}
			
				
		}
		Iterator<Integer> ii = dq.iterator();
		while (ii.hasNext())
		{
			int t = ii.next();
			System.out.println("First Name: " + firstNames.get(t) + " Last Name: " + lastNames.get(t) + " Gender: " + genders.get(t) + 
					" Athlete Number: " + t + " Swimming: " + 
			"Disqualified " + " Biking: " + "Disqualified " + " Running: " + 
					"Disqualified " + " Total: " + "Disqualified");
		}
	}
	
	public static void main(String[] args) throws SQLException
	{
		Scanner userInput = new Scanner(System.in);
		
		System.out.print("How much athletes will there be: ");
		
		int amountOfAthletes = userInput.nextInt(); //You can change the amount of athletes here.
		int[] athleteNumbers = new int[amountOfAthletes]; //Empty athlete numbers
		int[] correctedAthleteNumbers = new int[amountOfAthletes];
		
		
		//Creating Map Objects
		Map<Integer, String> firstNames, lastNames, genders, firstNamesMale, lastNamesMale, 
		gendersMale, firstNamesFemale, lastNamesFemale, gendersFemale; 
		Map<Integer, Double> swimmingTimes, swimmingTimesMale, 
		swimmingTimesFemale, bikingTimes, bikingTimesMale, bikingTimesFemale, runningTimes, runningTimesMale, 
		runningTimesFemale, total, totalMales, totalFemales;
		
		//Initializing the Maps of the <Integer, String type because the athlete number is an integer
		//and the value is a String - time and Disqualification
		firstNames = new HashMap<Integer, String>();
		lastNames = new HashMap<Integer, String>();
		genders = new HashMap<Integer, String>();
		
		firstNamesMale = new HashMap<Integer, String>();
		lastNamesMale = new HashMap<Integer, String>();
		gendersMale = new HashMap<Integer, String>();
		
		firstNamesFemale = new HashMap<Integer, String>();
		lastNamesFemale = new HashMap<Integer, String>();
		gendersFemale = new HashMap<Integer, String>();
		
		swimmingTimes = new HashMap<Integer, Double>();
		swimmingTimesMale = new HashMap<Integer, Double>();
		swimmingTimesFemale = new HashMap<Integer, Double>();
		
		bikingTimes = new HashMap<Integer, Double>();
		bikingTimesMale = new HashMap<Integer, Double>();
		bikingTimesFemale = new HashMap<Integer, Double>();
		
		runningTimes = new HashMap<Integer, Double>();
		runningTimesMale = new HashMap<Integer, Double>();
		runningTimesFemale = new HashMap<Integer, Double>();
		
		total = new HashMap<Integer, Double>();
		totalMales = new HashMap<Integer, Double>();
		totalFemales = new HashMap<Integer, Double>();
		
		//Old
		//fillItUp(athletes, numberOfAthletes, dataEntries);
		//Old
		//print(athletes);
		
		//Old assign method
		//assign(3);
		removingZeros(athleteNumbers); //Removes the zeros of the array
		populatingArrayWithNoDuplicates(athleteNumbers); //Populate the array with random numbers
		
		//Used for debugging, just to print the array
		//forEach(athleteNumbers);
		//Invoking the assignRevised method
		assignRevised(firstNames, lastNames, genders, firstNamesMale, lastNamesMale, gendersMale, 
				firstNamesFemale, lastNamesFemale, gendersFemale, amountOfAthletes, athleteNumbers);
		
		//Invoking the swimStuff method
		swimStuff(firstNames, lastNames, genders, firstNamesMale, lastNamesMale, gendersMale, 
				firstNamesFemale, lastNamesFemale, gendersFemale, swimmingTimes, swimmingTimesMale, 
				swimmingTimesFemale, bikingTimes, bikingTimesMale, bikingTimesFemale, runningTimes, 
				runningTimesMale, runningTimesFemale, total, totalFemales, totalMales, amountOfAthletes, 
				athleteNumbers);
		
		//Invoking the bikeStuff method
		bikeStuff(firstNames, lastNames, genders, firstNamesMale, lastNamesMale, gendersMale, 
				firstNamesFemale, lastNamesFemale, gendersFemale, swimmingTimes, swimmingTimesMale, 
				swimmingTimesFemale, bikingTimes, bikingTimesMale, bikingTimesFemale, runningTimes, 
				runningTimesMale, runningTimesFemale, total, totalFemales, totalMales, amountOfAthletes, 
				athleteNumbers);
		
		//Invoking the runStuff method
		runStuff(firstNames, lastNames, genders, firstNamesMale, lastNamesMale, gendersMale, 
				firstNamesFemale, lastNamesFemale, gendersFemale, swimmingTimes, swimmingTimesMale, 
				swimmingTimesFemale, bikingTimes, bikingTimesMale, bikingTimesFemale, runningTimes, 
				runningTimesMale, runningTimesFemale, total, totalFemales, totalMales, amountOfAthletes, 
				athleteNumbers);
		
		//Invoking the totalStuff method
		totalStuff(firstNames, lastNames, genders, firstNamesMale, lastNamesMale, gendersMale, 
				firstNamesFemale, lastNamesFemale, gendersFemale, swimmingTimes, swimmingTimesMale, 
				swimmingTimesFemale, bikingTimes, bikingTimesMale, bikingTimesFemale, runningTimes, 
				runningTimesMale, runningTimesFemale, total, totalFemales, totalMales, amountOfAthletes, 
				athleteNumbers);
		
		//System.out.println("Males : " + totalMales.size() + " Females: " + totalFemales.size());
		
		int[] correctedAthleteNumbersMale = new int[totalMales.size()];
		int[] correctedAthleteNumbersFemale = new int[totalFemales.size()];
		
		//Debugging stuff
		//printAllAthletes(swimmingTimes, bikingTimes, runningTimes, total);
		//System.out.println(firstNames.values());
		
		//Created a Map with the sorted times
		Map<Integer, Double> sortedTotal = sortMap(total);
		Map<Integer, Double> sortedTotalMale = sortMap(totalMales);
		Map<Integer, Double> sortedTotalFemale = sortMap(totalFemales);
		
		
		sortedTotal = swap(total, sortedTotal, athleteNumbers, correctedAthleteNumbers);
		sortedTotalMale = swap(totalMales, sortedTotalMale, athleteNumbers, correctedAthleteNumbersMale);
		sortedTotalFemale = swap(totalFemales, sortedTotalFemale, athleteNumbers, correctedAthleteNumbersFemale);
		

		printAllAthletes(sortedTotal, firstNames, lastNames, genders, swimmingTimes, bikingTimes, runningTimes, correctedAthleteNumbers);
		
//		System.out.println("\nTop Male: ");
//		printAllAthletes(sortedTotalMale, firstNamesMale, lastNamesMale, gendersMale, swimmingTimesMale, bikingTimesMale, runningTimesMale, correctedAthleteNumbersMale, 0);
//		
//		System.out.println("\nTop Female: ");
//		printAllAthletes(sortedTotalFemale, firstNamesFemale, lastNamesFemale, gendersFemale, swimmingTimesFemale, bikingTimesFemale, runningTimesFemale, correctedAthleteNumbersFemale, 0);
		
		
		insertAllAthletes(sortedTotal, firstNames, lastNames, genders, swimmingTimes, bikingTimes, runningTimes, correctedAthleteNumbers);
//		insertAllAthletes(sortedTotalFemale, firstNamesFemale, lastNamesFemale, gendersFemale, swimmingTimesFemale, bikingTimesFemale, runningTimesFemale, correctedAthleteNumbersFemale, 0);

		
		launch(args);
	}

	private static void insertAllAthletes(Map<Integer, Double> sortedTotalTime,
			Map<Integer, String> firstNames,
			Map<Integer, String> lastNames,
			Map<Integer, String> genders,
			Map<Integer, Double> swimmingTimes,
			Map<Integer, Double> bikingTimes,
			Map<Integer, Double> runningTimes,
			int[] correctedAthleteNumbers) throws SQLException {
		
		Connection csc3610conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ath_info", "root", "password");
		for (int j = 0; j < (sortedTotalTime.size()); j++) {
			if (sortedTotalTime.size() >= 1)
		{
			if (swimmingTimes.get(correctedAthleteNumbers[j]) >= 60 || bikingTimes.get(correctedAthleteNumbers[j]) >= 60 || runningTimes.get(correctedAthleteNumbers[j]) >= 60)
			{
				if (genders.get(correctedAthleteNumbers[j]).equalsIgnoreCase("Male")) {
				String query = "INSERT INTO male_info (FirstName, LastName, Number, RunTime, BikeTime, SwimTime, TotalTime, Gender)" +
						"Values(?,?,?,?,?,?,?,?)";
				PreparedStatement stmt = csc3610conn.prepareStatement(query);
				stmt.setString(1, firstNames.get(correctedAthleteNumbers[j]));
				stmt.setString(2, lastNames.get(correctedAthleteNumbers[j]));
				stmt.setLong(3, correctedAthleteNumbers[j]);
				stmt.setString(4, "Disqualified");
				stmt.setString(5, "Disqualified");
				stmt.setString(6, "Disqualified");
				stmt.setString(6, "Disqualified");
				stmt.setString(8, genders.get(correctedAthleteNumbers[j]));
				}
				if (genders.get(correctedAthleteNumbers[j]).equalsIgnoreCase("Female")) {
					String query = "INSERT INTO female_info (FirstName, LastName, Number, RunTime, BikeTime, SwimTime, TotalTime, Gender)" +
							"Values(?,?,?,?,?,?,?,?)";
					PreparedStatement stmt = csc3610conn.prepareStatement(query);
					stmt.setString(1, firstNames.get(correctedAthleteNumbers[j]));
					stmt.setString(2, lastNames.get(correctedAthleteNumbers[j]));
					stmt.setLong(3, correctedAthleteNumbers[j]);
					stmt.setString(4, "Disqualified");
					stmt.setString(5, "Disqualified");
					stmt.setString(6, "Disqualified");
					stmt.setString(6, "Disqualified");
					stmt.setString(8, genders.get(correctedAthleteNumbers[j]));
				}

				}
			else
			{			
				if (genders.get(correctedAthleteNumbers[j]).equalsIgnoreCase("Male")) {
				String query = "INSERT INTO male_info (FirstName, LastName, Number, RunTime, BikeTime, SwimTime, TotalTime, Gender)" +
						"Values(?,?,?,?,?,?,?,?)";
				PreparedStatement stmt = csc3610conn.prepareStatement(query);
				stmt.setString(1, firstNames.get(correctedAthleteNumbers[j]));
				stmt.setString(2, lastNames.get(correctedAthleteNumbers[j]));
				stmt.setLong(3, correctedAthleteNumbers[j]);
				stmt.setString(4, change(runningTimes.get(correctedAthleteNumbers[j])));
				stmt.setString(5, change(bikingTimes.get(correctedAthleteNumbers[j])));
				stmt.setString(6, change(swimmingTimes.get(correctedAthleteNumbers[j])));
				stmt.setString(7, change(sortedTotalTime.get(correctedAthleteNumbers[j])));
				stmt.setString(8, "Male");
		
				stmt.execute();
				

				}
				if (genders.get(correctedAthleteNumbers[j]).equalsIgnoreCase("Female")) {
					String query = "INSERT INTO female_info (FirstName, LastName, Number, RunTime, BikeTime, SwimTime, TotalTime, Gender)" +
							"Values(?,?,?,?,?,?,?,?)";
					PreparedStatement stmt = csc3610conn.prepareStatement(query);
					stmt.setString(1, firstNames.get(correctedAthleteNumbers[j]));
					stmt.setString(2, lastNames.get(correctedAthleteNumbers[j]));
					stmt.setLong(3, correctedAthleteNumbers[j]);
					stmt.setString(4, change(runningTimes.get(correctedAthleteNumbers[j])));
					stmt.setString(5, change(bikingTimes.get(correctedAthleteNumbers[j])));
					stmt.setString(6, change(swimmingTimes.get(correctedAthleteNumbers[j])));
					stmt.setString(7, change(sortedTotalTime.get(correctedAthleteNumbers[j])));
					stmt.setString(8, "Female");
					
					stmt.execute();

				}
					
			}
		}
		}
		
	}
		
		

		
	
	private static Map<Integer, Double> sortMap(Map<Integer, Double> unsorted)
	{
		List<Double> list = new ArrayList<Double>(unsorted.values());
		
		
		Collections.sort(list, new Comparator<Double>() 
				{

					@Override
					public int compare(Double o1, Double o2) {
						return o1.compareTo(o2);
					}
				});
		
		Map<Integer, Double> sorted = new HashMap<Integer, Double>();
		int j = 0;
		for (Iterator<Double> it = list.iterator(); it.hasNext();) 
		{
			sorted.put(j, it.next());
			j++;
		}
		
		return sorted;
	}
	public static Map<Integer, Double>swap(Map<Integer,Double> unsorted, Map<Integer, Double> sorted, int array[], int[] arIn)
	{
		
		List<Map.Entry<Integer, Double>> lisp = new ArrayList<Map.Entry<Integer, Double>>(sorted.entrySet());
		
		int i = 0;
		Map<Integer, Double> newThis = new HashMap<Integer, Double>();
		for (Iterator<Map.Entry<Integer, Double>> jam = lisp.iterator(); jam.hasNext();)
		{
			Map.Entry<Integer, Double> entry = jam.next();
			
			int iterate = 0;
			
			while (true)
			{
				if (unsorted.get(array[iterate]) == (entry.getValue()))
				{
					
					newThis.put(array[iterate], entry.getValue());
					arIn[i] = array[iterate];
					i++;
					break;
				}
				else
					iterate++;	
			}
		}
		return newThis;
	}
	
	//To go through an integer array
	public static void forEach(int[] ar)
	{
		for (Object ob: ar)
		{
			System.out.println(ob);
		}
	}

	public static String change(double eventTime)
	{
		double time;
		time = (eventTime);
		
		//Let us say that time is equal to 135.6
		int hours;
		int minutes;
		double seconds;
	
		hours = (int)(time / 60); //Would be 2
		time = time % 60; //Would be 15.8
		minutes = (int) (time); //Would be 15
		time = time - minutes; //Would be .8
		seconds = Math.round(time * 60 * 100)/100.0;
		
		if (hours >= 1 && minutes < 10 && seconds < 10)
		{
			return hours + ":" + "0" + minutes + ":" + "0" + seconds;
		}
		else if (hours >= 1 && minutes >= 10 && seconds < 10)
		{
			return hours + ":" + minutes + ":" + "0" + seconds;
		}
		else if (hours >= 1 && minutes < 10 && seconds >= 10)
		{
			return hours + ":" + "0" + minutes + ":" + seconds;
		}
		else if (hours == 0 && seconds < 10)
		{
			return minutes + ":" + "0" + seconds;
		}
		else if (hours == 0 && seconds >= 10)
		{
			return minutes + ":" + seconds;
		}
		else
		{
			return hours + ":" + minutes + ":" + seconds;
		}
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Triatholon Results");

		
		initializeRoot();
		showControlsData();
	}
	private void showControlsData() {
		FXMLLoader load = new FXMLLoader();
		load.setLocation(Athlete.class.getResource("ControlData.fxml"));
		
		try {
			controlData = (AnchorPane)load.load();
		}
		catch (IOException exc) {
			exc.printStackTrace();
		}
		rootLayout.setCenter(controlData);
	}
	private void initializeRoot() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Athlete.class.getResource("RootLayout.fxml"));
		
		try{
			rootLayout = (BorderPane)loader.load();
		}
		catch(IOException exc) {
			exc.printStackTrace();
		}
//		rootLayout.setCenter(staffTable);
		Scene scn = new Scene(rootLayout);
		primaryStage.setScene(scn);
		primaryStage.show();
	}
	
}
