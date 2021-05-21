package pacProject.StudentExceptions;

public class gradeException extends Exception{
	String exceptionCondition;
	public gradeException(String condition)
	{
		super(condition);
		exceptionCondition=condition;
		
	}
	public String toString()
	{
		return exceptionCondition;
	}
}
