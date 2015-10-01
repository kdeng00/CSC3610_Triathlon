package tryMe;

import java.util.Scanner;

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
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				System.out.print(athletes[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args)
	{
	
		final int dataEntries = 4;
		final int numberOfAthletes = 4;
		
		String athletes[][] = new String [numberOfAthletes][dataEntries];
		
		fillItUp(athletes, numberOfAthletes, dataEntries);
		
		print(athletes);
		
	}
}
