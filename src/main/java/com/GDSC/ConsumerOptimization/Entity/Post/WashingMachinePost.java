package com.GDSC.ConsumerOptimization.Entity.Post;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name="washing_machine_posts")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WashingMachinePost extends Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "pieceNumberPerWashing")
    int pieceNumberPerWashing;
    @Column(name = "degree")
    int degree;
    @Column(name = "weeklyFrequency")
    int weeklyFrequency;
    @Column(name = "detergentType")
    String detergentType;
    @Column(name = "avgDetergentMl")
    String avgDetergentMl;
    @Column(name = "detergentBrand")
    String detergentBrand;
    @Column(name = "fabricSoftenerUsage")
    String fabricSoftenerUsage;
    @Column(name = "fabricSoftenerMl")
    String fabricSoftenerMl;
    @Column(name = "washingMachineBrand")
    String washingMachineBrand;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public int getPieceNumberPerWashing() {
        return pieceNumberPerWashing;
    }

    public void setPieceNumberPerWashing(int pieceNumberPerWashing) {
        this.pieceNumberPerWashing = pieceNumberPerWashing;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public int getWeeklyFrequency() {
        return weeklyFrequency;
    }

    public void setWeeklyFrequency(int weeklyFrequency) {
        this.weeklyFrequency = weeklyFrequency;
    }

    public String getDetergentType() {
        return detergentType;
    }

    public void setDetergentType(String detergentType) {
        this.detergentType = detergentType;
    }

    public String getAvgDetergentMl() {
        return avgDetergentMl;
    }

    public void setAvgDetergentMl(String avgDetergentMl) {
        this.avgDetergentMl = avgDetergentMl;
    }

    public String getDetergentBrand() {
        return detergentBrand;
    }

    public void setDetergentBrand(String detergentBrand) {
        this.detergentBrand = detergentBrand;
    }

    public String getFabricSoftenerUsage() {
        return fabricSoftenerUsage;
    }

    public void setFabricSoftenerUsage(String fabricSoftenerUsage) {
        this.fabricSoftenerUsage = fabricSoftenerUsage;
    }

    public String getFabricSoftenerMl() {
        return fabricSoftenerMl;
    }

    public void setFabricSoftenerMl(String fabricSoftenerMl) {
        this.fabricSoftenerMl = fabricSoftenerMl;
    }

    public String getWashingMachineBrand() {
        return washingMachineBrand;
    }

    public void setWashingMachineBrand(String washingMachineBrand) {
        this.washingMachineBrand = washingMachineBrand;
    }

    @Override
    public String toString() {
        return "WashingMachinePost{" +
                "id=" + id +
                ", pieceNumberPerWashing=" + pieceNumberPerWashing +
                ", degree=" + degree +
                ", weeklyFrequency=" + weeklyFrequency +
                ", detergentType='" + detergentType + '\'' +
                ", avgDetergentMl='" + avgDetergentMl + '\'' +
                ", detergentBrand='" + detergentBrand + '\'' +
                ", fabricSoftenerUsage='" + fabricSoftenerUsage + '\'' +
                ", fabricSoftenerMl='" + fabricSoftenerMl + '\'' +
                ", washingMachineBrand='" + washingMachineBrand + '\'' +
                ", id=" + id +
                ", explanation='" + explanation + '\'' +
                ", category='" + category + '\'' +
                ", time=" + time +
                ", likeCount=" + likeCount +
                ", userInfo=" + userInfo +
                '}';
    }
}
