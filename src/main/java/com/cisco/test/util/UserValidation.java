package com.cisco.test.util;

import com.cisco.test.dto.User;
import com.cisco.test.excp.InvalidAgeException;
import com.cisco.test.excp.InvalidNameException;

public class UserValidation {
    public static void validateUser(User user) {
        validateUsername(user.getFirstName());
        validateUserAge(user.getAge());
    }

    public static void validateUsername(String userName) {
        if(userName == null || userName.length() <= 3) {
            throw new InvalidNameException("Invalid user name. Try again with a valid user name.");
        }
    }

    public static void validateUserAge(int age) {
        if(age <= 17) {
            throw new InvalidAgeException("Sorry. User should have at least 18 years old to login");
        }
    }
}
