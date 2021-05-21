package pacProject.StudentInformation;
import java.io.*;
import java.util.*;
import pacProject.StudentInfo;
import pacProject.StudentExceptions.*;

public class Details extends StudentInfo {
	public Details(String rollno, HashMap<String, String[]> studDetails) throws IOException
	{
		display(rollno,studDetails);
	}
	
	public Details() {
	}

	public void anyException(String exc) 
	{
		//Identify, catch and handle exception
		try {
			throw new DetailsException(exc);
		}
		catch(DetailsException e)
		{
			String response=e.toString();
			System.out.println(e);
			if("Invalid details".contentEquals(response))
				System.out.println("Enter details properly");
		}
	}
}
