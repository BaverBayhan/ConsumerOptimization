package com.GDSC.ConsumerOptimization.Exception;

public class UserInfoNotFoundException extends RuntimeException{
    public UserInfoNotFoundException(String username)
    {
        System.out.printf("UserInfo with username %s is not authenticated or does not exist%n",username);
    }
}
