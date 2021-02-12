// Alina Tariq | 500989574

import java.util.ArrayList;

// Make class Student implement the Comparable interface
// Two student objects should be compared by their name
public class Student implements Comparable<Student>
{
	private String name;
	private String id;
	public  ArrayList<CreditCourse> courses; 

	/**
	 * Initializes name, id and courses
	 * @param name student name
	 * @param id student ID
	 */
	public Student(String name, String id)
	{
		this.name = name;
		this.id   = id;
		courses   = new ArrayList<CreditCourse>();
	}

	/**
	 * Accesses the student ID
	 * @return student ID
	 */
	public String getId()
	{
		return id;
	}

	/**
	 * Access the student name
	 * @return student name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Looks for the given course code in the student's credit course list
	 * and if found, returns the student's grade
	 * @param courseCode the course code for which the grade is requested
	 * @return the student's grade
	 */
	public double getGrade(String courseCode)
	{
		for (int i = 0; i < courses.size(); i++)
		{
			// looks for the course in the student's course list
			if (courses.get(i).getCode().equalsIgnoreCase(courseCode))
			{
				return courses.get(i).grade;
			}
		}
		return 0.0;
	}

	/**
	 * Adds a new credit course to the student's list of courses
	 * @param courseName the new course title
	 * @param courseCode the new course's code
	 * @param descr the course's description
	 * @param format the format of the course
	 * @param sem the semester the course was taken
	 * @param grade the student's initial grade
	 */
	public void addCourse(String courseName, String courseCode, String descr, String format,String sem, double grade)
	{
		// creates the credit course and renders it active 
		CreditCourse creditcourse = new CreditCourse(courseName, courseCode, descr, format, sem, grade);
		creditcourse.setActive();
		courses.add(creditcourse);
	}

	/**
	 * Assigns the final grade for the class and makes the course inactive
	 * @param courseCode the course code
	 * @param grade the final grade
	 */
	public void completeCourse(String courseCode, double grade)
	{
		for (int i = 0; i < courses.size(); i++)
		{
			// looks for the course in the student's course list
			if (courses.get(i).getCode().equalsIgnoreCase(courseCode))
			{
				// assigns the grade and renders the course inactive
				courses.get(i).grade = grade;
				courses.get(i).setInactive();
			}
		}
		
	}

	/**
	 * Checks if the given course was found in the student's course list
	 * @param courseCode the course code
	 * @return true or false, depending on if the course was found
	 */
	public boolean findCourse(String courseCode)
	{
		for (int i = 0; i < courses.size(); i++)
		{
			// looks for the course in the student's course list
			if (courses.get(i).getCode().equalsIgnoreCase(courseCode))
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * Prints a student's transcript with all their completed (i.e. non
	 * active) courses (course code, course name, semester, letter grade)
	 */
	public void printTranscript()
	{
		for (int i = 0; i < courses.size(); i++)
		{
			// prints only inactive courses in transcript
			if (!courses.get(i).getActive())
			{
				System.out.println(courses.get(i).displayGrade());
			}
		}
	}

	/**
	 * Prints a list of all active courses the student is currently
	 * enrolled in 
	 */
	public void printActiveCourses()
	{
		for (int i = 0; i < courses.size(); i++)
		{
			// prints info about active courses only
			if (courses.get(i).getActive())
			{
				System.out.println(courses.get(i).getDescription() + "\n");
			}
		}
	}

	/**
	 * Drops the given course from the student's course list if it
	 * is an active course
	 * @param courseCode course code of the course to be dropped
	 */
	public void removeActiveCourse(String courseCode)
	{
		for (int i = 0; i < courses.size(); i++) 
		{
			// looks for the course in the student's course list and ensures it's active before removing
			if (courses.get(i).getCode().equalsIgnoreCase(courseCode) && courses.get(i).getActive())
			{
				courses.remove(i);
			}
		}
	}

	/**
	 * Compares the names of students using the Comparable interface
	 * and sorts them alphabetically 
	 */
	public int compareTo(Student other)
	{
		return this.name.compareTo(other.name);
	}

	/**
	 * Overrides the toString() method inherited from the Object superclass
	 * and returns the student's ID and name
	 */
	public String toString()
	{
		return id + " " + name;
	}

	/**
	 * Overrides the equals() method inherited from the Object superclass, and
	 * returns true if both the name and ID of the student and the casted "other"
	 * student are equal or false otherwise
	 */
	public boolean equals(Object other)
	{
		Student otherStudent = (Student) other;
		// checks to see if student ID and student name are equal
		if (this.getName().equalsIgnoreCase(otherStudent.getName()) & this.getId().equals(otherStudent.getId()))
		{
			return true;
		}
		else
		{
			return false;
		}

	}

}
