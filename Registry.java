// Alina Tariq | 500989574

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Registry
{

	private TreeMap<String, Student> students = new TreeMap<String, Student>();
	public TreeMap<String, ActiveCourse> courses = new TreeMap<String, ActiveCourse>();

	/**
	 * Creates a Registry, manually adding in students and active courses
	 * @throws NoSuchElementException 
	 * @throws FileNotFoundException 
	 */
	public Registry(String filename) throws FileNotFoundException, NoSuchElementException
	{
		// Adds students to the registry
		readStudents(filename);

		// Initializes class list
		ArrayList<Student> list = new ArrayList<Student>();

		// Creates active course objects and adds student to them
		// CPS209
		String courseName = "Computer Science II";
		String courseCode = "CPS209";
		String descr = "Learn how to write complex programs!";
		String format = "3Lec 2Lab";
		// adds students to class list
		list.add(students.get("38467"));
		list.add(students.get("98345"));
		list.add(students.get("57643"));
		list.add(students.get("25347"));
		// creates the course 
		courses.put(courseCode, new ActiveCourse(courseName,courseCode,descr,format,"W2020",list));
		// adds course to students' list of courses
		students.get("38467").addCourse(courseName,courseCode,descr,format,"W2020", 0); 
		students.get("98345").addCourse(courseName,courseCode,descr,format,"W2020", 0); 
		students.get("57643").addCourse(courseName,courseCode,descr,format,"W2020", 0);
		students.get("25347").addCourse(courseName,courseCode,descr,format,"W2020", 0);

		// CPS511
		list.clear();
		// sets up course details 
		courseName = "Computer Graphics";
		courseCode = "CPS511";
		descr = "Learn how to write cool graphics programs";
		format = "3Lec";
		// adds students to class list
		list.add(students.get("34562"));
		list.add(students.get("57643"));
		list.add(students.get("25347"));
		list.add(students.get("46532"));
		// creates the course
		courses.put(courseCode, new ActiveCourse(courseName,courseCode,descr,format,"F2020",list));
		// adds course to students' list of courses
		students.get("34562").addCourse(courseName,courseCode,descr,format,"F2020", 0);
		students.get("57643").addCourse(courseName,courseCode,descr,format,"F2020", 0);
		students.get("25347").addCourse(courseName,courseCode,descr,format,"F2020", 0); 
		students.get("46532").addCourse(courseName,courseCode,descr,format,"F2020", 0);

		// CPS643
		list.clear();
		// sets up course details
		courseName = "Virtual Reality";
		courseCode = "CPS643";
		descr = "Learn how to write extremely cool virtual reality programs";
		format = "3Lec 2Lab";
		// adds students to class list
		list.add(students.get("34562"));
		list.add(students.get("38467"));
		list.add(students.get("57643"));
		list.add(students.get("46532"));
		// creates the course 
		courses.put(courseCode, new ActiveCourse(courseName,courseCode,descr,format,"W2020",list));
		// adds course to students' list of courses
		students.get("34562").addCourse(courseName,courseCode,descr,format,"W2020", 0); 
		students.get("38467").addCourse(courseName,courseCode,descr,format,"W2020", 0); 
		students.get("57643").addCourse(courseName,courseCode,descr,format,"W2020", 0); 
		students.get("46532").addCourse(courseName,courseCode,descr,format,"W2020", 0); 

		// CPS616
		list.clear();
		// sets up course details
		courseName = "Algorithms";
		courseCode = "CPS616";
		descr = "Learn about Algorithms";
		format = "3Lec 1Lab";
		// adds students to class list
		list.add(students.get("34562"));
		list.add(students.get("38467"));
		list.add(students.get("98345"));
		list.add(students.get("57643"));
		// creates the course 
		courses.put(courseCode, new ActiveCourse(courseName,courseCode,descr,format,"W2020",list));
		// adds course to students' list of courses
		students.get("34562").addCourse(courseName,courseCode,descr,format,"W2020", 0); 
		students.get("38467").addCourse(courseName,courseCode,descr,format,"W2020", 0); 
		students.get("98345").addCourse(courseName,courseCode,descr,format,"W2020", 0); 
		students.get("57643").addCourse(courseName,courseCode,descr,format,"W2020", 0); 

		// CPS706
		list.clear();
		// sets up course details
		courseName = "Computer Networks";
		courseCode = "CPS706";
		descr = "Learn about Computer Networking";
		format = "3Lec 1Lab";
		// adds students to class list
		list.add(students.get("34562"));
		list.add(students.get("98345"));
		list.add(students.get("25347"));
		list.add(students.get("46532"));
		// creates the course 
		courses.put(courseCode, new ActiveCourse(courseName,courseCode,descr,format,"W2020",list));
		// adds course to students' list of courses
		students.get("34562").addCourse(courseName,courseCode,descr,format,"W2020", 0);
		students.get("98345").addCourse(courseName,courseCode,descr,format,"W2020", 0);
		students.get("25347").addCourse(courseName,courseCode,descr,format,"W2020", 0);
		students.get("46532").addCourse(courseName,courseCode,descr,format,"W2020", 0);

		list.clear();
	}

	/**
	 * Adds a new student to the registry
	 * @param name the student name
	 * @param id the student ID
	 * @return true if the student doesn't already exist and false otherwise
	 */
	public boolean addNewStudent(String name, String id)
	{
		if (!isNumeric(id))
		{
			throw new IllegalArgumentException("Invalid Student ID");
		}
		else if (!isAlphaOnly(name))
		{
			throw new IllegalArgumentException("Invalid Student Name");
		}
		// creates a new Student object
		Student s7 = new Student(name, id);

		// checks to make sure student doesn't already
		// exist in the registry before adding them in
		
		if (students.containsKey(id))
		{
			return false;
		}
		else 
		{
			students.put(id, s7);
			return true;
		}
	}

	/**
	 * Removes a student from the registry
	 * @param studentId the student ID
	 * @return true is the student was remove, false if the
	 * student was not found
	 */
	public boolean removeStudent(String studentId)
	{
		
		if (!isNumeric(studentId))
		{
			throw new IllegalArgumentException("Invalid Student ID");
		}
		
		// checks to see if the student exists in the registry
		// and removes them if they do
		
		if (students.containsKey(studentId))
		{
			students.remove(studentId);
			return true;
		}
		else 
		{
			// returns false if the student did not exist
			return false;
		}
	}

	/**
	 * Prints out a list of all students in the registry (ID and name)
	 */
	public void printAllStudents()
	{
		Set<String> allKeys = students.keySet();
		for (String key : allKeys)
			System.out.println(students.get(key));
	}

	/**
	 * Adds a student to the given course if the course is active and
	 * the student has not already taken it or are currently enrolled
	 * @param studentId the student ID
	 * @param courseCode the course code
	 */
	public void addCourse(String studentId, String courseCode)
	{
		if (!isNumeric(studentId))
		{
			throw new IllegalArgumentException("Invalid Student ID");
		}
		else if (isNumeric(courseCode) || isAlphaOnly(courseCode))
		{
			throw new IllegalArgumentException("Invalid Course Code");
		} 

		courseCode = courseCode.toUpperCase();
		
		// looks for the student in the registry 
		if (students.containsKey(studentId))
		{
			// ensures the student has not taken the course previously
			if(!students.get(studentId).findCourse(courseCode))
			{
				// finds the course from the active courses list 
				if (courses.containsKey(courseCode))
				{
					// if the student is not currently enrolled, adds them
					// to the course and adds the course to their course list
					if (!courses.get(courseCode).findStudent(studentId)) 
					{
						String cName = courses.get(courseCode).getName();
						String cCode = courses.get(courseCode).getCode();
						String cFrmt = courses.get(courseCode).getFormat();
						String cDescr = courses.get(courseCode).getDescrShort();
						String cSem = courses.get(courseCode).getSemester();
						courses.get(courseCode).addStudent(students.get(studentId));
						students.get(studentId).addCourse(cName, cCode, cDescr, cFrmt, cSem, 0);
					}
					else 
					{
						System.out.println("Student " + studentId + " is already enrolled");
					}
				}
				else
				{
					System.out.println("Course " + courseCode + " not found");
				}
			}
			else
			{
				System.out.println("Student " + studentId + " has already taken course " + courseCode);
			}
		}
		else
		{
			System.out.println("Student " + studentId + " not found");
		}
	}

	/**
	 * Drops the given student from the given course
	 * @param studentId the student ID
	 * @param courseCode the course code
	 */
	public void dropCourse(String studentId, String courseCode)
	{
		if (!isNumeric(studentId))
		{
			throw new IllegalArgumentException("Invalid Student ID");
		}
		else if (isNumeric(courseCode) || isAlphaOnly(courseCode))
		{
			throw new IllegalArgumentException("Invalid Course Code");
		} 
		
		courseCode = courseCode.toUpperCase();

		// looks for the course in the active courses list
		if (courses.containsKey(courseCode))
		{
			// checks to see if the student is enrolled in the course
			// and removes them from the course and the course from
			// their credit course list
			if (courses.get(courseCode).findStudent(studentId))
			{
				courses.get(courseCode).removeStudent(studentId);
				students.get(studentId).removeActiveCourse(courseCode);
			}
			else
			{
				System.out.println("Student " + studentId + " not found");
			}
		}
		else 
		{
			System.out.println("Course " + courseCode + " not found");
		}
	}

	/**
	 * Prints out information on all current active courses
	 */
	public void printActiveCourses()
	{
		Set<String> allKeys = courses.keySet();
		for (String key : allKeys)
			System.out.println(courses.get(key).getDescription());
	}

	/**
	 * Prints out the class list of the given active course
	 * @param courseCode the course code
	 */
	public void printClassList(String courseCode)
	{
		if (isNumeric(courseCode) || isAlphaOnly(courseCode))
		{
			throw new IllegalArgumentException("Invalid Course Code");
		}

		courseCode = courseCode.toUpperCase();

		if (courses.containsKey(courseCode))
		{
			courses.get(courseCode).printClassList();
		}
		else
		{
			System.out.println("Course " + courseCode + " not found");
		}
	}
	
	/**
	 * Clears the class list for specified course
	 * @param courseCode the course to be cleared
	 */
	public void clearClassList(String courseCode)
	{
		if (isNumeric(courseCode) || isAlphaOnly(courseCode))
		{
			throw new IllegalArgumentException("Invalid Course Code");
		}

		courseCode = courseCode.toUpperCase();

		if (courses.containsKey(courseCode))
		{
			courses.get(courseCode).clearClassList();
		}
		else
		{
			System.out.println("Course " + courseCode + " not found");
		}
	}


	/**
	 * Looks for the given course in the active courses list and sorts
	 * the class list by student name alphabetically
	 * @param courseCode the course code
	 */
	public void sortCourseByName(String courseCode)
	{
		if (isNumeric(courseCode) || isAlphaOnly(courseCode))
		{
			throw new IllegalArgumentException("Invalid Course Code");
		}

		courseCode = courseCode.toUpperCase();
		
		// makes sure the course is an active course
		if (courses.containsKey(courseCode))
		{
				courses.get(courseCode).sortByName();
		}
		else
		{
			System.out.println("Course " + courseCode + " not found");
		}
	
	}

	/**
	 * Looks for the given course in the active courses list and sorts
	 * the class list by student ID in order
	 * @param courseCode the course code
	 */
	public void sortCourseById(String courseCode)
	{
		if (isNumeric(courseCode) || isAlphaOnly(courseCode))
		{
			throw new IllegalArgumentException("Invalid Course Code");
		}
		
		courseCode = courseCode.toUpperCase();
		
		// makes sure the course is an active course
		if (courses.containsKey(courseCode))
		{
				courses.get(courseCode).sortById();
		}
		else
		{
			System.out.println("Course " + courseCode + " not found");
		}	 
		
	}

	/**
	 * Prints out the grades of all the students in the given course
	 * @param courseCode the course code
	 */
	public void printGrades(String courseCode)
	{
		if (isNumeric(courseCode) || isAlphaOnly(courseCode))
		{
			throw new IllegalArgumentException("Invalid Course Code");
		}
		
		courseCode = courseCode.toUpperCase();

		if (courses.containsKey(courseCode))
		{
				courses.get(courseCode).printGrades();
		}
		else
		{
			System.out.println("Course " + courseCode + " not found");
		}
	}

	/**
	 * Prints out all the active courses, the given student is
	 * currently enrolled in
	 * @param studentId the student ID
	 */
	public void printStudentCourses(String studentId)
	{
		if (!isNumeric(studentId))
		{
			throw new IllegalArgumentException("Invalid Student ID");
		}

		if (students.containsKey(studentId))
		{
				students.get(studentId).printActiveCourses();
		}
		else
		{
			System.out.println("Student " + studentId + " not found");
		}
	}

	/**
	 * Prints out a list of all completed courses and final 
	 * grades for the given student
	 */
	public void printStudentTranscript(String studentId)
	{
		if (!isNumeric(studentId))
		{
			throw new IllegalArgumentException("Invalid Student ID");
		}

		if (students.containsKey(studentId))
		{
			students.get(studentId).printTranscript();
		}
		else
		{
			System.out.println("Student " + studentId + " not found");
		}
	}

	/**
	 * Submits the final grade the student achieved in a given course
	 * and renders the course inactive 
	 * @param courseCode the course code
	 * @param studentId the student ID
	 * @param grade the student's final score
	 */
	public void setFinalGrade(String courseCode, String studentId, double grade)
	{

		if (isNumeric(courseCode) || isAlphaOnly(courseCode))
		{
			throw new IllegalArgumentException("Invalid Course Code");
		}
		else if (!isNumeric(studentId))
		{
			throw new IllegalArgumentException("Invalid Student ID");
		}
		else if (grade < 0 || grade > 100)
		{
			throw new IllegalArgumentException("Invalid grade");
		}

		courseCode = courseCode.toUpperCase();

		// looks for the course in the active courses list 
		if (courses.containsKey(courseCode))
		{
			// looks for the student in the class if course found
			if (courses.get(courseCode).findStudent(studentId))
			{
				// sets the final grade and marks course as complete
				students.get(studentId).completeCourse(courseCode, grade);
			}

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

	/**
	 * Reads in the names and ids of students from the given file
	 * @param filename the name of the file containing student information
	 * @throws FileNotFoundException
	 * @throws NoSuchElementException
	 */
	public void readStudents(String filename) throws FileNotFoundException, NoSuchElementException
	{
		File studentList = new File(filename);
		Scanner scanner = new Scanner(studentList);

		while (scanner.hasNextLine())
		{
			String name = scanner.next();
			String id = scanner.next();
			Student newStudent = new Student(name, id);
			students.put(id, newStudent);
		}
		
		scanner.close();
	}

}
