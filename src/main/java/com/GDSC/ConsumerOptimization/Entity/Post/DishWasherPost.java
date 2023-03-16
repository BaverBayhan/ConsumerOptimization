package com.GDSC.ConsumerOptimization.Entity.Post;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "DishWasherPost")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DishWasherPost extends Post{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "dishWasherBrand")
    String dishWasherBrand;

    @Column(name = "dishSoapBrand")
    String dishSoapBrand;

    @Column(name = "timesPerWeek")
    int timesPerWeek;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDishWasherBrand() {
        return dishWasherBrand;
    }

    public void setDishWasherBrand(String dishWasherBrand) {
        this.dishWasherBrand = dishWasherBrand;
    }

    public String getDishSoapBrand() {
        return dishSoapBrand;
    }

    public void setDishSoapBrand(String dishSoapBrand) {
        this.dishSoapBrand = dishSoapBrand;
    }

    public int getTimesPerWeek() {
        return timesPerWeek;
    }

    public void setTimesPerWeek(int timesPerWeek) {
        this.timesPerWeek = timesPerWeek;
    }

    @Override
    public String toString() {
        return "DishWasherPost{" +
                "id=" + id +
                ", dishWasherBrand='" + dishWasherBrand + '\'' +
                ", dishSoapBrand='" + dishSoapBrand + '\'' +
                ", timesPerWeek=" + timesPerWeek +
                ", id=" + id +
                ", explanation='" + explanation + '\'' +
                ", category='" + category + '\'' +
                ", time=" + time +
                ", likeCount=" + likeCount +
                ", userInfo=" + userInfo +
                '}';
    }
}
