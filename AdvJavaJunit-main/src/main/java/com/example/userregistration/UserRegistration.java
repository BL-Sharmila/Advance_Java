package com.example.userregistration;

import java.util.regex.Pattern;

public class UserRegistration {
    // Regex Patterns
    private static final String NAME_PATTERN = "^[A-Z][a-zA-Z]{2,}$";
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9]+([._%+-]?[a-zA-Z0-9]+)*@[a-zA-Z0-9]+(\\.[a-zA-Z]{2,})+$";
    private static final String MOBILE_PATTERN = "^[0-9]{2}\\s[0-9]{10}$";
    private static final String PASSWORD_PATTERN = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=]).{8,}$";

    public boolean validateFirstName(String firstName) {
        return Pattern.matches(NAME_PATTERN, firstName);
    }

    public boolean validateLastName(String lastName) {
        return Pattern.matches(NAME_PATTERN, lastName);
    }

    public boolean validateEmail(String email) {
        return Pattern.matches(EMAIL_PATTERN, email);
    }

    public boolean validateMobile(String mobile) {
        return Pattern.matches(MOBILE_PATTERN, mobile);
    }

    public boolean validatePassword(String password) {
        return Pattern.matches(PASSWORD_PATTERN, password);
    }
}
