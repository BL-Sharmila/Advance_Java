package com.example.userregistration;
import java.util.function.Predicate;

import java.util.regex.Pattern;

@FunctionalInterface
interface UserValidation {
    boolean validate(String input) throws InvalidUserDetailException;
}

public class UserRegistration {
	 // ===== Regex Patterns (single source of truth) =====
    private static final String NAME_REGEX =
            "^[A-Z][a-zA-Z]{2,}$"; // UC1, UC2: Capital first letter, min length 3
    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9]+([._+-]?[a-zA-Z0-9]+)*@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}(\\.[a-zA-Z]{2,})?$"; // UC3
    private static final String MOBILE_REGEX =
            "^[0-9]{2}\\s[0-9]{10}$"; // UC4: CC<space>10 digits
    // UC5–UC8 combined: >=8 chars, 1 uppercase, 1 digit, 1 special
    private static final String PASSWORD_REGEX =
            "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*]).{8,}$";

    // ===== UC13: Lambda Validators =====
    public static final Predicate<String> FIRST_NAME_VALIDATOR = s -> s != null && s.matches(NAME_REGEX);
    public static final Predicate<String> LAST_NAME_VALIDATOR  = s -> s != null && s.matches(NAME_REGEX);
    public static final Predicate<String> EMAIL_VALIDATOR      = s -> s != null && s.matches(EMAIL_REGEX);
    public static final Predicate<String> MOBILE_VALIDATOR     = s -> s != null && s.matches(MOBILE_REGEX);
    public static final Predicate<String> PASSWORD_VALIDATOR   = s -> s != null && s.matches(PASSWORD_REGEX);

    // ===== UC12: Exception-throwing wrappers (kept for compatibility with earlier UCs) =====
    public boolean validateFirstName(String firstName) throws InvalidUserDetailException {
        if (!FIRST_NAME_VALIDATOR.test(firstName))
            throw new InvalidUserDetailException("Invalid First Name");
        return true;
    }

    public boolean validateLastName(String lastName) throws InvalidUserDetailException {
        if (!LAST_NAME_VALIDATOR.test(lastName))
            throw new InvalidUserDetailException("Invalid Last Name");
        return true;
    }

    public boolean validateEmail(String email) throws InvalidUserDetailException {
        if (!EMAIL_VALIDATOR.test(email))
            throw new InvalidUserDetailException("Invalid Email");
        return true;
    }

    public boolean validateMobile(String mobile) throws InvalidUserDetailException {
        if (!MOBILE_VALIDATOR.test(mobile))
            throw new InvalidUserDetailException("Invalid Mobile Number (expected: CC␠10digits)");
        return true;
    }

    public boolean validatePassword(String password) throws InvalidUserDetailException {
        if (!PASSWORD_VALIDATOR.test(password))
            throw new InvalidUserDetailException(
                "Invalid Password (min 8, ≥1 uppercase, ≥1 digit, ≥1 special !@#$%^&*)");
        return true;
    }

    // ===== UC9 helper: sample emails (optional utility) =====
    public boolean[] validateSampleEmails(String[] emails) {
        boolean[] results = new boolean[emails.length];
        for (int i = 0; i < emails.length; i++) {
            results[i] = EMAIL_VALIDATOR.test(emails[i]);
        }
        return results;
    }
}
