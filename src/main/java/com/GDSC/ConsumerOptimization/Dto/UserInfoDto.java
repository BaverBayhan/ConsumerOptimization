package com.GDSC.ConsumerOptimization.Dto;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class UserInfoDto {
    private String city;
    private String memberNumberInHome;
    private String job;
    private int annualSalary;
    private String civilStatus;

}
