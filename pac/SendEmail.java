package pacProject.;
import java.io.*;
import java.util.HashMap;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
public class SendEmail {
     String path="";
     String email="";
     String rollno="";
     HashMap<String, String[]> studDetails;
    public SendEmail(String rollno,String path, String email) throws Exception {
        // TODO Auto-generated constructor stub
        this.path=path;
        this.email=email;
        this.rollno=rollno;
    }
    
	void send_mail()
    {
        // authentication info
        final String username  = "meghana3812";
        final String password = "Meghana@12345";
        String fromEmail = "meghana3812@gmail.com";
        String toEmail = email;
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username , password);
            }
        });
        // Start our mail message
        MimeMessage msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress(fromEmail));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            msg.setSubject("Welcome to College!  "+rollno);
            Multipart emailContent = new MimeMultipart();
            // Text body part
            MimeBodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setText("Your Details:");
            // Attachment body part.
            MimeBodyPart pdfAttachment = new MimeBodyPart();
            pdfAttachment.attachFile(path);
            // Attach body parts
            emailContent.addBodyPart(textBodyPart);
            emailContent.addBodyPart(pdfAttachment);
            // Attach multipart to message
            msg.setContent(emailContent);
            Transport.send(msg);
            System.out.println("Sent mail!!!");
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
