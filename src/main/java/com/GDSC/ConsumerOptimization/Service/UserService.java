package com.GDSC.ConsumerOptimization.Service;

import com.GDSC.ConsumerOptimization.Entity.User.User;

import java.util.Optional;

public interface UserService {

    void saveUser(User user);

    void deleteUser(User user);
}
