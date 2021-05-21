package pacProject.StudentExceptions;

public class FeeException extends Exception {
	String exceptionCondition;
	public FeeException(String condition)
	{
		super(condition);
		exceptionCondition=condition;
		
	}
	public String toString()
	{
		return exceptionCondition;
	}
}
