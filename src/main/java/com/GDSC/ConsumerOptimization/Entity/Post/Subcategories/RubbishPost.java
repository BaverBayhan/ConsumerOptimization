package com.GDSC.ConsumerOptimization.Entity.Post.Subcategories;


import com.GDSC.ConsumerOptimization.Entity.Post.Post;
import jakarta.persistence.*;
import org.springframework.stereotype.Service;

@Entity
@Table(name = "rubbishPost")
public class RubbishPost extends Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String garbageBagCountPerWeek;
    @Column
    private String recyclingOrNot;
    @Column
    private String recyclingBagsAmountPerWeek;

    public RubbishPost() {
    }

    public RubbishPost(String garbageBagCountPerWeek, String recyclingOrNot, String recyclingBagsAmountPerWeek) {
        this.garbageBagCountPerWeek = garbageBagCountPerWeek;
        this.recyclingOrNot = recyclingOrNot;
        this.recyclingBagsAmountPerWeek = recyclingBagsAmountPerWeek;
    }

    public Long getId() {
        return id;
    }


    public String getGarbageBagCountPerWeek() {
        return garbageBagCountPerWeek;
    }

    public void setGarbageBagCountPerWeek(String garbageBagCountPerWeek) {
        this.garbageBagCountPerWeek = garbageBagCountPerWeek;
    }

    public String getRecyclingOrNot() {
        return recyclingOrNot;
    }

    public void setRecyclingOrNot(String recyclingOrNot) {
        this.recyclingOrNot = recyclingOrNot;
    }

    public String getRecyclingBagsAmountPerWeek() {
        return recyclingBagsAmountPerWeek;
    }

    public void setRecyclingBagsAmountPerWeek(String recyclingBagsAmountPerWeek) {
        this.recyclingBagsAmountPerWeek = recyclingBagsAmountPerWeek;
    }

    @Override
    public String toString() {
        return "RubbishPost{" +
                "id=" + id +
                ", garbageBagCountPerWeek='" + garbageBagCountPerWeek + '\'' +
                ", recyclingOrNot='" + recyclingOrNot + '\'' +
                ", recyclingBagsAmountPerWeek='" + recyclingBagsAmountPerWeek + '\'' +
                '}';
    }
}
