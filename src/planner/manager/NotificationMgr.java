package planner.manager;


import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
 

import planner.model.Student;


public class NotificationMgr {
	
	/*public static void main (String[] args)
	{
		sendEmail(null);
	}*/

	/**
	 * Send both email and SMS for wait list notification
	 * @param studentToNotify
	 */
	public static void sendBoth (Student studentToNotify)
	{
		sendEmail(studentToNotify);
	    sendSMS(studentToNotify);
	}
	
	/**
	 * Send email for wait list notification
	 * @param studentToNotify
	 */

	public static void sendEmail(Student studentToNotify)
	{
		//String email = studentToNotify.getEmail();
		String email = "htet004@e.ntu.edu.sg";
		
		Properties props = new Properties();
	    props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		
		
		Authenticator auth = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				//email and password of smtp server
				return new PasswordAuthentication("cz2002.fsp2.group5@gmail.com","cz2002@fsp2group5");
			}
		};

	    Session session = Session.getDefaultInstance(props, auth);
	    
	    try {
	        MimeMessage msg = new MimeMessage(session);
	        msg.setFrom("cz2002.fsp2.group5@gmail.com");
	        msg.setRecipients(Message.RecipientType.TO,email);
	        msg.setSubject("Waitlist Notification");
	        msg.setText("You have been registered to <Course code>");
	        Transport.send(msg);
	    } catch (MessagingException mex) {
	        System.out.println("send failed, exception: " + mex);
	    }
	}
	
	
	/**
	 * Send SMS for wait list notification
	 * @param studentToNotify
	 */

	
	public static void sendSMS(Student studentToNotify)
	{
		int mobileNo = studentToNotify.getMobileNo();
		System.out.println("A SMS is sent to" + mobileNo);
	}
}