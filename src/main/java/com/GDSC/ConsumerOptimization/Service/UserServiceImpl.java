package com.GDSC.ConsumerOptimization.Service;

import com.GDSC.ConsumerOptimization.Entity.User.User;
import com.GDSC.ConsumerOptimization.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo repo;

    @Override
    public void saveUser(User user) {
        repo.save(user);
    }

    @Override
    public void deleteUser(User user) {
        repo.delete(user);
    }


}
