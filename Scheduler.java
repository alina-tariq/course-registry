// Alina Tariq | 500989574

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

public class Scheduler 
{
	// In main() after you create a Registry object, create a Scheduler object and pass in the courses ArrayList/TreeMap
	// If you do not want to try using a Map then uncomment
	// the line below and comment out the TreeMap line
	//ArrayList<Student> students;

	TreeMap<String,ActiveCourse> schedule;

	/**
	 * A constructor method to set up a scheduler
	 * @param courses all current active courses
	 */
	public Scheduler(TreeMap<String,ActiveCourse> courses)
	{
		schedule = courses;
	}

	/**
	 * Sets the schedule for the given course with the provided day, time, and duration
	 * @param courseCode the course 
	 * @param day the lecture day
	 * @param startTime the lecture start time
	 * @param duration the lecture duration
	 */
	public void setDayAndTime(String courseCode, String day, int startTime, int duration)
	{
		if (isNumeric(courseCode) || isAlphaOnly(courseCode))
		{
			throw new IllegalArgumentException("Invalid Course Code");
		}

		// changes to uppercase to avoid equality errors
		courseCode = courseCode.toUpperCase();
		day = day.toUpperCase();

		if (schedule.containsKey(courseCode))
		{
			ArrayList<String> days = new ArrayList<String>();
			days.add("MON"); days.add("TUE"); days.add("WED");
			days.add("THUR"); days.add("FRI");

			// checks to make sure the day is valid
			if (days.contains(day))
			{
				// checks to make sure the course will not run outside of valid hours
				if (startTime >= 800 && startTime + duration*100 <= 1700) 
				{
					// ensures it is a valid duration
					if (duration >= 1 && duration <= 3)
					{
						// clears course schedule if it exists
						if (schedule.get(courseCode).hasSchedule()) 
						{
							clearSchedule(courseCode);
						}

						// checks if the proposed schedule clashes with any other courses' schedule
						// sets the schedule if they don't 
						if (scheduleClash(day, startTime, duration))
						{
							throw new IllegalScheduleException("Lecture Time Collision");
						}
						else
						{
							schedule.get(courseCode).setSchedule(day, startTime, duration);
						}
					}
					else
					{
						throw new IllegalScheduleException("Invalid Lecture Duration");
					}
				}
				else
				{
					throw new IllegalScheduleException("Invalid Lecture Start Time");
				}
			}
			else
			{
				throw new IllegalScheduleException("Invalid Lecture Day");
			}
		}
		else
		{
			throw new IllegalScheduleException("Invalid Course Code");
		}
	}

	/**
	 * Sets a schedule consisting of multiple class blocks for the given course
	 * @param courseCode the course 
	 * @param day1 the first lecture day
	 * @param time1 the first lecture start time
	 * @param dur1 the first lecture duration
	 * @param day2 the second lecture day
	 * @param time2 the second lecture start time
	 * @param dur2 the second lecture duration
	 */
	public void setMultipleDayAndTime (String courseCode, String day1, int time1, int dur1, String day2, int time2, int dur2)
	{
		if (isNumeric(courseCode) || isAlphaOnly(courseCode))
		{
			throw new IllegalArgumentException("Invalid Course Code");
		}

		// sets all to upper case to avoid equality errors
		courseCode = courseCode.toUpperCase();
		day1 = day1.toUpperCase();
		day2 = day2.toUpperCase();
		if (schedule.containsKey(courseCode))
		{
			ArrayList<String> days = new ArrayList<String>();
			days.add("MON"); days.add("TUE"); days.add("WED");
			days.add("THUR"); days.add("FRI");

			// ensures the day given is valid
			if (days.contains(day1) && days.contains(day2))
			{
				// ensures the class times are within school hours
				if (time1 >= 800 && time2 >= 800 && time1 + dur1*100 <= 1700 && time2 + dur2*100 <= 1700) 
				{
					// checks that the duration is valid
					if (dur1 >= 1 && dur2 >= 1 && dur1 <= 3 && dur2 <= 3)
					{
						// clears course's current schedule if it exists to avoid clash
						if (schedule.get(courseCode).hasSchedule()) 
						{
							clearSchedule(courseCode);
						}

						// if no schedule clashes exist, schedules the course
						if (scheduleMutipleClash(day1, time1, dur1, day2, time2, dur2))
						{
							throw new IllegalScheduleException("Lecture Time Collision");
						}
						else
						{
							schedule.get(courseCode).setMultipleSchedule(day1, time1, dur1, day2, time2, dur2);;
						}
					}
					else
					{
						throw new IllegalScheduleException("Invalid Lecture Duration");
					}
				}
				else
				{
					throw new IllegalScheduleException("Invalid Lecture Start Time");
				}
			}
			else
			{
				throw new IllegalScheduleException("Invalid Lecture Day");
			}
		}
		else
		{
			throw new IllegalScheduleException("Invalid Course Code");
		}

	}

