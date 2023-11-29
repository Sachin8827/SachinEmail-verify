/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.emailgeneration;

/**
 *
 * @author hp
 */

import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;


/**
 *
 * @author hp
 */
public class GEMailSender {
    public boolean sendEmail(String to,String from,String subject,String text){
        boolean flag = false;
        
        Properties p = new Properties();
        p.put("mail.smtp.auth", true);
        p.put("mail.smtp.starttls.enable", true);
        p.put("mail.smtp.port", "587");
        p.put("mail.smtp.host", "smtp.gmail.com");
         String user = "sb360879@gmail.com";
         
         String password = "opurdrrhpkmiojtd";
        //session
        Session session = Session.getInstance(p,new jakarta.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(user,password);
        }
        
        });
        
        try{
            Message message = new MimeMessage(session);
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setFrom(new InternetAddress(from));
            message.setSubject(subject);
            message.setText(text);
            Transport.send(message);

            flag  = true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }
    public String generateRandomCode() {
        Random random = new Random();
        int code = 100000 + random.nextInt(900000); // Generates a random 6-digit code
        return String.valueOf(code);
    }
    public boolean verifyCode(String generatedCode) {
    Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the verification code sent to your email: ");
        String userEnteredCode = scanner.nextLine();
        if (generatedCode.equals(userEnteredCode)) {
            return true; 
        } else {
                return false;
        }   
}    
}

