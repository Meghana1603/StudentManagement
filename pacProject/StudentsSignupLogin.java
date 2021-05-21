package pacProject;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import javax.swing.*;
import pacProject.StudentInformation.*;

public class StudentsSignupLogin extends JFrame{
	  static String qual = " ";
	  JPanel panel;
	   JLabel user_label, password_label, message;
	   JTextField userName_text;
	   JPasswordField password_text;
	   JButton submit, cancel;
	   JRadioButton jRadioButton1;  
	    JRadioButton jRadioButton2; 
	    JButton jButton; 
	    ButtonGroup G1; 
	    JLabel L1; 
	    static JFrame frame2 = new JFrame("Please Enter Clg Password!");
	 public StudentsSignupLogin() {
	        super("Welcome to VASAVI!!!");
	        JLabel L1 = new JLabel("Qualification:"); 
	        JRadioButton option1 = new JRadioButton("Student");
	        JRadioButton option2 = new JRadioButton("Faculty");
	        JButton jButton = new JButton("Click");
	        ButtonGroup group = new ButtonGroup();
	        option1.setBounds(120, 30, 120, 50);
	        option2.setBounds(250, 30, 80, 50);
	        jButton.setBounds(125, 90, 80, 30); 
	        L1.setBounds(20, 30, 150, 50);
	        this.add(option1);
	        this.add(option2); 
	        setLayout(new FlowLayout());
	        this.add(L1); 
	        add(option1);
	        add(option2);
	        add(jButton);
	        setPreferredSize(new Dimension(400, 300));
	        this.setVisible(true);
	        jButton.addActionListener(new ActionListener() { 
	            // Anonymous class. 
	  
	            public void actionPerformed(ActionEvent e) 
	            { 
	                // Override Method 
	  
	                // Declaration of String class Objects.  
	  
	                // If condition to check if jRadioButton2 is selected. 
	                if (option1.isSelected()) { 
	  
	                    qual = "Student"; 
	                    JOptionPane.showMessageDialog(StudentsSignupLogin.this, qual);
	                    Student();
	                } 
	  
	                else if (option2.isSelected()) { 
	                	qual = "Faculty"; 
	                	JOptionPane.showMessageDialog(StudentsSignupLogin.this, qual);
	                	dispose();
	                	faculty();
	                	
	                } 
	                else { 
	  
	                    qual = "NO Button selected"; 
	                    JOptionPane.showMessageDialog(StudentsSignupLogin.this, qual);
	                } 
	  
	                // MessageDialog to show information selected radion buttons.  
	                dispose();
	            } 
	        });
	        pack();
	    }
	 public void faculty()
	 {
         // Password Label
         password_label = new JLabel();
         password_label.setText("Password :");
         password_text = new JPasswordField();
         // Submit
         submit = new JButton("SUBMIT");
         panel = new JPanel(new GridLayout(3, 1));
         panel.add(password_label);
         panel.add(password_text);
         message = new JLabel();
         panel.add(message);
         panel.add(submit);
         // Adding the listeners to components..
         submit.addActionListener(new ActionListener()
        		 {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if(password_text.getText().trim().equals("1602vce"))
				         {
							frame2.dispose();
				         HashMap<String, String[]> studDetails = new HashMap<>();
							BufferedReader f1 = null;
							try {
								f1 = new BufferedReader(new FileReader("E:/studentInfo.txt"));
							} catch (FileNotFoundException e3) {
								// TODO Auto-generated catch block
								e3.printStackTrace();
							}
							String line;
							try {
								while((line = f1.readLine())!=null)
								{
									String[] d= line.split(" ");
									int size=d.length;
									String[] entries= new String[size-1];
									for(int itr=1;itr<size;itr++)
										entries[itr-1]=d[itr];
									studDetails.put(d[0], entries);
								}
							} catch (IOException e2) {
								e2.printStackTrace();
							}
							try {
								f1.close();
							} catch (IOException e1) {
																                            e1.printStackTrace();
							}
							JFrame f;    
							    f=new JFrame("Lists");
							    JButton button = new JButton("Close");
							    final JLabel label = new JLabel();          
							    label.setHorizontalAlignment(JLabel.CENTER);  
							    label.setSize(400,100);  
							    JButton b=new JButton("Show"); 
							    button.setBounds(200,200,100,30);
							    b.setBounds(200,100,75,20);  
							    String languages[]={"Attendance List","CGPA List", "Fee Payment List"};        
							    final JComboBox cb=new JComboBox(languages);    
							    cb.setBounds(50, 100,90,20);    
							    f.add(cb); f.add(label); f.add(b);   
							    f.setLayout(null);    
							    f.add(button);
							    f.setSize(350,350);    
							    f.setVisible(true);       
							    b.addActionListener(new ActionListener() {  
							        public void actionPerformed(ActionEvent e) {       
							int option = cb.getSelectedIndex();
							facultyChoice(option+1, studDetails);
							}  
							});
							    button.addActionListener(new ActionListener() {  
							        public void actionPerformed(ActionEvent e) {       
							System.exit(0);
							}  
							});  
				         }
				         else
				         	JOptionPane.showMessageDialog(StudentsSignupLogin.this,"Wrong Password:-)");
					}
        	 
        		 });
         frame2.add(panel, BorderLayout.CENTER);
         frame2.setSize(450,350);
         frame2.setVisible(true);
	 }
	 void Student()
	 {
		 Thread t;
		 Scanner input = new Scanner(System.in);
		 singletonOfStudent stud = new singletonOfStudent().getInstance();
    		if(qual.equalsIgnoreCase("Student")) {
    			JFrame f11 = new JFrame("Student Form");
    			f11.setLayout(null); 
    			  
    	        // Initialization of object of "JRadioButton" class. 
    	        jRadioButton1 = new JRadioButton(); 
    	  
    	        // Initialization of object of "JRadioButton" class. 
    	        jRadioButton2 = new JRadioButton(); 
    	  
    	        // Initialization of object of "JButton" class. 
    	        jButton = new JButton("Click"); 
    	  
    	        // Initialization of object of "ButtonGroup" class. 
    	        G1 = new ButtonGroup(); 
    	  
    	        // Initialization of object of " JLabel" class. 
    	        L1 = new JLabel("Choice:"); 
    	  
    	        // setText(...) function is used to set text of radio button. 
    	        // Setting text of "jRadioButton2". 
    	        jRadioButton1.setText("signup"); 
    	  
    	        // Setting text of "jRadioButton4". 
    	        jRadioButton2.setText("login"); 
    	  
    	        // Setting Bounds of "jRadioButton2". 
    	        jRadioButton1.setBounds(120, 30, 120, 50); 
    	  
    	        // Setting Bounds of "jRadioButton4". 
    	        jRadioButton2.setBounds(250, 30, 80, 50); 
    	  
    	        // Setting Bounds of "jButton". 
    	        jButton.setBounds(125, 90, 80, 30); 
    	  
    	        // Setting Bounds of JLabel "L2". 
    	        L1.setBounds(20, 30, 150, 50); 
    	  
    	        // "this" keyword in java refers to current object. 
    	        // Adding "jRadioButton2" on JFrame. 
    	        f11.add(jRadioButton1); 
    	  
    	        // Adding "jRadioButton4" on JFrame. 
    	        f11.add(jRadioButton2); 
    	  
    	        // Adding "jButton" on JFrame. 
    	        f11.add(jButton); 
    	  
    	        // Adding JLabel "L2" on JFrame. 
    	        f11.add(L1); 
    	  
    	        // Adding "jRadioButton1" and "jRadioButton3" in a Button Group "G2". 
    	        G1.add(jRadioButton1); 
    	        G1.add(jRadioButton2); 
    	        // Setting Bounds of JFrame. 
    	        f11.setBounds(100, 100, 400, 200); 
    	  
    	        // Setting Title of frame. 
    	        f11.setTitle("Student Form"); 
    	  
    	        // Setting Visible status of frame as true. 
    	        f11.setVisible(true); 
     		//signup to join the college and enter the details
    	        jButton.addActionListener(new ActionListener()
       		 {

					@Override
					public void actionPerformed(ActionEvent ae) {
    	        String choice = "";
    	        if(jRadioButton1.isSelected())
    	        	choice=jRadioButton1.getText() ;
    	        if(jRadioButton2.isSelected())
    	        	choice=jRadioButton2.getText() ;
    	        f11.dispose();
     		if(choice.equalsIgnoreCase("signup"))
     		{
     			Thread t= new Thread(new Runnable() { public void run() {
     				try {
     					stud.Signup();
     				} catch (IOException e) {
     					e.printStackTrace();
     				}
     			}});
     			t.start();
     			try {
					t.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
     		}
     		//logins to know their details
     		else if(choice.equalsIgnoreCase("login"))
     		{
     			HashMap<String, String[]> studDetails = new HashMap<>();
     			System.out.println("Enter your Roll number:");
     			String rollno = input.next();
     			System.out.println("Enter password:");
     			String password = input.next();
     			String str="";
     			BufferedReader f1 = null;
				try {
					f1 = new BufferedReader(new FileReader("E:/studentInfo.txt"));
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
     			String line;
     			//getting details of students from file to map
     			try {
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
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
     			int flag=0;
     			for(Map.Entry<String, String[]> info : studDetails.entrySet())
     			{
     				String rollNumber = info.getKey();
     				String[] str1 = info.getValue();
     				info.setValue(str1);
     				//checking if the roll number entered is present in the map
     				if(rollNumber.equals(rollno))
     				{
     					//if roll number matches then checking if the password entered matches with the password at the time of signup
     					if(password.equals(str1[0]))
     					{
     						//if password also matches then asks them what info they want
     						System.out.println("Welcome to College!!!......"+rollno);
     						System.out.println("Click- 1 to get your details\n       2 to know your fee payment status\n       3 to know your attendance\n       4 to know your grade\n       5 to get your friends list\n       6 to exit");
     						int option1= input.nextInt();
     						if(option1==6)
     						{
     							System.exit(0);
     						}
     						while(option1!=6)
     						{
     							try {
									stud.Login(option1,rollno);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
     							System.out.println("Click- 1 to get your details\n       2 to know your fee payment status\n       3 to know your attendance\n       4 to know your grade\n       5 to get your friends list\n       6 to exit");
     							option1= input.nextInt();
     						}
     						flag=1;
     						break;
     					}
     					else
     						System.out.println("Enter password properly:-)");
     				}
     			}
     			if(flag==0)
     			{
     				Details details = new Details();
     				details.anyException("Invalid Details");
     			}
     		} 
     		f11.dispose();
    		}
       		 });
    		}
	 }
	public static HashMap<String, Float> sortByValue(HashMap<String, Float> tm) 
    { 
        // Create a list from elements of HashMap 
        LinkedList<Map.Entry<String, Float> > list = 
               new LinkedList<Map.Entry<String, Float> >(tm.entrySet()); 
  
        // Sort the list 
        Collections.sort(list, new Comparator<Map.Entry<String, Float> >() { 
            public int compare(Map.Entry<String, Float> o1,  
                               Map.Entry<String, Float> o2) 
            { 
                return (o2.getValue()).compareTo(o1.getValue()); 
            }

        }); 
          
        // put data from sorted list to hashmap  
        HashMap<String, Float> temp = new LinkedHashMap<String, Float>(); 
        for (Map.Entry<String, Float> aa : list) { 
            temp.put(aa.getKey(), aa.getValue()); 
        } 
        return temp; 
    } 
	public static HashMap<String, Float> sortByValueAttendance(HashMap<String, Float> tm) 
    { 
        // Create a list from elements of HashMap 
        LinkedList<Map.Entry<String, Float> > list = 
               new LinkedList<Map.Entry<String, Float> >(tm.entrySet()); 
  
        // Sort the list 
        Collections.sort(list, new Comparator<Map.Entry<String, Float> >() { 
            public int compare(Map.Entry<String, Float> o1,  
                               Map.Entry<String, Float> o2) 
            { 
                return (o1.getValue()).compareTo(o2.getValue()); 
            }

        }); 
          
        // put data from sorted list to hashmap  
        HashMap<String, Float> temp = new LinkedHashMap<String, Float>(); 
        for (Map.Entry<String, Float> aa : list) { 
            temp.put(aa.getKey(), aa.getValue()); 
        } 
        return temp; 
    } 
	static void facultyChoice(int option, HashMap<String, String[]> studDetails)
	{
		HashMap<String, Float> tm= new HashMap<>();
		int i;
		switch(option)
		{
		case 1: //displaying attendance list of students in descending order
			for(Map.Entry<String, String[]> info : studDetails.entrySet())
			{
				String rollNumber = info.getKey();
				String[] str1 = info.getValue();
				info.setValue(str1);
				float num= Float.parseFloat(str1[3]);
				tm.put(rollNumber, num);
			}
			tm=sortByValueAttendance(tm);
			String data[][]= new String[tm.size()][2];
			i =0;
			for(Entry<String, Float> info : tm.entrySet())
			{
				data[i][0] = info.getKey();
				data[i][1] = info.getValue()+"";
				i++;
			}
			JFrame f = new JFrame("Attendance list");
			JButton button = new JButton("Click to Close!");
			String Column[]= {"Roll No","Attendance Percentage"};
			JTable jt = new JTable(data,Column);
			jt.setBounds(30, 40, 200, 300);
			JScrollPane sp = new JScrollPane(jt);
			f.add(sp);
			//f.add(button);
			/*f.setContentPane(button);
		      button.addActionListener(e -> {
		         f.dispose();
		      });
		      f.setPreferredSize(new Dimension(550, 300));
		      f.getContentPane().setBackground(Color.GRAY);*/
			f.setSize(300, 400);
			f.setVisible(true);
			break;
		case 2://displaying cgpa list of students in descending order
			for(Map.Entry<String, String[]> info : studDetails.entrySet())
			{
				String rollNumber = info.getKey();
				String[] str1 = info.getValue();
				info.setValue(str1);
				float num= Float.parseFloat(str1[2]);
				tm.put(rollNumber, num);
			}
			tm=sortByValue(tm);
			String data1[][]= new String[tm.size()][2];
			i =0;
			for(Entry<String, Float> info : tm.entrySet())
			{
				data1[i][0] = info.getKey();
				data1[i][1] = info.getValue()+"";
				i++;
			}
			JFrame f1 = new JFrame("CGPA list");
			String Column1[]= {"Roll No","CGPA"};
			JTable jt1 = new JTable(data1,Column1);
			jt1.setBounds(30, 40, 200, 300);
			JScrollPane sp1 = new JScrollPane(jt1);
			f1.add(sp1);
			f1.setSize(300, 400);
			f1.setVisible(true);
			break;
		case 3://displaying fee payment list of students in descending order
			for(Map.Entry<String, String[]> info : studDetails.entrySet())
			{
				String rollNumber = info.getKey();
				String[] str1 = info.getValue();
				info.setValue(str1);
				float num= Float.parseFloat(str1[4]);
				tm.put(rollNumber, num);
			}
			tm=sortByValue(tm);
			String data11[][]= new String[tm.size()][2];
			i =0;
			for(Entry<String, Float> info : tm.entrySet())
			{
				data11[i][0] = info.getKey();
				data11[i][1] = info.getValue()+"";
				i++;
			}
			JFrame f11 = new JFrame("Fee payment list");
			String Column11[]= {"Roll No","Due Amount"};
			JTable jt11 = new JTable(data11,Column11);
			jt11.setBounds(30, 40, 200, 300);
			JScrollPane sp11 = new JScrollPane(jt11);
			f11.add(sp11);
			f11.setSize(300, 400);
			f11.setVisible(true);
			break;
		default: System.out.println("Invalid option");
				 break;
		}
	}
	public static void main(String[] args) throws InterruptedException, IOException {
            String user;
            SwingUtilities.invokeLater(new Runnable() {
            	 
                @Override
                public void run() {
                    new StudentsSignupLogin();
                }
            });
	}
}
