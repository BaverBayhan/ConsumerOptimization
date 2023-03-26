package com.GDSC.ConsumerOptimization.Controller;

import com.GDSC.ConsumerOptimization.Dto.UserInfoDto;
import com.GDSC.ConsumerOptimization.Entity.User.User;
import com.GDSC.ConsumerOptimization.Entity.User.UserInfo;
import com.GDSC.ConsumerOptimization.Repository.PostRepo;
import com.GDSC.ConsumerOptimization.Repository.UserinfoRepo;
import com.GDSC.ConsumerOptimization.Security.JwtGenerator;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/userinfo/")
public class UserInfoController {

    @Autowired
    private UserinfoRepo userinfoRepo;

    @Autowired
    private JwtGenerator generator;

    @PostMapping(path = "save")
    public ResponseEntity<String> saveUserInfo(@RequestHeader("Authorization") @NotNull String token,
                                               @RequestBody @NotNull UserInfoDto userInfoDto )
    {
        String username = generator.getUsernameFromJWT(token.substring(7));
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(username);
        userInfo.setSex(userInfoDto.getSex());
        userInfo.setCity(userInfoDto.getCity());
        userInfo.setJob(userInfoDto.getJob());
        userInfo.setAnnualSalary(userInfoDto.getAnnualSalary());
        userInfo.setAge(userInfoDto.getAge());
        userInfo.setCivilStatus(userInfoDto.getCivilStatus());
        userinfoRepo.save(userInfo);
        return new ResponseEntity<>("User info created successfully !", HttpStatus.CREATED);

    }



}
