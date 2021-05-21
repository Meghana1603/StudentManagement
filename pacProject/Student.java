package pacProject;
import java.io.IOException;
import java.util.HashMap;

interface Student {
	public void display(String rollno,HashMap<String, String[]> studDetails) throws IOException;
	public void grade(String rollno,HashMap<String, String[]> studDetails) throws IOException;
	public void attendance(String rollno,HashMap<String, String[]> studDetails) throws IOException;
	public void feepaid(String rollno,HashMap<String, String[]> studDetails) throws IOException;
}
