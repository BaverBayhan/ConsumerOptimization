package com.GDSC.ConsumerOptimization.Exception;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(String email)
    {
        System.out.printf("User with e-mail %s is not authenticated or does not exist%n",email);
    }
}