	/**
	 * Clears the given course's schedule
	 * @param courseCode the course
	 */
	public void clearSchedule(String courseCode)
	{
		if (isNumeric(courseCode) || isAlphaOnly(courseCode))
		{
			throw new IllegalArgumentException("Invalid Course Code");
		}

		courseCode = courseCode.toUpperCase();

		if (schedule.containsKey(courseCode))
		{
			schedule.get(courseCode).setSchedule("",  0,  0);
		}
	}

	/**
	 * Prints a timetable with all scheduled courses' days and times
	 */
	public void printSchedule()
	{
		Set<String> allKeys = schedule.keySet();
		String[][] timetable = new String[6][10];
		ArrayList<Integer> scheduleIndices = new ArrayList<Integer>();

		// day 
		timetable[0][0] = "        "; timetable[1][0] = "   MON  ";
		timetable[2][0] = "   TUE  "; timetable[3][0] = "   WED  ";
		timetable[4][0] = "   THU  "; timetable[5][0] = "   FRI  ";

		// time 
		timetable[0][1] = "  0800  "; timetable[0][2] = "  0900  ";
		timetable[0][3] = "  1000  "; timetable[0][4] = "  1100  ";
		timetable[0][5] = "  1200  "; timetable[0][6] = "  1300  ";
		timetable[0][7] = "  1400  "; timetable[0][8] = "  1500  ";
		timetable[0][9] = "  1600  ";

		// initializes each space
		for (int i = 1; i < 6; i++) {
			for (int j = 1; j < 10; j++){
				timetable[i][j] = "        ";
			}
		}

		for (String key : allKeys)
		{
			if (schedule.get(key).hasSchedule())
			{
				// retrieves index numbers of the first class block
				scheduleIndices = schedule.get(key).getSchedulerIndex();

				// adds first class block to timetable
				for (int j = scheduleIndices.get(1); j < scheduleIndices.get(2); j++)
				{
					int i = scheduleIndices.get(0);
					timetable[i][j] = " " + key + " ";
				}

				// if course has a second block adds it to the timetable
				if (scheduleIndices.size() == 6) 
				{
					for (int j = scheduleIndices.get(4); j < scheduleIndices.get(5); j++)
					{
						int i = scheduleIndices.get(3);
						timetable[i][j] = " " + key + " ";
					}
				}
			}
		}

		// prints out timetable
		for (int j = 0; j < 10; j++) {
			for (int i = 0; i < 6; i++) {
				System.out.print(timetable[i][j]);
			}
			System.out.print("\n");
		}


	}

	/**
	 * Checks to see if the proposed day, time, and duration clash with any other course's schedule
	 * @param day the proposed lecture day
	 * @param startTime the proposed lecture start time
	 * @param duration the proposed lecture duration
	 * @return if there is a clash
	 */
	public boolean scheduleClash(String day, int startTime, int duration)
	{
		Set<String> allKeys = schedule.keySet();
		for (String key : allKeys)
		{
			if (schedule.get(key).equalsSchedule(day, startTime, duration))
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks to see if the proposed days, times, and durations clash with any other course's schedule
	 * @param day1 the proposed first lecture day
	 * @param time1 the proposed first lecture start time
	 * @param dur1 the proposed first lecture duration
	 * @param day2 the proposed second lecture day
	 * @param time2 the proposed second lecture start time
	 * @param dur2 the proposed second lecture duration
	 * @return if there is a clash 
	 */
	public boolean scheduleMutipleClash(String day1, int time1, int dur1, String day2, int time2, int dur2)
	{
		Set<String> allKeys = schedule.keySet();
		for (String key : allKeys)
		{
			if (schedule.get(key).equalsMultipleSchedule(day1, time1, dur1, day2, time2, dur2))
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * Tries to automatically find a time slot for the course 
	 * @param courseCode the course to be scheduled
	 * @param duration the lecture duration
	 */
	public void automaticScheduler(String courseCode, int duration)
	{
		if (isNumeric(courseCode) || isAlphaOnly(courseCode))
		{
			throw new IllegalArgumentException("Invalid Course Code");
		}

		ArrayList<String> days = new ArrayList<String>();
		days.add("MON"); days.add("TUE"); days.add("WED");
		days.add("THUR"); days.add("FRI");
		boolean scheduled = false; // if scheduling was successful
		courseCode = courseCode.toUpperCase();

		// clears course's schedule if it exists to avoid clashes
		if (schedule.get(courseCode).hasSchedule()) 
		{
			clearSchedule(courseCode);
		}

		// for each day, checks each time slot to see if there's a schedule clash
		// stops looking after the first time slot with no collision is found
		for (String day : days)
		{
			for (int time = 800; time + duration*100 <= 1700; time += 100)
			{
				// if no clash is found for a day/time, sets schedule and exits the for loop
				if (!scheduleClash(day, time, duration))
				{
					scheduled = true;
					setDayAndTime(courseCode, day, time, duration);
					return;
				}
			}
		}

		if (!scheduled) {
			throw new IllegalScheduleException("Lecture Could Not Be Scheduled");
		}

	}

	/**
	 * Checks to see if the given string only consists of alphabetic characters
	 * @param str the string to be checked
	 * @return true if it does, false if it doesn't 
	 */
	private static boolean isAlphaOnly(String str) 
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

