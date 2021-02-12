// Alina Tariq | 500989574

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeMap;

public class ActiveCourse extends Course
{
	private int lecStart1 = 0;
	private int lecDur1 = 0;
	private String lecDay1 = "";
	private int lecStart2 = 0;
	private int lecDur2 = 0;
	private String lecDay2 = "";
	private ArrayList<Student> students; 
	private String             semester;

	/**
	 * A constructor method to set up an active course by initializing
	 * inherited variables name, code, descr, and fmt using the super 
	 * class (Course) along with local variables semester and students
	 * @param name
	 * @param code
	 * @param descr
	 * @param fmt
	 * @param semester
	 * @param students
	 */
	public ActiveCourse(String name, String code, String descr, String fmt, String semester, ArrayList<Student> students)
	{
		super(name, code, descr, fmt);
		this.semester = semester;
		// copies students array list
		this.students = new ArrayList<Student>(students);
	}

	/**
	 * Accesses and returns the semester the course is being taken
	 * @return the course's semester
	 */
	public String getSemester()
	{
		return semester;
	}

	/**
	 * Checks to see if the given student is enrolled in the course
	 * @param studentId the student's ID number
	 * @return true or false, depending on if the student is enrolled
	 */
	public boolean findStudent(String studentId)
	{
		for (int i = 0; i < students.size(); i++)
		{
			// looks for the student in the class list using ID
			if (students.get(i).getId().equals(studentId))
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * Adds a new student to the course
	 * @param newStudent the new student object
	 */
	public void addStudent(Student newStudent)
	{
		this.students.add(newStudent);
	}

	/**
	 * Removes a student from the course
	 * @param studentId the student's ID number
	 */
	public void removeStudent(String studentId) 
	{
		for (int i = 0; i < students.size(); i++)
		{
			// looks for the student in the list
			if (students.get(i).getId().equals(studentId))
			{
				students.remove(i);
			}
		}
	}

	/**
	 * Prints the class list (name, ID)
	 */
	public void printClassList()
	{
		for (int i = 0; i < students.size(); i++)
		{
			System.out.println("Student ID: " + students.get(i).getId() + " Name: " + students.get(i).getName());
		}
	}

	/**
	 * Prints the students' names, ID, and their grades
	 */
	public void printGrades()
	{
		for (int i = 0; i < students.size(); i++)
		{
			System.out.println(students.get(i).toString() + " " + getGrade(students.get(i).getId()));
		}
	}

	/**
	 * Returns the numeric grade of the given student in the course
	 * or 0 if the student is not found
	 * @param studentId the student's ID number
	 * @return the student's grade
	 */
	public double getGrade(String studentId)
	{
		for (int i = 0; i < students.size(); i++)
		{
			// looks for the student and returns their grade if found
			if (students.get(i).getId().equals(studentId))
			{
				return students.get(i).getGrade(getCode());
			}
		}
		// returns 0 if the student wasn't found
		return 0.0;
	}

	/**
	 * Overrides the getDescription() method inherited from the Course
	 * superclass and returns course information (name, code, description,
	 * format) along with semester and enrollment number
	 */
	public String getDescription()
	{
		return super.getDescription() + " " + getSemester() + " Enrolment: " + String.valueOf(students.size()) + '\n';
	}

	/**
	 * Clears the class list for the active course
	 */
	public void clearClassList()
	{
		students.clear();
	}


	/**
	 * Sets lecture schedule 
	 * @param day the lecture day
	 * @param time the lecture start time
	 * @param duration the lecture duration
	 */
	public void setSchedule(String day, int time, int duration)
	{
		lecDay1 = day;
		lecStart1 = time;
		lecDur1 = duration;
		lecDay2 = day;
		lecStart2 = time;
		lecDur2 = duration;
	}

	/**
	 * Sets multiple lecture schedules
	 * @param day1 the first lecture day
	 * @param time1 the first lecture start time
	 * @param dur1 the first lecture duration
	 * @param day2 the second lecture day
	 * @param time2 the second lecture start time
	 * @param dur2 the second lecture duration
	 */
	public void setMultipleSchedule(String day1, int time1, int dur1, String day2, int time2, int dur2)
	{
		lecDay1 = day1;
		lecStart1 = time1;
		lecDur1 = dur1;
		lecDay2 = day2;
		lecStart2 = time2;
		lecDur2 = dur2;
	}

	/**
	 * Checks to see if given day, time, and duration matches the course's schedule
	 * @param day the proposed lecture day
	 * @param time the proposed lecture time
	 * @param duration the proposed lecture duration
	 * @return if day, time, and durations overlapped
	 */
	public boolean equalsSchedule(String day, int time, int duration)
	{
		if (lecDay1.equalsIgnoreCase(day) && time >= lecStart1 && time < lecStart1 + lecDur1*100)
		{
			return true;
		}
		else if (lecDay1.equalsIgnoreCase(day) && time <= lecStart1 && time + duration*100 > lecStart1)
		{
			return true;
		}
		else	if (lecDay2.equalsIgnoreCase(day) && time >= lecStart2 && time < lecStart2 + lecDur2*100)
		{
			return true;
		}
		else if (lecDay2.equalsIgnoreCase(day) && time <= lecStart2 && time + duration*100 > lecStart2)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Checks to see if either of the given day, time, and duration
	 * combination match the current course's schedule
	 * @param day1 the first proposed lecture day
	 * @param time1 the first proposed lecture time
	 * @param dur1 the first proposed lecture duration
	 * @param day2 the second proposed lecture day
	 * @param time2 the second proposed lecture time
	 * @param dur2 the second proposed lecture duration
	 * @return if either day, time, and duration combos overlapped
	 */
	public boolean equalsMultipleSchedule(String day1, int time1, int dur1, String day2, int time2, int dur2)
	{
		if (lecDay1.equalsIgnoreCase(day1) && time1 >= lecStart1 && time1 < lecStart1 + lecDur1*100)
		{
			return true;
		}
		else if (lecDay1.equalsIgnoreCase(day1) && time1 <= lecStart1 && time1 + dur1*100 > lecStart1)
		{
			return true;
		}
		else if (lecDay2.equalsIgnoreCase(day1) && time1 >= lecStart2 && time1 < lecStart2 + lecDur2*100)
		{
			return true;
		}
		else if (lecDay2.equalsIgnoreCase(day1) && time1 <= lecStart2 && time1 + dur1*100 > lecStart2)
		{
			return true;
		}
		else if (lecDay1.equalsIgnoreCase(day2) && time2 >= lecStart1 && time2 < lecStart1 + lecDur1*100)
		{
			return true;
		}
		else if (lecDay1.equalsIgnoreCase(day2) && time2 <= lecStart1 && time2 + dur2*100 > lecStart1)
		{
			return true;
		} 
		else if (lecDay2.equalsIgnoreCase(day2) && time2 >= lecStart2 && time2 < lecStart2 + lecDur2*100)
		{
			return true;
		}
		else if (lecDay2.equalsIgnoreCase(day2) && time2 <= lecStart2 && time2 + dur2*100 > lecStart2)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Checks to see if the current course has a schedule set already
	 * @return if a schedule exists
	 */
	public boolean hasSchedule() {
		if (lecDay1.equals("") && lecStart1 == 0 && lecDur1 == 0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	/**
	 * Returns the timetable index numbers for the course schedule
	 * @return index number for class time slots
	 */
	public ArrayList<Integer> getSchedulerIndex() {

		ArrayList<Integer> timing = new ArrayList<Integer>();
		lecDay1 = lecDay1.toUpperCase();
		lecDay2 = lecDay2.toUpperCase();
		TreeMap<String, Integer> days = new TreeMap<String, Integer>();
		TreeMap<Integer, Integer> times = new TreeMap<Integer, Integer>();

		// matches lecture day and time with their appropriate timetable index numbers 
		days.put("MON", 1); days.put("TUE", 2); days.put("WED", 3); days.put("THUR", 4); days.put("FRI", 5);
		times.put(800, 1); times.put(900, 2); times.put(1000, 3); times.put(1100, 4); times.put(1200, 5); 
		times.put(1300, 6);  times.put(1400, 7); times.put(1500, 8); times.put(1600, 9);

		// adds day and time timetable array index numbers for the first class block
		timing.add(days.get(lecDay1));
		timing.add(times.get(lecStart1));
		timing.add(times.get(lecStart1) + lecDur1); // lecture end time

		// if a second class block exists, adds it's index numbers as well
		if (!lecDay2.equals("") && lecStart2 != 0 && lecDur2 != 0)
		{
			timing.add(days.get(lecDay2));
			timing.add(times.get(lecStart2));
			timing.add(times.get(lecStart2) + lecDur2);
		}

		return timing;
	}

	/**
	 * Sorts the students by name using Collections.sort and the NameComparator class
	 */
	public void sortByName()
	{
		Collections.sort(students, new NameComparator());
	}

	private class NameComparator implements Comparator<Student>
	{
		/**
		 * Makes use of the Comparator interface to compare
		 * the names of two Student objects
		 */
		public int compare(Student a, Student b)
		{
			int comparison = a.getName().compareTo(b.getName());
			return comparison;
		}

	}

	/**
	 * Sorts the students by ID using Collections.sort and the IdComparator class
	 */
	public void sortById()
	{
		Collections.sort(students, new IdComparator());
	}

	private class IdComparator implements Comparator<Student>
	{
		/**
		 * Makes use of the Comparator interface to compare
		 * the IDs of two Student objects
		 */
		public int compare(Student a, Student b)
		{
			int comparison = a.getId().compareTo(b.getId());
			return comparison;
		}
	}
}
