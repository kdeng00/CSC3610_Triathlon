package tryMe;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;

public class Athlete
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
	
	public static String[][] getAthletesData()
	{
		return athletes;
	}
	public static void setAthletesData(String[][] athletes)
	{
		Athlete.athletes = athletes;
	}
	public static String getFirstName() {
		return firstName;
	}
	public static void setFirstName(String firstName) {
		Athlete.firstName = firstName;
	}
	public static String getLastName() {
		return lastName;
	}
	public static void setLastName(String lastName) {
		Athlete.lastName = lastName;
	}
	public static String getGender() {
		return gender;
	}
	public static void setGender(String gender) {
		Athlete.gender = gender;
	}
	public static String getAthleteNumber() {
		return athleteNumber;
	}
	public static void setAthleteNumber(String athleteNumber) {
		Athlete.athleteNumber = athleteNumber;
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
		//Stack<Object> femaleAthletes = new Stack<>();
		//Stack<Object> maleAthletes = new Stack<>();
		
		List femaleList = new ArrayList<>();
		List maleList = new ArrayList<>();
		Queue allAthleteQueue = new LinkedList<>();
		
		
		//Scanner userInput = new Scanner(System.in);
		
		String gender = "";
		String firstName;
		String lastName;
		int athleteNumber;
		int males = 0;
		int females = 0;
		
		String[][] test = new String [3][8];
		String[][] testMale = new String[3][8];
		String[][] testFemale = new String[3][8];
		
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
				if (gender.equalsIgnoreCase("Male")) //allows upper/lower user input
				{
					athleteInfo.add(gender);
					test[i][3] = gender;
					//truStory = false;
					break;
				}
				else if (gender.equalsIgnoreCase("Female")) //allows upper/lower user input
				{
					athleteInfo.add(gender);
					test[i][3] = gender;
					//truStory = false;
					break;
				}
				else
					System.out.println("Does not Compute");
					System.out.println("Try again: ");
					
			}
			
			athleteNumber = (int) (Math.random()*300);
			athleteInfo.add(athleteNumber);
			test[i][4] = ""+athleteNumber;
			
			/*
			setRandomSwimTimeMinute();
			setRandomSwimTimeSecond();
			setRandomBikeTimeMinute();
			setRandomBikeTimeSecond();
			setRandomRunTimeMinute();
			setRandomRunTimeSecond();
			*/
			
			
			athleteInfo.add(getRandomSwimTimeMinute() + ":" + getRandomSwimTimeSecond());
			athleteInfo.add(getRandomBikeTimeMinute() + ":" + getRandomBikeTimeSecond());
			athleteInfo.add(getRandomRunTimeMinute() + ":" + getRandomRunTimeSecond());
			athleteInfo.add(getTotalTimeMinute() + ":" + getTotalTimeSecond());
			
			athletes.add(athleteInfo);
			allAthleteQueue.add(athleteInfo);
			
			/**
			
			if (gender.equals("Male"))
			{
				for (int j = 0; i < 7; i++)
				{	
					switch (males)
					{
						case 0:
							testMale[males][j] = "" + Math.round((getTotalTimeMinute() + (getTotalTimeSecond()/60.0)));
							break;
						case 1:
							testMale[males][j] = firstName;
							break;
						case 2:
							testMale[males][j] = lastName;
							break;
						case 3:
							testMale[males][j] = ""+athleteNumber;
							break;
							
						case 4: 
							testMale[males][j] = ""+getRandomSwimTimeMinute() + ":" + getRandomSwimTimeSecond();
							break;
						case 5:
							testMale[males][j] = ""+getRandomBikeTimeMinute() + ":" + getRandomBikeTimeSecond();
							break;
						case 6:
							testMale[males][j] = ""+getRandomRunTimeMinute() + ":" + getRandomRunTimeMinute();
							break;
						case 7:
							testMale[males][j] = ""+getTotalTimeMinute() + ":" + getTotalTimeSecond();
							males++;
							break;
							
					}
				
				}
				
				/**
				maleList.add( (firstName + " " + lastName + " " + gender + " " + athleteNumber + getRandomSwimTimeMinute()
				+ ":" + getRandomSwimTimeSecond() + " " + getRandomBikeTimeMinute() + ":" + getRandomBikeTimeSecond() 
				+ " " + getRandomRunTimeMinute() + ":" + getRandomRunTimeSecond() + " " + getTotalTimeMinute() + ":" 
				+ getTotalTimeSecond()) );
				maleAthletes.push((firstName + " " + lastName + " " + gender + " " + athleteNumber + getRandomSwimTimeMinute()
						+ ":" + getRandomSwimTimeSecond() + " " + getRandomBikeTimeMinute() + ":" + getRandomBikeTimeSecond() 
						+ " " + getRandomRunTimeMinute() + ":" + getRandomRunTimeSecond() + " " + getTotalTimeMinute() + ":" 
						+ getTotalTimeSecond()));
						
						
			}
			else if (gender.equals("Female"))
			{
				for (int j = 0; i < 7; i++)
				{	
					switch (females)
					{
						case 0:
							testMale[females][j] = "" + Math.round((getTotalTimeMinute() + (getTotalTimeSecond()/60.0)));
							break;
						case 1:
							testMale[females][j] = firstName;
							break;
						case 2:
							testMale[females][j] = lastName;
							break;
						case 3:
							testMale[females][j] = ""+athleteNumber;
							break;
							
						case 4: 
							testMale[females][j] = ""+getRandomSwimTimeMinute() + ":" + getRandomSwimTimeSecond();
							break;
						case 5:
							testMale[females][j] = ""+getRandomBikeTimeMinute() + ":" + getRandomBikeTimeSecond();
							break;
						case 6:
							testMale[females][j] = ""+getRandomRunTimeMinute() + ":" + getRandomRunTimeMinute();
							break;
						case 7:
							testMale[females][j] = ""+getTotalTimeMinute() + ":" + getTotalTimeSecond();
							females++;
							break;
							
					}
				
				}
			}
			*/
			
		}
		//System.out.println(athletes.elementAt(1));
		//All Athletes
		for (int k = 0; k < 3; k++)
		{
			//athletes.add(athleteInfo]);
		}
		
		
		
		Iterator itQueue = allAthleteQueue.iterator();
		Iterator itStack = athletes.iterator();
		
		
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
		
		/*
		//Should have give us a sorted arry, but it did not work
		// the method sort(list<T>, comparator<? super T>) in the type Collection is not aplicable
		// for the arguments(string[][], stack <Object> )...
		Collections.sort(test, athletes);
		     for(String[] counter: test){
			System.out.println();
		}
*/
		
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
		
		
		
		
		
		
		System.out.println("\nString: ");
		for (String[] ob: test)
		{
			setHours(Double.parseDouble(ob[0]));
			setMinutes(Double.parseDouble(ob[0]));
			setSeconds(Double.parseDouble(ob[0]));
			System.out.println( getHours()+ ":" + getMinutes() + ":" + getSeconds() + " " + ob[1] + " " + ob[2] + " " + ob[3] + " " + ob[4]);
		}
		
		
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
	
	
	public static void main(String[] args)
	{
	//Changed finals to capital since they're constants
		final int DATA_ENTRIES = 4;
		final int NUMBER_OF_ATHLETES = 4;
		
		String athletes[][] = new String [NUMBER_OF_ATHLETES][DATA_ENTRIES];
		
		//fillItUp(athletes, numberOfAthletes, dataEntries);
		
		//print(athletes);
		
		assign(3);
		
	}
}
