package tryMe;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;
import java.util.Queue;
import java.util.Comparator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Athlete extends Application
{
	public BorderPane rootLayout;
	public AnchorPane controlData;
	public Stage primaryStage;
	
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
	public static String getGender() {
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
	 * This method just assins the athlete's Data.
	 * The reason why there are so many arguments foro the method is because all of the maps are being used to assign information
	 */
	public static void assignRevised(Map<Integer, String> firstNames, Map<Integer, String> lastNames, Map<Integer, String> genders, 
			Map<Integer, String> firstNamesMale, Map<Integer, String> lastNamesMale, Map<Integer, String> gendersMale, 
			Map<Integer, String> firstNamesFemale, Map<Integer, String> lastNamesFemale, Map<Integer, String> gendersFemale, 
			int amountOfAthletes, int[] athleteNumbers)
	{
		Scanner userInput = new Scanner(System.in);
		/*
		 * Creating local variables within this method to make things easier instead of creating an instance of
		 * an object and using the the set method to set and the method to get then set the
		 */
		String firstName = ""; 
		String lastName = "";
		String gender = "";
		int athleteNumber;
		
		for (int i = 0; i < amountOfAthletes; i++)
		{
			Athlete athleteInformation = new Athlete();
			
			System.out.println("Enter First Name of the Athlete: ");
			firstName = userInput.nextLine();
			athleteInformation.setFirstName(firstName);
			
			System.out.println("Enter the Last Name of the Athlete: ");
			lastName = userInput.nextLine();
			athleteInformation.setLastName(lastName);
			
			System.out.println("Enter Male for Male and Female for Female: ");
			while (true)
			{
				gender = userInput.nextLine();
				if (gender.equals("Male") || gender.equals("male"))
				{
					athleteInformation.setGender(gender);
					break;
				}
				else if (gender.equals("Female") || gender.equals("female"))
				{
					athleteInformation.setGender(gender);
					break;
				}
				else
					System.out.println("Try again: ");
			}
			athleteNumber = athleteNumbers[i];
			athleteInformation.setAthleteNumber(""+athleteNumber);
			
			if (gender.equals("Male") || gender.equals("male"))
			{
				firstNamesMale.put(athleteNumbers[i], firstName);
				lastNamesMale.put(athleteNumbers[i], lastName);
				gendersMale.put(athleteNumbers[i], gender);
			}
			else if (gender.equals("Female") || gender.equals("females"))
			{
				firstNamesFemale.put(athleteNumbers[i], firstName);
				lastNamesFemale.put(athleteNumbers[i], lastName);
				gendersFemale.put(athleteNumbers[i], gender);
			}
			firstNames.put(athleteNumbers[i], firstName);
			lastNames.put(athleteNumbers[i], lastName);
			genders.put(athleteNumbers[i], gender);
		}
		userInput.close();
	}
	public static void swimStuff(Map<Integer, String> firstNames, Map<Integer, String> lastNames, Map<Integer, String> genders, 
			Map<Integer, String> firstNamesMale, Map<Integer, String> lastNamesMale, Map<Integer, String> gendersMale, 
			Map<Integer, String> firstNamesFemale, Map<Integer, String> lastNamesFemale, Map<Integer, String> gendersFemale, 
			Map<Integer, String> swimmingTimes, Map<Integer, String> swimmingTimesMale, Map<Integer, String> swimmingTimesFemale, 
			Map<Integer, String> bikingTimes, Map<Integer, String> bikingTimesMale, Map<Integer, String> bikingTimesFemale, 
			Map<Integer, String> runningTimes, Map<Integer, String> runningTimesMale, Map<Integer, String> runningTimesFemale, 
			Map<Integer, String> total, Map<Integer, String> totalMales, Map<Integer, String> totalFemales, 
			int amountOfAthletes, int[] athleteNumbers)
	{
		Swimming times = new Swimming();
		
		for (int i = 0; i < amountOfAthletes; i++)
		{
			times.generateRandomTime();
			if (times.randomTime() > 60)
			{
				swimmingTimes.put(athleteNumbers[i], "Disqualified");
				bikingTimes.put(athleteNumbers[i], "Disqualified");
				runningTimes.put(athleteNumbers[i], "Disqualified");
				total.put(athleteNumbers[i], "Disqualified");
			}
			else
			{
				swimmingTimes.put(athleteNumbers[i], ""+times.randomTime());
				System.out.println("Time: "+swimmingTimes.get(athleteNumbers[i]));
			}
			
			if (gendersMale.containsKey(athleteNumbers[i]) && times.randomTime() < 60)
			{
				swimmingTimesMale.put(athleteNumbers[i], ""+times.randomTime());
			}
			else if (gendersMale.containsKey(athleteNumbers[i]) && times.randomTime() > 60)
			{
				swimmingTimesMale.put(athleteNumbers[i], "Disqualified");
				bikingTimesMale.put(athleteNumbers[i], "Disqualified");
				runningTimesMale.put(athleteNumbers[i], "Disqualified");
				totalMales.put(athleteNumbers[i], "Disqualified");
			}
			else if (gendersFemale.containsKey(athleteNumbers[i]) && times.randomTime() < 60)
			{
				swimmingTimesFemale.put(athleteNumbers[i], ""+times.randomTime());
			}
			else if (gendersFemale.containsKey(athleteNumbers[i]) && times.randomTime() > 60)
			{
				swimmingTimesFemale.put(athleteNumbers[i], "Disqualified");
				bikingTimesFemale.put(athleteNumbers[i], "Disqualified");
				runningTimesFemale.put(athleteNumbers[i], "Disqualified");
				totalFemales.put(athleteNumbers[i], "Disqualified");
			}
		}
	}
	public static void bikeStuff(Map<Integer, String> firstNames, Map<Integer, String> lastNames, Map<Integer, String> genders, 
			Map<Integer, String> firstNamesMale, Map<Integer, String> lastNamesMale, Map<Integer, String> gendersMale, 
			Map<Integer, String> firstNamesFemale, Map<Integer, String> lastNamesFemale, Map<Integer, String> gendersFemale, 
			Map<Integer, String> swimmingTimes, Map<Integer, String> swimmingTimesMale, Map<Integer, String> swimmingTimesFemale, 
			Map<Integer, String> bikingTimes, Map<Integer, String> bikingTimesMale, Map<Integer, String> bikingTimesFemale, 
			Map<Integer, String> runningTimes, Map<Integer, String> runningTimesMale, Map<Integer, String> runningTimesFemale, 
			Map<Integer, String> total, Map<Integer, String> totalMales, Map<Integer, String> totalFemales, 
			int amountOfAthletes, int[] athleteNumbers)
	{
		Biking times = new Biking();
		for (int i = 0; i < amountOfAthletes; i++)
		{
			times.generateRandomTime();
			
			//System.out.println(bikingTimes.get(athleteNumbers[i]));
			if (swimmingTimes.get(athleteNumbers[i]).equals("Disqualified"))
			{
				System.out.println(bikingTimes.get(athleteNumbers[i]));
			}
			else
			{
				if (times.randomTime() > 60)
				{
					bikingTimes.put(athleteNumbers[i], "Disqualified");
					runningTimes.put(athleteNumbers[i], "Disqualified");
					total.put(athleteNumbers[i], "Disqualified");
				}
				else
				{
					bikingTimes.put(athleteNumbers[i], ""+times.randomTime());
					System.out.println("Time: "+bikingTimes.get(athleteNumbers[i]));
				}
				
				if (gendersMale.containsKey(athleteNumbers[i]) && times.randomTime() < 60)
				{
					bikingTimesMale.put(athleteNumbers[i], ""+times.randomTime());
				}
				else if (gendersMale.containsKey(athleteNumbers[i]) && times.randomTime() > 60)
				{
					bikingTimesMale.put(athleteNumbers[i], "Disqualified");
					runningTimesMale.put(athleteNumbers[i], "Disqualified");
					totalMales.put(athleteNumbers[i], "Disqualified");
				}
				else if (gendersFemale.containsKey(athleteNumbers[i]) && times.randomTime() < 60)
				{
					bikingTimesFemale.put(athleteNumbers[i], ""+times.randomTime());
				}
				else if (gendersFemale.containsKey(athleteNumbers[i]) && times.randomTime() > 60)
				{
					bikingTimesFemale.put(athleteNumbers[i], "Disqualified");
					runningTimesFemale.put(athleteNumbers[i], "Disqualified");
					totalFemales.put(athleteNumbers[i], "Disqualified");
				}
				
				//bikingTimes.put(athleteNumbers[i], ""+times.randomTime());
				//System.out.println("Not Disqualified: "+bikingTimes.get(athleteNumbers[i]));
			}
			
			//bikingTimes.put(athleteNumbers[i], ""+times.randomTime());
			//System.out.println("end: ");
			//System.out.println(swimmingTimes.get(athleteNumbers[i]));
		}
		//System.out.println("\nReal end");
	}
	public static void runStuff(Map<Integer, String> firstNames, Map<Integer, String> lastNames, Map<Integer, String> genders, 
			Map<Integer, String> firstNamesMale, Map<Integer, String> lastNamesMale, Map<Integer, String> gendersMale, 
			Map<Integer, String> firstNamesFemale, Map<Integer, String> lastNamesFemale, Map<Integer, String> gendersFemale, 
			Map<Integer, String> swimmingTimes, Map<Integer, String> swimmingTimesMale, Map<Integer, String> swimmingTimesFemale, 
			Map<Integer, String> bikingTimes, Map<Integer, String> bikingTimesMale, Map<Integer, String> bikingTimesFemale, 
			Map<Integer, String> runningTimes, Map<Integer, String> runningTimesMale, Map<Integer, String> runningTimesFemale, 
			Map<Integer, String> total, Map<Integer, String> totalMales, Map<Integer, String> totalFemales, 
			int amountOfAthletes, int[] athleteNumbers)
	{
		Running times = new Running();
		for (int i = 0; i < amountOfAthletes; i++)
		{
			times.generateRandomTime();
			
			//System.out.println(bikingTimes.get(athleteNumbers[i]));
			if (bikingTimes.get(athleteNumbers[i]).equals("Disqualified"))
			{
				System.out.println("DQ: "+runningTimes.get(athleteNumbers[i]));
			}
			else
			{
				if (times.randomTime() > 60)
				{
					runningTimes.put(athleteNumbers[i], "Disqualified");
					total.put(athleteNumbers[i], "Disqualified");
				}
				else
				{
					runningTimes.put(athleteNumbers[i], ""+times.randomTime());
					System.out.println("Time: "+runningTimes.get(athleteNumbers[i]));
				}
				
				if (gendersMale.containsKey(athleteNumbers[i]) && times.randomTime() < 60)
				{
					runningTimesMale.put(athleteNumbers[i], ""+times.randomTime());
				}
				else if (gendersMale.containsKey(athleteNumbers[i]) && times.randomTime() > 60)
				{
					runningTimesMale.put(athleteNumbers[i], "Disqualified");
					totalMales.put(athleteNumbers[i], "Disqualified");
				}
				else if (gendersFemale.containsKey(athleteNumbers[i]) && times.randomTime() < 60)
				{
					runningTimesFemale.put(athleteNumbers[i], ""+times.randomTime());
				}
				else if (gendersFemale.containsKey(athleteNumbers[i]) && times.randomTime() > 60)
				{
					runningTimesFemale.put(athleteNumbers[i], "Disqualified");
					totalFemales.put(athleteNumbers[i], "Disqualified");
				}
				
				//bikingTimes.put(athleteNumbers[i], ""+times.randomTime());
				//System.out.println("Not Disqualified: "+bikingTimes.get(athleteNumbers[i]));
			}
		}
	}
	public static void totalStuff(Map<Integer, String> firstNames, Map<Integer, String> lastNames, Map<Integer, String> genders, 
			Map<Integer, String> firstNamesMale, Map<Integer, String> lastNamesMale, Map<Integer, String> gendersMale, 
			Map<Integer, String> firstNamesFemale, Map<Integer, String> lastNamesFemale, Map<Integer, String> gendersFemale, 
			Map<Integer, String> swimmingTimes, Map<Integer, String> swimmingTimesMale, Map<Integer, String> swimmingTimesFemale, 
			Map<Integer, String> bikingTimes, Map<Integer, String> bikingTimesMale, Map<Integer, String> bikingTimesFemale, 
			Map<Integer, String> runningTimes, Map<Integer, String> runningTimesMale, Map<Integer, String> runningTimesFemale, 
			Map<Integer, String> total, Map<Integer, String> totalMales, Map<Integer, String> totalFemales, 
			int amountOfAthletes, int[] athleteNumbers)
	{
		//System.out.println("Amount of Athletes: "+amountOfAthletes);
		for (int i = 0; i < amountOfAthletes; i++)
		{
			//System.out.println("Start");
			double swimTime, bikeTime, runTime, totalTime;
			if (runningTimes.get(athleteNumbers[i]).equals("Disqualified"))
			{
				//System.out.println("DQ: "+total.get(athleteNumbers[i]));
			}
			else
			{
				swimTime = Double.parseDouble(swimmingTimes.get(athleteNumbers[i]));
				bikeTime = Double.parseDouble(bikingTimes.get(athleteNumbers[i]));
				runTime = Double.parseDouble(runningTimes.get(athleteNumbers[i]));
				totalTime = Math.round((100) * (swimTime + bikeTime + runTime))/100.0;
				total.put(athleteNumbers[i], ""+totalTime);
				//System.out.println("Total Time: "+total.get(athleteNumbers[i]));
				
				if (swimmingTimesMale.containsKey(athleteNumbers[i]))
				{
					swimTime = Double.parseDouble(swimmingTimesMale.get(athleteNumbers[i]));
					bikeTime = Double.parseDouble(bikingTimesMale.get(athleteNumbers[i]));
					runTime = Double.parseDouble(runningTimesMale.get(athleteNumbers[i]));
					totalTime = Math.round((100) * (swimTime + bikeTime + runTime))/100.0;;
					totalMales.put(athleteNumbers[i], ""+totalTime);
					//System.out.println("Males Total Time: "+totalMales.get(athleteNumbers[i]));
				}
				else if (swimmingTimesFemale.containsKey(athleteNumbers[i]))
				{
					//System.out.println(swimmingTimesFemale.get(athleteNumbers[i]));
					swimTime = Double.parseDouble(swimmingTimesFemale.get(athleteNumbers[i]));
					bikeTime = Double.parseDouble(bikingTimesFemale.get(athleteNumbers[i]));
					runTime = Double.parseDouble(runningTimesFemale.get(athleteNumbers[i]));
					totalTime = Math.round((100) * (swimTime + bikeTime + runTime))/100.0;;
					totalFemales.put(athleteNumbers[i], ""+totalTime);
					//System.out.println("Females Total Time: "+totalFemales.get(athleteNumbers[i]));
				}
				/**
				swimTime = Double.parseDouble(swimmingTimesMale.get(athleteNumbers[i]));
				bikeTime = Double.parseDouble(bikingTimesMale.get(athleteNumbers[i]));
				runTime = Double.parseDouble(runningTimesMale.get(athleteNumbers[i]));
				totalTime = swimTime + bikeTime + runTime;
				totalMales.put(athleteNumbers[i], ""+totalTime);
				System.out.println("Males Total Time: "+totalMales.get(athleteNumbers[i]));
				
				System.out.println(swimmingTimesFemale.get(athleteNumbers[i]));
				swimTime = Double.parseDouble(swimmingTimesFemale.get(athleteNumbers[i]));
				bikeTime = Double.parseDouble(bikingTimesFemale.get(athleteNumbers[i]));
				runTime = Double.parseDouble(runningTimesFemale.get(athleteNumbers[i]));
				totalTime = swimTime + bikeTime + runTime;
				totalFemales.put(athleteNumbers[i], ""+totalTime);
				System.out.println("Females Total Time: "+totalFemales.get(athleteNumbers[i]));
				*/
			}
			//System.out.println("Out of the if-else");
		}
	}
	public static void printAllAthletes(Map<Integer, String> swimmingTimes, Map<Integer, String> bikingTimes, 
			Map<Integer, String> runningTimes, Map<Integer, String> total, int[] athleteNumbers)
	{
		System.out.println(total.keySet());
		
	}
	public static void printAllAthletes(Map<Integer, String> athletesTotalTime, Map<Integer, String> firstNames, Map<Integer, String> lastNames, 
			Map<Integer, String> genders, Map<Integer, String> swimmingTimes, Map<Integer, String> bikingTimes, Map<Integer, String> runningTimes)
	{
		int[] gs = new int[athletesTotalTime.size()];
		int i = 0;
		//System.out.println(athletesTotalTime.keySet());
		Set<Integer> array =  athletesTotalTime.keySet();
		Iterator<Integer> blah = array.iterator();
		while (blah.hasNext())
		{
			gs[i] = (int) blah.next();
			i++;
		}
		
		for (int j = 0; j < (athletesTotalTime.size()); j++)
		{
			//System.out.println("Keys: " +gs[j]);
			
			System.out.println("First Name: " + firstNames.get(gs[j]) + " Last Name: " + lastNames.get(gs[j]) + " Gender: " + genders.get(gs[j]) + " Swimming: " + 
			swimmingTimes.get(gs[j]) + " Biking: " + bikingTimes.get(gs[j]) + " Running: " + 
					runningTimes.get(gs[j]) + " Total: " + athletesTotalTime.get(gs[j]));
					
		}
		
		/**
		
		for (Map.Entry<Integer, String> entry : athletesTotalTime.entrySet()) {
			System.out.println("[Key] : " + entry.getKey() 
                                      + " [Value] : " + entry.getValue());
		}
		*/
	}
	
	public static void main(String[] args)
	{
	
		//final int dataEntries = 4;
		//final int numberOfAthletes = 4;
		
		int amountOfAthletes =3;
		int[] athleteNumbers = new int[amountOfAthletes];
		
		Map<Integer, String> firstNames, lastNames, genders, firstNamesMale, lastNamesMale, 
		gendersMale, firstNamesFemale, lastNamesFemale, gendersFemale; 
		Map<Integer, String> swimmingTimes, swimmingTimesMale, 
		swimmingTimesFemale, bikingTimes, bikingTimesMale, bikingTimesFemale, runningTimes, runningTimesMale, 
		runningTimesFemale, total, totalMales, totalFemales;
		
		firstNames = new HashMap<Integer, String>();
		lastNames = new HashMap<Integer, String>();
		genders = new HashMap<Integer, String>();
		
		firstNamesMale = new HashMap<Integer, String>();
		lastNamesMale = new HashMap<Integer, String>();
		gendersMale = new HashMap<Integer, String>();
		
		firstNamesFemale = new HashMap<Integer, String>();
		lastNamesFemale = new HashMap<Integer, String>();
		gendersFemale = new HashMap<Integer, String>();
		
		swimmingTimes = new HashMap<Integer, String>();
		swimmingTimesMale = new HashMap<Integer, String>();
		swimmingTimesFemale = new HashMap<Integer, String>();
		
		bikingTimes = new HashMap<Integer, String>();
		bikingTimesMale = new HashMap<Integer, String>();
		bikingTimesFemale = new HashMap<Integer, String>();
		
		runningTimes = new HashMap<Integer, String>();
		runningTimesMale = new HashMap<Integer, String>();
		runningTimesFemale = new HashMap<Integer, String>();
		
		total = new HashMap<Integer, String>();
		totalMales = new HashMap<Integer, String>();
		totalFemales = new HashMap<Integer, String>();
		
		//fillItUp(athletes, numberOfAthletes, dataEntries);
		
		//print(athletes);
		
		//assign(3);
		removingZeros(athleteNumbers);
		populatingArrayWithNoDuplicates(athleteNumbers);
		//forEach(athleteNumbers);
		assignRevised(firstNames, lastNames, genders, firstNamesMale, lastNamesMale, gendersMale, 
				firstNamesFemale, lastNamesFemale, gendersFemale, amountOfAthletes, athleteNumbers);
		System.out.println("Swim: ");
		swimStuff(firstNames, lastNames, genders, firstNamesMale, lastNamesMale, gendersMale, 
				firstNamesFemale, lastNamesFemale, gendersFemale, swimmingTimes, swimmingTimesMale, 
				swimmingTimesFemale, bikingTimes, bikingTimesMale, bikingTimesFemale, runningTimes, 
				runningTimesMale, runningTimesFemale, total, totalFemales, totalMales, amountOfAthletes, 
				athleteNumbers);
		System.out.println("Bike: ");
		bikeStuff(firstNames, lastNames, genders, firstNamesMale, lastNamesMale, gendersMale, 
				firstNamesFemale, lastNamesFemale, gendersFemale, swimmingTimes, swimmingTimesMale, 
				swimmingTimesFemale, bikingTimes, bikingTimesMale, bikingTimesFemale, runningTimes, 
				runningTimesMale, runningTimesFemale, total, totalFemales, totalMales, amountOfAthletes, 
				athleteNumbers);
		System.out.println("Run: ");
		runStuff(firstNames, lastNames, genders, firstNamesMale, lastNamesMale, gendersMale, 
				firstNamesFemale, lastNamesFemale, gendersFemale, swimmingTimes, swimmingTimesMale, 
				swimmingTimesFemale, bikingTimes, bikingTimesMale, bikingTimesFemale, runningTimes, 
				runningTimesMale, runningTimesFemale, total, totalFemales, totalMales, amountOfAthletes, 
				athleteNumbers);
		System.out.println("Total: ");
		totalStuff(firstNames, lastNames, genders, firstNamesMale, lastNamesMale, gendersMale, 
				firstNamesFemale, lastNamesFemale, gendersFemale, swimmingTimes, swimmingTimesMale, 
				swimmingTimesFemale, bikingTimes, bikingTimesMale, bikingTimesFemale, runningTimes, 
				runningTimesMale, runningTimesFemale, total, totalFemales, totalMales, amountOfAthletes, 
				athleteNumbers);
		
		//printAllAthletes(swimmingTimes, bikingTimes, runningTimes, total);
		//System.out.println(firstNames.values());
		Map<Integer, String> sortedTotal = sortMap(total);
		//printAllAthletes(swimmingTimes, bikingTimes, runningTimes, total);

		/**
		List<Map.Entry<Integer, String>> l = new ArrayList<Map.Entry<Integer, String>>(total.entrySet());
		Collections.sort(l, new Comparator<Object>()
		{
			@Override
			public int compare(Object one, Object two)
			{
				@SuppressWarnings("unchecked")
				Map.Entry<Integer, String> uno = (Map.Entry<Integer, String>) one;
				@SuppressWarnings("unchecked")
				Map.Entry<Integer, String> dos = (Map.Entry<Integer, String>) two;
				return uno.getValue().compareTo(dos.getValue());
			}
		});
		*/
		
		printAllAthletes(sortedTotal, firstNames, lastNames, genders, swimmingTimes, bikingTimes, runningTimes);
		launch(args);
		
	}

	private static Map<Integer, String> sortMap(Map<Integer, String> unsorted)
	{
		List<Map.Entry<Integer, String>> list = new LinkedList<Map.Entry<Integer, String>>(unsorted.entrySet());
		
		Collections.sort(list, new Comparator<Map.Entry<Integer, String>>() 
				{
					@Override
					public int compare(Map.Entry<Integer, String> one, Map.Entry<Integer, String> two)
					{
						return (one.getValue()).compareTo(two.getValue());
					}
				});
		Map<Integer, String> sorted = new LinkedHashMap<Integer, String>();
		for (Iterator<Map.Entry<Integer, String>> it = list.iterator(); it.hasNext();) 
		{
			Map.Entry<Integer, String> entry = it.next();
			sorted.put(entry.getKey(), entry.getValue());
		}
		return sorted;
	}
	
	public static void forEach(int[] ar)
	{
		for (Object ob: ar)
		{
			System.out.println(ob);
		}
	}
		@Override
		public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Triatholon Prjoect Demo");
		
		//initializeRootLayout();
		//showControlsData();

		
	}
		
	
	private void showControlsData() {
		FXMLLoader load = new FXMLLoader();
		load.setLocation(Athlete.class.getResource("Athlete_Controller.fxml"));
		
		try {
			controlData = (AnchorPane)load.load();
		}
		catch(IOException exc) {
			exc.printStackTrace();
		}
		rootLayout.setCenter(controlData);
	}
	private void initializeRootLayout() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Athlete.class.getResource("RootLayout.fxml"));
		
		try {
			rootLayout = (BorderPane)loader.load();
		}
		catch(IOException exc) {
			exc.printStackTrace();
		}
		Scene scn = new Scene(rootLayout);
		primaryStage.setScene(scn);
		primaryStage.show();
	
		
		
	}
	
}
