// Alina Tariq | 500989574

public class CreditCourse extends Course
{
    private String semester;
    public double grade;
    public boolean active;
    
    /**
     * A constuctor method to initialize a credit course using
     * inherited variables name, code, descr, fmt from the super
     * class (Course) along with local variables semester and grade 
     * @param name the course name
     * @param code the course code
     * @param descr the course description
     * @param fmt the course format
     * @param semester the semester the course was taken
     * @param grade the grade earned 
     */
	public CreditCourse(String name, String code, String descr, String fmt, String semester, double grade)
	{
	    super(name, code, descr, fmt);
	    this.semester = semester;
	    this.grade = grade;
	}
	
	/**
	 * Returns whether or not the course is active
	 * @return the course's active status
	 */
	public boolean getActive()
	{
		return active;
	}
	
	/**
	 * Marks the course as active
	 */
	public void setActive()
	{
		active = true;
	}
	
	/**
	 * Marks the course as inactive
	 */
	public void setInactive()
	{
		active = false;
	}
	
	/**
	 * Returns info about the course (code, name, semester, grade)
	 * @return the course code, name, semester, and alphabet grade earned
	 */
	public String displayGrade()
	{
		return getInfo() + " " + semester + " Grade: " + convertNumericGrade(grade);
	}
	
}
