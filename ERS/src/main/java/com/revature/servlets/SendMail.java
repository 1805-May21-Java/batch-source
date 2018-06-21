package com.revature.servlets;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//first from, to, subject, & text values are set

public class SendMail {
    private String from;
    private String to;
    private String subject;
    private String text;
    private String password;

    //other functions can make a send mail class
    public SendMail(String from, String password, String to, String subject, String text) {
        this.from = from;
        this.password = password;
        this.to = to;
        this.subject = subject;
        this.text = text;
    }

    // send method is called in the end
    public void send() throws MessagingException { 
    	 Properties props = new Properties();    
    	 //set the properties to gmail, and fort to 587
         props.put("mail.smtp.host", "smtp.gmail.com");    
         props.put("mail.smtp.socketFactory.port", "587");    
         props.put("mail.smtp.socketFactory.class",    
                   "javax.net.ssl.SSLSocketFactory");    
         props.put("mail.smtp.auth", "true");    
         props.put("mail.smtp.port", "587");
         props.put("mail.smtp.starttls.enable", "true");

         Session session = Session.getDefaultInstance(props, 
        		 new javax.mail.Authenticator() {    
             protected PasswordAuthentication getPasswordAuthentication() {    
             return new PasswordAuthentication(from,password);  
             }    
            }); 
    	 InternetAddress fromAddress = null;
    	 InternetAddress toAddress = null;
    	 Transport transport = session.getTransport("smtp");
    	 transport.connect();
    try {
    	//get the necessary message for send function to work from the input
    	//set the input from sendemail class that been created
        Message simpleMessage = new MimeMessage(session);
        fromAddress = new InternetAddress(from);
        toAddress = new InternetAddress(to);
        simpleMessage.setFrom(fromAddress);
        simpleMessage.setRecipient(RecipientType.TO, toAddress);
        simpleMessage.setSubject(subject);
        simpleMessage.setText(text);
        transport.sendMessage(simpleMessage,
                simpleMessage.getAllRecipients());
    } catch (MessagingException e) {
        e.printStackTrace();
    } finally {
        transport.close();
    }
     }
 }