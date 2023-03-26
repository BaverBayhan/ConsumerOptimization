package com.GDSC.ConsumerOptimization.Entity.Post.Subcategories;

import com.GDSC.ConsumerOptimization.Entity.Post.Post;
import jakarta.persistence.*;

@Entity
@Table(name = "kitchenPost")
public class KitchenPost extends Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String cookAveragePerWeek;
    @Column
    private String ovenUsagePerWeek;
    @Column
    private String stoveUsagePerWeek;
    @Column
    private String brandOfOven;
    @Column
    private String brandOfRefrigerator;

    public KitchenPost() {
    }

    public KitchenPost(String cookAveragePerWeek, String ovenUsagePerWeek, String stoveUsagePerWeek, String brandOfOven, String brandOfRefrigerator) {
        this.cookAveragePerWeek = cookAveragePerWeek;
        this.ovenUsagePerWeek = ovenUsagePerWeek;
        this.stoveUsagePerWeek = stoveUsagePerWeek;
        this.brandOfOven = brandOfOven;
        this.brandOfRefrigerator = brandOfRefrigerator;
    }

    public Long getId() {
        return id;
    }
    public String getCookAveragePerWeek() {
        return cookAveragePerWeek;
    }

    public void setCookAveragePerWeek(String cookAveragePerWeek) {
        this.cookAveragePerWeek = cookAveragePerWeek;
    }

    public String getOvenUsagePerWeek() {
        return ovenUsagePerWeek;
    }

    public void setOvenUsagePerWeek(String ovenUsagePerWeek) {
        this.ovenUsagePerWeek = ovenUsagePerWeek;
    }

    public String getStoveUsagePerWeek() {
        return stoveUsagePerWeek;
    }

    public void setStoveUsagePerWeek(String stoveUsagePerWeek) {
        this.stoveUsagePerWeek = stoveUsagePerWeek;
    }

    public String getBrandOfOven() {
        return brandOfOven;
    }

    public void setBrandOfOven(String brandOfOven) {
        this.brandOfOven = brandOfOven;
    }

    public String getBrandOfRefrigerator() {
        return brandOfRefrigerator;
    }

    public void setBrandOfRefrigerator(String brandOfRefrigerator) {
        this.brandOfRefrigerator = brandOfRefrigerator;
    }

    @Override
    public String toString() {
        return "KitchenPost{" +
                "id=" + id +
                ", cookAveragePerWeek='" + cookAveragePerWeek + '\'' +
                ", ovenUsagePerWeek='" + ovenUsagePerWeek + '\'' +
                ", stoveUsagePerWeek='" + stoveUsagePerWeek + '\'' +
                ", brandOfOven='" + brandOfOven + '\'' +
                ", brandOfRefrigerator='" + brandOfRefrigerator + '\'' +
                '}';
    }
}
