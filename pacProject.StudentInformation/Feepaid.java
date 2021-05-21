package pacProject.StudentInformation;
import java.io.IOException;
import java.util.HashMap;
import pacProject.StudentInfo;
import pacProject.StudentExceptions.FeeException;

public class Feepaid extends StudentInfo{
	public Feepaid(String rollno,HashMap<String, String[]> studDetails) throws IOException
	{
		feepaid(rollno,studDetails);
	}
	public Feepaid() {
		
	}
	public void anyException(String exc,String dueAmount) 
	{
		//Identify, catch and handle exception
		try {
			throw new FeeException(exc);
		}
		catch(FeeException e)
		{
			String response=e.toString();
			System.out.println(e);
			if("Total fee not paid".contentEquals(response))
				System.out.println("Pay the remaining amount: "+dueAmount+" by the end of this month");
		}
	}
}
