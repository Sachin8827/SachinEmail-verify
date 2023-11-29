/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.emailgeneration;

/**
 *
 * @author hp
 */
public class EmailGeneration {

    public static void main(String[] args) {
         GEMailSender gm = new GEMailSender();
        String otp = gm.generateRandomCode();
        String to = "abhishekh0456@gmail.com";
        String from = "sb360879@gmail.com";
        String subject = "This is email using java";
        String text = "Your verification code is: " + otp +"\n ab tumhare account me 50000 rupeee me kaat lunga";
        
        
        boolean b = gm.sendEmail(to, from, subject, text);
        if (b) {
            
             boolean otpResult = gm.verifyCode(otp);
            if (otpResult) {
                System.out.println("Verification successful.");
            } else {
                System.out.println("Verification failed.");
            }
        }
        else{
            System.out.println("failed");
        }
    
    }
}
