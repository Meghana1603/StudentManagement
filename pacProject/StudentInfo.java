package pacProject;
import java.io.*;
import java.util.*;
import javax.swing.text.html.HTMLDocument.Iterator;
import pacProject.StudentExceptions.attendanceException;
import pacProject.StudentInformation.*;

public class StudentInfo implements Student {
	
	public void display(String rollno, HashMap<String, String[]> studDetails) throws IOException
	{
		for(Map.Entry<String, String[]> info : studDetails.entrySet())
		{
			String rollNumber = info.getKey();
			//displaying the details of required student from map
			if(rollNumber.equals(rollno))
			{
				System.out.println("Your Details:");
			String[] str1=info.getValue();
			info.setValue(str1);
			System.out.println("         Student Name: "+str1[1]);
			System.out.println("         CGPA: "+str1[2]);
			 System.out.println("         Attendance: "+str1[3]);
			 System.out.println("         Fee Amount: "+str1[4]);
			 System.out.println("--------------------------------------------------All the best!!!------------------------------------------------");
			 break;
			}
		}
	}
	public void feepaid(String rollno,HashMap<String, String[]> studDetails) throws IOException
	{
		String amount;
		//checks if the student paid total fee or not
		for(Map.Entry<String, String[]> info : studDetails.entrySet())
		{
			String rollNumber = info.getKey();
			if(rollNumber.equals(rollno))
			{
				String[] str1=info.getValue();
				info.setValue(str1);
				amount=str1[4];
				System.out.println("Due Amount: "+amount);
				if(amount.compareTo("0")==0)
				{
					System.out.println("Fee payment status: Paid total fee amount");
					System.out.println("ThankYou:-)");
					break;
				}
				else
				{
					//if total fee is not paid asks whether the student want to pay total fees or not
					System.out.println("Do you want to pay due amount(yes/no): ");
					Scanner input = new Scanner(System.in);
					String choice = input.next();
					//if student wants to pay total fee changing the due amount to 0
					if(choice.equalsIgnoreCase("yes"))
					{
						System.out.println("Fee payment status: Paid");
						System.out.println("Due amount: 0");
						str1[4]="0";
						info.setValue(str1);
						//modifying details if the student pays the fee
						FileOutputStream os = new FileOutputStream("E:/studentInfo.txt");
						String data="";
						String line;
						for(Map.Entry<String, String[]> info1 : studDetails.entrySet())
						{
							String entries =info1.getKey() + " ";
							String[] str11 = info1.getValue();
							info1.setValue(str11);
							for(String s: str11)
							{
								entries+= s + " ";
							}
							entries+="\n";
							data+=entries;
						}
						os.write(data.getBytes());
						os.close();
						FileOutputStream recFile = new FileOutputStream("E:\\"+rollno+".txt");
						String details = "***Your Details***\n";
						details+="Roll Number: "+ rollno +"\n";
						details+="Password: "+ str1[0]+"\n";
						details+="Student Name: "+ str1[1] + "\n";
						details+="CGPA: "+ str1[2]+"\n";
						details+="Attendance: "+str1[3]+"\n";
						details+="Fee: "+str1[4]+"\n";
						details += "***All the Best:-)***\n";
						recFile.write(details.getBytes());
						recFile.close();
						try {
							SendEmail mailToStudent = new SendEmail(rollno,"E:\\"+rollno+".txt",str1[5]);
							mailToStudent.send_mail();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						recFile.close();
					}
					//if the student don't want to pay throws exception
					else if(amount.compareTo("0")!=0)
					{
						Feepaid feepaid = new Feepaid();
						feepaid.anyException("Total fee not paid", amount);
					}
					else
					{
						System.out.println("Fee payment status: Paid total fee amount");
						System.out.println("ThankYou:-)");
					}
					break;
				}
			}
		}
	}
	public void grade(String rollno,HashMap<String, String[]> studDetails) throws IOException
	{
		String grades;
		int flag=0;
		for(Map.Entry<String, String[]> info : studDetails.entrySet())
		{
			String rollNumber = info.getKey();
			// displays the grade of required student 
			if(rollNumber.equals(rollno))
			{
				String[] str1=info.getValue();
				grades=str1[2];
				info.setValue(str1);
				System.out.println("Grade: "+grades);
				// if his grade is less than 5.0 then exception is caused
				if(Float.parseFloat(grades) < 5.0)
				{
					calculateResult result = new calculateResult();
					result.anyException("Failed in prevoius semester");
				}
				// asks him whether he want present semester grade 
				System.out.println("Do you want to know your present semester grade(yes/no): ");
				Scanner input = new Scanner(System.in);
				String choice = input.next();
				//if yes he need to enter marks in 6 subjects and we display his grade and update his details
				if(choice.equalsIgnoreCase("yes"))
				{
					ArrayList marks = new ArrayList();
					System.out.println("Enter your marks in 6 courses out of 100:");
					for(int itr=0;itr<6;itr++)
					{
						int mark=input.nextInt();
						marks.add(mark);
					}
					java.util.Iterator itr = marks.iterator();
					int sum=0;
					while(itr.hasNext())
					{
						sum += (int) itr.next();
					}
					float finalgrade=sum/60;
					System.out.println("Your present semester grade is: "+ finalgrade);
					str1[2]=finalgrade+"";
					info.setValue(str1);
					//if his grade is less than 5.0 exception cccurs
					if(finalgrade < 5.0)
					{
						calculateResult result = new calculateResult();
						result.anyException("Failed");
					}
					//updating grade to present semester grade
					FileOutputStream os = new FileOutputStream("E:/studentInfo.txt");
					String data="";
					String line;
					for(Map.Entry<String, String[]> info1 : studDetails.entrySet())
					{
						String entries =info1.getKey() + " ";
						String[] str11 = info1.getValue();
						for(String s: str11)
						{
							entries+= s + " ";
						}
						entries+="\n";
						data+=entries;
					}
					os.write(data.getBytes());
					os.close();
					FileOutputStream recFile = new FileOutputStream("E:\\"+rollno+".txt");
					String details = "***Your Details***\n";
					details+="Roll Number: "+ rollno +"\n";
					details+="Password: "+ str1[0]+"\n";
					details+="Student Name: "+ str1[1] + "\n";
					details+="CGPA: "+ str1[2]+"\n";
					details+="Attendance: "+str1[3]+"\n";
					details+="Fee: "+str1[4]+"\n";
					details += "***All the Best:-)***\n";
					recFile.write(details.getBytes());
					recFile.close();
					try {
						SendEmail mailToStudent = new SendEmail(rollno,"E:\\"+rollno+".txt",str1[5]);
						mailToStudent.send_mail();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					recFile.close();
				}
				flag=1;
				break;
			}
		}
		if(flag==0)
		{
			System.out.println("ThankYou:-)");
		}
	}
	public void attendance(String rollno,HashMap<String, String[]> studDetails) throws IOException
	{
		int totalClasses=300;
		String attendanceCalci;
		int flag=0;
		for(Map.Entry<String, String[]> info : studDetails.entrySet())
		{
			String rollNumber = info.getKey();
			if(rollNumber.equals(rollno))
			{
				String[] str1=info.getValue();
				attendanceCalci=str1[3];
				info.setValue(str1);
				attendanceReport attend = new attendanceReport();
				System.out.println("Attendance: "+attendanceCalci);
				//if attendance less than 75% eception is caused
				if(Float.parseFloat(attendanceCalci)<75)
				{
					attend.anyException("Lessthan 75% Attendance");
				}
				else if(Float.parseFloat(attendanceCalci)<65)
				{
					attend.anyException("LessThan 65% Attendance");
				}
				//if he wants present semester attendance he need t enter how many classes he attended
				System.out.println("Do you want to know your present semester atttendance(yes/no): ");
				Scanner input = new Scanner(System.in);
				String choice = input.next();
				if(choice.equalsIgnoreCase("yes"))
				{
					System.out.println("Enter number of classes you attended: ");
					int noOfClasses=input.nextInt();
					float attendPer=(noOfClasses / (totalClasses/100));
					System.out.println("Your present semester Attendance percentage is: "+ attendPer);
					str1[3]=attendPer+"";
					info.setValue(str1);
					//if attendance less than 75% eception is caused
					if(attendPer<75)
					{
						attend.anyException("Lessthan 75% Attendance");
					}
					else if(attendPer<65)
					{
						attend.anyException("LessThan 65% Attendance");
					}
					//updating the present semester attendance percentage of student
					FileOutputStream os = new FileOutputStream("E:/studentInfo.txt");
					String data="";
					String line;
					for(Map.Entry<String, String[]> info1 : studDetails.entrySet())
					{
						String entries =info1.getKey() + " ";
						String[] str11 = info1.getValue();
						for(String s: str11)
						{
							entries+= s + " ";
						}
						entries+="\n";
						data+=entries;
					}
					os.write(data.getBytes());
					os.close();
					FileOutputStream recFile = new FileOutputStream("E:\\"+rollno+".txt");
					String details = "***Your Details***\n";
					details+="Roll Number: "+ rollno +"\n";
					details+="Password: "+ str1[0]+"\n";
					details+="Student Name: "+ str1[1] + "\n";
					details+="CGPA: "+ str1[2]+"\n";
					details+="Attendance: "+str1[3]+"\n";
					details+="Fee: "+str1[4]+"\n";
					details += "***All the Best:-)***\n";
					recFile.write(details.getBytes());
					recFile.close();
					try {
						SendEmail mailToStudent = new SendEmail(rollno,"E:\\"+rollno+".txt",str1[5]);
						mailToStudent.send_mail();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					recFile.close();
				}
				flag=1;
				break;
			}
		}
		if(flag==0)
		{
			System.out.println("ThankYou:-)");
		}
		  
	}
}
