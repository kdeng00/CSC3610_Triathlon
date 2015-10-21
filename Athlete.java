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
			athleteNumber = athleteNumbers[i]; //Assigns an athleteNumber
			athleteInformation.setAthleteNumber(""+athleteNumber); //Concatenates the int to a String
			
			//Assigns the athletes to their corresponding Maps
			if (gender.equals("Male") || gender.equals("male")
			{
				firstNamesMale.put(athleteNumbers[i], athleteInformation.getFirstName);
				lastNamesMale.put(athleteNumbers[i], athleteInformation.getLastName);
				gendersMale.put(athleteNumbers[i], athleteInformation.getGender);
			}
			else if (gender.equals("Female") || gender.equals("female"))
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
	/*
	 * This method takes all the Maps and adds the swimming times to the maps. If the times exceed 60 then it will
	 * Disqualify the athlete's time for the other times. That's why there are other events in this method.
	 */
	public static void swimStuff(Map<Integer, String> firstNames, Map<Integer, String> lastNames, Map<Integer, String> genders, 
			Map<Integer, String> firstNamesMale, Map<Integer, String> lastNamesMale, Map<Integer, String> gendersMale, 
			Map<Integer, String> firstNamesFemale, Map<Integer, String> lastNamesFemale, Map<Integer, String> gendersFemale, 
			Map<Integer, String> swimmingTimes, Map<Integer, String> swimmingTimesMale, Map<Integer, String> swimmingTimesFemale, 
			Map<Integer, String> bikingTimes, Map<Integer, String> bikingTimesMale, Map<Integer, String> bikingTimesFemale, 
			Map<Integer, String> runningTimes, Map<Integer, String> runningTimesMale, Map<Integer, String> runningTimesFemale, 
			Map<Integer, String> total, Map<Integer, String> totalMales, Map<Integer, String> totalFemales, 
			int amountOfAthletes, int[] athleteNumbers)
	{
		Swimming times = new Swimming(); //Instance of the swimming class to store data
		//The loop only does three loops because there are only three athletes. You can change the amount of 
		//Athletes in the main method
		for (int i = 0; i < amountOfAthletes; i++)
		{
			times.generateRandomTime(); //Generates a random time but does not return it
			if (times.randomTime() >= 60) //Checks to see if the random time is greater than 60 minutes... Changed it to equal to or greater than
			{
				//Disqualifies athlete's other times
				swimmingTimes.put(athleteNumbers[i], "Disqualified");
				bikingTimes.put(athleteNumbers[i], "Disqualified");
				runningTimes.put(athleteNumbers[i], "Disqualified");
				total.put(athleteNumbers[i], "Disqualified");
			}
			else //If not greater than 60 than it assigns the time to the Map
			{
				swimmingTimes.put(athleteNumbers[i], ""+times.randomTime());
				System.out.println("Time: "+swimmingTimes.get(athleteNumbers[i]));
			}
			/*
			 * The reason why this if statement is not an else-if statement and continuing from the
			 * last statement because this assigns information to the gender-specific Maps
			 * Essentially repeating the last step but for the specific Maps
			 */
			if (gendersMale.containsKey(athleteNumbers[i]) && times.randomTime() < 60) //The containsKey method checks the key if it's available
			{
				swimmingTimesMale.put(athleteNumbers[i], ""+times.randomTime()); //Assigns the data
			}
			else if (gendersMale.containsKey(athleteNumbers[i]) && times.randomTime() >= 60) //Disqualifies Athlete
			{
				swimmingTimesMale.put(athleteNumbers[i], "Disqualified");
				bikingTimesMale.put(athleteNumbers[i], "Disqualified");
				runningTimesMale.put(athleteNumbers[i], "Disqualified");
				totalMales.put(athleteNumbers[i], "Disqualified");
			}
			else if (gendersFemale.containsKey(athleteNumbers[i]) && times.randomTime() < 60) //Repeat of the beginning if Statement
			{
				swimmingTimesFemale.put(athleteNumbers[i], ""+times.randomTime());
			}
			else if (gendersFemale.containsKey(athleteNumbers[i]) && times.randomTime() >= 60) //Repeat of the previous statment
			{
				swimmingTimesFemale.put(athleteNumbers[i], "Disqualified");
				bikingTimesFemale.put(athleteNumbers[i], "Disqualified");
				runningTimesFemale.put(athleteNumbers[i], "Disqualified");
				totalFemales.put(athleteNumbers[i], "Disqualified");
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
			Map<Integer, String> swimmingTimes, Map<Integer, String> swimmingTimesMale, Map<Integer, String> swimmingTimesFemale, 
			Map<Integer, String> bikingTimes, Map<Integer, String> bikingTimesMale, Map<Integer, String> bikingTimesFemale, 
			Map<Integer, String> runningTimes, Map<Integer, String> runningTimesMale, Map<Integer, String> runningTimesFemale, 
			Map<Integer, String> total, Map<Integer, String> totalMales, Map<Integer, String> totalFemales, 
			int amountOfAthletes, int[] athleteNumbers)
	{
		Biking times = new Biking(); //Biking object
		for (int i = 0; i < amountOfAthletes; i++)
		{
			times.generateRandomTime(); //Generates random time but does not return anything
			
			if (swimmingTimes.get(athleteNumbers[i]).equals("Disqualified")) //Checks to see if they are already disqualified
			{
				System.out.println(bikingTimes.get(athleteNumbers[i])); //This statement can be removed, I only used it for debugging
				//If the athlete is disqualified then it moves on to the next Athlete
			}
			else //If the athlete is not disqualified then it adds data
			{
				if (times.randomTime() >= 60) //Checks if the generated time is greater or equal to 60
				{
					//If greater then it disqualifies the athlete
					bikingTimes.put(athleteNumbers[i], "Disqualified");
					runningTimes.put(athleteNumbers[i], "Disqualified");
					total.put(athleteNumbers[i], "Disqualified");
				}
				else //If not then it assigns the athlete data
				{
					bikingTimes.put(athleteNumbers[i], ""+times.randomTime());
					System.out.println("Time: "+bikingTimes.get(athleteNumbers[i]));
				}
				
				/*
				 * Gender-specific time assigning, nothing new here except for:
				 * does not disqualify the athlete for swimming because the swimming
				 * event is before the biking event. Swimming is outside of the scope.
				 */
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
			}
		}
	}
	//Same method with some slight changes 
	public static void runStuff(Map<Integer, String> firstNames, Map<Integer, String> lastNames, Map<Integer, String> genders, 
			Map<Integer, String> firstNamesMale, Map<Integer, String> lastNamesMale, Map<Integer, String> gendersMale, 
			Map<Integer, String> firstNamesFemale, Map<Integer, String> lastNamesFemale, Map<Integer, String> gendersFemale, 
			Map<Integer, String> swimmingTimes, Map<Integer, String> swimmingTimesMale, Map<Integer, String> swimmingTimesFemale, 
			Map<Integer, String> bikingTimes, Map<Integer, String> bikingTimesMale, Map<Integer, String> bikingTimesFemale, 
			Map<Integer, String> runningTimes, Map<Integer, String> runningTimesMale, Map<Integer, String> runningTimesFemale, 
			Map<Integer, String> total, Map<Integer, String> totalMales, Map<Integer, String> totalFemales, 
			int amountOfAthletes, int[] athleteNumbers)
	{
		Running times = new Running(); //Running object
		for (int i = 0; i < amountOfAthletes; i++)
		{
			times.generateRandomTime(); //Generates but does not return anything
			
			if (bikingTimes.get(athleteNumbers[i]).equals("Disqualified")) //Checks to if the athlete is already disqualified
			{
				System.out.println("DQ: "+runningTimes.get(athleteNumbers[i])); //This can be omitted, only used for debugging
			}
			else //If athlete is not disqualified then it will assign data
			{
				if (times.randomTime() > 60) //If the random time is greater than or equal to 60 then it disqualifies the athlete
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
			}
		}
	}
	//Calculates everything
	public static void totalStuff(Map<Integer, String> firstNames, Map<Integer, String> lastNames, Map<Integer, String> genders, 
			Map<Integer, String> firstNamesMale, Map<Integer, String> lastNamesMale, Map<Integer, String> gendersMale, 
			Map<Integer, String> firstNamesFemale, Map<Integer, String> lastNamesFemale, Map<Integer, String> gendersFemale, 
			Map<Integer, String> swimmingTimes, Map<Integer, String> swimmingTimesMale, Map<Integer, String> swimmingTimesFemale, 
			Map<Integer, String> bikingTimes, Map<Integer, String> bikingTimesMale, Map<Integer, String> bikingTimesFemale, 
			Map<Integer, String> runningTimes, Map<Integer, String> runningTimesMale, Map<Integer, String> runningTimesFemale, 
			Map<Integer, String> total, Map<Integer, String> totalMales, Map<Integer, String> totalFemales, 
			int amountOfAthletes, int[] athleteNumbers)
	{
		for (int i = 0; i < amountOfAthletes; i++)
		{
			double swimTime, bikeTime, runTime, totalTime;
			//If the athlete is not already disqualified then it will not calculate the data
			//You cannot calculate a String
			if (runningTimes.get(athleteNumbers[i]).equals("Disqualified"))
			{
				System.out.println("DQ: "+total.get(athleteNumbers[i])); //This can be omitted
			}
			else
			{
				/*
				 * Since the Maps have values of the String type it has to be parsed into a double
				 * then assigned to a double variable and calculated
				 */
				swimTime = Double.parseDouble(swimmingTimes.get(athleteNumbers[i]));
				bikeTime = Double.parseDouble(bikingTimes.get(athleteNumbers[i]));
				runTime = Double.parseDouble(runningTimes.get(athleteNumbers[i]));
				totalTime = Math.round((100) * (swimTime + bikeTime + runTime))/100.0; //A number to the hundreths place
				total.put(athleteNumbers[i], ""+totalTime); //Assigns that time to the total Map
				
				if (swimmingTimesMale.containsKey(athleteNumbers[i])) //Calculates the times for the males
				{
					swimTime = Double.parseDouble(swimmingTimesMale.get(athleteNumbers[i]));
					bikeTime = Double.parseDouble(bikingTimesMale.get(athleteNumbers[i]));
					runTime = Double.parseDouble(runningTimesMale.get(athleteNumbers[i]));
					totalTime = Math.round((100) * (swimTime + bikeTime + runTime))/100.0;;
					totalMales.put(athleteNumbers[i], ""+totalTime);
				}
				else if (swimmingTimesFemale.containsKey(athleteNumbers[i])) //Calculates the times for the females
				{
					swimTime = Double.parseDouble(swimmingTimesFemale.get(athleteNumbers[i]));
					bikeTime = Double.parseDouble(bikingTimesFemale.get(athleteNumbers[i]));
					runTime = Double.parseDouble(runningTimesFemale.get(athleteNumbers[i]));
					totalTime = Math.round((100) * (swimTime + bikeTime + runTime))/100.0;;
					totalFemales.put(athleteNumbers[i], ""+totalTime);
				}
			}
		}
	}
	//Prints the data
	public static void printAllAthletes(Map<Integer, String> athletesTotalTime, Map<Integer, String> firstNames, Map<Integer, String> lastNames, 
			Map<Integer, String> genders, Map<Integer, String> swimmingTimes, Map<Integer, String> bikingTimes, Map<Integer, String> runningTimes)
	{
		int[] gs = new int[athletesTotalTime.size()]; //Initializes an Array
		int i = 0; //index variable
	
		Set<Integer> array =  athletesTotalTime.keySet(); //Assigns the keySet of the athlete's total time to a Set
		Iterator<Integer> blah = array.iterator(); //An Iterator of the array with the ordered keys
		//Iterates through the Iterator and assigns/dump the values to the array
		while (blah.hasNext())
		{
			gs[i] = (int) blah.next();
			i++;
		}
		//Prints the data, all of it.
		for (int j = 0; j < (athletesTotalTime.size()); j++)
		{
			
			System.out.println("First Name: " + firstNames.get(gs[j]) + " Last Name: " + lastNames.get(gs[j]) + " Gender: " + genders.get(gs[j]) + " Swimming: " + 
			swimmingTimes.get(gs[j]) + " Biking: " + bikingTimes.get(gs[j]) + " Running: " + 
					runningTimes.get(gs[j]) + " Total: " + athletesTotalTime.get(gs[j]));
					
		}
	}
	
	public static void main(String[] args)
	{
		int amountOfAthletes = 3; //You can change the amount of athletes here.
		int[] athleteNumbers = new int[amountOfAthletes]; //Empty athlete numbers
		
		//Creating Map Objects
		Map<Integer, String> firstNames, lastNames, genders, firstNamesMale, lastNamesMale, 
		gendersMale, firstNamesFemale, lastNamesFemale, gendersFemale; 
		Map<Integer, String> swimmingTimes, swimmingTimesMale, 
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
		System.out.println("Swim: ");
		//Invoiking the swimStuff method
		swimStuff(firstNames, lastNames, genders, firstNamesMale, lastNamesMale, gendersMale, 
				firstNamesFemale, lastNamesFemale, gendersFemale, swimmingTimes, swimmingTimesMale, 
				swimmingTimesFemale, bikingTimes, bikingTimesMale, bikingTimesFemale, runningTimes, 
				runningTimesMale, runningTimesFemale, total, totalFemales, totalMales, amountOfAthletes, 
				athleteNumbers);
		System.out.println("Bike: ");
		//Invoiking the bikeStuff method
		bikeStuff(firstNames, lastNames, genders, firstNamesMale, lastNamesMale, gendersMale, 
				firstNamesFemale, lastNamesFemale, gendersFemale, swimmingTimes, swimmingTimesMale, 
				swimmingTimesFemale, bikingTimes, bikingTimesMale, bikingTimesFemale, runningTimes, 
				runningTimesMale, runningTimesFemale, total, totalFemales, totalMales, amountOfAthletes, 
				athleteNumbers);
		System.out.println("Run: ");
		//Invoking the runStuff method
		runStuff(firstNames, lastNames, genders, firstNamesMale, lastNamesMale, gendersMale, 
				firstNamesFemale, lastNamesFemale, gendersFemale, swimmingTimes, swimmingTimesMale, 
				swimmingTimesFemale, bikingTimes, bikingTimesMale, bikingTimesFemale, runningTimes, 
				runningTimesMale, runningTimesFemale, total, totalFemales, totalMales, amountOfAthletes, 
				athleteNumbers);
		System.out.println("Total: ");
		//Invoking the totalStuff method
		totalStuff(firstNames, lastNames, genders, firstNamesMale, lastNamesMale, gendersMale, 
				firstNamesFemale, lastNamesFemale, gendersFemale, swimmingTimes, swimmingTimesMale, 
				swimmingTimesFemale, bikingTimes, bikingTimesMale, bikingTimesFemale, runningTimes, 
				runningTimesMale, runningTimesFemale, total, totalFemales, totalMales, amountOfAthletes, 
				athleteNumbers);
		
		//Debugging stuff
		//printAllAthletes(swimmingTimes, bikingTimes, runningTimes, total);
		//System.out.println(firstNames.values());
		
		//Created a Map with the sorted times
		Map<Integer, String> sortedTotal = sortMap(total);

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
		/*
		 * Changed the List type to an ArrayList because the LinkedList was not needed.
		 * To sort the information first the data needs to be transferred to something that can
		 * be sorted. That's why List is being used
		 */
		List<Map.Entry<Integer, String>> list = new ArrayList<Map.Entry<Integer, String>>(unsorted.entrySet());
		
		//Sorts the the List
		Collections.sort(list, new Comparator<Map.Entry<Integer, String>>() 
				{
					/*
					 * If the first Map object is greater than the second Map than 
					 * it returns a 1, if the first Map object is less than the second
					 * Map then it returns a negative 1. If they are both equal then it
					 * it will return a 0
					 */
					@Override
					public int compare(Map.Entry<Integer, String> one, Map.Entry<Integer, String> two)
					{
						return (one.getValue()).compareTo(two.getValue());
					}
				});
		Map<Integer, String> sorted = new HashMap<Integer, String>();
		/*
		 * Iterates through the sorted List and assigns/dumps it in a Map then it gets put
		 * into the sorted Map
		 */
		for (Iterator<Map.Entry<Integer, String>> it = list.iterator(); it.hasNext();) 
		{
			Map.Entry<Integer, String> entry = it.next();
			sorted.put(entry.getKey(), entry.getValue());
		}
		//Once that is finished it returns the sorted Map
		return sorted;
	}
	
	//To go through an integer array
	public static void forEach(int[] ar)
	{
		for (Object ob: ar)
		{
			System.out.println(ob);
		}
	}
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
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
