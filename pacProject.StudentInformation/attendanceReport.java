package pacProject.StudentInformation;
import java.io.IOException;
import java.util.HashMap;
import pacProject.StudentInfo;
import pacProject.StudentExceptions.attendanceException;

public class attendanceReport extends StudentInfo{
	public attendanceReport(String rollno,HashMap<String, String[]> studDetails) throws IOException
	{
		attendance(rollno,studDetails);
	}
	public attendanceReport() {
		// TODO Auto-generated constructor stub
	}
	public void anyException(String exc) 
	{
		//Identify, catch and handle exception
		try {
			throw new attendanceException(exc);
		}
		catch(attendanceException e)
		{
			String response=e.toString();
			System.out.println(e);
			if("Lessthan 75% Attendance".contentEquals(response))
			{
				System.out.println("Try to maintain 75% attendance");
			}
			else if("Lessthan 65% Attendance".contentEquals(response))
			{
				System.out.println("Your attendance is less than 65%.\nSubmit medicals reports if any, else serious action we be taken");
			}
		}
	}
}
