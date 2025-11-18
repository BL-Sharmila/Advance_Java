package com.example.userregistration;

import org.junit.Test;
import static org.junit.Assert.*;
public class UserRegistrationTest {
	
	 private final UserRegistration user = new UserRegistration();

	    // ===== UC10: Happy/Sad tests using exception-throwing wrappers =====

	    @Test
	    public void givenFirstName_WhenProper_ShouldReturnTrue() throws Exception {
	        assertTrue(user.validateFirstName("Kalki"));
	    }

	    @Test(expected = InvalidUserDetailException.class)
	    public void givenFirstName_WhenInvalid_ShouldThrow() throws Exception {
	        user.validateFirstName("ka"); // too short & not capitalized
	    }

	    @Test
	    public void givenLastName_WhenProper_ShouldReturnTrue() throws Exception {
	        assertTrue(user.validateLastName("Dhandapani"));
	    }

	    @Test(expected = InvalidUserDetailException.class)
	    public void givenEmail_WhenInvalid_ShouldThrow() throws Exception {
	        user.validateEmail("abc@.com");
	    }

	    @Test
	    public void givenMobile_WhenProper_ShouldReturnTrue() throws Exception {
	        assertTrue(user.validateMobile("91 9876543210"));
	    }

	    @Test(expected = InvalidUserDetailException.class)
	    public void givenMobile_WhenInvalid_ShouldThrow() throws Exception {
	        user.validateMobile("919876543210"); // missing space
	    }

	    @Test
	    public void givenPassword_WhenValid_ShouldReturnTrue() throws Exception {
	        assertTrue(user.validatePassword("Abc@1234"));
	    }

	    @Test(expected = InvalidUserDetailException.class)
	    public void givenPassword_WhenNoUppercase_ShouldThrow() throws Exception {
	        user.validatePassword("abc@1234");
	    }

	    // ===== UC13: Direct Lambda usage (no exceptions) =====

	    @Test
	    public void lambda_FirstNameValidator_True() {
	        assertTrue(UserRegistration.FIRST_NAME_VALIDATOR.test("John"));
	    }

	    @Test
	    public void lambda_FirstNameValidator_False() {
	        assertFalse(UserRegistration.FIRST_NAME_VALIDATOR.test("jo"));
	    }

}
