package com.example.userregistration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class UserRegistrationTest {

    UserRegistration user = new UserRegistration();

    @Test
    public void givenFirstName_WhenProper_ShouldReturnTrue() {
        assertTrue(user.validateFirstName("John"));
    }

    @Test
    public void givenFirstName_WhenImproper_ShouldReturnFalse() {
        assertFalse(user.validateFirstName("jo"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc@gmail.com", "abc.xyz@bl.co.in"})
    public void givenValidEmails_ShouldReturnTrue(String email) {
        assertTrue(user.validateEmail(email));
    }

    @Test
    public void givenMobile_WhenProper_ShouldReturnTrue() {
        assertTrue(user.validateMobile("91 9876543210"));
    }

    @Test
    public void givenPassword_WhenProper_ShouldReturnTrue() {
        assertTrue(user.validatePassword("Abcd@1234"));
    }
}
