// Alina Tariq | 500989574

import java.util.*;
import java.io.*;

public class StudentRegistrySimulator 
{
	public static void main(String[] args)
	{
		// creates registry
		try 
		{
			Registry registry = new Registry("students.txt");

			Scheduler scheduler = new Scheduler(registry.courses);

			// takes in user input
			Scanner scanner = new Scanner(System.in);
			System.out.print(">");

			while (scanner.hasNextLine())
			{
				String inputLine = scanner.nextLine();
				if (inputLine == null || inputLine.equals("")) continue;

				Scanner commandLine = new Scanner(inputLine);
				String command = commandLine.next();

				// goes back to the beginning of the loop if nothing is entered
				if (command == null || command.equals("")) continue;

				else if (command.equalsIgnoreCase("L") || command.equalsIgnoreCase("LIST"))
				{
					// prints out a list of all students
					registry.printAllStudents();
				}
				else if (command.equalsIgnoreCase("Q") || command.equalsIgnoreCase("QUIT"))
				{
					// exits the loop
					scanner.close();
					commandLine.close();
					return;
				}
				else if (command.equalsIgnoreCase("REG"))
				{
					// ensures both name and ID have been given
					// checks the name only has alphabets and the ID only numbers
					// adds the student to the registry using their name and ID
					// if all conditions are satisfied

					try
					{	
						String name = commandLine.next();
						String id = commandLine.next();

						boolean result = registry.addNewStudent(name, id);
						if (!result)
						{
							System.out.println("Student " + name + " already registered");
						}
					}
					catch (IllegalArgumentException e)
					{
						System.out.println(e.getMessage());
					}
					catch (NoSuchElementException e)
					{
						System.out.println("Missing inputs");
					}

				}
				else if (command.equalsIgnoreCase("DEL"))
				{
					// ensures ID has been given and checks it's numeric
					// removes the student from the registry if conditions are met

					try
					{
						String id = commandLine.next();
						
						boolean result = registry.removeStudent(id);
						if (!result)
						{
							System.out.println("Student not found in registry.");
						}
					}
					catch (IllegalArgumentException e)
					{
						System.out.println(e.getMessage());
					}
					catch (NoSuchElementException e)
					{
						System.out.println("Missing input");
					}
				}
				else if (command.equalsIgnoreCase("ADDC"))
				{
					// ensures valid student ID and course code is given
					// adds a student to the active course
					
					try
					{
						String id = commandLine.next();
						String courseCode = commandLine.next();
						registry.addCourse(id, courseCode);
					}
					catch (IllegalArgumentException e)
					{
						System.out.println(e.getMessage());
					}
					catch (NoSuchElementException e)
					{
						System.out.println("Missing inputs");
					}
				}
				else if (command.equalsIgnoreCase("CCL"))
				{
					// ensures course code is given and valid
					// clears class list for the given course

					try
					{
						String courseCode = commandLine.next();
						registry.clearClassList(courseCode);
					}
					catch (IllegalArgumentException e)
					{
						System.out.println(e.getMessage());
					}
					catch (NoSuchElementException e)
					{
						System.out.println("Missing input");
					}
				}
				else if (command.equalsIgnoreCase("DROPC"))
				{
					// ensures valid student id and course codes are given
					// drop student from the given course

					try 
					{
						String id = commandLine.next();
						String courseCode = commandLine.next();
						registry.dropCourse(id, courseCode);
					}
					catch (IllegalArgumentException e)
					{
						System.out.println(e.getMessage());
					}
					catch (NoSuchElementException e)
					{
						System.out.println("Missing inputs");
					}

				}
				else if (command.equalsIgnoreCase("PAC"))
				{
					// prints all active courses
					registry.printActiveCourses();
				}		  
				else if (command.equalsIgnoreCase("PCL"))
				{
					// ensures course code is given and valid
					// print class list for the given course

					try
					{
						String courseCode = commandLine.next();
						registry.printClassList(courseCode);
					}
					catch (IllegalArgumentException e)
					{
						System.out.println(e.getMessage());
					}
					catch (NoSuchElementException e)
					{
						System.out.println("Missing input");
					}
				}
				else if (command.equalsIgnoreCase("PGR"))
				{
					// ensures course code is given and valid
					// print names, ID, and grades for the given course

					try
					{
						String courseCode = commandLine.next();
						registry.printGrades(courseCode);
					}
					catch (IllegalArgumentException e)
					{
						System.out.println(e.getMessage());
					}
					catch (NoSuchElementException e)
					{
						System.out.println("Missing input");
					}
				}
				else if (command.equalsIgnoreCase("PSC"))
				{
					// ensures student ID is given and valid
					// print all credit courses for the student

					try 
					{
						String id = commandLine.next();
						registry.printStudentCourses(id);
					}
					catch (IllegalArgumentException e)
					{
						System.out.println(e.getMessage());
					}
					catch (NoSuchElementException e)
					{
						System.out.println("Missing input");
					}

				}
				else if (command.equalsIgnoreCase("PST"))
				{
					// ensures student ID is given and valid
					// prints out the student's transcript

					try 
					{
						String id = commandLine.next();
						registry.printStudentTranscript(id);

					}
					catch (IllegalArgumentException e)
					{
						System.out.println(e.getMessage());
					}
					catch (NoSuchElementException e)
					{
						System.out.println("Missing input");
					}

				}
				else if (command.equalsIgnoreCase("SFG"))
				{
					// ensures valid course code, student ID and grade are given
					// set final grade of student for the given course

					try 
					{
						String courseCode = commandLine.next();
						String id = commandLine.next();
						double grade = Double.parseDouble(commandLine.next());
						registry.setFinalGrade(courseCode, id, grade);

					}
					catch (IllegalArgumentException e)
					{
						System.out.println(e.getMessage());
					}
					catch (NoSuchElementException e)
					{
						System.out.println("Missing inputs");
					}
				}
				else if (command.equalsIgnoreCase("SCN"))
				{
					// ensures course code is given and valid
					// sort list of students in course alphabetically by name
					try 
					{
						String courseCode = commandLine.next();
						registry.sortCourseByName(courseCode);
					}
					catch (IllegalArgumentException e)
					{
						System.out.println(e.getMessage());
					}
					catch (NoSuchElementException e)
					{
						System.out.println("Missing input");
					}

				}
				else if (command.equalsIgnoreCase("SCI"))
				{
					// ensures course code is given and valid
					// sort list of students in course by student id

					try
					{
						String id = commandLine.next();
						registry.sortCourseById(id);
					}
					catch (IllegalArgumentException e)
					{
						System.out.println(e.getMessage());
					}
					catch (NoSuchElementException e)
					{
						System.out.println("Missing input");
					}
				}
				else if (command.equalsIgnoreCase("SCH"))
				{
					// takes in course code, lecture day(s)
					// lecture time(s), and lecture duration(s)
					// to schedule courses at the given slots
					// can handle single and multiple block classes
					
					try 
					{
						String courseCode = commandLine.next();
						String day1 = commandLine.next();
						int time1 = commandLine.nextInt();
						int dur1 = commandLine.nextInt();

						if(commandLine.hasNext())
						{
							String day2 = commandLine.next();
							int time2 = commandLine.nextInt();
							int dur2 = commandLine.nextInt();

							scheduler.setMultipleDayAndTime(courseCode, day1, time1, dur1, day2, time2, dur2);
						}
						else
						{
							scheduler.setDayAndTime(courseCode, day1, time1, dur1);
						}

					}
					catch (IllegalScheduleException e)
					{
						System.out.println(e.getMessage());
					}
					catch (IllegalArgumentException e)
					{
						System.out.println(e.getMessage());
					}
					catch (NoSuchElementException e)
					{
						System.out.println("Missing inputs");
					}
				}
				else if (command.equalsIgnoreCase("CSCH"))
				{
					// takes in course code and clears the
					// clears the schedule for the given course
					
					try 
					{
						String courseCode = commandLine.next();
						scheduler.clearSchedule(courseCode);

					}
					catch (IllegalScheduleException e)
					{
						System.out.println(e.getMessage());
					}
					catch (IllegalArgumentException e)
					{
						System.out.println(e.getMessage());
					}
					catch (NoSuchElementException e)
					{
						System.out.println("Missing input");
					}
				}
				else if (command.equalsIgnoreCase("ASCH"))
				{
					// takes in course code and duration
					// to try and schedule a course automatically
					// if no slot found, throws an exception
					
					try 
					{
						String courseCode = commandLine.next();
						int duration = commandLine.nextInt();
						scheduler.automaticScheduler(courseCode, duration);
					}
					catch (IllegalScheduleException e)
					{
						System.out.println(e.getMessage());
					}
					catch (IllegalArgumentException e)
					{
						System.out.println(e.getMessage());
					}
					catch (NoSuchElementException e)
					{
						System.out.println("Missing inputs");
					}
				}
				else if (command.equalsIgnoreCase("PSCH"))
				{
					scheduler.printSchedule();
				}
				else {
					System.out.println("Command not recognized");
				}
				System.out.print("\n>");
			} 		
		} 
		catch (IOException FileNotFoundException) 
		{
			System.out.println("File not found");
		}
		catch (RuntimeException NoSuchElementException) 
		{
			System.out.println("Bad file format");
		}
	}

	/**
	 * Checks to see if the given string only consists of alphabetic characters
	 * @param str the string to be checked
	 * @return true if it does, false if it doesn't 
	 */
	private static boolean isStringOnlyAlphabet(String str) 
	{ 
		for (int i = 0; i < str.length(); i++)
		{
			if (!Character.isLetter(str.charAt(i)))
			{
				return false;
			}
		}
		return true;
	} 

	/**
	 * Checks to see if the given string only consists of digits
	 * @param str the string to be checked
	 * @return true if it does, false if it doesn't
	 */
	public static boolean isNumeric(String str)
	{
		for (int i = 0; i < str.length(); i++)
		{
			if (!Character.isDigit(str.charAt(i)))
			{
				return false;
			}
		}
		return true;
	}


}