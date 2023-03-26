package com.GDSC.ConsumerOptimization.Entity.Post.Subcategories;

import com.GDSC.ConsumerOptimization.Entity.Post.Post;
import jakarta.persistence.*;

@Entity
@Table(name = "personalHygienePost")
public class PersonalHygienePost extends Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String averageShowerTimePerWeek;
    @Column
    private String shampooConsumptionPerMonth;
    @Column
    private String showerGelUsage;
    @Column
    private String teethBrushPerDay;
    @Column
    private String careProductsUsagePerDay;


    public PersonalHygienePost() {
    }

    public PersonalHygienePost(Long id, String averageShowerTimePerWeek, String shampooConsumptionPerMonth, String teethBrushPerDay, String showerGelUsage, String careProductsUsagePerDay) {
        this.id = id;
        this.averageShowerTimePerWeek = averageShowerTimePerWeek;
        this.shampooConsumptionPerMonth = shampooConsumptionPerMonth;
        this.teethBrushPerDay = teethBrushPerDay;
        this.showerGelUsage = showerGelUsage;
        this.careProductsUsagePerDay = careProductsUsagePerDay;
    }

    public Long getId() {
        return id;
    }


    public String getAverageShowerTimePerWeek() {
        return averageShowerTimePerWeek;
    }

    public void setAverageShowerTimePerWeek(String averageShowerTimePerWeek) {
        this.averageShowerTimePerWeek = averageShowerTimePerWeek;
    }

    public String getShampooConsumptionPerMonth() {
        return shampooConsumptionPerMonth;
    }

    public void setShampooConsumptionPerMonth(String shampooConsumptionPerMonth) {
        this.shampooConsumptionPerMonth = shampooConsumptionPerMonth;
    }

    public String getTeethBrushPerDay() {
        return teethBrushPerDay;
    }

    public void setTeethBrushPerDay(String teethBrushPerDay) {
        this.teethBrushPerDay = teethBrushPerDay;
    }

    public String getShowerGelUsage() {
        return showerGelUsage;
    }

    public void setShowerGelUsage(String showerGelUsage) {
        this.showerGelUsage = showerGelUsage;
    }

    public String getCareProductsUsagePerDay() {
        return careProductsUsagePerDay;
    }

    public void setCareProductsUsagePerDay(String careProductsUsagePerDay) {
        this.careProductsUsagePerDay = careProductsUsagePerDay;
    }
}

