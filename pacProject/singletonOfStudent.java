package pacProject;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import pacProject.*;
import pacProject.StudentInformation.*;

public class singletonOfStudent {
	private static singletonOfStudent ref=null;
	String student_name, password;
	int roll_no,branch,fee;
	float cgpa,attendance;
	String rollno="";
	HashMap<String, String[]> studDetails = new HashMap<>();
	public static  singletonOfStudent getInstance()
	{
		if(ref==null)
			ref= new singletonOfStudent();
		return ref;
	}
	private void friendslist(String rollno2, HashMap<String, String[]> studDetails2) {
		String entries = null;
		String format = rollno2.substring(0, 8);
		for(Map.Entry<String, String[]> info : studDetails.entrySet())
		{
			entries = info.getKey();
			String[] str1 = info.getValue();
			Pattern p = Pattern.compile(format);
			Matcher m = p.matcher(entries);
			boolean matchFound = m.find();
		    if(matchFound && !entries.equals(rollno2)) {
						System.out.println("Roll Number: "+entries + " Name: "+ str1[1] + " Phone Number: " + str1[6]);
		    }
		}
		System.out.println();
	}
	synchronized public void Signup() throws IOException
	{
		//array containing count of students in each branch
		int[] students = {0,0,0,0,0,0};
		InputStream f1 = new FileInputStream("E:/studentInfo.txt");
		int i,flag=0;
		String str="";
		char b;
		//counting number f students in each branch irrespective of year joined
		while((i=f1.read())!=-1){
			 str+=(char)i;
			if((char)i=='\n' && !str.isBlank())
		 {
				b=str.charAt(7);
				if(b=='1')
					students[0]+=1;
				else if(b=='2')
					students[1]+=1;
				else if(b=='3')
					students[2]+=1;
				else if(b=='4')
					students[3]+=1;
				else if(b=='5')
					students[4]+=1;
				else if(b=='6')
					students[5]+=1;
			str="";	
		 }
		}
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your mail id:");
		String mail = input.next();
		System.out.println("Enter your name:");
		student_name=input.next();
		System.out.println("Enter password:");
		password=input.next();
		System.out.println("Enter your branch code(CSE-1,ECE-2,IT-3,EEE-4,MECH-5,CIVIL-6):");
		branch=input.nextInt();
		System.out.println("Enter your phone number:");
		String phone=input.next();
		//clg code-1602
		students[branch-1]+=1;
		roll_no=(1602*1000)+(branch*100)+(students[branch-1]);
		// generating student roll number based on the year the student joins
		int c = (Calendar.getInstance().get(Calendar.YEAR))%100;
		rollno+=c+"-"+roll_no;
		System.out.println("Your roll_no is: "+rollno);
		File studfile = new File("E:\\"+rollno+".txt");
		studfile.createNewFile();
		System.out.println("All the Best:-)");
		cgpa=0;//new student
		attendance=0;//new student
		fee=10000;//college fee
		String[] studentinfo= {password, student_name, cgpa+"",attendance+"", fee+"", mail, phone+""};
		ArrayList<String[]> d = new ArrayList<String[]>();
		d.add(studentinfo);
		//add details of new student in to map
		studDetails.put(rollno+"", studentinfo );
		try {
			//save data of students in to file
			saveData(rollno,studentinfo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		rollno="";
	}
	boolean saveData(String rollno, String[] studentinfo) throws IOException
	{
		FileOutputStream o = new FileOutputStream("E:/studentInfo.txt",true);
		String entries = null;
		for(Map.Entry<String, String[]> info : studDetails.entrySet())
		{
			entries = info.getKey() + " ";
			String[] str1 = info.getValue();
			info.setValue(str1);
			for(String s: str1)
			{
				entries+= s + " ";
			}
			entries+="\n";
		}
		//appending the details of new student to file 
		o.write(entries.getBytes());
		FileOutputStream recFile = new FileOutputStream("E:\\"+rollno+".txt");
		String details = "***Your Details***\n";
		details+="Roll Number: "+ rollno +"\n";
		details+="Password: "+ studentinfo[0]+"\n";
		details+="Student Name: "+ studentinfo[1] + "\n";
		details+="CGPA: "+ studentinfo[2]+"\n";
		details+="Attendance: "+studentinfo[3]+"\n";
		details+="Fee: "+studentinfo[4]+"\n";
		details += "***All the Best:-)***\n";
		recFile.write(details.getBytes());
		recFile.close();
		try {
			SendEmail mailToStudent = new SendEmail(rollno,"E:\\"+rollno+".txt",studentinfo[5]);
			mailToStudent.send_mail();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		recFile.close();
		return true;
	}
	synchronized void Login(int i,String rollno) throws IOException {
		BufferedReader f1 = new BufferedReader(new FileReader("E:/studentInfo.txt"));
		String line;
		//adding student details in file to map
		while((line = f1.readLine())!=null)
		{
			String[] d= line.split(" ");
			int size=d.length;
			String[] entries= new String[size-1];
			for(int itr=1;itr<size;itr++)
			{
				entries[itr-1]=d[itr];
			}
			studDetails.put(d[0], entries);
		}
		switch (i) {
		case 1:
			System.out.println("You have chosen to know your details");
			//creating object of Details class 
			Details details = new Details(rollno,studDetails);
			break;
		case 2:
			System.out.println("You have chosen to know your fee payment Status");
			//creating object of Feepaid class 
			Feepaid feepaid = new Feepaid(rollno,studDetails);
			break;
		case 3:
			System.out.println("You chosen to know your attendance percentage");
			//creating object of attendanceReport class 
			attendanceReport attendance = new attendanceReport(rollno,studDetails);
			break;
		case 4:
			System.out.println("You chosen to know your grade");
			//creating object of calculateResult class 
			calculateResult result = new calculateResult(rollno,studDetails);
			break;
		case 5:
			System.out.println("Your Friends list:");
			friendslist(rollno,studDetails);
			break;
		default:
			System.out.println("Invalid Option");
			break;
		}
	}
}
