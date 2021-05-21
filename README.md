# StudentManagement
<h1>ABSTRACT</h1>
<h3>OBJECTIVE:</h3>
<h6>For Faculty:</h6>
Faculty can view the details of students regarding attendance, grade and fee payment.
<h6>For Students:</h6>
Students can join t5e college by entering their information and after which roll number of student will be generated.
Using this roll number the student can login and check his details like attendance, cgpa and fee payment status. We also modify student details based on present semester data entered by student.
Also giving alert to students based on their attendance, cgpa and fee payment status.
<h6>Working:</h6>
The code will first ask whether the qualification of the person is student or faculty. If faculty was selected then we ask for college password. If password entered was correct, we ask which list of student details does the faculty wants to see like- attendance, cgpa, fee payment lists which are sorted. If password entered was wrong the user can try again try enter correct password.
If qualification was Student , then we ask whether the student wants to login or signup. If signup was selected, we take student information like- mail id, phone number, name, password and branch code. Based 
on the year the student joined, we generate his roll number and display it on the screen and a mail will be sent to the student mail regarding student details. And if login was selected, we ask student to select suitable options like viewing his details and updating his/her details and giving the results and also sending mail if details are updated. We also alert the student if results were below the mark.
<h6>Concepts used:</h6>
Classes, Interfaces and abstract classes, Inheritance , Singleton class, Packages, access specifiers, String handling, Exception handling, Util and IO Packages, Regex expressions, UI and MVC(Swings) , Javax package  for sending mail.
<h6>Language used:</h6> Java language

<h1>INTRODUCTION</h1>
Now-a-days everyone are busy in their own lifestyles. To bring more efficiency, it’s essential to shift to the automation of tasks in this technological-driven world. This is where student record management system comes into picture.
Student record management system is designed to help manage daily college/school activities of recording and maintaining by automating it. It is also known as student information system or student record system.
<h6>Problem statement:</h6>
Develop a program in java using OOP concepts to built a simple software for student information (records) management system which can perform the following operations:
<h6>Operations:</h6>
<ol type="1">
  <li>Store the n student’s information (records).</li>
  <li>Store the name of the students, roll number which is unique for every student, fee paid by the students, cgpa of the students, attendance of the students.</li>
  <li>Sorting according to the attendance and displaying.</li>
  <li>Sorting according to cgpa and displaying.</li>
  <li>Sorting according to due amount and displaying.</li>
  <li>Modifying students details like cgpa, attendance, fees.</li>
  <li>Faculty login to view lists of details of student.</li>
 </ol>

<h1>Description:</h1>
<ul>
  <li>Separate classes are used for fee paid details, cgpa, attendance and details of students.</li>
  <li>The user can choose the operation from the list and as per the users request the details will be displayed.</li>
  <li>Faculty can access student’s details and check their results.</li>
</ul>

<h1>CONCLUSION</h1>
To conclude, the system is developed in such a way that the user with common knowledge of computers can handle it easily. The system developed is user friendly and efficient in achieving basic goals. It takes care of all the constrains which have specified in code. It is beneficial for the concerned aspects. Application developed is realistic and secure.
