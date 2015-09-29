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
					if (Integer.parseInt(athletes[i][j]) == 0)
					{
						athletes[i][j] = "Female";
					}
					else if (Integer.parseInt(athletes[i][j]) == 1)
					{
						athletes[i][j] = "Male";
					}
					else
						while ((Integer.parseInt(athletes[i][j])) != 0 || (Integer.parseInt(athletes[i][j])) == 1)
						{
							System.out.println("Does not equal to 0 or 1");
							System.out.println("Try again: ");
							athletes[i][j] = userInput.nextLine();
							
							if (!athletes[i][j].equals("0") || !athletes[i][j].equals("1"))
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
	}
	public static void main(String[] args)
	{
		Scanner userInput = new Scanner(System.in);
		final int dataEntries = 4;
		final int numberOfAthletes = 4;
		
		String athletes[][] = new String [numberOfAthletes][dataEntries];
		
		fillItUp(athletes, numberOfAthletes, dataEntries);
		
	}
}
