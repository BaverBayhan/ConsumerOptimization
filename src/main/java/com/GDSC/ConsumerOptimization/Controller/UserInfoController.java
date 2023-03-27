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

import java.util.Optional;

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
        userInfo.setMemberNumberInHome(userInfoDto.getMemberNumberInHome());
        userInfo.setCity(userInfoDto.getCity());
        userInfo.setJob(userInfoDto.getJob());
        userInfo.setAnnualSalary(userInfoDto.getAnnualSalary());
        userInfo.setCivilStatus(userInfoDto.getCivilStatus());
        userinfoRepo.save(userInfo);
        return new ResponseEntity<>("User info created successfully !", HttpStatus.CREATED);

    }

    @GetMapping(path = "retrieve")
    public ResponseEntity<UserInfoDto> getUserInfo(@RequestHeader("Authorization") @NotNull String token)
    {
        String username = generator.getUsernameFromJWT(token.substring(7));
        Optional<UserInfo> userInfo = userinfoRepo.findByUsername(username);
        UserInfoDto userInfoDto = new UserInfoDto();
        if(userInfo.isPresent())
        {
            userInfoDto.setCity(userInfo.get().getCity());
            userInfoDto.setJob(userInfo.get().getJob());
            userInfoDto.setAnnualSalary(userInfo.get().getAnnualSalary());
            userInfoDto.setMemberNumberInHome(userInfo.get().getMemberNumberInHome());
            userInfoDto.setCivilStatus(userInfo.get().getCivilStatus());
        }

        return new ResponseEntity<>(userInfoDto,HttpStatus.OK);
    }



}
