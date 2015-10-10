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
		
		// new ArrayList<>();
		// new ArrayList<>();
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
					//truStory = false;
					break;
				}
				else if (gender.equalsIgnoreCase("Female"))
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
			
				
			athleteInfo.add(getRandomSwimTimeMinute() + ":" + getRandomSwimTimeSecond());
			athleteInfo.add(getRandomBikeTimeMinute() + ":" + getRandomBikeTimeSecond());
			athleteInfo.add(getRandomRunTimeMinute() + ":" + getRandomRunTimeSecond());
			athleteInfo.add(getTotalTimeMinute() + ":" + getTotalTimeSecond());
			
			athletes.add(athleteInfo);
			allAthleteQueue.add(athleteInfo);
			
			
			
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
	
	
	
	
	public static void main(String[] args)
	{
	
		final int dataEntries = 4;
		final int numberOfAthletes = 4;
		
		
		
		//fillItUp(athletes, numberOfAthletes, dataEntries);
		
		//print(athletes);
		
		assign(3);
		launch(args);
		
		
	}
		@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Triatholon Prjoect Demo");
		
		initializeRootLayout();
		showControlsData();

		
	}
	private void showControlsData() {
		FXMLLoader load = new FXMLLoader();
		load.setLocation(Ares_Athlete.class.getResource("Athlete_Controller.fxml"));
		
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
		loader.setLocation(Ares_Athlete.class.getResource("RootLayout.fxml"));
		
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
