package com.revature.util;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class MailUtil {
    public static void send(final String from,final String password,String to,String sub,String msg){
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465"); // 587
        props.put("mail.smtp.socketFactory.class",
                  "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
        	protected PasswordAuthentication getPasswordAuthentication() {
        		return new PasswordAuthentication(from,password);
        	}
        });

        try {
			MimeMessage message = new MimeMessage(session);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(sub);
			message.setText(msg);
			
			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
// MailUtil.send("from@gmail.com","xxxxx","to@gmail.com","hello javatpoint","How r u?");  

