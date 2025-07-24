package com.bridgelabz;

import java.util.regex.Pattern;

public class UserRegistration {

    // UC1: First Name - Start with Capital, min 3 chars
    public boolean isValidFirstName(String name) {
        return Pattern.matches("^[A-Z][a-zA-Z]{2,}$", name);
    }

    // UC2: Last Name - Same rule as First Name
    public boolean isValidLastName(String name) {
        return Pattern.matches("^[A-Z][a-zA-Z]{2,}$", name);
    }

    // UC3: Email Validation
    public boolean isValidEmail(String email) {
        return Pattern.matches("^[a-zA-Z0-9]+([._+-][a-zA-Z0-9]+)*@[a-zA-Z0-9]+(\\.[a-z]{2,}){1,2}$", email);
    }

    // UC4: Mobile Format - Country code + space + 10 digit
    public boolean isValidMobile(String mobile) {
        return Pattern.matches("^[0-9]{2}\\s[0-9]{10}$", mobile);
    }

    // UC5 to UC8: Password Rules
    // Rule1: Min 8 chars
    public boolean isValidPasswordRule1(String password) {
        return Pattern.matches("^.{8,}$", password);
    }

    // Rule2: At least 1 uppercase
    public boolean isValidPasswordRule2(String password) {
        return Pattern.matches("^(?=.*[A-Z]).{8,}$", password);
    }

    // Rule3: At least 1 number
    public boolean isValidPasswordRule3(String password) {
        return Pattern.matches("^(?=.*[A-Z])(?=.*\\d).{8,}$", password);
    }

    // Rule4: Exactly 1 special character
    public boolean isValidPasswordRule4(String password) {
        return Pattern.matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!])(?!.*[@#$%^&+=!].*[@#$%^&+=!]).{8,}$", password);
    }

    // UC9: Test All Email Samples (Valid + Invalid)
    public void testSampleEmails() {
        String[] validEmails = {
            "abc@yahoo.com", "abc-100@yahoo.com", "abc.100@yahoo.com",
            "abc111@abc.com", "abc-100@abc.net", "abc.100@abc.com.au",
            "abc@1.com", "abc@gmail.com.com", "abc+100@gmail.com"
        };

        String[] invalidEmails = {
            "abc", "abc@.com.my", "abc123@gmail.a", "abc123@.com", "abc123@.com.com",
            ".abc@abc.com", "abc()*@gmail.com", "abc@%*.com", "abc..2002@gmail.com",
            "abc.@gmail.com", "abc@abc@gmail.com", "abc@gmail.com.1a", "abc@gmail.com.aa.au"
        };

        System.out.println("\nValid Emails:");
        for (String email : validEmails) {
            System.out.println(email + " => " + isValidEmail(email));
        }

        System.out.println("\nInvalid Emails:");
        for (String email : invalidEmails) {
            System.out.println(email + " => " + isValidEmail(email));
        }
    }

    public static void main(String[] args) {
        UserRegistration user = new UserRegistration();

        System.out.println("First Name Valid: " + user.isValidFirstName("Sharmila"));
        System.out.println("Last Name Valid: " + user.isValidLastName("Ravi"));
        System.out.println("Email Valid: " + user.isValidEmail("abc.xyz@bl.co.in"));
        System.out.println("Mobile Valid: " + user.isValidMobile("91 9919819801"));

        System.out.println("Password Rule 1: " + user.isValidPasswordRule1("Password1@"));
        System.out.println("Password Rule 2: " + user.isValidPasswordRule2("Password1@"));
        System.out.println("Password Rule 3: " + user.isValidPasswordRule3("Password1@"));
        System.out.println("Password Rule 4: " + user.isValidPasswordRule4("Password1@"));

        user.testSampleEmails(); // UC9
    }
}
