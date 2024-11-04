/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.legalnod.serviceimpl;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailSending {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(EmailSending.class);
    private static final String SMTP_HOST_NAME = "mail.legalnod.com";
    private static final String SMTP_PORT = "25"; // default port is 465 !
    private static final String SMTP_AUTH_USER = "info@legalnod.com";
    private static final String SMTP_AUTH_PWD = "legalnod123*";    
    
    public void sendEmail(String email, String subject, String text,String type,String fromAdd) throws MessagingException,AddressException  {
    	LOGGER.debug("sendEmail...method");
        String[] emailList = new String[1];
        emailList[0] = email;
        sendEmail(emailList, subject, text,type,fromAdd);
        }

    ////Send to multiple recipients
    public void sendEmail(String[] emailList, String subject, String text,String type,String fromAdd) throws MessagingException,AddressException  {
    	LOGGER.debug("sendEmail multiple...method");
        boolean debug = true;
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true"); // added this line
        props.put("mail.smtp.host", SMTP_HOST_NAME);
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");
        props.put("mail.smtp.user", SMTP_AUTH_USER);
        props.put("mail.smtp.password", SMTP_AUTH_PWD);
        props.put("mail.smtp.port", SMTP_PORT );
        Authenticator auth = new SMTPAuthenticator();
        Session session = Session.getDefaultInstance(props, auth);
        session.setDebug(debug);
        Message msg = new MimeMessage(session);
        InternetAddress addressFrom = new InternetAddress(fromAdd);
        msg.setFrom(addressFrom);
        InternetAddress[] addressTo = new InternetAddress[emailList.length];
        for (int i = 0; i < emailList.length; i++){
    	addressTo[i] = new InternetAddress(emailList[i]);
    	}

        msg.setRecipients(Message.RecipientType.TO, addressTo);
        msg.setSubject(subject);
        msg.setContent(text, type);
        Transport transport = session.getTransport("smtp");
        transport.connect(SMTP_HOST_NAME, SMTP_AUTH_USER, SMTP_AUTH_PWD);
        transport.sendMessage(msg, msg.getAllRecipients());
        transport.close();
    }

    private class SMTPAuthenticator extends javax.mail.Authenticator {

        public PasswordAuthentication getPasswordAuthentication() {
            String username = SMTP_AUTH_USER;
            String password = SMTP_AUTH_PWD;
            return new PasswordAuthentication(username, password);
        }
    }

}
