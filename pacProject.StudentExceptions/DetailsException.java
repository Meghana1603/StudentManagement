package pacProject.StudentExceptions;

public class DetailsException extends Exception{
	String exceptionCondition;
	public DetailsException(String condition)
	{
		super(condition);
		exceptionCondition=condition;
		
	}
	public String toString()
	{
		return exceptionCondition;
	}
}
