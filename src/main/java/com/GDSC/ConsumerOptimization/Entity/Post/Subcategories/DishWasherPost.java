package com.GDSC.ConsumerOptimization.Entity.Post.Subcategories;

import com.GDSC.ConsumerOptimization.Entity.Post.Post;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "DishWasherPost")
public class DishWasherPost extends Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String byHandOrMachine;
    @Column
    private String averagePerWeek;
    @Column
    private String solidityRatio;
    @Column
    private String detergentBrand;
    @Column
    private String dishWasherBrand;
    @Column
    private String rinseAidUsage;
    @Column
    private String brandOfRinseAid;

    public DishWasherPost() {}
    public DishWasherPost(String byHandOrMachine, String averagePerWeek, String solidityRatio, String detergentBrand, String dishWasherBrand, String rinseAidUsage, String brandOfRinseAid) {
        this.byHandOrMachine = byHandOrMachine;
        this.averagePerWeek = averagePerWeek;
        this.solidityRatio = solidityRatio;
        this.detergentBrand = detergentBrand;
        this.dishWasherBrand = dishWasherBrand;
        this.rinseAidUsage = rinseAidUsage;
        this.brandOfRinseAid = brandOfRinseAid;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getByHandOrMachine() {
        return byHandOrMachine;
    }

    public void setByHandOrMachine(String byHandOrMachine) {
        this.byHandOrMachine = byHandOrMachine;
    }

    public String getAveragePerWeek() {
        return averagePerWeek;
    }

    public void setAveragePerWeek(String averagePerWeek) {
        this.averagePerWeek = averagePerWeek;
    }

    public String getSolidityRatio() {
        return solidityRatio;
    }

    public void setSolidityRatio(String solidityRatio) {
        this.solidityRatio = solidityRatio;
    }

    public String getDetergentBrand() {
        return detergentBrand;
    }

    public void setDetergentBrand(String detergentBrand) {
        this.detergentBrand = detergentBrand;
    }

    public String getDishWasherBrand() {
        return dishWasherBrand;
    }

    public void setDishWasherBrand(String dishWasherBrand) {
        this.dishWasherBrand = dishWasherBrand;
    }

    public String getRinseAidUsage() {
        return rinseAidUsage;
    }
    public void setRinseAidUsage(String rinseAidUsage) {
        this.rinseAidUsage = rinseAidUsage;
    }

    public String getBrandOfRinseAid() {
        return brandOfRinseAid;
    }

    public void setBrandOfRinseAid(String brandOfRinseAid) {
        this.brandOfRinseAid = brandOfRinseAid;
    }

    @Override
    public String toString() {
        return "DishWasherPost{" +
                "id=" + id +
                ", byHandOrMachine='" + byHandOrMachine + '\'' +
                ", averagePerWeek='" + averagePerWeek + '\'' +
                ", solidityRatio='" + solidityRatio + '\'' +
                ", detergentBrand='" + detergentBrand + '\'' +
                ", dishWasherBrand='" + dishWasherBrand + '\'' +
                ", rinseAidUsage='" + rinseAidUsage + '\'' +
                ", brandOfRinseAid='" + brandOfRinseAid + '\'' +
                '}';
    }
}
