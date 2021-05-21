package pacProject.StudentInformation;
import java.io.IOException;
import java.util.HashMap;

import pacProject.StudentInfo;
import pacProject.StudentExceptions.gradeException;

public class calculateResult extends StudentInfo {
	public calculateResult(String rollno, HashMap<String, String[]> studDetails) throws IOException
	{
		grade(rollno,studDetails);
	}
	public calculateResult() {
		// TODO Auto-generated constructor stub
	}
	public void anyException(String exc) 
	{
		//Identify, catch and handle exception
		try {
			throw new gradeException(exc);
		}
		catch(gradeException e)
		{
			String response=e.toString();
			System.out.println(e);
			if("Failed".contentEquals(response))
				System.out.println("You failed in the exams.\nDo not repeat this, write supplimentary exams");
			else if("Failed in prevoius semester".contentEquals(response))
				System.out.println("Clear yur backlogs");
		}
	}
}
