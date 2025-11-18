package com.example.userregistration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class EmailParameterizedTest {

	@Parameterized.Parameters(name = "{index}: {0} => {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {"abc@bl.co", true},
            {"abc.xyz@bl.co.in", true},
            {"abc-100@abc.net", true},
            {"abc111@abc.com", true},
            {"abc@.com", false},
            {"abc..2002@gmail.com", false},
            {"abc@%*.com", false},
            {"abc@gmail.com.1a", false}
        });
    }

    private final String email;
    private final boolean expected;

    public EmailParameterizedTest(String email, boolean expected) {
        this.email = email;
        this.expected = expected;
    }

    @Test
    public void validateEmails_WithLambda() {
        assertEquals(expected, UserRegistration.EMAIL_VALIDATOR.test(email));
    }
}

