package com.GDSC.ConsumerOptimization.Service;

import com.GDSC.ConsumerOptimization.Entity.User.Roles;
import com.GDSC.ConsumerOptimization.Entity.User.User;
import com.GDSC.ConsumerOptimization.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    private Collection<GrantedAuthority> mapRolesToAuthorities(List<Roles> roles)
    {
        return roles.stream().
                map(role -> new SimpleGrantedAuthority(role.getRoles())).collect(Collectors.toList());
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user =  userRepo.findByUsername(username)
               .orElseThrow(() -> new UsernameNotFoundException("Username not found"));


       return new org.springframework.security.core.userdetails.
               User(user.getUsername(),user.getPassword(),mapRolesToAuthorities(user.getRoles()));
    }


}
