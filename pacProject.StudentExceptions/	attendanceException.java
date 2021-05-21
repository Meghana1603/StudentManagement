package pacProject.StudentExceptions;

public class attendanceException extends Exception {
	String exceptionCondition;
	public attendanceException(String condition)
	{
		super(condition);
		exceptionCondition=condition;
		
	}
	public String toString()
	{
		return exceptionCondition;
	}
}
