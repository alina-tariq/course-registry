// Alina Tariq | 500989574

public class Course 
{
	private String code;
	private String name;
	private String description;
	private String format;

	/**
	 * Initializes an empty course using the name, code,
	 * descr, and fmt variables
	 */
	public Course()
	{
		this.code        = "";
		this.name        = "";
		this.description = "";
		this.format      = "";
	}

	/**
	 * Initializes name, code, descr, and fmt of a course
	 * @param name the course name
	 * @param code the course code 
	 * @param descr the course description
	 * @param fmt the course format
	 */
	public Course(String name, String code, String descr, String fmt)
	{
		this.code        = code;
		this.name        = name;
		this.description = descr;
		this.format      = fmt;
	}

	/**
	 * Accesses and returns the course code
	 * @return the course code
	 */
	public String getCode()
	{
		return code;
	}

	/**
	 * Accesses and returns the course name
	 * @return the course name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Accesses and returns the course format
	 * @return the course format
	 */
	public String getFormat()
	{
		return format;
	}

	/**
	 * Accesses and returns course information, namely course code,
	 * name, description, and format
	 * @return course code, name, description, and format
	 */
	public String getDescription()
	{
		return code + " - " + name + "\n" + description + "\n" + format;
	}

	/**
	 * Accesses and returns only the course description
	 * @return the course description
	 */
	public String getDescrShort()
	{
		return description;
	}

	/**
	 * Accesses and returns course information (code and name)
	 * @return course code and course name
	 */
	public String getInfo()
	{
		return code + " - " + name;
	}

	/** 
	 * A static method to convert the numeric grade to a letter grade string
	 * @param score the student's numeric grade
	 * @return the student's letter grade
	 */
	public static String convertNumericGrade(double score)
	{
		// converts numeric score and returns letter grade
		if (score >= 90)
		{
			return "A+";
		}
		else if (score >= 85) 
		{
			return "A";
		}
		else if (score >= 80) 
		{
			return "A-";
		}
		else if (score >= 77)
		{
			return "B+";
		}
		else if (score >= 73)
		{
			return "B";
		}
		else if (score >= 70)
		{
			return "B-";
		}
		else if (score >= 67)
		{
			return "C+";
		}
		else if (score >= 63)
		{
			return "C";
		}
		else if (score >= 60)
		{
			return "C-";
		}
		else if (score >= 57)
		{
			return "D+";
		}
		else if (score >= 53)
		{
			return "D";
		}
		else if (score >= 50)
		{
			return "D-";
		}
		else {
			return "F";
		}
	}

}
